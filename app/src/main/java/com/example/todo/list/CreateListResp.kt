package com.example.todo.list
import com.google.gson.annotations.SerializedName


data class CreateListResp(
    @SerializedName("content")
    val content: String,
    @SerializedName("errors")
    val errors: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("todoId")
    val todoId: String
)