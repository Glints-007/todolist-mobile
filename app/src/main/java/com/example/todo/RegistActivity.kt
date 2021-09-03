package com.example.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class RegistActivity : AppCompatActivity() {
    private lateinit var name_regist: TextInputEditText
    private lateinit var email_regist: TextInputEditText
    private lateinit var pass_regist: TextInputEditText
    private lateinit var regist_btn: MaterialButton
    private lateinit var login_page: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)

        name_regist = findViewById(R.id.fullname_register)
        email_regist = findViewById(R.id.email_register)
        pass_regist = findViewById(R.id.pass_register)
        regist_btn = findViewById(R.id.regist_btn)
        login_page = findViewById(R.id.login_page)

        login_page.setOnClickListener {
            onBackPressed()
        }

        fun onBackPressed() {
            super.onBackPressed()
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
        }
    }
}