package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.api.APIClient
import com.example.todo.task.Adapter
import com.example.todo.task.IndexTodo
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class todoShow : AppCompatActivity(){
    private lateinit var back_efab: ExtendedFloatingActionButton
    private lateinit var todoRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_show)

        back_efab = findViewById(R.id.back_extend_fab)
        todoRV = findViewById(R.id.todoRV)

        back_efab.setOnClickListener{
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
        }

        //Recycle View
        todoRV .setHasFixedSize(true)
        todoRV.layoutManager = LinearLayoutManager(this)
        getIndexTodo()
    }

    fun getIndexTodo(){
        APIClient.task.getIndex().enqueue(object: Callback<List<IndexTodo>>{
            override fun onResponse(call: Call<List<IndexTodo>>, response: Response<List<IndexTodo>>) {
                if (response.isSuccessful){
                    val index: List<IndexTodo>? = response.body()
                    val adapter = Adapter(this@todoShow, index!!)
                    todoRV.adapter = adapter
                }
                else{
                    val message = "An error occurred\nPlease try again later..."
                    Toast.makeText(this@todoShow, message, Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<IndexTodo>>, t: Throwable) {
                val message = t.localizedMessage
                Toast.makeText(this@todoShow, message, Toast.LENGTH_LONG).show()
            }
        })
    }
}