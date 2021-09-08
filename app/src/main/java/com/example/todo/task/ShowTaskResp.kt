package com.example.todo.task

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ShowTaskResp {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("userId")
    @Expose
    var userId: String? = null

    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("date")
    @Expose
    val date: String? = null
}