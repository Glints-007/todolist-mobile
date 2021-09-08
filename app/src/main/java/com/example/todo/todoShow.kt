package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.task.ShowTaskResp
import com.example.todo.task.TaskAdapter
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class todoShow : AppCompatActivity(){
    private lateinit var back_efab: ExtendedFloatingActionButton
    private lateinit var todoRV: RecyclerView
    private val list = ArrayList<ShowTaskResp>()

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

        todoRV .setHasFixedSize(true)
        todoRV.layoutManager = LinearLayoutManager(this)
        getData()
    }

    fun getData() {
        APIClient.task.getTask().enqueue(object: Callback<ArrayList<ShowTaskResp>> {
            override fun onResponse(call: Call<ArrayList<ShowTaskResp>>, response: Response<ArrayList<ShowTaskResp>>
            ) {
                if (response.isSuccessful){
                    val showTask = response.body()
                    for (st in showTask!!){
                        response.body()?.let { list.addAll(it)}
                        val adapter = TaskAdapter(list)
                        todoRV.adapter = adapter
                    }
                }
                else{
                    val message = "An error occurred\nPlease try again later..."
                    Toast.makeText(this@todoShow, message, Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ArrayList<ShowTaskResp>>, t: Throwable) {
                val message = t.localizedMessage
                Toast.makeText(this@todoShow, message, Toast.LENGTH_LONG).show()
            }
        })
    }
}