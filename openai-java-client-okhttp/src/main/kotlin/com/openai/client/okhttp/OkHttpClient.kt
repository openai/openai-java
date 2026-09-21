package com.openai.client.okhttp

import com.openai.core.RequestOptions
import com.openai.core.Timeout
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestBody
import com.openai.core.http.HttpResponse
import com.openai.core.http.ProxyAuthenticator
import com.openai.errors.OpenAIIoException
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.net.Proxy
import java.time.Duration
import java.util.concurrent.CancellationException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutorService
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.X509TrustManager
import kotlin.jvm.optionals.getOrNull
import okhttp3.Call
import okhttp3.Callback
import okhttp3.ConnectionPool
import okhttp3.Dispatcher
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okio.BufferedSink
import okio.buffer
import okio.sink

class OkHttpClient
internal constructor(@JvmSynthetic internal val okHttpClient: okhttp3.OkHttpClient) :
    HttpClient, com.openai.core.http.WebSocketClient {

    private val webSockets =
        java.util.concurrent.ConcurrentHashMap.newKeySet<
            com.openai.core.http.WebSocketClient.Connection
        >()
    private val closed = java.util.concurrent.atomic.AtomicBoolean()
    private val pendingWebSockets =
        java.util.concurrent.ConcurrentHashMap.newKeySet<
            CompletableFuture<com.openai.core.http.WebSocketClient.Connection>
        >()

    override fun connectWebSocket(
        request: HttpRequest,
        options: RequestOptions,
        maxMessageBytes: Int,
        listener: com.openai.core.http.WebSocketClient.Listener,
    ): CompletableFuture<com.openai.core.http.WebSocketClient.Connection> {
        check(!closed.get()) { "Client is closed" }
        val finished = java.util.concurrent.atomic.AtomicBoolean()
        val current =
            java.util.concurrent.atomic.AtomicReference<
                com.openai.core.http.WebSocketClient.Connection
            >()
        val result =
            BoundedWebSocket.connect(
                okHttpClient,
                request.toRequest(okHttpClient, options.timeout),
                options,
                maxMessageBytes,
                object : com.openai.core.http.WebSocketClient.Listener {
                    override fun onMessage(text: String) = listener.onMessage(text)

                    override fun onClosed(code: Int) {
                        finished.set(true)
                        current.get()?.let { webSockets.remove(it) }
                        listener.onClosed(code)
                    }

                    override fun onFailure(error: Throwable) {
                        finished.set(true)
                        current.get()?.let { webSockets.remove(it) }
                        listener.onFailure(error)
                    }
                },
            )
        pendingWebSockets.add(result)
        if (closed.get()) result.cancel(true)
        result.whenComplete { connection, error ->
            pendingWebSockets.remove(result)
            if (error == null) {
                current.set(connection)
                webSockets.add(connection)
                if (closed.get() || finished.get()) {
                    webSockets.remove(connection)
                    connection.close()
                }
            }
        }
        return result
    }

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
        val call = newCall(request, requestOptions)

        return try {
            call.execute().toHttpResponse()
        } catch (e: IOException) {
            throw OpenAIIoException("Request failed", e)
        } finally {
            request.body?.close()
        }
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        val future = CompletableFuture<HttpResponse>()

        val call = newCall(request, requestOptions)
        call.enqueue(
            object : Callback {
                override fun onResponse(call: Call, response: Response) {
                    val httpResponse = response.toHttpResponse()
                    if (!future.complete(httpResponse)) {
                        httpResponse.close()
                    }
                }

                override fun onFailure(call: Call, e: IOException) {
                    future.completeExceptionally(OpenAIIoException("Request failed", e))
                }
            }
        )

        future.whenComplete { _, e ->
            if (e is CancellationException) {
                call.cancel()
            }
            request.body?.close()
        }

        return future
    }

    override fun close() {
        closed.set(true)
        pendingWebSockets.forEach { it.cancel(true) }
        pendingWebSockets.clear()
        webSockets.forEach { it.close() }
        webSockets.clear()
        okHttpClient.dispatcher.executorService.shutdown()
        okHttpClient.connectionPool.evictAll()
        okHttpClient.cache?.close()
    }

    private fun newCall(request: HttpRequest, requestOptions: RequestOptions): Call {
        val clientBuilder = okHttpClient.newBuilder()

        requestOptions.timeout?.let {
            clientBuilder
                .connectTimeout(it.connect())
                .readTimeout(it.read())
                .writeTimeout(it.write())
                .callTimeout(it.request())
        }

        val client = clientBuilder.build()
        return client.newCall(request.toRequest(client))
    }

    companion object {
        @get:JvmSynthetic
        internal val apiKeyRedirectInterceptor =
            okhttp3.Interceptor { chain ->
                val request = chain.request()
                val originalUrl = chain.call().request().url
                val url = request.url
                val sameOrigin =
                    originalUrl.scheme == url.scheme &&
                        originalUrl.host == url.host &&
                        originalUrl.port == url.port
                // OkHttp strips Authorization on cross-origin redirects, but does not
                // recognize the Azure API-key header as a credential.
                chain.proceed(
                    if (sameOrigin) request
                    else request.newBuilder().removeHeader("api-key").build()
                )
            }

        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private var timeout: Timeout = Timeout.default()
        private var followRedirects: Boolean = true
        private var proxy: Proxy? = null
        private var proxyAuthenticator: ProxyAuthenticator? = null
        private var maxIdleConnections: Int? = null
        private var keepAliveDuration: Duration? = null
        private var dispatcherExecutorService: ExecutorService? = null
        private var sslSocketFactory: SSLSocketFactory? = null
        private var trustManager: X509TrustManager? = null
        private var hostnameVerifier: HostnameVerifier? = null

        fun timeout(timeout: Timeout) = apply { this.timeout = timeout }

        fun timeout(timeout: Duration) = timeout(Timeout.builder().request(timeout).build())

        @JvmSynthetic
        internal fun followRedirects(followRedirects: Boolean) = apply {
            this.followRedirects = followRedirects
        }

        fun proxy(proxy: Proxy?) = apply { this.proxy = proxy }

        fun proxyAuthenticator(proxyAuthenticator: ProxyAuthenticator?) = apply {
            this.proxyAuthenticator = proxyAuthenticator
        }

        /**
         * Sets the maximum number of idle connections kept by the underlying [ConnectionPool].
         *
         * If this is set, then [keepAliveDuration] must also be set.
         *
         * If unset, then OkHttp's default is used.
         */
        fun maxIdleConnections(maxIdleConnections: Int?) = apply {
            this.maxIdleConnections = maxIdleConnections
        }

        /**
         * Sets the keep-alive duration for idle connections in the underlying [ConnectionPool].
         *
         * If this is set, then [maxIdleConnections] must also be set.
         *
         * If unset, then OkHttp's default is used.
         */
        fun keepAliveDuration(keepAliveDuration: Duration?) = apply {
            this.keepAliveDuration = keepAliveDuration
        }

        fun dispatcherExecutorService(dispatcherExecutorService: ExecutorService?) = apply {
            this.dispatcherExecutorService = dispatcherExecutorService
        }

        fun sslSocketFactory(sslSocketFactory: SSLSocketFactory?) = apply {
            this.sslSocketFactory = sslSocketFactory
        }

        fun trustManager(trustManager: X509TrustManager?) = apply {
            this.trustManager = trustManager
        }

        fun hostnameVerifier(hostnameVerifier: HostnameVerifier?) = apply {
            this.hostnameVerifier = hostnameVerifier
        }

        fun build(): OkHttpClient =
            OkHttpClient(
                okhttp3.OkHttpClient.Builder()
                    // `RetryingHttpClient` handles retries if the user enabled them.
                    .retryOnConnectionFailure(false)
                    .followRedirects(followRedirects)
                    .followSslRedirects(followRedirects)
                    .addNetworkInterceptor(apiKeyRedirectInterceptor)
                    .connectTimeout(timeout.connect())
                    .readTimeout(timeout.read())
                    .writeTimeout(timeout.write())
                    .callTimeout(timeout.request())
                    .proxy(proxy)
                    .apply {
                        proxyAuthenticator?.let { auth ->
                            proxyAuthenticator { route, response ->
                                val proxy = route?.proxy ?: Proxy.NO_PROXY
                                // A 407 inside an HTTPS tunnel comes from the origin, not the
                                // proxy, even for an application CONNECT request. Proxy CONNECT
                                // challenges have no TLS handshake attached to their response.
                                if (
                                    proxy.type() != Proxy.Type.HTTP ||
                                        response.handshake != null ||
                                        (response.request.url.isHttps &&
                                            response.request.method != "CONNECT")
                                ) {
                                    null
                                } else {
                                    auth
                                        .authenticate(
                                            proxy,
                                            response.request.toHttpRequest(),
                                            response.toHttpResponse(),
                                        )
                                        .getOrNull()
                                        ?.toRequest(client = null)
                                }
                            }
                        }

                        dispatcherExecutorService?.let { dispatcher(Dispatcher(it)) }

                        val maxIdleConnections = maxIdleConnections
                        val keepAliveDuration = keepAliveDuration
                        if (maxIdleConnections != null && keepAliveDuration != null) {
                            connectionPool(
                                ConnectionPool(
                                    maxIdleConnections,
                                    keepAliveDuration.toNanos(),
                                    TimeUnit.NANOSECONDS,
                                )
                            )
                        } else {
                            check((maxIdleConnections != null) == (keepAliveDuration != null)) {
                                "Both or none of `maxIdleConnections` and `keepAliveDuration` must be set, but only one was set"
                            }
                        }

                        val sslSocketFactory = sslSocketFactory
                        val trustManager = trustManager
                        if (sslSocketFactory != null && trustManager != null) {
                            sslSocketFactory(sslSocketFactory, trustManager)
                        } else {
                            check((sslSocketFactory != null) == (trustManager != null)) {
                                "Both or none of `sslSocketFactory` and `trustManager` must be set, but only one was set"
                            }
                        }

                        hostnameVerifier?.let(::hostnameVerifier)
                    }
                    .build()
                    .apply {
                        // We usually make all our requests to the same host so it makes sense to
                        // raise the per-host limit to the overall limit.
                        dispatcher.maxRequestsPerHost = dispatcher.maxRequests
                    }
            )
    }
}

