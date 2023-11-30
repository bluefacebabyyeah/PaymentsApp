package com.example.domain.usecases

import com.example.domain.repos.IAuthRepo
import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    private val authRepo: IAuthRepo
){
    suspend fun logOut(){
        authRepo.logOut()
    }
}