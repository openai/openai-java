package com.openai.client.okhttp

import com.openai.core.RequestOptions
import com.openai.core.http.WebSocketClient
import com.openai.core.http.WebSocketHandshakeException
import java.io.IOException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicReference
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import okio.utf8Size

/**
 * Uses the HTTP client's transport policy; receive limits apply after OkHttp assembles a message.
 */
internal object BoundedWebSocket {
    fun connect(
        client: okhttp3.OkHttpClient,
        request: okhttp3.Request,
        options: RequestOptions,
        maxMessageBytes: Int,
        listener: WebSocketClient.Listener,
    ): CompletableFuture<WebSocketClient.Connection> {
        require(request.header("Sec-WebSocket-Extensions") == null) {
            "Sec-WebSocket-Extensions is managed by OkHttp and cannot be supplied"
        }
        // OkHttp skips network interceptors for upgrades. The SDK redirect guard is unnecessary
        // because redirects are disabled here; never silently bypass a caller's policy.
        require(client.networkInterceptors.all { it === OkHttpClient.apiKeyRedirectInterceptor }) {
            "WebSockets do not support OkHttp network interceptors"
        }
        require(
            client.authenticator === okhttp3.Authenticator.NONE &&
                client.proxyAuthenticator === okhttp3.Authenticator.NONE
        ) {
            "WebSockets do not support OkHttp challenge authenticators"
        }
        val connectDuration =
            options.timeout?.connect()
                ?: java.time.Duration.ofMillis(client.connectTimeoutMillis.toLong())
        val writeDuration =
            options.timeout?.write()
                ?: java.time.Duration.ofMillis(client.writeTimeoutMillis.toLong())
        val readDuration =
            options.timeout?.read()
                ?: java.time.Duration.ofMillis(client.readTimeoutMillis.toLong())
        val requestDuration =
            options.timeout?.request()
                ?: java.time.Duration.ofMillis(client.callTimeoutMillis.toLong())
        require(
            !connectDuration.isNegative &&
                !writeDuration.isNegative &&
                !readDuration.isNegative &&
                !requestDuration.isNegative
        ) {
            "Timeouts must be nonnegative"
        }
        val timeout =
            if (connectDuration.isZero) 0
            else connectDuration.toMillis().coerceIn(1, Int.MAX_VALUE.toLong()).toInt()
        val writeTimeout =
            if (writeDuration.isZero) 0
            else writeDuration.toMillis().coerceIn(1, Int.MAX_VALUE.toLong()).toInt()
        val deadlineMillis =
            listOf(connectDuration, requestDuration)
                .filterNot { it.isZero }
                .map { it.toMillis().coerceAtLeast(1) }
                .minOrNull()
        // A native WebSocket occupies its dispatcher until its reader exits. Keep that
        // lifetime off the HTTP dispatcher, including any caller-supplied bounded executor.
        val dispatcher =
            okhttp3.Dispatcher(
                java.util.concurrent.Executors.newCachedThreadPool { runnable ->
                    Thread(runnable, "openai-websocket").apply { isDaemon = true }
                }
            )
        val transport =
            client
                .newBuilder()
                .dispatcher(dispatcher)
                .followRedirects(false)
                .followSslRedirects(false)
                .retryOnConnectionFailure(false)
                .connectTimeout(timeout.toLong(), TimeUnit.MILLISECONDS)
                .writeTimeout(writeTimeout.toLong(), TimeUnit.MILLISECONDS)
                .readTimeout(readDuration)
                .callTimeout(0, TimeUnit.MILLISECONDS)
                .apply {
                    // Disable compression before the native reader can inflate a message.
                    addInterceptor { chain ->
                        val response =
                            chain.proceed(
                                chain
                                    .request()
                                    .newBuilder()
                                    .removeHeader("Sec-WebSocket-Extensions")
                                    .build()
                            )
                        if (
                            response.code == 101 &&
                                response.headers("Sec-WebSocket-Extensions").isNotEmpty()
                        ) {
                            chain.call().cancel()
                            response.close()
                            throw IOException("WebSocket extensions are disabled")
                        }
                        response
                    }
                }
                .build()
        val result = CompletableFuture<WebSocketClient.Connection>()
        val ended = AtomicBoolean()
        val openingClaimed = AtomicBoolean()
        val native = AtomicReference<WebSocket>()
        val closeDeadline = AtomicReference<java.util.concurrent.ScheduledFuture<*>>()
        val callbacks = Any()
        fun stop(notifyClosed: Int? = null) {
            ended.set(true)
            closeDeadline.getAndSet(null)?.cancel(false)
            try {
                native.get()?.cancel()
            } finally {
                synchronized(dispatcher) {
                    try {
                        if (notifyClosed != null) {
                            dispatcher.executorService.execute {
                                synchronized(callbacks) { listener.onClosed(notifyClosed) }
                            }
                        }
                    } finally {
                        dispatcher.executorService.shutdown()
                    }
                }
            }
        }
        fun fail(error: Throwable) {
            synchronized(callbacks) {
                if (ended.compareAndSet(false, true)) {
                    stop()
                    result.completeExceptionally(error)
                    listener.onFailure(error)
                }
            }
        }
        val deadline =
            deadlineMillis?.let { milliseconds ->
                timer.schedule(
                    {
                        // Claim the timeout before dispatching completion. A synchronous
                        // future continuation must not occupy the shared deadline timer.
                        val timedOut =
                            synchronized(dispatcher) {
                                if (
                                    openingClaimed.compareAndSet(false, true) &&
                                        ended.compareAndSet(false, true)
                                ) {
                                    dispatcher.executorService.execute {
                                        result.completeExceptionally(
                                            IOException("WebSocket handshake timed out")
                                        )
                                    }
                                    true
                                } else false
                            }
                        if (timedOut) stop()
                    },
                    milliseconds,
                    TimeUnit.MILLISECONDS,
                )
            }
        result.whenComplete { _, error ->
            deadline?.cancel(false)
            if (error != null) stop()
        }
        val socket =
            try {
                transport.newWebSocket(
                    request,
                    object : WebSocketListener() {
                        override fun onOpen(webSocket: WebSocket, response: Response) {
                            native.set(webSocket)
                            if (!openingClaimed.compareAndSet(false, true)) {
                                webSocket.cancel()
                                return
                            }
                            val connection =
                                object : WebSocketClient.Connection {
                                    override fun send(text: String) {
                                        synchronized(this) {
                                            check(!ended.get()) { "WebSocket is closed" }
                                            require(text.isNotEmpty()) {
                                                "WebSocket command must not be empty"
                                            }
                                            val size = text.utf8Size()
                                            require(size <= maxMessageBytes) {
                                                "WebSocket command exceeds maxMessageBytes"
                                            }
                                            require(size <= MAX_SEND_BYTES) {
                                                "WebSocket command exceeds OkHttp's 16 MiB send limit"
                                            }
                                            check(webSocket.queueSize() == 0L) {
                                                "WebSocket send buffer is full; command was not queued"
                                            }
                                            check(webSocket.send(text)) {
                                                "WebSocket is closed; command was not queued"
                                            }
                                        }
                                    }

                                    override fun close() {
                                        // Abort independently of a running listener. The owned
                                        // executor serializes notification after that listener.
                                        if (ended.compareAndSet(false, true))
                                            stop(notifyClosed = 1000)
                                    }
                                }
                            if (ended.get() || !result.complete(connection)) connection.close()
                            if (ended.get()) webSocket.cancel()
                        }

                        override fun onMessage(webSocket: WebSocket, text: String) {
                            synchronized(callbacks) {
                                if (ended.get()) return
                                if (text.utf8Size() > maxMessageBytes) {
                                    fail(IOException("WebSocket message exceeds maxMessageBytes"))
                                } else listener.onMessage(text)
                            }
                        }

                        override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
                            fail(IOException("Unexpected binary WebSocket message"))
                        }

                        override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                            synchronized(callbacks) {
                                if (!ended.get()) {
                                    // Native close timeout starts after earlier writes drain.
                                    // Bound the reply even when an application write is blocked.
                                    closeDeadline.set(
                                        timer.schedule(
                                            {
                                                if (ended.compareAndSet(false, true))
                                                    stop(notifyClosed = code)
                                            },
                                            1,
                                            TimeUnit.SECONDS,
                                        )
                                    )
                                    // A peer may omit its status; reserved code 1005 cannot be
                                    // sent.
                                    webSocket.close(if (code == 1005) 1000 else code, null)
                                }
                            }
                        }

                        override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                            if (ended.compareAndSet(false, true)) stop(notifyClosed = code)
                        }

                        override fun onFailure(
                            webSocket: WebSocket,
                            error: Throwable,
                            response: Response?,
                        ) {
                            fail(
                                response?.let { WebSocketHandshakeException(it.code) }
                                    ?: IOException("WebSocket transport failed", error)
                            )
                        }
                    },
                )
            } catch (error: Exception) {
                stop()
                result.completeExceptionally(error)
                throw error
            }
        native.set(socket)
        if (ended.get()) socket.cancel()
        return result
    }

    // OkHttp's fixed outgoing queue budget also applies to a single complete message.
    private const val MAX_SEND_BYTES = 16 * 1024 * 1024
    private val timer =
        java.util.concurrent
            .ScheduledThreadPoolExecutor(1) { runnable ->
                Thread(runnable, "openai-websocket-timeouts").apply { isDaemon = true }
            }
            .apply { removeOnCancelPolicy = true }
}
