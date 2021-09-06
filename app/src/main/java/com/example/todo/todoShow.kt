package com.example.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class todoShow : AppCompatActivity() {
    private lateinit var back_efab: ExtendedFloatingActionButton
    private lateinit var todoItem: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_show)

        back_efab = findViewById(R.id.back_extend_fab)
        todoItem = findViewById(R.id.todoRV)

        back_efab.setOnClickListener{
            //
        }
    }
}