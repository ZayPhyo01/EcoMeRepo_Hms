package com.example.ecome.view.holders

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<S : Any>(view : View):RecyclerView.ViewHolder(view),View.OnClickListener {

    protected var bindData : S?=null

    init {
        view.setOnClickListener(this)
    }
    abstract fun bind(bindData : S)
}