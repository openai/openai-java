// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.audio.voices

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceTest {

    @Test
    fun create() {
        val voice =
            Voice.builder()
                .id("id")
                .createdAt(0L)
                .name("name")
                .type(Voice.Type.AUDIO_SAMPLE)
                .build()

        assertThat(voice.id()).isEqualTo("id")
        assertThat(voice.createdAt()).isEqualTo(0L)
        assertThat(voice.name()).isEqualTo("name")
        assertThat(voice.type()).isEqualTo(Voice.Type.AUDIO_SAMPLE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voice =
            Voice.builder()
                .id("id")
                .createdAt(0L)
                .name("name")
                .type(Voice.Type.AUDIO_SAMPLE)
                .build()

        val roundtrippedVoice =
            jsonMapper.readValue(jsonMapper.writeValueAsString(voice), jacksonTypeRef<Voice>())

        assertThat(roundtrippedVoice).isEqualTo(voice)
    }
}
