package com.example.ecome.adapter

import android.content.Context
import android.view.ViewGroup
import com.example.ecome.R
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.view.holders.BaseViewHolder
import com.example.ecome.view.holders.FavouriteViewHolder
import com.example.ecome.view.holders.ProductViewHolder

class FavouriteAdapter (context: Context) : BaseAdapter<FavouriteViewHolder, ProductVO> (context) {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder<ProductVO> {
        val view = mLayoutInflator.inflate(R.layout.item_view_favourite, p0, false)
        return FavouriteViewHolder(view)
    }

}