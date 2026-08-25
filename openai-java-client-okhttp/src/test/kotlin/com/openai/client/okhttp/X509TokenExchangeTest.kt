package com.openai.client.okhttp

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import com.openai.auth.X509WorkloadIdentity
import com.openai.core.RequestOptions
import com.openai.core.Timeout
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.errors.OpenAIInvalidDataException
import com.openai.errors.OpenAIIoException
import com.openai.errors.UnexpectedStatusCodeException
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.net.SocketTimeoutException
import java.security.cert.X509Certificate
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import okhttp3.mockwebserver.MockResponse
import okhttp3.tls.HandshakeCertificates
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class X509TokenExchangeTest {
    private val identity =
        X509WorkloadIdentity.builder()
            .identityProviderId("idp_test")
            .serviceAccountId("svc_acct_test")
            .build()

    @Test
    fun exchangesSynchronouslyOverPinnedMtlsUsingTheExactProtocol() {
        exchangesOverPinnedMtlsUsingTheExactProtocol(async = false)
    }

    @Test
    fun exchangesAsynchronouslyOverPinnedMtlsUsingTheExactProtocol() {
        exchangesOverPinnedMtlsUsingTheExactProtocol(async = true)
    }

    private fun exchangesOverPinnedMtlsUsingTheExactProtocol(async: Boolean) {
        val clientIdentity = X509TestIdentity.create("exchange client")
        X509TestPeer(AUTH_HOST, clientIdentity.root.certificate).use { authPeer ->
            authPeer.enqueue(
                MockResponse().setHeader("Content-Type", "application/json").setBody(TOKEN_RESPONSE)
            )
            val transport = transport(clientIdentity, listOf(authPeer.serverRootCertificate))

            val token =
                transport.bindForTest(Timeout.default(), authPeer.proxy, authPeer.proxy).use { bound
                    ->
                    val exchange = X509TokenExchange(identity, bound.exchangeClient)
                    if (async) exchange.executeAsync().get(5, TimeUnit.SECONDS)
                    else exchange.execute()
                }

            assertThat(token.value).isEqualTo(ACCESS_TOKEN)
            assertThat(token.expiresIn).isEqualTo(Duration.ofHours(1))
            assertThat(token.toString()).doesNotContain(ACCESS_TOKEN)

            val connect = authPeer.takeRequest()
            val request = authPeer.takeRequest()
            assertThat(connect.requestLine).isEqualTo("CONNECT $AUTH_HOST:443 HTTP/1.1")
            assertThat(request.method).isEqualTo("POST")
            assertThat(request.path).isEqualTo("/oauth/token")
            assertThat(request.getHeader("Authorization")).isNull()
            assertThat(request.getHeader("Cookie")).isNull()
            assertThat(request.getHeader("Content-Type")).startsWith("application/json")
            assertThat(ObjectMapper().readTree(request.body.readUtf8()))
                .isEqualTo(ObjectMapper().readTree(TOKEN_REQUEST))
            val presentedChain = requireNotNull(request.handshake).peerCertificates
            assertThat(presentedChain.first()).isEqualTo(clientIdentity.leaf.certificate)
            assertThat(presentedChain).contains(clientIdentity.root.certificate)
            assertThat(authPeer.requestedServerNames).containsExactly(AUTH_HOST)
        }
    }

    @Test
    fun rejectsMalformedOrSemanticallyInvalidSuccessResponsesWithoutLeakingCredentials() {
        val invalidBodies =
            mapOf(
                "malformed" to "not-json",
                "trailing garbage" to "${validResponse()} trailing",
                "second root" to "${validResponse()} {}",
                "missing access_token" to validResponseWithout("access_token"),
                "missing token_type" to validResponseWithout("token_type"),
                "null token_type" to validResponseWithNull("token_type"),
                "missing issued_token_type" to validResponseWithout("issued_token_type"),
                "null issued_token_type" to validResponseWithNull("issued_token_type"),
                "access_token" to validResponse(accessToken = "secret token with spaces"),
                "token_type" to validResponse(tokenType = "MAC"),
                "issued_token_type" to validResponse(issuedTokenType = "refresh_token"),
                "redacted valid token with invalid type" to
                    validResponse(accessToken = "secret-token-must-not-leak", tokenType = "MAC"),
                "expires_in" to validResponse(expiresIn = "0"),
                "fractional expires_in" to validResponse(expiresIn = "1.5"),
                "expires_in above protocol maximum" to validResponse(expiresIn = "3601"),
                "long maximum expires_in" to validResponse(expiresIn = Long.MAX_VALUE.toString()),
                "long expires_in" to validResponse(expiresIn = "9223372036854775808"),
            )

        invalidBodies.forEach { (description, body) ->
            val response = TestResponse(200, body)
            assertThatThrownBy {
                    X509TokenExchange(identity, SingleResponseClient(response)).execute()
                }
                .describedAs(description)
                .isInstanceOf(OpenAIInvalidDataException::class.java)
                .hasMessageNotContaining("secret")
                .hasMessageNotContaining(body)
            assertThat(response.closed).describedAs(description).isTrue()
        }
    }

    @Test
    fun cancelingAsyncExchangeCancelsTheUnderlyingCall() {
        val responseFuture = CompletableFuture<HttpResponse>()
        val result =
            X509TokenExchange(identity, DeferredResponseClient(responseFuture)).executeAsync()

        assertThat(result.cancel(true)).isTrue()

        assertThat(responseFuture.isCancelled).isTrue()
    }

    @Test
    fun closesALateResponseWhenUnderlyingCancellationLosesTheRace() {
        val responseFuture = NonCancellableFuture<HttpResponse>()
        val result =
            X509TokenExchange(identity, DeferredResponseClient(responseFuture)).executeAsync()
        val response = TestResponse(200, validResponse())

        assertThat(result.cancel(true)).isTrue()
        assertThat(responseFuture.complete(response)).isTrue()

        assertThat(result.isCancelled).isTrue()
        assertThat(response.awaitClosed(5, TimeUnit.SECONDS)).isTrue()
        assertThat(response.bodyRead).isFalse()
    }

    @Test
    fun cancelingWhileParsingClosesAndInterruptsTheActiveResponseExactlyOnce() {
        val responseFuture = CompletableFuture<HttpResponse>()
        val result =
            X509TokenExchange(identity, DeferredResponseClient(responseFuture)).executeAsync()
        val response = BlockingResponse()
        val executor = Executors.newSingleThreadExecutor()

        try {
            val delivery = executor.submit<Boolean> { responseFuture.complete(response) }
            assertThat(response.bodyStarted.await(5, TimeUnit.SECONDS)).isTrue()

            assertThat(result.cancel(true)).isTrue()

            assertThat(response.closed.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(delivery.get(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.isCancelled).isTrue()
            assertThat(response.closeCount).hasValue(1)
        } finally {
            executor.shutdownNow()
        }
    }

    @Test
    fun completedAsyncResponseReturnsCancellationHandleBeforeParsingStarts() {
        val response = BlockingResponse()
        val invocationExecutor = Executors.newSingleThreadExecutor()

        try {
            val invocation =
                invocationExecutor.submit<CompletableFuture<X509AccessToken>> {
                    X509TokenExchange(identity, SingleResponseClient(response)).executeAsync()
                }
            val result = invocation.get(5, TimeUnit.SECONDS)
            assertThat(response.bodyStarted.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            assertThat(response.closed.await(5, TimeUnit.SECONDS)).isTrue()
        } finally {
            response.close()
            invocationExecutor.shutdownNow()
        }
    }

    @Test
    fun acceptsLargeForwardCompatibleResponsesWithoutAnArbitraryLimit() {
        val node = ObjectMapper().readTree(validResponse())
        (node as ObjectNode).put("forward_compatible_field", "x".repeat(2 * 1024 * 1024))
        val response = TestResponse(200, node.toString())

        val token = X509TokenExchange(identity, SingleResponseClient(response)).execute()

        assertThat(token.value).isEqualTo(ACCESS_TOKEN)
        assertThat(response.closed).isTrue()
    }

    @Test
    fun preservesFailureStatusWithoutReadingOrExposingTheResponseBody() {
        val secretBody = """{"error_description":"secret diagnostic"}"""
        val response = TestResponse(401, secretBody)

        assertThatThrownBy { X509TokenExchange(identity, SingleResponseClient(response)).execute() }
            .isInstanceOf(UnexpectedStatusCodeException::class.java)
            .hasMessageContaining("401")
            .hasMessageNotContaining("secret diagnostic")
        assertThat(response.bodyRead).isFalse()
        assertThat(response.closed).isTrue()
    }

    @Test
    fun rejectsNon200SuccessStatusWithoutParsingItsBody() {
        val response = TestResponse(201, validResponse())

        assertThatThrownBy { X509TokenExchange(identity, SingleResponseClient(response)).execute() }
            .isInstanceOf(UnexpectedStatusCodeException::class.java)
            .hasMessageContaining("201")
        assertThat(response.bodyRead).isFalse()
        assertThat(response.closed).isTrue()
    }

    @Test
    fun redactsCredentialHeadersFromSynchronousExchangeErrors() {
        redactsCredentialHeadersFromExchangeErrors(async = false)
    }

    @Test
    fun redactsCredentialHeadersFromAsynchronousExchangeErrors() {
        redactsCredentialHeadersFromExchangeErrors(async = true)
    }

    private fun redactsCredentialHeadersFromExchangeErrors(async: Boolean) {
        val response =
            TestResponse(
                503,
                "not read",
                Headers.builder()
                    .put("Set-Cookie", "session=secret-cookie")
                    .put("Authorization", "Bearer secret-token")
                    .put("X-Api-Key", "secret-api-key")
                    .put("X-Request-ID", "req_safe")
                    .put("Retry-After", "1")
                    .build(),
            )

        val failure = exchangeFailure(response, async)

        assertThat(failure).isInstanceOf(UnexpectedStatusCodeException::class.java)
        val statusError = failure as UnexpectedStatusCodeException
        assertThat(statusError.headers().values("Set-Cookie")).isEmpty()
        assertThat(statusError.headers().values("Authorization")).isEmpty()
        assertThat(statusError.headers().values("X-Api-Key")).isEmpty()
        assertThat(statusError.headers().values("X-Request-ID")).containsExactly("req_safe")
        assertThat(statusError.headers().values("Retry-After")).containsExactly("1")
        assertThat(statusError.toString())
            .doesNotContain("secret-cookie", "secret-token", "secret-api-key")
        assertThat(response.bodyRead).isFalse()
        assertThat(response.closed).isTrue()
    }

    @Test
    fun preservesSynchronousIssuerBodyTimeoutAsRetryableIo() {
        preservesIssuerBodyTimeoutAsRetryableIo(async = false)
    }

    @Test
    fun preservesAsynchronousIssuerBodyTimeoutAsRetryableIo() {
        preservesIssuerBodyTimeoutAsRetryableIo(async = true)
    }

    private fun preservesIssuerBodyTimeoutAsRetryableIo(async: Boolean) {
        val response = FailingBodyResponse(SocketTimeoutException("issuer body stalled"))

        val failure = exchangeFailure(response, async)

        assertThat(failure).isInstanceOf(OpenAIIoException::class.java)
        assertThat(failure).hasMessage("Failed to read X.509 token exchange response")
        assertThat(failure.cause).isInstanceOf(SocketTimeoutException::class.java)
        assertThat(response.closed).isTrue()
    }

    private fun exchangeFailure(response: HttpResponse, async: Boolean): Throwable {
        val result =
            runCatching {
                    val exchange = X509TokenExchange(identity, SingleResponseClient(response))
                    if (async) exchange.executeAsync().get(5, TimeUnit.SECONDS)
                    else exchange.execute()
                }
                .exceptionOrNull() ?: error("Expected X.509 exchange to fail")
        return if (result is ExecutionException) result.cause ?: result else result
    }

    private fun transport(
        clientIdentity: X509TestIdentity,
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
            .keyManager(x509TestKeyManager(mapOf(CERTIFICATE_ALIAS to clientIdentity)))
            .certificateAlias(CERTIFICATE_ALIAS)
            .trustManager(trustManager)
            .build()
    }

    private fun validResponseWithout(field: String): String =
        (ObjectMapper().readTree(validResponse()) as ObjectNode).apply { remove(field) }.toString()

    private fun validResponseWithNull(field: String): String =
        (ObjectMapper().readTree(validResponse()) as ObjectNode).apply { putNull(field) }.toString()

    private fun validResponse(
        accessToken: String = ACCESS_TOKEN,
        tokenType: String = "Bearer",
        issuedTokenType: String = ACCESS_TOKEN_TYPE,
        expiresIn: String = "3600",
    ): String =
        """
        {
          "access_token": "$accessToken",
          "issued_token_type": "$issuedTokenType",
          "token_type": "$tokenType",
          "expires_in": $expiresIn
        }
        """
            .trimIndent()

    private companion object {
        const val AUTH_HOST = "mtls.auth.openai.com"
        const val CERTIFICATE_ALIAS = "x509"
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
              "expires_in": 3600,
              "forward_compatible_field": true
            }
            """
                .trimIndent()
    }
}

private class SingleResponseClient(private val response: HttpResponse) : HttpClient {
    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
        response

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> = CompletableFuture.completedFuture(response)

    override fun close() {}
}

private class DeferredResponseClient(private val responseFuture: CompletableFuture<HttpResponse>) :
    HttpClient {
    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
        error("Unexpected synchronous call")

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> = responseFuture

    override fun close() {}
}

private class NonCancellableFuture<T> : CompletableFuture<T>() {
    override fun cancel(mayInterruptIfRunning: Boolean): Boolean = false
}

private class BlockingResponse : HttpResponse {
    val bodyStarted = CountDownLatch(1)
    val closed = CountDownLatch(1)
    val closeCount = AtomicInteger()

    override fun statusCode(): Int = 200

    override fun headers(): Headers = Headers.builder().build()

    override fun body(): InputStream =
        object : InputStream() {
            override fun read(): Int {
                bodyStarted.countDown()
                closed.await()
                throw IOException("response closed")
            }
        }

    override fun close() {
        closeCount.incrementAndGet()
        closed.countDown()
    }
}

private class TestResponse(
    private val statusCode: Int,
    body: String,
    private val responseHeaders: Headers = Headers.builder().build(),
) : HttpResponse {
    private val bytes = body.toByteArray()
    private val closedSignal = CountDownLatch(1)
    var bodyRead = false
        private set

    @Volatile
    var closed = false
        private set

    fun awaitClosed(timeout: Long, unit: TimeUnit): Boolean = closedSignal.await(timeout, unit)

    override fun statusCode(): Int = statusCode

    override fun headers(): Headers = responseHeaders

    override fun body(): ByteArrayInputStream {
        bodyRead = true
        return ByteArrayInputStream(bytes)
    }

    override fun close() {
        closed = true
        closedSignal.countDown()
    }
}

private class FailingBodyResponse(private val failure: IOException) : HttpResponse {
    var closed = false
        private set

    override fun statusCode(): Int = 200

    override fun headers(): Headers = Headers.builder().build()

    override fun body(): InputStream =
        object : InputStream() {
            override fun read(): Int = throw failure
        }

    override fun close() {
        closed = true
    }
}
