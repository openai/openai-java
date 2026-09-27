package com.openai.core.http

import com.openai.core.RequestOptions
import java.util.concurrent.CompletableFuture

/** Optional transport capability. HTTP-only clients need not implement this interface. */
interface WebSocketClient {
    /**
     * Opens one connection using the prepared endpoint and headers, including authentication.
     * Implementations must serialize listener callbacks, enforce [maxMessageBytes] before listener
     * delivery, and bound pending application writes. The standard OkHttp transport checks the
     * receive limit after whole-message assembly and decompression; it is not an allocation bound.
     * Canceling the returned future must release an opening socket. Do not replay commands or
     * follow redirects.
     */
    fun connectWebSocket(
        request: HttpRequest,
        options: RequestOptions,
        maxMessageBytes: Int,
        listener: Listener,
    ): CompletableFuture<Connection>

    interface Connection : AutoCloseable {
        /**
         * Enqueues one complete message, or throws if closed or the send buffer is full. The
         * standard OkHttp transport rejects empty text; Responses commands must contain JSON.
         */
        fun send(text: String)

        /**
         * Releases this socket only; it does not close the shared HTTP client or its executor. The
         * standard transport aborts without waiting for a running listener; terminal notification
         * remains serialized after that listener returns.
         */
        override fun close()
    }

    interface Listener {
        fun onMessage(text: String)

        fun onClosed(code: Int)

        fun onFailure(error: Throwable)
    }
}
