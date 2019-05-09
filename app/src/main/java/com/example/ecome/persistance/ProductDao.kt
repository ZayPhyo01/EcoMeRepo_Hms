package com.example.ecome.persistance

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.view.holders.ProductViewHolder

@Dao
abstract class ProductDao {

    @Query("Select * from product")
    abstract fun getProduct() : MutableList<ProductVO>

    @Query("Select * from product where product_id = :id")
    abstract fun getProductById(id : Int) : ProductVO

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertProduct(products : MutableList<ProductVO>) : List<Long>


    fun getFavouriteByProductID(favouriteDao: FavouriteDao, productDao: ProductDao): MutableList<ProductVO>{

        var allProductsId = productDao.getProduct()
        var allFavouritesId = favouriteDao.getFavouriteProduct()


        for (p in allProductsId){
            for (f in allFavouritesId){

                if (p.product_id == f.product_id){

                    p.isFavourtie = true

                    break
                }

            }
        }


        return allProductsId
    }



}