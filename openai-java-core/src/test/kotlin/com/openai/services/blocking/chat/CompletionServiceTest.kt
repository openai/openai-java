// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.chat

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.ChatCompletionAudioParam
import com.openai.models.ChatCompletionCreateParams
import com.openai.models.ChatCompletionDeveloperMessageParam
import com.openai.models.ChatCompletionModality
import com.openai.models.ChatCompletionPredictionContent
import com.openai.models.ChatCompletionReasoningEffort
import com.openai.models.ChatCompletionStreamOptions
import com.openai.models.ChatCompletionTool
import com.openai.models.ChatCompletionToolChoiceOption
import com.openai.models.ChatModel
import com.openai.models.FunctionDefinition
import com.openai.models.FunctionParameters
import com.openai.models.Metadata
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
            )

        chatCompletionStream.use {
            chatCompletionStream.stream().forEach {
                println(it)
                it.validate()
            }
        }
    }
}
