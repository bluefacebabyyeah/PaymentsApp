package com.example.paymentsapp.di

import com.example.data.repos.AuthRepository
import com.example.data.repos.PaymentsRepository
import com.example.domain.repos.IAuthRepo
import com.example.domain.repos.IPaymentsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {
    @Binds
    @Singleton
    fun bindsAuthRepo(authRepo: AuthRepository): IAuthRepo

    @Binds
    @Singleton
    fun bindsPaymentsRepo(paymentsRepository: PaymentsRepository): IPaymentsRepo
}