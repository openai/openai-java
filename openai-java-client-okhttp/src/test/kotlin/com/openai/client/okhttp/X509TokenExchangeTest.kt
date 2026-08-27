package com.openai.client.okhttp

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
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
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import okhttp3.mockwebserver.MockResponse
import okhttp3.tls.HandshakeCertificates
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class X509TokenExchangeTest {

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
                    X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, bound.exchangeClient).use {
                        exchange ->
                        if (async) exchange.executeAsync().get(5, TimeUnit.SECONDS)
                        else exchange.execute()
                    }
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
                "duplicate access_token" to
                    validResponseWithDuplicate(
                        "access_token",
                        "\"secret-duplicate-token-must-not-leak\"",
                    ),
                "duplicate expires_in" to validResponseWithDuplicate("expires_in", "60"),
                "missing access_token" to validResponseWithout("access_token"),
                "missing token_type" to validResponseWithout("token_type"),
                "null token_type" to validResponseWithNull("token_type"),
                "missing issued_token_type" to validResponseWithout("issued_token_type"),
                "null issued_token_type" to validResponseWithNull("issued_token_type"),
                "invalid access_token" to validResponse(accessToken = "secret token with spaces"),
                "invalid token_type" to
                    validResponse(accessToken = "secret-token-must-not-leak", tokenType = "MAC"),
                "invalid issued_token_type" to validResponse(issuedTokenType = "refresh_token"),
                "missing expires_in" to validResponseWithout("expires_in"),
                "zero expires_in" to validResponse(expiresIn = "0"),
                "fractional expires_in" to validResponse(expiresIn = "1.5"),
                "expires_in above maximum" to validResponse(expiresIn = "3601"),
                "overflow expires_in" to validResponse(expiresIn = "9223372036854775808"),
            )

        invalidBodies.forEach { (description, body) ->
            listOf(false, true).forEach { async ->
                val response = TestResponse(200, body)

                assertThat(exchangeFailure(response, async))
                    .describedAs("$description (async=$async)")
                    .isInstanceOf(OpenAIInvalidDataException::class.java)
                    .hasMessageNotContaining("secret")
                    .hasMessageNotContaining(body)
                assertThat(response.closed).describedAs(description).isTrue()
            }
        }
    }

    @Test
    fun acceptsLargeForwardCompatibleResponsesWithoutAnArbitraryLimit() {
        val node = ObjectMapper().readTree(validResponse())
        (node as ObjectNode).put("forward_compatible_field", "x".repeat(2 * 1024 * 1024))
        val response = TestResponse(200, node.toString())

        val token =
            X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, SingleResponseClient(response)).use {
                it.execute()
            }

        assertThat(token.value).isEqualTo(ACCESS_TOKEN)
        assertThat(response.closed).isTrue()
    }

    @Test
    fun failureStatusDoesNotReadBodyAndRetainsOnlySafeDiagnosticHeaders() {
        listOf(false, true).forEach { async ->
            val response =
                TestResponse(
                    503,
                    """{"error_description":"secret diagnostic"}""",
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
            assertThat(statusError.statusCode()).isEqualTo(503)
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
    }

    @Test
    fun rejectsNon200SuccessWithoutReadingTheBody() {
        listOf(false, true).forEach { async ->
            val response = TestResponse(201, validResponse())

            val failure = exchangeFailure(response, async)

            assertThat(failure).isInstanceOf(UnexpectedStatusCodeException::class.java)
            assertThat((failure as UnexpectedStatusCodeException).statusCode()).isEqualTo(201)
            assertThat(response.bodyRead).isFalse()
            assertThat(response.closed).isTrue()
        }
    }

    @Test
    fun preservesIssuerBodyTimeoutAndIoFailuresAsSanitizedRetryableIo() {
        listOf(
                SocketTimeoutException("issuer body stalled"),
                IOException("issuer body disconnected"),
            )
            .forEach { cause ->
                listOf(false, true).forEach { async ->
                    val response = FailingBodyResponse(cause)

                    val failure = exchangeFailure(response, async)

                    assertThat(failure).isInstanceOf(OpenAIIoException::class.java)
                    assertThat(failure).hasMessage("Failed to read X.509 token exchange response")
                    assertThat(failure.cause).isSameAs(cause)
                    assertThat(response.closed).isTrue()
                }
            }
    }

    @Test
    fun completedAsyncResponseParsesOnOwnedIoThreadAfterReturningCancellationHandle() {
        val response = BlockingResponse()
        val exchange = X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, SingleResponseClient(response))

        val result = exchange.executeAsync()
        assertThat(response.bodyStarted.await(5, TimeUnit.SECONDS)).isTrue()
        assertThat(response.bodyThreadName).startsWith("openai-x509-response-")
        assertThat(result.cancel(true)).isTrue()

        assertThat(response.closed.await(5, TimeUnit.SECONDS)).isTrue()
        assertThat(response.closeCount).hasValue(1)
        exchange.close()
    }

    @Test
    fun cancelingBeforeResponseDeliveryCancelsTheUnderlyingCall() {
        val responseFuture = CompletableFuture<HttpResponse>()
        val client = DeferredResponseClient(responseFuture)
        val exchange = X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, client)

        val result = exchange.executeAsync()
        assertThat(result.cancel(true)).isTrue()

        assertThat(responseFuture.isCancelled).isTrue()
        assertThat(client.closed).isFalse()
        exchange.close()
        assertThat(client.closed).isFalse()
    }

    @Test
    fun cancelingClosesALateResponseWhenUnderlyingCancellationLosesTheRace() {
        val responseFuture = NonCancellableFuture<HttpResponse>()
        val exchange =
            X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, DeferredResponseClient(responseFuture))
        val result = exchange.executeAsync()
        val response = TestResponse(200, validResponse())

        assertThat(result.cancel(true)).isTrue()
        assertThat(responseFuture.complete(response)).isTrue()

        assertThat(result.isCancelled).isTrue()
        assertThat(response.bodyRead).isFalse()
        assertThat(response.closeCount).hasValue(1)
        exchange.close()
    }

    @Test
    fun responseExecutorIsBoundedAndClosesRejectedResponses() {
        val responses = List(5) { BlockingResponse() }
        val client = SequenceResponseClient(responses)
        val exchange = X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, client)
        val results = mutableListOf<CompletableFuture<X509AccessToken>>()

        repeat(4) { index ->
            results += exchange.executeAsync()
            assertThat(responses[index].bodyStarted.await(5, TimeUnit.SECONDS)).isTrue()
        }
        results += exchange.executeAsync()

        assertThatThrownBy { results.last().get(5, TimeUnit.SECONDS) }
            .isInstanceOf(ExecutionException::class.java)
            .hasCauseInstanceOf(OpenAIIoException::class.java)
        assertThat(responses.last().closed.await(5, TimeUnit.SECONDS)).isTrue()
        assertThat(responses.last().bodyStarted.count).isEqualTo(1)

        exchange.close()
        assertThat(results.take(4)).allMatch(CompletableFuture<*>::isCancelled)
        assertThat(responses.take(4)).allMatch { it.closed.await(5, TimeUnit.SECONDS) }
        assertThat(client.closed).isFalse()
    }

    private fun exchangeFailure(response: HttpResponse, async: Boolean): Throwable {
        val result =
            runCatching {
                    X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, SingleResponseClient(response))
                        .use { exchange ->
                            if (async) exchange.executeAsync().get(5, TimeUnit.SECONDS)
                            else exchange.execute()
                        }
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

    private fun validResponseWithDuplicate(field: String, firstValue: String): String =
        validResponse().replaceFirst("\"$field\":", "\"$field\": $firstValue,\n  \"$field\":")

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
        const val IDP_ID = "idp_test"
        const val SERVICE_ACCOUNT_ID = "svc_acct_test"
        const val ACCESS_TOKEN = "test-x509-access-token"
        const val ACCESS_TOKEN_TYPE = "urn:ietf:params:oauth:token-type:access_token"
        val TOKEN_REQUEST =
            """
            {
              "grant_type": "urn:ietf:params:oauth:grant-type:token-exchange",
              "subject_token_type": "urn:openai:params:oauth:token-type:x509",
              "identity_provider_id": "$IDP_ID",
              "service_account_id": "$SERVICE_ACCOUNT_ID"
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

private open class SingleResponseClient(private val response: HttpResponse) : HttpClient {
    var closed = false
        private set

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
        response

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> = CompletableFuture.completedFuture(response)

    override fun close() {
        closed = true
    }
}

private class DeferredResponseClient(private val responseFuture: CompletableFuture<HttpResponse>) :
    HttpClient {
    var closed = false
        private set

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
        error("Unexpected synchronous call")

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> = responseFuture

    override fun close() {
        closed = true
    }
}

private class NonCancellableFuture<T> : CompletableFuture<T>() {
    override fun cancel(mayInterruptIfRunning: Boolean): Boolean = false
}

private class SequenceResponseClient(responses: List<HttpResponse>) : HttpClient {
    private val responses = ArrayDeque(responses)
    var closed = false
        private set

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
        error("Unexpected synchronous call")

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> = CompletableFuture.completedFuture(responses.removeFirst())

    override fun close() {
        closed = true
    }
}

private class BlockingResponse : HttpResponse {
    val bodyStarted = CountDownLatch(1)
    val closed = CountDownLatch(1)
    val closeCount = AtomicInteger()

    @Volatile var bodyThreadName: String? = null

    override fun statusCode(): Int = 200

    override fun headers(): Headers = Headers.builder().build()

    override fun body(): InputStream =
        object : InputStream() {
            override fun read(): Int {
                bodyThreadName = Thread.currentThread().name
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
    val closeCount = AtomicInteger()
    var bodyRead = false
        private set

    var closed = false
        private set

    override fun statusCode(): Int = statusCode

    override fun headers(): Headers = responseHeaders

    override fun body(): ByteArrayInputStream {
        bodyRead = true
        return ByteArrayInputStream(bytes)
    }

    override fun close() {
        closeCount.incrementAndGet()
        closed = true
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
