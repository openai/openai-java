package com.openai.helpers

import com.openai.core.Params
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams

/** Per-connection GA Realtime options, including optional limits for slow consumers. */
class RealtimeWebSocketOptions
private constructor(
    @get:JvmName("maxMessageBytes") val maxMessageBytes: Int,
    @get:JvmName("maxQueuedBytes") val maxQueuedBytes: Long,
    @get:JvmName("maxQueuedEvents") val maxQueuedEvents: Int,
    @get:JvmName("reconnect") val reconnect: Boolean,
    @get:JvmName("maxReconnectAttempts") val maxReconnectAttempts: Int,
    @get:JvmName("reconnectDelayMillis") val reconnectDelayMillis: Long,
    @get:JvmName("maxPendingBytes") val maxPendingBytes: Long,
    internal val onReconnected: java.util.function.Consumer<RealtimeConnection>?,
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
        private var reconnect = false
        private var maxReconnectAttempts = 5
        private var reconnectDelayMillis = 500L
        private var maxPendingBytes = 0L
        private var onReconnected: java.util.function.Consumer<RealtimeConnection>? = null
        private val headers = Headers.builder()
        private val queryParams = QueryParams.builder()

        /** Overrides the inherited model for this socket. */
        fun model(value: String) = apply { queryParams.replace("model", value) }

        /** Joins an existing call. */
        fun callId(value: String) = apply { queryParams.replace("call_id", value) }

        /** Selects transcription mode for this GA connection. */
        fun transcription() = apply { queryParams.replace("intent", "transcription") }

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

        /** Enable bounded recovery of model sessions. Default: false. No command is replayed. */
        fun reconnect(value: Boolean) = apply { reconnect = value }

        /** Additional attempts over the logical connection's lifetime. Default: 5. */
        fun maxReconnectAttempts(value: Int) = apply {
            require(value >= 0)
            maxReconnectAttempts = value
        }

        /** Initial backoff, doubled up to eight seconds. Default: 500 milliseconds. */
        fun reconnectDelayMillis(value: Long) = apply {
            require(value in 0..8000)
            reconnectDelayMillis = value
        }

        /** Encoded bytes retained during recovery until explicitly flushed. Default: 0. */
        fun maxPendingBytes(value: Long) = apply {
            require(value >= 0)
            maxPendingBytes = value
        }

        /** Restore application-owned session state before explicitly flushing pending commands. */
        fun onReconnected(value: java.util.function.Consumer<RealtimeConnection>) = apply {
            onReconnected = value
        }

        fun build() =
            RealtimeWebSocketOptions(
                maxMessageBytes,
                maxQueuedBytes,
                maxQueuedEvents,
                reconnect,
                maxReconnectAttempts,
                reconnectDelayMillis,
                maxPendingBytes,
                onReconnected,
                headers.build(),
                queryParams.build(),
            )
    }
}
