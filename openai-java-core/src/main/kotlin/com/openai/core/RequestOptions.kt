package com.openai.core

import java.time.Duration

class RequestOptions private constructor(val responseValidation: Boolean?, val timeout: Timeout?) {

    companion object {

        private val NONE = builder().build()

        @JvmStatic fun none() = NONE

        @JvmSynthetic
        internal fun from(clientOptions: ClientOptions): RequestOptions =
            builder()
                .responseValidation(clientOptions.responseValidation)
                .timeout(clientOptions.timeout)
                .build()

        @JvmStatic fun builder() = Builder()
    }

    fun applyDefaults(options: RequestOptions): RequestOptions =
        RequestOptions(
            responseValidation = responseValidation ?: options.responseValidation,
            timeout =
                if (options.timeout != null && timeout != null) timeout.assign(options.timeout)
                else timeout ?: options.timeout,
        )

    class Builder internal constructor() {

        private var responseValidation: Boolean? = null
        private var timeout: Timeout? = null

        fun responseValidation(responseValidation: Boolean) = apply {
            this.responseValidation = responseValidation
        }

        fun timeout(timeout: Timeout) = apply { this.timeout = timeout }

        fun timeout(timeout: Duration) = timeout(Timeout.builder().request(timeout).build())

        fun build(): RequestOptions = RequestOptions(responseValidation, timeout)
    }
}
