package com.example.domain.usecases

import com.example.data.repos.AuthRepository
import com.example.domain.models.AuthArgs
import com.example.domain.models.AuthResult
import javax.inject.Inject

class LogInUseCase @Inject constructor(
    private val authRepo: AuthRepository
) {
    suspend fun logIn(authArgs: AuthArgs): AuthResult {
        return authRepo.logIn(authArgs)
    }
}