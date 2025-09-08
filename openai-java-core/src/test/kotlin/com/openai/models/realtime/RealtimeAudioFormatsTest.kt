// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class RealtimeAudioFormatsTest {

    @Test
    fun ofAudioPcm() {
        val audioPcm =
            RealtimeAudioFormats.AudioPcm.builder()
                .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                .build()

        val realtimeAudioFormats = RealtimeAudioFormats.ofAudioPcm(audioPcm)

        assertThat(realtimeAudioFormats.audioPcm()).contains(audioPcm)
        assertThat(realtimeAudioFormats.audioPcmu()).isEmpty
        assertThat(realtimeAudioFormats.audioPcma()).isEmpty
    }

    @Test
    fun ofAudioPcmRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeAudioFormats =
            RealtimeAudioFormats.ofAudioPcm(
                RealtimeAudioFormats.AudioPcm.builder()
                    .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                    .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                    .build()
            )

        val roundtrippedRealtimeAudioFormats =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeAudioFormats),
                jacksonTypeRef<RealtimeAudioFormats>(),
            )

        assertThat(roundtrippedRealtimeAudioFormats).isEqualTo(realtimeAudioFormats)
    }

    @Test
    fun ofAudioPcmu() {
        val audioPcmu =
            RealtimeAudioFormats.AudioPcmu.builder()
                .type(RealtimeAudioFormats.AudioPcmu.Type.AUDIO_PCMU)
                .build()

        val realtimeAudioFormats = RealtimeAudioFormats.ofAudioPcmu(audioPcmu)

        assertThat(realtimeAudioFormats.audioPcm()).isEmpty
        assertThat(realtimeAudioFormats.audioPcmu()).contains(audioPcmu)
        assertThat(realtimeAudioFormats.audioPcma()).isEmpty
    }

    @Test
    fun ofAudioPcmuRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeAudioFormats =
            RealtimeAudioFormats.ofAudioPcmu(
                RealtimeAudioFormats.AudioPcmu.builder()
                    .type(RealtimeAudioFormats.AudioPcmu.Type.AUDIO_PCMU)
                    .build()
            )

        val roundtrippedRealtimeAudioFormats =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeAudioFormats),
                jacksonTypeRef<RealtimeAudioFormats>(),
            )

        assertThat(roundtrippedRealtimeAudioFormats).isEqualTo(realtimeAudioFormats)
    }

    @Test
    fun ofAudioPcma() {
        val audioPcma =
            RealtimeAudioFormats.AudioPcma.builder()
                .type(RealtimeAudioFormats.AudioPcma.Type.AUDIO_PCMA)
                .build()

        val realtimeAudioFormats = RealtimeAudioFormats.ofAudioPcma(audioPcma)

        assertThat(realtimeAudioFormats.audioPcm()).isEmpty
        assertThat(realtimeAudioFormats.audioPcmu()).isEmpty
        assertThat(realtimeAudioFormats.audioPcma()).contains(audioPcma)
    }

    @Test
    fun ofAudioPcmaRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeAudioFormats =
            RealtimeAudioFormats.ofAudioPcma(
                RealtimeAudioFormats.AudioPcma.builder()
                    .type(RealtimeAudioFormats.AudioPcma.Type.AUDIO_PCMA)
                    .build()
            )

        val roundtrippedRealtimeAudioFormats =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeAudioFormats),
                jacksonTypeRef<RealtimeAudioFormats>(),
            )

        assertThat(roundtrippedRealtimeAudioFormats).isEqualTo(realtimeAudioFormats)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val realtimeAudioFormats =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<RealtimeAudioFormats>())

        val e = assertThrows<OpenAIInvalidDataException> { realtimeAudioFormats.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
