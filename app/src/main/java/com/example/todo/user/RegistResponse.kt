package com.example.todo.user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegistResponse {
    @SerializedName("access_token")
    @Expose
    var access_token: String? = null

    @SerializedName("token_type")
    @Expose
    var token_type: String? = null
}