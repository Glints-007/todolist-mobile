package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var user_login: TextInputEditText
    private lateinit var pass_login: TextInputEditText
    private lateinit var login_btn: MaterialButton
    private lateinit var regist_page: MaterialButton
    private lateinit var forgot_pass: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user_login = findViewById(R.id.email_login)
        pass_login = findViewById(R.id.pass_login)
        login_btn = findViewById(R.id.login_btn)
        regist_page = findViewById(R.id.regist_page)
        forgot_pass = findViewById(R.id.forgotpass)

        regist_page.setOnClickListener {
            val intent = Intent(this, RegistActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
        }
    }
}