// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.translations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.audio.transcriptions.TranscriptionSegment
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class TranslationCreateResponseTest {

    @Test
    fun ofTranslation() {
        val translation = Translation.builder().text("text").build()

        val translationCreateResponse = TranslationCreateResponse.ofTranslation(translation)

        assertThat(translationCreateResponse.translation()).contains(translation)
        assertThat(translationCreateResponse.verbose()).isEmpty
    }

    @Test
    fun ofTranslationRoundtrip() {
        val jsonMapper = jsonMapper()
        val translationCreateResponse =
            TranslationCreateResponse.ofTranslation(Translation.builder().text("text").build())

        val roundtrippedTranslationCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(translationCreateResponse),
                jacksonTypeRef<TranslationCreateResponse>(),
            )

        assertThat(roundtrippedTranslationCreateResponse).isEqualTo(translationCreateResponse)
    }

    @Test
    fun ofVerbose() {
        val verbose =
            TranslationVerbose.builder()
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
                .build()

        val translationCreateResponse = TranslationCreateResponse.ofVerbose(verbose)

        assertThat(translationCreateResponse.translation()).isEmpty
        assertThat(translationCreateResponse.verbose()).contains(verbose)
    }

    @Test
    fun ofVerboseRoundtrip() {
        val jsonMapper = jsonMapper()
        val translationCreateResponse =
            TranslationCreateResponse.ofVerbose(
                TranslationVerbose.builder()
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
                    .build()
            )

        val roundtrippedTranslationCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(translationCreateResponse),
                jacksonTypeRef<TranslationCreateResponse>(),
            )

        assertThat(roundtrippedTranslationCreateResponse).isEqualTo(translationCreateResponse)
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
        val translationCreateResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<TranslationCreateResponse>())

        val e = assertThrows<OpenAIInvalidDataException> { translationCreateResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
