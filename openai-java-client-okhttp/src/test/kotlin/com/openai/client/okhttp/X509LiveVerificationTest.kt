package com.openai.client.okhttp

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.core.Timeout
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestBody
import com.openai.core.http.HttpResponse
import java.io.ByteArrayInputStream
import java.io.OutputStream
import java.net.Socket
import java.security.KeyStore
import java.security.Principal
import java.security.PrivateKey
import java.security.cert.X509Certificate
import java.time.Duration
import java.util.Arrays
import java.util.Base64
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
 * This deliberately uses the raw, fixed-origin transport capability so the live gate remains useful
 * before higher-level X.509 client integration exists. It never logs response bodies, tokens,
 * certificate material, aliases, or enrollment identifiers.
 */
@EnabledIfEnvironmentVariable(named = "OPENAI_X509_LIVE_TEST", matches = "1")
internal class X509LiveVerificationTest {
    private val jsonMapper = JsonMapper()

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
                val accessToken = exchangeToken(bound.exchangeClient, configuration)
                recordingKeyManager.requireClientAliasSelection("issuer exchange")
                verifyApi(bound.apiClient, accessToken)
                recordingKeyManager.requireClientAliasSelection("mTLS API")
            }
        }

        println("X.509 live verification passed: issuer exchange and mTLS API request completed.")
    }

    private fun exchangeToken(client: OkHttpClient, configuration: LiveConfiguration): String {
        val exchange =
            X509LiveRequests.exchange(
                jsonMapper,
                configuration.identityProviderId,
                configuration.serviceAccountId,
            )

        return execute(client, exchange.request, "issuer exchange").use { response ->
            requireSuccessful(response, "issuer exchange")
            val body = readJson(response, "issuer exchange")
            validateTokenResponse(body)
        }
    }

    private fun verifyApi(client: OkHttpClient, accessToken: String) {
        execute(client, X509LiveRequests.api(accessToken), "mTLS API").use { response ->
            requireSuccessful(response, "mTLS API")
        }
    }

    private fun validateTokenResponse(body: JsonNode): String {
        check(body.isObject) { "The issuer exchange returned an invalid response shape." }
        check(body.path("token_type").asText() == "Bearer") {
            "The issuer exchange returned an unexpected token type."
        }
        check(body.path("issued_token_type").asText() == ACCESS_TOKEN_TYPE) {
            "The issuer exchange returned an unexpected issued token type."
        }
        val expiresIn = body.path("expires_in")
        check(expiresIn.isIntegralNumber && expiresIn.asLong() in 1..MAX_TOKEN_TTL_SECONDS) {
            "The issuer exchange returned an invalid token lifetime."
        }
        val accessToken = body.path("access_token")
        check(accessToken.isTextual && BEARER_TOKEN.matches(accessToken.asText())) {
            "The issuer exchange returned an invalid bearer token."
        }
        return accessToken.asText()
    }

    private fun requireSuccessful(response: HttpResponse, stage: String) =
        X509LiveDiagnostics.requireSuccessful(response, stage)

    private fun execute(client: OkHttpClient, request: HttpRequest, stage: String): HttpResponse =
        try {
            client.execute(request)
        } catch (_: Exception) {
            throw IllegalStateException("$stage failed before receiving an HTTP response.")
        }

    private fun readJson(response: HttpResponse, stage: String): JsonNode =
        X509LiveDiagnostics.readJson(jsonMapper, response, stage)

    private fun defaultTrustManager(): X509TrustManager =
        TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
            .apply { init(null as KeyStore?) }
            .trustManagers
            .filterIsInstance<X509TrustManager>()
            .firstOrNull()
            ?: error("The JVM default trust store did not provide an X.509 trust manager.")

    private companion object {
        const val ACCESS_TOKEN_TYPE = "urn:ietf:params:oauth:token-type:access_token"
        const val MAX_TOKEN_TTL_SECONDS = 3600L
        val BEARER_TOKEN = Regex("^[A-Za-z0-9\\-._~+/]+=*$")
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
    private const val EXCHANGE_URL = "https://mtls.auth.openai.com/oauth/token"
    private const val API_ORIGIN = "https://mtls.api.openai.com"
    private const val TOKEN_EXCHANGE_GRANT_TYPE = "urn:ietf:params:oauth:grant-type:token-exchange"
    private const val X509_SUBJECT_TOKEN_TYPE = "urn:openai:params:oauth:token-type:x509"

    fun exchange(
        jsonMapper: JsonMapper,
        identityProviderId: String,
        serviceAccountId: String,
    ): X509LiveExchangeRequest {
        val body =
            ZeroizingJsonBody(
                jsonMapper.writeValueAsBytes(
                    linkedMapOf(
                        "grant_type" to TOKEN_EXCHANGE_GRANT_TYPE,
                        "subject_token_type" to X509_SUBJECT_TOKEN_TYPE,
                        "identity_provider_id" to identityProviderId,
                        "service_account_id" to serviceAccountId,
                    )
                )
            )
        return X509LiveExchangeRequest(
            HttpRequest.builder().method(HttpMethod.POST).baseUrl(EXCHANGE_URL).body(body).build(),
            body,
        )
    }

    fun api(accessToken: String): HttpRequest =
        HttpRequest.builder()
            .method(HttpMethod.GET)
            .baseUrl(API_ORIGIN)
            .addPathSegments("v1", "models")
            .putHeader("Authorization", "Bearer $accessToken")
            .build()
}

internal data class X509LiveExchangeRequest(val request: HttpRequest, val body: ZeroizingJsonBody)

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

    fun requireSuccessful(response: HttpResponse, stage: String) {
        check(response.statusCode() in 200..299) {
            "$stage failed with HTTP ${response.statusCode()}${requestIdSuffix(response)}."
        }
    }

    fun readJson(jsonMapper: JsonMapper, response: HttpResponse, stage: String): JsonNode =
        try {
            jsonMapper.readTree(response.body())
                ?: throw IllegalStateException("$stage returned an empty JSON response.")
        } catch (_: Exception) {
            throw IllegalStateException("$stage returned invalid JSON${requestIdSuffix(response)}.")
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

    @Test
    fun invalidIssuerBodiesAreNeverIncludedInDiagnostics() {
        val response =
            StubLiveResponse(200, "request id containing sensitive text", "customer-data")

        response.use {
            assertThatThrownBy {
                    X509LiveDiagnostics.readJson(JsonMapper(), response, "issuer exchange")
                }
                .isInstanceOf(IllegalStateException::class.java)
                .hasMessage("issuer exchange returned invalid JSON.")
                .hasMessageNotContaining("sensitive")
                .hasMessageNotContaining("customer-data")
        }
    }
}

private class StubLiveResponse(statusCode: Int, requestId: String, body: String) : HttpResponse {
    private val statusCode = statusCode
    private val headers = Headers.builder().put("x-request-id", requestId).build()
    private val body = ByteArrayInputStream(body.toByteArray(Charsets.UTF_8))

    override fun statusCode(): Int = statusCode

    override fun headers(): Headers = headers

    override fun body(): ByteArrayInputStream = body

    override fun close() = body.close()
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

internal class ZeroizingJsonBody(private val bytes: ByteArray) : HttpRequestBody {
    private val contentLength = bytes.size.toLong()

    var closed = false
        private set

    override fun writeTo(outputStream: OutputStream) = outputStream.write(bytes)

    override fun contentType(): String = "application/json"

    override fun contentLength(): Long = contentLength

    override fun repeatable(): Boolean = false

    override fun close() {
        Arrays.fill(bytes, 0)
        closed = true
    }
}
