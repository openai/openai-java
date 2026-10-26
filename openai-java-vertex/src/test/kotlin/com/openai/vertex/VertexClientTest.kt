package com.openai.vertex

import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.delete
import com.github.tomakehurst.wiremock.client.WireMock.deleteRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.findAll
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.serviceUnavailable
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.temporaryRedirect
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.github.tomakehurst.wiremock.stubbing.Scenario
import com.google.auth.oauth2.AccessToken
import com.google.auth.oauth2.GoogleCredentials
import com.openai.client.okhttp.VertexOpenAIOkHttpClient
import com.openai.core.DataResidency
import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIIoException
import com.openai.models.responses.FunctionTool
import com.openai.models.responses.ResponseCreateParams
import com.openai.models.responses.ResponseInputItem
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Proxy
import java.net.URI
import java.time.Duration
import java.util.Date
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.RejectedExecutionException
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class VertexClientTest {
    private val api = "/v1/projects/test-project/locations/us-central1/publishers/openai/v1"
    private val responseJson =
        """{"id":"resp_test","object":"response","created_at":1,"model":"project-model","output":[]}"""

    private fun params() =
        ResponseCreateParams.builder().model("project-model").input("Say hello").build()

    @Test
    fun websocketAuthenticationUsesRequestAndClientTimeouts(wmRuntimeInfo: WireMockRuntimeInfo) {
        for (overrideTimeout in listOf(false, true)) {
            val interrupted = CountDownLatch(1)
            val release = CountDownLatch(1)
            val client =
                VertexOpenAIOkHttpClient.builder()
                    .baseUrl("${wmRuntimeInfo.httpBaseUrl}$api")
                    .tokenProvider {
                        try {
                            check(release.await(10, TimeUnit.SECONDS))
                        } catch (cause: InterruptedException) {
                            interrupted.countDown()
                            throw cause
                        }
                        "fake"
                    }
                    .timeout(
                        if (overrideTimeout) Duration.ofSeconds(30) else Duration.ofMillis(200)
                    )
                    .build()
            try {
                val options =
                    if (overrideTimeout)
                        RequestOptions.builder().timeout(Duration.ofMillis(200)).build()
                    else RequestOptions.none()
                val pending =
                    client
                        .async()
                        .responses()
                        .connect(com.openai.core.http.ResponseWebSocketOptions.defaults(), options)
                assertThatThrownBy { pending.get(5, TimeUnit.SECONDS) }
                    .hasRootCauseMessage("Timed out while obtaining Google credentials for Vertex.")
                assertThat(interrupted.await(5, TimeUnit.SECONDS)).isTrue()
                verify(0, getRequestedFor(urlPathEqualTo("$api/responses")))
            } finally {
                release.countDown()
                client.close()
            }
        }
    }

    @Test
    fun replayCarriesEveryOutputItemAndItsAdditionalFields(wmRuntimeInfo: WireMockRuntimeInfo) {
        val fixture =
            """[{"type":"reasoning","id":"rs_test","summary":[],"encrypted_content":"fake-sealed","new_field":{"value":1}},{"type":"function_call","id":"fc_test","call_id":"call_test","name":"lookup","arguments":"{}","status":"completed"}]"""
        val mapper = jsonMapper()
        stubFor(
            post(urlPathEqualTo("$api/responses"))
                .inScenario("replay")
                .whenScenarioStateIs(Scenario.STARTED)
                .willSetStateTo("follow")
                .willReturn(
                    okJson(
                        """{"id":"resp_first","object":"response","created_at":1,"model":"project-model","output":$fixture}"""
                    )
                )
        )
        stubFor(
            post(urlPathEqualTo("$api/responses"))
                .inScenario("replay")
                .whenScenarioStateIs("follow")
                .willReturn(okJson(responseJson))
        )
        val client =
            VertexOpenAIOkHttpClient.builder()
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}$api")
                .tokenProvider { "fake" }
                .build()
        try {
            val first = client.responses().create(params())
            val messages = mutableListOf<ResponseInputItem>()
            first.output().forEach { item ->
                messages.add(mapper.convertValue(item, ResponseInputItem::class.java))
                if (item.isFunctionCall()) {
                    messages.add(
                        ResponseInputItem.ofFunctionCallOutput(
                            ResponseInputItem.FunctionCallOutput.builder()
                                .callId(item.asFunctionCall().callId())
                                .output("ok")
                                .build()
                        )
                    )
                }
            }
            client
                .responses()
                .create(
                    ResponseCreateParams.builder()
                        .model("project-model")
                        .input(ResponseCreateParams.Input.ofResponse(messages))
                        .store(false)
                        .build()
                )
            val sent = findAll(postRequestedFor(urlPathEqualTo("$api/responses")))
            assertThat(sent).hasSize(2)
            val input = mapper.readTree(sent.last().bodyAsString).path("input")
            val expected = mapper.readTree(fixture)
            assertThat(input.size()).isEqualTo(3)
            assertThat(input[0]).isEqualTo(expected[0])
            assertThat(input[1]).isEqualTo(expected[1])
            assertThat(input[2].path("call_id").asText()).isEqualTo("call_test")
            assertThat(input[2].path("output").asText()).isEqualTo("ok")
        } finally {
            client.close()
        }
    }

    @Test
    fun vertexSyncAndAsyncCopiesRejectOpenAiResidencyBeforeAuth(
        wmRuntimeInfo: WireMockRuntimeInfo
    ) {
        val calls = AtomicInteger()
        val client =
            VertexOpenAIOkHttpClient.builder()
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}$api")
                .tokenProvider {
                    calls.incrementAndGet()
                    "fake"
                }
                .build()
        try {
            assertThatThrownBy { client.withOptions { it.dataResidency(DataResidency.EU) } }
                .isInstanceOf(IllegalArgumentException::class.java)
            assertThatThrownBy { client.async().withOptions { it.dataResidency(DataResidency.EU) } }
                .isInstanceOf(IllegalArgumentException::class.java)
            assertThat(calls.get()).isZero()
            verify(0, postRequestedFor(urlPathEqualTo("$api/responses")))
        } finally {
            client.close()
        }
    }

    @Test
    fun applicationTokensAreRefreshedOnRetryThroughACustomHttpEndpoint(
        wmRuntimeInfo: WireMockRuntimeInfo
    ) {
        val calls = AtomicInteger()
        stubFor(
            post(urlPathEqualTo("$api/responses"))
                .inScenario("callback retry")
                .whenScenarioStateIs(Scenario.STARTED)
                .willSetStateTo("ready")
                .willReturn(serviceUnavailable().withHeader("retry-after-ms", "1"))
        )
        stubFor(
            post(urlPathEqualTo("$api/responses"))
                .inScenario("callback retry")
                .whenScenarioStateIs("ready")
                .willReturn(okJson(responseJson))
        )
        val client =
            VertexOpenAIOkHttpClient.builder()
                .baseUrl("http://gateway.example.test$api")
                .proxy(
                    Proxy(Proxy.Type.HTTP, InetSocketAddress("127.0.0.1", wmRuntimeInfo.httpPort))
                )
                .tokenProvider { "fake-${calls.incrementAndGet()}" }
                .putHeader("x-test-routing", "synthetic")
                .putHeader("OpenAI-Project", "fake-openai-project")
                .maxRetries(1)
                .build()
        try {
            assertThat(client.async().responses().create(params()).get(5, TimeUnit.SECONDS).id())
                .isEqualTo("resp_test")
            assertThat(calls.get()).isEqualTo(2)
            val received = findAll(postRequestedFor(urlPathEqualTo("$api/responses")))
            assertThat(received.map { it.getHeader("Authorization") })
                .containsExactly("Bearer fake-1", "Bearer fake-2")
            assertThat(received.map { it.getHeader("x-test-routing") }).containsOnly("synthetic")
            assertThat(received.all { it.getHeader("OpenAI-Project") == null }).isTrue()
        } finally {
            client.close()
        }
    }

    @Test
    fun rejectsCompetingCredentialsAndConflictingHeadersBeforeTheCallback(
        wmRuntimeInfo: WireMockRuntimeInfo
    ) {
        val calls = AtomicInteger()
        val base = "${wmRuntimeInfo.httpBaseUrl}$api"
        assertThatThrownBy {
                VertexOpenAIOkHttpClient.builder()
                    .baseUrl(base)
                    .tokenProvider {
                        calls.incrementAndGet()
                        "fake"
                    }
                    .googleCredentials(RecordingCredentials())
                    .build()
            }
            .hasMessageContaining("only one")
        val client =
            VertexOpenAIOkHttpClient.builder()
                .baseUrl(base)
                .tokenProvider {
                    calls.incrementAndGet()
                    "fake"
                }
                .putHeader("Authorization", "Bearer fake-override")
                .maxRetries(0)
                .build()
        try {
            assertThatThrownBy { client.responses().create(params()) }
                .hasMessageContaining("cannot be combined")
            assertThat(calls.get()).isZero()
            verify(0, postRequestedFor(urlPathEqualTo("$api/responses")))
        } finally {
            client.close()
        }
    }

    @Test
    fun invalidApplicationTokensNeverReachTransport(wmRuntimeInfo: WireMockRuntimeInfo) {
        for (value in listOf("", "contains space", "fake\r\nx-test: injected")) {
            val client =
                VertexOpenAIOkHttpClient.builder()
                    .baseUrl("${wmRuntimeInfo.httpBaseUrl}$api")
                    .tokenProvider { value }
                    .maxRetries(0)
                    .build()
            try {
                assertThatThrownBy { client.responses().create(params()) }
                    .hasMessage("Vertex token provider must return a valid bearer token.")
            } finally {
                client.close()
            }
        }
        verify(0, postRequestedFor(urlPathEqualTo("$api/responses")))
    }

    @Test
    fun timedOutCallbackIsInterruptedAndDoesNotDispatch(wmRuntimeInfo: WireMockRuntimeInfo) {
        val entered = CountDownLatch(1)
        val interrupted = CountDownLatch(1)
        val release = CountDownLatch(1)
        val calls = AtomicInteger()
        stubFor(post(urlPathEqualTo("$api/responses")).willReturn(okJson(responseJson)))
        val client =
            VertexOpenAIOkHttpClient.builder()
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}$api")
                .tokenProvider {
                    if (calls.incrementAndGet() == 1) {
                        entered.countDown()
                        try {
                            check(release.await(5, TimeUnit.SECONDS))
                        } catch (cause: InterruptedException) {
                            interrupted.countDown()
                            throw cause
                        }
                    }
                    "fake"
                }
                .maxRetries(0)
                .build()
        try {
            val pending =
                client
                    .async()
                    .responses()
                    .create(
                        params(),
                        RequestOptions.builder().timeout(Duration.ofMillis(100)).build(),
                    )
            assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
            assertThatThrownBy { pending.get(5, TimeUnit.SECONDS) }
                .hasRootCauseMessage("Timed out while obtaining Google credentials for Vertex.")
            assertThat(interrupted.await(5, TimeUnit.SECONDS)).isTrue()
            release.countDown()
            assertThat(client.responses().create(params()).id()).isEqualTo("resp_test")
            verify(1, postRequestedFor(urlPathEqualTo("$api/responses")))
        } finally {
            release.countDown()
            client.close()
        }
    }

    @Test
    fun closeInterruptsCallbackWithoutClosingCallerExecutor(wmRuntimeInfo: WireMockRuntimeInfo) {
        val entered = CountDownLatch(1)
        val interrupted = CountDownLatch(1)
        val release = CountDownLatch(1)
        val executor = Executors.newSingleThreadExecutor()
        val client =
            VertexOpenAIOkHttpClient.builder()
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}$api")
                .authenticationExecutor(executor)
                .tokenProvider {
                    entered.countDown()
                    try {
                        check(release.await(5, TimeUnit.SECONDS))
                    } catch (cause: InterruptedException) {
                        interrupted.countDown()
                        throw cause
                    }
                    "fake"
                }
                .maxRetries(0)
                .build()
        try {
            val pending = client.async().responses().create(params())
            assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
            client.close()
            assertThat(interrupted.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(pending.isCompletedExceptionally).isTrue()
            assertThat(executor.submit<String> { "available" }.get(5, TimeUnit.SECONDS))
                .isEqualTo("available")
            verify(0, postRequestedFor(urlPathEqualTo("$api/responses")))
        } finally {
            release.countDown()
            client.close()
            executor.shutdownNow()
        }
    }

    @Test
    fun syncRequestOnAuthenticationExecutorDoesNotBlockItself(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(post(urlPathEqualTo("$api/responses")).willReturn(okJson(responseJson)))
        val executor = Executors.newSingleThreadExecutor()
        val client =
            VertexOpenAIOkHttpClient.builder()
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}$api")
                .authenticationExecutor(executor)
                .tokenProvider { "fake" }
                .timeout(Duration.ofSeconds(1))
                .maxRetries(0)
                .build()
        try {
            val response = executor.submit<String> { client.responses().create(params()).id() }
            assertThat(response.get(5, TimeUnit.SECONDS)).isEqualTo("resp_test")
        } finally {
            client.close()
            executor.shutdownNow()
        }
    }

    @Test
    fun overloadedCredentialLookupFailsWithoutDispatching(wmRuntimeInfo: WireMockRuntimeInfo) {
        val release = CountDownLatch(1)
        val credentials = RecordingCredentials { release.await() }
        val client =
            VertexOpenAIOkHttpClient.builder()
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}$api")
                .googleCredentials(credentials)
                .maxRetries(0)
                .build()
        try {
            val requests = (1..100).map { client.async().responses().create(params()) }
            assertThatThrownBy {
                    CompletableFuture.anyOf(*requests.toTypedArray()).get(5, TimeUnit.SECONDS)
                }
                .hasCauseInstanceOf(OpenAIIoException::class.java)
                .hasRootCauseInstanceOf(RejectedExecutionException::class.java)
            verify(0, postRequestedFor(urlPathEqualTo("$api/responses")))
        } finally {
            client.close()
            release.countDown()
        }
    }

    @Test
    fun transientCredentialLookupIsRetried(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(post(urlPathEqualTo("$api/responses")).willReturn(okJson(responseJson)))
        val credentials = RecordingCredentials { if (it == 1) throw IOException("try again") }
        val client =
            VertexOpenAIOkHttpClient.builder()
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}$api")
                .googleCredentials(credentials)
                .maxRetries(1)
                .build()
        try {
            assertThat(client.responses().create(params()).id()).isEqualTo("resp_test")
            assertThat(credentials.calls.get()).isEqualTo(2)
            verify(1, postRequestedFor(urlPathEqualTo("$api/responses")))
        } finally {
            client.close()
        }
    }

    @Test
    fun responsesReuseTheSdkWhileAuthRefreshesAtEachRetry(wmRuntimeInfo: WireMockRuntimeInfo) {
        val credentials = RecordingCredentials()
        stubFor(
            post(urlPathEqualTo("$api/responses"))
                .inScenario("retry")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(serviceUnavailable())
                .willSetStateTo("ok")
        )
        stubFor(
            post(urlPathEqualTo("$api/responses"))
                .inScenario("retry")
                .whenScenarioStateIs("ok")
                .willReturn(okJson(responseJson))
        )
        stubFor(get(urlPathEqualTo("$api/responses/resp_test")).willReturn(okJson(responseJson)))
        stubFor(
            delete(urlPathEqualTo("$api/responses/resp_test"))
                .willReturn(aResponse().withStatus(204))
        )

        val client =
            VertexOpenAIOkHttpClient.builder()
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}$api")
                .googleCredentials(credentials)
                .maxRetries(1)
                .build()
        try {
            assertThat(
                    client
                        .withOptions { it.organization("org-explicit").project("proj-explicit") }
                        .async()
                        .responses()
                        .create(params())
                        .get()
                        .id()
                )
                .isEqualTo("resp_test")
            assertThat(client.responses().retrieve("resp_test").id()).isEqualTo("resp_test")
            client.responses().delete("resp_test")
        } finally {
            client.close()
        }
        val creates = findAll(postRequestedFor(urlPathEqualTo("$api/responses")))
        assertThat(creates).hasSize(2)
        assertThat(creates.map { it.getHeader("Authorization") })
            .containsExactlyInAnyOrder("Bearer fake-token-1", "Bearer fake-token-2")
        assertThat(creates).allSatisfy {
            assertThat(it.getHeader("x-goog-user-project")).isEqualTo("quota-project")
            assertThat(it.getHeader("OpenAI-Organization")).isNull()
            assertThat(it.getHeader("OpenAI-Project")).isNull()
            assertThat(it.bodyAsString).contains("project-model")
        }
        verify(getRequestedFor(urlPathEqualTo("$api/responses/resp_test")))
        verify(deleteRequestedFor(urlPathEqualTo("$api/responses/resp_test")))
        assertThat(credentials.calls).hasValue(4)
    }

    @Test
    fun credentialsNeverGoToAnotherOriginOrFollowRedirects(wmRuntimeInfo: WireMockRuntimeInfo) {
        val credentials = RecordingCredentials()
        stubFor(
            post(urlPathEqualTo("$api/responses"))
                .willReturn(temporaryRedirect("${wmRuntimeInfo.httpBaseUrl}/redirected"))
        )
        val client =
            VertexOpenAIOkHttpClient.builder()
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}$api")
                .googleCredentials(credentials)
                .maxRetries(0)
                .build()
        try {
            assertThatThrownBy { client.responses().create(params()) }
                .isInstanceOf(RuntimeException::class.java)
            verify(0, postRequestedFor(urlPathEqualTo("/redirected")))
            val previousCalls = credentials.calls.get()
            assertThatThrownBy {
                    client
                        .withOptions { it.baseUrl("https://api.openai.com/v1") }
                        .responses()
                        .create(params())
                }
                .hasMessageContaining("different origin")
            assertThatThrownBy {
                    client
                        .withOptions { it.putHeader("Authorization", "Bearer fake-other") }
                        .responses()
                        .create(params())
                }
                .hasMessageContaining("Authorization")
            assertThatThrownBy {
                    client.withOptions { it.apiKey("fake-openai") }.responses().create(params())
                }
                .hasMessageContaining("Provider authentication")
            assertThatThrownBy {
                    client.withOptions { it.adminApiKey("fake-admin") }.responses().create(params())
                }
                .hasMessageContaining("Provider authentication")
            assertThatThrownBy {
                    client
                        .withOptions { it.putHeader("api-key", "fake-azure") }
                        .responses()
                        .create(params())
                }
                .hasMessageContaining("api-key")
            assertThat(credentials.calls).hasValue(previousCalls)
        } finally {
            client.close()
        }
    }

    @Test
    fun defaultAndCustomConfigurationOnlyNeedVertexInputs() {
        assertThat(vertexBaseUrl(null, "example-project", "us-central1"))
            .isEqualTo(
                "https://us-central1-aiplatform.googleapis.com$api"
                    .replace("test-project", "example-project")
            )
        assertThat(vertexBaseUrl(null, "example-project", "global"))
            .isEqualTo(
                "https://aiplatform.googleapis.com/v1/projects/example-project/locations/global/publishers/openai/v1"
            )
        assertThat(vertexBaseUrl("https://proxy.example.test/openai/v1", null, null))
            .isEqualTo("https://proxy.example.test/openai/v1")
        assertThatThrownBy { vertexBaseUrl(null, "../wrong", "us-central1") }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { vertexBaseUrl("https://user:password@proxy.example.test", null, null) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun domainScopedProjectRoutesToVertex() {
        val builder =
            VertexOpenAIOkHttpClient.builder()
                .projectId("example.com:my-project")
                .location("us-central1")
                .tokenProvider { "fake" }
        val client = builder.build()
        try {
            client.withOptions {
                assertThat(it.build().baseUrl())
                    .isEqualTo(
                        "https://us-central1-aiplatform.googleapis.com/v1/projects/" +
                            "example.com:my-project/locations/us-central1/publishers/openai/v1"
                    )
            }
            assertThatThrownBy { builder.location("us-central1.example").build().close() }
                .hasMessageContaining("valid Google Cloud location")
        } finally {
            client.close()
        }
    }

    @Test
    fun googleLibraryCoordinatesExpiredRefreshForConcurrentCalls(
        wmRuntimeInfo: WireMockRuntimeInfo
    ) {
        val refreshed = AtomicInteger()
        val credentials =
            object :
                GoogleCredentials(
                    GoogleCredentials.newBuilder()
                        .setAccessToken(AccessToken("fake-expired", Date(0)))
                        .setQuotaProjectId("quota-project")
                ) {
                override fun createScoped(scopes: Collection<String>): GoogleCredentials = this

                override fun refreshAccessToken(): AccessToken {
                    refreshed.incrementAndGet()
                    return AccessToken(
                        "fake-refreshed",
                        Date(System.currentTimeMillis() + 3600_000),
                    )
                }
            }
        stubFor(post(urlPathEqualTo("$api/responses")).willReturn(okJson(responseJson)))
        val client =
            VertexOpenAIOkHttpClient.builder()
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}$api")
                .googleCredentials(credentials)
                .build()
        try {
            val calls = List(8) { client.async().responses().create(params()) }
            CompletableFuture.allOf(*calls.toTypedArray()).get(10, TimeUnit.SECONDS)
            assertThat(calls.map { it.get().id() }).containsOnly("resp_test")
        } finally {
            client.close()
        }
        assertThat(refreshed).hasValue(1)
        assertThat(findAll(postRequestedFor(urlPathEqualTo("$api/responses")))).allSatisfy {
            assertThat(it.getHeader("Authorization")).isEqualTo("Bearer fake-refreshed")
            assertThat(it.getHeader("x-goog-user-project")).isEqualTo("quota-project")
        }
    }

    @Test
    fun timedOutCredentialWaitNeverDispatchesAndDoesNotBreakAnotherCaller(
        wmRuntimeInfo: WireMockRuntimeInfo
    ) {
        val entered = CountDownLatch(1)
        val released = CountDownLatch(1)
        val credentials =
            object : GoogleCredentials() {
                override fun createScoped(scopes: Collection<String>): GoogleCredentials = this

                override fun getRequestMetadata(uri: URI): Map<String, List<String>> {
                    entered.countDown()
                    check(released.await(10, TimeUnit.SECONDS))
                    return mapOf("Authorization" to listOf("Bearer fake-refresh"))
                }
            }
        stubFor(post(urlPathEqualTo("$api/responses")).willReturn(okJson(responseJson)))
        val client =
            VertexOpenAIOkHttpClient.builder()
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}$api")
                .googleCredentials(credentials)
                .maxRetries(0)
                .build()
        try {
            val shortWait =
                client
                    .async()
                    .responses()
                    .create(
                        params(),
                        RequestOptions.builder().timeout(Duration.ofMillis(100)).build(),
                    )
            assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
            assertThatThrownBy { shortWait.get(5, TimeUnit.SECONDS) }
                .hasRootCauseMessage("Timed out while obtaining Google credentials for Vertex.")
            verify(0, postRequestedFor(urlPathEqualTo("$api/responses")))
            released.countDown()
            assertThat(client.responses().create(params()).id()).isEqualTo("resp_test")
            // A completed late token from the timed-out waiter must never start an HTTP call.
            verify(1, postRequestedFor(urlPathEqualTo("$api/responses")))
        } finally {
            released.countDown()
            client.close()
        }
    }

    @Test
    fun toolsAndStreamErrorsCrossTheOrdinarySdkBoundaryWithoutReplay(
        wmRuntimeInfo: WireMockRuntimeInfo
    ) {
        val body =
            "event: response.output_text.delta\n" +
                """data: {"type":"response.output_text.delta","sequence_number":1,"item_id":"item_test","output_index":0,"content_index":0,"delta":"ok","logprobs":[]}""" +
                "\n\nevent: error\n" +
                """data: {"type":"error","code":"unsupported_feature","message":"fixture","param":null,"sequence_number":2}""" +
                "\n\ndata: [DONE]\n\n"
        stubFor(
            post(urlPathEqualTo("$api/responses"))
                .willReturn(
                    aResponse().withHeader("Content-Type", "text/event-stream").withBody(body)
                )
        )
        val client =
            VertexOpenAIOkHttpClient.builder()
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}$api")
                .googleCredentials(RecordingCredentials())
                .maxRetries(2)
                .build()
        try {
            val request =
                ResponseCreateParams.builder()
                    .model("project-model")
                    .input("Say hello")
                    .addTool(
                        FunctionTool.builder()
                            .name("echo_fixture")
                            .parameters(
                                FunctionTool.Parameters.builder()
                                    .putAdditionalProperty("type", JsonValue.from("object"))
                                    .putAdditionalProperty(
                                        "properties",
                                        JsonValue.from(emptyMap<String, Any>()),
                                    )
                                    .putAdditionalProperty(
                                        "required",
                                        JsonValue.from(emptyList<String>()),
                                    )
                                    .putAdditionalProperty(
                                        "additionalProperties",
                                        JsonValue.from(false),
                                    )
                                    .build()
                            )
                            .strict(true)
                            .build()
                    )
                    .build()
            client.responses().createStreaming(request).use { stream ->
                val events = stream.stream().toArray().toList()
                assertThat(events).hasSize(2)
                val first = events[0] as com.openai.models.responses.ResponseStreamEvent
                val last = events[1] as com.openai.models.responses.ResponseStreamEvent
                assertThat(first.asOutputTextDelta().delta()).isEqualTo("ok")
                assertThat(last.asError().code()).hasValue("unsupported_feature")
            }
        } finally {
            client.close()
        }
        val requests = findAll(postRequestedFor(urlPathEqualTo("$api/responses")))
        assertThat(requests).hasSize(1)
        assertThat(requests.single().bodyAsString).contains("echo_fixture", "project-model")
    }

    private class RecordingCredentials(private val beforeRequest: ((Int) -> Unit)? = null) :
        GoogleCredentials() {
        val calls = AtomicInteger()

        override fun createScoped(scopes: Collection<String>): GoogleCredentials = this

        override fun getRequestMetadata(uri: URI): Map<String, List<String>> {
            val attempt = calls.incrementAndGet()
            beforeRequest?.invoke(attempt)
            return mapOf(
                "Authorization" to listOf("Bearer fake-token-$attempt"),
                "x-goog-user-project" to listOf("quota-project"),
            )
        }
    }
}
