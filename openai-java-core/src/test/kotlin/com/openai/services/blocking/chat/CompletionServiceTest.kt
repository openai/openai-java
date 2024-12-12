// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.chat

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.ChatCompletionAudioParam
import com.openai.models.ChatCompletionCreateParams
import com.openai.models.ChatCompletionMessageParam
import com.openai.models.ChatCompletionModality
import com.openai.models.ChatCompletionPredictionContent
import com.openai.models.ChatCompletionStreamOptions
import com.openai.models.ChatCompletionSystemMessageParam
import com.openai.models.ChatCompletionTool
import com.openai.models.ChatCompletionToolChoiceOption
import com.openai.models.ChatModel
import com.openai.models.FunctionDefinition
import com.openai.models.FunctionParameters
import com.openai.models.ResponseFormatText
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class CompletionServiceTest {

    @Test
    fun callCreate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val completionService = client.chat().completions()
        val chatCompletion =
            completionService.create(
                ChatCompletionCreateParams.builder()
                    .messages(
                        listOf(
                            ChatCompletionMessageParam.ofChatCompletionSystemMessageParam(
                                ChatCompletionSystemMessageParam.builder()
                                    .content(
                                        ChatCompletionSystemMessageParam.Content.ofTextContent(
                                            "string"
                                        )
                                    )
                                    .role(ChatCompletionSystemMessageParam.Role.SYSTEM)
                                    .name("name")
                                    .build()
                            )
                        )
                    )
                    .model(ChatModel.O1_PREVIEW)
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
                            .content(
                                ChatCompletionPredictionContent.Content.ofTextContent("string")
                            )
                            .type(ChatCompletionPredictionContent.Type.CONTENT)
                            .build()
                    )
                    .presencePenalty(-2.0)
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
            )
        println(chatCompletion)
        chatCompletion.validate()
    }

    @Test
    fun callCreateStreaming() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val completionService = client.chat().completions()

        val chatCompletionStream =
            completionService.createStreaming(
                ChatCompletionCreateParams.builder()
                    .messages(
                        listOf(
                            ChatCompletionMessageParam.ofChatCompletionSystemMessageParam(
                                ChatCompletionSystemMessageParam.builder()
                                    .content(
                                        ChatCompletionSystemMessageParam.Content.ofTextContent(
                                            "string"
                                        )
                                    )
                                    .role(ChatCompletionSystemMessageParam.Role.SYSTEM)
                                    .name("name")
                                    .build()
                            )
                        )
                    )
                    .model(ChatModel.O1_PREVIEW)
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
                            .content(
                                ChatCompletionPredictionContent.Content.ofTextContent("string")
                            )
                            .type(ChatCompletionPredictionContent.Type.CONTENT)
                            .build()
                    )
                    .presencePenalty(-2.0)
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
            )

        chatCompletionStream.use {
            chatCompletionStream.stream().forEach {
                println(it)
                it.validate()
            }
        }
    }
}
