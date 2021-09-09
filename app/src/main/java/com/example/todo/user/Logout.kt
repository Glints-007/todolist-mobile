package com.example.todo.user
import com.google.gson.annotations.SerializedName


data class Logout(
    @SerializedName("content")
    val content: Any,
    @SerializedName("errors")
    val errors: Any,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("status")
    val status: String
)