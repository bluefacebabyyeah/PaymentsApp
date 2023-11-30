package com.example.domain.usecases

import com.example.data.repos.AuthRepository
import com.example.domain.models.AuthResult
import javax.inject.Inject

class CheckAuthUseCase @Inject constructor(
    private val authRepo: AuthRepository
) {
    suspend fun checkAuth(): Boolean {
        return authRepo.checkAuth()
    }
}