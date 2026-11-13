package com.openai.errors

import com.openai.core.http.Headers
import java.util.Optional

class OpenAIIoException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : OpenAIException(message, cause) {

    override fun headers(): Optional<Headers> = super.headers()

    @JvmSynthetic internal fun withHeaders(headers: Headers) = apply { attachHeaders(headers) }
}
