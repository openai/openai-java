// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.openai.core.JsonValue
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
                        .addByte(JsonValue.from(mapOf<String, Any>()))
                        .logprob(0.0)
                        .build()
                )
                .build()

        assertThat(transcriptionTextDoneEvent.text()).isEqualTo("text")
        assertThat(transcriptionTextDoneEvent.logprobs().getOrNull())
            .containsExactly(
                TranscriptionTextDoneEvent.Logprob.builder()
                    .token("token")
                    .addByte(JsonValue.from(mapOf<String, Any>()))
                    .logprob(0.0)
                    .build()
            )
    }
}
