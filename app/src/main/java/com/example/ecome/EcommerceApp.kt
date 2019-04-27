package com.example.ecome

import android.app.Application
import com.example.ecome.data.model.BaseModel
import com.example.ecome.data.model.CategoryModel
import com.example.ecome.data.model.ProductModel

class EcommerceApp : Application() {

    override fun onCreate() {
        super.onCreate()
        CategoryModel.initNewsAppModel(applicationContext)
        ProductModel.initProductAppModel(applicationContext)
        //BaseModel.setUpDatabase(applicationContext)
    }
}


