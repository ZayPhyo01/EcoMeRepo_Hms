package com.example.ecome.activity

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.ecome.R
import com.example.ecome.adapter.CategoryAdapter
import com.example.ecome.adapter.ProductAdapter
import com.example.ecome.data.model.CategoryModel
import com.example.ecome.data.model.ImplCategory
import com.example.ecome.data.model.ImplProduct
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.onTapItemDelegate
import com.example.ecome.util.AppUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), onTapItemDelegate {


    override fun onTapProductID(productId: Int) {
        var intent = DetailtActivity.newIntent(applicationContext)
        intent.putExtra(AppUtils.PRODUCT_ID,productId)
        startActivity(intent)    }

    lateinit var productRecyclerView: RecyclerView
    lateinit var categoryModel: CategoryModel
    lateinit var productModel: ProductModel
    lateinit var categoryAdapter: CategoryAdapter
    lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toolbar = toolbar
        setSupportActionBar(toolbar)
        toolbar.setTitle("Ecommerce App")


        //For category list
        var layoutManager: LinearLayoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        rv_category.layoutManager = layoutManager
        categoryAdapter = CategoryAdapter(context = applicationContext)
        rv_category.adapter = categoryAdapter

        //For product list
        productRecyclerView = rv_product
        var productlayoutManger: GridLayoutManager = GridLayoutManager(applicationContext, 2)
        productRecyclerView.layoutManager = productlayoutManger
        productAdapter = ProductAdapter(applicationContext)
        productRecyclerView.adapter = productAdapter

        categoryModel = CategoryModel.getInstance()
        var categoryFromDb : MutableList<CategoryVO> = categoryModel.getCategoryList(object : ImplCategory.CategoryResult {
            override fun onError(message: String) {

            }

            override fun onSuccess(categories: MutableList<CategoryVO>) {
                val categoryResult = categories
                categoryAdapter.setNewData(categoryResult)
            }
        })




        productModel = ProductModel.getInstance()
        var products : MutableList<ProductVO> = productModel.getProducts(object : ImplProduct.ProductDelegate {
            override fun onSuccess(products: MutableList<ProductVO>) {
                var products = products
                productAdapter.setNewData(products)
            }

            override fun onError(message: String) {

            }
        })

        if (!productModel.isEmpty()) {
            productAdapter.setNewData(products)
        }

    }
}
