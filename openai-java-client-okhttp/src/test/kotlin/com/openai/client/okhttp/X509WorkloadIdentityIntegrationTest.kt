package com.openai.client.okhttp

import com.fasterxml.jackson.databind.ObjectMapper
import com.openai.errors.OpenAIException
import com.openai.errors.OpenAIInvalidDataException
import java.net.InetSocketAddress
import java.net.Proxy
import java.time.Duration
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.tls.HandshakeCertificates
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock
import org.junit.jupiter.api.parallel.Resources

@ResourceLock(Resources.SYSTEM_PROPERTIES)
internal class X509WorkloadIdentityIntegrationTest {

    private val jsonMapper = ObjectMapper()

    @Test
    fun synchronousPublicClientExchangesLazilyAndCachesBearerOverRealMutualTls() {
        verifyPublicClient(async = false)
    }

    @Test
    fun asynchronousPublicClientExchangesLazilyAndCachesBearerOverRealMutualTls() {
        verifyPublicClient(async = true)
    }

    @Test
    fun synchronousPublicClientPreservesTheExplicitEuMutualTlsEndpoint() {
        verifyPublicClient(async = false, apiHost = EU_API_HOST)
    }

    @Test
    fun asynchronousPublicClientPreservesTheExplicitEuMutualTlsEndpoint() {
        verifyPublicClient(async = true, apiHost = EU_API_HOST)
    }

    @Test
    fun synchronousPublicClientPreservesTheEnvironmentConfiguredEuMutualTlsEndpoint() {
        verifyEnvironmentConfiguredPublicClient(async = false)
    }

    @Test
    fun asynchronousPublicClientPreservesTheEnvironmentConfiguredEuMutualTlsEndpoint() {
        verifyEnvironmentConfiguredPublicClient(async = true)
    }

    @Test
    fun synchronousClonedPublicClientCannotSendBearerToAnUnauthorizedOrigin() {
        verifyClonedPublicClientRejectsUnauthorizedOrigin(async = false)
    }

    @Test
    fun asynchronousClonedPublicClientCannotSendBearerToAnUnauthorizedOrigin() {
        verifyClonedPublicClientRejectsUnauthorizedOrigin(async = true)
    }

    @Test
    fun synchronousPublicClientRefreshesTokensWithinTheConfiguredBuffer() {
        verifyRefresh(async = false)
    }

    @Test
    fun asynchronousPublicClientRefreshesTokensWithinTheConfiguredBuffer() {
        verifyRefresh(async = true)
    }

    @Test
    fun synchronousPublicClientRefreshesAndRetriesRejectedAccessTokens() {
        verifyRejectedTokenRecovery(async = false)
    }

    @Test
    fun asynchronousPublicClientRefreshesAndRetriesRejectedAccessTokens() {
        verifyRejectedTokenRecovery(async = true)
    }

    @Test
    fun synchronousPublicClientRejectsUnrepresentableTokenExpiration() {
        verifyUnrepresentableTokenExpiration(async = false)
    }

    @Test
    fun asynchronousPublicClientRejectsUnrepresentableTokenExpirationWithoutHanging() {
        verifyUnrepresentableTokenExpiration(async = true)
    }

    @Test
    fun closingSynchronousPublicClientClosesItsTokenExchangeAuthentication() {
        verifyPublicClientClosesAuthentication(async = false)
    }

    @Test
    fun closingAsynchronousPublicClientClosesItsTokenExchangeAuthentication() {
        verifyPublicClientClosesAuthentication(async = true)
    }

