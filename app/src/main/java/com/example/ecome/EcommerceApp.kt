package com.example.ecome

import android.app.Application
import com.example.ecome.data.model.*

class EcommerceApp : Application() {

    override fun onCreate() {
        super.onCreate()
        CategoryModel.initNewsAppModel(applicationContext)
        ProductModel.initProductAppModel(applicationContext)
        ImplUserModel.initUserModel(applicationContext)
        //BaseModel.setUpDatabase(applicationContext)
    }
}


