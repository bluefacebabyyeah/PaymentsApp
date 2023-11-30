package com.example.data.api

import com.example.data.models.AuthDto
import com.example.data.models.PaymentsDto
import com.example.domain.models.AuthArgs
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface PaymentsApi{
    @POST("login")
    suspend fun logIn(@Body authArgs: AuthArgs): AuthDto

    @GET("payments")
    suspend fun getPayments(@Header("token") token: String): PaymentsDto
}