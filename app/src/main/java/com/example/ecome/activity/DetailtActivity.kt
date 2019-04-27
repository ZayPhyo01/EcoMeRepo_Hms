package com.example.ecome.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.ecome.R

class DetailtActivity : BaseActivity() {



    companion object {

        public fun newIntent (context : Context): Intent{
            var intent = Intent(context,DetailtActivity::class.java)
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_product_activity)
    }
}