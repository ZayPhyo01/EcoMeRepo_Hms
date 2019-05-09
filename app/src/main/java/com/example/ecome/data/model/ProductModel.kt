package com.example.ecome.data.model

import android.content.Context
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.ProductResponse
import com.example.ecome.persistance.EcommerceDatabase

object ProductModel : BaseModel(), ImplProduct {

    fun getInstance(): ProductModel {
        return ProductModel
    }

    override fun getFavouriteByProduct(): MutableList<ProductVO> {
        return mEcommerceDatabase.getFavouriteDao().getFavouriteProduct()
    }


    override fun getProductsById(id: Int): ProductVO {
        return mEcommerceDatabase.getProductDao().getProductById(id)
    }


    override fun getProducts(delegate: ImplProduct.ProductDelegate): MutableList<ProductVO> {
        mDataAgent.loadProduct(object : BaseDelegate<ProductResponse> {
            override fun fail(message: String) {
                delegate.onError(message)
            }


            override fun success(dataVo: ProductResponse) {

                var productsList = mEcommerceDatabase.getProductDao().insertProduct(dataVo.products!!)
                delegate.onSuccess(dataVo.products!!)
            }

        })
        var result = mEcommerceDatabase.getProductDao().getProduct()
        return result
    }

    fun isEmpty(): Boolean {
        return if (mEcommerceDatabase.getProductDao().getProduct() == null) {
            true
        } else {
            false
        }
    }


}