package com.example.ecome.data.model

import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.ProductResponse

class ProductModel private constructor() : BaseModel(), IProduct {

    override fun getProductsById(id: Int): ProductVO {
        return mEcoDatabase!!.getProductDao().getProductById(id)
    }


    companion object {
        var productModel: ProductModel? = null

        fun getInstance(): ProductModel {
            if (productModel == null) {
                productModel = ProductModel()
            }
            return productModel!!

        }
    }

    override fun getProducts(delegate: IProduct.ProductDelegate): MutableList<ProductVO> {
        mDataAgent.loadProduct(object : BaseDelegate<ProductResponse> {
            override fun fail(message: String) {

                delegate.onError(message)
            }

            override fun success(dataVo: ProductResponse) {

               var productsList =  mEcoDatabase!!.getProductDao().insertProduct(dataVo.products!!)

                delegate.onSuccess(dataVo.products!!)
            }

        })
        var result = mEcoDatabase!!.getProductDao().getProduct()
        return result
    }

    fun isEmpty(): Boolean {
        return if (mEcoDatabase!!.getProductDao().getProduct() == null) {
            true
        } else {
            false
        }
    }


}