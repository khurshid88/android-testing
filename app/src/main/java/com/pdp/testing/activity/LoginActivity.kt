package com.pdp.testing.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.pdp.testing.R
import com.pdp.testing.utils.Utils

//https://medium.com/att-israel/a-deep-dive-into-android-espresso-3feed15d204c

class LoginActivity : AppCompatActivity() {
    lateinit var et_email: EditText
    lateinit var et_password: EditText
    lateinit var b_login: Button
    lateinit var tv_message: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
    }

    private fun initViews() {
        et_email = findViewById(R.id.et_email)
        et_password = findViewById(R.id.et_password)
        b_login = findViewById(R.id.b_login)
        tv_message = findViewById(R.id.tv_message)

        et_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val email = et_email.text.toString().trim()
                if (email.isNotEmpty() && s!!.isNotEmpty()) {
                    b_login.isEnabled = true
                } else {
                    b_login.isEnabled = false
                }
            }

        })

        b_login.setOnClickListener {
            loginUserToApp()
        }
    }

    private fun loginUserToApp() {
        val email = et_email.text.toString()
        val password = et_password.text.toString()
        if (email.equals(Utils.USER_NAME) && password.equals(Utils.VALID_PASSWORD)) {
            tv_message.text = getString(R.string.srt_success)
        } else {
            tv_message.text = getString(R.string.srt_failure)
        }
    }
}