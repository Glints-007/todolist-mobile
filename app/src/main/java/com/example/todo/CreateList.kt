package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class CreateList : AppCompatActivity() {
    private lateinit var back_efab: ExtendedFloatingActionButton
    private lateinit var title: TextInputEditText
    private lateinit var desc: TextInputEditText
    private lateinit var image_btn: MaterialButton
    private lateinit var createList_btn: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_list)


        back_efab = findViewById(R.id.back_extend_fab)
        title = findViewById(R.id.titleList)
        desc = findViewById(R.id.descList)
        image_btn = findViewById(R.id.image_btn)
        createList_btn = findViewById(R.id.createList_btn)

        back_efab.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
        }

        createList_btn.setOnClickListener {
            //val createTaskReq = CreateTaskReq()
            if (TextUtils.isEmpty(title.text.toString()) or
                TextUtils.isEmpty(desc.text.toString())
            ) {
                val message = "Those are required..."
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            } else {
//                createTaskReq.name = title.text.toString().trim()
//                createTaskReq.date = desc.text.toString().trim()
//
//                createTask(createTaskReq)
            }
        }
    }
}