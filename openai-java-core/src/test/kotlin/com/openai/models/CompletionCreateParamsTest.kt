// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CompletionCreateParamsTest {

    @Test
    fun create() {
        CompletionCreateParams.builder()
            .model(CompletionCreateParams.Model.GPT_3_5_TURBO_INSTRUCT)
            .prompt("This is a test.")
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
            .seed(0L)
            .stop("\n")
            .streamOptions(ChatCompletionStreamOptions.builder().includeUsage(true).build())
            .suffix("test.")
            .temperature(1.0)
            .topP(1.0)
            .user("user-1234")
            .build()
    }

    @Test
    fun body() {
        val params =
            CompletionCreateParams.builder()
                .model(CompletionCreateParams.Model.GPT_3_5_TURBO_INSTRUCT)
                .prompt("This is a test.")
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
                .seed(0L)
                .stop("\n")
                .streamOptions(ChatCompletionStreamOptions.builder().includeUsage(true).build())
                .suffix("test.")
                .temperature(1.0)
                .topP(1.0)
                .user("user-1234")
                .build()

        val body = params._body()

        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(CompletionCreateParams.Model.GPT_3_5_TURBO_INSTRUCT)
        assertThat(body.prompt())
            .contains(CompletionCreateParams.Prompt.ofString("This is a test."))
        assertThat(body.bestOf()).contains(0L)
        assertThat(body.echo()).contains(true)
        assertThat(body.frequencyPenalty()).contains(-2.0)
        assertThat(body.logitBias())
            .contains(
                CompletionCreateParams.LogitBias.builder()
                    .putAdditionalProperty("foo", JsonValue.from(0))
                    .build()
            )
        assertThat(body.logprobs()).contains(0L)
        assertThat(body.maxTokens()).contains(16L)
        assertThat(body.n()).contains(1L)
        assertThat(body.presencePenalty()).contains(-2.0)
        assertThat(body.seed()).contains(0L)
        assertThat(body.stop()).contains(CompletionCreateParams.Stop.ofString("\n"))
        assertThat(body.streamOptions())
            .contains(ChatCompletionStreamOptions.builder().includeUsage(true).build())
        assertThat(body.suffix()).contains("test.")
        assertThat(body.temperature()).contains(1.0)
        assertThat(body.topP()).contains(1.0)
        assertThat(body.user()).contains("user-1234")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            CompletionCreateParams.builder()
                .model(CompletionCreateParams.Model.GPT_3_5_TURBO_INSTRUCT)
                .prompt("This is a test.")
                .build()

        val body = params._body()

        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(CompletionCreateParams.Model.GPT_3_5_TURBO_INSTRUCT)
        assertThat(body.prompt())
            .contains(CompletionCreateParams.Prompt.ofString("This is a test."))
    }
}
