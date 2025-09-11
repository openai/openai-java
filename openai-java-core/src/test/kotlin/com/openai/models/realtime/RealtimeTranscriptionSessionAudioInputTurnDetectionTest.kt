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

internal class RealtimeTranscriptionSessionAudioInputTurnDetectionTest {

    @Test
    fun ofServerVad() {
        val serverVad =
            RealtimeTranscriptionSessionAudioInputTurnDetection.ServerVad.builder()
                .createResponse(true)
                .idleTimeoutMs(5000L)
                .interruptResponse(true)
                .prefixPaddingMs(0L)
                .silenceDurationMs(0L)
                .threshold(0.0)
                .build()

        val realtimeTranscriptionSessionAudioInputTurnDetection =
            RealtimeTranscriptionSessionAudioInputTurnDetection.ofServerVad(serverVad)

        assertThat(realtimeTranscriptionSessionAudioInputTurnDetection.serverVad())
            .contains(serverVad)
        assertThat(realtimeTranscriptionSessionAudioInputTurnDetection.semanticVad()).isEmpty
    }

    @Test
    fun ofServerVadRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranscriptionSessionAudioInputTurnDetection =
            RealtimeTranscriptionSessionAudioInputTurnDetection.ofServerVad(
                RealtimeTranscriptionSessionAudioInputTurnDetection.ServerVad.builder()
                    .createResponse(true)
                    .idleTimeoutMs(5000L)
                    .interruptResponse(true)
                    .prefixPaddingMs(0L)
                    .silenceDurationMs(0L)
                    .threshold(0.0)
                    .build()
            )

        val roundtrippedRealtimeTranscriptionSessionAudioInputTurnDetection =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranscriptionSessionAudioInputTurnDetection),
                jacksonTypeRef<RealtimeTranscriptionSessionAudioInputTurnDetection>(),
            )

        assertThat(roundtrippedRealtimeTranscriptionSessionAudioInputTurnDetection)
            .isEqualTo(realtimeTranscriptionSessionAudioInputTurnDetection)
    }

    @Test
    fun ofSemanticVad() {
        val semanticVad =
            RealtimeTranscriptionSessionAudioInputTurnDetection.SemanticVad.builder()
                .createResponse(true)
                .eagerness(
                    RealtimeTranscriptionSessionAudioInputTurnDetection.SemanticVad.Eagerness.LOW
                )
                .interruptResponse(true)
                .build()

        val realtimeTranscriptionSessionAudioInputTurnDetection =
            RealtimeTranscriptionSessionAudioInputTurnDetection.ofSemanticVad(semanticVad)

        assertThat(realtimeTranscriptionSessionAudioInputTurnDetection.serverVad()).isEmpty
        assertThat(realtimeTranscriptionSessionAudioInputTurnDetection.semanticVad())
            .contains(semanticVad)
    }

    @Test
    fun ofSemanticVadRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranscriptionSessionAudioInputTurnDetection =
            RealtimeTranscriptionSessionAudioInputTurnDetection.ofSemanticVad(
                RealtimeTranscriptionSessionAudioInputTurnDetection.SemanticVad.builder()
                    .createResponse(true)
                    .eagerness(
                        RealtimeTranscriptionSessionAudioInputTurnDetection.SemanticVad.Eagerness
                            .LOW
                    )
                    .interruptResponse(true)
                    .build()
            )

        val roundtrippedRealtimeTranscriptionSessionAudioInputTurnDetection =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranscriptionSessionAudioInputTurnDetection),
                jacksonTypeRef<RealtimeTranscriptionSessionAudioInputTurnDetection>(),
            )

        assertThat(roundtrippedRealtimeTranscriptionSessionAudioInputTurnDetection)
            .isEqualTo(realtimeTranscriptionSessionAudioInputTurnDetection)
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
        val realtimeTranscriptionSessionAudioInputTurnDetection =
            jsonMapper()
                .convertValue(
                    testCase.value,
                    jacksonTypeRef<RealtimeTranscriptionSessionAudioInputTurnDetection>(),
                )

        val e =
            assertThrows<OpenAIInvalidDataException> {
                realtimeTranscriptionSessionAudioInputTurnDetection.validate()
            }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
