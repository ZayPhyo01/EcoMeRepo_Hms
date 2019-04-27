package com.example.ecome.network


import com.example.ecome.data.vos.ProductVO
import com.example.ecome.network.response.CategoryResponse
import com.example.ecome.network.response.ProductResponse
import com.example.ecome.util.DataAgentUtil
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface EcoApi {

    @POST(DataAgentUtil.CATEGORY_URL)
    @FormUrlEncoded
    fun getCategory(@Field("access_token") access_token: String, @Field("page") page: Int): Call<CategoryResponse>

    @POST(DataAgentUtil.PRODUCT_URL)
    @FormUrlEncoded
    fun getProduct(@Field("access_token") access_token: String, @Field("page") page: Int): Call<ProductResponse>
}