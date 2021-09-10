package com.example.todo.list
import com.google.gson.annotations.SerializedName

data class EditListResp(
    @SerializedName("errors")
    val errors: String,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("status")
    val status: String
)