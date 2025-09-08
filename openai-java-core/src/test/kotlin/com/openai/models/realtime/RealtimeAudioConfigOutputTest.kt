// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeAudioConfigOutputTest {

    @Test
    fun create() {
        val realtimeAudioConfigOutput =
            RealtimeAudioConfigOutput.builder()
                .format(
                    RealtimeAudioFormats.AudioPcm.builder()
                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                        .build()
                )
                .speed(0.25)
                .voice(RealtimeAudioConfigOutput.Voice.ALLOY)
                .build()

        assertThat(realtimeAudioConfigOutput.format())
            .contains(
                RealtimeAudioFormats.ofAudioPcm(
                    RealtimeAudioFormats.AudioPcm.builder()
                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                        .build()
                )
            )
        assertThat(realtimeAudioConfigOutput.speed()).contains(0.25)
        assertThat(realtimeAudioConfigOutput.voice())
            .contains(RealtimeAudioConfigOutput.Voice.ALLOY)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeAudioConfigOutput =
            RealtimeAudioConfigOutput.builder()
                .format(
                    RealtimeAudioFormats.AudioPcm.builder()
                        .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                        .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                        .build()
                )
                .speed(0.25)
                .voice(RealtimeAudioConfigOutput.Voice.ALLOY)
                .build()

        val roundtrippedRealtimeAudioConfigOutput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeAudioConfigOutput),
                jacksonTypeRef<RealtimeAudioConfigOutput>(),
            )

        assertThat(roundtrippedRealtimeAudioConfigOutput).isEqualTo(realtimeAudioConfigOutput)
    }
}
