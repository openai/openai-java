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

class InternalServerException
private constructor(
    private val statusCode: Int,
    private val headers: Headers,
    private val error: ErrorObject?,
    cause: Throwable?,
) : OpenAIServiceException("$statusCode: ${error?.message()}", cause) {

    override fun body(): JsonValue =
        error?.let { JsonValue.fromJsonNode(jsonMapper().valueToTree(it)) } ?: JsonMissing.of()

    override fun code(): Optional<String> = Optional.ofNullable(error?.code()?.getOrNull())

    override fun param(): Optional<String> = Optional.ofNullable(error?.param()?.getOrNull())

    override fun type(): Optional<String> = Optional.ofNullable(error?.type())

    override fun statusCode(): Int = statusCode

    override fun headers(): Headers = headers

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InternalServerException].
         *
         * The following fields are required:
         * ```java
         * .statusCode()
         * .headers()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InternalServerException]. */
    class Builder internal constructor() {

        private var statusCode: Int? = null
        private var headers: Headers? = null
        private var error: ErrorObject? = null
        private var cause: Throwable? = null

        @JvmSynthetic
        internal fun from(internalServerException: InternalServerException) = apply {
            statusCode = internalServerException.statusCode
            headers = internalServerException.headers
            error = internalServerException.error
            cause = internalServerException.cause
        }

        fun statusCode(statusCode: Int) = apply { this.statusCode = statusCode }

        fun headers(headers: Headers) = apply { this.headers = headers }

        fun error(error: ErrorObject?) = apply { this.error = error }

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<ErrorObject>) = error(error.getOrNull())

        fun cause(cause: Throwable?) = apply { this.cause = cause }

        /** Alias for calling [Builder.cause] with `cause.orElse(null)`. */
        fun cause(cause: Optional<Throwable>) = cause(cause.getOrNull())

        /**
         * Returns an immutable instance of [InternalServerException].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .statusCode()
         * .headers()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InternalServerException =
            InternalServerException(
                checkRequired("statusCode", statusCode),
                checkRequired("headers", headers),
                error,
                cause,
            )
    }
}