private fun HttpRequest.toRequest(
    client: okhttp3.OkHttpClient?,
    timeout: Timeout? = null,
): Request {
    var body: RequestBody? = body?.toRequestBody()
    if (body == null && requiresBody(method)) {
        body = "".toRequestBody()
    }

    val builder = Request.Builder().url(toUrl()).method(method.name, body)
    headers.names().forEach { name -> headers.values(name).forEach { builder.addHeader(name, it) } }

    if (client != null) {
        val readTimeout = timeout?.read() ?: Duration.ofMillis(client.readTimeoutMillis.toLong())
        val requestTimeout =
            timeout?.request() ?: Duration.ofMillis(client.callTimeoutMillis.toLong())
        if (!headers.names().contains("X-Stainless-Read-Timeout") && !readTimeout.isZero) {
            builder.addHeader("X-Stainless-Read-Timeout", readTimeout.seconds.toString())
        }
        if (!headers.names().contains("X-Stainless-Timeout") && !requestTimeout.isZero) {
            builder.addHeader("X-Stainless-Timeout", requestTimeout.seconds.toString())
        }
    }

    return builder.build()
}

/** `OkHttpClient` always requires a request body for some methods. */
private fun requiresBody(method: HttpMethod): Boolean =
    when (method) {
        HttpMethod.POST,
        HttpMethod.PUT,
        HttpMethod.PATCH -> true
        else -> false
    }

