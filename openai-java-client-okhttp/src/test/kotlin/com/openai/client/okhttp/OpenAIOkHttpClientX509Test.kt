package com.openai.client.okhttp

import com.fasterxml.jackson.databind.ObjectMapper
import com.openai.auth.X509WorkloadIdentity
import com.openai.credential.BearerTokenCredential
import com.openai.models.files.FileListParams
import java.net.Proxy
import java.security.cert.X509Certificate
import java.time.Duration
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import okhttp3.mockwebserver.SocketPolicy
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class OpenAIOkHttpClientX509Test {
    private val jsonMapper = ObjectMapper()

    @Test
    fun syncClientUsesExactExchangeAndApiWireContract() {
        Fixture().use { fixture ->
            fixture.enqueueSuccess()
            val client =
                fixture
                    .syncBuilder()
                    .putHeader("X-Application-Test", "api-only")
                    .build()
                    .withOptions { options -> options.timeout(Duration.ofSeconds(5)) }

            try {
                assertThat(client.files().list().data()).isEmpty()
            } finally {
                client.close()
            }

            assertSuccessfulWireContract(
                fixture,
                expectedUserAgent = "OpenAIClientImpl/Java",
                expectedApplicationHeader = "api-only",
            )
        }
    }

    @Test
    fun asyncClientUsesExactExchangeAndApiWireContract() {
        Fixture().use { fixture ->
            fixture.enqueueSuccess()
            val client = fixture.asyncBuilder().build()

            try {
                assertThat(client.files().list().get(10, TimeUnit.SECONDS).data()).isEmpty()
            } finally {
                client.close()
            }

            assertSuccessfulWireContract(fixture, expectedUserAgent = "OpenAIClientAsyncImpl/Java")
        }
    }

    @Test
    fun onlyPublicJavaConstructionPathIsX509BuilderFactory() {
        listOf(OpenAIOkHttpClient.Builder::class.java, OpenAIOkHttpClientAsync.Builder::class.java)
            .forEach { builderClass ->
                assertThat(builderClass.constructors).noneMatch { constructor ->
                    !constructor.isSynthetic &&
                        constructor.parameterTypes.contains(X509ClientConfiguration::class.java)
                }
            }
        assertThat(
                X509ClientConfiguration::class.java.constructors.filterNot { constructor ->
                    constructor.isSynthetic
                }
            )
            .isEmpty()
        assertThat(
                BoundX509Transport::class.java.constructors.filterNot { constructor ->
                    constructor.isSynthetic
                }
            )
            .isEmpty()
        assertThat(
                X509ClientConfiguration::class.java.declaredMethods.filterNot { method ->
                    method.isSynthetic
                }
            )
            .isEmpty()
        assertThat(
                OpenAIOkHttpClient::class
                    .java
                    .getMethod(
                        "x509Builder",
                        X509WorkloadIdentity::class.java,
                        X509Transport::class.java,
                    )
            )
            .isNotNull()
        assertThat(
                OpenAIOkHttpClientAsync::class
                    .java
                    .getMethod(
                        "x509Builder",
                        X509WorkloadIdentity::class.java,
                        X509Transport::class.java,
                    )
            )
            .isNotNull()
    }

    @Test
    fun fixedModeRejectsCompetingConfigurationBeforeNetworkUse() {
        Fixture().use { fixture ->
            val syncMutations =
                listOf<Pair<String, (OpenAIOkHttpClient.Builder) -> Unit>>(
                    "baseUrl" to { it.baseUrl("https://example.test/v1") },
                    "apiKey" to { it.apiKey("test-api-key") },
                    "adminApiKey" to { it.adminApiKey("test-admin-key") },
                    "credential" to { it.credential(BearerTokenCredential.create("test-token")) },
                    "organization" to { it.organization("org_test") },
                    "project" to { it.project("proj_test") },
                    "fromEnv" to { it.fromEnv() },
                    "proxy" to { it.proxy(Proxy.NO_PROXY) },
                    "followRedirects" to { it.followRedirects(false) },
                )
            syncMutations.forEach { (name, mutate) ->
                assertThatThrownBy { mutate(fixture.syncBuilder()) }
                    .isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining(name)
            }

            assertThatThrownBy { fixture.asyncBuilder().baseUrl("https://example.test/v1") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("baseUrl")
            assertThatThrownBy { fixture.asyncBuilder().proxy(Proxy.NO_PROXY) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("proxy")
            assertThat(fixture.authPeer.server.requestCount).isZero()
            assertThat(fixture.apiPeer.server.requestCount).isZero()
        }
    }

    @Test
    fun withOptionsCannotMoveBearerToAnotherEndpoint() {
        Fixture().use { fixture ->
            val client = fixture.syncBuilder().build()
            try {
                assertThatThrownBy {
                        client.withOptions { options ->
                            options.baseUrl("https://attacker.example/v1")
                        }
                    }
                    .isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining("baseUrl")
                assertThatThrownBy {
                        client.files().withOptions { options ->
                            options.apiKey("replacement-secret")
                        }
                    }
                    .isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining("apiKey")
            } finally {
                client.close()
            }
            assertThat(fixture.authPeer.server.requestCount).isZero()
            assertThat(fixture.apiPeer.server.requestCount).isZero()
        }
    }

    @Test
    fun callerSuppliedCredentialHeaderIsRejectedBeforeTokenExchange() {
        Fixture().use { fixture ->
            val client = fixture.syncBuilder().putHeader("Authorization", "Bearer secret").build()
            try {
                assertThatThrownBy { client.files().list() }
                    .isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining("Authorization")
                    .hasMessageNotContaining("secret")
            } finally {
                client.close()
            }
            assertThat(fixture.authPeer.server.requestCount).isZero()
            assertThat(fixture.apiPeer.server.requestCount).isZero()
        }
    }

    @Test
    fun requestLevelCredentialHeaderIsRejectedBeforeTokenExchange() {
        Fixture().use { fixture ->
            val client = fixture.syncBuilder().build()
            val params =
                FileListParams.builder()
                    .putAdditionalHeader("api_key", "request-level-secret")
                    .build()
            try {
                assertThatThrownBy { client.files().list(params) }
                    .isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining("api_key")
                    .hasMessageNotContaining("request-level-secret")
            } finally {
                client.close()
            }
            assertThat(fixture.authPeer.server.requestCount).isZero()
            assertThat(fixture.apiPeer.server.requestCount).isZero()
        }
    }

    @Test
    fun adminOnlyRouteFailsLocallyWithoutExchangingToken() {
        Fixture().use { fixture ->
            val client = fixture.syncBuilder().build()
            try {
                assertThatThrownBy { client.admin().organization().auditLogs().list() }
                    .isInstanceOf(IllegalStateException::class.java)
                    .hasMessageContaining("requires adminApiKey")
            } finally {
                client.close()
            }
            assertThat(fixture.authPeer.server.requestCount).isZero()
            assertThat(fixture.apiPeer.server.requestCount).isZero()
        }
    }

    @Test
    fun closingAsyncClientCancelsBlockedExchangeBeforeApiDispatch() {
        Fixture().use { fixture ->
            fixture.authPeer.enqueue(MockResponse().setSocketPolicy(SocketPolicy.NO_RESPONSE))
            val client = fixture.asyncBuilder().timeout(Duration.ofSeconds(30)).build()
            val future = client.files().list()

            assertConnectAuthority(fixture.authPeer.takeRequest(), AUTH_AUTHORITY)
            assertThat(fixture.authPeer.takeRequest().path).isEqualTo("/oauth/token")
            client.close()

            assertThatThrownBy { future.get(5, TimeUnit.SECONDS) }
                .isInstanceOf(ExecutionException::class.java)
            assertThat(fixture.apiPeer.server.requestCount).isZero()
        }
    }

    @Test
    fun closingSyncClientCancelsBlockedExchangeBeforeApiDispatch() {
        Fixture().use { fixture ->
            fixture.authPeer.enqueue(MockResponse().setSocketPolicy(SocketPolicy.NO_RESPONSE))
            val client = fixture.syncBuilder().timeout(Duration.ofSeconds(30)).build()
            val executor = Executors.newSingleThreadExecutor()
            val future = executor.submit { client.files().list() }

            try {
                assertConnectAuthority(fixture.authPeer.takeRequest(), AUTH_AUTHORITY)
                assertThat(fixture.authPeer.takeRequest().path).isEqualTo("/oauth/token")
                client.close()

                assertThatThrownBy { future.get(5, TimeUnit.SECONDS) }
                    .isInstanceOf(ExecutionException::class.java)
                assertThat(fixture.apiPeer.server.requestCount).isZero()
            } finally {
                client.close()
                executor.shutdownNow()
            }
        }
    }

    @Test
    fun closingAsyncClientCancelsBlockedApiDispatch() {
        Fixture().use { fixture ->
            fixture.authPeer.enqueue(
                MockResponse().setHeader("Content-Type", "application/json").setBody(TOKEN_RESPONSE)
            )
            fixture.apiPeer.enqueue(MockResponse().setSocketPolicy(SocketPolicy.NO_RESPONSE))
            val client = fixture.asyncBuilder().timeout(Duration.ofSeconds(30)).build()
            val future = client.files().list()

            assertConnectAuthority(fixture.authPeer.takeRequest(), AUTH_AUTHORITY)
            assertThat(fixture.authPeer.takeRequest().path).isEqualTo("/oauth/token")
            assertConnectAuthority(fixture.apiPeer.takeRequest(), API_AUTHORITY)
            assertThat(fixture.apiPeer.takeRequest().path).isEqualTo("/v1/files")
            client.close()

            assertThatThrownBy { future.get(5, TimeUnit.SECONDS) }
                .isInstanceOf(ExecutionException::class.java)
            assertThat(fixture.authPeer.server.requestCount).isEqualTo(2)
            assertThat(fixture.apiPeer.server.requestCount).isEqualTo(2)
        }
    }

    private fun assertSuccessfulWireContract(
        fixture: Fixture,
        expectedUserAgent: String,
        expectedApplicationHeader: String? = null,
    ) {
        val authConnect = fixture.authPeer.takeRequest()
        val exchangeRequest = fixture.authPeer.takeRequest()
        val apiConnect = fixture.apiPeer.takeRequest()
        val apiRequest = fixture.apiPeer.takeRequest()

        assertConnectAuthority(authConnect, AUTH_AUTHORITY)
        assertConnectAuthority(apiConnect, API_AUTHORITY)
        assertThat(exchangeRequest.method).isEqualTo("POST")
        assertThat(exchangeRequest.path).isEqualTo("/oauth/token")
        assertThat(exchangeRequest.getHeader("Authorization")).isNull()
        assertThat(exchangeRequest.getHeader("X-Application-Test")).isNull()
        assertThat(jsonMapper.readTree(exchangeRequest.body.readUtf8()))
            .isEqualTo(jsonMapper.readTree(TOKEN_REQUEST))
        assertThat(apiRequest.method).isEqualTo("GET")
        assertThat(apiRequest.path).isEqualTo("/v1/files")
        assertThat(apiRequest.headers.values("Authorization"))
            .containsExactly("Bearer $ACCESS_TOKEN")
        assertThat(apiRequest.getHeader("api-key")).isNull()
        assertThat(apiRequest.getHeader("Cookie")).isNull()
        assertThat(apiRequest.getHeader("OpenAI-Organization")).isNull()
        assertThat(apiRequest.getHeader("OpenAI-Project")).isNull()
        assertThat(apiRequest.getHeader("X-Application-Test")).isEqualTo(expectedApplicationHeader)
        assertThat(apiRequest.getHeader("User-Agent")).startsWith(expectedUserAgent)
        assertPresentedIdentity(exchangeRequest, fixture.identity.leaf.certificate)
        assertPresentedIdentity(apiRequest, fixture.identity.leaf.certificate)
        assertThat(exchangeRequest.handshake!!.peerCertificates)
            .isEqualTo(apiRequest.handshake!!.peerCertificates)
        assertThat(fixture.authPeer.requestedServerNames).containsExactly(AUTH_HOST)
        assertThat(fixture.apiPeer.requestedServerNames).containsExactly(API_HOST)
    }

    private fun assertConnectAuthority(request: RecordedRequest, authority: String) {
        assertThat(request.requestLine).isEqualTo("CONNECT $authority HTTP/1.1")
    }

    private fun assertPresentedIdentity(request: RecordedRequest, expected: X509Certificate) {
        assertThat(requireNotNull(request.handshake).peerCertificates.first()).isEqualTo(expected)
    }

    private class Fixture : AutoCloseable {
        val identity = X509TestIdentity.create("SDK X.509 identity")
        val authPeer = X509TestPeer(AUTH_HOST, identity.root.certificate)
        val apiPeer = X509TestPeer(API_HOST, identity.root.certificate)
        private val workloadIdentity =
            X509WorkloadIdentity.builder()
                .identityProviderId("idp_test")
                .serviceAccountId("svc_acct_test")
                .build()
        private val transport =
            X509Transport.builder()
                .keyManager(x509TestKeyManager(mapOf(CERTIFICATE_ALIAS to identity)))
                .certificateAlias(CERTIFICATE_ALIAS)
                .trustManager(
                    identity
                        .clientHandshakeCertificates(
                            listOf(authPeer.serverRootCertificate, apiPeer.serverRootCertificate)
                        )
                        .trustManager
                )
                .build()

        fun syncBuilder(): OpenAIOkHttpClient.Builder =
            OpenAIOkHttpClient.x509BuilderForTest(
                workloadIdentity,
                transport,
                authPeer.proxy,
                apiPeer.proxy,
            )

        fun asyncBuilder(): OpenAIOkHttpClientAsync.Builder =
            OpenAIOkHttpClientAsync.x509BuilderForTest(
                workloadIdentity,
                transport,
                authPeer.proxy,
                apiPeer.proxy,
            )

        fun enqueueSuccess() {
            authPeer.enqueue(
                MockResponse().setHeader("Content-Type", "application/json").setBody(TOKEN_RESPONSE)
            )
            apiPeer.enqueue(
                MockResponse().setHeader("Content-Type", "application/json").setBody(FILES_RESPONSE)
            )
        }

        override fun close() {
            apiPeer.use { authPeer.close() }
        }
    }

    private companion object {
        const val AUTH_HOST = "mtls.auth.openai.com"
        const val API_HOST = "mtls.api.openai.com"
        const val AUTH_AUTHORITY = "$AUTH_HOST:443"
        const val API_AUTHORITY = "$API_HOST:443"
        const val ACCESS_TOKEN = "test-x509-access-token"
        const val CERTIFICATE_ALIAS = "selected"
        const val ACCESS_TOKEN_TYPE = "urn:ietf:params:oauth:token-type:access_token"
        const val FILES_RESPONSE = """{"object":"list","data":[]}"""
        val TOKEN_REQUEST =
            """
            {
              "grant_type": "urn:ietf:params:oauth:grant-type:token-exchange",
              "subject_token_type": "urn:openai:params:oauth:token-type:x509",
              "identity_provider_id": "idp_test",
              "service_account_id": "svc_acct_test"
            }
            """
                .trimIndent()
        val TOKEN_RESPONSE =
            """
            {
              "access_token": "$ACCESS_TOKEN",
              "issued_token_type": "$ACCESS_TOKEN_TYPE",
              "token_type": "Bearer",
              "expires_in": 3600
            }
            """
                .trimIndent()
    }
}
