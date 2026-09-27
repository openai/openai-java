package com.openai.client.okhttp

import com.fasterxml.jackson.databind.ObjectMapper
import java.net.Proxy
import java.security.cert.X509Certificate
import javax.net.ssl.SSLPeerUnverifiedException
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

/**
 * Executable wire contract for the X.509 workload-identity implementation introduced by later PRs.
 * This is deliberately independent of SDK production code.
 *
 * The bearer is not certificate-bound. The exchange and API TLS connections may present different
 * certificates that are each independently accepted by their destination.
 */
internal class X509WorkloadIdentityWireContractTest {
    private val jsonMapper = ObjectMapper()

    @Test
    fun referenceFlowUsesExactAuthoritiesAndIndependentClientCertificates() {
        val exchangeIdentity = X509TestIdentity.create("exchange identity")
        val apiIdentity = X509TestIdentity.create("api identity")
        X509TestPeer(AUTH_HOST, exchangeIdentity.root.certificate).use { authPeer ->
            X509TestPeer(API_HOST, apiIdentity.root.certificate).use { apiPeer ->
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

                val accessToken =
                    mtlsClient(
                            exchangeIdentity,
                            listOf(authPeer.serverRootCertificate),
                            authPeer.proxy,
                        )
                        .useTestClient(::exchangeToken)
                mtlsClient(apiIdentity, listOf(apiPeer.serverRootCertificate), apiPeer.proxy)
                    .useTestClient { client -> callApi(client, accessToken) }

                val authConnect = authPeer.takeRequest()
                val exchangeRequest = authPeer.takeRequest()
                val apiConnect = apiPeer.takeRequest()
                val apiRequest = apiPeer.takeRequest()
                assertConnectAuthority(authConnect, AUTH_AUTHORITY)
                assertConnectAuthority(apiConnect, API_AUTHORITY)
                assertThat(exchangeRequest.method).isEqualTo("POST")
                assertThat(exchangeRequest.path).isEqualTo("/oauth/token")
                assertThat(exchangeRequest.getHeader("Authorization")).isNull()
                assertThat(exchangeRequest.getHeader("Content-Type")).startsWith("application/json")
                assertThat(jsonMapper.readTree(exchangeRequest.body.readUtf8()))
                    .isEqualTo(jsonMapper.readTree(TOKEN_REQUEST))
                assertThat(apiRequest.method).isEqualTo("GET")
                assertThat(apiRequest.path).isEqualTo("/v1/files")
                assertThat(apiRequest.getHeader("Authorization")).isEqualTo("Bearer $ACCESS_TOKEN")
                assertPresentedCertificate(exchangeRequest, exchangeIdentity.leaf.certificate)
                assertPresentedCertificate(apiRequest, apiIdentity.leaf.certificate)
                assertThat(authPeer.requestedServerNames).containsExactly(AUTH_HOST)
                assertThat(apiPeer.requestedServerNames).containsExactly(API_HOST)
            }
        }
    }

    @Test
    fun referenceClientsDoNotFollowRedirectsOnEitherLeg() {
        val identity = X509TestIdentity.create("redirect test identity")
        X509TestPeer(AUTH_HOST, identity.root.certificate).use { authPeer ->
            X509TestPeer(API_HOST, identity.root.certificate).use { apiPeer ->
                authPeer.enqueue(MockResponse().setResponseCode(307).setHeader("Location", API_URL))
                authPeer.enqueue(MockResponse())
                apiPeer.enqueue(MockResponse().setResponseCode(307).setHeader("Location", AUTH_URL))
                apiPeer.enqueue(MockResponse())

                mtlsClient(identity, listOf(authPeer.serverRootCertificate), authPeer.proxy)
                    .useTestClient { client ->
                        client.newCall(tokenRequest()).execute().use { response ->
                            assertThat(response.code).isEqualTo(307)
                        }
                    }
                mtlsClient(identity, listOf(apiPeer.serverRootCertificate), apiPeer.proxy)
                    .useTestClient { client ->
                        client.newCall(apiRequest(ACCESS_TOKEN)).execute().use { response ->
                            assertThat(response.code).isEqualTo(307)
                        }
                    }

                assertThat(authPeer.server.requestCount).isEqualTo(2)
                assertThat(apiPeer.server.requestCount).isEqualTo(2)
                assertConnectAuthority(authPeer.takeRequest(), AUTH_AUTHORITY)
                assertThat(authPeer.takeRequest().path).isEqualTo("/oauth/token")
                assertConnectAuthority(apiPeer.takeRequest(), API_AUTHORITY)
                assertThat(apiPeer.takeRequest().path).isEqualTo("/v1/files")
            }
        }
    }

