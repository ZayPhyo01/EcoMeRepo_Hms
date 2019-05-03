package com.example.ecome.data.vos

import android.arch.persistence.room.*
import android.support.annotation.ColorInt
import com.example.ecome.network.typeconverter.ProductImagesTypeConvertor
import com.google.gson.annotations.SerializedName

@Entity(tableName = "product")
@TypeConverters(ProductImagesTypeConvertor::class)
data class ProductVO (


    @PrimaryKey
    @ColumnInfo
    @SerializedName("product_id")
    val product_id: Int,

    @ColumnInfo
    @SerializedName("product_name")
    val product_name: String,

//
//    @ColumnInfo
//    @SerializedName("product_image_url")
//    val product_image_url: List<ProductImageVO>
//        get() = if (field == null) ArrayList() else field,

    @ColumnInfo
    @SerializedName("product_desc")
    val product_desc: String,

    @ColumnInfo
    @SerializedName("product_price")
    val product_price: String,
    @ColumnInfo
    @SerializedName("uploaded_time")
    val uploaded_time: String,

    @ColumnInfo
    @SerializedName("uploaded_date")
    val uploaded_date: String,
    @ColumnInfo
    @SerializedName("availability")
    val availability: String
)

//    var images: List<String>? = null
//            get() = if (field == null) ArrayList() else field

}