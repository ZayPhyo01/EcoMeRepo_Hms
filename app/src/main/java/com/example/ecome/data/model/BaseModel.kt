package com.example.ecome.data.model

import android.content.Context
import com.example.ecome.network.ProductDataAgent
import com.example.ecome.persistance.EcommerceDatabase

open class BaseModel {

    val mDataAgent = ProductDataAgent.getInstance()

    lateinit var mEcommerceDatabase: EcommerceDatabase

}