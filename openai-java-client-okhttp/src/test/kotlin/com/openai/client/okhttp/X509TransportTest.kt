package com.openai.client.okhttp

import com.openai.core.Timeout
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import java.net.Socket
import java.security.KeyStore
import java.security.Principal
import java.security.PrivateKey
import java.security.cert.X509Certificate
import javax.net.ssl.KeyManagerFactory
import javax.net.ssl.SSLEngine
import javax.net.ssl.X509ExtendedKeyManager
import okhttp3.mockwebserver.MockResponse
import okhttp3.tls.HandshakeCertificates
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class X509TransportTest {

    @Test
    fun productionBindingIsDirectNonRetryingAndIsolated() {
        val pinned = X509TestIdentity.create("production binding identity")
        val transport = transport(pinned, emptyList())

        transport.bind(Timeout.default()).use { bound ->
            val exchange = bound.exchangeClient.okHttpClient
            val api = bound.apiClient.okHttpClient

            assertThat(exchange.proxy).isEqualTo(java.net.Proxy.NO_PROXY)
            assertThat(api.proxy).isEqualTo(java.net.Proxy.NO_PROXY)
            assertThat(exchange.followRedirects).isFalse()
            assertThat(api.followRedirects).isFalse()
            assertThat(exchange.followSslRedirects).isFalse()
            assertThat(api.followSslRedirects).isFalse()
            assertThat(exchange.retryOnConnectionFailure).isFalse()
            assertThat(api.retryOnConnectionFailure).isFalse()
            assertThat(exchange.connectionPool).isNotSameAs(api.connectionPool)
            assertThat(exchange.dispatcher).isNotSameAs(api.dispatcher)
            assertThat(exchange.dispatcher.executorService)
                .isNotSameAs(api.dispatcher.executorService)
        }
    }

    @Test
    fun productionTransportPinsOneAliasAcrossBothExactAuthorities() {
        val pinned = X509TestIdentity.create("pinned identity")
        val alternate = X509TestIdentity.create("alternate identity")
        X509TestPeer(AUTH_HOST, pinned.root.certificate).use { authPeer ->
            X509TestPeer(API_HOST, pinned.root.certificate).use { apiPeer ->
                authPeer.enqueue(MockResponse().setBody("auth"))
                apiPeer.enqueue(MockResponse().setBody("api"))
                val transport =
                    adversarialTransport(
                        pinned,
                        alternate,
                        listOf(authPeer.serverRootCertificate, apiPeer.serverRootCertificate),
                    )

                transport.bindForTest(Timeout.default(), authPeer.proxy, apiPeer.proxy).use { bound
                    ->
                    bound.exchangeClient.execute(request(AUTH_URL)).use { response ->
                        assertThat(response.statusCode()).isEqualTo(200)
                    }
                    // Closing one path must not drain the other path's pool or dispatcher.
                    bound.exchangeClient.close()
                    bound.apiClient.execute(request("$API_URL/v1/files")).use { response ->
                        assertThat(response.statusCode()).isEqualTo(200)
                    }
                }

                val authConnect = authPeer.takeRequest()
                val authRequest = authPeer.takeRequest()
                val apiConnect = apiPeer.takeRequest()
                val apiRequest = apiPeer.takeRequest()
                assertThat(authConnect.requestLine).isEqualTo("CONNECT $AUTH_HOST:443 HTTP/1.1")
                assertThat(apiConnect.requestLine).isEqualTo("CONNECT $API_HOST:443 HTTP/1.1")
                assertThat(authRequest.path).isEqualTo("/oauth/token")
                assertThat(apiRequest.path).isEqualTo("/v1/files")
                assertThat(requireNotNull(authRequest.handshake).peerCertificates.first())
                    .isEqualTo(pinned.leaf.certificate)
                assertThat(requireNotNull(apiRequest.handshake).peerCertificates.first())
                    .isEqualTo(pinned.leaf.certificate)
                assertThat(authRequest.handshake!!.peerCertificates)
                    .doesNotContain(alternate.leaf.certificate)
                assertThat(apiRequest.handshake!!.peerCertificates)
                    .doesNotContain(alternate.leaf.certificate)
                assertThat(authPeer.requestedServerNames).containsExactly(AUTH_HOST)
                assertThat(apiPeer.requestedServerNames).containsExactly(API_HOST)
            }
        }
    }

    @Test
    fun productionTransportDoesNotFollowRedirects() {
        val identity = X509TestIdentity.create("redirect identity")
        X509TestPeer(AUTH_HOST, identity.root.certificate).use { authPeer ->
            X509TestPeer(API_HOST, identity.root.certificate).use { apiPeer ->
                authPeer.enqueue(
                    MockResponse().setResponseCode(307).setHeader("Location", "$API_URL/v1/files")
                )
                val transport =
                    transport(
                        identity,
                        listOf(authPeer.serverRootCertificate, apiPeer.serverRootCertificate),
                    )

                transport.bindForTest(Timeout.default(), authPeer.proxy, apiPeer.proxy).use { bound
                    ->
                    bound.exchangeClient.execute(request(AUTH_URL)).use { response ->
                        assertThat(response.statusCode()).isEqualTo(307)
                    }
                }

                assertThat(authPeer.server.requestCount).isEqualTo(2)
                assertThat(apiPeer.server.requestCount).isZero()
            }
        }
    }

    @Test
    fun productionTransportRetainsNativeHostnameVerification() {
        val identity = X509TestIdentity.create("hostname identity")
        X509TestPeer(AUTH_HOST, identity.root.certificate).use { authPeer ->
            authPeer.enqueue(MockResponse())
            val transport = transport(identity, listOf(authPeer.serverRootCertificate))

            transport.bindForTest(Timeout.default(), authPeer.proxy, authPeer.proxy).use { bound ->
                assertThatThrownBy { bound.exchangeClient.execute(request(API_URL)).close() }
                    .hasRootCauseInstanceOf(javax.net.ssl.SSLPeerUnverifiedException::class.java)
            }

            assertThat(authPeer.takeRequest().requestLine)
                .isEqualTo("CONNECT $API_HOST:443 HTTP/1.1")
        }
    }

    @Test
    fun rejectsMissingOrBlankAliasBeforeNetworking() {
        val identity = X509TestIdentity.create("builder identity")
        val keyManager = keyManager(mapOf(PINNED_ALIAS to identity))
        val trustManager = HandshakeCertificates.Builder().build().trustManager

        assertThatThrownBy {
                X509Transport.builder()
                    .keyManager(keyManager)
                    .certificateAlias(" ")
                    .trustManager(trustManager)
                    .build()
            }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("certificateAlias must not be blank")
        assertThatThrownBy {
                X509Transport.builder()
                    .keyManager(keyManager)
                    .certificateAlias("missing")
                    .trustManager(trustManager)
                    .build()
            }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("certificateAlias does not identify a private key")
    }

    private fun adversarialTransport(
        pinned: X509TestIdentity,
        alternate: X509TestIdentity,
        trustedServerRoots: Iterable<X509Certificate>,
    ): X509Transport =
        transport(
            SelectingKeyManager(
                keyManager(mapOf(PINNED_ALIAS to pinned, ALTERNATE_ALIAS to alternate)),
                ALTERNATE_ALIAS,
            ),
            trustedServerRoots,
        )

    private fun transport(
        identity: X509TestIdentity,
        trustedServerRoots: Iterable<X509Certificate>,
    ): X509Transport = transport(keyManager(mapOf(PINNED_ALIAS to identity)), trustedServerRoots)

    private fun transport(
        keyManager: X509ExtendedKeyManager,
        trustedServerRoots: Iterable<X509Certificate>,
    ): X509Transport {
        val trustManager =
            HandshakeCertificates.Builder()
                .apply {
                    trustedServerRoots.forEach { certificate -> addTrustedCertificate(certificate) }
                }
                .build()
                .trustManager
        return X509Transport.builder()
            .keyManager(keyManager)
            .certificateAlias(PINNED_ALIAS)
            .trustManager(trustManager)
            .build()
    }

    private fun keyManager(identities: Map<String, X509TestIdentity>): X509ExtendedKeyManager {
        val password = "test password".toCharArray()
        val keyStore =
            KeyStore.getInstance("PKCS12").apply {
                load(null, null)
                identities.forEach { (alias, identity) ->
                    setKeyEntry(
                        alias,
                        identity.leaf.keyPair.private,
                        password,
                        arrayOf(identity.leaf.certificate, identity.root.certificate),
                    )
                }
            }
        val keyManagerFactory =
            KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()).apply {
                init(keyStore, password)
            }
        return keyManagerFactory.keyManagers.filterIsInstance<X509ExtendedKeyManager>().single()
    }

    private fun request(url: String): HttpRequest =
        HttpRequest.builder().method(HttpMethod.GET).baseUrl(url).build()

    private companion object {
        const val AUTH_HOST = "mtls.auth.openai.com"
        const val API_HOST = "mtls.api.openai.com"
        const val AUTH_URL = "https://$AUTH_HOST/oauth/token"
        const val API_URL = "https://$API_HOST"
        const val PINNED_ALIAS = "pinned"
        const val ALTERNATE_ALIAS = "alternate"
    }
}

