package com.example.paymentsapp.di

import com.example.data.api.PaymentsApi
import com.example.data.api.deserializers.PaymentsDtoSerializer
import com.example.data.models.PaymentsDto
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    companion object {
        const val API_URL = "https://easypay.world/api-test/"
    }

    @Provides
    fun provideApi(): PaymentsApi =
        Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create(
                GsonBuilder().registerTypeAdapter(PaymentsDto::class.java, PaymentsDtoSerializer())
                    .create()
            ))
            .client(OkHttpClient()
                .newBuilder()
                .addInterceptor { chain ->
                    val request: Request =
                        chain
                            .request()
                            .newBuilder()
                            .addHeader("v", "1")
                            .addHeader("app-key","12345")
                            .build()
                    chain.proceed(request)
                }
                .build())
            .build()
            .create(PaymentsApi::class.java)
}