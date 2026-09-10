// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AudioFormatTest {

    @Test
    fun ofAudioPcm() {
        val audioPcm = AudioFormat.AudioPcm.builder().rate(AudioFormat.AudioPcm.Rate._16000).build()

        val audioFormat = AudioFormat.ofAudioPcm(audioPcm)

        assertThat(audioFormat.audioPcm()).contains(audioPcm)
        assertThat(audioFormat.audioPcmu()).isEmpty
        assertThat(audioFormat.audioPcma()).isEmpty
    }

    @Test
    fun ofAudioPcmRoundtrip() {
        val jsonMapper = jsonMapper()
        val audioFormat =
            AudioFormat.ofAudioPcm(
                AudioFormat.AudioPcm.builder().rate(AudioFormat.AudioPcm.Rate._16000).build()
            )

        val roundtrippedAudioFormat =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(audioFormat),
                jacksonTypeRef<AudioFormat>(),
            )

        assertThat(roundtrippedAudioFormat).isEqualTo(audioFormat)
    }

    @Test
    fun ofAudioPcmu() {
        val audioPcmu = AudioFormat.AudioPcmu.builder().rate(8000L).build()

        val audioFormat = AudioFormat.ofAudioPcmu(audioPcmu)

        assertThat(audioFormat.audioPcm()).isEmpty
        assertThat(audioFormat.audioPcmu()).contains(audioPcmu)
        assertThat(audioFormat.audioPcma()).isEmpty
    }

    @Test
    fun ofAudioPcmuRoundtrip() {
        val jsonMapper = jsonMapper()
        val audioFormat =
            AudioFormat.ofAudioPcmu(AudioFormat.AudioPcmu.builder().rate(8000L).build())

        val roundtrippedAudioFormat =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(audioFormat),
                jacksonTypeRef<AudioFormat>(),
            )

        assertThat(roundtrippedAudioFormat).isEqualTo(audioFormat)
    }

    @Test
    fun ofAudioPcma() {
        val audioPcma = AudioFormat.AudioPcma.builder().rate(8000L).build()

        val audioFormat = AudioFormat.ofAudioPcma(audioPcma)

        assertThat(audioFormat.audioPcm()).isEmpty
        assertThat(audioFormat.audioPcmu()).isEmpty
        assertThat(audioFormat.audioPcma()).contains(audioPcma)
    }

    @Test
    fun ofAudioPcmaRoundtrip() {
        val jsonMapper = jsonMapper()
        val audioFormat =
            AudioFormat.ofAudioPcma(AudioFormat.AudioPcma.builder().rate(8000L).build())

        val roundtrippedAudioFormat =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(audioFormat),
                jacksonTypeRef<AudioFormat>(),
            )

        assertThat(roundtrippedAudioFormat).isEqualTo(audioFormat)
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
        val audioFormat = jsonMapper().convertValue(testCase.value, jacksonTypeRef<AudioFormat>())

        val e = assertThrows<OpenAIInvalidDataException> { audioFormat.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
