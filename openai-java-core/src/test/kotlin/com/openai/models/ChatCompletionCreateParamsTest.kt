// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionCreateParamsTest {

    @Test
    fun createChatCompletionCreateParams() {
        ChatCompletionCreateParams.builder()
            .messages(
                listOf(
                    ChatCompletionMessageParam.ofChatCompletionDeveloperMessageParam(
                        ChatCompletionDeveloperMessageParam.builder()
                            .content(
                                ChatCompletionDeveloperMessageParam.Content.ofTextContent("string")
                            )
                            .role(ChatCompletionDeveloperMessageParam.Role.DEVELOPER)
                            .name("name")
                            .build()
                    )
                )
            )
            .model(ChatModel.O1)
            .audio(
                ChatCompletionAudioParam.builder()
                    .format(ChatCompletionAudioParam.Format.WAV)
                    .voice(ChatCompletionAudioParam.Voice.ALLOY)
                    .build()
            )
            .frequencyPenalty(-2.0)
            .functionCall(
                ChatCompletionCreateParams.FunctionCall.ofBehavior(
                    ChatCompletionCreateParams.FunctionCall.Behavior.NONE
                )
            )
            .functions(
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
            .modalities(listOf(ChatCompletionModality.TEXT))
            .n(1L)
            .parallelToolCalls(true)
            .prediction(
                ChatCompletionPredictionContent.builder()
                    .content(ChatCompletionPredictionContent.Content.ofTextContent("string"))
                    .type(ChatCompletionPredictionContent.Type.CONTENT)
                    .build()
            )
            .presencePenalty(-2.0)
            .reasoningEffort(ChatCompletionReasoningEffort.LOW)
            .responseFormat(
                ChatCompletionCreateParams.ResponseFormat.ofResponseFormatText(
                    ResponseFormatText.builder().type(ResponseFormatText.Type.TEXT).build()
                )
            )
            .seed(-9007199254740991L)
            .serviceTier(ChatCompletionCreateParams.ServiceTier.AUTO)
            .stop(ChatCompletionCreateParams.Stop.ofString("string"))
            .store(true)
            .streamOptions(ChatCompletionStreamOptions.builder().includeUsage(true).build())
            .temperature(1.0)
            .toolChoice(
                ChatCompletionToolChoiceOption.ofBehavior(
                    ChatCompletionToolChoiceOption.Behavior.NONE
                )
            )
            .tools(
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
                        .type(ChatCompletionTool.Type.FUNCTION)
                        .build()
                )
            )
            .topLogprobs(0L)
            .topP(1.0)
            .user("user-1234")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            ChatCompletionCreateParams.builder()
                .messages(
                    listOf(
                        ChatCompletionMessageParam.ofChatCompletionDeveloperMessageParam(
                            ChatCompletionDeveloperMessageParam.builder()
                                .content(
                                    ChatCompletionDeveloperMessageParam.Content.ofTextContent(
                                        "string"
                                    )
                                )
                                .role(ChatCompletionDeveloperMessageParam.Role.DEVELOPER)
                                .name("name")
                                .build()
                        )
                    )
                )
                .model(ChatModel.O1)
                .audio(
                    ChatCompletionAudioParam.builder()
                        .format(ChatCompletionAudioParam.Format.WAV)
                        .voice(ChatCompletionAudioParam.Voice.ALLOY)
                        .build()
                )
                .frequencyPenalty(-2.0)
                .functionCall(
                    ChatCompletionCreateParams.FunctionCall.ofBehavior(
                        ChatCompletionCreateParams.FunctionCall.Behavior.NONE
                    )
                )
                .functions(
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
                .modalities(listOf(ChatCompletionModality.TEXT))
                .n(1L)
                .parallelToolCalls(true)
                .prediction(
                    ChatCompletionPredictionContent.builder()
                        .content(ChatCompletionPredictionContent.Content.ofTextContent("string"))
                        .type(ChatCompletionPredictionContent.Type.CONTENT)
                        .build()
                )
                .presencePenalty(-2.0)
                .reasoningEffort(ChatCompletionReasoningEffort.LOW)
                .responseFormat(
                    ChatCompletionCreateParams.ResponseFormat.ofResponseFormatText(
                        ResponseFormatText.builder().type(ResponseFormatText.Type.TEXT).build()
                    )
                )
                .seed(-9007199254740991L)
                .serviceTier(ChatCompletionCreateParams.ServiceTier.AUTO)
                .stop(ChatCompletionCreateParams.Stop.ofString("string"))
                .store(true)
                .streamOptions(ChatCompletionStreamOptions.builder().includeUsage(true).build())
                .temperature(1.0)
                .toolChoice(
                    ChatCompletionToolChoiceOption.ofBehavior(
                        ChatCompletionToolChoiceOption.Behavior.NONE
                    )
                )
                .tools(
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
                            .type(ChatCompletionTool.Type.FUNCTION)
                            .build()
                    )
                )
                .topLogprobs(0L)
                .topP(1.0)
                .user("user-1234")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.messages())
            .isEqualTo(
                listOf(
                    ChatCompletionMessageParam.ofChatCompletionDeveloperMessageParam(
                        ChatCompletionDeveloperMessageParam.builder()
                            .content(
                                ChatCompletionDeveloperMessageParam.Content.ofTextContent("string")
                            )
                            .role(ChatCompletionDeveloperMessageParam.Role.DEVELOPER)
                            .name("name")
                            .build()
                    )
                )
            )
        assertThat(body.model()).isEqualTo(ChatModel.O1)
        assertThat(body.audio())
            .isEqualTo(
                ChatCompletionAudioParam.builder()
                    .format(ChatCompletionAudioParam.Format.WAV)
                    .voice(ChatCompletionAudioParam.Voice.ALLOY)
                    .build()
            )
        assertThat(body.frequencyPenalty()).isEqualTo(-2.0)
        assertThat(body.functionCall())
            .isEqualTo(
                ChatCompletionCreateParams.FunctionCall.ofBehavior(
                    ChatCompletionCreateParams.FunctionCall.Behavior.NONE
                )
            )
        assertThat(body.functions())
            .isEqualTo(
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
            .isEqualTo(
                ChatCompletionCreateParams.LogitBias.builder()
                    .putAdditionalProperty("foo", JsonValue.from(0))
                    .build()
            )
        assertThat(body.logprobs()).isEqualTo(true)
        assertThat(body.maxCompletionTokens()).isEqualTo(0L)
        assertThat(body.maxTokens()).isEqualTo(0L)
        assertThat(body.metadata())
            .isEqualTo(
                ChatCompletionCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.modalities()).isEqualTo(listOf(ChatCompletionModality.TEXT))
        assertThat(body.n()).isEqualTo(1L)
        assertThat(body.parallelToolCalls()).isEqualTo(true)
        assertThat(body.prediction())
            .isEqualTo(
                ChatCompletionPredictionContent.builder()
                    .content(ChatCompletionPredictionContent.Content.ofTextContent("string"))
                    .type(ChatCompletionPredictionContent.Type.CONTENT)
                    .build()
            )
        assertThat(body.presencePenalty()).isEqualTo(-2.0)
        assertThat(body.reasoningEffort()).isEqualTo(ChatCompletionReasoningEffort.LOW)
        assertThat(body.responseFormat())
            .isEqualTo(
                ChatCompletionCreateParams.ResponseFormat.ofResponseFormatText(
                    ResponseFormatText.builder().type(ResponseFormatText.Type.TEXT).build()
                )
            )
        assertThat(body.seed()).isEqualTo(-9007199254740991L)
        assertThat(body.serviceTier()).isEqualTo(ChatCompletionCreateParams.ServiceTier.AUTO)
        assertThat(body.stop()).isEqualTo(ChatCompletionCreateParams.Stop.ofString("string"))
        assertThat(body.store()).isEqualTo(true)
        assertThat(body.streamOptions())
            .isEqualTo(ChatCompletionStreamOptions.builder().includeUsage(true).build())
        assertThat(body.temperature()).isEqualTo(1.0)
        assertThat(body.toolChoice())
            .isEqualTo(
                ChatCompletionToolChoiceOption.ofBehavior(
                    ChatCompletionToolChoiceOption.Behavior.NONE
                )
            )
        assertThat(body.tools())
            .isEqualTo(
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
                        .type(ChatCompletionTool.Type.FUNCTION)
                        .build()
                )
            )
        assertThat(body.topLogprobs()).isEqualTo(0L)
        assertThat(body.topP()).isEqualTo(1.0)
        assertThat(body.user()).isEqualTo("user-1234")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            ChatCompletionCreateParams.builder()
                .messages(
                    listOf(
                        ChatCompletionMessageParam.ofChatCompletionDeveloperMessageParam(
                            ChatCompletionDeveloperMessageParam.builder()
                                .content(
                                    ChatCompletionDeveloperMessageParam.Content.ofTextContent(
                                        "string"
                                    )
                                )
                                .role(ChatCompletionDeveloperMessageParam.Role.DEVELOPER)
                                .build()
                        )
                    )
                )
                .model(ChatModel.O1)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.messages())
            .isEqualTo(
                listOf(
                    ChatCompletionMessageParam.ofChatCompletionDeveloperMessageParam(
                        ChatCompletionDeveloperMessageParam.builder()
                            .content(
                                ChatCompletionDeveloperMessageParam.Content.ofTextContent("string")
                            )
                            .role(ChatCompletionDeveloperMessageParam.Role.DEVELOPER)
                            .build()
                    )
                )
            )
        assertThat(body.model()).isEqualTo(ChatModel.O1)
    }
}
