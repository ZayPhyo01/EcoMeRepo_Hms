package com.example.ecome.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "category")
data class CategoryVO(

    @PrimaryKey
    @ColumnInfo
    @SerializedName ("category_id" ) var category_id :Int,

    @ColumnInfo
    @SerializedName ("category_name") var category_name : String,

    @ColumnInfo
    @SerializedName ("category_icon" ) val category_icon :String,

    @ColumnInfo
    @SerializedName ("category_color") val category_color: String

)