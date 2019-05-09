package com.example.ecome.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "fav_table")
data class FavouriteVO (

    @PrimaryKey
    @ColumnInfo
    @SerializedName("product_id")
    val product_id: Int
)



