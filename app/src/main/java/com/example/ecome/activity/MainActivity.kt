package com.example.ecome.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.example.ecome.R
import com.example.ecome.adapter.CategoryAdapter
import com.example.ecome.adapter.ProductAdapter
import com.example.ecome.data.model.CategoryModel
import com.example.ecome.data.model.ICategory
import com.example.ecome.data.model.IProduct
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.data.vos.ProductVO

class MainActivity : BaseActivity() {

    lateinit var categoryRecyclerView: RecyclerView
    lateinit var productRecyclerView: RecyclerView
    lateinit var categoryModel: CategoryModel
    lateinit var productModel: ProductModel
    lateinit var categoryAdapter: CategoryAdapter
    lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toolbar = findViewById<Toolbar> (R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setTitle("Eco Me")


        //For category list
        categoryRecyclerView = findViewById(R.id.rv_category)
        var layoutManager: LinearLayoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView.layoutManager = layoutManager
        categoryAdapter = CategoryAdapter(context = applicationContext)
        categoryRecyclerView.adapter = categoryAdapter

        //For product list
        productRecyclerView = findViewById(R.id.rv_product)
        var productlayoutManger: GridLayoutManager = GridLayoutManager(applicationContext, 2)
        productRecyclerView.layoutManager = productlayoutManger
        productAdapter = ProductAdapter(applicationContext)
        productRecyclerView.adapter = productAdapter

        categoryModel = CategoryModel.getInstance()
        var categoryFromDb : MutableList<CategoryVO> = categoryModel.getCategoryList(object : ICategory.CategoryResult {
            override fun onError(message: String) {

            }

            override fun onSuccess(categories: MutableList<CategoryVO>) {
                val categoryResult = categories
                categoryAdapter.setNewData(categoryResult)
            }
        })


        productModel = ProductModel.getInstance()
        var products : MutableList<ProductVO> = productModel.getProducts(object : IProduct.ProductDelegate {
            override fun onSuccess(products: MutableList<ProductVO>) {
                var products = products
                productAdapter.setNewData(products)
            }

            override fun onError(message: String) {

            }
        })


    }
}
