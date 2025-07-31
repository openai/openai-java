// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AnnotationDeltaTest {

    @Test
    fun ofFileCitation() {
        val fileCitation =
            FileCitationDeltaAnnotation.builder()
                .index(0L)
                .endIndex(0L)
                .fileCitation(
                    FileCitationDeltaAnnotation.FileCitation.builder()
                        .fileId("file_id")
                        .quote("quote")
                        .build()
                )
                .startIndex(0L)
                .text("text")
                .build()

        val annotationDelta = AnnotationDelta.ofFileCitation(fileCitation)

        assertThat(annotationDelta.fileCitation()).contains(fileCitation)
        assertThat(annotationDelta.filePath()).isEmpty
    }

    @Test
    fun ofFileCitationRoundtrip() {
        val jsonMapper = jsonMapper()
        val annotationDelta =
            AnnotationDelta.ofFileCitation(
                FileCitationDeltaAnnotation.builder()
                    .index(0L)
                    .endIndex(0L)
                    .fileCitation(
                        FileCitationDeltaAnnotation.FileCitation.builder()
                            .fileId("file_id")
                            .quote("quote")
                            .build()
                    )
                    .startIndex(0L)
                    .text("text")
                    .build()
            )

        val roundtrippedAnnotationDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(annotationDelta),
                jacksonTypeRef<AnnotationDelta>(),
            )

        assertThat(roundtrippedAnnotationDelta).isEqualTo(annotationDelta)
    }

    @Test
    fun ofFilePath() {
        val filePath =
            FilePathDeltaAnnotation.builder()
                .index(0L)
                .endIndex(0L)
                .filePath(FilePathDeltaAnnotation.FilePath.builder().fileId("file_id").build())
                .startIndex(0L)
                .text("text")
                .build()

        val annotationDelta = AnnotationDelta.ofFilePath(filePath)

        assertThat(annotationDelta.fileCitation()).isEmpty
        assertThat(annotationDelta.filePath()).contains(filePath)
    }

    @Test
    fun ofFilePathRoundtrip() {
        val jsonMapper = jsonMapper()
        val annotationDelta =
            AnnotationDelta.ofFilePath(
                FilePathDeltaAnnotation.builder()
                    .index(0L)
                    .endIndex(0L)
                    .filePath(FilePathDeltaAnnotation.FilePath.builder().fileId("file_id").build())
                    .startIndex(0L)
                    .text("text")
                    .build()
            )

        val roundtrippedAnnotationDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(annotationDelta),
                jacksonTypeRef<AnnotationDelta>(),
            )

        assertThat(roundtrippedAnnotationDelta).isEqualTo(annotationDelta)
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
        val annotationDelta =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AnnotationDelta>())

        val e = assertThrows<OpenAIInvalidDataException> { annotationDelta.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
