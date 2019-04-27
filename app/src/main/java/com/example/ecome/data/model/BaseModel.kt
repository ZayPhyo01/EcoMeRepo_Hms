package com.example.ecome.data.model

import android.content.Context
import com.example.ecome.network.ProductDataAgent
import com.example.ecome.persistance.EcommerceDatabase

open class BaseModel protected constructor(context: Context) {

    var mDataAgent = ProductDataAgent.getInstance()

    var mEcommerceDatabase : EcommerceDatabase = EcommerceDatabase.getInstance(context)

}