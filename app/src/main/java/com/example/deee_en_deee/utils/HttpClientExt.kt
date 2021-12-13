package com.example.deee_en_deee.utils

import io.ktor.client.*
import io.ktor.http.cio.*
import io.ktor.client.request.*
import io.ktor.utils.io.core.*

suspend inline fun <reified ResponseType: Any> HttpClient.get(
    url: String,
    parameters: List<UrlParameter> = listOf()
): Result<ResponseType> {
    return try {
        this@get.use { client ->
            val response = client.get<String> {
                url(url)
                parameters.forEach { parameter(it.key, it.value)}
            }

            val responseObject: ResponseType = response.fromJsonString()
            Result.success(responseObject)
        }
    } catch (e: Throwable) {
        Result.failure(e)
    }
}