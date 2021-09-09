package com.example.todo.task

import retrofit2.Call
import retrofit2.http.*

interface TaskService {
    @GET("/api/v1/todos")
//    fun getIndex(): Call<ArrayList<ArrayList<IndexTodo>>>
    fun getIndex(): Call<List<IndexTodo>>

    @POST("/api/v1/todos")
    fun createTask(
        @Body createTaskReq: CreateTaskReq
    ): Call<CreateTaskResp>

    @FormUrlEncoded
    @GET("/api/v1/todos/{todoId}")
    fun getTask(): Call<ShowTaskResp>

    @FormUrlEncoded
    @PUT("/api/v1/todos/{todoId}")
    fun editTask(
        @Path ("userId") userId: Int,
        @Field("name") name: String?,
        @Field("date") date: String?
    ): Call<EditTaskResp>

    @DELETE("/api/v1/todos/{todoId}")
    fun delTask(@Path("id") id: Int): Call<DelTaskResp>
}