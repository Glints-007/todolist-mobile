package com.example.todo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class ListActivity : AppCompatActivity() {
    private lateinit var back_efab: ExtendedFloatingActionButton
    private lateinit var listRV: RecyclerView
    private lateinit var addListEfab: ExtendedFloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        back_efab = findViewById(R.id.back_extend_fab)
        listRV = findViewById(R.id.listRV)
        addListEfab = findViewById(R.id.addList)

        back_efab.setOnClickListener{
            val intent = Intent(this, todoShow::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
        }

        addListEfab.setOnClickListener {
            //

            val intent = Intent(this, CreateList::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
        }
    }
}