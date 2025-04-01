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

internal class TranscriptionCreateResponseTest {

    @Test
    fun ofTranscription() {
        val transcription =
            Transcription.builder()
                .text("text")
                .addLogprob(
                    Transcription.Logprob.builder().token("token").addByte(0.0).logprob(0.0).build()
                )
                .build()

        val transcriptionCreateResponse = TranscriptionCreateResponse.ofTranscription(transcription)

        assertThat(transcriptionCreateResponse.transcription()).contains(transcription)
        assertThat(transcriptionCreateResponse.verbose()).isEmpty
    }

    @Test
    fun ofTranscriptionRoundtrip() {
        val jsonMapper = jsonMapper()
        val transcriptionCreateResponse =
            TranscriptionCreateResponse.ofTranscription(
                Transcription.builder()
                    .text("text")
                    .addLogprob(
                        Transcription.Logprob.builder()
                            .token("token")
                            .addByte(0.0)
                            .logprob(0.0)
                            .build()
                    )
                    .build()
            )

        val roundtrippedTranscriptionCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionCreateResponse),
                jacksonTypeRef<TranscriptionCreateResponse>(),
            )

        assertThat(roundtrippedTranscriptionCreateResponse).isEqualTo(transcriptionCreateResponse)
    }

    @Test
    fun ofVerbose() {
        val verbose =
            TranscriptionVerbose.builder()
                .duration(0.0)
                .language("language")
                .text("text")
                .addSegment(
                    TranscriptionSegment.builder()
                        .id(0L)
                        .avgLogprob(0.0)
                        .compressionRatio(0.0)
                        .end(0.0)
                        .noSpeechProb(0.0)
                        .seek(0L)
                        .start(0.0)
                        .temperature(0.0)
                        .text("text")
                        .addToken(0L)
                        .build()
                )
                .addWord(TranscriptionWord.builder().end(0.0).start(0.0).word("word").build())
                .build()

        val transcriptionCreateResponse = TranscriptionCreateResponse.ofVerbose(verbose)

        assertThat(transcriptionCreateResponse.transcription()).isEmpty
        assertThat(transcriptionCreateResponse.verbose()).contains(verbose)
    }

    @Test
    fun ofVerboseRoundtrip() {
        val jsonMapper = jsonMapper()
        val transcriptionCreateResponse =
            TranscriptionCreateResponse.ofVerbose(
                TranscriptionVerbose.builder()
                    .duration(0.0)
                    .language("language")
                    .text("text")
                    .addSegment(
                        TranscriptionSegment.builder()
                            .id(0L)
                            .avgLogprob(0.0)
                            .compressionRatio(0.0)
                            .end(0.0)
                            .noSpeechProb(0.0)
                            .seek(0L)
                            .start(0.0)
                            .temperature(0.0)
                            .text("text")
                            .addToken(0L)
                            .build()
                    )
                    .addWord(TranscriptionWord.builder().end(0.0).start(0.0).word("word").build())
                    .build()
            )

        val roundtrippedTranscriptionCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionCreateResponse),
                jacksonTypeRef<TranscriptionCreateResponse>(),
            )

        assertThat(roundtrippedTranscriptionCreateResponse).isEqualTo(transcriptionCreateResponse)
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
        val transcriptionCreateResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<TranscriptionCreateResponse>())

        val e = assertThrows<OpenAIInvalidDataException> { transcriptionCreateResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
