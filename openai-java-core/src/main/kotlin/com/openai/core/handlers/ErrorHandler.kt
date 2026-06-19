// File generated from our OpenAPI spec by Stainless.

@file:JvmName("ErrorHandler")

package com.openai.core.handlers

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
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
internal fun errorBodyHandler(jsonMapper: JsonMapper): Handler<JsonField<ErrorObject>> {
    val handler = jsonHandler<JsonNode>(jsonMapper)

    return object : Handler<JsonField<ErrorObject>> {
        override fun handle(response: HttpResponse): JsonField<ErrorObject> =
            try {
                val node = handler.handle(response)
                node.get("error")?.let {
                    jsonMapper.readerFor(jacksonTypeRef<JsonField<ErrorObject>>()).readValue(it)
                } ?: JsonValue.fromJsonNode(node)
            } catch (e: Exception) {
                JsonMissing.of()
            }
    }
}

@JvmSynthetic
internal fun errorHandler(
    errorBodyHandler: Handler<JsonField<ErrorObject>>
): Handler<HttpResponse> =
    object : Handler<HttpResponse> {
        override fun handle(response: HttpResponse): HttpResponse {
            val statusCode = response.statusCode()
            if (statusCode in 200..299) {
                return response
            }

            return response.use {
                val headers = it.headers()
                val error = errorBodyHandler.handle(it)

                when (statusCode) {
                    400 -> throw BadRequestException.builder().headers(headers).error(error).build()
                    401 ->
                        throw UnauthorizedException.builder().headers(headers).error(error).build()
                    403 ->
                        throw PermissionDeniedException.builder()
                            .headers(headers)
                            .error(error)
                            .build()
                    404 -> throw NotFoundException.builder().headers(headers).error(error).build()
                    422 ->
                        throw UnprocessableEntityException.builder()
                            .headers(headers)
                            .error(error)
                            .build()
                    429 -> throw RateLimitException.builder().headers(headers).error(error).build()
                    in 500..599 ->
                        throw InternalServerException.builder()
                            .statusCode(statusCode)
                            .headers(headers)
                            .error(error)
                            .build()
                    else ->
                        throw UnexpectedStatusCodeException.builder()
                            .statusCode(statusCode)
                            .headers(headers)
                            .error(error)
                            .build()
                }
            }
        }
    }
