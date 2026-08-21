package com.openai.errors

import com.openai.core.http.Headers
import java.util.Optional

class OpenAIInvalidDataException
@JvmOverloads
constructor(
    message: String? = null,
    cause: Throwable? = null,
    private val headers: Headers? = null,
) : OpenAIException(message, cause) {

    fun headers(): Optional<Headers> = Optional.ofNullable(headers)
}
