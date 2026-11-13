package com.openai.errors

import com.openai.core.http.Headers
import java.util.Optional

open class OpenAIException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause) {

    @Transient private var responseHeaders: Headers? = null

    /**
     * Returns the headers of the HTTP response that caused this exception. A response with no
     * headers has a present, empty [Headers]. Absent if no response was available.
     */
    open fun headers(): Optional<Headers> = Optional.ofNullable(responseHeaders)

    @JvmSynthetic
    internal fun attachHeaders(headers: Headers) {
        responseHeaders = headers
    }
}
