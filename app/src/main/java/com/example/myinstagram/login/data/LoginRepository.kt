package com.example.myinstagram.login.data

import android.util.Log
import com.example.myinstagram.login.data.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val api: LoginService
) {
    suspend fun doLogin(user: String, password: String): Boolean{
        return api.doLogin(user, password)
    }
}