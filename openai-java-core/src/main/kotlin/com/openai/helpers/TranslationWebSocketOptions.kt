package com.openai.helpers

import com.openai.core.Params
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams

/** Per-connection Translation options, including optional limits for slow consumers. */
class TranslationWebSocketOptions
private constructor(
    @get:JvmName("maxMessageBytes") val maxMessageBytes: Int,
    @get:JvmName("maxQueuedBytes") val maxQueuedBytes: Long,
    @get:JvmName("maxQueuedEvents") val maxQueuedEvents: Int,
    private val headers: Headers,
    private val queryParams: QueryParams,
) : Params {
    override fun _headers() = headers

    override fun _queryParams() = queryParams

    companion object {
        @JvmStatic fun builder() = Builder()

        @JvmStatic fun defaults() = builder().build()
    }

    class Builder internal constructor() {
        private var maxMessageBytes = Int.MAX_VALUE
        private var maxQueuedBytes = Long.MAX_VALUE
        private var maxQueuedEvents = Int.MAX_VALUE
        private val headers = Headers.builder()
        private val queryParams = QueryParams.builder()

        /** Overrides the inherited model for this socket. */
        fun model(value: String) = apply { queryParams.replace("model", value) }

        fun putHeader(name: String, value: String) = apply { headers.put(name, value) }

        fun putQueryParam(name: String, value: String) = apply { queryParams.put(name, value) }

        fun maxMessageBytes(value: Int) = apply {
            require(value > 0)
            maxMessageBytes = value
        }

        fun maxQueuedBytes(value: Long) = apply {
            require(value > 0)
            maxQueuedBytes = value
        }

        fun maxQueuedEvents(value: Int) = apply {
            require(value > 0)
            maxQueuedEvents = value
        }

        fun build() =
            TranslationWebSocketOptions(
                maxMessageBytes,
                maxQueuedBytes,
                maxQueuedEvents,
                headers.build(),
                queryParams.build(),
            )
    }
}
