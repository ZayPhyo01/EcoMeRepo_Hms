package com.example.ecome.data.vos

import android.arch.persistence.room.ColumnInfo
import com.google.gson.annotations.SerializedName


data class ProductImageVO(

    @ColumnInfo
    @SerializedName("id") var id : Int,

    @ColumnInfo
    @SerializedName ("image_url") var image_url : String? = null

    )