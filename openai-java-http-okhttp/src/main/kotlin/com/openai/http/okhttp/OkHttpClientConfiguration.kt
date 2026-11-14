package com.openai.http.okhttp

import com.openai.core.ClientOptions
import com.openai.core.Timeout
import com.openai.core.http.ProxyAuthenticator
import java.net.Proxy
import java.time.Duration
import java.util.concurrent.ExecutorService
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.X509TrustManager
import okhttp3.Interceptor

/** Configuration shared by the SDK factories that construct a client backed by OkHttp. */
internal class OkHttpClientConfiguration {

    val clientOptions = ClientOptions.builder()
    var dispatcherExecutorService: ExecutorService? = null
    var followRedirects: Boolean? = null
    var proxy: Proxy? = null
    var proxyAuthenticator: ProxyAuthenticator? = null
    var maxIdleConnections: Int? = null
    var keepAliveDuration: Duration? = null
    var sslSocketFactory: SSLSocketFactory? = null
    var trustManager: X509TrustManager? = null
    var hostnameVerifier: HostnameVerifier? = null
    var okHttpClient: okhttp3.OkHttpClient? = null
    val interceptors = mutableListOf<Interceptor>()
    var x509WorkloadIdentity: X509WorkloadIdentity? = null

    private var timeoutConfigured = false
    private var x509BaseUrl: String? = null

    fun baseUrl(baseUrl: String?) {
        clientOptions.baseUrl(baseUrl)
        x509BaseUrl = baseUrl
    }

    fun timeout(timeout: Timeout) {
        timeoutConfigured = true
        clientOptions.timeout(timeout)
    }

    fun fromEnv() {
        clientOptions.fromEnv()
        (System.getProperty("openai.baseUrl") ?: System.getenv("OPENAI_BASE_URL"))?.let {
            x509BaseUrl = it
        }
    }

    fun build(): ClientOptions {
        val customTransport =
            proxy != null ||
                proxyAuthenticator != null ||
                maxIdleConnections != null ||
                keepAliveDuration != null ||
                dispatcherExecutorService != null ||
                sslSocketFactory != null ||
                trustManager != null ||
                hostnameVerifier != null

        x509WorkloadIdentity?.let { identity ->
            require(!customTransport && interceptors.isEmpty() && okHttpClient == null) {
                "X.509 workload identity cannot be combined with custom transport settings"
            }
            return x509ClientOptions(clientOptions, identity, x509BaseUrl)
        }

        val transport =
            okHttpClient?.let { native ->
                require(!customTransport && followRedirects == null) {
                    "Configure transport settings on the supplied okHttpClient instead of the SDK builder"
                }
                if (!timeoutConfigured) {
                    clientOptions.timeout(native.sdkTimeout())
                }
                OkHttpClient.borrow(native, interceptors)
            }
                ?: OkHttpClient.builder()
                    .timeout(clientOptions.timeout())
                    .followRedirects(followRedirects ?: true)
                    .proxy(proxy)
                    .proxyAuthenticator(proxyAuthenticator)
                    .maxIdleConnections(maxIdleConnections)
                    .keepAliveDuration(keepAliveDuration)
                    .dispatcherExecutorService(dispatcherExecutorService)
                    .sslSocketFactory(sslSocketFactory)
                    .trustManager(trustManager)
                    .hostnameVerifier(hostnameVerifier)
                    .also { builder -> interceptors.forEach(builder::addInterceptor) }
                    .build()
        return clientOptions.httpClient(transport).build()
    }
}
