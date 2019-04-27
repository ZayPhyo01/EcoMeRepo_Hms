package com.example.ecome.data.vos

import android.arch.persistence.room.*
import android.support.annotation.ColorInt
import com.example.ecome.network.typeconverter.ProductImagesTypeConvertor
import com.google.gson.annotations.SerializedName

@Entity(tableName = "product")
@TypeConverters(ProductImagesTypeConvertor::class)
class ProductVO {


    @PrimaryKey
    @ColumnInfo
    @SerializedName("product_id")
    var product_id: Int = 0

    @ColumnInfo
    @SerializedName("product_name")
    var product_name: String? = null


    @ColumnInfo
    @SerializedName("product_image_url")
    var product_image_url: List<ProductImageVO>? = null
        get() = if (field == null) ArrayList() else field

    @ColumnInfo
    @SerializedName("product_desc")
    var product_desc: String? = null

    @ColumnInfo
    @SerializedName("product_price")
    var product_price: String? = null

    @ColumnInfo
    @SerializedName("uploaded_time")
    var uploaded_time: String? = null

    @ColumnInfo
    @SerializedName("uploaded_date")
    var uploaded_date: String? = null

    @ColumnInfo
    @SerializedName("availability")
    var availability: String? = null

//    var images: List<String>? = null
//            get() = if (field == null) ArrayList() else field

}