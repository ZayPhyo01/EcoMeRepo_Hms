package com.example.ecome.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "login_user")
data class LoginUserVO (

    @PrimaryKey
    @ColumnInfo
    @SerializedName("user_id") var user_id : Int,

    @ColumnInfo
    @SerializedName("name") var name : String,

    @ColumnInfo
    @SerializedName("address") var address : String,

    @ColumnInfo
    @SerializedName("phone_no") var phone_no : String,

    @ColumnInfo
    @SerializedName("wallet") var wallet : String,

    @ColumnInfo
    @SerializedName("profile_image") var profile_image : String,

    @ColumnInfo
    @SerializedName("cover_image") var cover_image : String

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
