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
        override fun handle(response: HttpResponse): HttpResponse =
            when (val statusCode = response.statusCode()) {
                in 200..299 -> response
                400 ->
                    response.use {
                        throw BadRequestException.builder()
                            .headers(it.headers())
                            .error(errorBodyHandler.handle(it))
                            .build()
                    }
                401 ->
                    response.use {
                        throw UnauthorizedException.builder()
                            .headers(it.headers())
                            .error(errorBodyHandler.handle(it))
                            .build()
                    }
                403 ->
                    response.use {
                        throw PermissionDeniedException.builder()
                            .headers(it.headers())
                            .error(errorBodyHandler.handle(it))
                            .build()
                    }
                404 ->
                    response.use {
                        throw NotFoundException.builder()
                            .headers(it.headers())
                            .error(errorBodyHandler.handle(it))
                            .build()
                    }
                422 ->
                    response.use {
                        throw UnprocessableEntityException.builder()
                            .headers(it.headers())
                            .error(errorBodyHandler.handle(it))
                            .build()
                    }
                429 ->
                    response.use {
                        throw RateLimitException.builder()
                            .headers(it.headers())
                            .error(errorBodyHandler.handle(it))
                            .build()
                    }
                in 500..599 ->
                    response.use {
                        throw InternalServerException.builder()
                            .statusCode(statusCode)
                            .headers(it.headers())
                            .error(errorBodyHandler.handle(it))
                            .build()
                    }
                else ->
                    response.use {
                        throw UnexpectedStatusCodeException.builder()
                            .statusCode(statusCode)
                            .headers(it.headers())
                            .error(errorBodyHandler.handle(it))
                            .build()
                    }
            }
    }
