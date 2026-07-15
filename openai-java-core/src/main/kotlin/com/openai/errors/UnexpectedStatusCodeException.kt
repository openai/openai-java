// File generated from our OpenAPI spec by Stainless.

package com.openai.errors

import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.jsonMapper
import com.openai.models.ErrorObject
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class UnexpectedStatusCodeException
private constructor(
    private val statusCode: Int,
    private val headers: Headers,
    private val error: JsonField<ErrorObject>,
    cause: Throwable?,
) :
    OpenAIServiceException(
        "$statusCode: ${error.asKnown().getOrNull()?._message()?.asKnown()?.getOrNull() ?: (if (error.isMissing()) "Unknown" else jsonMapper().writeValueAsString(error))}",
        cause,
    ) {

    override fun body(): JsonValue =
        if (error.isMissing()) JsonMissing.of()
        else JsonValue.fromJsonNode(jsonMapper().valueToTree(error))

    override fun code(): Optional<String> =
        Optional.ofNullable(error.asKnown().getOrNull()?.code()?.getOrNull())

    override fun param(): Optional<String> =
        Optional.ofNullable(error.asKnown().getOrNull()?.param()?.getOrNull())

    override fun type(): Optional<String> = Optional.ofNullable(error.asKnown().getOrNull()?.type())

    override fun statusCode(): Int = statusCode

    override fun headers(): Headers = headers

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [UnexpectedStatusCodeException].
         *
         * The following fields are required:
         * ```java
         * .statusCode()
         * .headers()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UnexpectedStatusCodeException]. */
    class Builder internal constructor() {

        private var statusCode: Int? = null
        private var headers: Headers? = null
        private var error: JsonField<ErrorObject> = JsonMissing.of()
        private var cause: Throwable? = null

        @JvmSynthetic
        internal fun from(unexpectedStatusCodeException: UnexpectedStatusCodeException) = apply {
            statusCode = unexpectedStatusCodeException.statusCode
            headers = unexpectedStatusCodeException.headers
            error = unexpectedStatusCodeException.error
            cause = unexpectedStatusCodeException.cause
        }

        fun statusCode(statusCode: Int) = apply { this.statusCode = statusCode }

        fun headers(headers: Headers) = apply { this.headers = headers }

        fun error(error: ErrorObject?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<ErrorObject>) = error(error.getOrNull())

        fun error(error: JsonField<ErrorObject>) = apply { this.error = error }

        fun cause(cause: Throwable?) = apply { this.cause = cause }

        /** Alias for calling [Builder.cause] with `cause.orElse(null)`. */
        fun cause(cause: Optional<Throwable>) = cause(cause.getOrNull())

        /**
         * Returns an immutable instance of [UnexpectedStatusCodeException].
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
        fun build(): UnexpectedStatusCodeException =
            UnexpectedStatusCodeException(
                checkRequired("statusCode", statusCode),
                checkRequired("headers", headers),
                error,
                cause,
            )
    }
}
