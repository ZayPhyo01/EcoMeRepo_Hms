package com.example.ecome.data.model

import android.content.Context
import com.example.ecome.network.DataAgent
import com.example.ecome.network.ProductDataAgent
import com.example.ecome.persistance.EcoDatabase
import com.example.ecome.util.DataAgentUtil

open class BaseModel() {

    var mDataAgent : ProductDataAgent


    init {
        mDataAgent = ProductDataAgent.getInstance()

    }
    companion object {
        var mEcoDatabase  : EcoDatabase?=null
        fun setUpDatabase(context: Context){
            mEcoDatabase = EcoDatabase.getInstance(context)
        }
    }


}