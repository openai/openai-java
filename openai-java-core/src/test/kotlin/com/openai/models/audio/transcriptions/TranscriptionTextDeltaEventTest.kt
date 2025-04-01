// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
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
                        .addByte(JsonValue.from(mapOf<String, Any>()))
                        .logprob(0.0)
                        .build()
                )
                .build()

        assertThat(transcriptionTextDeltaEvent.delta()).isEqualTo("delta")
        assertThat(transcriptionTextDeltaEvent.logprobs().getOrNull())
            .containsExactly(
                TranscriptionTextDeltaEvent.Logprob.builder()
                    .token("token")
                    .addByte(JsonValue.from(mapOf<String, Any>()))
                    .logprob(0.0)
                    .build()
            )
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
                        .addByte(JsonValue.from(mapOf<String, Any>()))
                        .logprob(0.0)
                        .build()
                )
                .build()

        val roundtrippedTranscriptionTextDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionTextDeltaEvent),
                jacksonTypeRef<TranscriptionTextDeltaEvent>(),
            )

        assertThat(roundtrippedTranscriptionTextDeltaEvent).isEqualTo(transcriptionTextDeltaEvent)
    }
}
