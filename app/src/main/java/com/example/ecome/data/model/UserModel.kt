package com.example.ecome.data.model

import com.example.ecome.data.vos.LoginUserVO

interface UserModel {

    fun login (name: String, password: String, loginDelegate: loginDelegate)

    fun logout()


    interface loginDelegate{

        fun onSuccess (loginUserVO: LoginUserVO)
        fun onFail (message : String)

    }



}
