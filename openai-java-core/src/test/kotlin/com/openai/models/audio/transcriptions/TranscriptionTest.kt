// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionTest {

    @Test
    fun create() {
        val transcription =
            Transcription.builder()
                .text("text")
                .addLogprob(
                    Transcription.Logprob.builder().token("token").addByte(0.0).logprob(0.0).build()
                )
                .build()

        assertThat(transcription.text()).isEqualTo("text")
        assertThat(transcription.logprobs().getOrNull())
            .containsExactly(
                Transcription.Logprob.builder().token("token").addByte(0.0).logprob(0.0).build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val transcription =
            Transcription.builder()
                .text("text")
                .addLogprob(
                    Transcription.Logprob.builder().token("token").addByte(0.0).logprob(0.0).build()
                )
                .build()

        val roundtrippedTranscription =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcription),
                jacksonTypeRef<Transcription>(),
            )

        assertThat(roundtrippedTranscription).isEqualTo(transcription)
    }
}
