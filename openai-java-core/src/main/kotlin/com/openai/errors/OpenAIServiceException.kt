// File generated from our OpenAPI spec by Stainless.

package com.openai.errors

import com.openai.core.JsonValue
import com.openai.core.http.Headers
import java.util.Optional

abstract class OpenAIServiceException
protected constructor(message: String, cause: Throwable? = null) : OpenAIException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue

    abstract fun code(): Optional<String>

    abstract fun param(): Optional<String>

    abstract fun type(): Optional<String>
}
