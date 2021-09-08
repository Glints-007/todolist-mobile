package com.example.todo.task

import com.google.gson.annotations.SerializedName

//class IndexTodo {
//    @SerializedName("id")
//    @Expose
//    var id: String? = null
//
//    @SerializedName("userId")
//    @Expose
//    var userId: String? = null
//
//    @SerializedName("name")
//    @Expose
//    val name: String? = null
//
//    @SerializedName("date")
//    @Expose
//    var date: String? = null
//}
data class IndexTodo(
    @field:SerializedName("Response")
    val response: List<ResponseItem?>? = null
)

data class ResponseItem(

    @field:SerializedName("date")
    val date: Any? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("userId")
    val userId: Int? = null
)
