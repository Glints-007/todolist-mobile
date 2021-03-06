package com.example.todo.task

import com.google.gson.annotations.SerializedName

data class ShowTaskResp(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("userId")
    val userId: Int
)