package com.example.ecome.data.model

import android.content.Context
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.CategoryResponse

class CategoryModel private constructor(context : Context) : BaseModel(context), ImplCategory {


    companion object {
        var categoryModel: CategoryModel? = null

        fun getInstance(): CategoryModel {
            if (categoryModel == null) {
                throw RuntimeException("NewsModel is being invoked before initializing.")
            }
            return categoryModel!!

        }

        fun initNewsAppModel(context : Context) {
            categoryModel = CategoryModel(context)
        }
    }

    override fun getCategoryList(result: ImplCategory.CategoryResult) : MutableList<CategoryVO> {





        mDataAgent.loadCategory(object : BaseDelegate<CategoryResponse> {
            override fun fail(message: String) {
                result.onError(message)
            }

            override fun success(dataVo: CategoryResponse) {
                mEcommerceDatabase.getCategoryDao().insertCategory(dataVo.categoryList!!)

                result.onSuccess(dataVo.categoryList)


            }

        })

        return  mEcommerceDatabase.getCategoryDao().getCategory()
    }

      fun isEmpty():Boolean {
       return if(mEcommerceDatabase.getCategoryDao().getCategory()==null) {
            true
        }else {
           false
       }
    }



}