package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.user.LoginResponse
import com.example.todo.user.UserPrefManager
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class DashboardActivity : AppCompatActivity() {
    private lateinit var createNewTask: MaterialCardView
    private lateinit var showTasks: MaterialCardView
    private lateinit var logout: MaterialButton

    private lateinit var loginResponse: LoginResponse
    private lateinit var userPrefManager: UserPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val accessToken = LoginResponse.User(access_token)
        setContentView(R.layout.activity_dashboard)

        createNewTask = findViewById(R.id.createTodo)
        showTasks = findViewById(R.id.showTodo)
        logout = findViewById(R.id.logout_btn)

        //val token = userPrefManager.token

        if (intent.extras != null){
            loginResponse = intent.getSerializableExtra("content") as LoginResponse
            userPrefManager.saveUser(LoginResponse.User())
            userPrefManager.token
            Log.e("TAG", "====>"+ loginResponse.content)
        }

        createNewTask.setOnClickListener {
            //

            val intent = Intent(this@DashboardActivity, CreateTodo::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
            finish()
        }

        showTasks.setOnClickListener {
            //

            val intent = Intent(this@DashboardActivity, todoShow::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
            finish()
        }

        val userPrefManager = UserPrefManager(applicationContext)
        logout.setOnClickListener {
            logoutUser()

            val intent = Intent(this@DashboardActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun logoutUser(){
        userPrefManager.logout()
        val intent =Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
        Toast.makeText(this,"You  have been logged out...", Toast.LENGTH_LONG).show()
    }
}