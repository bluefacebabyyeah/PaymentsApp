package com.example.paymentsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Payments
import com.example.domain.usecases.GetPaymentsUseCase
import com.example.domain.usecases.LogOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentsViewModel @Inject constructor(
    private val logOutUseCase: LogOutUseCase,
    private val getPaymentsUseCase: GetPaymentsUseCase,
) : ViewModel() {
    val items = MutableLiveData<List<Payments>>()
    val error = MutableLiveData<String?>()
    val loading = MutableLiveData<Boolean>(false)

    fun loadItems() {
        viewModelScope.launch {
            loading.value = true
            try {
                items.value = getPaymentsUseCase.getPayments()
            } catch (e: Exception) {
                e.printStackTrace()
                error.value = "Unknown error has occurred"
            }
            loading.value = false
        }
    }

    fun logOut(){
        viewModelScope.launch {
            logOutUseCase.logOut()
        }
    }
}