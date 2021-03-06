package com.example.ecome.data.model

import android.content.Context
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.LoginResponse

object ImplUserModel: BaseModel (), UserModel{

    fun getInstance() : ImplUserModel = ImplUserModel

    override fun login(name: String, password: String, loginDelegate: UserModel.loginDelegate) {
        mDataAgent.login(name,password,object : BaseDelegate<LoginResponse> {
            override fun fail(message: String) {
                loginDelegate.onFail("fail login")
            }

            override fun success(dataVo: LoginResponse) {
                loginDelegate.onSuccess(dataVo.login_user!!) /// !!
            }
        })

    }

    override fun logout() {
    }


}


/*
lass UserModel private constructor(context: Context): BaseModel(context),ILogin{

    companion object {
        var INSTANCE : UserModel?=null

        fun initUserModel(context: Context){
            if(INSTANCE == null)
                INSTANCE = UserModel(context)
        }
        fun getInstance() : UserModel{
            return INSTANCE!!
        }
    }

    override fun login(phone: String, pw: String,loginDelegate: ILogin.LoginDelegate) {
        mDataAgent.login(phone,pw,object : BaseDelegate<LoginResponse>{
            override fun fail(message: String) {
                loginDelegate.onFail("fail login")
            }

            override fun success(dataVo: LoginResponse) {
                loginDelegate.onSuccess(dataVo.login_user)
            }
        })

    }


    override fun logout() {


    }
}*/
