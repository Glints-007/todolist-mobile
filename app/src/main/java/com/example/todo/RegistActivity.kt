package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
            onBackPressed()
        }

        fun onBackPressed() {
            super.onBackPressed()
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
        }

        regist_btn.setOnClickListener {
            fun onCLick(){
                val registReq = RegistReq()
                if (TextUtils.isEmpty(name_regist.text.toString()) or
                    TextUtils.isEmpty(email_regist.text.toString()) or
                    TextUtils.isEmpty(pass_regist.text.toString())){

                    val message = "All inputs required..."
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                }
                else{
                registReq.name(name_regist.text.toString())
                registReq.email(email_regist.text.toString())
                registReq.password(pass_regist.text.toString())

                registUser(registReq)
                }
            }
        }
    }

    fun registUser(registReq: RegistReq){
        val registResponseCall: Call<RegistResponse> = APIClient.service.registUser(registReq)
        registResponseCall.enqueue(Callback<RegistResponse>() {
            fun onResponse(call: Call<RegistResponse>, response: Response<RegistResponse>){
                if (response.isSuccessful){
                    val message = "Your account is successfully registered..."
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show()

                    val intent =Intent(this, MainActivity::class.java)
                    startActivity(intent)
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