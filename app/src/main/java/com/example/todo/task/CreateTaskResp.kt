package com.example.todo.task

import com.google.gson.annotations.SerializedName

data class CreateTaskResp(
    @SerializedName("userId")
    val userId: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("date")
    val date: String
)
//    : Parcelable {
//    constructor(): this("","","","")
//}