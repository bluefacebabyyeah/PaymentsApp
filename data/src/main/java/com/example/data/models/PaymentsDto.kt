package com.example.data.models

data class PaymentsDto(
    val response: List<Response>
) {
    data class Response(
        val id : Int,
        val title: String,
        val amount: Double?,
        val created: Int?
    )
}