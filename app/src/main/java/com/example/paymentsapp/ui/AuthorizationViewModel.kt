package com.example.paymentsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.AuthArgs
import com.example.domain.models.AuthResult
import com.example.domain.models.User
import com.example.domain.usecases.CheckAuthUseCase
import com.example.domain.usecases.LogInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val logInUseCase: LogInUseCase,
    private val checkAuthUseCase: CheckAuthUseCase
) : ViewModel(){
    val user = MutableLiveData<User?>()
    val authorization = MutableLiveData<AuthResult>()
    val error = MutableLiveData<String?>()

    fun logIn(authArgs: AuthArgs){
        viewModelScope.launch {
            //TODO
        }
    }

    fun checkAuth(authResult: AuthResult){
        viewModelScope.launch {
            //TODO
        }
    }
}