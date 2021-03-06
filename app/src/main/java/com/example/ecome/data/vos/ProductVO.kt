package com.example.ecome.data.vos

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName

 @Entity(tableName = "product")
data class ProductVO(

    @PrimaryKey
    @ColumnInfo
    @SerializedName("product_id")
    var product_id: Int =0,

    @ColumnInfo
    @SerializedName("product_name")
    var product_name: String = "",


    @ColumnInfo
    @TypeConverters
    @SerializedName("product_image_url")
    var product_image_url: List<ProductImageVO> = ArrayList(),


    @ColumnInfo
    @SerializedName("product_desc")
    var product_desc: String = "",

    @ColumnInfo
    @SerializedName("product_price")
    var product_price: String = "",
    @ColumnInfo
    @SerializedName("uploaded_time")
    var uploaded_time: String = "",

    @ColumnInfo
    @SerializedName("uploaded_date")
    var uploaded_date: String ="",

    @ColumnInfo
    @SerializedName("availability")
    var availability: Boolean = false,


    @Ignore
    var isFavourtie: Boolean = false

)