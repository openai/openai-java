package com.openai.client.okhttp

import com.openai.auth.WorkloadIdentity
import com.openai.client.OpenAIClient
import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.errors.OpenAIIoException
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.security.KeyStore
import java.security.cert.X509Certificate
import java.util.concurrent.CompletableFuture
import javax.net.ssl.KeyManagerFactory
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.tls.HandshakeCertificates
import okhttp3.tls.HeldCertificate
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class OpenAIOkHttpClientNativeMutualTlsTest {

    private val clientRoot =
        HeldCertificate.Builder().commonName("client root").certificateAuthority(2).build()
    private val clientIntermediate =
        HeldCertificate.Builder()
            .commonName("client intermediate")
            .certificateAuthority(1)
            .signedBy(clientRoot)
            .build()
    private val clientLeaf =
        HeldCertificate.Builder().commonName("client leaf").signedBy(clientIntermediate).build()

    @Test
    fun publicX509ClientBuildersRejectPlaintextApiEndpoints() {
        val workloadIdentity =
            WorkloadIdentity.x509Builder()
                .identityProviderId("idp_test")
                .serviceAccountId("svc_acct_test")
                .build()

        listOf(false, true).forEach { async ->
            assertThatThrownBy {
                    if (async) {
                        OpenAIOkHttpClientAsync.builder()
                            .baseUrl("http://localhost:8080/v1")
                            .workloadIdentity(workloadIdentity)
                            .build()
                    } else {
                        OpenAIOkHttpClient.builder()
                            .baseUrl("http://localhost:8080/v1")
                            .workloadIdentity(workloadIdentity)
                            .build()
                    }
                }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("X.509 workload identity requires an absolute HTTPS base URL")
        }
    }

    @Test
    fun nativeMutualTlsPresentsFullPkcs12Chain() {
        mutuallyAuthenticatedServer().use { fixture ->
            fixture.server.enqueue(
                MockResponse()
                    .setHeader("Content-Type", "application/json")
                    .setBody("""{"object":"list","data":[]}""")
            )
            val client =
                nativeMutualTlsClient(
                    arrayOf(clientLeaf.certificate, clientIntermediate.certificate),
                    fixture.clientTrust.trustManager,
                    fixture.baseUrl,
                )

            try {
                client.files().list()
            } finally {
                client.close()
            }

            val request = fixture.server.takeRequest()
            assertThat(request.path).isEqualTo("/v1/files")
            assertThat(requireNotNull(request.handshake).peerCertificates)
                .containsSubsequence(clientLeaf.certificate, clientIntermediate.certificate)
        }
    }

    @Test
    fun nativeMutualTlsFailsClosedWhenIntermediateIsMissing() {
        mutuallyAuthenticatedServer().use { fixture ->
            fixture.server.enqueue(
                MockResponse()
                    .setHeader("Content-Type", "application/json")
                    .setBody("""{"object":"list","data":[]}""")
            )
            val client =
                nativeMutualTlsClient(
                    arrayOf(clientLeaf.certificate),
                    fixture.clientTrust.trustManager,
                    fixture.baseUrl,
                )

            try {
                assertThatThrownBy { client.files().list() }
                    .isInstanceOf(OpenAIIoException::class.java)
                    .hasCauseInstanceOf(IOException::class.java)
            } finally {
                client.close()
            }

            assertThat(fixture.server.requestCount).isZero()
        }
    }

    @Test
    fun x509WorkloadIdentityUsesSameFullChainTransportForExchangeAndApi() {
        mutuallyAuthenticatedServer().use { fixture ->
            fixture.server.enqueue(
                MockResponse()
                    .setHeader("Content-Type", "application/json")
                    .setBody(
                        """{"access_token":"test-token","issued_token_type":"urn:ietf:params:oauth:token-type:access_token","token_type":"Bearer","expires_in":3600}"""
                    )
            )
            fixture.server.enqueue(
                MockResponse()
                    .setHeader("Content-Type", "application/json")
                    .setBody("""{"object":"list","data":[]}""")
            )
            val transport =
                routingTokenExchangeTo(
                    nativeMutualTlsTransport(
                        arrayOf(clientLeaf.certificate, clientIntermediate.certificate),
                        fixture.clientTrust.trustManager,
                    ),
                    fixture.server.url("/oauth/token").toString(),
                )
            val client =
                OpenAIClientImpl(
                    ClientOptions.builder()
                        .httpClient(transport)
                        .baseUrl(fixture.baseUrl)
                        .workloadIdentity(
                            WorkloadIdentity.x509Builder()
                                .identityProviderId("idp_test")
                                .serviceAccountId("svc_acct_test")
                                .build()
                        )
                        .build()
                )

            try {
                client.files().list()
            } finally {
                client.close()
            }

            val exchange = fixture.server.takeRequest()
            val api = fixture.server.takeRequest()
            assertThat(exchange.path).isEqualTo("/oauth/token")
            assertThat(exchange.getHeader("Authorization")).isNull()
            assertThat(api.path).isEqualTo("/v1/files")
            assertThat(api.getHeader("Authorization")).isEqualTo("Bearer test-token")
            listOf(exchange, api).forEach { request ->
                assertThat(requireNotNull(request.handshake).peerCertificates)
                    .containsSubsequence(clientLeaf.certificate, clientIntermediate.certificate)
            }
        }
    }

    private fun nativeMutualTlsClient(
        chain: Array<X509Certificate>,
        serverTrustManager: X509TrustManager,
        baseUrl: String,
    ): OpenAIClient {
        val sslContext = nativeMutualTlsSslContext(chain, serverTrustManager)
        return OpenAIOkHttpClient.builder()
            .apiKey("test")
            .baseUrl(baseUrl)
            .followRedirects(false)
            .sslSocketFactory(sslContext.socketFactory)
            .trustManager(serverTrustManager)
            .maxRetries(0)
            .build()
    }

    private fun nativeMutualTlsTransport(
        chain: Array<X509Certificate>,
        serverTrustManager: X509TrustManager,
    ): OkHttpClient =
        OkHttpClient.builder()
            .followRedirects(false)
            .sslSocketFactory(nativeMutualTlsSslContext(chain, serverTrustManager).socketFactory)
            .trustManager(serverTrustManager)
            .build()

    private fun nativeMutualTlsSslContext(
        chain: Array<X509Certificate>,
        serverTrustManager: X509TrustManager,
    ): SSLContext {
        val password = "test password".toCharArray()
        val storedKeyStore =
            KeyStore.getInstance("PKCS12").apply {
                load(null, null)
                setKeyEntry("client", clientLeaf.keyPair.private, password, chain)
            }
        val encodedKeyStore =
            ByteArrayOutputStream().use { output ->
                storedKeyStore.store(output, password)
                output.toByteArray()
            }
        val loadedKeyStore =
            KeyStore.getInstance("PKCS12").apply {
                ByteArrayInputStream(encodedKeyStore).use { input -> load(input, password) }
            }
        val keyManagers =
            KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()).apply {
                init(loadedKeyStore, password)
            }
        val sslContext =
            SSLContext.getInstance("TLS").apply {
                init(keyManagers.keyManagers, arrayOf<TrustManager>(serverTrustManager), null)
            }

        return sslContext
    }

    private fun routingTokenExchangeTo(delegate: HttpClient, tokenExchangeUrl: String): HttpClient =
        object : HttpClient {
            override fun execute(
                request: HttpRequest,
                requestOptions: RequestOptions,
            ): HttpResponse = delegate.execute(route(request), requestOptions)

            override fun executeAsync(
                request: HttpRequest,
                requestOptions: RequestOptions,
            ): CompletableFuture<HttpResponse> =
                delegate.executeAsync(route(request), requestOptions)

            override fun close() = delegate.close()

            private fun route(request: HttpRequest): HttpRequest =
                if (request.url() == "https://mtls.auth.openai.com/oauth/token") {
                    request.toBuilder().baseUrl(tokenExchangeUrl).build()
                } else {
                    request
                }
        }

    private fun mutuallyAuthenticatedServer(): MutualTlsServer {
        val serverRoot =
            HeldCertificate.Builder().commonName("server root").certificateAuthority(1).build()
        val serverCertificate =
            HeldCertificate.Builder()
                .commonName("localhost")
                .addSubjectAlternativeName("localhost")
                .signedBy(serverRoot)
                .build()
        val serverIdentity =
            HandshakeCertificates.Builder()
                .heldCertificate(serverCertificate)
                .addTrustedCertificate(clientRoot.certificate)
                .build()
        val clientTrust =
            HandshakeCertificates.Builder().addTrustedCertificate(serverRoot.certificate).build()
        val server =
            MockWebServer().apply {
                useHttps(serverIdentity.sslSocketFactory(), false)
                requireClientAuth()
                start()
            }
        return MutualTlsServer(server, clientTrust)
    }

    private data class MutualTlsServer(
        val server: MockWebServer,
        val clientTrust: HandshakeCertificates,
    ) : AutoCloseable {
        val baseUrl: String
            get() = server.url("/v1").toString().removeSuffix("/")

        override fun close() {
            server.close()
        }
    }
}
