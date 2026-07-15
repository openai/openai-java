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

internal class RealtimeTranslationServerEventTest {

    @Test
    fun ofError() {
        val error =
            RealtimeErrorEvent.builder()
                .error(
                    RealtimeError.builder()
                        .message("message")
                        .type("type")
                        .code("code")
                        .eventId("event_id")
                        .param("param")
                        .build()
                )
                .eventId("event_id")
                .build()

        val realtimeTranslationServerEvent = RealtimeTranslationServerEvent.ofError(error)

        assertThat(realtimeTranslationServerEvent.error()).contains(error)
        assertThat(realtimeTranslationServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionClosed()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionOutputAudioDelta()).isEmpty
    }

    @Test
    fun ofErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationServerEvent =
            RealtimeTranslationServerEvent.ofError(
                RealtimeErrorEvent.builder()
                    .error(
                        RealtimeError.builder()
                            .message("message")
                            .type("type")
                            .code("code")
                            .eventId("event_id")
                            .param("param")
                            .build()
                    )
                    .eventId("event_id")
                    .build()
            )

        val roundtrippedRealtimeTranslationServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationServerEvent),
                jacksonTypeRef<RealtimeTranslationServerEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationServerEvent)
            .isEqualTo(realtimeTranslationServerEvent)
    }

    @Test
    fun ofSessionCreated() {
        val sessionCreated =
            RealtimeTranslationSessionCreatedEvent.builder()
                .eventId("event_id")
                .session(
                    RealtimeTranslationSession.builder()
                        .id("id")
                        .audio(
                            RealtimeTranslationSession.Audio.builder()
                                .input(
                                    RealtimeTranslationSession.Audio.Input.builder()
                                        .noiseReduction(
                                            RealtimeTranslationSession.Audio.Input.NoiseReduction
                                                .builder()
                                                .type(NoiseReductionType.NEAR_FIELD)
                                                .build()
                                        )
                                        .transcription(
                                            RealtimeTranslationSession.Audio.Input.Transcription
                                                .builder()
                                                .model("model")
                                                .build()
                                        )
                                        .build()
                                )
                                .output(
                                    RealtimeTranslationSession.Audio.Output.builder()
                                        .language("language")
                                        .build()
                                )
                                .build()
                        )
                        .expiresAt(0L)
                        .model("model")
                        .build()
                )
                .build()

        val realtimeTranslationServerEvent =
            RealtimeTranslationServerEvent.ofSessionCreated(sessionCreated)

        assertThat(realtimeTranslationServerEvent.error()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionCreated()).contains(sessionCreated)
        assertThat(realtimeTranslationServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionClosed()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionOutputAudioDelta()).isEmpty
    }

    @Test
    fun ofSessionCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationServerEvent =
            RealtimeTranslationServerEvent.ofSessionCreated(
                RealtimeTranslationSessionCreatedEvent.builder()
                    .eventId("event_id")
                    .session(
                        RealtimeTranslationSession.builder()
                            .id("id")
                            .audio(
                                RealtimeTranslationSession.Audio.builder()
                                    .input(
                                        RealtimeTranslationSession.Audio.Input.builder()
                                            .noiseReduction(
                                                RealtimeTranslationSession.Audio.Input
                                                    .NoiseReduction
                                                    .builder()
                                                    .type(NoiseReductionType.NEAR_FIELD)
                                                    .build()
                                            )
                                            .transcription(
                                                RealtimeTranslationSession.Audio.Input.Transcription
                                                    .builder()
                                                    .model("model")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .output(
                                        RealtimeTranslationSession.Audio.Output.builder()
                                            .language("language")
                                            .build()
                                    )
                                    .build()
                            )
                            .expiresAt(0L)
                            .model("model")
                            .build()
                    )
                    .build()
            )

        val roundtrippedRealtimeTranslationServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationServerEvent),
                jacksonTypeRef<RealtimeTranslationServerEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationServerEvent)
            .isEqualTo(realtimeTranslationServerEvent)
    }

    @Test
    fun ofSessionUpdated() {
        val sessionUpdated =
            RealtimeTranslationSessionUpdatedEvent.builder()
                .eventId("event_id")
                .session(
                    RealtimeTranslationSession.builder()
                        .id("id")
                        .audio(
                            RealtimeTranslationSession.Audio.builder()
                                .input(
                                    RealtimeTranslationSession.Audio.Input.builder()
                                        .noiseReduction(
                                            RealtimeTranslationSession.Audio.Input.NoiseReduction
                                                .builder()
                                                .type(NoiseReductionType.NEAR_FIELD)
                                                .build()
                                        )
                                        .transcription(
                                            RealtimeTranslationSession.Audio.Input.Transcription
                                                .builder()
                                                .model("model")
                                                .build()
                                        )
                                        .build()
                                )
                                .output(
                                    RealtimeTranslationSession.Audio.Output.builder()
                                        .language("language")
                                        .build()
                                )
                                .build()
                        )
                        .expiresAt(0L)
                        .model("model")
                        .build()
                )
                .build()

        val realtimeTranslationServerEvent =
            RealtimeTranslationServerEvent.ofSessionUpdated(sessionUpdated)

        assertThat(realtimeTranslationServerEvent.error()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionUpdated()).contains(sessionUpdated)
        assertThat(realtimeTranslationServerEvent.sessionClosed()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionOutputAudioDelta()).isEmpty
    }

    @Test
    fun ofSessionUpdatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationServerEvent =
            RealtimeTranslationServerEvent.ofSessionUpdated(
                RealtimeTranslationSessionUpdatedEvent.builder()
                    .eventId("event_id")
                    .session(
                        RealtimeTranslationSession.builder()
                            .id("id")
                            .audio(
                                RealtimeTranslationSession.Audio.builder()
                                    .input(
                                        RealtimeTranslationSession.Audio.Input.builder()
                                            .noiseReduction(
                                                RealtimeTranslationSession.Audio.Input
                                                    .NoiseReduction
                                                    .builder()
                                                    .type(NoiseReductionType.NEAR_FIELD)
                                                    .build()
                                            )
                                            .transcription(
                                                RealtimeTranslationSession.Audio.Input.Transcription
                                                    .builder()
                                                    .model("model")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .output(
                                        RealtimeTranslationSession.Audio.Output.builder()
                                            .language("language")
                                            .build()
                                    )
                                    .build()
                            )
                            .expiresAt(0L)
                            .model("model")
                            .build()
                    )
                    .build()
            )

        val roundtrippedRealtimeTranslationServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationServerEvent),
                jacksonTypeRef<RealtimeTranslationServerEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationServerEvent)
            .isEqualTo(realtimeTranslationServerEvent)
    }

    @Test
    fun ofSessionClosed() {
        val sessionClosed =
            RealtimeTranslationSessionClosedEvent.builder().eventId("event_id").build()

        val realtimeTranslationServerEvent =
            RealtimeTranslationServerEvent.ofSessionClosed(sessionClosed)

        assertThat(realtimeTranslationServerEvent.error()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionClosed()).contains(sessionClosed)
        assertThat(realtimeTranslationServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionOutputAudioDelta()).isEmpty
    }

    @Test
    fun ofSessionClosedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationServerEvent =
            RealtimeTranslationServerEvent.ofSessionClosed(
                RealtimeTranslationSessionClosedEvent.builder().eventId("event_id").build()
            )

        val roundtrippedRealtimeTranslationServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationServerEvent),
                jacksonTypeRef<RealtimeTranslationServerEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationServerEvent)
            .isEqualTo(realtimeTranslationServerEvent)
    }

    @Test
    fun ofSessionInputTranscriptDelta() {
        val sessionInputTranscriptDelta =
            RealtimeTranslationInputTranscriptDeltaEvent.builder()
                .delta("delta")
                .eventId("event_id")
                .elapsedMs(0L)
                .build()

        val realtimeTranslationServerEvent =
            RealtimeTranslationServerEvent.ofSessionInputTranscriptDelta(
                sessionInputTranscriptDelta
            )

        assertThat(realtimeTranslationServerEvent.error()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionClosed()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionInputTranscriptDelta())
            .contains(sessionInputTranscriptDelta)
        assertThat(realtimeTranslationServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionOutputAudioDelta()).isEmpty
    }

    @Test
    fun ofSessionInputTranscriptDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationServerEvent =
            RealtimeTranslationServerEvent.ofSessionInputTranscriptDelta(
                RealtimeTranslationInputTranscriptDeltaEvent.builder()
                    .delta("delta")
                    .eventId("event_id")
                    .elapsedMs(0L)
                    .build()
            )

        val roundtrippedRealtimeTranslationServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationServerEvent),
                jacksonTypeRef<RealtimeTranslationServerEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationServerEvent)
            .isEqualTo(realtimeTranslationServerEvent)
    }

    @Test
    fun ofSessionOutputTranscriptDelta() {
        val sessionOutputTranscriptDelta =
            RealtimeTranslationOutputTranscriptDeltaEvent.builder()
                .delta("delta")
                .eventId("event_id")
                .elapsedMs(0L)
                .build()

        val realtimeTranslationServerEvent =
            RealtimeTranslationServerEvent.ofSessionOutputTranscriptDelta(
                sessionOutputTranscriptDelta
            )

        assertThat(realtimeTranslationServerEvent.error()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionClosed()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionOutputTranscriptDelta())
            .contains(sessionOutputTranscriptDelta)
        assertThat(realtimeTranslationServerEvent.sessionOutputAudioDelta()).isEmpty
    }

    @Test
    fun ofSessionOutputTranscriptDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationServerEvent =
            RealtimeTranslationServerEvent.ofSessionOutputTranscriptDelta(
                RealtimeTranslationOutputTranscriptDeltaEvent.builder()
                    .delta("delta")
                    .eventId("event_id")
                    .elapsedMs(0L)
                    .build()
            )

        val roundtrippedRealtimeTranslationServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationServerEvent),
                jacksonTypeRef<RealtimeTranslationServerEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationServerEvent)
            .isEqualTo(realtimeTranslationServerEvent)
    }

    @Test
    fun ofSessionOutputAudioDelta() {
        val sessionOutputAudioDelta =
            RealtimeTranslationOutputAudioDeltaEvent.builder()
                .delta("delta")
                .eventId("event_id")
                .channels(0L)
                .elapsedMs(0L)
                .format(RealtimeTranslationOutputAudioDeltaEvent.Format.PCM16)
                .sampleRate(0L)
                .build()

        val realtimeTranslationServerEvent =
            RealtimeTranslationServerEvent.ofSessionOutputAudioDelta(sessionOutputAudioDelta)

        assertThat(realtimeTranslationServerEvent.error()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionClosed()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(realtimeTranslationServerEvent.sessionOutputAudioDelta())
            .contains(sessionOutputAudioDelta)
    }

    @Test
    fun ofSessionOutputAudioDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTranslationServerEvent =
            RealtimeTranslationServerEvent.ofSessionOutputAudioDelta(
                RealtimeTranslationOutputAudioDeltaEvent.builder()
                    .delta("delta")
                    .eventId("event_id")
                    .channels(0L)
                    .elapsedMs(0L)
                    .format(RealtimeTranslationOutputAudioDeltaEvent.Format.PCM16)
                    .sampleRate(0L)
                    .build()
            )

        val roundtrippedRealtimeTranslationServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTranslationServerEvent),
                jacksonTypeRef<RealtimeTranslationServerEvent>(),
            )

        assertThat(roundtrippedRealtimeTranslationServerEvent)
            .isEqualTo(realtimeTranslationServerEvent)
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
        val realtimeTranslationServerEvent =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<RealtimeTranslationServerEvent>())

        val e =
            assertThrows<OpenAIInvalidDataException> { realtimeTranslationServerEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
