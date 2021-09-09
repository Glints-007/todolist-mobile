package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.user.LoginReq
import com.example.todo.user.LoginResponse
import com.example.todo.user.UserPrefManager
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var user_login: TextInputEditText
    private lateinit var pass_login: TextInputEditText
    private lateinit var login_btn: MaterialButton
    private lateinit var regist_page: MaterialButton
    private lateinit var forgot_pass: TextView
    private lateinit var userPrefManager: UserPrefManager

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

        login_btn.setOnClickListener {
            val loginReq = LoginReq()
            if (TextUtils.isEmpty(user_login.text.toString())){
                user_login.requestFocus()
                user_login.setError("Please enter your email...")
            }
            if (TextUtils.isEmpty(pass_login.text.toString())){
                pass_login.requestFocus()
                pass_login.setError("Please enter your password...")
            }
            else{
                loginReq.email = user_login.text.toString().trim()
                loginReq.password = pass_login.text.toString().trim()
                loginUser(loginReq)
            }
        }

        userPrefManager = UserPrefManager(applicationContext)

        forgot_pass.setOnClickListener {
            val intent = Intent(this, ForgotActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
        }
    }

    fun loginUser(loginReq: LoginReq){
        val loginResponseCall: Call<LoginResponse> = APIClient.user().loginUser(loginReq)
        loginResponseCall.enqueue(object: Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful){
                    val loginResponse = response.body()
                    if (loginResponse!!.content!!.status_code!!.equals("200")){
                        userPrefManager.saveUser(LoginResponse.User())
                        val intent = Intent(this@MainActivity, DashboardActivity::class.java)
//                    startActivity(intent.putExtra("data", loginResponse))
                        Log.d("Debug", "ISI " + APIClient.gson.toJson(loginResponse))
                        startActivity(intent)
                        finish()
                    }
                }
                else{
                    val message = "Unable to login with the provided credential..."
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                val message = t.localizedMessage
                Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
            }
        })
    }

//    override fun onStart() {
//        super.onStart()
//
//        if (userPrefManager.isLogin){
//            val intent = Intent(this@MainActivity, DashboardActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//    }
}