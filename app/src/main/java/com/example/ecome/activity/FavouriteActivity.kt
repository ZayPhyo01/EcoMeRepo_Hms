package com.example.ecome.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.ecome.R
import com.example.ecome.adapter.FavouriteAdapter
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.util.AppUtils
import kotlinx.android.synthetic.main.activity_favourite.*
import kotlinx.android.synthetic.main.detail_product_activity.*
import kotlinx.android.synthetic.main.item_view_product.*

class FavouriteActivity :BaseActivity (){


    // To Change
    lateinit var productName : TextView
    lateinit var productPrice : TextView
    lateinit var productDesc : TextView
    lateinit var productImage: ImageView
    lateinit var productModel : ProductModel
    lateinit var favouriteAdapter: FavouriteAdapter

    companion object {

        public fun newIntent (context : Context): Intent {
            var intent = Intent(context,FavouriteActivity::class.java)
            return intent
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)

        productModel = ProductModel
        productName = tv_product_name
        productDesc = tv_detail_product_desc
        productImage = imv_product
        productPrice = tv_product_price



        var staggeredGridLayoutManager : StaggeredGridLayoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvFavourite.layoutManager = staggeredGridLayoutManager
        favouriteAdapter = FavouriteAdapter(applicationContext)
        rvFavourite.adapter = favouriteAdapter

        //favouriteAdapter.setNewData(productModel.getFavouriteByProduct())




    }
}