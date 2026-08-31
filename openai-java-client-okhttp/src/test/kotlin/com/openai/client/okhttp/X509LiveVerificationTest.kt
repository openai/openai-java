package com.openai.client.okhttp

import com.openai.core.RequestOptions
import com.openai.core.Timeout
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.errors.UnexpectedStatusCodeException
import java.io.ByteArrayInputStream
import java.io.IOException
import java.net.Socket
import java.security.KeyStore
import java.security.Principal
import java.security.PrivateKey
import java.security.cert.X509Certificate
import java.time.Duration
import java.util.Arrays
import java.util.Base64
import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicBoolean
import javax.net.ssl.KeyManagerFactory
import javax.net.ssl.SSLEngine
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509ExtendedKeyManager
import javax.net.ssl.X509TrustManager
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable

/**
 * Explicitly opt-in verification against the enrolled production issuer and mTLS API.
 *
 * This uses the production token exchange over the fixed-origin transport capability so the live
 * gate remains useful before higher-level X.509 client integration exists. It never logs response
 * bodies, tokens, certificate material, aliases, or enrollment identifiers.
 */
@EnabledIfEnvironmentVariable(named = "OPENAI_X509_LIVE_TEST", matches = "1")
internal class X509LiveVerificationTest {
    @Test
    fun enrolledCertificateCompletesIssuerAndApiLegs() {
        LiveConfiguration.fromEnvironment().use { configuration ->
            val keyStore =
                KeyStore.getInstance("PKCS12").apply {
                    ByteArrayInputStream(configuration.pkcs12).use { input ->
                        load(input, configuration.password)
                    }
                }
            val keyManager =
                KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm())
                    .apply { init(keyStore, configuration.password) }
                    .keyManagers
                    .filterIsInstance<X509ExtendedKeyManager>()
                    .firstOrNull()
                    ?: error(
                        "The configured PKCS#12 identity did not provide an X.509 key manager."
                    )
            val recordingKeyManager =
                HandshakeRecordingKeyManager(keyManager, configuration.certificateAlias)
            val trustManager = defaultTrustManager()
            val transport =
                X509Transport.builder()
                    .keyManager(recordingKeyManager)
                    .certificateAlias(configuration.certificateAlias)
                    .trustManager(trustManager)
                    .build()

            transport.bind(LIVE_TIMEOUT).use { bound ->
                val accessToken =
                    X509LiveDiagnostics.issuerExchange(bound.exchangeClient) { issuerClient ->
                        X509TokenExchange(
                                configuration.identityProviderId,
                                configuration.serviceAccountId,
                                issuerClient,
                            )
                            .use { exchange -> exchange.execute().value }
                    }
                recordingKeyManager.requireClientAliasSelection("issuer exchange")
                verifyApi(bound.apiClient, accessToken)
                recordingKeyManager.requireClientAliasSelection("mTLS API")
            }
        }

        println("X.509 live verification passed: issuer exchange and mTLS API request completed.")
    }

    private fun verifyApi(client: OkHttpClient, accessToken: String) {
        execute(client, X509LiveRequests.api(accessToken), "mTLS API").use { response ->
            requireSuccessful(response, "mTLS API")
        }
    }

    private fun requireSuccessful(response: HttpResponse, stage: String) =
        X509LiveDiagnostics.requireSuccessful(response, stage)

    private fun execute(client: OkHttpClient, request: HttpRequest, stage: String): HttpResponse =
        try {
            client.execute(request)
        } catch (_: Exception) {
            throw IllegalStateException("$stage failed before receiving an HTTP response.")
        }

    private fun defaultTrustManager(): X509TrustManager =
        TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
            .apply { init(null as KeyStore?) }
            .trustManagers
            .filterIsInstance<X509TrustManager>()
            .firstOrNull()
            ?: error("The JVM default trust store did not provide an X.509 trust manager.")

    private companion object {
        val LIVE_TIMEOUT =
            Timeout.builder()
                .connect(Duration.ofSeconds(20))
                .read(Duration.ofSeconds(30))
                .write(Duration.ofSeconds(30))
                .request(Duration.ofSeconds(45))
                .build()
    }
}

internal object X509LiveRequests {
    private const val API_ORIGIN = "https://mtls.api.openai.com"

    fun api(accessToken: String): HttpRequest =
        HttpRequest.builder()
            .method(HttpMethod.GET)
            .baseUrl(API_ORIGIN)
            .addPathSegments("v1", "models")
            .putHeader("Authorization", "Bearer $accessToken")
            .build()
}

