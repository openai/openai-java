package com.openai.errors

import com.openai.core.http.Headers
import java.util.Optional

class OpenAIIoException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : OpenAIException(message, cause) {

    private var responseHeaders: Headers? = null

    internal constructor(message: String?, cause: Throwable?, headers: Headers) : this(message, cause) {
        responseHeaders = headers
    }

    fun headers(): Optional<Headers> = Optional.ofNullable(responseHeaders)
}
