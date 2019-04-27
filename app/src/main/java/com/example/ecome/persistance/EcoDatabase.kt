package com.example.ecome.persistance

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.data.vos.ProductVO

@Database(entities = arrayOf(CategoryVO::class,ProductVO::class), version = 4)
abstract class EcoDatabase : RoomDatabase() {

    public abstract fun getCategoryDao(): CategoryDao
    public abstract fun getProductDao() : ProductDao

    companion object {
        val DATABASE_NAME = "ecodatabase"
        var database: EcoDatabase? = null

        fun getInstance(context: Context): EcoDatabase {

            if (database == null) {
                database = Room.databaseBuilder(context, EcoDatabase::class.java, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build()
            }
            return database!!

        }
    }

}