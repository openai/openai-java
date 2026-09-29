// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.chat

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.findAll
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.reset
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.ChatModel
import com.openai.models.FunctionDefinition
import com.openai.models.FunctionParameters
import com.openai.models.ReasoningEffort
import com.openai.models.ResponseFormatText
import com.openai.models.chat.completions.ChatCompletionAudioParam
import com.openai.models.chat.completions.ChatCompletionCreateParams
import com.openai.models.chat.completions.ChatCompletionDeveloperMessageParam
import com.openai.models.chat.completions.ChatCompletionPredictionContent
import com.openai.models.chat.completions.ChatCompletionStreamOptions
import com.openai.models.chat.completions.ChatCompletionToolChoiceOption
import com.openai.models.chat.completions.ChatCompletionUpdateParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ChatCompletionServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val chatCompletionService = client.chat().completions()

        val chatCompletion =
            chatCompletionService.create(
                ChatCompletionCreateParams.builder()
                    .addMessage(
                        ChatCompletionDeveloperMessageParam.builder()
                            .content("string")
                            .name("name")
                            .build()
                    )
                    .model(ChatModel.GPT_6_ASTRA)
                    .audio(
                        ChatCompletionAudioParam.builder()
                            .format(ChatCompletionAudioParam.Format.WAV)
                            .voice(ChatCompletionAudioParam.Voice.UnionMember1.ALLOY)
                            .build()
                    )
                    .frequencyPenalty(-2.0)
                    .functionCall(ChatCompletionCreateParams.FunctionCall.FunctionCallMode.NONE)
                    .addFunction(
                        ChatCompletionCreateParams.Function.builder()
                            .name("name")
                            .description("description")
                            .parameters(
                                FunctionParameters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
                    .logitBias(
                        ChatCompletionCreateParams.LogitBias.builder()
                            .putAdditionalProperty("foo", JsonValue.from(0))
                            .build()
                    )
                    .logprobs(true)
                    .maxCompletionTokens(0L)
                    .maxTokens(0L)
                    .metadata(
                        ChatCompletionCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .addModality(ChatCompletionCreateParams.Modality.TEXT)
                    .moderation(
                        ChatCompletionCreateParams.Moderation.builder()
                            .model("model")
                            .policy(
                                ChatCompletionCreateParams.Moderation.Policy.builder()
                                    .input(
                                        ChatCompletionCreateParams.Moderation.Policy.Input.builder()
                                            .mode(
                                                ChatCompletionCreateParams.Moderation.Policy.Input
                                                    .Mode
                                                    .SCORE
                                            )
                                            .build()
                                    )
                                    .output(
                                        ChatCompletionCreateParams.Moderation.Policy.Output
                                            .builder()
                                            .mode(
                                                ChatCompletionCreateParams.Moderation.Policy.Output
                                                    .Mode
                                                    .SCORE
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .n(1L)
                    .parallelToolCalls(true)
                    .prediction(ChatCompletionPredictionContent.builder().content("string").build())
                    .presencePenalty(-2.0)
                    .promptCacheKey("prompt-cache-key-1234")
                    .promptCacheOptions(
                        ChatCompletionCreateParams.PromptCacheOptions.builder()
                            .mode(ChatCompletionCreateParams.PromptCacheOptions.Mode.IMPLICIT)
                            .ttl(ChatCompletionCreateParams.PromptCacheOptions.Ttl._30M)
                            .build()
                    )
                    .promptCacheRetention(ChatCompletionCreateParams.PromptCacheRetention.IN_MEMORY)
                    .reasoningEffort(ReasoningEffort.NONE)
                    .responseFormat(ResponseFormatText.builder().build())
                    .safetyIdentifier("safety-identifier-1234")
                    .seed(-9007199254740991L)
                    .serviceTier(ChatCompletionCreateParams.ServiceTier.AUTO)
                    .stop("\n")
                    .store(true)
                    .streamOptions(
                        ChatCompletionStreamOptions.builder()
                            .includeObfuscation(true)
                            .includeUsage(true)
                            .build()
                    )
                    .temperature(1.0)
                    .toolChoice(ChatCompletionToolChoiceOption.Auto.NONE)
                    .addFunctionTool(
                        FunctionDefinition.builder()
                            .name("name")
                            .description("description")
                            .parameters(
                                FunctionParameters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .strict(true)
                            .build()
                    )
                    .topLogprobs(0L)
                    .topP(1.0)
                    .user("user-1234")
                    .verbosity(ChatCompletionCreateParams.Verbosity.LOW)
                    .webSearchOptions(
                        ChatCompletionCreateParams.WebSearchOptions.builder()
                            .searchContextSize(
                                ChatCompletionCreateParams.WebSearchOptions.SearchContextSize.LOW
                            )
                            .userLocation(
                                ChatCompletionCreateParams.WebSearchOptions.UserLocation.builder()
                                    .approximate(
                                        ChatCompletionCreateParams.WebSearchOptions.UserLocation
                                            .Approximate
                                            .builder()
                                            .city("city")
                                            .country("country")
                                            .region("region")
                                            .timezone("timezone")
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        chatCompletion.validate()
    }

    @Test
    fun createStreaming() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val chatCompletionService = client.chat().completions()

        val chatCompletionStreamResponse =
            chatCompletionService.createStreaming(
                ChatCompletionCreateParams.builder()
                    .addMessage(
                        ChatCompletionDeveloperMessageParam.builder()
                            .content("string")
                            .name("name")
                            .build()
                    )
                    .model(ChatModel.GPT_6_ASTRA)
                    .audio(
                        ChatCompletionAudioParam.builder()
                            .format(ChatCompletionAudioParam.Format.WAV)
                            .voice(ChatCompletionAudioParam.Voice.UnionMember1.ALLOY)
                            .build()
                    )
                    .frequencyPenalty(-2.0)
                    .functionCall(ChatCompletionCreateParams.FunctionCall.FunctionCallMode.NONE)
                    .addFunction(
                        ChatCompletionCreateParams.Function.builder()
                            .name("name")
                            .description("description")
                            .parameters(
                                FunctionParameters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
                    .logitBias(
                        ChatCompletionCreateParams.LogitBias.builder()
                            .putAdditionalProperty("foo", JsonValue.from(0))
                            .build()
                    )
                    .logprobs(true)
                    .maxCompletionTokens(0L)
                    .maxTokens(0L)
                    .metadata(
                        ChatCompletionCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .addModality(ChatCompletionCreateParams.Modality.TEXT)
                    .moderation(
                        ChatCompletionCreateParams.Moderation.builder()
                            .model("model")
                            .policy(
                                ChatCompletionCreateParams.Moderation.Policy.builder()
                                    .input(
                                        ChatCompletionCreateParams.Moderation.Policy.Input.builder()
                                            .mode(
                                                ChatCompletionCreateParams.Moderation.Policy.Input
                                                    .Mode
                                                    .SCORE
                                            )
                                            .build()
                                    )
                                    .output(
                                        ChatCompletionCreateParams.Moderation.Policy.Output
                                            .builder()
                                            .mode(
                                                ChatCompletionCreateParams.Moderation.Policy.Output
                                                    .Mode
                                                    .SCORE
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .n(1L)
                    .parallelToolCalls(true)
                    .prediction(ChatCompletionPredictionContent.builder().content("string").build())
                    .presencePenalty(-2.0)
                    .promptCacheKey("prompt-cache-key-1234")
                    .promptCacheOptions(
                        ChatCompletionCreateParams.PromptCacheOptions.builder()
                            .mode(ChatCompletionCreateParams.PromptCacheOptions.Mode.IMPLICIT)
                            .ttl(ChatCompletionCreateParams.PromptCacheOptions.Ttl._30M)
                            .build()
                    )
                    .promptCacheRetention(ChatCompletionCreateParams.PromptCacheRetention.IN_MEMORY)
                    .reasoningEffort(ReasoningEffort.NONE)
                    .responseFormat(ResponseFormatText.builder().build())
                    .safetyIdentifier("safety-identifier-1234")
                    .seed(-9007199254740991L)
                    .serviceTier(ChatCompletionCreateParams.ServiceTier.AUTO)
                    .stop("\n")
                    .store(true)
                    .streamOptions(
                        ChatCompletionStreamOptions.builder()
                            .includeObfuscation(true)
                            .includeUsage(true)
                            .build()
                    )
                    .temperature(1.0)
                    .toolChoice(ChatCompletionToolChoiceOption.Auto.NONE)
                    .addFunctionTool(
                        FunctionDefinition.builder()
                            .name("name")
                            .description("description")
                            .parameters(
                                FunctionParameters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .strict(true)
                            .build()
                    )
                    .topLogprobs(0L)
                    .topP(1.0)
                    .user("user-1234")
                    .verbosity(ChatCompletionCreateParams.Verbosity.LOW)
                    .webSearchOptions(
                        ChatCompletionCreateParams.WebSearchOptions.builder()
                            .searchContextSize(
                                ChatCompletionCreateParams.WebSearchOptions.SearchContextSize.LOW
                            )
                            .userLocation(
                                ChatCompletionCreateParams.WebSearchOptions.UserLocation.builder()
                                    .approximate(
                                        ChatCompletionCreateParams.WebSearchOptions.UserLocation
                                            .Approximate
                                            .builder()
                                            .city("city")
                                            .country("country")
                                            .region("region")
                                            .timezone("timezone")
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        chatCompletionStreamResponse.use {
            chatCompletionStreamResponse.stream().forEach { chatCompletion ->
                chatCompletion.validate()
            }
        }
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val chatCompletionService = client.chat().completions()

        val chatCompletion = chatCompletionService.retrieve("completion_id")

        chatCompletion.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val chatCompletionService = client.chat().completions()

        val chatCompletion =
            chatCompletionService.update(
                ChatCompletionUpdateParams.builder()
                    .completionId("completion_id")
                    .metadata(
                        ChatCompletionUpdateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        chatCompletion.validate()
    }

    @Test
    fun listStopsOnExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        try {
            // A terminal page can still contain items and a cursor
            stubFor(
                get(anyUrl())
                    .willReturn(okJson("{\"data\":[{\"id\":\"item_1\"}],\"has_more\":false}"))
            )
            val page = client.chat().completions().list()
            assertThat(page.items()).hasSize(1)
            assertThat(page.hasNextPage()).isFalse()

            assertThat(page.autoPager().toList()).hasSize(1)

            assertThat(findAll(getRequestedFor(anyUrl()))).hasSize(1)
        } finally {
            client.close()
        }
    }

    @Test
    fun listContinuesUntilExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
        // Both explicit true and a missing flag preserve normal cursor traversal.
        for (firstResponse in
            listOf(
                "{\"data\":[{\"id\":\"item_1\"}],\"has_more\":true}",
                "{\"data\":[{\"id\":\"item_1\"}]}",
            )) {
            reset()
            val client =
                OpenAIOkHttpClient.builder()
                    .baseUrl(wmRuntimeInfo.httpBaseUrl)
                    .apiKey("My API Key")
                    .adminApiKey("My Admin API Key")
                    .build()
            try {
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("Started")
                        .willReturn(okJson(firstResponse))
                        .willSetStateTo("terminal")
                )
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("terminal")
                        .willReturn(okJson("{\"data\":[{\"id\":\"item_1\"}],\"has_more\":false}"))
                        .willSetStateTo("unexpected")
                )
                // Bound a regression to one extra request instead of an infinite loop.
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("unexpected")
                        .willReturn(okJson("{}"))
                )
                val page = client.chat().completions().list()
                assertThat(page.hasNextPage()).isTrue()

                assertThat(page.autoPager().toList()).hasSize(2)

                assertThat(findAll(getRequestedFor(anyUrl()))).hasSize(2)
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val chatCompletionService = client.chat().completions()

        val page = chatCompletionService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val chatCompletionService = client.chat().completions()

        val chatCompletionDeleted = chatCompletionService.delete("completion_id")

        chatCompletionDeleted.validate()
    }
}
