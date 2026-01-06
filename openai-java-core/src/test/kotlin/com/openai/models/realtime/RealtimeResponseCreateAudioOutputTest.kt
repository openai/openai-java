// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeResponseCreateAudioOutputTest {

    @Test
    fun create() {
        val realtimeResponseCreateAudioOutput =
            RealtimeResponseCreateAudioOutput.builder()
                .output(
                    RealtimeResponseCreateAudioOutput.Output.builder()
                        .format(
                            RealtimeAudioFormats.AudioPcm.builder()
                                .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                .build()
                        )
                        .voice(RealtimeResponseCreateAudioOutput.Output.Voice.ASH)
                        .build()
                )
                .build()

        assertThat(realtimeResponseCreateAudioOutput.output())
            .contains(
                RealtimeResponseCreateAudioOutput.Output.builder()
                    .format(
                        RealtimeAudioFormats.AudioPcm.builder()
                            .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                            .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                            .build()
                    )
                    .voice(RealtimeResponseCreateAudioOutput.Output.Voice.ASH)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeResponseCreateAudioOutput =
            RealtimeResponseCreateAudioOutput.builder()
                .output(
                    RealtimeResponseCreateAudioOutput.Output.builder()
                        .format(
                            RealtimeAudioFormats.AudioPcm.builder()
                                .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                .build()
                        )
                        .voice(RealtimeResponseCreateAudioOutput.Output.Voice.ASH)
                        .build()
                )
                .build()

        val roundtrippedRealtimeResponseCreateAudioOutput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeResponseCreateAudioOutput),
                jacksonTypeRef<RealtimeResponseCreateAudioOutput>(),
            )

        assertThat(roundtrippedRealtimeResponseCreateAudioOutput)
            .isEqualTo(realtimeResponseCreateAudioOutput)
    }
}
