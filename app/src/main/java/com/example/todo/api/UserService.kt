package com.example.todo.api

import com.example.todo.user.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserService {
    @POST("/api/v1/login")
    fun loginUser(
        @Body loginReq: LoginReq
    ): Call<LoginResponse>

    @POST("/api/v1/register")
    fun registUser(
        @Body registReq: RegistReq
    ): Call<RegistResponse>

    @FormUrlEncoded
    @POST("/api/v1/logout")
    fun logoutUser(): Call<Logout>

    @FormUrlEncoded
    @POST("/api/v1/forgot")
    fun forgotPass(
        @Field("email") email: String
    ): Call<ForgotPassResp>
}