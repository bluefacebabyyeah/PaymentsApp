package com.example.data.api.deserializers

import com.example.data.models.PaymentsDto
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class PaymentsDtoSerializer : JsonDeserializer<PaymentsDto> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): PaymentsDto {
        val jsonObject = json as JsonObject
        val response = jsonObject.get("response").asJsonArray
        val result = PaymentsDto(
            response = response.map {
                PaymentsDto.Response(
                    id = it.asJsonObject.get("id").asInt,
                    title = it.asJsonObject.get("title").asString,
                    amount = it.asJsonObject.run {
                        if ("amount" in keySet()) get("amount").run {
                            try { this.asDouble } catch (e: Exception) { this.asString.toDoubleOrNull() ?: 0.0 }
                        } else null
                    },
                    created = it.asJsonObject.run {
                        if ("created" in keySet()) get("created").asInt else null
                    }
                )
            }
        )
        return result
    }
}