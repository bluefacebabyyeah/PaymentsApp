package com.example.data.repos

import com.example.data.api.PaymentsApi
import com.example.domain.models.AuthArgs
import com.example.domain.models.AuthResult
import com.example.domain.repos.IAuthRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val dao: AuthArgsDao,
    private val api: PaymentsApi,
    private val authResult: AuthResult?
) : IAuthRepo {
    override suspend fun checkAuth(): Boolean {
        return authResult == null
    }

    override suspend fun logIn(authArgs: AuthArgs): AuthResult {
        return if (checkAuth())
            withContext(Dispatchers.IO){
                api.getAuthResultDto.toAuthResult
            }
        else
            return AuthResult(null)
    }

    override suspend fun logOut(){
        //TODO
    }
}