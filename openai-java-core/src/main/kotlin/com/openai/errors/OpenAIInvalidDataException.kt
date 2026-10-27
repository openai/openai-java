package com.openai.errors

import com.openai.core.http.Headers
import java.util.Optional

class OpenAIInvalidDataException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : OpenAIException(message, cause) {

    private var responseHeaders: Headers? = null

    /**
     * Returns headers retained when reading or parsing the HTTP response failed.
     *
     * Empty for failures before a response is available or outside response handling.
     */
    fun headers(): Optional<Headers> = Optional.ofNullable(responseHeaders)

    @JvmSynthetic internal fun withHeaders(headers: Headers) = apply { responseHeaders = headers }
}