    @Test
    fun certificateAuthenticationCannotBeCombinedWithApiKeysOrCustomTransports() {
        val identity = X509TestIdentity.create("configuration identity")
        val configuration = configuration(identity, emptyList())

        assertThatThrownBy {
                OpenAIOkHttpClient.builder()
                    .apiKey("fake-api-key")
                    .x509WorkloadIdentity(configuration)
                    .build()
            }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("cannot be combined")
        assertThatThrownBy {
                OpenAIOkHttpClientAsync.builder()
                    .apiKey("fake-api-key")
                    .x509WorkloadIdentity(configuration)
                    .build()
            }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("cannot be combined")

        val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("localhost", 12345))
        assertThatThrownBy {
                OpenAIOkHttpClient.builder()
                    .proxy(proxy)
                    .x509WorkloadIdentity(configuration)
                    .build()
            }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("custom transport settings")
        assertThatThrownBy {
                OpenAIOkHttpClientAsync.builder()
                    .proxy(proxy)
                    .x509WorkloadIdentity(configuration)
                    .build()
            }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("custom transport settings")
    }

    @Test
    fun configurationRequiresIdsAndTransportAndRejectsNegativeRefreshBuffers() {
        assertThatThrownBy { X509WorkloadIdentity.builder().build() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("identityProviderId")
        assertThatThrownBy { X509WorkloadIdentity.builder().refreshBuffer(Duration.ofSeconds(-1)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("refreshBuffer")
    }

    private fun verifyEnvironmentConfiguredPublicClient(async: Boolean) {
        val previousBaseUrl = System.setProperty("openai.baseUrl", "https://$EU_API_HOST/v1")
        try {
            verifyPublicClient(async, EU_API_HOST, fromEnv = true)
        } finally {
            if (previousBaseUrl == null) {
                System.clearProperty("openai.baseUrl")
            } else {
                System.setProperty("openai.baseUrl", previousBaseUrl)
            }
        }
    }

    private fun verifyPublicClient(
        async: Boolean,
        apiHost: String = API_HOST,
        fromEnv: Boolean = false,
    ) {
        val identity = X509TestIdentity.create("public certificate identity")
        X509TestPeer(AUTH_HOST, identity.root.certificate).use { authPeer ->
            X509TestPeer(apiHost, identity.root.certificate).use { apiPeer ->
                authPeer.enqueue(tokenResponse(ACCESS_TOKEN))
                apiPeer.enqueue(filesResponse())
                apiPeer.server.enqueue(filesResponse())
                val configuration =
                    configuration(
                            identity,
                            listOf(authPeer.serverRootCertificate, apiPeer.serverRootCertificate),
                        )
                        .withTestProxies(authPeer.proxy, apiPeer.proxy)

                if (async) {
                    val client =
                        OpenAIOkHttpClientAsync.builder()
                            .apply {
                                if (fromEnv) {
                                    baseUrl("https://$API_HOST/v1")
                                    fromEnv()
                                    apiKey(null as String?)
                                } else if (apiHost != API_HOST) {
                                    baseUrl("https://$apiHost/v1")
                                }
                            }
                            .x509WorkloadIdentity(configuration)
                            .maxRetries(0)
                            .build()
                    try {
                        assertThat(authPeer.server.requestCount).isZero()
                        client.files().list().get(5, TimeUnit.SECONDS)
                        client.files().list().get(5, TimeUnit.SECONDS)
                    } finally {
                        client.close()
                    }
                } else {
                    val client =
                        OpenAIOkHttpClient.builder()
                            .apply {
                                if (fromEnv) {
                                    baseUrl("https://$API_HOST/v1")
                                    fromEnv()
                                    apiKey(null as String?)
                                } else if (apiHost != API_HOST) {
                                    baseUrl("https://$apiHost/v1")
                                }
                            }
                            .x509WorkloadIdentity(configuration)
                            .maxRetries(0)
                            .build()
                    try {
                        assertThat(authPeer.server.requestCount).isZero()
                        client.files().list()
                        client.files().list()
                    } finally {
                        client.close()
                    }
                }

                assertThat(authPeer.takeRequest().requestLine)
                    .isEqualTo("CONNECT $AUTH_HOST:443 HTTP/1.1")
                val exchangeRequest = authPeer.takeRequest()
                assertThat(exchangeRequest.path).isEqualTo("/oauth/token")
                assertThat(exchangeRequest.getHeader("Authorization")).isNull()
                assertThat(jsonMapper.readTree(exchangeRequest.body.readUtf8()))
                    .isEqualTo(jsonMapper.readTree(TOKEN_REQUEST))
                assertThat(requireNotNull(exchangeRequest.handshake).peerCertificates.first())
                    .isEqualTo(identity.leaf.certificate)
                assertThat(authPeer.server.requestCount).isEqualTo(2)
                assertThat(apiPeer.takeRequest().requestLine)
                    .isEqualTo("CONNECT $apiHost:443 HTTP/1.1")
                repeat(2) {
                    val apiRequest = apiPeer.takeRequest()
                    assertThat(apiRequest.path).isEqualTo("/v1/files")
                    assertThat(apiRequest.getHeader("Authorization"))
                        .isEqualTo("Bearer $ACCESS_TOKEN")
                    assertThat(requireNotNull(apiRequest.handshake).peerCertificates.first())
                        .isEqualTo(identity.leaf.certificate)
                }
                assertThat(authPeer.requestedServerNames).containsExactly(AUTH_HOST)
                assertThat(apiPeer.requestedServerNames).containsExactly(apiHost)
            }
        }
    }

    private fun verifyPublicClientClosesAuthentication(async: Boolean) {
        val identity = X509TestIdentity.create("closed certificate identity")
        val configuration = configuration(identity, emptyList())

        if (async) {
            val client =
                OpenAIOkHttpClientAsync.builder()
                    .x509WorkloadIdentity(configuration)
                    .maxRetries(0)
                    .build()
            client.close()
            assertThatThrownBy { client.files().list().get(5, TimeUnit.SECONDS) }
                .isInstanceOf(ExecutionException::class.java)
                .hasRootCauseInstanceOf(IllegalStateException::class.java)
                .hasMessageContaining("authentication is closed")
        } else {
            val client =
                OpenAIOkHttpClient.builder()
                    .x509WorkloadIdentity(configuration)
                    .maxRetries(0)
                    .build()
            client.close()
            assertThatThrownBy { client.files().list() }
                .isInstanceOf(IllegalStateException::class.java)
                .hasMessageContaining("authentication is closed")
        }
    }

    private fun verifyClonedPublicClientRejectsUnauthorizedOrigin(async: Boolean) {
        val identity = X509TestIdentity.create("origin-bound certificate identity")
        X509TestPeer(AUTH_HOST, identity.root.certificate).use { authPeer ->
            X509TestPeer(API_HOST, identity.root.certificate).use { apiPeer ->
                MockWebServer().use { unauthorizedPeer ->
                    authPeer.enqueue(tokenResponse(ACCESS_TOKEN))
                    apiPeer.enqueue(filesResponse())
                    unauthorizedPeer.enqueue(filesResponse())
                    val configuration =
                        configuration(
                                identity,
                                listOf(
                                    authPeer.serverRootCertificate,
                                    apiPeer.serverRootCertificate,
                                ),
                            )
                            .withTestProxies(authPeer.proxy, apiPeer.proxy)

                    if (async) {
                        val client =
                            OpenAIOkHttpClientAsync.builder()
                                .x509WorkloadIdentity(configuration)
                                .maxRetries(0)
                                .build()
                        try {
                            client.files().list().get(5, TimeUnit.SECONDS)
                            val cloned =
                                client.withOptions {
                                    it.baseUrl(unauthorizedPeer.url("/v1").toString())
                                    it.httpClient(OkHttpClient.builder().build())
                                }
                            try {
                                assertThatThrownBy {
                                        cloned.files().list().get(5, TimeUnit.SECONDS)
                                    }
                                    .isInstanceOf(ExecutionException::class.java)
                                    .hasRootCauseInstanceOf(OpenAIException::class.java)
                                    .hasMessageContaining("destination is not authorized")
                            } finally {
                                cloned.close()
                            }
                        } finally {
                            client.close()
                        }
                    } else {
                        val client =
                            OpenAIOkHttpClient.builder()
                                .x509WorkloadIdentity(configuration)
                                .maxRetries(0)
                                .build()
                        try {
                            client.files().list()
                            val cloned =
                                client.withOptions {
                                    it.baseUrl(unauthorizedPeer.url("/v1").toString())
                                    it.httpClient(OkHttpClient.builder().build())
                                }
                            try {
                                assertThatThrownBy { cloned.files().list() }
                                    .isInstanceOf(OpenAIException::class.java)
                                    .hasMessageContaining("destination is not authorized")
                            } finally {
                                cloned.close()
                            }
                        } finally {
                            client.close()
                        }
                    }

                    assertThat(unauthorizedPeer.requestCount).isZero()
                    assertThat(authPeer.server.requestCount).isEqualTo(2)
                }
            }
        }
    }

    private fun verifyRefresh(async: Boolean) {
        val identity = X509TestIdentity.create("refresh certificate identity")
        X509TestPeer(AUTH_HOST, identity.root.certificate).use { authPeer ->
            X509TestPeer(API_HOST, identity.root.certificate).use { apiPeer ->
                authPeer.enqueue(tokenResponse("first-test-token", expiresInSeconds = 1))
                authPeer.server.enqueue(tokenResponse("second-test-token", expiresInSeconds = 3600))
                apiPeer.enqueue(filesResponse())
                apiPeer.server.enqueue(filesResponse())
                val configuration =
                    configuration(
                            identity,
                            listOf(authPeer.serverRootCertificate, apiPeer.serverRootCertificate),
                            Duration.ofSeconds(2),
                        )
                        .withTestProxies(authPeer.proxy, apiPeer.proxy)

                if (async) {
                    val client =
                        OpenAIOkHttpClientAsync.builder()
                            .x509WorkloadIdentity(configuration)
                            .maxRetries(0)
                            .build()
                    try {
                        client.files().list().get(5, TimeUnit.SECONDS)
                        client.files().list().get(5, TimeUnit.SECONDS)
                    } finally {
                        client.close()
                    }
                } else {
                    val client =
                        OpenAIOkHttpClient.builder()
                            .x509WorkloadIdentity(configuration)
                            .maxRetries(0)
                            .build()
                    try {
                        client.files().list()
                        client.files().list()
                    } finally {
                        client.close()
                    }
                }

                authPeer.takeRequest()
                assertThat(authPeer.takeRequest().path).isEqualTo("/oauth/token")
                assertThat(authPeer.takeRequest().path).isEqualTo("/oauth/token")
                apiPeer.takeRequest()
                assertThat(apiPeer.takeRequest().getHeader("Authorization"))
                    .isEqualTo("Bearer first-test-token")
                assertThat(apiPeer.takeRequest().getHeader("Authorization"))
                    .isEqualTo("Bearer second-test-token")
            }
        }
    }

    private fun verifyUnrepresentableTokenExpiration(async: Boolean) {
        val identity = X509TestIdentity.create("invalid expiration certificate identity")
        X509TestPeer(AUTH_HOST, identity.root.certificate).use { authPeer ->
            X509TestPeer(API_HOST, identity.root.certificate).use { apiPeer ->
                authPeer.enqueue(tokenResponse("fake-invalid-expiration-token", Long.MAX_VALUE))
                val configuration =
                    configuration(
                            identity,
                            listOf(authPeer.serverRootCertificate, apiPeer.serverRootCertificate),
                        )
                        .withTestProxies(authPeer.proxy, apiPeer.proxy)

                if (async) {
                    val client =
                        OpenAIOkHttpClientAsync.builder()
                            .x509WorkloadIdentity(configuration)
                            .maxRetries(0)
                            .build()
                    try {
                        assertThatThrownBy { client.files().list().get(5, TimeUnit.SECONDS) }
                            .isInstanceOf(ExecutionException::class.java)
                            .hasCauseInstanceOf(OpenAIInvalidDataException::class.java)
                            .hasMessageContaining("token expiration")
                    } finally {
                        client.close()
                    }
                } else {
                    val client =
                        OpenAIOkHttpClient.builder()
                            .x509WorkloadIdentity(configuration)
                            .maxRetries(0)
                            .build()
                    try {
                        assertThatThrownBy { client.files().list() }
                            .isInstanceOf(OpenAIInvalidDataException::class.java)
                            .hasMessageContaining("token expiration")
                    } finally {
                        client.close()
                    }
                }

                assertThat(apiPeer.server.requestCount).isZero()
            }
        }
    }

    private fun verifyRejectedTokenRecovery(async: Boolean) {
        val identity = X509TestIdentity.create("rejected token certificate identity")
        X509TestPeer(AUTH_HOST, identity.root.certificate).use { authPeer ->
            X509TestPeer(API_HOST, identity.root.certificate).use { apiPeer ->
                authPeer.enqueue(tokenResponse("rejected-test-token"))
                authPeer.server.enqueue(tokenResponse("refreshed-test-token"))
                apiPeer.enqueue(MockResponse().setResponseCode(401))
                apiPeer.server.enqueue(filesResponse())
                val configuration =
                    configuration(
                            identity,
                            listOf(authPeer.serverRootCertificate, apiPeer.serverRootCertificate),
                        )
                        .withTestProxies(authPeer.proxy, apiPeer.proxy)

                if (async) {
                    val client =
                        OpenAIOkHttpClientAsync.builder()
                            .x509WorkloadIdentity(configuration)
                            .maxRetries(1)
                            .build()
                    try {
                        client.files().list().get(5, TimeUnit.SECONDS)
                    } finally {
                        client.close()
                    }
                } else {
                    val client =
                        OpenAIOkHttpClient.builder()
                            .x509WorkloadIdentity(configuration)
                            .maxRetries(1)
                            .build()
                    try {
                        client.files().list()
                    } finally {
                        client.close()
                    }
                }

                authPeer.takeRequest()
                assertThat(authPeer.takeRequest().path).isEqualTo("/oauth/token")
                assertThat(authPeer.takeRequest().path).isEqualTo("/oauth/token")
                apiPeer.takeRequest()
                assertThat(apiPeer.takeRequest().getHeader("Authorization"))
                    .isEqualTo("Bearer rejected-test-token")
                assertThat(apiPeer.takeRequest().getHeader("Authorization"))
                    .isEqualTo("Bearer refreshed-test-token")
            }
        }
    }

    private fun configuration(
        identity: X509TestIdentity,
        serverRoots: Iterable<java.security.cert.X509Certificate>,
        refreshBuffer: Duration = Duration.ofMinutes(20),
    ): X509WorkloadIdentity {
        val trustManager =
            HandshakeCertificates.Builder()
                .apply { serverRoots.forEach { addTrustedCertificate(it) } }
                .build()
                .trustManager
        val transport =
            X509Transport.builder()
                .keyManager(x509TestKeyManager(mapOf(CERTIFICATE_ALIAS to identity)))
                .certificateAlias(CERTIFICATE_ALIAS)
                .trustManager(trustManager)
                .build()
        return X509WorkloadIdentity.builder()
            .identityProviderId(IDENTITY_PROVIDER_ID)
            .serviceAccountId(SERVICE_ACCOUNT_ID)
            .transport(transport)
            .refreshBuffer(refreshBuffer)
            .build()
    }

    private fun tokenResponse(value: String, expiresInSeconds: Long = 3600): MockResponse =
        MockResponse()
            .setHeader("Content-Type", "application/json")
            .setBody(
                """{"access_token":"$value","token_type":"Bearer","issued_token_type":"urn:ietf:params:oauth:token-type:access_token","expires_in":$expiresInSeconds}"""
            )

    private fun filesResponse(): MockResponse =
        MockResponse()
            .setHeader("Content-Type", "application/json")
            .setBody("""{"object":"list","data":[]}""")

    private companion object {
        const val AUTH_HOST = "mtls.auth.openai.com"
        const val API_HOST = "mtls.api.openai.com"
        const val EU_API_HOST = "mtls-eu.api.openai.com"
        const val CERTIFICATE_ALIAS = "fixed-test-alias"
        const val IDENTITY_PROVIDER_ID = "idp_test"
        const val SERVICE_ACCOUNT_ID = "svc_acct_test"
        const val ACCESS_TOKEN = "fake-x509-access-token"
        val TOKEN_REQUEST =
            """
            {
              "grant_type": "urn:ietf:params:oauth:grant-type:token-exchange",
              "subject_token_type": "urn:openai:params:oauth:token-type:x509",
              "identity_provider_id": "$IDENTITY_PROVIDER_ID",
              "service_account_id": "$SERVICE_ACCOUNT_ID"
            }
            """
                .trimIndent()
    }
}
