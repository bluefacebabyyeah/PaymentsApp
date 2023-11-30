package com.example.domain.usecases

import com.example.data.repos.AuthRepository
import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    private val authRepo: AuthRepository
){
    suspend fun logOut(){
        authRepo.logOut()
    }
}