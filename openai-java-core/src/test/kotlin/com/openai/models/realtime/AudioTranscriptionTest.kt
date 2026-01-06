// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AudioTranscriptionTest {

    @Test
    fun create() {
        val audioTranscription =
            AudioTranscription.builder()
                .language("language")
                .model(AudioTranscription.Model.of("string"))
                .prompt("prompt")
                .build()

        assertThat(audioTranscription.language()).contains("language")
        assertThat(audioTranscription.model()).contains(AudioTranscription.Model.of("string"))
        assertThat(audioTranscription.prompt()).contains("prompt")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val audioTranscription =
            AudioTranscription.builder()
                .language("language")
                .model(AudioTranscription.Model.of("string"))
                .prompt("prompt")
                .build()

        val roundtrippedAudioTranscription =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(audioTranscription),
                jacksonTypeRef<AudioTranscription>(),
            )

        assertThat(roundtrippedAudioTranscription).isEqualTo(audioTranscription)
    }
}
