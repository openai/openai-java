package com.openai.helpers

import com.openai.core.Params
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import java.time.Duration

/** Per-connection Translation options, including optional limits for slow consumers. */
class TranslationWebSocketOptions
private constructor(
    @get:JvmName("maxMessageBytes") val maxMessageBytes: Int,
    @get:JvmName("maxQueuedBytes") val maxQueuedBytes: Long,
    @get:JvmName("maxQueuedEvents") val maxQueuedEvents: Int,
    @get:JvmName("sendTimeout") val sendTimeout: Duration?,
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
        private var sendTimeout: Duration? = null
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

        /**
         * Optional deadline for a Translation audio/session send, including serialization and
         * admission. Defaults to the existing immediate transport send. Null restores that default.
         * A timeout closes only this socket; no possibly attempted write is replayed.
         */
        fun sendTimeout(value: Duration?) = apply {
            require(value == null || (!value.isZero && !value.isNegative)) {
                "Translation sendTimeout must be positive"
            }
            value?.toNanos()
            sendTimeout = value
        }

        fun build() =
            TranslationWebSocketOptions(
                maxMessageBytes,
                maxQueuedBytes,
                maxQueuedEvents,
                sendTimeout,
                headers.build(),
                queryParams.build(),
            )
    }
}
