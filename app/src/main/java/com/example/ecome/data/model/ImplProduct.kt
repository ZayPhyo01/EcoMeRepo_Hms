package com.example.ecome.data.model

import com.example.ecome.data.vos.ProductVO

interface ImplProduct {

    fun getProducts(delegate: ProductDelegate) : MutableList<ProductVO>

    fun getProductsById(id : Int) : ProductVO

    interface ProductDelegate{
        fun onSuccess(products : MutableList<ProductVO>)
        fun onError(message : String)

    }
}