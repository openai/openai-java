package com.openai.client.okhttp

import com.github.tomakehurst.wiremock.client.WireMock.aResponse
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
import com.openai.bedrock.BedrockEndpoint
import com.openai.core.LogLevel
import com.openai.core.Sleeper
import com.openai.models.chat.completions.ChatCompletionCreateParams
import com.openai.models.responses.ResponseCreateParams
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.time.Clock
import java.time.Duration
import java.time.Instant
import java.time.ZoneOffset
import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class BedrockOpenAIOkHttpClientTest {

    @Test
    fun runtimeChatCompletionsUseBedrockSigV4Service(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(
            post(urlPathEqualTo("/openai/v1/chat/completions"))
                .willReturn(okJson(runtimeChatCompletion()))
        )
        val client =
            BedrockOpenAIOkHttpClient.builder()
                .endpoint(BedrockEndpoint.RUNTIME)
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}/openai/v1")
                .awsRegion("us-east-1")
                .awsAccessKeyId("ACCESSKEY")
                .awsSecretAccessKey("fixture-secret-access-key")
                .awsSessionToken("session-token")
                .maxRetries(0)
                .build()

        val completion = client.chat().completions().create(runtimeChatParams())

        assertThat(completion.choices().single().message().content()).hasValue("Hello")
        assertThat(completion.choices().single().finishReason().toString()).isEqualTo("stop")
        assertThat(completion.usage().get().totalTokens()).isEqualTo(7)
        val request =
            findAll(postRequestedFor(urlPathEqualTo("/openai/v1/chat/completions"))).single()
        assertThat(request.getHeader("Authorization")).contains("/us-east-1/bedrock/aws4_request")
        assertThat(request.getHeader("X-Amz-Security-Token")).isEqualTo("session-token")
        assertThat(request.bodyAsString).contains("us.openai.gpt-5.6-sol")
        client.close()
    }

    @Test
    fun runtimeBearerAuthenticationSupportsChatAndResponses(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(
            post(urlPathEqualTo("/openai/v1/chat/completions"))
                .willReturn(okJson(runtimeChatCompletion()))
        )
        stubFor(
            post(urlPathEqualTo("/openai/v1/responses"))
                .willReturn(
                    okJson(
                        """{"id":"resp_runtime","object":"response","created_at":1,"model":"us.openai.gpt-5.6-sol","output":[]}"""
                    )
                )
        )
        val client =
            BedrockOpenAIOkHttpClient.builder()
                .endpoint(BedrockEndpoint.RUNTIME)
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}/openai/v1")
                .apiKey("bedrock-token")
                .maxRetries(0)
                .build()

        val completion = client.chat().completions().create(runtimeChatParams())
        val response =
            client
                .responses()
                .create(
                    ResponseCreateParams.builder()
                        .model("us.openai.gpt-5.6-sol")
                        .input("Say hello")
                        .build()
                )

        assertThat(completion.choices().single().message().content()).hasValue("Hello")
        assertThat(response.id()).isEqualTo("resp_runtime")
        assertThat(
                findAll(postRequestedFor(urlPathEqualTo("/openai/v1/chat/completions")))
                    .single()
                    .getHeader("Authorization")
            )
            .isEqualTo("Bearer bedrock-token")
        assertThat(
                findAll(postRequestedFor(urlPathEqualTo("/openai/v1/responses")))
                    .single()
                    .getHeader("Authorization")
            )
            .isEqualTo("Bearer bedrock-token")
        client.close()
    }

    @Test
    fun runtimeSigV4AuthenticationSupportsResponses(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(
            post(urlPathEqualTo("/openai/v1/responses"))
                .willReturn(
                    okJson(
                        """{"id":"resp_runtime_sigv4","object":"response","created_at":1,"model":"us.openai.gpt-5.6-terra","output":[]}"""
                    )
                )
        )
        val client =
            BedrockOpenAIOkHttpClient.builder()
                .endpoint(BedrockEndpoint.RUNTIME)
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}/openai/v1")
                .awsRegion("us-east-1")
                .awsAccessKeyId("ACCESSKEY")
                .awsSecretAccessKey("fixture-secret-access-key")
                .maxRetries(0)
                .build()

        val response =
            client
                .responses()
                .create(
                    ResponseCreateParams.builder()
                        .model("us.openai.gpt-5.6-terra")
                        .input("Say hello")
                        .build()
                )

        assertThat(response.id()).isEqualTo("resp_runtime_sigv4")
        val request = findAll(postRequestedFor(urlPathEqualTo("/openai/v1/responses"))).single()
        assertThat(request.getHeader("Authorization")).contains("/us-east-1/bedrock/aws4_request")
        assertThat(request.bodyAsString).contains("us.openai.gpt-5.6-terra")
        client.close()
    }

    @Test
    fun runtimeStreamingPreservesChunkOrderAndTermination(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(
            post(urlPathEqualTo("/openai/v1/chat/completions"))
                .willReturn(
                    aResponse()
                        .withHeader("Content-Type", "text/event-stream")
                        .withBody(
                            """
                            data: {"id":"chatcmpl_runtime","object":"chat.completion.chunk","created":1,"model":"us.openai.gpt-5.6-sol","choices":[{"index":0,"delta":{"role":"assistant","content":"Hel"},"finish_reason":null}]}

                            data: {"id":"chatcmpl_runtime","object":"chat.completion.chunk","created":1,"model":"us.openai.gpt-5.6-sol","choices":[{"index":0,"delta":{"content":"lo"},"finish_reason":"stop"}]}

                            data: [DONE]

                            """
                                .trimIndent()
                        )
                )
        )
        val client =
            BedrockOpenAIOkHttpClient.builder()
                .endpoint(BedrockEndpoint.RUNTIME)
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}/openai/v1")
                .awsRegion("us-east-1")
                .awsAccessKeyId("ACCESSKEY")
                .awsSecretAccessKey("fixture-secret-access-key")
                .build()
        val chunks = mutableListOf<String>()
        val finishReasons = mutableListOf<String>()

        client.chat().completions().createStreaming(runtimeChatParams()).use { stream ->
            stream.stream().forEach { chunk ->
                val choice = chunk.choices().single()
                choice.delta().content().ifPresent(chunks::add)
                choice.finishReason().ifPresent { finishReasons.add(it.toString()) }
            }
        }

        assertThat(chunks).containsExactly("Hel", "lo")
        assertThat(finishReasons).containsExactly("stop")
        assertThat(
                findAll(postRequestedFor(urlPathEqualTo("/openai/v1/chat/completions")))
                    .single()
                    .getHeader("Authorization")
            )
            .contains("/us-east-1/bedrock/aws4_request")
        client.close()
    }

    @Test
    fun runtimeBearerStreamingPreservesChunkOrderAndTermination(
        wmRuntimeInfo: WireMockRuntimeInfo
    ) {
        stubFor(
            post(urlPathEqualTo("/openai/v1/chat/completions"))
                .willReturn(
                    aResponse()
                        .withHeader("Content-Type", "text/event-stream")
                        .withBody(
                            """
                            data: {"id":"chatcmpl_runtime","object":"chat.completion.chunk","created":1,"model":"us.openai.gpt-5.6-luna","choices":[{"index":0,"delta":{"content":"Bearer"},"finish_reason":"stop"}]}

                            data: [DONE]

                            """
                                .trimIndent()
                        )
                )
        )
        val client =
            BedrockOpenAIOkHttpClient.builder()
                .endpoint(BedrockEndpoint.RUNTIME)
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}/openai/v1")
                .apiKey("bedrock-streaming-token")
                .build()
        val params =
            ChatCompletionCreateParams.builder()
                .model("us.openai.gpt-5.6-luna")
                .addUserMessage("Say hello")
                .build()
        val chunks = mutableListOf<String>()

        client.chat().completions().createStreaming(params).use { stream ->
            stream.stream().forEach { chunk ->
                chunk.choices().single().delta().content().ifPresent(chunks::add)
            }
        }

        assertThat(chunks).containsExactly("Bearer")
        assertThat(
                findAll(postRequestedFor(urlPathEqualTo("/openai/v1/chat/completions")))
                    .single()
                    .getHeader("Authorization")
            )
            .isEqualTo("Bearer bedrock-streaming-token")
        client.close()
    }

    @Test
    fun runtimeResponseStreamingSupportsBearerAuthentication(wmRuntimeInfo: WireMockRuntimeInfo) {
        verifyRuntimeResponseStreaming(wmRuntimeInfo, bearer = true)
    }

    @Test
    fun runtimeResponseStreamingSupportsSigV4Authentication(wmRuntimeInfo: WireMockRuntimeInfo) {
        verifyRuntimeResponseStreaming(wmRuntimeInfo, bearer = false)
    }

    private fun verifyRuntimeResponseStreaming(
        wmRuntimeInfo: WireMockRuntimeInfo,
        bearer: Boolean,
    ) {
        stubFor(
            post(urlPathEqualTo("/openai/v1/responses"))
                .willReturn(
                    aResponse()
                        .withHeader("Content-Type", "text/event-stream")
                        .withBody(
                            """
                            data: {"type":"response.output_text.delta","content_index":0,"delta":"Runtime","item_id":"item_1","logprobs":[],"output_index":0,"sequence_number":1}

                            data: {"type":"response.output_text.delta","content_index":0,"delta":" stream","item_id":"item_1","logprobs":[],"output_index":0,"sequence_number":2}

                            data: [DONE]

                            """
                                .trimIndent()
                        )
                )
        )
        val builder =
            BedrockOpenAIOkHttpClient.builder()
                .endpoint(BedrockEndpoint.RUNTIME)
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}/openai/v1")
        if (bearer) {
            builder.apiKey("bedrock-streaming-token")
        } else {
            builder
                .awsRegion("us-east-1")
                .awsAccessKeyId("ACCESSKEY")
                .awsSecretAccessKey("fixture-secret-access-key")
        }
        val client = builder.build()
        val params =
            ResponseCreateParams.builder().model("us.openai.gpt-5.6-sol").input("Say hello").build()
        val chunks = mutableListOf<String>()

        client.responses().createStreaming(params).use { stream ->
            stream.stream().forEach { event ->
                event.outputTextDelta().ifPresent { chunks.add(it.delta()) }
            }
        }

        assertThat(chunks).containsExactly("Runtime", " stream")
        val authorization =
            findAll(postRequestedFor(urlPathEqualTo("/openai/v1/responses")))
                .single()
                .getHeader("Authorization")
        if (bearer) {
            assertThat(authorization).isEqualTo("Bearer bedrock-streaming-token")
        } else {
            assertThat(authorization).contains("/us-east-1/bedrock/aws4_request")
        }
        client.close()
    }

    @Test
    fun runtimeAsyncChatCompletionsUseBedrockSigV4Service(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(
            post(urlPathEqualTo("/openai/v1/chat/completions"))
                .willReturn(okJson(runtimeChatCompletion()))
        )
        val client =
            BedrockOpenAIOkHttpClient.builder()
                .endpoint(BedrockEndpoint.RUNTIME)
                .baseUrl("${wmRuntimeInfo.httpBaseUrl}/openai/v1")
                .awsRegion("us-east-1")
                .awsAccessKeyId("ACCESSKEY")
                .awsSecretAccessKey("fixture-secret-access-key")
                .build()
                .async()

        val completion = client.chat().completions().create(runtimeChatParams()).join()

        assertThat(completion.choices().single().message().content()).hasValue("Hello")
        assertThat(
                findAll(postRequestedFor(urlPathEqualTo("/openai/v1/chat/completions")))
                    .single()
                    .getHeader("Authorization")
            )
            .contains("/us-east-1/bedrock/aws4_request")
        client.close()
    }

    @Test
    fun retriesResolveFreshCredentialsAndSignAgain(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubRetryingModelsResponse()
        val providerCalls = AtomicInteger()
        val provider = rotatingProvider(providerCalls)
        val client = client(wmRuntimeInfo.httpBaseUrl, provider)

        val models = client.models().list()

        assertThat(models.data()).isEmpty()
        assertThat(providerCalls).hasValue(2)
        verify(2, getRequestedFor(urlPathEqualTo("/models")))
        val requests = findAll(getRequestedFor(urlPathEqualTo("/models")))
        assertThat(requests[0].getHeader("Authorization")).contains("Credential=FIRSTACCESSKEY/")
        assertThat(requests[1].getHeader("Authorization")).contains("Credential=SECONDACCESSKEY/")
        client.close()
    }

    @Test
    fun asyncClientUsesTheSamePerAttemptSigningPath(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubRetryingModelsResponse()
        val providerCalls = AtomicInteger()
        val client = client(wmRuntimeInfo.httpBaseUrl, rotatingProvider(providerCalls)).async()

        val models = client.models().list().join()

        assertThat(models.data()).isEmpty()
        assertThat(providerCalls).hasValue(2)
        verify(2, getRequestedFor(urlPathEqualTo("/models")))
        client.close()
    }

    @Test
    fun runtimeRetriesResolveFreshCredentialsAndSignAgain(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubRetryingModelsResponse()
        val providerCalls = AtomicInteger()
        val client =
            client(
                wmRuntimeInfo.httpBaseUrl,
                rotatingProvider(providerCalls),
                BedrockEndpoint.RUNTIME,
            )

        val models = client.models().list()

        assertThat(models.data()).isEmpty()
        assertThat(providerCalls).hasValue(2)
        val requests = findAll(getRequestedFor(urlPathEqualTo("/models")))
        assertThat(requests.map { it.getHeader("Authorization") }).allMatch { authorization ->
            authorization.contains("/us-east-1/bedrock/aws4_request")
        }
        client.close()
    }

    @Test
    fun bearerProviderResolvesFreshTokenOnEveryRetry(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubRetryingModelsResponse()
        val providerCalls = AtomicInteger()
        val client =
            BedrockOpenAIOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .bedrockTokenProvider { "token-${providerCalls.incrementAndGet()}" }
                .sleeper(NoopSleeper)
                .maxRetries(1)
                .build()

        val models = client.models().list()

        assertThat(models.data()).isEmpty()
        assertThat(providerCalls).hasValue(2)
        val requests = findAll(getRequestedFor(urlPathEqualTo("/models")))
        assertThat(requests.map { it.getHeader("Authorization") })
            .containsExactly("Bearer token-1", "Bearer token-2")
        client.close()
    }

    @Test
    fun skipAuthSendsUnsignedRequests(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(
            get(urlPathEqualTo("/models")).willReturn(okJson("{\"object\":\"list\",\"data\":[]}"))
        )
        val client =
            BedrockOpenAIOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .skipAuth(true)
                .maxRetries(0)
                .build()

        val models = client.models().list()

        assertThat(models.data()).isEmpty()
        assertThat(
                findAll(getRequestedFor(urlPathEqualTo("/models")))
                    .single()
                    .getHeader("Authorization")
            )
            .isNull()
        client.close()
    }

    @Test
    fun signedRequestsDoNotFollowRedirects(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(get(urlPathEqualTo("/models")).willReturn(temporaryRedirect("/redirected-models")))
        stubFor(
            get(urlPathEqualTo("/redirected-models"))
                .willReturn(okJson("{\"object\":\"list\",\"data\":[]}"))
        )
        val client =
            client(
                wmRuntimeInfo.httpBaseUrl,
                AwsCredentialsProvider {
                    AwsBasicCredentials.create("ACCESSKEY", "fixture-secret-access-key")
                },
            )

        assertThatThrownBy { client.models().list() }.isInstanceOf(RuntimeException::class.java)
        verify(1, getRequestedFor(urlPathEqualTo("/models")))
        verify(0, getRequestedFor(urlPathEqualTo("/redirected-models")))
        client.close()
    }

    @Test
    @ResourceLock("System.err")
    fun debugLogsRedactAwsAuthorizationAndSessionToken(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(
            get(urlPathEqualTo("/models")).willReturn(okJson("{\"object\":\"list\",\"data\":[]}"))
        )
        val originalError = System.err
        val logOutput = ByteArrayOutputStream()
        System.setErr(PrintStream(logOutput))

        try {
            val client =
                BedrockOpenAIOkHttpClient.builder()
                    .endpoint(BedrockEndpoint.MANTLE)
                    .baseUrl(wmRuntimeInfo.httpBaseUrl)
                    .awsRegion("us-east-1")
                    .awsAccessKeyId("LOGACCESSKEY")
                    .awsSecretAccessKey("log-secret-access-key")
                    .awsSessionToken("log-session-token")
                    .logLevel(LogLevel.DEBUG)
                    .maxRetries(0)
                    .build()

            client.models().list()
            client.close()
        } finally {
            System.setErr(originalError)
        }

        val logs = logOutput.toString("UTF-8")
        assertThat(logs).contains("Authorization: ██")
        assertThat(logs).contains("X-Amz-Security-Token: ██")
        assertThat(logs).doesNotContain("LOGACCESSKEY")
        assertThat(logs).doesNotContain("log-secret-access-key")
        assertThat(logs).doesNotContain("log-session-token")
    }

    private fun client(
        baseUrl: String,
        provider: AwsCredentialsProvider,
        endpoint: BedrockEndpoint = BedrockEndpoint.MANTLE,
    ) =
        BedrockOpenAIOkHttpClient.builder()
            .endpoint(endpoint)
            .baseUrl(baseUrl)
            .awsRegion("us-east-1")
            .awsCredentialsProvider(provider)
            .clock(Clock.fixed(Instant.parse("2026-06-01T12:34:56Z"), ZoneOffset.UTC))
            .sleeper(NoopSleeper)
            .maxRetries(1)
            .build()

    private fun runtimeChatParams(): ChatCompletionCreateParams =
        ChatCompletionCreateParams.builder()
            .model("us.openai.gpt-5.6-sol")
            .addUserMessage("Say hello")
            .build()

    private fun runtimeChatCompletion(): String =
        """{"id":"chatcmpl_runtime","object":"chat.completion","created":1,"model":"us.openai.gpt-5.6-sol","choices":[{"index":0,"message":{"role":"assistant","content":"Hello"},"finish_reason":"stop"}],"usage":{"prompt_tokens":4,"completion_tokens":3,"total_tokens":7}}"""

    private fun rotatingProvider(providerCalls: AtomicInteger) = AwsCredentialsProvider {
        val accessKey =
            if (providerCalls.getAndIncrement() == 0) "FIRSTACCESSKEY" else "SECONDACCESSKEY"
        AwsBasicCredentials.create(accessKey, "fixture-secret-access-key")
    }

    private fun stubRetryingModelsResponse() {
        stubFor(
            get(urlPathEqualTo("/models"))
                .inScenario("retry")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(serviceUnavailable())
                .willSetStateTo("success")
        )
        stubFor(
            get(urlPathEqualTo("/models"))
                .inScenario("retry")
                .whenScenarioStateIs("success")
                .willReturn(okJson("{\"object\":\"list\",\"data\":[]}"))
        )
    }

    private object NoopSleeper : Sleeper {
        override fun sleep(duration: Duration) {}

        override fun sleepAsync(duration: Duration): CompletableFuture<Void> =
            CompletableFuture.completedFuture(null)

        override fun close() {}
    }
}
