package com.openai.client.okhttp

import com.openai.core.Timeout
import com.openai.core.http.HttpClient
import com.openai.core.http.ProxyAuthenticator
import com.openai.core.http.WebSocketClient
import com.openai.http.okhttp.OkHttpClient as Transport
import java.net.Proxy
import java.time.Duration
import java.util.concurrent.ExecutorService
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.X509TrustManager
import okhttp3.Interceptor

class OkHttpClient private constructor(private val transport: Transport) :
    HttpClient by transport, WebSocketClient by transport {
    internal constructor(okHttpClient: okhttp3.OkHttpClient) : this(Transport(okHttpClient))

    internal val okHttpClient
        get() = transport.okHttpClient

    override fun close() = transport.close()

    companion object {
        @JvmSynthetic
        internal fun borrow(client: okhttp3.OkHttpClient, interceptors: List<Interceptor>) =
            OkHttpClient(Transport.borrow(client, interceptors))

        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {
        private val builder = Transport.builder()

        /**
         * Adds an OkHttp application interceptor. Interceptors run in registration order for each
         * HTTP attempt, including SDK retries. Instances may be called concurrently.
         */
        fun addInterceptor(interceptor: Interceptor) = apply { builder.addInterceptor(interceptor) }

        fun timeout(timeout: Timeout) = apply { builder.timeout(timeout) }

        fun timeout(timeout: Duration) = apply { builder.timeout(timeout) }

        fun proxy(proxy: Proxy?) = apply { builder.proxy(proxy) }

        fun proxyAuthenticator(proxyAuthenticator: ProxyAuthenticator?) = apply {
            builder.proxyAuthenticator(proxyAuthenticator)
        }

        /**
         * Sets the maximum number of idle connections kept by the underlying
         * [okhttp3.ConnectionPool].
         *
         * If this is set, then [keepAliveDuration] must also be set.
         *
         * If unset, then OkHttp's default is used.
         */
        fun maxIdleConnections(maxIdleConnections: Int?) = apply {
            builder.maxIdleConnections(maxIdleConnections)
        }

        /**
         * Sets the keep-alive duration for idle connections in the underlying
         * [okhttp3.ConnectionPool].
         *
         * If this is set, then [maxIdleConnections] must also be set.
         *
         * If unset, then OkHttp's default is used.
         */
        fun keepAliveDuration(keepAliveDuration: Duration?) = apply {
            builder.keepAliveDuration(keepAliveDuration)
        }

        fun dispatcherExecutorService(dispatcherExecutorService: ExecutorService?) = apply {
            builder.dispatcherExecutorService(dispatcherExecutorService)
        }

        fun sslSocketFactory(sslSocketFactory: SSLSocketFactory?) = apply {
            builder.sslSocketFactory(sslSocketFactory)
        }

        fun trustManager(trustManager: X509TrustManager?) = apply {
            builder.trustManager(trustManager)
        }

        fun hostnameVerifier(hostnameVerifier: HostnameVerifier?) = apply {
            builder.hostnameVerifier(hostnameVerifier)
        }

        fun build() = OkHttpClient(builder.build())
    }
}
