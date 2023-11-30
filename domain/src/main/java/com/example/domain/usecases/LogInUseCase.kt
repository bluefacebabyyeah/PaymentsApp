package com.example.domain.usecases

import com.example.domain.models.AuthArgs
import com.example.domain.models.AuthResult
import com.example.domain.repos.IAuthRepo
import javax.inject.Inject

class LogInUseCase @Inject constructor(
    private val authRepo: IAuthRepo
) {
    suspend fun logIn(authArgs: AuthArgs): AuthResult {
        return authRepo.logIn(authArgs)
    }
}