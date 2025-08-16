// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.chat

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
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
                    .model(ChatModel.GPT_5)
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
                    .promptCacheKey("prompt-cache-key-1234")
                    .reasoningEffort(ReasoningEffort.MINIMAL)
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
                    .text(
                        ChatCompletionCreateParams.Text.builder()
                            .verbosity(ChatCompletionCreateParams.Text.Verbosity.LOW)
                            .build()
                    )
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
                    .model(ChatModel.GPT_5)
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
                    .promptCacheKey("prompt-cache-key-1234")
                    .reasoningEffort(ReasoningEffort.MINIMAL)
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
                    .text(
                        ChatCompletionCreateParams.Text.builder()
                            .verbosity(ChatCompletionCreateParams.Text.Verbosity.LOW)
                            .build()
                    )
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

        val chatCompletionFuture = chatCompletionServiceAsync.retrieve("completion_id")

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
                        ChatCompletionUpdateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        val chatCompletion = chatCompletionFuture.get()
        chatCompletion.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val chatCompletionServiceAsync = client.chat().completions()

        val pageFuture = chatCompletionServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val chatCompletionServiceAsync = client.chat().completions()

        val chatCompletionDeletedFuture = chatCompletionServiceAsync.delete("completion_id")

        val chatCompletionDeleted = chatCompletionDeletedFuture.get()
        chatCompletionDeleted.validate()
    }
}
