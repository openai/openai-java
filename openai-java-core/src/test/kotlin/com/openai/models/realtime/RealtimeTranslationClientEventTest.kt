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

internal class RealtimeTranslationClientEventTest {

    @Test
    fun ofSessionUpdate() {
        val sessionUpdate =
            RealtimeTranslationSessionUpdateEvent.builder()
                .session(
                    RealtimeTranslationSessionUpdateRequest.builder()
                        .audio(
                            RealtimeTranslationSessionUpdateRequest.Audio.builder()
                                .input(
                                    RealtimeTranslationSessionUpdateRequest.Audio.Input.builder()
                                        .noiseReduction(
                                            RealtimeTranslationSessionUpdateRequest.Audio.Input
                                                .NoiseReduction
                                                .builder()
                                                .type(NoiseReductionType.NEAR_FIELD)
                                                .build()
                                        )
                                        .transcription(
                                            RealtimeTranslationSessionUpdateRequest.Audio.Input
                                                .Transcription
                                                .builder()
                                                .model("model")
                                                .build()
                                        )
                                        .build()
                                )
                                .output(
                                    RealtimeTranslationSessionUpdateRequest.Audio.Output.builder()
                                        .language("language")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .eventId("event_id")
                .build()

        val realtimeTranslationClientEvent =
            RealtimeTranslationClientEvent.ofSessionUpdate(sessionUpdate)

        assertThat(realtimeTranslationClientEvent.sessionUpdate()).contains(sessionUpdate)
        assertThat(realtimeTranslationClientEvent.sessionInputAudioBufferAppend()).isEmpty
        assertThat(realtimeTranslationClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionUpdateRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationClientEvent =
            RealtimeTranslationClientEvent.ofSessionUpdate(
                RealtimeTranslationSessionUpdateEvent.builder()
                    .session(
                        RealtimeTranslationSessionUpdateRequest.builder()
                            .audio(
                                RealtimeTranslationSessionUpdateRequest.Audio.builder()
                                    .input(
                                        RealtimeTranslationSessionUpdateRequest.Audio.Input
                                            .builder()
                                            .noiseReduction(
                                                RealtimeTranslationSessionUpdateRequest.Audio.Input
                                                    .NoiseReduction
                                                    .builder()
                                                    .type(NoiseReductionType.NEAR_FIELD)
                                                    .build()
                                            )
                                            .transcription(
                                                RealtimeTranslationSessionUpdateRequest.Audio.Input
                                                    .Transcription
                                                    .builder()
                                                    .model("model")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .output(
                                        RealtimeTranslationSessionUpdateRequest.Audio.Output
                                            .builder()
                                            .language("language")
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .eventId("event_id")
                    .build()
            )

        val roundtrippedRealtimeTranslationClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationClientEvent),
                jacksonTypeRef<RealtimeTranslationClientEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationClientEvent)
            .isEqualTo(realtimeTranslationClientEvent)
    }

    @Test
    fun ofSessionInputAudioBufferAppend() {
        val sessionInputAudioBufferAppend =
            RealtimeTranslationInputAudioBufferAppendEvent.builder()
                .audio("audio")
                .eventId("event_id")
                .build()

        val realtimeTranslationClientEvent =
            RealtimeTranslationClientEvent.ofSessionInputAudioBufferAppend(
                sessionInputAudioBufferAppend
            )

        assertThat(realtimeTranslationClientEvent.sessionUpdate()).isEmpty
        assertThat(realtimeTranslationClientEvent.sessionInputAudioBufferAppend())
            .contains(sessionInputAudioBufferAppend)
        assertThat(realtimeTranslationClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionInputAudioBufferAppendRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationClientEvent =
            RealtimeTranslationClientEvent.ofSessionInputAudioBufferAppend(
                RealtimeTranslationInputAudioBufferAppendEvent.builder()
                    .audio("audio")
                    .eventId("event_id")
                    .build()
            )

        val roundtrippedRealtimeTranslationClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationClientEvent),
                jacksonTypeRef<RealtimeTranslationClientEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationClientEvent)
            .isEqualTo(realtimeTranslationClientEvent)
    }

    @Test
    fun ofSessionClose() {
        val sessionClose =
            RealtimeTranslationSessionCloseEvent.builder().eventId("event_id").build()

        val realtimeTranslationClientEvent =
            RealtimeTranslationClientEvent.ofSessionClose(sessionClose)

        assertThat(realtimeTranslationClientEvent.sessionUpdate()).isEmpty
        assertThat(realtimeTranslationClientEvent.sessionInputAudioBufferAppend()).isEmpty
        assertThat(realtimeTranslationClientEvent.sessionClose()).contains(sessionClose)
    }

    @Test
    fun ofSessionCloseRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationClientEvent =
            RealtimeTranslationClientEvent.ofSessionClose(
                RealtimeTranslationSessionCloseEvent.builder().eventId("event_id").build()
            )

        val roundtrippedRealtimeTranslationClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationClientEvent),
                jacksonTypeRef<RealtimeTranslationClientEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationClientEvent)
            .isEqualTo(realtimeTranslationClientEvent)
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
        val realtimeTranslationClientEvent =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<RealtimeTranslationClientEvent>())

        val e =
            assertThrows<OpenAIInvalidDataException> { realtimeTranslationClientEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
