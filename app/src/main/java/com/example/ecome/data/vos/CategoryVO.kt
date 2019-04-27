package com.example.ecome.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "category")
data class CategoryVO(

    @PrimaryKey
    @ColumnInfo(name = "category_id")
    var category_id: Int? = null,

    @ColumnInfo(name = "category_name")
    var category_name: String? = null,

    @ColumnInfo(name = "category_icon")
    var category_icon: String? = null,

    @ColumnInfo(name = "category_color")
    var category_color: String? = null
)