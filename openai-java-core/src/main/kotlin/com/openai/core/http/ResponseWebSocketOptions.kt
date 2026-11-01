package com.openai.core.http

import com.openai.core.Params

/** Configurable bounds for a Responses connection, including all of its lanes. */
class ResponseWebSocketOptions
private constructor(
    @get:JvmName("maxMessageBytes") val maxMessageBytes: Int,
    @get:JvmName("maxQueuedBytes") val maxQueuedBytes: Long,
    @get:JvmName("maxQueuedEvents") val maxQueuedEvents: Int,
    @get:JvmName("maxLanes") val maxLanes: Int,
    @get:JvmName("maxPendingSends") val maxPendingSends: Int,
    @get:JvmName("maxResponseBytes") val maxResponseBytes: Long?,
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
        private var maxLanes = 64
        private var maxPendingSends = 1
        private var maxResponseBytes: Long? = null
        private val headers = Headers.builder()
        private val queryParams = QueryParams.builder()

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
         * Maximum named lane IDs reserved on one socket, including closed lanes (default 64).
         * Excludes the default lane. Reconnect releases closed reservations and retains open lanes.
         */
        fun maxLanes(value: Int) = apply {
            require(value > 0)
            maxLanes = value
        }

        /** Maximum commands admitted concurrently for serialization and send preparation. */
        fun maxPendingSends(value: Int) = apply {
            require(value > 0)
            maxPendingSends = value
        }

        /**
         * Enables automatic final-response collection with this positive per-response budget.
         * Counts original UTF-8 wire bytes for consumed created, output-item-done and terminal
         * events. Deltas remain raw events and are not retained by the collector. Overflow fails
         * only collection on that lane; raw reads and other lanes remain usable. Unset by default.
         */
        fun maxResponseBytes(value: Long) = apply {
            require(value > 0)
            maxResponseBytes = value
        }

        fun putHeader(name: String, value: String) = apply { headers.put(name, value) }

        fun putQueryParam(name: String, value: String) = apply { queryParams.put(name, value) }

        fun build() =
            ResponseWebSocketOptions(
                maxMessageBytes,
                maxQueuedBytes,
                maxQueuedEvents,
                maxLanes,
                maxPendingSends,
                maxResponseBytes,
                headers.build(),
                queryParams.build(),
            )
    }
}
