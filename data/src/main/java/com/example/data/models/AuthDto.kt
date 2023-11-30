package com.example.data.models

data class AuthDto(
    val success: Boolean,
    val response: Response?
) {
    data class Response(
        val token: String
    )
}