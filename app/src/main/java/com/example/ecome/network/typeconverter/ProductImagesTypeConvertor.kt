package com.example.ecome.network.typeconverter

import android.arch.persistence.room.TypeConverter
import com.example.ecome.data.vos.ProductImageVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class ProductImagesTypeConvertor {

    @TypeConverter
    fun  toJson(myObj: MutableList<ProductImageVO>) : String{
        return Gson().toJson(myObj)
    }

    @TypeConverter
    fun toObj (string : String) : MutableList<ProductImageVO> {
        var gson = Gson()

        val listType = object : TypeToken<MutableList<ProductImageVO>>() {

        }.type
        return Gson().fromJson(string,listType)
    }




/*  @TypeConverter
    fun String fromListToJson (obj: List<Prod>) {

        return Gson().toJson(images)

    }*/
//
//    @TypeConverter
//    fun List<String> fromJsonToList (String jsonImages){
//
//        listType : Type =
//
//        return Gson().fromJson(jsonImages, listType)
//    }
}