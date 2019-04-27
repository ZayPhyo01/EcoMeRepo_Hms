package com.example.ecome.network

import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.CategoryResponse
import com.example.ecome.network.response.ProductResponse

interface DataAgent {
    fun loadCategory(categoryDelegate: BaseDelegate<CategoryResponse>)
    fun loadProduct(productDelegate: BaseDelegate<ProductResponse>)
}