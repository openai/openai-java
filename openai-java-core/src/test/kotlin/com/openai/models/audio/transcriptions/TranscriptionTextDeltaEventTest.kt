// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionTextDeltaEventTest {

    @Test
    fun create() {
        val transcriptionTextDeltaEvent =
            TranscriptionTextDeltaEvent.builder()
                .delta("delta")
                .addLogprob(
                    TranscriptionTextDeltaEvent.Logprob.builder()
                        .token("token")
                        .addByte(0L)
                        .logprob(0.0)
                        .build()
                )
                .segmentId("segment_id")
                .build()

        assertThat(transcriptionTextDeltaEvent.delta()).isEqualTo("delta")
        assertThat(transcriptionTextDeltaEvent.logprobs().getOrNull())
            .containsExactly(
                TranscriptionTextDeltaEvent.Logprob.builder()
                    .token("token")
                    .addByte(0L)
                    .logprob(0.0)
                    .build()
            )
        assertThat(transcriptionTextDeltaEvent.segmentId()).contains("segment_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val transcriptionTextDeltaEvent =
            TranscriptionTextDeltaEvent.builder()
                .delta("delta")
                .addLogprob(
                    TranscriptionTextDeltaEvent.Logprob.builder()
                        .token("token")
                        .addByte(0L)
                        .logprob(0.0)
                        .build()
                )
                .segmentId("segment_id")
                .build()

        val roundtrippedTranscriptionTextDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionTextDeltaEvent),
                jacksonTypeRef<TranscriptionTextDeltaEvent>(),
            )

        assertThat(roundtrippedTranscriptionTextDeltaEvent).isEqualTo(transcriptionTextDeltaEvent)
    }
}
