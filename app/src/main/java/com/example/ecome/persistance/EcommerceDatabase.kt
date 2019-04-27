package com.example.ecome.persistance

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.data.vos.ProductVO

@Database(entities = arrayOf(CategoryVO::class,ProductVO::class), version = 4)
abstract class EcommerceDatabase : RoomDatabase() {

    public abstract fun getCategoryDao(): CategoryDao
    public abstract fun getProductDao() : ProductDao

    companion object {
        val DATABASE_NAME = "ecommerceDatabase"
        var database: EcommerceDatabase? = null

        fun getInstance(context: Context): EcommerceDatabase {

            if (database == null) {
                database = Room.databaseBuilder(context, EcommerceDatabase::class.java, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return database!!

        }
    }

}