// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.chat

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.*
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
                                .parameters(FunctionParameters.builder().build())
                                .build()
                        )
                    )
                    .logitBias(ChatCompletionCreateParams.LogitBias.builder().build())
                    .logprobs(true)
                    .maxCompletionTokens(0L)
                    .maxTokens(0L)
                    .metadata(ChatCompletionCreateParams.Metadata.builder().build())
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
                                        .parameters(FunctionParameters.builder().build())
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
                                .parameters(FunctionParameters.builder().build())
                                .build()
                        )
                    )
                    .logitBias(ChatCompletionCreateParams.LogitBias.builder().build())
                    .logprobs(true)
                    .maxCompletionTokens(0L)
                    .maxTokens(0L)
                    .metadata(ChatCompletionCreateParams.Metadata.builder().build())
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
                                        .parameters(FunctionParameters.builder().build())
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
