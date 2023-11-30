package com.example.domain.repos

import com.example.domain.models.Payments

interface IPaymentsRepo {
    suspend fun getPayments(): List<Payments>
}