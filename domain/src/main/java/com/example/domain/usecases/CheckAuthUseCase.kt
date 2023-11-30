package com.example.domain.usecases

import com.example.domain.repos.IAuthRepo
import javax.inject.Inject

class CheckAuthUseCase @Inject constructor(
    private val authRepo: IAuthRepo
) {
    suspend fun checkAuth(): Boolean {
        return authRepo.checkAuth()
    }
}