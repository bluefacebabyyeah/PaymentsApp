package com.example.domain.models

data class Payments(
    val user: User,
    val id: Int,
    val title: String,
    val amount: Double?,
    val created: Int
)
