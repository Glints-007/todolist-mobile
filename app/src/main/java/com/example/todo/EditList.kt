package com.example.todo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class EditList : AppCompatActivity() {
    private lateinit var back_efab: ExtendedFloatingActionButton
    private lateinit var titleEdit: TextInputEditText
    private lateinit var descEdit: TextInputEditText
    private lateinit var imageEdit: MaterialButton
    private lateinit var updateList: MaterialButton
    private lateinit var delList: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_list)

        back_efab = findViewById(R.id.back_extend_fab)
        titleEdit = findViewById(R.id.titleList_edit)
        descEdit = findViewById(R.id.descList_edit)
        imageEdit = findViewById(R.id.image_btn_edit)
        updateList = findViewById(R.id.updateList_btn)
        delList = findViewById(R.id.delList_btn)

        back_efab.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
        }
    }
}