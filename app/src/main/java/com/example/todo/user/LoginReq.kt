package com.example.todo.user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginReq {
    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null
}