package com.example.ecome.data.model

import android.content.Context
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.CategoryResponse

object CategoryModel : BaseModel(), ImplCategory {


        fun getInstance(): CategoryModel {
            return CategoryModel
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