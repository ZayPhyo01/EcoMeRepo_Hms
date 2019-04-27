package com.example.ecome.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.ColorInt

@Entity(tableName = "product")
data class ProductVO(
    @PrimaryKey
    @ColumnInfo
    var product_id: Int? = null,

    @ColumnInfo
    var product_name: String? = null,

    @Ignore
    var product_image_url: MutableList<ProductImageVO>? = null,

    @ColumnInfo
    var product_desc: String? = null,

    @ColumnInfo
    var product_price: String? = null,

    @ColumnInfo
    var uploaded_time: String? = null,

    @ColumnInfo
    var availability: Boolean? = null,

    @ColumnInfo
    var uploaded_date: String? = null

)