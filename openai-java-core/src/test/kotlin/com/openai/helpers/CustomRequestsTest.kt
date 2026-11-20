package com.openai.helpers

import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import com.openai.core.http.*
import com.openai.credential.BearerTokenCredential
import com.openai.errors.BadRequestException
import java.io.ByteArrayInputStream
import java.time.Duration
import java.util.ArrayDeque
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.kotlin.mock

class CustomRequestsTest {
    private class Response(private val status: Int = 200, text: String = "{}") : HttpResponse {
        var closed = false
        val stream = ByteArrayInputStream(text.toByteArray())

        override fun statusCode() = status

        override fun headers() = Headers.builder().put("x-request-id", "req-test").build()

        override fun body() = stream

        override fun close() {
            closed = true
        }
    }

    private class Transport : HttpClient {
        val requests = mutableListOf<HttpRequest>()
        val options = mutableListOf<RequestOptions>()
        val responses = ArrayDeque<Response>()
        var closed = false

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            requests.add(request)
            options.add(requestOptions)
            return if (responses.isEmpty()) Response() else responses.removeFirst()
        }

        override fun executeAsync(request: HttpRequest, requestOptions: RequestOptions) =
            CompletableFuture.completedFuture(execute(request, requestOptions))

        override fun close() {
            closed = true
        }
    }

    private val transport = Transport()

    private fun options() =
        ClientOptions.builder()
            .httpClient(transport)
            .baseUrl("https://example.test/v1")
            .apiKey("test-key")
            .maxRetries(0)

    private fun request(
        path: String = "/experimental/widgets",
        method: HttpMethod = HttpMethod.GET,
    ) = CustomRequests.Request.builder().method(method).path(path)

    @Test
    fun inheritsAuthenticationHeadersQueryAndTimeoutsWithRequestOverrides() {
        val client =
            OpenAIClientImpl(
                options()
                    .organization("org-test")
                    .project("proj-test")
                    .putHeader("X-Custom", "default")
                    .putQueryParam("scope", "default")
                    .putQueryParam("retained", "yes")
                    .timeout(Duration.ofSeconds(9))
                    .build()
            )
        val helper = CustomRequests.from(client)
        val response =
            helper.execute(
                request(method = HttpMethod.POST)
                    .body(JsonValue.from(mapOf("name" to "test", "nested" to listOf(true, null))))
                    .putHeader("x-custom", "override")
                    .putQueryParam("scope", "one")
                    .putQueryParam("scope", "two")
                    .build(),
                RequestOptions.builder().timeout(Duration.ofSeconds(3)).build(),
            )
        val sent = transport.requests.single()
        assertThat(sent.baseUrl).isEqualTo("https://example.test/v1")
        assertThat(sent.pathSegments).containsExactly("experimental", "widgets")
        assertThat(sent.headers.values("Authorization")).containsExactly("Bearer test-key")
        assertThat(sent.headers.values("OpenAI-Organization")).containsExactly("org-test")
        assertThat(sent.headers.values("OpenAI-Project")).containsExactly("proj-test")
        assertThat(sent.headers.values("X-Custom")).containsExactly("override")
        assertThat(sent.queryParams.values("scope")).containsExactly("one", "two")
        assertThat(sent.queryParams.values("retained")).containsExactly("yes")
        assertThat(sent.body!!.content().bufferedReader().readText())
            .isEqualTo("""{"name":"test","nested":[true,null]}""")
        assertThat(sent.body!!.contentType()).isEqualTo("application/json")
        assertThat(transport.options.single().timeout!!.request()).isEqualTo(Duration.ofSeconds(3))
        assertThat(response.requestId()).contains("req-test")
        response.close()
        assertThat(transport.closed).isFalse()
        client.close()
        assertThat(transport.closed).isTrue()
    }

    @Test
    fun returnsUnconsumedRawBodyAndCallerOwnsIt() {
        val response = Response(text = "arbitrary bytes")
        transport.responses.add(response)
        val result =
            CustomRequests.from(OpenAIClientImpl(options().build())).execute(request().build())
        assertThat(result).isSameAs(response)
        assertThat(response.closed).isFalse()
        assertThat(result.body().bufferedReader().readText()).isEqualTo("arbitrary bytes")
        result.close()
        assertThat(response.closed).isTrue()
    }

    @Test
    fun mapsErrorsAndClosesFailedResponse() {
        val response =
            Response(
                400,
                """{"error":{"message":"synthetic error","type":"invalid_request_error"}}""",
            )
        transport.responses.add(response)
        val failure =
            org.junit.jupiter.api.assertThrows<BadRequestException> {
                CustomRequests.from(OpenAIClientImpl(options().build())).execute(request().build())
            }
        assertThat(failure.headers().values("x-request-id")).containsExactly("req-test")
        assertThat(response.closed).isTrue()
    }

    @Test
    fun retriesThroughConfiguredPipelineAndReplaysJsonBody() {
        val failed = Response(500)
        transport.responses.add(failed)
        transport.responses.add(Response())
        val helper =
            CustomRequests.from(
                OpenAIClientImpl(options().maxRetries(1).sleeper(mock<Sleeper>()).build())
            )
        helper
            .execute(
                request(method = HttpMethod.POST).body(JsonValue.from(mapOf("value" to 42))).build()
            )
            .close()
        assertThat(transport.requests).hasSize(2)
        assertThat(failed.closed).isTrue()
        assertThat(transport.requests.map { it.body!!.content().bufferedReader().readText() })
            .containsExactly("""{"value":42}""", """{"value":42}""")
    }

    @Test
    fun retainsProviderAuthenticationHook() {
        var attempts = 0
        val authenticator =
            object : HttpRequestAuthenticator {
                override fun authenticate(request: HttpRequest): HttpRequest {
                    attempts++
                    return request.toBuilder().putHeader("X-Signed", "synthetic").build()
                }
            }
        val helper =
            CustomRequests.from(
                OpenAIClientImpl(
                    options()
                        .apiKey(null as String?)
                        .httpRequestAuthenticator(authenticator)
                        .build()
                )
            )
        helper.execute(request().build()).close()
        assertThat(attempts).isEqualTo(1)
        assertThat(transport.requests.single().headers.values("X-Signed"))
            .containsExactly("synthetic")
    }

    @Test
    fun credentialsAreResolvedForEachRequest() {
        var token = "one"
        val helper =
            CustomRequests.from(
                OpenAIClientImpl(
                    options().credential(BearerTokenCredential.create { token }).build()
                )
            )
        helper.execute(request().build()).close()
        token = "two"
        helper.execute(request().build()).close()
        assertThat(transport.requests.map { it.headers.values("Authorization").single() })
            .containsExactly("Bearer one", "Bearer two")
    }

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                "",
                "//other.test/path",
                "https://other.test/path",
                "http:other",
                "../models",
                "a/../b",
                "a/./b",
                "a//b",
                "a/",
                "a?query=1",
                "a#fragment",
                "a\\b",
                "a\nb",
            ]
    )
    fun rejectsInvalidPathsWithoutSending(path: String) {
        assertThatThrownBy { request(path).build() }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThat(transport.requests).isEmpty()
    }

    @Test
    fun permitsRootAndEncodesSegmentsAsData() {
        val helper = CustomRequests.from(OpenAIClientImpl(options().build()))
        helper.execute(request("/").build()).close()
        helper.execute(request("models/name%2Fpart").build()).close()
        assertThat(transport.requests[0].pathSegments).isEmpty()
        assertThat(transport.requests[1].url())
            .isEqualTo("https://example.test/v1/models/name%252Fpart")
    }

    @Test
    fun requestBuilderSnapshotsHeadersQueryAndPath() {
        val builder = request().putHeader("X-Test", "one").putQueryParam("key", "one")
        val first = builder.build()
        builder.path("changed").putHeader("X-Test", "two").putQueryParam("key", "two")
        CustomRequests.from(OpenAIClientImpl(options().build())).execute(first).close()
        val sent = transport.requests.single()
        assertThat(sent.pathSegments).containsExactly("experimental", "widgets")
        assertThat(sent.headers.values("X-Test")).containsExactly("one")
        assertThat(sent.queryParams.values("key")).containsExactly("one")
    }

    @Test
    fun preservesDisabledTelemetryAndExplicitUserAgent() {
        val helper =
            CustomRequests.from(
                OpenAIClientImpl(
                    options().disableTelemetry(true).putHeader("User-Agent", "my-app").build()
                )
            )
        helper.execute(request().build()).close()
        assertThat(transport.requests.single().headers.names()).noneMatch {
            it.startsWith("X-Stainless", true)
        }
        assertThat(transport.requests.single().headers.values("User-Agent"))
            .containsExactly("my-app")
    }

    @Test
    fun disabledTelemetryDoesNotAddUserAgent() {
        CustomRequests.from(OpenAIClientImpl(options().disableTelemetry(true).build()))
            .execute(request().build())
            .close()
        assertThat(transport.requests.single().headers.values("User-Agent")).isEmpty()
    }

    @Test
    fun validatesMethodAndBody() {
        for (method in listOf(HttpMethod.CONNECT, HttpMethod.TRACE)) {
            assertThatThrownBy { request(method = method) }
                .isInstanceOf(IllegalArgumentException::class.java)
        }
        for (method in listOf(HttpMethod.GET, HttpMethod.HEAD)) {
            assertThatThrownBy { request(method = method).body(JsonValue.from(null)).build() }
                .isInstanceOf(IllegalArgumentException::class.java)
        }
    }

    @Test
    fun postSupportsExplicitJsonNull() {
        CustomRequests.from(OpenAIClientImpl(options().build()))
            .execute(request(method = HttpMethod.POST).body(JsonValue.from(null)).build())
            .close()
        assertThat(transport.requests.single().body!!.content().bufferedReader().readText())
            .isEqualTo("null")
    }

    @Test
    fun legacyAzureUsesExistingAuthAndPathPreparation() {
        val helper =
            CustomRequests.from(
                OpenAIClientImpl(
                    options()
                        .baseUrl("https://example.openai.azure.com")
                        .credential(
                            com.openai.azure.credential.AzureApiKeyCredential.create("test-key")
                        )
                        .build()
                )
            )
        helper
            .execute(
                request("deployments/test/chat/completions", HttpMethod.POST)
                    .body(JsonValue.from(mapOf("messages" to emptyList<Any>())))
                    .build()
            )
            .close()
        assertThat(transport.requests.single().pathSegments)
            .containsExactly("openai", "deployments", "test", "chat", "completions")
        assertThat(transport.requests.single().headers.values("api-key"))
            .containsExactly("test-key")
    }

    @Test
    fun sendsThroughRealTransportWithoutEscapingBasePath() {
        val server =
            com.sun.net.httpserver.HttpServer.create(java.net.InetSocketAddress("127.0.0.1", 0), 0)
        val received = CompletableFuture<List<String>>()
        server.createContext("/") { exchange ->
            try {
                received.complete(
                    listOf(
                        exchange.requestMethod,
                        exchange.requestURI.toString(),
                        exchange.requestHeaders.getFirst("Authorization"),
                        exchange.requestHeaders.getFirst("Content-Type"),
                        exchange.requestBody.bufferedReader().use { it.readText() },
                    )
                )
                val bytes = "{\"ok\":true}".toByteArray()
                exchange.sendResponseHeaders(200, bytes.size.toLong())
                exchange.responseBody.use { it.write(bytes) }
            } finally {
                exchange.close()
            }
        }
        server.start()
        val client =
            com.openai.client.okhttp.OpenAIOkHttpClient.builder()
                .baseUrl("http://127.0.0.1:${server.address.port}/v1")
                .apiKey("test-key")
                .maxRetries(0)
                .build()
        try {
            CustomRequests.from(client)
                .execute(
                    request("experimental/a b", HttpMethod.POST)
                        .putQueryParam("tag", "one two")
                        .body(JsonValue.from(mapOf("name" to "example")))
                        .build()
                )
                .use {
                    assertThat(it.body().bufferedReader().readText()).isEqualTo("{\"ok\":true}")
                }
            assertThat(received.get(5, java.util.concurrent.TimeUnit.SECONDS))
                .containsExactly(
                    "POST",
                    "/v1/experimental/a%20b?tag=one%20two",
                    "Bearer test-key",
                    "application/json",
                    "{\"name\":\"example\"}",
                )
        } finally {
            client.close()
            server.stop(0)
        }
    }

    @Test
    fun explicitlyUsesAdminOnlyCredentials() {
        val helper =
            CustomRequests.from(
                OpenAIClientImpl(
                    options().apiKey(null as String?).adminApiKey("admin-test").build()
                )
            )
        helper
            .execute(
                request("organization/experimental")
                    .securityOptions(
                        com.openai.core.SecurityOptions.builder().adminApiKeyAuth(true).build()
                    )
                    .build()
            )
            .close()
        assertThat(transport.requests.single().headers.values("Authorization"))
            .containsExactly("Bearer admin-test")
    }

    @Test
    fun doesNotChooseAdminCredentialsForOrdinaryRequests() {
        val helper =
            CustomRequests.from(OpenAIClientImpl(options().adminApiKey("admin-test").build()))
        helper.execute(request().build()).close()
        helper
            .execute(
                request("organization/experimental")
                    .securityOptions(
                        com.openai.core.SecurityOptions.builder().adminApiKeyAuth(true).build()
                    )
                    .build()
            )
            .close()
        assertThat(transport.requests.map { it.headers.values("Authorization").single() })
            .containsExactly("Bearer test-key", "Bearer admin-test")
    }
}
