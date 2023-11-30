package com.example.domain.usecases

import com.example.domain.models.Payments
import com.example.domain.repos.IPaymentsRepo
import javax.inject.Inject

class GetPaymentsUseCase @Inject constructor(
    private val paymentsRepo: IPaymentsRepo
) {
    suspend fun getPayments(): List<Payments>{
        return paymentsRepo.getPayments()
    }
}