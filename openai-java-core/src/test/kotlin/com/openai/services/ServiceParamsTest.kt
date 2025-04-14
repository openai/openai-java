// File generated from our OpenAPI spec by Stainless.

package com.openai.services

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
import com.openai.models.chat.completions.ChatCompletionTool
import com.openai.models.chat.completions.ChatCompletionToolChoiceOption
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@WireMockTest
internal class ServiceParamsTest {

    private lateinit var client: OpenAIClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            OpenAIOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun create() {
        val chatCompletionService = client.chat().completions()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

        chatCompletionService.create(
            ChatCompletionCreateParams.builder()
                .addMessage(
                    ChatCompletionDeveloperMessageParam.builder()
                        .content("string")
                        .name("name")
                        .build()
                )
                .model(ChatModel.GPT_4_1)
                .audio(
                    ChatCompletionAudioParam.builder()
                        .format(ChatCompletionAudioParam.Format.WAV)
                        .voice(ChatCompletionAudioParam.Voice.ALLOY)
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
                .n(1L)
                .parallelToolCalls(true)
                .prediction(ChatCompletionPredictionContent.builder().content("string").build())
                .presencePenalty(-2.0)
                .reasoningEffort(ReasoningEffort.LOW)
                .responseFormat(ResponseFormatText.builder().build())
                .seed(-9007199254740991L)
                .serviceTier(ChatCompletionCreateParams.ServiceTier.AUTO)
                .stop("\n")
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
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }
}
