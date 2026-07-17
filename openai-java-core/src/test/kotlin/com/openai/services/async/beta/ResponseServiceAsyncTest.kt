// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.beta.responses.BetaFunctionTool
import com.openai.models.beta.responses.BetaResponseIncludable
import com.openai.models.beta.responses.BetaResponsePrompt
import com.openai.models.beta.responses.BetaResponseTextConfig
import com.openai.models.beta.responses.BetaToolChoiceOptions
import com.openai.models.beta.responses.ResponseCancelParams
import com.openai.models.beta.responses.ResponseCompactParams
import com.openai.models.beta.responses.ResponseCreateParams
import com.openai.models.beta.responses.ResponseDeleteParams
import com.openai.models.beta.responses.ResponseRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ResponseServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val responseServiceAsync = client.beta().responses()

        val betaResponseFuture =
            responseServiceAsync.create(
                ResponseCreateParams.builder()
                    .addBeta(ResponseCreateParams.Beta.RESPONSES_MULTI_AGENT_V1)
                    .background(true)
                    .addContextManagement(
                        ResponseCreateParams.ContextManagement.builder()
                            .type("type")
                            .compactThreshold(1000L)
                            .build()
                    )
                    .conversation("string")
                    .addInclude(BetaResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                    .input("string")
                    .instructions("instructions")
                    .maxOutputTokens(16L)
                    .maxToolCalls(0L)
                    .metadata(
                        ResponseCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(ResponseCreateParams.Model.GPT_5_1)
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
                    .multiAgent(
                        ResponseCreateParams.MultiAgent.builder()
                            .enabled(true)
                            .maxConcurrentSubagents(1L)
                            .build()
                    )
                    .parallelToolCalls(true)
                    .previousResponseId("previous_response_id")
                    .prompt(
                        BetaResponsePrompt.builder()
                            .id("id")
                            .variables(
                                BetaResponsePrompt.Variables.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .version("version")
                            .build()
                    )
                    .promptCacheKey("prompt-cache-key-1234")
                    .promptCacheOptions(
                        ResponseCreateParams.PromptCacheOptions.builder()
                            .mode(ResponseCreateParams.PromptCacheOptions.Mode.IMPLICIT)
                            .ttl(ResponseCreateParams.PromptCacheOptions.Ttl._30M)
                            .build()
                    )
                    .promptCacheRetention(ResponseCreateParams.PromptCacheRetention.IN_MEMORY)
                    .reasoning(
                        ResponseCreateParams.Reasoning.builder()
                            .context(ResponseCreateParams.Reasoning.Context.AUTO)
                            .effort(ResponseCreateParams.Reasoning.Effort.NONE)
                            .generateSummary(ResponseCreateParams.Reasoning.GenerateSummary.AUTO)
                            .mode(ResponseCreateParams.Reasoning.Mode.STANDARD)
                            .summary(ResponseCreateParams.Reasoning.Summary.AUTO)
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
                        BetaResponseTextConfig.builder()
                            .formatText()
                            .verbosity(BetaResponseTextConfig.Verbosity.LOW)
                            .build()
                    )
                    .toolChoice(BetaToolChoiceOptions.NONE)
                    .addTool(
                        BetaFunctionTool.builder()
                            .name("name")
                            .parameters(
                                BetaFunctionTool.Parameters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .strict(true)
                            .addAllowedCaller(BetaFunctionTool.AllowedCaller.DIRECT)
                            .deferLoading(true)
                            .description("description")
                            .outputSchema(
                                BetaFunctionTool.OutputSchema.builder()
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

        val betaResponse = betaResponseFuture.get()
        betaResponse.validate()
    }

    @Test
    fun createStreaming() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val responseServiceAsync = client.beta().responses()

        val betaResponseStreamResponse =
            responseServiceAsync.createStreaming(
                ResponseCreateParams.builder()
                    .addBeta(ResponseCreateParams.Beta.RESPONSES_MULTI_AGENT_V1)
                    .background(true)
                    .addContextManagement(
                        ResponseCreateParams.ContextManagement.builder()
                            .type("type")
                            .compactThreshold(1000L)
                            .build()
                    )
                    .conversation("string")
                    .addInclude(BetaResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                    .input("string")
                    .instructions("instructions")
                    .maxOutputTokens(16L)
                    .maxToolCalls(0L)
                    .metadata(
                        ResponseCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(ResponseCreateParams.Model.GPT_5_1)
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
                    .multiAgent(
                        ResponseCreateParams.MultiAgent.builder()
                            .enabled(true)
                            .maxConcurrentSubagents(1L)
                            .build()
                    )
                    .parallelToolCalls(true)
                    .previousResponseId("previous_response_id")
                    .prompt(
                        BetaResponsePrompt.builder()
                            .id("id")
                            .variables(
                                BetaResponsePrompt.Variables.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .version("version")
                            .build()
                    )
                    .promptCacheKey("prompt-cache-key-1234")
                    .promptCacheOptions(
                        ResponseCreateParams.PromptCacheOptions.builder()
                            .mode(ResponseCreateParams.PromptCacheOptions.Mode.IMPLICIT)
                            .ttl(ResponseCreateParams.PromptCacheOptions.Ttl._30M)
                            .build()
                    )
                    .promptCacheRetention(ResponseCreateParams.PromptCacheRetention.IN_MEMORY)
                    .reasoning(
                        ResponseCreateParams.Reasoning.builder()
                            .context(ResponseCreateParams.Reasoning.Context.AUTO)
                            .effort(ResponseCreateParams.Reasoning.Effort.NONE)
                            .generateSummary(ResponseCreateParams.Reasoning.GenerateSummary.AUTO)
                            .mode(ResponseCreateParams.Reasoning.Mode.STANDARD)
                            .summary(ResponseCreateParams.Reasoning.Summary.AUTO)
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
                        BetaResponseTextConfig.builder()
                            .formatText()
                            .verbosity(BetaResponseTextConfig.Verbosity.LOW)
                            .build()
                    )
                    .toolChoice(BetaToolChoiceOptions.NONE)
                    .addTool(
                        BetaFunctionTool.builder()
                            .name("name")
                            .parameters(
                                BetaFunctionTool.Parameters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .strict(true)
                            .addAllowedCaller(BetaFunctionTool.AllowedCaller.DIRECT)
                            .deferLoading(true)
                            .description("description")
                            .outputSchema(
                                BetaFunctionTool.OutputSchema.builder()
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

        val onCompleteFuture = betaResponseStreamResponse.subscribe {}.onCompleteFuture()
        onCompleteFuture.get()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val responseServiceAsync = client.beta().responses()

        val betaResponseFuture =
            responseServiceAsync.retrieve(
                ResponseRetrieveParams.builder()
                    .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                    .addInclude(BetaResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                    .includeObfuscation(true)
                    .startingAfter(0L)
                    .addBeta(ResponseRetrieveParams.Beta.RESPONSES_MULTI_AGENT_V1)
                    .build()
            )

        val betaResponse = betaResponseFuture.get()
        betaResponse.validate()
    }

    @Test
    fun retrieveStreaming() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val responseServiceAsync = client.beta().responses()

        val betaResponseStreamResponse =
            responseServiceAsync.retrieveStreaming(
                ResponseRetrieveParams.builder()
                    .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                    .addInclude(BetaResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                    .includeObfuscation(true)
                    .startingAfter(0L)
                    .addBeta(ResponseRetrieveParams.Beta.RESPONSES_MULTI_AGENT_V1)
                    .build()
            )

        val onCompleteFuture =
            betaResponseStreamResponse
                .subscribe { betaResponse -> betaResponse.validate() }
                .onCompleteFuture()
        onCompleteFuture.get()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val responseServiceAsync = client.beta().responses()

        val future =
            responseServiceAsync.delete(
                ResponseDeleteParams.builder()
                    .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                    .addBeta(ResponseDeleteParams.Beta.RESPONSES_MULTI_AGENT_V1)
                    .build()
            )

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
        val responseServiceAsync = client.beta().responses()

        val betaResponseFuture =
            responseServiceAsync.cancel(
                ResponseCancelParams.builder()
                    .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                    .addBeta(ResponseCancelParams.Beta.RESPONSES_MULTI_AGENT_V1)
                    .build()
            )

        val betaResponse = betaResponseFuture.get()
        betaResponse.validate()
    }

    @Test
    fun compact() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val responseServiceAsync = client.beta().responses()

        val betaCompactedResponseFuture =
            responseServiceAsync.compact(
                ResponseCompactParams.builder()
                    .addBeta(ResponseCompactParams.Beta.RESPONSES_MULTI_AGENT_V1)
                    .model(ResponseCompactParams.Model.GPT_5_6_SOL)
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

        val betaCompactedResponse = betaCompactedResponseFuture.get()
        betaCompactedResponse.validate()
    }
}
