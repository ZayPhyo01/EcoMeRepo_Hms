package com.example.ecome.network

import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.CategoryResponse
import com.example.ecome.network.response.ProductResponse
import com.example.ecome.util.DataAgentUtil
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductDataAgent private constructor() : DataAgent {

    override fun loadCategory(categoryDelegate: BaseDelegate<CategoryResponse>) {
        var categories = mEcommerceApi.getCategory(DataAgentUtil.ACCESS_TOKEN, 1)
        categories.enqueue(ProductCallback<CategoryResponse>(categoryDelegate))
    }

    override fun loadProduct(productDelegate: BaseDelegate<ProductResponse>) {
        var products = mEcommerceApi.getProduct(DataAgentUtil.ACCESS_TOKEN,1)
        products.enqueue(ProductCallback<ProductResponse>(productDelegate))
    }

    var mRetrofit: Retrofit? = null
    private var mEcommerceApi: EcommerceApi

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl(DataAgentUtil.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        mEcommerceApi = mRetrofit!!.create(EcommerceApi::class.java)

    }

    companion object {
        var dataAgent: ProductDataAgent? = null

        fun getInstance(): ProductDataAgent {

            if (dataAgent == null) {
                dataAgent = ProductDataAgent()
            }

            return dataAgent!!
        }
    }


}