    @Test
    fun tlsPeerCannotImpersonateAnotherAuthority() {
        val identity = X509TestIdentity.create("authority test identity")
        X509TestPeer(AUTH_HOST, identity.root.certificate).use { authPeer ->
            authPeer.enqueue(MockResponse())
            val client =
                mtlsClient(identity, listOf(authPeer.serverRootCertificate), authPeer.proxy)

            client.useTestClient {
                assertThatThrownBy {
                        it.newCall(apiRequest(ACCESS_TOKEN)).execute().use { response ->
                            response.body?.string()
                        }
                    }
                    .isInstanceOf(SSLPeerUnverifiedException::class.java)
            }
            assertThat(authPeer.server.requestCount).isEqualTo(1)
            assertConnectAuthority(authPeer.takeRequest(), API_AUTHORITY)
            assertThat(authPeer.requestedServerNames).containsExactly(API_HOST)
        }
    }

    private fun exchangeToken(client: OkHttpClient): String {
        client.newCall(tokenRequest()).execute().use { response ->
            assertThat(response.code).isEqualTo(200)
            val body = jsonMapper.readTree(requireNotNull(response.body).string())
            assertThat(body.path("issued_token_type").asText()).isEqualTo(ACCESS_TOKEN_TYPE)
            assertThat(body.path("token_type").asText()).isEqualTo("Bearer")
            assertThat(body.path("expires_in").asLong()).isEqualTo(3600)
            return body.path("access_token").asText()
        }
    }

    private fun callApi(client: OkHttpClient, accessToken: String) {
        client.newCall(apiRequest(accessToken)).execute().use { response ->
            assertThat(response.code).isEqualTo(200)
        }
    }

    private fun mtlsClient(
        identity: X509TestIdentity,
        trustedServerRoots: Iterable<X509Certificate>,
        proxy: Proxy,
    ): OkHttpClient {
        val handshakeCertificates = identity.clientHandshakeCertificates(trustedServerRoots)
        return OkHttpClient.Builder()
            .sslSocketFactory(
                handshakeCertificates.sslSocketFactory(),
                handshakeCertificates.trustManager,
            )
            .proxy(proxy)
            .followRedirects(false)
            .followSslRedirects(false)
            .build()
    }

    private fun tokenRequest(): Request =
        Request.Builder().url(AUTH_URL).post(TOKEN_REQUEST.toRequestBody(JSON_MEDIA_TYPE)).build()

    private fun apiRequest(accessToken: String): Request =
        Request.Builder()
            .url("$API_URL/v1/files")
            .header("Authorization", "Bearer $accessToken")
            .get()
            .build()

    private fun assertConnectAuthority(request: RecordedRequest, authority: String) {
        assertThat(request.requestLine).isEqualTo("CONNECT $authority HTTP/1.1")
    }

    private fun assertPresentedCertificate(request: RecordedRequest, expected: X509Certificate) {
        assertThat(requireNotNull(request.handshake).peerCertificates).containsExactly(expected)
    }

    private companion object {
        const val AUTH_HOST = "mtls.auth.openai.com"
        const val API_HOST = "mtls.api.openai.com"
        const val AUTH_AUTHORITY = "$AUTH_HOST:443"
        const val API_AUTHORITY = "$API_HOST:443"
        const val AUTH_URL = "https://$AUTH_HOST/oauth/token"
        const val API_URL = "https://$API_HOST"
        const val ACCESS_TOKEN = "test-x509-access-token"
        const val ACCESS_TOKEN_TYPE = "urn:ietf:params:oauth:token-type:access_token"
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
        val JSON_MEDIA_TYPE = "application/json".toMediaType()
    }
}
