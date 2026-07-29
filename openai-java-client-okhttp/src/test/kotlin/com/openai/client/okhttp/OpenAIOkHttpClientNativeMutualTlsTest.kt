package com.openai.client.okhttp

import com.openai.client.OpenAIClient
import com.openai.errors.OpenAIIoException
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.security.KeyStore
import java.security.cert.X509Certificate
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

            assertThat(fixture.server.takeRequest().path).isEqualTo("/v1/files")
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

    private fun nativeMutualTlsClient(
        chain: Array<X509Certificate>,
        serverTrustManager: X509TrustManager,
        baseUrl: String,
    ): OpenAIClient {
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

        return OpenAIOkHttpClient.builder()
            .apiKey("test")
            .baseUrl(baseUrl)
            .followRedirects(false)
            .sslSocketFactory(sslContext.socketFactory)
            .trustManager(serverTrustManager)
            .maxRetries(0)
            .build()
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
