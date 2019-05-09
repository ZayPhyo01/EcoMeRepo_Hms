package com.example.ecome

import android.app.Application
import com.example.ecome.data.model.*

class EcommerceApp : Application() {

    override fun onCreate() {
        super.onCreate()
       // CategoryModel.initNewsAppModel(applicationContext)
        CategoryModel.initEcoDatabase(applicationContext)
        ProductModel.initEcoDatabase(applicationContext)
        ImplUserModel.initEcoDatabase(applicationContext)
        //BaseModel.setUpDatabase(applicationContext)
    }
}


