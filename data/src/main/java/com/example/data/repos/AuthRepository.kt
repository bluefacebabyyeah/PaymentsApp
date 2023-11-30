package com.example.data.repos

import com.example.data.api.PaymentsApi
import com.example.data.storage.AppStorage
import com.example.domain.models.AuthArgs
import com.example.domain.models.AuthResult
import com.example.domain.models.User
import com.example.domain.repos.IAuthRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val api: PaymentsApi,
    private val appStorage: AppStorage
) : IAuthRepo {

    override suspend fun checkAuth(): Boolean {
        return withContext(Dispatchers.IO){
            appStorage.getToken()!=null
        }
    }

    override suspend fun logIn(authArgs: AuthArgs): AuthResult {
        return if (!checkAuth())
            withContext(Dispatchers.IO){
                val response = api.logIn(authArgs)
                if (response.response != null){
                    val token = response.response.token
                    appStorage.storeToken(token)
                    appStorage.storeUserName(authArgs.login)
                    AuthResult(
                        User(
                            authArgs.login
                        )
                    )
                }
                else AuthResult(
                    null
                )
            }
        else
            AuthResult(null)
    }

    override suspend fun logOut(){
        withContext(Dispatchers.IO){
            appStorage.storeToken(null)
            appStorage.storeUserName(null)
        }
    }
}