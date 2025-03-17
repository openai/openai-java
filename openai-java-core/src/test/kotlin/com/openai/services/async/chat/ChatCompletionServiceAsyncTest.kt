// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.chat

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.ChatModel
import com.openai.models.FunctionDefinition
import com.openai.models.FunctionParameters
import com.openai.models.Metadata
import com.openai.models.ReasoningEffort
import com.openai.models.ResponseFormatText
import com.openai.models.chat.completions.ChatCompletionAudioParam
import com.openai.models.chat.completions.ChatCompletionCreateParams
import com.openai.models.chat.completions.ChatCompletionDeleteParams
import com.openai.models.chat.completions.ChatCompletionDeveloperMessageParam
import com.openai.models.chat.completions.ChatCompletionPredictionContent
import com.openai.models.chat.completions.ChatCompletionRetrieveParams
import com.openai.models.chat.completions.ChatCompletionStreamOptions
import com.openai.models.chat.completions.ChatCompletionTool
import com.openai.models.chat.completions.ChatCompletionToolChoiceOption
import com.openai.models.chat.completions.ChatCompletionUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ChatCompletionServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val chatCompletionServiceAsync = client.chat().completions()

        val chatCompletionFuture =
            chatCompletionServiceAsync.create(
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
            )

        val chatCompletion = chatCompletionFuture.get()
        chatCompletion.validate()
    }

    @Test
    fun createStreaming() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val chatCompletionServiceAsync = client.chat().completions()

        val chatCompletionStreamResponse =
            chatCompletionServiceAsync.createStreaming(
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
            )

        val onCompleteFuture =
            chatCompletionStreamResponse
                .subscribe { chatCompletion -> chatCompletion.validate() }
                .onCompleteFuture()
        onCompleteFuture.get()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val chatCompletionServiceAsync = client.chat().completions()

        val chatCompletionFuture =
            chatCompletionServiceAsync.retrieve(
                ChatCompletionRetrieveParams.builder().completionId("completion_id").build()
            )

        val chatCompletion = chatCompletionFuture.get()
        chatCompletion.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val chatCompletionServiceAsync = client.chat().completions()

        val chatCompletionFuture =
            chatCompletionServiceAsync.update(
                ChatCompletionUpdateParams.builder()
                    .completionId("completion_id")
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        val chatCompletion = chatCompletionFuture.get()
        chatCompletion.validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val chatCompletionServiceAsync = client.chat().completions()

        val chatCompletionDeletedFuture =
            chatCompletionServiceAsync.delete(
                ChatCompletionDeleteParams.builder().completionId("completion_id").build()
            )

        val chatCompletionDeleted = chatCompletionDeletedFuture.get()
        chatCompletionDeleted.validate()
    }
}
