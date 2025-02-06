// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionCreateParamsTest {

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
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
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
                .build()
        val body = params._body()
        assertThat(body).isNotNull
        assertThat(body.messages())
            .isEqualTo(
                listOf(
                    ChatCompletionMessageParam.ofDeveloper(
                        ChatCompletionDeveloperMessageParam.builder()
                            .content("string")
                            .name("name")
                            .build()
                    )
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
                ChatCompletionCreateParams.FunctionCall.ofAuto(
                    ChatCompletionCreateParams.FunctionCall.Auto.NONE
                )
            )
        assertThat(body.functions())
            .contains(
                listOf(
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
        assertThat(body.modalities()).contains(listOf(ChatCompletionModality.TEXT))
        assertThat(body.n()).contains(1L)
        assertThat(body.parallelToolCalls()).contains(true)
        assertThat(body.prediction())
            .contains(ChatCompletionPredictionContent.builder().content("string").build())
        assertThat(body.presencePenalty()).contains(-2.0)
        assertThat(body.reasoningEffort()).contains(ChatCompletionReasoningEffort.LOW)
        assertThat(body.responseFormat())
            .contains(
                ChatCompletionCreateParams.ResponseFormat.ofText(
                    ResponseFormatText.builder().build()
                )
            )
        assertThat(body.seed()).contains(0L)
        assertThat(body.serviceTier()).contains(ChatCompletionCreateParams.ServiceTier.AUTO)
        assertThat(body.stop()).contains(ChatCompletionCreateParams.Stop.ofString("string"))
        assertThat(body.store()).contains(true)
        assertThat(body.streamOptions())
            .contains(ChatCompletionStreamOptions.builder().includeUsage(true).build())
        assertThat(body.temperature()).contains(1.0)
        assertThat(body.toolChoice())
            .contains(
                ChatCompletionToolChoiceOption.ofAuto(ChatCompletionToolChoiceOption.Auto.NONE)
            )
        assertThat(body.tools())
            .contains(
                listOf(
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
            )
        assertThat(body.topLogprobs()).contains(0L)
        assertThat(body.topP()).contains(1.0)
        assertThat(body.user()).contains("user-1234")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ChatCompletionCreateParams.builder()
                .addDeveloperMessage("string")
                .model(ChatModel.O3_MINI)
                .build()
        val body = params._body()
        assertThat(body).isNotNull
        assertThat(body.messages())
            .isEqualTo(
                listOf(
                    ChatCompletionMessageParam.ofDeveloper(
                        ChatCompletionDeveloperMessageParam.builder().content("string").build()
                    )
                )
            )
        assertThat(body.model()).isEqualTo(ChatModel.O3_MINI)
    }
}
