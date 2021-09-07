package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.user.LoginResponse
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class DashboardActivity : AppCompatActivity() {
    private lateinit var createNewTask: MaterialCardView
    private lateinit var showTasks: MaterialCardView
    private lateinit var logout: MaterialButton

    private lateinit var loginResponse: LoginResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        createNewTask = findViewById(R.id.createTodo)
        showTasks = findViewById(R.id.showTodo)
        logout = findViewById(R.id.logout_btn)

        if (intent.extras != null){
            loginResponse = intent.getSerializableExtra("data") as LoginResponse

            Log.e("TAG", "====>"+ loginResponse.content)
        }

        logout.setOnClickListener {
            //

            val intent = Intent(this@DashboardActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}