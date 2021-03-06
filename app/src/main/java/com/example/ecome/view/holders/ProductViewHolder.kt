package com.example.ecome.view.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.ecome.R
import com.example.ecome.data.vos.ProductVO
import kotlinx.android.synthetic.main.item_view_product.view.*

class ProductViewHolder(view: View) : BaseViewHolder<ProductVO>(view) {

    lateinit var productImage: ImageView
    lateinit var productName: TextView
    lateinit var productPrice: TextView

    init {
        productPrice = itemView.tv_product_price
        productName = itemView.tv_product_name
        productImage = itemView.imv_product
    }


    override fun bind(bindData: ProductVO) {
        var imageUrl = bindData.product_image_url!![0].image_url
        Glide.with(itemView.context)
            .load(imageUrl)
            .into(productImage)
        productName.setText(bindData.product_name)
        productPrice.setText(bindData.product_price.toString())
    }

    override fun onClick(v: View?) {

           }
}