package com.openai.core

import java.time.Duration

class RequestOptions private constructor(val responseValidation: Boolean?, val timeout: Duration?) {
    fun applyDefaults(options: RequestOptions): RequestOptions {
        return RequestOptions(
            responseValidation = this.responseValidation ?: options.responseValidation,
            timeout = this.timeout ?: options.timeout,
        )
    }

    companion object {

        private val NONE = builder().build()

        @JvmStatic fun none() = NONE

        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private var responseValidation: Boolean? = null
        private var timeout: Duration? = null

        fun responseValidation(responseValidation: Boolean) = apply {
            this.responseValidation = responseValidation
        }

        fun timeout(timeout: Duration) = apply { this.timeout = timeout }

        fun build(): RequestOptions {
            return RequestOptions(responseValidation, timeout)
        }
    }
}
