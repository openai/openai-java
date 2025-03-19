// File generated from our OpenAPI spec by Stainless.

package com.openai.errors

import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.jsonMapper
import com.openai.models.ErrorObject
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class UnauthorizedException
private constructor(
    private val headers: Headers,
    private val error: ErrorObject?,
    cause: Throwable?,
) : OpenAIServiceException("401: ${error?.message()}", cause) {

    override fun headers(): Headers = headers

    override fun statusCode(): Int = 401

    override fun body(): JsonValue =
        error?.let { JsonValue.fromJsonNode(jsonMapper().valueToTree(it)) } ?: JsonMissing.of()

    override fun code(): Optional<String> = Optional.ofNullable(error?.code()?.getOrNull())

    override fun param(): Optional<String> = Optional.ofNullable(error?.param()?.getOrNull())

    override fun type(): Optional<String> = Optional.ofNullable(error?.type())

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UnauthorizedException].
         *
         * The following fields are required:
         * ```java
         * .headers()
         * .error()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UnauthorizedException]. */
    class Builder internal constructor() {

        private var headers: Headers? = null
        private var error: ErrorObject? = null
        private var cause: Throwable? = null

        @JvmSynthetic
        internal fun from(unauthorizedException: UnauthorizedException) = apply {
            headers = unauthorizedException.headers
            error = unauthorizedException.error
            cause = unauthorizedException.cause
        }

        fun headers(headers: Headers) = apply { this.headers = headers }

        fun error(error: ErrorObject?) = apply { this.error = error }

        fun cause(cause: Throwable?) = apply { this.cause = cause }

        /** Alias for calling [Builder.cause] with `cause.orElse(null)`. */
        fun cause(cause: Optional<Throwable>) = cause(cause.getOrNull())

        /**
         * Returns an immutable instance of [UnauthorizedException].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .headers()
         * .error()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UnauthorizedException =
            UnauthorizedException(
                checkRequired("headers", headers),
                checkRequired("error", error),
                cause,
            )
    }
}
