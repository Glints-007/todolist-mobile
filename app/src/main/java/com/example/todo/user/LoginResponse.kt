package com.example.todo.user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class LoginResponse : Serializable {
    @SerializedName("errors")
    @Expose
    val errors: String? = null

    @SerializedName("content")
    @Expose
    val content: User? = null
    class User{
        @SerializedName("status_code")
        @Expose
        var status_code: Int? = null

        @SerializedName("access_token")
        @Expose
        var access_token: String? = null

        @SerializedName("token_type")
        @Expose
        var token_type: String? = null
    }
}