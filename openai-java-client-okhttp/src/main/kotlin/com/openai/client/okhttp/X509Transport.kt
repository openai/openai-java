package com.openai.client.okhttp

import com.openai.core.Timeout
import com.openai.core.checkRequired
import java.io.IOException
import java.net.Proxy
import java.net.Socket
import java.security.Principal
import java.security.PrivateKey
import java.security.cert.X509Certificate
import javax.net.ssl.KeyManager
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLEngine
import javax.net.ssl.X509ExtendedKeyManager
import javax.net.ssl.X509TrustManager

/**
 * Preview: an immutable, caller-attested TLS capability for X.509 workload identity federation.
 *
 * The caller attests that the configured certificate alias resolves to the same private key and
 * certificate chain, and that the trust manager makes stable trust decisions, for this capability's
 * lifetime. The SDK does not copy private-key material. To rotate the identity or change server
 * trust, build a new capability; each capability is a distinct TLS generation with its own context.
 * Each bound session creates and owns its own isolated connection pools.
 *
 * This initial capability is direct-connect only. It always uses native hostname verification,
 * disables redirects, and does not accept arbitrary clients, interceptors, or socket factories.
 */
class X509Transport
private constructor(
    private val sslContext: SSLContext,
    private val trustManager: X509TrustManager,
) {

    companion object {
        @JvmStatic fun builder() = Builder()

        private const val ISSUER_HOST = "mtls.auth.openai.com"
        private val API_HOSTS = setOf("mtls.api.openai.com", "mtls-eu.api.openai.com")
        private const val HTTPS_PORT = 443
    }

    /** A builder for [X509Transport]. */
    class Builder internal constructor() {

        private var keyManager: X509ExtendedKeyManager? = null
        private var certificateAlias: String? = null
        private var trustManager: X509TrustManager? = null

        /**
         * Sets the caller-owned key manager. Its configured [certificateAlias] must remain stable
         * for the lifetime of the built capability.
         */
        fun keyManager(keyManager: X509ExtendedKeyManager) = apply { this.keyManager = keyManager }

        /** Sets the one client-certificate alias allowed on both network legs. */
        fun certificateAlias(certificateAlias: String) = apply {
            this.certificateAlias = certificateAlias
        }

        /**
         * Sets the caller-owned trust manager used for server authentication. Client identity and
         * server trust remain independent. The caller attests that its trust decisions remain
         * stable for the lifetime of the built capability. To change the trust policy, build a new
         * capability.
         */
        fun trustManager(trustManager: X509TrustManager) = apply {
            this.trustManager = trustManager
        }

        fun build(): X509Transport {
            val keyManager = checkRequired("keyManager", keyManager)
            val alias =
                checkRequired("certificateAlias", certificateAlias).also {
                    require(it.isNotBlank()) { "certificateAlias must not be blank" }
                }
            val trustManager = checkRequired("trustManager", trustManager)
            requireNotNull(keyManager.getPrivateKey(alias)) {
                "certificateAlias does not identify a private key"
            }
            require(!keyManager.getCertificateChain(alias).isNullOrEmpty()) {
                "certificateAlias does not identify a certificate chain"
            }

            val fixedAliasKeyManager = FixedAliasKeyManager(keyManager, alias)
            val sslContext =
                SSLContext.getInstance("TLS").apply {
                    init(arrayOf<KeyManager>(fixedAliasKeyManager), arrayOf(trustManager), null)
                }
            return X509Transport(sslContext, trustManager)
        }
    }

    /**
     * Binds this TLS generation to two isolated direct-connect clients. The returned object owns
     * both clients and must be closed by the SDK client that receives it.
     */
    @JvmSynthetic
    internal fun bind(timeout: Timeout): BoundX509Transport =
        bind(timeout, Proxy.NO_PROXY, Proxy.NO_PROXY)

    /** Test seam for the loopback HTTP CONNECT oracle. Production integration uses [bind]. */
    @JvmSynthetic
    internal fun bindForTest(
        timeout: Timeout,
        exchangeProxy: Proxy,
        apiProxy: Proxy,
    ): BoundX509Transport = bind(timeout, exchangeProxy, apiProxy)

    private fun bind(timeout: Timeout, exchangeProxy: Proxy, apiProxy: Proxy): BoundX509Transport {
        fun client(proxy: Proxy, allowedHosts: Set<String>): OkHttpClient {
            val client =
                OkHttpClient.builder()
                    .timeout(timeout)
                    .followRedirects(false)
                    .proxy(proxy)
                    .sslSocketFactory(sslContext.socketFactory)
                    .trustManager(trustManager)
                    .build()

            return OkHttpClient(
                client.okHttpClient
                    .newBuilder()
                    .addInterceptor { chain ->
                        val request = chain.request()
                        val url = request.url
                        if (
                            url.scheme != "https" ||
                                url.host !in allowedHosts ||
                                url.port != HTTPS_PORT ||
                                url.encodedUsername.isNotEmpty() ||
                                url.encodedPassword.isNotEmpty()
                        ) {
                            throw IOException("X.509 request destination is not authorized")
                        }
                        chain.proceed(request)
                    }
                    .build()
            )
        }

        val exchangeClient = client(exchangeProxy, setOf(ISSUER_HOST))
        return try {
            BoundX509Transport(exchangeClient, client(apiProxy, API_HOSTS))
        } catch (error: Throwable) {
            try {
                exchangeClient.close()
            } catch (closeError: Throwable) {
                if (closeError !== error) {
                    error.addSuppressed(closeError)
                }
            }
            throw error
        }
    }
}

internal class BoundX509Transport(val exchangeClient: OkHttpClient, val apiClient: OkHttpClient) :
    AutoCloseable {

    override fun close() {
        apiClient.use { exchangeClient.close() }
    }
}

private class FixedAliasKeyManager(
    private val delegate: X509ExtendedKeyManager,
    private val alias: String,
) : X509ExtendedKeyManager() {

    override fun getClientAliases(keyType: String, issuers: Array<out Principal>?): Array<String>? =
        delegate
            .getClientAliases(keyType, issuers)
            ?.takeIf { aliases -> alias in aliases }
            ?.let { arrayOf(alias) }

    override fun chooseClientAlias(
        keyType: Array<out String>?,
        issuers: Array<out Principal>?,
        socket: Socket?,
    ): String? = chooseEligibleAlias(keyType, issuers)

    override fun chooseEngineClientAlias(
        keyType: Array<out String>?,
        issuers: Array<out Principal>?,
        engine: SSLEngine?,
    ): String? = chooseEligibleAlias(keyType, issuers)

    private fun chooseEligibleAlias(
        keyTypes: Array<out String>?,
        issuers: Array<out Principal>?,
    ): String? =
        keyTypes
            ?.asSequence()
            ?.flatMap { keyType ->
                delegate.getClientAliases(keyType, issuers).orEmpty().asSequence()
            }
            ?.firstOrNull { it == alias }

    override fun getServerAliases(keyType: String, issuers: Array<out Principal>?): Array<String>? =
        null

    override fun chooseServerAlias(
        keyType: String,
        issuers: Array<out Principal>?,
        socket: Socket?,
    ): String? = null

    override fun chooseEngineServerAlias(
        keyType: String,
        issuers: Array<out Principal>?,
        engine: SSLEngine?,
    ): String? = null

    override fun getCertificateChain(alias: String?): Array<X509Certificate>? =
        alias?.takeIf { it == this.alias }?.let(delegate::getCertificateChain)

    override fun getPrivateKey(alias: String?): PrivateKey? =
        alias?.takeIf { it == this.alias }?.let(delegate::getPrivateKey)
}
