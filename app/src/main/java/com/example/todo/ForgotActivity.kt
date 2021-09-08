package com.example.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class ForgotActivity : AppCompatActivity() {
    private lateinit var email_reset: TextInputEditText
    private lateinit var reset_email: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        email_reset = findViewById(R.id.email_forgot)
        reset_email = findViewById(R.id.reset_btn)

//        reset_email.setOnClickListener {
//
//        }
    }
}