/** A delegate whose ordinary selection callbacks always try to select a different alias. */
private class SelectingKeyManager(
    private val delegate: X509ExtendedKeyManager,
    private val selectedAlias: String,
) : X509ExtendedKeyManager() {

    override fun getClientAliases(keyType: String, issuers: Array<out Principal>?): Array<String>? =
        delegate.getClientAliases(keyType, issuers)

    override fun chooseClientAlias(
        keyType: Array<out String>?,
        issuers: Array<out Principal>?,
        socket: Socket?,
    ): String = selectedAlias

    override fun chooseEngineClientAlias(
        keyType: Array<out String>?,
        issuers: Array<out Principal>?,
        engine: SSLEngine?,
    ): String = selectedAlias

    override fun getServerAliases(keyType: String, issuers: Array<out Principal>?): Array<String>? =
        delegate.getServerAliases(keyType, issuers)

    override fun chooseServerAlias(
        keyType: String,
        issuers: Array<out Principal>?,
        socket: Socket?,
    ): String? = delegate.chooseServerAlias(keyType, issuers, socket)

    override fun chooseEngineServerAlias(
        keyType: String,
        issuers: Array<out Principal>?,
        engine: SSLEngine?,
    ): String? = delegate.chooseEngineServerAlias(keyType, issuers, engine)

    override fun getCertificateChain(alias: String?): Array<X509Certificate>? =
        delegate.getCertificateChain(alias)

    override fun getPrivateKey(alias: String?): PrivateKey? = delegate.getPrivateKey(alias)
}
