package com.example.todo

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.task.ShowTaskResp
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

class EditTask : AppCompatActivity(), View.OnClickListener {
    private lateinit var back_efab: ExtendedFloatingActionButton
    private lateinit var titleEdit: TextInputEditText
    private lateinit var dateEdit: TextInputEditText
    private lateinit var updateList: MaterialButton
    private lateinit var delList: MaterialButton
    private val calendar = Calendar.getInstance()
    lateinit var list: ShowTaskResp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_task)

        back_efab = findViewById(R.id.back_extend_fab)
        titleEdit = findViewById(R.id.editTitleTodo)
        dateEdit = findViewById(R.id.editDateTodo)
        updateList = findViewById(R.id.update_btn)
        delList = findViewById(R.id.delTask_btn)

        innitAction()
    }

    fun innitAction(){
        dateEdit.setOnClickListener(this)

        back_efab.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
        }
    }
    var date = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
        calendar[Calendar.YEAR] = year
        calendar[Calendar.MONTH] = month
        calendar[Calendar.DAY_OF_MONTH] = dayOfMonth
        updLabel()
    }

    override fun onClick(v: View?) {
        if (v == dateEdit){
            DatePickerDialog(
                this, date, calendar[Calendar.YEAR], calendar[Calendar.MONTH],
                calendar[Calendar.DAY_OF_MONTH]
            ).show()
        }
    }

    fun updLabel(){
        val myformat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myformat, Locale.US)
        dateEdit.setText(sdf.format(calendar.time))
    }

//    fun getTaskToEdit(){
//        APIClient.task.getTask(ShowTaskResp()).enqueue(object: Callback<ShowTaskResp> {
//            override fun onResponse(call: Call<ShowTaskResp>, response: Response<ShowTaskResp>) {
//                if (response.isSuccessful){
//                    val
//                }
//                else{
//                    val message = "An error occurred\nPlease try again later..."
//                    Toast.makeText(this@EditTask, message, Toast.LENGTH_LONG).show()
//                }
//            }
//
//            override fun onFailure(call: Call<ShowTaskResp>, t: Throwable) {
//                val message = t.localizedMessage
//                Toast.makeText(this@EditTask, message, Toast.LENGTH_LONG).show()
//            }
//        })
//    }
}