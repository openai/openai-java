// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.ChatCompletionStreamOptions
import com.openai.models.CompletionCreateParams
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
        val completionService = client.completions()
        val completion =
            completionService.create(
                CompletionCreateParams.builder()
                    .model(CompletionCreateParams.Model.GPT_3_5_TURBO_INSTRUCT)
                    .prompt(CompletionCreateParams.Prompt.ofString("This is a test."))
                    .bestOf(0L)
                    .echo(true)
                    .frequencyPenalty(-2.0)
                    .logitBias(
                        CompletionCreateParams.LogitBias.builder()
                            .putAdditionalProperty("foo", JsonValue.from(0))
                            .build()
                    )
                    .logprobs(0L)
                    .maxTokens(16L)
                    .n(1L)
                    .presencePenalty(-2.0)
                    .seed(-9007199254740991L)
                    .stop(CompletionCreateParams.Stop.ofString("\n"))
                    .streamOptions(ChatCompletionStreamOptions.builder().includeUsage(true).build())
                    .suffix("test.")
                    .temperature(1.0)
                    .topP(1.0)
                    .user("user-1234")
                    .build()
            )
        println(completion)
        completion.validate()
    }

    @Test
    fun callCreateStreaming() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val completionService = client.completions()

        val completionStream =
            completionService.createStreaming(
                CompletionCreateParams.builder()
                    .model(CompletionCreateParams.Model.GPT_3_5_TURBO_INSTRUCT)
                    .prompt(CompletionCreateParams.Prompt.ofString("This is a test."))
                    .bestOf(0L)
                    .echo(true)
                    .frequencyPenalty(-2.0)
                    .logitBias(
                        CompletionCreateParams.LogitBias.builder()
                            .putAdditionalProperty("foo", JsonValue.from(0))
                            .build()
                    )
                    .logprobs(0L)
                    .maxTokens(16L)
                    .n(1L)
                    .presencePenalty(-2.0)
                    .seed(-9007199254740991L)
                    .stop(CompletionCreateParams.Stop.ofString("\n"))
                    .streamOptions(ChatCompletionStreamOptions.builder().includeUsage(true).build())
                    .suffix("test.")
                    .temperature(1.0)
                    .topP(1.0)
                    .user("user-1234")
                    .build()
            )

        completionStream.use {
            completionStream.stream().forEach {
                println(it)
                it.validate()
            }
        }
    }
}
