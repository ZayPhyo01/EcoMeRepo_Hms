package com.example.ecome.data.model

import android.util.Log
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.CategoryResponse

class CategoryModel private constructor() : BaseModel(), ICategory {


    companion object {
        var categoryModel: CategoryModel? = null

        fun getInstance(): CategoryModel {
            if (categoryModel == null) {
                categoryModel = CategoryModel()
            }
            return categoryModel!!

        }
    }

    override fun getCategoryList(result: ICategory.CategoryResult) : MutableList<CategoryVO> {





        mDataAgent.loadCategory(object : BaseDelegate<CategoryResponse> {
            override fun fail(message: String) {
                result.onError(message)
            }

            override fun success(dataVo: CategoryResponse) {
                mEcoDatabase!!.getCategoryDao().insertCategory(dataVo.categoryList!!)

                result.onSuccess(dataVo.categoryList)


            }

        })

        return  mEcoDatabase!!.getCategoryDao().getCategory()
    }

      fun isEmpty():Boolean {
       return if(mEcoDatabase!!.getCategoryDao().getCategory()==null) {
            true
        }else {
           false
       }
    }



}