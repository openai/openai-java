// File generated from our OpenAPI spec by Stainless.

package com.openai.services

import com.fasterxml.jackson.databind.json.JsonMapper
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.client.OpenAIClient
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.ChatCompletion
import com.openai.models.ChatCompletionAudio
import com.openai.models.ChatCompletionAudioParam
import com.openai.models.ChatCompletionCreateParams
import com.openai.models.ChatCompletionDeveloperMessageParam
import com.openai.models.ChatCompletionMessage
import com.openai.models.ChatCompletionMessageToolCall
import com.openai.models.ChatCompletionModality
import com.openai.models.ChatCompletionPredictionContent
import com.openai.models.ChatCompletionReasoningEffort
import com.openai.models.ChatCompletionStreamOptions
import com.openai.models.ChatCompletionTokenLogprob
import com.openai.models.ChatCompletionTool
import com.openai.models.ChatCompletionToolChoiceOption
import com.openai.models.ChatModel
import com.openai.models.CompletionUsage
import com.openai.models.FunctionDefinition
import com.openai.models.FunctionParameters
import com.openai.models.Metadata
import com.openai.models.ResponseFormatText
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@WireMockTest
class ServiceParamsTest {

    private val JSON_MAPPER: JsonMapper = jsonMapper()

    private lateinit var client: OpenAIClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            OpenAIOkHttpClient.builder()
                .apiKey("My API Key")
                .organization("My Organization")
                .project("My Project")
                .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
                .build()
    }

    @Test
    fun completionsCreateWithAdditionalParams() {
        val additionalHeaders = mutableMapOf<String, List<String>>()

        additionalHeaders.put("x-test-header", listOf("abc1234"))

        val additionalQueryParams = mutableMapOf<String, List<String>>()

        additionalQueryParams.put("test_query_param", listOf("def567"))

        val additionalBodyProperties = mutableMapOf<String, JsonValue>()

        additionalBodyProperties.put("testBodyProperty", JsonValue.from("ghi890"))

        val params =
            ChatCompletionCreateParams.builder()
                .addMessage(
                    ChatCompletionDeveloperMessageParam.builder()
                        .content("string")
                        .name("name")
                        .build()
                )
                .model(ChatModel.O3_MINI)
                .audio(
                    ChatCompletionAudioParam.builder()
                        .format(ChatCompletionAudioParam.Format.WAV)
                        .voice(ChatCompletionAudioParam.Voice.ALLOY)
                        .build()
                )
                .frequencyPenalty(-2.0)
                .functionCall(ChatCompletionCreateParams.FunctionCall.Auto.NONE)
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
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .addModality(ChatCompletionModality.TEXT)
                .n(1L)
                .parallelToolCalls(true)
                .prediction(ChatCompletionPredictionContent.builder().content("string").build())
                .presencePenalty(-2.0)
                .reasoningEffort(ChatCompletionReasoningEffort.LOW)
                .responseFormat(ResponseFormatText.builder().build())
                .seed(0L)
                .serviceTier(ChatCompletionCreateParams.ServiceTier.AUTO)
                .stop("string")
                .store(true)
                .streamOptions(ChatCompletionStreamOptions.builder().includeUsage(true).build())
                .temperature(1.0)
                .toolChoice(ChatCompletionToolChoiceOption.Auto.NONE)
                .addTool(
                    ChatCompletionTool.builder()
                        .function(
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
                        .build()
                )
                .topLogprobs(0L)
                .topP(1.0)
                .user("user-1234")
                .additionalHeaders(additionalHeaders)
                .additionalBodyProperties(additionalBodyProperties)
                .additionalQueryParams(additionalQueryParams)
                .build()

        val apiResponse =
            ChatCompletion.builder()
                .id("id")
                .addChoice(
                    ChatCompletion.Choice.builder()
                        .finishReason(ChatCompletion.Choice.FinishReason.STOP)
                        .index(0L)
                        .logprobs(
                            ChatCompletion.Choice.Logprobs.builder()
                                .addContent(
                                    ChatCompletionTokenLogprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .addTopLogprob(
                                            ChatCompletionTokenLogprob.TopLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .build()
                                        )
                                        .build()
                                )
                                .addRefusal(
                                    ChatCompletionTokenLogprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .addTopLogprob(
                                            ChatCompletionTokenLogprob.TopLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .message(
                            ChatCompletionMessage.builder()
                                .content("content")
                                .refusal("refusal")
                                .audio(
                                    ChatCompletionAudio.builder()
                                        .id("id")
                                        .data("data")
                                        .expiresAt(0L)
                                        .transcript("transcript")
                                        .build()
                                )
                                .functionCall(
                                    ChatCompletionMessage.FunctionCall.builder()
                                        .arguments("arguments")
                                        .name("name")
                                        .build()
                                )
                                .addToolCall(
                                    ChatCompletionMessageToolCall.builder()
                                        .id("id")
                                        .function(
                                            ChatCompletionMessageToolCall.Function.builder()
                                                .arguments("arguments")
                                                .name("name")
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .created(0L)
                .model("model")
                .serviceTier(ChatCompletion.ServiceTier.SCALE)
                .systemFingerprint("system_fingerprint")
                .usage(
                    CompletionUsage.builder()
                        .completionTokens(0L)
                        .promptTokens(0L)
                        .totalTokens(0L)
                        .completionTokensDetails(
                            CompletionUsage.CompletionTokensDetails.builder()
                                .acceptedPredictionTokens(0L)
                                .audioTokens(0L)
                                .reasoningTokens(0L)
                                .rejectedPredictionTokens(0L)
                                .build()
                        )
                        .promptTokensDetails(
                            CompletionUsage.PromptTokensDetails.builder()
                                .audioTokens(0L)
                                .cachedTokens(0L)
                                .build()
                        )
                        .build()
                )
                .build()

        stubFor(
            post(anyUrl())
                .withHeader("x-test-header", equalTo("abc1234"))
                .withQueryParam("test_query_param", equalTo("def567"))
                .withRequestBody(matchingJsonPath("$.testBodyProperty", equalTo("ghi890")))
                .willReturn(ok(JSON_MAPPER.writeValueAsString(apiResponse)))
        )

        client.chat().completions().create(params)

        verify(postRequestedFor(anyUrl()))
    }
}
