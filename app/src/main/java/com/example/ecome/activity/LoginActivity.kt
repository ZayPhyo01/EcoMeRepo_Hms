package com.example.ecome.activity

import android.os.Bundle
import android.support.v4.app.TaskStackBuilder
import android.util.Log
import android.view.View
import com.example.ecome.R
import com.example.ecome.data.model.ImplUserModel
import com.example.ecome.data.model.UserModel
import com.example.ecome.data.vos.LoginUserVO
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {


    lateinit var userModel: ImplUserModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        userModel = ImplUserModel.getInstance()

        btn_login.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {



                userModel.login(et_userName.text.toString(), et_password.text.toString(), object : UserModel.loginDelegate {
                    override fun onSuccess(loginVO: LoginUserVO) {
                        startActivity(MainActivity.newIntent(applicationContext))
                        finish()

                    }

                    override fun onFail(message: String) {
                        //progressBar.cancel()
                        Log.d("login","fail")
                    }
                })

            }
        })
    }


}

