package com.example.ecome.data.model

import android.content.Context
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.ProductResponse

class ProductModel private constructor(context: Context) : BaseModel(context), ImplProduct {

    override fun getProductsById(id: Int): ProductVO {
        return mEcommerceDatabase!!.getProductDao().getProductById(id)
    }


    companion object {
        var productModel: ProductModel? = null

        fun getInstance(): ProductModel {
            if (productModel == null) {
                throw RuntimeException("NewsModel is being invoked before initializing.")
            }
            return productModel!!

        }

        fun initProductAppModel(context : Context) {
            productModel = ProductModel(context)
        }
    }

    override fun getProducts(delegate: ImplProduct.ProductDelegate): MutableList<ProductVO> {
        mDataAgent.loadProduct(object : BaseDelegate<ProductResponse> {
            override fun fail(message: String) {

                delegate.onError(message)
            }

            override fun success(dataVo: ProductResponse) {

               var productsList =  mEcommerceDatabase!!.getProductDao().insertProduct(dataVo.products!!)

                delegate.onSuccess(dataVo.products!!)
            }

        })
        var result = mEcommerceDatabase!!.getProductDao().getProduct()
        return result
    }

    fun isEmpty(): Boolean {
        return if (mEcommerceDatabase!!.getProductDao().getProduct() == null) {
            true
        } else {
            false
        }
    }


}