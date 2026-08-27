package com.openai.client.okhttp

import com.openai.core.Timeout
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.errors.OpenAIIoException
import java.net.Socket
import java.security.KeyStore
import java.security.Principal
import java.security.PrivateKey
import java.security.cert.X509Certificate
import java.time.Duration
import java.util.concurrent.CompletionException
import javax.net.ssl.KeyManagerFactory
import javax.net.ssl.SSLEngine
import javax.net.ssl.SSLHandshakeException
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
        val bound = transport.bind(Timeout.default())
        val exchange = bound.exchangeClient.okHttpClient
        val api = bound.apiClient.okHttpClient

        bound.use {
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

        assertThat(exchange.dispatcher.executorService.isShutdown).isTrue()
        assertThat(api.dispatcher.executorService.isShutdown).isTrue()
        assertThat(exchange.connectionPool.connectionCount()).isZero()
        assertThat(api.connectionPool.connectionCount()).isZero()
    }

    @Test
    fun productionTransportPinsOneAliasAcrossBothExactAuthorities() {
        val pinned = X509TestIdentity.create("pinned identity")
        val alternate = X509TestIdentity.create("alternate identity")
        X509TestPeer(AUTH_HOST, pinned.root.certificate).use { authPeer ->
            X509TestPeer(API_HOST, pinned.root.certificate).use { apiPeer ->
                authPeer.enqueue(
                    MockResponse()
                        .setHeader("Content-Type", "application/json")
                        .setBody(TOKEN_RESPONSE)
                )
                apiPeer.enqueue(
                    MockResponse()
                        .setHeader("Content-Type", "application/json")
                        .setBody("""{"object":"list","data":[]}""")
                )
                val recordingKeyManager =
                    HandshakeRecordingKeyManager(
                        SelectingKeyManager(
                            keyManager(mapOf(PINNED_ALIAS to pinned, ALTERNATE_ALIAS to alternate)),
                            ALTERNATE_ALIAS,
                        ),
                        PINNED_ALIAS,
                    )
                val transport =
                    transport(
                        recordingKeyManager,
                        listOf(authPeer.serverRootCertificate, apiPeer.serverRootCertificate),
                    )
                transport.bindForTest(Timeout.default(), authPeer.proxy, apiPeer.proxy).use { bound
                    ->
                    val token =
                        X509TokenExchange("idp_test", "svc_acct_test", bound.exchangeClient).use {
                            exchange ->
                            exchange.execute()
                        }
                    assertThat(token.expiresIn).isEqualTo(Duration.ofDays(1))
                    recordingKeyManager.requireClientAliasSelection("issuer exchange")
                    // Closing one path must not drain the other path's pool or dispatcher.
                    bound.exchangeClient.close()
                    bound.apiClient.execute(X509LiveRequests.api(token.value)).use { response ->
                        assertThat(response.statusCode()).isEqualTo(200)
                    }
                    recordingKeyManager.requireClientAliasSelection("mTLS API")
                }

                val authConnect = authPeer.takeRequest()
                val authRequest = authPeer.takeRequest()
                val apiConnect = apiPeer.takeRequest()
                val apiRequest = apiPeer.takeRequest()
                assertThat(authConnect.requestLine).isEqualTo("CONNECT $AUTH_HOST:443 HTTP/1.1")
                assertThat(apiConnect.requestLine).isEqualTo("CONNECT $API_HOST:443 HTTP/1.1")
                assertThat(authRequest.method).isEqualTo("POST")
                assertThat(authRequest.path).isEqualTo("/oauth/token")
                assertThat(authRequest.getHeader("Authorization")).isNull()
                assertThat(authRequest.getHeader("Content-Type")).isEqualTo("application/json")
                assertThat(authRequest.body.readUtf8()).isEqualTo(TOKEN_REQUEST)
                assertThat(apiRequest.method).isEqualTo("GET")
                assertThat(apiRequest.path).isEqualTo("/v1/models")
                assertThat(apiRequest.getHeader("Authorization")).isEqualTo("Bearer $ACCESS_TOKEN")
                assertThat(apiRequest.getHeader("api-key")).isNull()
                assertThat(apiRequest.getHeader("x-api-key")).isNull()
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
    fun productionTransportRejectsUnauthorizedOriginsBeforeNetworking() {
        val identity = X509TestIdentity.create("origin-bound identity")
        X509TestPeer(ATTACKER_HOST, identity.root.certificate).use { attackerPeer ->
            attackerPeer.enqueue(MockResponse())
            val transport = transport(identity, listOf(attackerPeer.serverRootCertificate))

            transport.bindForTest(Timeout.default(), attackerPeer.proxy, attackerPeer.proxy).use {
                bound ->
                val unauthorizedOrigins =
                    mapOf(
                        bound.exchangeClient to
                            listOf(
                                "https://$ATTACKER_HOST/oauth/token",
                                API_URL,
                                "https://$EU_API_HOST/v1/models",
                                "http://$AUTH_HOST/oauth/token",
                                "https://$AUTH_HOST:8443/oauth/token",
                                "https://user:password@$AUTH_HOST/oauth/token",
                                "https://$AUTH_HOST.attacker.example/oauth/token",
                            ),
                        bound.apiClient to
                            listOf(
                                "https://$ATTACKER_HOST/v1/models",
                                AUTH_URL,
                                "http://$API_HOST/v1/models",
                                "https://$API_HOST:8443/v1/models",
                                "https://user:password@$API_HOST/v1/models",
                                "https://$API_HOST.attacker.example/v1/models",
                                "https://$API_HOST./v1/models",
                            ),
                    )

                unauthorizedOrigins.forEach { (client, origins) ->
                    origins.forEach { origin ->
                        val request =
                            request(origin)
                                .toBuilder()
                                .putHeader("Authorization", "Bearer $ACCESS_TOKEN")
                                .build()
                        assertThatThrownBy { client.execute(request).close() }
                            .isInstanceOf(OpenAIIoException::class.java)
                            .hasRootCauseMessage("X.509 request destination is not authorized")
                    }

                    val request =
                        request("https://$ATTACKER_HOST/v1/models")
                            .toBuilder()
                            .putHeader("Authorization", "Bearer $ACCESS_TOKEN")
                            .build()
                    assertThatThrownBy { client.executeAsync(request).join() }
                        .isInstanceOf(CompletionException::class.java)
                        .hasCauseInstanceOf(OpenAIIoException::class.java)
                        .hasRootCauseMessage("X.509 request destination is not authorized")
                }
            }

            assertThat(attackerPeer.server.requestCount).isZero()
            assertThat(attackerPeer.requestedServerNames).isEmpty()
        }
    }

    @Test
    fun productionTransportAcceptsCanonicalAuthoritiesAndEuResidency() {
        val identity = X509TestIdentity.create("canonical origin identity")
        X509TestPeer(AUTH_HOST, identity.root.certificate).use { authPeer ->
            X509TestPeer(EU_API_HOST, identity.root.certificate).use { apiPeer ->
                authPeer.enqueue(MockResponse())
                apiPeer.enqueue(MockResponse())
                val transport =
                    transport(
                        identity,
                        listOf(authPeer.serverRootCertificate, apiPeer.serverRootCertificate),
                    )

                transport.bindForTest(Timeout.default(), authPeer.proxy, apiPeer.proxy).use { bound
                    ->
                    bound.exchangeClient
                        .execute(request("https://MTLS.AUTH.OPENAI.COM:443/oauth/token"))
                        .close()
                    bound.apiClient
                        .execute(
                            request("https://MTLS-EU.API.OPENAI.COM:443/v1/models")
                                .toBuilder()
                                .putHeader("Authorization", "Bearer $ACCESS_TOKEN")
                                .build()
                        )
                        .close()
                }

                assertThat(authPeer.takeRequest().requestLine)
                    .isEqualTo("CONNECT $AUTH_HOST:443 HTTP/1.1")
                authPeer.takeRequest()
                assertThat(apiPeer.takeRequest().requestLine)
                    .isEqualTo("CONNECT $EU_API_HOST:443 HTTP/1.1")
                val apiRequest = apiPeer.takeRequest()
                assertThat(apiRequest.getHeader("Authorization")).isEqualTo("Bearer $ACCESS_TOKEN")
                assertThat(requireNotNull(apiRequest.handshake).peerCertificates.first())
                    .isEqualTo(identity.leaf.certificate)
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
                assertThatThrownBy { bound.apiClient.execute(request(API_URL)).close() }
                    .hasRootCauseInstanceOf(javax.net.ssl.SSLPeerUnverifiedException::class.java)
            }

            assertThat(authPeer.takeRequest().requestLine)
                .isEqualTo("CONNECT $API_HOST:443 HTTP/1.1")
            assertThat(authPeer.requestedServerNames).containsExactly(API_HOST)
        }
    }

    @Test
    fun productionTransportRejectsUntrustedServersOnBothLegs() {
        val identity = X509TestIdentity.create("untrusted server identity")
        val unrelatedRoot = X509TestIdentity.create("unrelated server identity").root.certificate
        X509TestPeer(AUTH_HOST, identity.root.certificate).use { authPeer ->
            X509TestPeer(API_HOST, identity.root.certificate).use { apiPeer ->
                authPeer.enqueue(MockResponse())
                apiPeer.enqueue(MockResponse())
                val transport = transport(identity, listOf(unrelatedRoot))

                transport.bindForTest(Timeout.default(), authPeer.proxy, apiPeer.proxy).use { bound
                    ->
                    assertThatThrownBy { bound.exchangeClient.execute(request(AUTH_URL)).close() }
                        .isInstanceOf(OpenAIIoException::class.java)
                        .hasCauseInstanceOf(SSLHandshakeException::class.java)
                    assertThatThrownBy {
                            bound.apiClient.execute(request("$API_URL/v1/files")).close()
                        }
                        .isInstanceOf(OpenAIIoException::class.java)
                        .hasCauseInstanceOf(SSLHandshakeException::class.java)
                }

                assertThat(authPeer.server.requestCount).isEqualTo(1)
                assertThat(apiPeer.server.requestCount).isEqualTo(1)
            }
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
        const val EU_API_HOST = "mtls-eu.api.openai.com"
        const val ATTACKER_HOST = "review.attacker.example"
        const val AUTH_URL = "https://$AUTH_HOST/oauth/token"
        const val API_URL = "https://$API_HOST"
        const val PINNED_ALIAS = "pinned"
        const val ALTERNATE_ALIAS = "alternate"
        const val ACCESS_TOKEN = "test-x509-access-token"
        val TOKEN_REQUEST =
            """{"grant_type":"urn:ietf:params:oauth:grant-type:token-exchange","subject_token_type":"urn:openai:params:oauth:token-type:x509","identity_provider_id":"idp_test","service_account_id":"svc_acct_test"}"""
        val TOKEN_RESPONSE =
            """
            {
              "access_token": "$ACCESS_TOKEN",
              "issued_token_type": "urn:ietf:params:oauth:token-type:access_token",
              "token_type": "Bearer",
              "expires_in": 86400
            }
            """
                .trimIndent()
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
