package com.example.data.storage

import android.content.SharedPreferences
import javax.inject.Inject

class AppStorage @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    companion object {
        private const val tokenKey = "token"
        private const val userNameKey = "username"
    }

    suspend fun storeToken(token: String?) =
        sharedPreferences.edit().putString(tokenKey, token).commit()

    suspend fun getToken() =
        sharedPreferences.getString(tokenKey, null)

    suspend fun storeUserName(userName: String?) =
        sharedPreferences.edit().putString(userNameKey, userName).commit()

    suspend fun getUserName() =
        sharedPreferences.getString(userNameKey, null)

}