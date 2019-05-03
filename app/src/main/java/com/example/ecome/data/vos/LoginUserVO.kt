package com.example.ecome.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "login_user")
 data class LoginUserVO (


    val user_id: Int,

    val name: String,


    val address: String,


    val phone_no: String,


    val wallet: String,


    val profile_image: String,

    val cover_image: String

)

/*
"login_user": {
    "user_id": 1,
    "name": "Aung Aung",
    "address": "Mandalay",
    "phone_no": "0978456321",
    "wallet": "500000",
    "profile_image": "http://efekt-dieta.info/cdn/images/profile-pictures/profile-pictures-16.jpg",
    "cover_image": "http://efekt-dieta.info/cdn/images/profile-pictures/profile-pictures-16.jpg"
},*/
