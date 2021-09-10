package com.example.todo.list
import com.google.gson.annotations.SerializedName

data class DelListResp(
    @SerializedName("errors")
    val errors: Any,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("status")
    val status: String
)