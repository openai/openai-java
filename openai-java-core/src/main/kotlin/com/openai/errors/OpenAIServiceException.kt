package com.openai.errors

import com.openai.core.JsonValue
import com.openai.core.http.Headers
import java.util.Optional

abstract class OpenAIServiceException
protected constructor(message: String, cause: Throwable? = null) : OpenAIException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    /**
     * Returns the first `x-request-id` response header, or an empty [Optional] if absent. This is
     * the server request ID, not the caller's `X-Client-Request-Id`.
     */
    open fun requestId(): Optional<String> =
        Optional.ofNullable(headers().values("x-request-id").firstOrNull())

    abstract fun body(): JsonValue

    abstract fun code(): Optional<String>

    abstract fun param(): Optional<String>

    abstract fun type(): Optional<String>
}