internal class HandshakeRecordingKeyManager(
    private val delegate: X509ExtendedKeyManager,
    private val expectedAlias: String,
) : X509ExtendedKeyManager() {
    private val expectedAliasWasEligible = AtomicBoolean()

    fun requireClientAliasSelection(stage: String) {
        check(expectedAliasWasEligible.getAndSet(false)) {
            "$stage completed without selecting the configured X.509 client certificate."
        }
    }

    override fun getClientAliases(keyType: String, issuers: Array<out Principal>?): Array<String>? =
        delegate.getClientAliases(keyType, issuers).also { aliases ->
            if (aliases?.any { it == expectedAlias } == true) {
                expectedAliasWasEligible.set(true)
            }
        }

    override fun chooseClientAlias(
        keyType: Array<out String>?,
        issuers: Array<out Principal>?,
        socket: Socket?,
    ): String? = delegate.chooseClientAlias(keyType, issuers, socket)

    override fun chooseEngineClientAlias(
        keyType: Array<out String>?,
        issuers: Array<out Principal>?,
        engine: SSLEngine?,
    ): String? = delegate.chooseEngineClientAlias(keyType, issuers, engine)

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

internal object X509LiveDiagnostics {
    private val safeRequestId = Regex("^[A-Za-z0-9._:-]{1,128}$")

    fun <T> issuerExchange(client: HttpClient, action: (HttpClient) -> T): T {
        var requestId: String? = null
        val capturingClient =
            object : HttpClient by client {
                override fun execute(request: HttpRequest): HttpResponse =
                    client.execute(request).also { response ->
                        requestId =
                            response.requestId().orElse(null)?.takeIf(safeRequestId::matches)
                    }
            }

        return issuerExchange({ requestId }) { action(capturingClient) }
    }

    fun <T> issuerExchange(action: () -> T): T = issuerExchange({ null }, action)

    private fun <T> issuerExchange(requestId: () -> String?, action: () -> T): T =
        try {
            action()
        } catch (error: UnexpectedStatusCodeException) {
            val requestIdSuffix = requestId()?.let { " (request_id=$it)" }.orEmpty()
            throw IllegalStateException(
                "issuer exchange failed with HTTP ${error.statusCode()}$requestIdSuffix."
            )
        } catch (_: Exception) {
            val requestIdSuffix = requestId()?.let { " (request_id=$it)" }.orEmpty()
            throw IllegalStateException(
                "issuer exchange failed before receiving a valid response$requestIdSuffix."
            )
        }

    fun requireSuccessful(response: HttpResponse, stage: String) {
        check(response.statusCode() in 200..299) {
            "$stage failed with HTTP ${response.statusCode()}${requestIdSuffix(response)}."
        }
    }

    private fun requestIdSuffix(response: HttpResponse): String =
        response
            .requestId()
            .orElse(null)
            ?.takeIf(safeRequestId::matches)
            ?.let { " (request_id=$it)" }
            .orEmpty()
}

internal class X509LiveVerificationDiagnosticsTest {
    @Test
    fun malformedIssuerResponsesPreserveOnlySafeRequestIdsFromProductionExchange() {
        mapOf(
                "req_123-abc:456" to " (request_id=req_123-abc:456)",
                "request id containing sensitive text" to "",
                "x".repeat(129) to "",
            )
            .forEach { (requestId, expectedSuffix) ->
                val response =
                    StubLiveResponse(
                        200,
                        requestId,
                        "customer-data secret-token",
                        mapOf("Authorization" to "Bearer secret-token"),
                    )
                val client = StubLiveClient(response)

                assertThatThrownBy {
                        X509LiveDiagnostics.issuerExchange(client) { issuerClient ->
                            X509TokenExchange("idp_test", "svc_acct_test", issuerClient).use {
                                exchange ->
                                exchange.execute()
                            }
                        }
                    }
                    .isInstanceOf(IllegalStateException::class.java)
                    .hasMessage(
                        "issuer exchange failed before receiving a valid response$expectedSuffix."
                    )
                    .hasNoCause()
                    .hasMessageNotContaining("sensitive")
                    .hasMessageNotContaining("customer-data")
                    .hasMessageNotContaining("secret-token")
            }
    }

    @Test
    fun issuerFailuresPreserveOnlySafeRequestIdsFromProductionExchange() {
        mapOf(
                "req_123-abc:456" to " (request_id=req_123-abc:456)",
                "request id containing sensitive text" to "",
                "x".repeat(129) to "",
            )
            .forEach { (requestId, expectedSuffix) ->
                val response =
                    StubLiveResponse(
                        403,
                        requestId,
                        """{"error":"invalid_grant","error_description":"customer-data"}""",
                        mapOf(
                            "Authorization" to "Bearer secret-token",
                            "X-Customer" to "customer-data",
                        ),
                    )
                val client = StubLiveClient(response)

                assertThatThrownBy {
                        X509LiveDiagnostics.issuerExchange(client) { issuerClient ->
                            X509TokenExchange("idp_test", "svc_acct_test", issuerClient).use {
                                exchange ->
                                exchange.execute()
                            }
                        }
                    }
                    .isInstanceOf(IllegalStateException::class.java)
                    .hasMessage("issuer exchange failed with HTTP 403$expectedSuffix.")
                    .hasNoCause()
                    .hasMessageNotContaining("sensitive")
                    .hasMessageNotContaining("customer-data")
                    .hasMessageNotContaining("secret-token")
            }
    }

    @Test
    fun issuerExchangeFailuresNeverIncludeUnderlyingCauses() {
        assertThatThrownBy {
                X509LiveDiagnostics.issuerExchange {
                    throw IOException("customer-data enrollment-id secret-token")
                }
            }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("issuer exchange failed before receiving a valid response.")
            .hasNoCause()
            .hasMessageNotContaining("customer-data")
            .hasMessageNotContaining("enrollment-id")
            .hasMessageNotContaining("secret-token")

        val statusFailure =
            UnexpectedStatusCodeException.builder()
                .statusCode(403)
                .headers(Headers.builder().put("x-request-id", "sensitive enrollment-id").build())
                .cause(IOException("customer-data secret-token"))
                .build()

        assertThatThrownBy { X509LiveDiagnostics.issuerExchange { throw statusFailure } }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("issuer exchange failed with HTTP 403.")
            .hasNoCause()
            .hasMessageNotContaining("customer-data")
            .hasMessageNotContaining("enrollment-id")
            .hasMessageNotContaining("secret-token")
    }

    @Test
    fun diagnosticsIncludeOnlySanitizedRequestIds() {
        val safeResponse = StubLiveResponse(403, "req_123-abc:456", "unused")
        val unsafeResponse =
            StubLiveResponse(403, "request id containing sensitive text", "customer-data")

        assertThatThrownBy { X509LiveDiagnostics.requireSuccessful(safeResponse, "mTLS API") }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("mTLS API failed with HTTP 403 (request_id=req_123-abc:456).")
        assertThatThrownBy { X509LiveDiagnostics.requireSuccessful(unsafeResponse, "mTLS API") }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("mTLS API failed with HTTP 403.")
            .hasMessageNotContaining("sensitive")
            .hasMessageNotContaining("customer-data")
    }
}

private class StubLiveResponse(
    statusCode: Int,
    requestId: String,
    body: String,
    additionalHeaders: Map<String, String> = emptyMap(),
) : HttpResponse {
    private val statusCode = statusCode
    private val headers =
        Headers.builder()
            .put("x-request-id", requestId)
            .apply { additionalHeaders.forEach { (name, value) -> put(name, value) } }
            .build()
    private val body = ByteArrayInputStream(body.toByteArray(Charsets.UTF_8))

    override fun statusCode(): Int = statusCode

    override fun headers(): Headers = headers

    override fun body(): ByteArrayInputStream = body

    override fun close() = body.close()
}

private class StubLiveClient(private val response: HttpResponse) : HttpClient {
    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
        response

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> = CompletableFuture.completedFuture(response)

    override fun close() = Unit
}

private class LiveConfiguration
private constructor(
    val pkcs12: ByteArray,
    val password: CharArray,
    val certificateAlias: String,
    val identityProviderId: String,
    val serviceAccountId: String,
) : AutoCloseable {

    override fun close() {
        Arrays.fill(pkcs12, 0)
        Arrays.fill(password, '\u0000')
    }

    companion object {
        fun fromEnvironment(): LiveConfiguration {
            val encodedPkcs12 = requiredEnvironment("OPENAI_X509_KEYSTORE_P12_BASE64")
            val password = requiredEnvironment("OPENAI_X509_KEYSTORE_PASSWORD")
            val certificateAlias = requiredNonBlankEnvironment("OPENAI_X509_CERTIFICATE_ALIAS")
            val identityProviderId = requiredNonBlankEnvironment("OPENAI_X509_IDENTITY_PROVIDER_ID")
            val serviceAccountId = requiredNonBlankEnvironment("OPENAI_X509_SERVICE_ACCOUNT_ID")

            return LiveConfiguration(
                Base64.getDecoder().decode(encodedPkcs12),
                password.toCharArray(),
                certificateAlias,
                identityProviderId,
                serviceAccountId,
            )
        }

        private fun requiredEnvironment(name: String): String =
            System.getenv(name)?.takeIf(String::isNotEmpty)
                ?: error("$name must be configured for X.509 live verification.")

        private fun requiredNonBlankEnvironment(name: String): String =
            requiredEnvironment(name).also {
                check(it.isNotBlank()) { "$name must not be blank for X.509 live verification." }
            }
    }
}
