package com.example.ecome

import android.app.Application
import com.example.ecome.data.model.BaseModel
import com.example.ecome.persistance.EcoDatabase

class EcoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        BaseModel.setUpDatabase(applicationContext)
    }
}