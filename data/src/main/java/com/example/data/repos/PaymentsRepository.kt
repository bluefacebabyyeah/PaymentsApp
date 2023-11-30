package com.example.data.repos

import com.example.data.api.PaymentsApi
import com.example.data.storage.AppStorage
import com.example.domain.models.Payments
import com.example.domain.models.User
import com.example.domain.repos.IPaymentsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PaymentsRepository @Inject constructor(
    val api: PaymentsApi,
    val appStorage: AppStorage
) : IPaymentsRepo {
    override suspend fun getPayments(): List<Payments>{
        return withContext(Dispatchers.IO){
            val response = api.getPayments(appStorage.getToken().toString())
            response.response.map {
                Payments(
                    User(appStorage.getUserName().toString()),
                    it.id,
                    it.title,
                    it.amount,
                    it.created
                )
            }
        }
    }
}