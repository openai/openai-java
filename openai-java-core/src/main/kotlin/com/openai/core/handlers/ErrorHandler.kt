// File generated from our OpenAPI spec by Stainless.

@file:JvmName("ErrorHandler")

package com.openai.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.errors.BadRequestException
import com.openai.errors.InternalServerException
import com.openai.errors.NotFoundException
import com.openai.errors.PermissionDeniedException
import com.openai.errors.RateLimitException
import com.openai.errors.UnauthorizedException
import com.openai.errors.UnexpectedStatusCodeException
import com.openai.errors.UnprocessableEntityException
import com.openai.models.ErrorObject

@JvmSynthetic
internal fun errorBodyHandler(jsonMapper: JsonMapper): Handler<ErrorObject?> {
    return object : Handler<ErrorObject?> {
        override fun handle(response: HttpResponse): ErrorObject? {
            val bodyBytes = try {
                response.body().readBytes()
            } catch (_: Exception) {
                return null
            }
            if (bodyBytes.isEmpty()) return null

            // Try to parse the body as JSON and extract the error object.
            try {
                val node = jsonMapper.readTree(bodyBytes)
                if (node != null) {
                    // Standard OpenAI format: {"error": {...}}
                    val errorNode = node.get("error") ?: node

                    // Try full deserialization first.
                    try {
                        return jsonMapper.readerFor(jacksonTypeRef<ErrorObject>()).readValue(errorNode)
                    } catch (_: Exception) {
                        // Full deserialization failed (e.g. non-standard field types from
                        // third-party OpenAI-compatible APIs like Google Gemini, which returns
                        // "code" as an integer instead of a string). Try extracting just the
                        // "message" field directly so callers still see a meaningful error.
                        val messageText = errorNode.get("message")
                            ?.takeIf { it.isTextual }
                            ?.textValue()
                        if (messageText != null) {
                            try {
                                val fallbackNode = jsonMapper.createObjectNode().put("message", messageText)
                                return jsonMapper.readerFor(jacksonTypeRef<ErrorObject>()).readValue(fallbackNode)
                            } catch (_: Exception) {
                                // ignore
                            }
                        }
                    }
                }
            } catch (_: Exception) {
                // JSON parsing failed – fall through to raw-body fallback below.
            }

            // Body is not valid JSON (or not an object): wrap the raw text as the message so
            // callers can see the actual server error instead of a useless "null".
            return try {
                val rawMessage = bodyBytes.toString(Charsets.UTF_8).trim()
                if (rawMessage.isNotEmpty()) {
                    val fallbackNode = jsonMapper.createObjectNode().put("message", rawMessage)
                    jsonMapper.readerFor(jacksonTypeRef<ErrorObject>()).readValue(fallbackNode)
                } else null
            } catch (_: Exception) {
                null
            }
        }
    }
}

@JvmSynthetic
internal fun errorHandler(errorBodyHandler: Handler<ErrorObject?>): Handler<HttpResponse> =
    object : Handler<HttpResponse> {
        override fun handle(response: HttpResponse): HttpResponse =
            when (val statusCode = response.statusCode()) {
                in 200..299 -> response
                400 ->
                    throw BadRequestException.builder()
                        .headers(response.headers())
                        .error(errorBodyHandler.handle(response))
                        .build()
                401 ->
                    throw UnauthorizedException.builder()
                        .headers(response.headers())
                        .error(errorBodyHandler.handle(response))
                        .build()
                403 ->
                    throw PermissionDeniedException.builder()
                        .headers(response.headers())
                        .error(errorBodyHandler.handle(response))
                        .build()
                404 ->
                    throw NotFoundException.builder()
                        .headers(response.headers())
                        .error(errorBodyHandler.handle(response))
                        .build()
                422 ->
                    throw UnprocessableEntityException.builder()
                        .headers(response.headers())
                        .error(errorBodyHandler.handle(response))
                        .build()
                429 ->
                    throw RateLimitException.builder()
                        .headers(response.headers())
                        .error(errorBodyHandler.handle(response))
                        .build()
                in 500..599 ->
                    throw InternalServerException.builder()
                        .statusCode(statusCode)
                        .headers(response.headers())
                        .error(errorBodyHandler.handle(response))
                        .build()
                else ->
                    throw UnexpectedStatusCodeException.builder()
                        .statusCode(statusCode)
                        .headers(response.headers())
                        .error(errorBodyHandler.handle(response))
                        .build()
            }
    }
