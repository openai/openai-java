package com.openai.errors

import com.openai.core.http.Headers

abstract class OpenAIServiceException
@JvmOverloads
constructor(
    private val statusCode: Int,
    private val headers: Headers,
    private val body: String,
    private val error: OpenAIError,
    message: String = "$statusCode: $error",
    cause: Throwable? = null,
) : OpenAIException(message, cause) {

    fun statusCode(): Int = statusCode

    fun headers(): Headers = headers

    fun body(): String = body

    fun error(): OpenAIError = error
}
