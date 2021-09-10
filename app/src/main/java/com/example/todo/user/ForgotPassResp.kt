package com.example.todo.user
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ForgotPassResp{
    @SerializedName("success")
    @Expose
    val success: Boolean? = null

    @SerializedName("data")
    @Expose
    val data: Data? = null

    class Data {
        @SerializedName("message")
        @Expose
        val message: String? = null
    }
}