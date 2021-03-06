package com.example.todo.api

import android.content.Context
import okhttp3.Credentials

object CredentialsManager {
    private val PREFERENCES_NAME = "auth0"
    private val ACCESS_TOKEN = "access_token"

    fun saveCredentials(context: Context, credentials: Credentials) {
        val sp = context.getSharedPreferences(
            PREFERENCES_NAME, Context.MODE_PRIVATE)

//        sp!!.edit().putString(ACCESS_TOKEN, credentials.accessToken).apply()
    }

    fun getAccessToken(context: Context): String {
        val sp = context.getSharedPreferences(
            PREFERENCES_NAME, Context.MODE_PRIVATE)

        return sp!!.getString(ACCESS_TOKEN, null)!!
    }
}