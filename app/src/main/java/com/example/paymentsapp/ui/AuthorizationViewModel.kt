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

    val authorized = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>(false)
    val error = MutableLiveData<String?>()
    fun logIn(authArgs: AuthArgs){
        viewModelScope.launch {
            loading.value = true
            try {
                val result = logInUseCase.logIn(authArgs)
                authorized.value = result.user != null
                if (result.user == null)
                    error.value = "Incorrect credentials"
            } catch (e: Exception) {
                e.printStackTrace()
                error.value = "Unknown error has occurred"
            }
            loading.value = false
        }
    }

    fun checkAuth(){
        viewModelScope.launch {
            authorized.value = checkAuthUseCase.checkAuth()
        }
    }
}