private fun HttpRequest.toUrl(): String {
    val builder = baseUrl.toHttpUrl().newBuilder()
    pathSegments.forEach(builder::addPathSegment)
    queryParams.keys().forEach { key ->
        queryParams.values(key).forEach { builder.addQueryParameter(key, it) }
    }

    return builder.toString()
}

private fun HttpRequestBody.toRequestBody(): RequestBody {
    val mediaType = contentType()?.toMediaType()
    val length = contentLength()

    return object : RequestBody() {
        override fun contentType(): MediaType? = mediaType

        override fun contentLength(): Long = length

        override fun isOneShot(): Boolean = !repeatable()

        override fun writeTo(sink: BufferedSink) = writeTo(sink.outputStream())
    }
}

private fun Request.toHttpRequest(): HttpRequest {
    val builder = HttpRequest.builder().method(HttpMethod.valueOf(method)).baseUrl(url.toBaseUrl())
    url.pathSegments.forEach(builder::addPathSegment)
    url.queryParameterNames.forEach { name ->
        url.queryParameterValues(name).filterNotNull().forEach { builder.putQueryParam(name, it) }
    }
    headers.forEach { (name, value) -> builder.putHeader(name, value) }
    body?.let { builder.body(it.toHttpRequestBody()) }
    return builder.build()
}

private fun HttpUrl.toBaseUrl(): String = buildString {
    append(scheme).append("://").append(host)
    if (port != HttpUrl.defaultPort(scheme)) {
        append(":").append(port)
    }
}

private fun RequestBody.toHttpRequestBody(): HttpRequestBody {
    val mediaType = contentType()?.toString()
    val length = contentLength()
    val isOneShot = isOneShot()
    val source = this
    return object : HttpRequestBody {
        override fun contentType(): String? = mediaType

        override fun contentLength(): Long = length

        override fun repeatable(): Boolean = !isOneShot

        override fun writeTo(outputStream: OutputStream) {
            val sink = outputStream.sink().buffer()
            source.writeTo(sink)
            sink.flush()
        }

        override fun close() {}
    }
}

private fun Response.toHttpResponse(): HttpResponse {
    val headers = headers.toHeaders()

    return object : HttpResponse {
        override fun statusCode(): Int = code

        override fun headers(): Headers = headers

        override fun body(): InputStream = body!!.byteStream()

        override fun close() = body!!.close()
    }
}

private fun okhttp3.Headers.toHeaders(): Headers {
    val headersBuilder = Headers.builder()
    forEach { (name, value) -> headersBuilder.put(name, value) }
    return headersBuilder.build()
}
