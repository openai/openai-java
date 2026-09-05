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
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.function.BiConsumer
import okhttp3.mockwebserver.MockResponse
import okhttp3.tls.HandshakeCertificates
import org.assertj.core.api.Assertions.assertThat
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
        val response =
            TestResponse(
                200,
                """
                {
                  "forward_compatible_field": {
                    "nested": [{"value": "${"x".repeat(2 * 1024 * 1024)}"}]
                  },
                  "access_token": "$ACCESS_TOKEN",
                  "issued_token_type": "$ACCESS_TOKEN_TYPE",
                  "token_type": "Bearer",
                  "expires_in": 3600
                }
                """
                    .trimIndent(),
            )

        val token =
            X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, SingleResponseClient(response)).use {
                it.execute()
            }

        assertThat(token.value).isEqualTo(ACCESS_TOKEN)
        assertThat(response.closed).isTrue()
    }

    @Test
    fun acceptsAccessTokensAboveMetadataDiagnosticLimits() {
        val largeAccessToken = "a".repeat(2 * 1024)

        listOf(false, true).forEach { async ->
            val response = TestResponse(200, validResponse(accessToken = largeAccessToken))

            val token =
                X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, SingleResponseClient(response)).use {
                    exchange ->
                    if (async) exchange.executeAsync().get(5, TimeUnit.SECONDS)
                    else exchange.execute()
                }

            assertThat(token.value).isEqualTo(largeAccessToken)
            assertThat(response.closed).isTrue()
        }
    }

    @Test
    fun rejectsOversizedRecognizedSuccessStringsBeforeReadingTheCompleteValue() {
        mapOf(
                "token_type" to validResponse(tokenType = OVERSIZED_RECOGNIZED_VALUE),
                "issued_token_type" to validResponse(issuedTokenType = OVERSIZED_RECOGNIZED_VALUE),
                "token\\u005ftype" to
                    validResponse(tokenType = OVERSIZED_RECOGNIZED_VALUE)
                        .replaceFirst("token_type", "token\\u005ftype"),
            )
            .forEach { (field, body) ->
                listOf(false, true).forEach { async ->
                    val response = TestResponse(200, body)

                    assertThat(exchangeFailure(response, async))
                        .describedAs("$field (async=$async)")
                        .isInstanceOf(OpenAIInvalidDataException::class.java)
                        .hasMessage("Invalid X.509 token exchange response")
                    assertThat(response.bytesRead.get()).isLessThan(body.toByteArray().size)
                    assertThat(response.closed).isTrue()
                }
            }
    }

    @Test
    fun rejectsNestedRecognizedSuccessFieldsBeforeReadingLargeNestedStrings() {
        listOf("access_token", "token_type", "issued_token_type", "expires_in").forEach { field ->
            val body =
                validResponseWithRawValue(field, """{"$field":"$OVERSIZED_RECOGNIZED_VALUE"}""")
            listOf(false, true).forEach { async ->
                val response = TestResponse(200, body)

                assertThat(exchangeFailure(response, async))
                    .describedAs("$field (async=$async)")
                    .isInstanceOf(OpenAIInvalidDataException::class.java)
                    .hasMessage("Invalid X.509 token exchange response field: $field")
                assertThat(response.bytesRead.get()).isLessThan(body.toByteArray().size)
                assertThat(response.closed).isTrue()
            }
        }
    }

    @Test
    fun acceptsPositiveTokenLifetimesAboveOneHour() {
        listOf(false, true).forEach { async ->
            val response = TestResponse(200, validResponse(expiresIn = "86400"))

            val token =
                X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, SingleResponseClient(response)).use {
                    exchange ->
                    if (async) exchange.executeAsync().get(5, TimeUnit.SECONDS)
                    else exchange.execute()
                }

            assertThat(token.expiresIn).isEqualTo(Duration.ofDays(1))
            assertThat(response.closed).isTrue()
        }
    }

    @Test
    fun failureStatusPreservesSafeOAuthCodeAndHeadersWithoutFreeFormDescription() {
        listOf(false, true).forEach { async ->
            val response =
                TestResponse(
                    503,
                    """
                    {
                      "error": "invalid_grant",
                      "error_description": "Certificate is not authorized; Authorization: Bearer secret-body-token; Cookie: session=secret-body-cookie; access_token=secret-body-api-key"
                    }
                    """
                        .trimIndent(),
                    Headers.builder()
                        .put("Set-Cookie", "session=secret-cookie")
                        .put("Authorization", "Bearer secret-token")
                        .put("X-Api-Key", "secret-api-key")
                        .put("X-Request-ID", "req_safe")
                        .put("Retry-After", "1")
                        .put("Traceparent", "aaaaaaaa.bbbbbbbb.cccccccc")
                        .put("Tracestate", "vendor=sk-test-not-a-real-credential-00000000")
                        .build(),
                )

            val failure = exchangeFailure(response, async)

            assertThat(failure).isInstanceOf(UnexpectedStatusCodeException::class.java)
            val statusError = failure as UnexpectedStatusCodeException
            assertThat(statusError.statusCode()).isEqualTo(503)
            assertThat(statusError.headers().values("Set-Cookie")).isEmpty()
            assertThat(statusError.headers().values("Authorization")).isEmpty()
            assertThat(statusError.headers().values("X-Api-Key")).isEmpty()
            assertThat(statusError.headers().values("X-Request-ID")).containsExactly("<redacted>")
            assertThat(statusError.headers().values("Retry-After")).containsExactly("1")
            assertThat(statusError.headers().values("Traceparent")).containsExactly("<redacted>")
            assertThat(statusError.headers().values("Tracestate")).containsExactly("<redacted>")
            assertThat(statusError.code()).contains("invalid_grant")
            assertThat(statusError.message).contains("invalid_grant")
            assertThat(statusError.toString())
                .doesNotContain(
                    "Certificate is not authorized",
                    "secret-cookie",
                    "secret-token",
                    "secret-api-key",
                    "secret-body-token",
                    "secret-body-cookie",
                    "secret-body-api-key",
                    "aaaaaaaa.bbbbbbbb.cccccccc",
                    "sk-test-not-a-real-credential-00000000",
                )
            assertThat(statusError.headers().toString())
                .doesNotContain(
                    "aaaaaaaa.bbbbbbbb.cccccccc",
                    "sk-test-not-a-real-credential-00000000",
                )
            assertThat(statusError.body().toString())
                .doesNotContain("secret-body-token", "secret-body-cookie", "secret-body-api-key")
            assertThat(response.bodyRead).isTrue()
            assertThat(response.closed).isTrue()
        }
    }

    @Test
    fun doesNotExposeShortOpaqueSecretsFromDiagnosticHeaders() {
        listOf(false, true).forEach { async ->
            val response =
                TestResponse(
                    400,
                    """{"error":"invalid_request"}""",
                    Headers.builder()
                        .put("X-Request-ID", "short-request-secret")
                        .put("Tracestate", "short-trace-secret")
                        .put("Retry-After", "short-retry-secret")
                        .put("Content-Type", "short-content-secret")
                        .build(),
                )

            val failure = exchangeFailure(response, async)

            assertThat(failure).isInstanceOf(UnexpectedStatusCodeException::class.java)
            val statusError = failure as UnexpectedStatusCodeException
            assertThat(statusError.headers().values("X-Request-ID")).containsExactly("<redacted>")
            assertThat(statusError.headers().values("Tracestate")).containsExactly("<redacted>")
            assertThat(statusError.headers().values("Retry-After")).isEmpty()
            assertThat(statusError.headers().values("Content-Type")).isEmpty()
            assertThat(statusError.headers().toString())
                .doesNotContain(
                    "short-request-secret",
                    "short-trace-secret",
                    "short-retry-secret",
                    "short-content-secret",
                )
            assertThat(failure.toString())
                .doesNotContain(
                    "short-request-secret",
                    "short-trace-secret",
                    "short-retry-secret",
                    "short-content-secret",
                )
            assertThat(response.closed).isTrue()
        }
    }

    @Test
    fun rejectsNon200SuccessWithoutRetainingCredentialFields() {
        listOf(false, true).forEach { async ->
            val response =
                TestResponse(201, validResponse(accessToken = "secret-token-must-not-leak"))

            val failure = exchangeFailure(response, async)

            assertThat(failure).isInstanceOf(UnexpectedStatusCodeException::class.java)
            assertThat((failure as UnexpectedStatusCodeException).statusCode()).isEqualTo(201)
            assertThat(failure.toString()).doesNotContain("secret-token-must-not-leak")
            assertThat(response.bodyRead).isTrue()
            assertThat(response.closed).isTrue()
        }
    }

    @Test
    fun doesNotExposeFreeFormOAuthErrorDescriptions() {
        mapOf(
                "short-unlabeled-secret" to "short-unlabeled-secret",
                "Authorization: Digest username=alice, response=secret-digest-value" to
                    "secret-digest-value",
                "Cookie: first=secret-first-cookie; second=secret-second-cookie" to
                    "secret-second-cookie",
                "client_secret=\"part-one,part-two\"" to "part-two",
                "password=\"part-one;part-two\"" to "part-two",
                "api_key=\"part-one part-two\"" to "part-two",
                "Bearer \"part-one,part-two\"" to "part-two",
            )
            .forEach { (diagnostic, secret) ->
                listOf(false, true).forEach { async ->
                    val response =
                        TestResponse(
                            400,
                            ObjectMapper()
                                .writeValueAsString(
                                    mapOf(
                                        "error" to "invalid_grant",
                                        "error_description" to "Safe prefix; $diagnostic",
                                    )
                                ),
                        )

                    val failure = exchangeFailure(response, async)

                    assertThat(failure).isInstanceOf(UnexpectedStatusCodeException::class.java)
                    val statusError = failure as UnexpectedStatusCodeException
                    assertThat(statusError.code()).contains("invalid_grant")
                    assertThat(failure.message).doesNotContain("Safe prefix", diagnostic, secret)
                    assertThat(failure.toString()).doesNotContain(secret)
                    assertThat(statusError.body().toString()).doesNotContain(diagnostic, secret)
                    assertThat(response.closed).isTrue()
                }
            }
    }

    @Test
    fun rejectsCredentialLikeOAuthErrorCodesFromDiagnostics() {
        listOf(
                "short-unlabeled-secret",
                "sk-test-not-a-real-credential-00000000",
                "aaaaaaaa.bbbbbbbb.cccccccc",
            )
            .forEach { credential ->
                listOf(false, true).forEach { async ->
                    val response =
                        TestResponse(
                            400,
                            """{"error":"$credential","error_description":"Issuer rejected certificate"}""",
                        )

                    val failure = exchangeFailure(response, async)

                    assertThat(failure).isInstanceOf(UnexpectedStatusCodeException::class.java)
                    val statusError = failure as UnexpectedStatusCodeException
                    assertThat(statusError.code()).isEmpty()
                    assertThat(statusError.message).doesNotContain("Issuer rejected certificate")
                    assertThat(statusError.message).doesNotContain(credential)
                    assertThat(statusError.body().toString()).doesNotContain(credential)
                    assertThat(statusError.toString()).doesNotContain(credential)
                    assertThat(response.closed).isTrue()
                }
            }
    }

    @Test
    fun ignoresOversizedOAuthDiagnosticsBeforeReadingTheCompleteValue() {
        mapOf(
                "error" to """{"error":"$OVERSIZED_RECOGNIZED_VALUE","error_description":"safe"}""",
                "error_description" to
                    """{"error":"invalid_grant","error_description":"$OVERSIZED_RECOGNIZED_VALUE"}""",
                "error\\u005fdescription" to
                    "{\"error\":\"invalid_grant\",\"error\\u005fdescription\":" +
                        "\"$OVERSIZED_RECOGNIZED_VALUE\"}",
            )
            .forEach { (field, body) ->
                listOf(false, true).forEach { async ->
                    val response = TestResponse(503, body)

                    val failure = exchangeFailure(response, async)

                    assertThat(failure)
                        .describedAs("$field (async=$async)")
                        .isInstanceOf(UnexpectedStatusCodeException::class.java)
                    val statusError = failure as UnexpectedStatusCodeException
                    assertThat(statusError.statusCode()).isEqualTo(503)
                    assertThat(statusError.code()).isEmpty()
                    assertThat(response.bytesRead.get()).isLessThan(body.toByteArray().size)
                    assertThat(response.closed).isTrue()
                }
            }
    }

    @Test
    fun ignoresNestedOAuthDiagnosticsBeforeReadingLargeNestedStrings() {
        mapOf(
                "error" to
                    """{"error":{"error":"$OVERSIZED_RECOGNIZED_VALUE"},"error_description":"safe"}""",
                "error_description" to
                    """{"error":"invalid_grant","error_description":{"error_description":"$OVERSIZED_RECOGNIZED_VALUE"}}""",
            )
            .forEach { (field, body) ->
                listOf(false, true).forEach { async ->
                    val response = TestResponse(503, body)

                    val failure = exchangeFailure(response, async)

                    assertThat(failure)
                        .describedAs("$field (async=$async)")
                        .isInstanceOf(UnexpectedStatusCodeException::class.java)
                    val statusError = failure as UnexpectedStatusCodeException
                    assertThat(statusError.statusCode()).isEqualTo(503)
                    assertThat(statusError.code()).isEmpty()
                    assertThat(response.bytesRead.get()).isLessThan(body.toByteArray().size)
                    assertThat(response.closed).isTrue()
                }
            }
    }

    @Test
    fun preservesIssuerBodyTimeoutAndIoFailuresAsSanitizedRetryableIo() {
        listOf(
                SocketTimeoutException("issuer body stalled"),
                IOException("issuer body disconnected"),
            )
            .forEach { cause ->
                listOf(200, 503).forEach { statusCode ->
                    listOf(false, true).forEach { async ->
                        val response = FailingBodyResponse(cause, statusCode)

                        val failure = exchangeFailure(response, async)

                        assertThat(failure).isInstanceOf(OpenAIIoException::class.java)
                        assertThat(failure)
                            .hasMessage("Failed to read X.509 token exchange response")
                        assertThat(failure.cause).isSameAs(cause)
                        assertThat(response.closed).isTrue()
                    }
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
        assertThat(client.started.await(5, TimeUnit.SECONDS)).isTrue()
        assertThat(result.cancel(true)).isTrue()

        assertThat(responseFuture.isCancelled).isTrue()
        assertThat(client.closed).isFalse()
        exchange.close()
        assertThat(client.closed).isFalse()
    }

    @Test
    fun cancellationWaitsForInFlightRequestEnrollmentBeforePublishing() {
        val responseFuture = CompletableFuture<HttpResponse>()
        val client = BlockingStartClient(responseFuture)
        val exchange = X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, client)
        val result = exchange.executeAsync()
        val cancellationPublished = CountDownLatch(1)
        val cancellationFinished = CountDownLatch(1)
        result.whenComplete { _, _ -> cancellationPublished.countDown() }

        assertThat(client.started.await(5, TimeUnit.SECONDS)).isTrue()
        Thread {
                result.cancel(true)
                cancellationFinished.countDown()
            }
            .start()

        try {
            assertThat(cancellationFinished.await(200, TimeUnit.MILLISECONDS)).isFalse()
            assertThat(cancellationPublished.count).isEqualTo(1)

            client.release.countDown()

            assertThat(cancellationFinished.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(cancellationPublished.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.isCancelled).isTrue()
            assertThat(responseFuture.isCancelled).isTrue()
        } finally {
            client.release.countDown()
            exchange.close()
        }
    }

    @Test
    fun cancellationWaitsForCompletedResponseHandoffBeforePublishing() {
        val response = BlockingResponse()
        val responseFuture = BlockingHandoffFuture<HttpResponse>(response)
        val client = DeferredResponseClient(responseFuture)
        val exchange = X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, client)
        val result = exchange.executeAsync()
        val cancellationPublished = CountDownLatch(1)
        val cancellationFinished = CountDownLatch(1)
        result.whenComplete { _, _ -> cancellationPublished.countDown() }

        assertThat(responseFuture.handoffStarted.await(5, TimeUnit.SECONDS)).isTrue()
        Thread {
                result.cancel(true)
                cancellationFinished.countDown()
            }
            .start()

        try {
            assertThat(cancellationFinished.await(200, TimeUnit.MILLISECONDS)).isFalse()
            assertThat(cancellationPublished.count).isEqualTo(1)

            responseFuture.releaseHandoff.countDown()

            assertThat(cancellationFinished.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(cancellationPublished.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(response.closed.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(response.bodyStarted.count).isEqualTo(1)
            assertThat(response.closeCount).hasValue(1)
        } finally {
            responseFuture.releaseHandoff.countDown()
            exchange.close()
        }
    }

    @Test
    fun cancelingClosesALateResponseWhenUnderlyingCancellationLosesTheRace() {
        val responseFuture = NonCancellableFuture<HttpResponse>()
        val client = DeferredResponseClient(responseFuture)
        val exchange = X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, client)
        val result = exchange.executeAsync()
        val response = BlockingResponse()

        assertThat(client.started.await(5, TimeUnit.SECONDS)).isTrue()
        assertThat(result.cancel(true)).isTrue()
        assertThat(responseFuture.complete(response)).isTrue()

        assertThat(result.isCancelled).isTrue()
        assertThat(response.bodyStarted.count).isEqualTo(1)
        assertThat(response.closed.await(5, TimeUnit.SECONDS)).isTrue()
        assertThat(response.closeCount).hasValue(1)
        exchange.close()
    }

    @Test
    fun throwingLateResponseCloseDoesNotStrandResponseWorkers() {
        val pending = List(4) { NonCancellableFuture<HttpResponse>() }
        val admitted = AtomicInteger()
        val allAdmitted = CountDownLatch(pending.size)
        val closed = CountDownLatch(pending.size)
        val closeCount = AtomicInteger()
        val client =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("Unexpected synchronous exchange")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    val index = admitted.getAndIncrement()
                    allAdmitted.countDown()
                    return if (index < pending.size) pending[index]
                    else CompletableFuture.completedFuture(TestResponse(200, validResponse()))
                }

                override fun close() {}
            }
        X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, client).use { exchange ->
            val canceled = pending.map { exchange.executeAsync() }
            // The queued fifth exchange checks that every owned worker leaves its get().
            assertThat(allAdmitted.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(admitted.get()).isEqualTo(pending.size)
            canceled.forEach { assertThat(it.cancel(true)).isTrue() }
            pending.forEach { future ->
                val response =
                    object : HttpResponse {
                        override fun statusCode() = 200

                        override fun headers() = Headers.builder().build()

                        override fun body(): InputStream = ByteArrayInputStream(byteArrayOf())

                        override fun close() {
                            closeCount.incrementAndGet()
                            closed.countDown()
                            throw IOException("synthetic late close failure")
                        }
                    }
                // Completing the transport may throw from the registered callback.
                runCatching { future.complete(response) }
            }
            assertThat(closed.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(closeCount).hasValue(pending.size)
            assertThat(canceled).allMatch { it.isCancelled }
            assertThat(exchange.executeAsync().get(5, TimeUnit.SECONDS).value)
                .isEqualTo(ACCESS_TOKEN)
        }
    }

    @Test
    fun cancellationClosesActiveResponseBeforeRunningCallerCallbacks() {
        val response = BlockingResponse()
        val exchange = X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, SingleResponseClient(response))
        val result = exchange.executeAsync()
        val callbackStarted = CountDownLatch(1)
        val releaseCallback = CountDownLatch(1)
        val cancellationFinished = CountDownLatch(1)

        assertThat(response.bodyStarted.await(5, TimeUnit.SECONDS)).isTrue()
        result.whenComplete { _, _ ->
            callbackStarted.countDown()
            releaseCallback.await()
        }
        Thread {
                result.cancel(true)
                cancellationFinished.countDown()
            }
            .start()

        try {
            assertThat(callbackStarted.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(response.closed.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(response.closeCount).hasValue(1)
        } finally {
            releaseCallback.countDown()
            assertThat(cancellationFinished.await(5, TimeUnit.SECONDS)).isTrue()
            exchange.close()
        }
    }

    @Test
    fun closeClosesALateResponseWhenUnderlyingCancellationLosesTheRace() {
        val responseFuture = NonCancellableFuture<HttpResponse>()
        val client = DeferredResponseClient(responseFuture)
        val exchange = X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, client)
        val result = exchange.executeAsync()
        val response = BlockingResponse()

        assertThat(client.started.await(5, TimeUnit.SECONDS)).isTrue()
        exchange.close()
        assertThat(responseFuture.complete(response)).isTrue()

        assertThat(result.isCancelled).isTrue()
        assertThat(response.bodyStarted.count).isEqualTo(1)
        assertThat(response.closed.await(5, TimeUnit.SECONDS)).isTrue()
        assertThat(response.closeCount).hasValue(1)
    }

    @Test
    fun closeCleansAllAdmittedOperationsBeforeRunningCallerCallbacks() {
        val responses = List(4) { BlockingResponse() }
        val client = SequenceResponseClient(responses)
        val exchange = X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, client)
        val activeResults = responses.map { exchange.executeAsync() }
        val queuedResult = exchange.executeAsync()
        val results = activeResults + queuedResult
        val callbackStarted = CountDownLatch(1)
        val releaseCallbacks = CountDownLatch(1)
        val closeFinished = CountDownLatch(1)

        responses.forEach { response ->
            assertThat(response.bodyStarted.await(5, TimeUnit.SECONDS)).isTrue()
        }
        assertThat(client.executeCount).hasValue(4)
        results.forEach { result ->
            result.whenComplete { _, _ ->
                callbackStarted.countDown()
                releaseCallbacks.await()
            }
        }
        Thread {
                exchange.close()
                closeFinished.countDown()
            }
            .start()

        try {
            assertThat(callbackStarted.await(5, TimeUnit.SECONDS)).isTrue()
            responses.forEach { response ->
                assertThat(response.closed.await(5, TimeUnit.SECONDS)).isTrue()
                assertThat(response.closeCount).hasValue(1)
            }
            assertThat(client.executeCount).hasValue(4)
        } finally {
            releaseCallbacks.countDown()
            assertThat(closeFinished.await(5, TimeUnit.SECONDS)).isTrue()
        }
    }

    @Test
    fun asyncExecutorQueuesWholeExchangesBeforeIssuingAdditionalRequests() {
        val release = CountDownLatch(1)
        val activeResponses = List(4) { GatedResponse(validResponse(), release) }
        val queuedResponse = TestResponse(200, validResponse())
        val responses = activeResponses + queuedResponse
        val client = SequenceResponseClient(responses)
        val exchange = X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, client)
        try {
            val results = responses.map { exchange.executeAsync() }

            activeResponses.forEach { response ->
                assertThat(response.bodyStarted.await(5, TimeUnit.SECONDS)).isTrue()
            }
            assertThat(client.executeCount).hasValue(4)
            assertThat(queuedResponse.bodyRead).isFalse()
            assertThat(results.last().isDone).isFalse()

            release.countDown()

            assertThat(results.map { it.get(5, TimeUnit.SECONDS).value })
                .containsExactlyElementsOf(List(5) { ACCESS_TOKEN })
            assertThat(activeResponses).allMatch { it.closed }
            assertThat(queuedResponse.closed).isTrue()
        } finally {
            release.countDown()
            exchange.close()
        }
        assertThat(client.closed).isFalse()
    }

    @Test
    fun asyncExecutorBoundsAndRemovesCanceledQueuedExchanges() {
        val release = CountDownLatch(1)
        val activeResponses = List(4) { GatedResponse(validResponse(), release) }
        val admittedResponses = List(4) { TestResponse(200, validResponse()) }
        val client = SequenceResponseClient(activeResponses + admittedResponses)
        val exchange = X509TokenExchange(IDP_ID, SERVICE_ACCOUNT_ID, client)
        try {
            val activeResults = List(4) { exchange.executeAsync() }
            val queuedResults = List(4) { exchange.executeAsync() }

            activeResponses.forEach { response ->
                assertThat(response.bodyStarted.await(5, TimeUnit.SECONDS)).isTrue()
            }
            assertThat(client.executeCount).hasValue(4)

            val overflow = exchange.executeAsync()
            val overflowFailure =
                runCatching { overflow.get(5, TimeUnit.SECONDS) }.exceptionOrNull()
                    ?: error("Expected bounded X.509 executor rejection")
            assertThat(overflowFailure).isInstanceOf(ExecutionException::class.java)
            assertThat(overflowFailure.cause).isInstanceOf(OpenAIIoException::class.java)
            assertThat(overflowFailure.cause)
                .hasMessage("X.509 token exchange processing unavailable")

            assertThat(queuedResults.first().cancel(true)).isTrue()
            val replacement = exchange.executeAsync()
            assertThat(replacement.isDone).isFalse()
            assertThat(client.executeCount).hasValue(4)

            release.countDown()

            val successful = activeResults + queuedResults.drop(1) + replacement
            assertThat(successful.map { it.get(5, TimeUnit.SECONDS).value })
                .containsExactlyElementsOf(List(8) { ACCESS_TOKEN })
            assertThat(queuedResults.first().isCancelled).isTrue()
            assertThat(client.executeCount).hasValue(8)
            assertThat(activeResponses).allMatch { it.closed }
            assertThat(admittedResponses).allMatch { it.closed }
        } finally {
            release.countDown()
            exchange.close()
        }
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

    private fun validResponseWithRawValue(field: String, value: String): String =
        validResponse()
            .replaceFirst(Regex("\"$field\"\\s*:\\s*(?:\"[^\"]*\"|[0-9]+)"), "\"$field\": $value")

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
        val OVERSIZED_RECOGNIZED_VALUE = "x".repeat(256 * 1024)
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
    val started = CountDownLatch(1)
    var closed = false
        private set

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
        error("Unexpected synchronous call")

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> = responseFuture.also { started.countDown() }

    override fun close() {
        closed = true
    }
}

