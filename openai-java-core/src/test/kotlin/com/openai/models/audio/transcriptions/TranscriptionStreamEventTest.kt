// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class TranscriptionStreamEventTest {

    @Test
    fun ofTranscriptTextSegment() {
        val transcriptTextSegment =
            TranscriptionTextSegmentEvent.builder()
                .id("id")
                .end(0.0f)
                .speaker("speaker")
                .start(0.0f)
                .text("text")
                .build()

        val transcriptionStreamEvent =
            TranscriptionStreamEvent.ofTranscriptTextSegment(transcriptTextSegment)

        assertThat(transcriptionStreamEvent.transcriptTextSegment()).contains(transcriptTextSegment)
        assertThat(transcriptionStreamEvent.transcriptTextDelta()).isEmpty
        assertThat(transcriptionStreamEvent.transcriptTextDone()).isEmpty
    }

    @Test
    fun ofTranscriptTextSegmentRoundtrip() {
        val jsonMapper = jsonMapper()
        val transcriptionStreamEvent =
            TranscriptionStreamEvent.ofTranscriptTextSegment(
                TranscriptionTextSegmentEvent.builder()
                    .id("id")
                    .end(0.0f)
                    .speaker("speaker")
                    .start(0.0f)
                    .text("text")
                    .build()
            )

        val roundtrippedTranscriptionStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionStreamEvent),
                jacksonTypeRef<TranscriptionStreamEvent>(),
            )

        assertThat(roundtrippedTranscriptionStreamEvent).isEqualTo(transcriptionStreamEvent)
    }

    @Test
    fun ofTranscriptTextDelta() {
        val transcriptTextDelta =
            TranscriptionTextDeltaEvent.builder()
                .delta("delta")
                .addLogprob(
                    TranscriptionTextDeltaEvent.Logprob.builder()
                        .token("token")
                        .addByte(0L)
                        .logprob(0.0)
                        .build()
                )
                .segmentId("segment_id")
                .build()

        val transcriptionStreamEvent =
            TranscriptionStreamEvent.ofTranscriptTextDelta(transcriptTextDelta)

        assertThat(transcriptionStreamEvent.transcriptTextSegment()).isEmpty
        assertThat(transcriptionStreamEvent.transcriptTextDelta()).contains(transcriptTextDelta)
        assertThat(transcriptionStreamEvent.transcriptTextDone()).isEmpty
    }

    @Test
    fun ofTranscriptTextDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val transcriptionStreamEvent =
            TranscriptionStreamEvent.ofTranscriptTextDelta(
                TranscriptionTextDeltaEvent.builder()
                    .delta("delta")
                    .addLogprob(
                        TranscriptionTextDeltaEvent.Logprob.builder()
                            .token("token")
                            .addByte(0L)
                            .logprob(0.0)
                            .build()
                    )
                    .segmentId("segment_id")
                    .build()
            )

        val roundtrippedTranscriptionStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionStreamEvent),
                jacksonTypeRef<TranscriptionStreamEvent>(),
            )

        assertThat(roundtrippedTranscriptionStreamEvent).isEqualTo(transcriptionStreamEvent)
    }

    @Test
    fun ofTranscriptTextDone() {
        val transcriptTextDone =
            TranscriptionTextDoneEvent.builder()
                .text("text")
                .addLogprob(
                    TranscriptionTextDoneEvent.Logprob.builder()
                        .token("token")
                        .addByte(0L)
                        .logprob(0.0)
                        .build()
                )
                .usage(
                    TranscriptionTextDoneEvent.Usage.builder()
                        .inputTokens(0L)
                        .outputTokens(0L)
                        .totalTokens(0L)
                        .inputTokenDetails(
                            TranscriptionTextDoneEvent.Usage.InputTokenDetails.builder()
                                .audioTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .build()
                )
                .build()

        val transcriptionStreamEvent =
            TranscriptionStreamEvent.ofTranscriptTextDone(transcriptTextDone)

        assertThat(transcriptionStreamEvent.transcriptTextSegment()).isEmpty
        assertThat(transcriptionStreamEvent.transcriptTextDelta()).isEmpty
        assertThat(transcriptionStreamEvent.transcriptTextDone()).contains(transcriptTextDone)
    }

    @Test
    fun ofTranscriptTextDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val transcriptionStreamEvent =
            TranscriptionStreamEvent.ofTranscriptTextDone(
                TranscriptionTextDoneEvent.builder()
                    .text("text")
                    .addLogprob(
                        TranscriptionTextDoneEvent.Logprob.builder()
                            .token("token")
                            .addByte(0L)
                            .logprob(0.0)
                            .build()
                    )
                    .usage(
                        TranscriptionTextDoneEvent.Usage.builder()
                            .inputTokens(0L)
                            .outputTokens(0L)
                            .totalTokens(0L)
                            .inputTokenDetails(
                                TranscriptionTextDoneEvent.Usage.InputTokenDetails.builder()
                                    .audioTokens(0L)
                                    .textTokens(0L)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedTranscriptionStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionStreamEvent),
                jacksonTypeRef<TranscriptionStreamEvent>(),
            )

        assertThat(roundtrippedTranscriptionStreamEvent).isEqualTo(transcriptionStreamEvent)
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
        val transcriptionStreamEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<TranscriptionStreamEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { transcriptionStreamEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
