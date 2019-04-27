package com.example.ecome.view.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.ecome.R
import com.example.ecome.data.vos.CategoryVO

class CategoryViewHolder(view: View) : BaseViewHolder<CategoryVO>(view) {

    var categoryIcon: ImageView? = null
    var categoryName: TextView? = null

    init {
        categoryIcon = itemView.findViewById(R.id.imv_category_icon)
        categoryName = itemView.findViewById(R.id.tv_category_name)
    }

    override fun bind(bindData: CategoryVO) {

        Glide.with(itemView.context)
            .load(bindData.category_icon)
            .into(categoryIcon!!)
        categoryName!!.setText(bindData.category_name.toString())
    }

    override fun onClick(v: View?) {
    }
}