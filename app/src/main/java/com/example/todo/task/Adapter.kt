package com.example.todo.task

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.list.IndexList
import com.example.todo.task.Adapter.AdapterHolder
import com.google.android.material.button.MaterialButton

class Adapter(val context: Context, val dataList: List<IndexTodo>) :
    RecyclerView.Adapter<AdapterHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.activity_todo_item, parent, false)
        return AdapterHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        val indexTodo = dataList[position]
        val title = indexTodo.name
        val timeline = indexTodo.date
        val todoId = indexTodo.userId

        holder.todoClik.setOnClickListener {
            val intent = Intent(context, IndexList::class.java)
//            intent.putExtra(todoId, dataList[position].id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class AdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var timeline: TextView
        var editTaskIcon: MaterialButton
        var todoClik: LinearLayout

        init {
            title = itemView.findViewById(R.id.titleTV)
            timeline = itemView.findViewById(R.id.timelineTV)
            editTaskIcon = itemView.findViewById(R.id.editTodo)
            todoClik = itemView.findViewById(R.id.todoItem)
        }
    }
}