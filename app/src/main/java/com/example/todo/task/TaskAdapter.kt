package com.example.todo.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R

class TaskAdapter(private val list: ArrayList<ShowTaskResp>): RecyclerView.Adapter<TaskAdapter.TaskVH>(){
    inner class  TaskVH(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(taskResp: ShowTaskResp){
            with(itemView){
                val title = findViewById<TextView>(R.id.titleTV)
                val timeline = findViewById<TextView>(R.id.timelineTV)

                title.text = taskResp.name
                timeline.text = taskResp.date
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskVH {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_todo_item, parent, false)

        return TaskVH(view)
    }

    override fun onBindViewHolder(holder: TaskVH, position: Int) {
//        holder.title.setText(list.get(position).name)
//        holder.timeline.setText(list.get(position).date)
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}