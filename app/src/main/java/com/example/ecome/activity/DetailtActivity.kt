package com.example.ecome.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.ecome.R
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.util.AppUtils
import kotlinx.android.synthetic.main.detail_product_activity.*
import org.w3c.dom.Text

class DetailtActivity : BaseActivity() {


    lateinit var productName: TextView
    lateinit var productPrice: TextView
    lateinit var productImage: ImageView
    lateinit var productDesc: TextView
    lateinit var productModel: ProductModel

  /*
    init {
        productName = t
    }
*/

    companion object {

        public fun newIntent (context : Context): Intent{
            var intent = Intent(context,DetailtActivity::class.java)
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_product_activity)

        productModel = ProductModel.getInstance()
        productDesc = tv_detail_product_desc
        productName = tv_detail_product_name
        productPrice = tv_detail_product_price
        productImage = iv_detail_product


       val productId : Int = intent.getIntExtra(AppUtils.PRODUCT_ID, -1)
        var productVo: ProductVO = productModel.getProductsById(productId)
        productDesc.setText(productVo.product_desc)
        productPrice.setText(productVo.product_price)
        productName.setText(productVo.product_name)
        var imageUrl = productVo.product_image_url

        if (imageUrl!!.size > 0)
            Glide.with(applicationContext)
                .load(imageUrl[0].image_url)
                .into(productImage)




    }
}