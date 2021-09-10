package com.example.todo.list
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class IndexList {
    @SerializedName("content")
    @Expose
    val content: String? = null

    @SerializedName("created_at")
    @Expose
    val createdAt: String? = null

    @SerializedName("id")
    @Expose
    val id: Int? = null

    @SerializedName("image")
    @Expose
    val image: String? = null

    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("todoId")
    @Expose
    val todoId: Int? = null

    @SerializedName("updated_at")
    @Expose
    val updatedAt: String? = null
}