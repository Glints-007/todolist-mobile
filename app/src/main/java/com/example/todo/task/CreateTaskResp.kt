package com.example.todo.task
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CreateTaskResp(
    @SerializedName("date")
    val date: String,
    @SerializedName("errors")
    val errors: String,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("userId")
    val userId: Int
)
    : Parcelable {
    constructor(): this("","","","","",0)
}