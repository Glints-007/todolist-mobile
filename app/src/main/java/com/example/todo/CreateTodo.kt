package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.task.CreateTaskReq
import com.example.todo.task.CreateTaskResp
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateTodo : AppCompatActivity() {
    private lateinit var titleTask: TextInputEditText
    private lateinit var timelineTask: TextInputEditText
    private lateinit var createTaskBtn: MaterialButton
    private lateinit var back_efab: ExtendedFloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_todo)

        titleTask = findViewById(R.id.titleTodo)
        timelineTask = findViewById(R.id.dateTodo)
        back_efab = findViewById(R.id.back_extend_fab)
        createTaskBtn = findViewById(R.id.createTask_btn)

        back_efab.setOnClickListener{
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
        }

        createTaskBtn.setOnClickListener {
            val createTaskReq = CreateTaskReq()
            if (TextUtils.isEmpty(titleTask.text.toString())){
                titleTask.requestFocus()
                titleTask.setError("Please enter your email...")
            }
            else{
                createTaskReq.name = titleTask.text.toString().trim()
                createTaskReq.date = timelineTask.text.toString().trim()

                createTask(createTaskReq)
            }
        }
    }

    private fun createTask(createTaskReq: CreateTaskReq){
        val createTaskResCall: Call<CreateTaskResp> = APIClient.task.createTask(createTaskReq)
        createTaskResCall.enqueue(object: Callback<CreateTaskResp> {
            override fun onResponse(call: Call<CreateTaskResp>, response: Response<CreateTaskResp>) {
                if (response.isSuccessful){
                    val message = "Created successfully..."
                    Toast.makeText(this@CreateTodo, message, Toast.LENGTH_LONG).show()

                    val intent =Intent(this@CreateTodo, todoShow::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    val message = "An error occurred\n Please try again later..."
                    Toast.makeText(this@CreateTodo, message, Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(call: Call<CreateTaskResp>, t: Throwable) {
                val message = t.localizedMessage
                Toast.makeText(this@CreateTodo, message, Toast.LENGTH_LONG).show()
            }
        })
    }
}