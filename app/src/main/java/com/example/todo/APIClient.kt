package com.example.todo

import com.example.todo.task.TaskService
import com.example.todo.user.UserService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {
    val gson = GsonBuilder().setLenient().create()

    //private fun client(token: String)

    val retrofit: Retrofit
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val okHttpClient: OkHttpClient =
                Builder().addInterceptor(httpLoggingInterceptor).build()
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://shielded-springs-76713.herokuapp.com")
                .client(okHttpClient)
                .build()
        }
    val user: UserService
        get() = retrofit.create(UserService::class.java)

    val task: TaskService
        get() = retrofit.create(TaskService::class.java)


}