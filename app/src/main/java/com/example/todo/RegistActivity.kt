package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.user.RegistReq
import com.example.todo.user.RegistResponse
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_regist.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            super.onBackPressed()
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
        }

        regist_btn.setOnClickListener {
            val registReq = RegistReq()
            if (TextUtils.isEmpty(email_regist.text.toString()) or !Patterns.EMAIL_ADDRESS.matcher(email_regist.text.toString()).matches()){
                email_regist.requestFocus()
                email_regist.setError("Please enter your email correctly...")
            }
            if (TextUtils.isEmpty(pass_regist.text.toString())){
                pass_regist.requestFocus()
                pass_regist.setError("Please enter your password...")
            }
            if ( pass_regist.text.toString().length<8){
                pass_regist.requestFocus()
                pass_regist.setError("Password contained 8 characters or more..")
            }
            else{
                registReq.name = name_regist.text.toString().trim()
                registReq.email = email_regist.text.toString().trim()
                registReq.password = pass_regist.text.toString().trim()

                registUser(registReq)
            }
        }
    }

    fun registUser(registReq: RegistReq){
        val registResponseCall: Call<RegistResponse> = APIClient.user().registUser(registReq)
        registResponseCall.enqueue(object: Callback<RegistResponse> {
            override fun onResponse(call: Call<RegistResponse>, response: Response<RegistResponse>){
                if (response.isSuccessful){
                    val message = "Your account is successfully registered..."
                    Toast.makeText(this@RegistActivity, message, Toast.LENGTH_LONG).show()

                    val intent =Intent(this@RegistActivity, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
                    finish()
                }
                else{
                    val message = "An error occurred\n Please try again later..."
                    Toast.makeText(this@RegistActivity, message, Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<RegistResponse>, t: Throwable){
                val message = t.localizedMessage
                Toast.makeText(this@RegistActivity, message, Toast.LENGTH_LONG).show()
            }
        })
    }
}