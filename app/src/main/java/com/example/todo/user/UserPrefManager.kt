package com.example.todo.user

import android.content.Context
import android.content.SharedPreferences

class UserPrefManager(context: Context) {
    private var sharedPref: SharedPreferences = context.getSharedPreferences("TODO", Context.MODE_PRIVATE)
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var context: Context
    private val pref_name = "TODO"
//    private var preferences = context.getSharedPreferences(LoginResponse.User.)

    fun saveUser(userLogin: LoginResponse.User){
        editor = sharedPref.edit()
        editor.putString("status_code", userLogin.status_code!!.toInt().toString())
        editor.putString("access_token", userLogin.access_token)
        editor.putString("token_type", userLogin.token_type)
        editor.putBoolean("logged", true)
        editor.apply()
    }

    var isLogin
        get() = sharedPref.getBoolean("logged", false)
        set(value) = sharedPref.edit().putBoolean("isLogin", value).apply()

    var token
        get() = sharedPref.getString("access_token", null)
        set(value) = sharedPref.edit().putString("access_token", value).apply()


    var getEmail
        get() = sharedPref.getString("email", null)
        set(value) = sharedPref.edit().putString("email", value).apply()

    var getPass
        get() = (sharedPref.getString("password", null))
    set(value) = sharedPref.edit().putString("password", value).apply()

//    fun getUser(): LoginReq{
//        val user = LoginReq(sharedPref.getString("access_token", null))
//        return user
//    }

    fun logout(){
        editor = sharedPref.edit()
        editor.clear()
        editor.apply()
    }
}