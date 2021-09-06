package com.example.todo

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("/api/v1/login")
    fun loginUser(@Body loginReq: LoginReq): Call<LoginResponse>

    @POST("/api/v1/register")
    fun registUser(@Body registReq: RegistReq): Call<RegistResponse>
}