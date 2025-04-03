// File generated from our OpenAPI spec by Stainless.

package com.openai.models.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CompletionChoiceTest {

    @Test
    fun create() {
        val completionChoice =
            CompletionChoice.builder()
                .finishReason(CompletionChoice.FinishReason.STOP)
                .index(0L)
                .logprobs(
                    CompletionChoice.Logprobs.builder()
                        .addTextOffset(0L)
                        .addTokenLogprob(0.0)
                        .addToken("string")
                        .addTopLogprob(
                            CompletionChoice.Logprobs.TopLogprob.builder()
                                .putAdditionalProperty("foo", JsonValue.from(0))
                                .build()
                        )
                        .build()
                )
                .text("text")
                .build()

        assertThat(completionChoice.finishReason()).isEqualTo(CompletionChoice.FinishReason.STOP)
        assertThat(completionChoice.index()).isEqualTo(0L)
        assertThat(completionChoice.logprobs())
            .contains(
                CompletionChoice.Logprobs.builder()
                    .addTextOffset(0L)
                    .addTokenLogprob(0.0)
                    .addToken("string")
                    .addTopLogprob(
                        CompletionChoice.Logprobs.TopLogprob.builder()
                            .putAdditionalProperty("foo", JsonValue.from(0))
                            .build()
                    )
                    .build()
            )
        assertThat(completionChoice.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val completionChoice =
            CompletionChoice.builder()
                .finishReason(CompletionChoice.FinishReason.STOP)
                .index(0L)
                .logprobs(
                    CompletionChoice.Logprobs.builder()
                        .addTextOffset(0L)
                        .addTokenLogprob(0.0)
                        .addToken("string")
                        .addTopLogprob(
                            CompletionChoice.Logprobs.TopLogprob.builder()
                                .putAdditionalProperty("foo", JsonValue.from(0))
                                .build()
                        )
                        .build()
                )
                .text("text")
                .build()

        val roundtrippedCompletionChoice =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(completionChoice),
                jacksonTypeRef<CompletionChoice>(),
            )

        assertThat(roundtrippedCompletionChoice).isEqualTo(completionChoice)
    }
}
