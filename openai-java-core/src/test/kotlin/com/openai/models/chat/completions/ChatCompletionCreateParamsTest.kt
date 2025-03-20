// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.openai.core.JsonValue
import com.openai.models.ChatModel
import com.openai.models.FunctionDefinition
import com.openai.models.FunctionParameters
import com.openai.models.Metadata
import com.openai.models.ReasoningEffort
import com.openai.models.ResponseFormatText
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionCreateParamsTest {

    @Test
    fun create() {
        ChatCompletionCreateParams.builder()
            .addMessage(
                ChatCompletionDeveloperMessageParam.builder().content("string").name("name").build()
            )
            .model(ChatModel.O3_MINI)
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
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
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
                                ChatCompletionCreateParams.WebSearchOptions.UserLocation.Approximate
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
    }

    @Test
    fun body() {
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
                    Metadata.builder()
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
                .build()

        val body = params._body()

        assertThat(body.messages())
            .containsExactly(
                ChatCompletionMessageParam.ofDeveloper(
                    ChatCompletionDeveloperMessageParam.builder()
                        .content("string")
                        .name("name")
                        .build()
                )
            )
        assertThat(body.model()).isEqualTo(ChatModel.O3_MINI)
        assertThat(body.audio())
            .contains(
                ChatCompletionAudioParam.builder()
                    .format(ChatCompletionAudioParam.Format.WAV)
                    .voice(ChatCompletionAudioParam.Voice.ALLOY)
                    .build()
            )
        assertThat(body.frequencyPenalty()).contains(-2.0)
        assertThat(body.functionCall())
            .contains(
                ChatCompletionCreateParams.FunctionCall.ofMode(
                    ChatCompletionCreateParams.FunctionCall.FunctionCallMode.NONE
                )
            )
        assertThat(body.functions().getOrNull())
            .containsExactly(
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
        assertThat(body.logitBias())
            .contains(
                ChatCompletionCreateParams.LogitBias.builder()
                    .putAdditionalProperty("foo", JsonValue.from(0))
                    .build()
            )
        assertThat(body.logprobs()).contains(true)
        assertThat(body.maxCompletionTokens()).contains(0L)
        assertThat(body.maxTokens()).contains(0L)
        assertThat(body.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
        assertThat(body.modalities().getOrNull())
            .containsExactly(ChatCompletionCreateParams.Modality.TEXT)
        assertThat(body.n()).contains(1L)
        assertThat(body.parallelToolCalls()).contains(true)
        assertThat(body.prediction())
            .contains(ChatCompletionPredictionContent.builder().content("string").build())
        assertThat(body.presencePenalty()).contains(-2.0)
        assertThat(body.reasoningEffort()).contains(ReasoningEffort.LOW)
        assertThat(body.responseFormat())
            .contains(
                ChatCompletionCreateParams.ResponseFormat.ofText(
                    ResponseFormatText.builder().build()
                )
            )
        assertThat(body.seed()).contains(-9007199254740991L)
        assertThat(body.serviceTier()).contains(ChatCompletionCreateParams.ServiceTier.AUTO)
        assertThat(body.stop()).contains(ChatCompletionCreateParams.Stop.ofString("\n"))
        assertThat(body.store()).contains(true)
        assertThat(body.streamOptions())
            .contains(ChatCompletionStreamOptions.builder().includeUsage(true).build())
        assertThat(body.temperature()).contains(1.0)
        assertThat(body.toolChoice())
            .contains(
                ChatCompletionToolChoiceOption.ofAuto(ChatCompletionToolChoiceOption.Auto.NONE)
            )
        assertThat(body.tools().getOrNull())
            .containsExactly(
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
        assertThat(body.topLogprobs()).contains(0L)
        assertThat(body.topP()).contains(1.0)
        assertThat(body.user()).contains("user-1234")
        assertThat(body.webSearchOptions())
            .contains(
                ChatCompletionCreateParams.WebSearchOptions.builder()
                    .searchContextSize(
                        ChatCompletionCreateParams.WebSearchOptions.SearchContextSize.LOW
                    )
                    .userLocation(
                        ChatCompletionCreateParams.WebSearchOptions.UserLocation.builder()
                            .approximate(
                                ChatCompletionCreateParams.WebSearchOptions.UserLocation.Approximate
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
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ChatCompletionCreateParams.builder()
                .addDeveloperMessage("string")
                .model(ChatModel.O3_MINI)
                .build()

        val body = params._body()

        assertThat(body.messages())
            .containsExactly(
                ChatCompletionMessageParam.ofDeveloper(
                    ChatCompletionDeveloperMessageParam.builder().content("string").build()
                )
            )
        assertThat(body.model()).isEqualTo(ChatModel.O3_MINI)
    }
}
