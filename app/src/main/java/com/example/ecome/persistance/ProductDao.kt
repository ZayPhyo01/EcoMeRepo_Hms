package com.example.ecome.persistance

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.view.holders.ProductViewHolder

@Dao
interface ProductDao {

    @Query("Select * from product")
    fun getProduct() : MutableList<ProductVO>

    @Query("Select * from product where product_id = :id")
    fun getProductById(id : Int) : ProductVO

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(products : MutableList<ProductVO>) : List<Long>





}