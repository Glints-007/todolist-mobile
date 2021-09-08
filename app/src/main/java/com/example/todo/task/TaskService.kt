package com.example.todo.task

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TaskService {
    @GET("/api/v1/todos")
//    fun getIndex(): Call<ArrayList<ArrayList<IndexTodo>>>
    fun getIndex(): Call<IndexTodo>

    @POST("/api/v1/todos")
    fun createTask(
        @Body createTaskReq: CreateTaskReq
    ): Call<CreateTaskResp>

    @GET("/api/v1/todos/{todoId}")
    fun getTask(): Call<ArrayList<ShowTaskResp>>

//    @PUT("/api/v1/todos/{todoId}")

//    @DELETE("/api/v1/todos/{todoId}")
}