private class BlockingStartClient(private val responseFuture: CompletableFuture<HttpResponse>) :
    HttpClient {
    val started = CountDownLatch(1)
    val release = CountDownLatch(1)

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
        error("Unexpected synchronous call")

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        started.countDown()
        release.await()
        return responseFuture
    }

    override fun close() {}
}

private class NonCancellableFuture<T> : CompletableFuture<T>() {
    override fun cancel(mayInterruptIfRunning: Boolean): Boolean = false
}

private class BlockingHandoffFuture<T>(value: T) : CompletableFuture<T>() {
    val handoffStarted = CountDownLatch(1)
    val releaseHandoff = CountDownLatch(1)

    init {
        complete(value)
    }

    override fun whenComplete(action: BiConsumer<in T, in Throwable?>): CompletableFuture<T> {
        handoffStarted.countDown()
        releaseHandoff.await()
        return super.whenComplete(action)
    }
}

private class SequenceResponseClient(responses: List<HttpResponse>) : HttpClient {
    private val responses = ConcurrentLinkedQueue(responses)
    val executeCount = AtomicInteger()
    var closed = false
        private set

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
        error("Unexpected synchronous call")

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        executeCount.incrementAndGet()
        return CompletableFuture.completedFuture(
            responses.poll() ?: error("No X.509 test response remains")
        )
    }

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

