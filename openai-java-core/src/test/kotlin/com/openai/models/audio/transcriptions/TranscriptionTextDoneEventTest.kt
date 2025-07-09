// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionTextDoneEventTest {

    @Test
    fun create() {
        val transcriptionTextDoneEvent =
            TranscriptionTextDoneEvent.builder()
                .text("text")
                .addLogprob(
                    TranscriptionTextDoneEvent.Logprob.builder()
                        .token("token")
                        .addByte(0L)
                        .logprob(0.0)
                        .build()
                )
                .usage(
                    TranscriptionTextDoneEvent.Usage.builder()
                        .inputTokens(0L)
                        .outputTokens(0L)
                        .totalTokens(0L)
                        .inputTokenDetails(
                            TranscriptionTextDoneEvent.Usage.InputTokenDetails.builder()
                                .audioTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(transcriptionTextDoneEvent.text()).isEqualTo("text")
        assertThat(transcriptionTextDoneEvent.logprobs().getOrNull())
            .containsExactly(
                TranscriptionTextDoneEvent.Logprob.builder()
                    .token("token")
                    .addByte(0L)
                    .logprob(0.0)
                    .build()
            )
        assertThat(transcriptionTextDoneEvent.usage())
            .contains(
                TranscriptionTextDoneEvent.Usage.builder()
                    .inputTokens(0L)
                    .outputTokens(0L)
                    .totalTokens(0L)
                    .inputTokenDetails(
                        TranscriptionTextDoneEvent.Usage.InputTokenDetails.builder()
                            .audioTokens(0L)
                            .textTokens(0L)
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val transcriptionTextDoneEvent =
            TranscriptionTextDoneEvent.builder()
                .text("text")
                .addLogprob(
                    TranscriptionTextDoneEvent.Logprob.builder()
                        .token("token")
                        .addByte(0L)
                        .logprob(0.0)
                        .build()
                )
                .usage(
                    TranscriptionTextDoneEvent.Usage.builder()
                        .inputTokens(0L)
                        .outputTokens(0L)
                        .totalTokens(0L)
                        .inputTokenDetails(
                            TranscriptionTextDoneEvent.Usage.InputTokenDetails.builder()
                                .audioTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedTranscriptionTextDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionTextDoneEvent),
                jacksonTypeRef<TranscriptionTextDoneEvent>(),
            )

        assertThat(roundtrippedTranscriptionTextDoneEvent).isEqualTo(transcriptionTextDoneEvent)
    }
}
