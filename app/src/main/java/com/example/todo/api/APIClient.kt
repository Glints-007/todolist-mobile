package com.example.todo.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {
    val BASE_URL = "https://shielded-springs-76713.herokuapp.com"
    val gson = GsonBuilder().setLenient().create()

//    private fun client(token: String): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor(OAuthInterceptor("Bearer", token))
//            .build()
//    }
//
//    @JvmName("getRetrofit1")
//    private fun getRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//    }
//    private fun getRetrofit(token: String): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(client(token))
//            .build()
//    }
//
//    fun user(token: String): UserService = getRetrofit(token).create(UserService::class.java)
//    fun user(): UserService = getRetrofit().create(UserService::class.java)

    val retrofit: Retrofit
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val okHttpClient: OkHttpClient =
                Builder().addInterceptor(httpLoggingInterceptor).build()
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()
        }
//    val user: UserService
//        get() = retrofit.create(UserService::class.java)


    val user: UserService
        get() = retrofit.create(UserService::class.java)
    val task: TaskService
        get() = retrofit.create(TaskService::class.java)


}