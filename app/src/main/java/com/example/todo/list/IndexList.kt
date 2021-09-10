package com.example.todo.list
import com.google.gson.annotations.SerializedName

class IndexList : ArrayList<IndexListItem>()

data class IndexListItem(
    @SerializedName("content")
    val content: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("todoId")
    val todoId: Int,
    @SerializedName("updated_at")
    val updatedAt: String
)