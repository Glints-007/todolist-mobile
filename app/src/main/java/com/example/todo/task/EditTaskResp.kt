package com.example.todo.task
import com.google.gson.annotations.SerializedName


data class EditTaskResp(
    @SerializedName("errors")
    val errors: String,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("status")
    val status: String
)