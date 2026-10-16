// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.ChatModel
import com.openai.models.Reasoning
import com.openai.models.ReasoningEffort
import com.openai.models.ResponseFormatText
import com.openai.models.responses.FunctionTool
import com.openai.models.responses.ResponseCompactParams
import com.openai.models.responses.ResponseCreateParams
import com.openai.models.responses.ResponseIncludable
import com.openai.models.responses.ResponsePrompt
import com.openai.models.responses.ResponseRetrieveParams
import com.openai.models.responses.ResponseTextConfig
import com.openai.models.responses.ToolChoiceOptions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ResponseServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val responseServiceAsync = client.responses()

        val responseFuture =
            responseServiceAsync.create(
                ResponseCreateParams.builder()
                    .accessPrograms(
                        ResponseCreateParams.AccessPrograms.builder()
                            .cyber(ResponseCreateParams.AccessPrograms.Cyber.STANDARD)
                            .build()
                    )
                    .background(true)
                    .addContextManagement(
                        ResponseCreateParams.ContextManagement.builder()
                            .type("type")
                            .compactThreshold(1000L)
                            .build()
                    )
                    .conversation("string")
                    .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                    .input("string")
                    .instructions("instructions")
                    .maxOutputTokens(16L)
                    .maxToolCalls(0L)
                    .metadata(
                        ResponseCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(ChatModel.GPT_6_ASTRA)
                    .moderation(
                        ResponseCreateParams.Moderation.builder()
                            .model("model")
                            .policy(
                                ResponseCreateParams.Moderation.Policy.builder()
                                    .input(
                                        ResponseCreateParams.Moderation.Policy.Input.builder()
                                            .mode(
                                                ResponseCreateParams.Moderation.Policy.Input.Mode
                                                    .SCORE
                                            )
                                            .build()
                                    )
                                    .output(
                                        ResponseCreateParams.Moderation.Policy.Output.builder()
                                            .mode(
                                                ResponseCreateParams.Moderation.Policy.Output.Mode
                                                    .SCORE
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .parallelToolCalls(true)
                    .previousResponseId("previous_response_id")
                    .prompt(
                        ResponsePrompt.builder()
                            .id("id")
                            .variables(
                                ResponsePrompt.Variables.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .version("version")
                            .build()
                    )
                    .promptCacheKey("prompt-cache-key-1234")
                    .promptCacheOptions(
                        ResponseCreateParams.PromptCacheOptions.builder()
                            .comparisonResponseId("resp_123")
                            .mode(ResponseCreateParams.PromptCacheOptions.Mode.IMPLICIT)
                            .prewarm(true)
                            .ttl(ResponseCreateParams.PromptCacheOptions.Ttl._30M)
                            .build()
                    )
                    .promptCacheRetention(ResponseCreateParams.PromptCacheRetention.IN_MEMORY)
                    .reasoning(
                        Reasoning.builder()
                            .context(Reasoning.Context.AUTO)
                            .effort(ReasoningEffort.NONE)
                            .generateSummary(Reasoning.GenerateSummary.AUTO)
                            .mode(Reasoning.Mode.STANDARD)
                            .summary(Reasoning.Summary.AUTO)
                            .build()
                    )
                    .safetyIdentifier("safety-identifier-1234")
                    .serviceTier(ResponseCreateParams.ServiceTier.AUTO)
                    .store(true)
                    .streamOptions(
                        ResponseCreateParams.StreamOptions.builder()
                            .includeObfuscation(true)
                            .build()
                    )
                    .temperature(1.0)
                    .text(
                        ResponseTextConfig.builder()
                            .format(ResponseFormatText.builder().build())
                            .verbosity(ResponseTextConfig.Verbosity.LOW)
                            .build()
                    )
                    .toolChoice(ToolChoiceOptions.NONE)
                    .addTool(
                        FunctionTool.builder()
                            .name("name")
                            .parameters(
                                FunctionTool.Parameters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .strict(true)
                            .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                            .async(true)
                            .deferLoading(true)
                            .description("description")
                            .outputSchema(
                                FunctionTool.OutputSchema.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
                    .topLogprobs(0L)
                    .topP(1.0)
                    .truncation(ResponseCreateParams.Truncation.AUTO)
                    .user("user-1234")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun createStreaming() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val responseServiceAsync = client.responses()

        val responseStreamResponse =
            responseServiceAsync.createStreaming(
                ResponseCreateParams.builder()
                    .accessPrograms(
                        ResponseCreateParams.AccessPrograms.builder()
                            .cyber(ResponseCreateParams.AccessPrograms.Cyber.STANDARD)
                            .build()
                    )
                    .background(true)
                    .addContextManagement(
                        ResponseCreateParams.ContextManagement.builder()
                            .type("type")
                            .compactThreshold(1000L)
                            .build()
                    )
                    .conversation("string")
                    .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                    .input("string")
                    .instructions("instructions")
                    .maxOutputTokens(16L)
                    .maxToolCalls(0L)
                    .metadata(
                        ResponseCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(ChatModel.GPT_6_ASTRA)
                    .moderation(
                        ResponseCreateParams.Moderation.builder()
                            .model("model")
                            .policy(
                                ResponseCreateParams.Moderation.Policy.builder()
                                    .input(
                                        ResponseCreateParams.Moderation.Policy.Input.builder()
                                            .mode(
                                                ResponseCreateParams.Moderation.Policy.Input.Mode
                                                    .SCORE
                                            )
                                            .build()
                                    )
                                    .output(
                                        ResponseCreateParams.Moderation.Policy.Output.builder()
                                            .mode(
                                                ResponseCreateParams.Moderation.Policy.Output.Mode
                                                    .SCORE
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .parallelToolCalls(true)
                    .previousResponseId("previous_response_id")
                    .prompt(
                        ResponsePrompt.builder()
                            .id("id")
                            .variables(
                                ResponsePrompt.Variables.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .version("version")
                            .build()
                    )
                    .promptCacheKey("prompt-cache-key-1234")
                    .promptCacheOptions(
                        ResponseCreateParams.PromptCacheOptions.builder()
                            .comparisonResponseId("resp_123")
                            .mode(ResponseCreateParams.PromptCacheOptions.Mode.IMPLICIT)
                            .prewarm(true)
                            .ttl(ResponseCreateParams.PromptCacheOptions.Ttl._30M)
                            .build()
                    )
                    .promptCacheRetention(ResponseCreateParams.PromptCacheRetention.IN_MEMORY)
                    .reasoning(
                        Reasoning.builder()
                            .context(Reasoning.Context.AUTO)
                            .effort(ReasoningEffort.NONE)
                            .generateSummary(Reasoning.GenerateSummary.AUTO)
                            .mode(Reasoning.Mode.STANDARD)
                            .summary(Reasoning.Summary.AUTO)
                            .build()
                    )
                    .safetyIdentifier("safety-identifier-1234")
                    .serviceTier(ResponseCreateParams.ServiceTier.AUTO)
                    .store(true)
                    .streamOptions(
                        ResponseCreateParams.StreamOptions.builder()
                            .includeObfuscation(true)
                            .build()
                    )
                    .temperature(1.0)
                    .text(
                        ResponseTextConfig.builder()
                            .format(ResponseFormatText.builder().build())
                            .verbosity(ResponseTextConfig.Verbosity.LOW)
                            .build()
                    )
                    .toolChoice(ToolChoiceOptions.NONE)
                    .addTool(
                        FunctionTool.builder()
                            .name("name")
                            .parameters(
                                FunctionTool.Parameters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .strict(true)
                            .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                            .async(true)
                            .deferLoading(true)
                            .description("description")
                            .outputSchema(
                                FunctionTool.OutputSchema.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
                    .topLogprobs(0L)
                    .topP(1.0)
                    .truncation(ResponseCreateParams.Truncation.AUTO)
                    .user("user-1234")
                    .build()
            )

        val received = java.util.concurrent.atomic.AtomicInteger()
        val onCompleteFuture =
            responseStreamResponse
                .subscribe { event ->
                    event.validate()
                    received.incrementAndGet()
                }
                .onCompleteFuture()
        onCompleteFuture.get()
        check(received.get() > 0) { "Expected at least one streaming event" }
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val responseServiceAsync = client.responses()

        val responseFuture =
            responseServiceAsync.retrieve(
                ResponseRetrieveParams.builder()
                    .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                    .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                    .includeObfuscation(true)
                    .startingAfter(0L)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun retrieveStreaming(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val responseServiceAsync = client.responses()

        stubFor(
            get(anyUrl())
                .withHeader("Accept", equalTo("text/event-stream"))
                .withQueryParam("stream", equalTo("true"))
                .willReturn(
                    ok()
                        .withHeader("Content-Type", "text/event-stream")
                        .withBody(
                            "data: {\"delta\":\"delta\",\"sequence_number\":0,\"type\":\"response.audio.delta\"}\n\n"
                        )
                )
        )

        val responseStreamResponse =
            responseServiceAsync.retrieveStreaming(
                ResponseRetrieveParams.builder()
                    .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                    .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                    .includeObfuscation(true)
                    .startingAfter(0L)
                    .build()
            )

        val received = java.util.concurrent.atomic.AtomicInteger()
        val onCompleteFuture =
            responseStreamResponse
                .subscribe { event ->
                    event.validate()
                    received.incrementAndGet()
                }
                .onCompleteFuture()
        onCompleteFuture.get()
        check(received.get() > 0) { "Expected at least one streaming event" }
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val responseServiceAsync = client.responses()

        val future = responseServiceAsync.delete("resp_677efb5139a88190b512bc3fef8e535d")

        val response = future.get()
    }

    @Test
    fun cancel() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val responseServiceAsync = client.responses()

        val responseFuture = responseServiceAsync.cancel("resp_677efb5139a88190b512bc3fef8e535d")

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun compact() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val responseServiceAsync = client.responses()

        val compactedResponseFuture =
            responseServiceAsync.compact(
                ResponseCompactParams.builder()
                    .model(ResponseCompactParams.Model.GPT_6_ASTRA)
                    .input("string")
                    .instructions("instructions")
                    .previousResponseId("resp_123")
                    .promptCacheKey("prompt_cache_key")
                    .promptCacheOptions(
                        ResponseCompactParams.PromptCacheOptions.builder()
                            .mode(ResponseCompactParams.PromptCacheOptions.Mode.IMPLICIT)
                            .ttl(ResponseCompactParams.PromptCacheOptions.Ttl._30M)
                            .build()
                    )
                    .promptCacheRetention(ResponseCompactParams.PromptCacheRetention.IN_MEMORY)
                    .serviceTier(ResponseCompactParams.ServiceTier.AUTO)
                    .build()
            )

        val compactedResponse = compactedResponseFuture.get()
        compactedResponse.validate()
    }
}
