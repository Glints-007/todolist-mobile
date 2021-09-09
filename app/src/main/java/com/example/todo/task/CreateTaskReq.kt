package com.example.todo.task

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//@Parcelize
class CreateTaskReq {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("date")
    @Expose
    var date: String? = null
//    ): Parcelable{
//        constructor(): this("","")
    }