private class GatedResponse(body: String, private val release: CountDownLatch) : HttpResponse {
    private val bytes = body.toByteArray()
    val bodyStarted = CountDownLatch(1)
    var closed = false
        private set

    override fun statusCode(): Int = 200

    override fun headers(): Headers = Headers.builder().build()

    override fun body(): InputStream =
        object : ByteArrayInputStream(bytes) {
            override fun read(): Int {
                awaitRelease()
                return super.read()
            }

            override fun read(buffer: ByteArray, offset: Int, length: Int): Int {
                awaitRelease()
                return super.read(buffer, offset, length)
            }

            private fun awaitRelease() {
                bodyStarted.countDown()
                try {
                    release.await()
                } catch (error: InterruptedException) {
                    Thread.currentThread().interrupt()
                    throw IOException("Interrupted while waiting to read test response", error)
                }
            }
        }

    override fun close() {
        closed = true
    }
}

private class TestResponse(
    private val statusCode: Int,
    body: String,
    private val responseHeaders: Headers = Headers.builder().build(),
) : HttpResponse {
    private val bytes = body.toByteArray()
    val bytesRead = AtomicInteger()
    val closeCount = AtomicInteger()
    var bodyRead = false
        private set

    var closed = false
        private set

    override fun statusCode(): Int = statusCode

    override fun headers(): Headers = responseHeaders

    override fun body(): InputStream {
        bodyRead = true
        return object : ByteArrayInputStream(bytes) {
            override fun read(): Int =
                super.read().also { if (it >= 0) bytesRead.incrementAndGet() }

            override fun read(buffer: ByteArray, offset: Int, length: Int): Int =
                super.read(buffer, offset, length).also { if (it > 0) bytesRead.addAndGet(it) }
        }
    }

    override fun close() {
        closeCount.incrementAndGet()
        closed = true
    }
}

private class FailingBodyResponse(private val failure: IOException, private val statusCode: Int) :
    HttpResponse {
    var closed = false
        private set

    override fun statusCode(): Int = statusCode

    override fun headers(): Headers = Headers.builder().build()

    override fun body(): InputStream =
        object : InputStream() {
            override fun read(): Int = throw failure
        }

    override fun close() {
        closed = true
    }
}
