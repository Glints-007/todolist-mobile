package com.example.todo.api

import com.example.todo.list.*
import retrofit2.Call
import retrofit2.http.*

interface ListService {
    @FormUrlEncoded
    @POST("/api/v1/todos/{todoId}/lists")
    fun createList(
        @Path("todoId") todoId: Int,
        @Field("name") name: String,
        @Field("content") content: String,
        @Field("image") image: String
    ): Call<CreateListResp>

    @FormUrlEncoded
    @GET("/api/v1/todos/{todoId}/lists")
    fun indexList(
        @Path("todoId") todoId: Int
    ): Call<List<IndexList>>


    @FormUrlEncoded
    @GET("/api/v1/todos/{todoId}/lists")
    fun showList(
        @Path("todoId") todoId: Int
    ): Call<ShowListResp>

    @FormUrlEncoded
    @PUT("/api/v1/todos/{todoId}/lists")
    fun editList(
        @Path("todoId") todoId: Int,
        @Field("name") name: String,
        @Field("content") content: String,
        @Field("image") image: String
    ): Call<EditListResp>

    @FormUrlEncoded
    @DELETE("/api/v1/todos/{todoId}/lists")
    fun deleteList(
        @Path("todoId") todoId: Int
    ): Call<DelListResp>
}