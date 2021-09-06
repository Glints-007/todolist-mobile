package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import retrofit2.*

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

        login_btn.setOnClickListener {
            val registReq = RegistReq()
            if (TextUtils.isEmpty(user_login.text.toString()) or
                TextUtils.isEmpty(pass_login.text.toString())){
                    val message = "All inputs required..."
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
            else{
                val loginReq = LoginReq()
                loginReq.email(user_login.text.toString())
                loginReq.password(pass_login.text.toString())
                 loginUser(loginReq)
            }
        }
    }

    fun loginUser(loginReq: LoginReq){
        val loginResponseCall: Call<LoginResponse> = APIClient.service.loginUser(loginReq);
        loginResponseCall.enqueue(Callback<LoginResponse>() {
            fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>){
                if (response.isSuccessful){
                    val loginResponse = response.body()

                    val intent =Intent(this, DashboardActivity::class.java)
                    startActivity(intent.putExtra("data", loginResponse))
                    finish()
                }
                else{
                    val message = "An error occurred\n Please try again later..."
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                }
            }

            fun onFailure(call: Call<RegistResponse>, t: Throwable){
                val message = t.localizedMessage
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        })
    }
}