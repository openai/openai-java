package com.openai.core.http

import com.openai.core.RequestOptions
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeoutException

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

    /** Optional ability to observe capacity without enqueueing an application message. */
    interface WritableConnection : Connection {
        /**
         * Wait until the transport can accept another complete message, or throw on timeout,
         * interruption or closure. Readiness is advisory; another writer may win admission. Does
         * not reserve capacity or consume any server event.
         */
        @Throws(TimeoutException::class, InterruptedException::class)
        fun awaitWritable(timeout: Duration)
    }

    interface Listener {
        fun onMessage(text: String)

        fun onClosed(code: Int)

        fun onFailure(error: Throwable)
    }
}

// Match String's UTF-8 encoding, including its one-byte replacement for unpaired surrogates,
// without allocating a second payload while the event is retained.
@JvmSynthetic
internal fun utf8Size(text: String): Long {
    var bytes = 0L
    var index = 0
    while (index < text.length) {
        val char = text[index++]
        bytes +=
            when {
                char < '\u0080' -> 1
                char < '\u0800' -> 2
                char !in '\uD800'..'\uDFFF' -> 3
                char <= '\uDBFF' && index < text.length && text[index] in '\uDC00'..'\uDFFF' -> {
                    index++
                    4
                }
                else -> 1
            }
    }
    return bytes
}
