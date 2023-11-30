package com.example.domain.repos

import com.example.domain.models.AuthArgs
import com.example.domain.models.AuthResult

interface IAuthRepo {

    suspend fun checkAuth(): Boolean

    suspend fun logIn(authArgs: AuthArgs): AuthResult

    suspend fun logOut()
}