package com.example.todo.task

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class IndexTodo {
        @field:SerializedName("date")
        @Expose
        val date: String? = null

        @field:SerializedName("updated_at")
        @Expose
        val updatedAt: String? = null

        @field:SerializedName("name")
        @Expose
        val name: String? = null

        @field:SerializedName("created_at")
        @Expose
        val createdAt: String? = null

        @field:SerializedName("id")
        @Expose
        val id: Int? = null

        @field:SerializedName("userId")
        @Expose
        val userId: Int? = null
}
