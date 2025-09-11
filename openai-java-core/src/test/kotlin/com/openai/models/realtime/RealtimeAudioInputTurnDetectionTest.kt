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

internal class RealtimeAudioInputTurnDetectionTest {

    @Test
    fun ofServerVad() {
        val serverVad =
            RealtimeAudioInputTurnDetection.ServerVad.builder()
                .createResponse(true)
                .idleTimeoutMs(5000L)
                .interruptResponse(true)
                .prefixPaddingMs(0L)
                .silenceDurationMs(0L)
                .threshold(0.0)
                .build()

        val realtimeAudioInputTurnDetection = RealtimeAudioInputTurnDetection.ofServerVad(serverVad)

        assertThat(realtimeAudioInputTurnDetection.serverVad()).contains(serverVad)
        assertThat(realtimeAudioInputTurnDetection.semanticVad()).isEmpty
    }

    @Test
    fun ofServerVadRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeAudioInputTurnDetection =
            RealtimeAudioInputTurnDetection.ofServerVad(
                RealtimeAudioInputTurnDetection.ServerVad.builder()
                    .createResponse(true)
                    .idleTimeoutMs(5000L)
                    .interruptResponse(true)
                    .prefixPaddingMs(0L)
                    .silenceDurationMs(0L)
                    .threshold(0.0)
                    .build()
            )

        val roundtrippedRealtimeAudioInputTurnDetection =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeAudioInputTurnDetection),
                jacksonTypeRef<RealtimeAudioInputTurnDetection>(),
            )

        assertThat(roundtrippedRealtimeAudioInputTurnDetection)
            .isEqualTo(realtimeAudioInputTurnDetection)
    }

    @Test
    fun ofSemanticVad() {
        val semanticVad =
            RealtimeAudioInputTurnDetection.SemanticVad.builder()
                .createResponse(true)
                .eagerness(RealtimeAudioInputTurnDetection.SemanticVad.Eagerness.LOW)
                .interruptResponse(true)
                .build()

        val realtimeAudioInputTurnDetection =
            RealtimeAudioInputTurnDetection.ofSemanticVad(semanticVad)

        assertThat(realtimeAudioInputTurnDetection.serverVad()).isEmpty
        assertThat(realtimeAudioInputTurnDetection.semanticVad()).contains(semanticVad)
    }

    @Test
    fun ofSemanticVadRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeAudioInputTurnDetection =
            RealtimeAudioInputTurnDetection.ofSemanticVad(
                RealtimeAudioInputTurnDetection.SemanticVad.builder()
                    .createResponse(true)
                    .eagerness(RealtimeAudioInputTurnDetection.SemanticVad.Eagerness.LOW)
                    .interruptResponse(true)
                    .build()
            )

        val roundtrippedRealtimeAudioInputTurnDetection =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeAudioInputTurnDetection),
                jacksonTypeRef<RealtimeAudioInputTurnDetection>(),
            )

        assertThat(roundtrippedRealtimeAudioInputTurnDetection)
            .isEqualTo(realtimeAudioInputTurnDetection)
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
        val realtimeAudioInputTurnDetection =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<RealtimeAudioInputTurnDetection>())

        val e =
            assertThrows<OpenAIInvalidDataException> { realtimeAudioInputTurnDetection.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
