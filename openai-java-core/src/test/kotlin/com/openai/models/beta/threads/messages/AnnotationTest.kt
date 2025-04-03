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

internal class AnnotationTest {

    @Test
    fun ofFileCitation() {
        val fileCitation =
            FileCitationAnnotation.builder()
                .endIndex(0L)
                .fileCitation(
                    FileCitationAnnotation.FileCitation.builder().fileId("file_id").build()
                )
                .startIndex(0L)
                .text("text")
                .build()

        val annotation = Annotation.ofFileCitation(fileCitation)

        assertThat(annotation.fileCitation()).contains(fileCitation)
        assertThat(annotation.filePath()).isEmpty
    }

    @Test
    fun ofFileCitationRoundtrip() {
        val jsonMapper = jsonMapper()
        val annotation =
            Annotation.ofFileCitation(
                FileCitationAnnotation.builder()
                    .endIndex(0L)
                    .fileCitation(
                        FileCitationAnnotation.FileCitation.builder().fileId("file_id").build()
                    )
                    .startIndex(0L)
                    .text("text")
                    .build()
            )

        val roundtrippedAnnotation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(annotation),
                jacksonTypeRef<Annotation>(),
            )

        assertThat(roundtrippedAnnotation).isEqualTo(annotation)
    }

    @Test
    fun ofFilePath() {
        val filePath =
            FilePathAnnotation.builder()
                .endIndex(0L)
                .filePath(FilePathAnnotation.FilePath.builder().fileId("file_id").build())
                .startIndex(0L)
                .text("text")
                .build()

        val annotation = Annotation.ofFilePath(filePath)

        assertThat(annotation.fileCitation()).isEmpty
        assertThat(annotation.filePath()).contains(filePath)
    }

    @Test
    fun ofFilePathRoundtrip() {
        val jsonMapper = jsonMapper()
        val annotation =
            Annotation.ofFilePath(
                FilePathAnnotation.builder()
                    .endIndex(0L)
                    .filePath(FilePathAnnotation.FilePath.builder().fileId("file_id").build())
                    .startIndex(0L)
                    .text("text")
                    .build()
            )

        val roundtrippedAnnotation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(annotation),
                jacksonTypeRef<Annotation>(),
            )

        assertThat(roundtrippedAnnotation).isEqualTo(annotation)
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
        val annotation = jsonMapper().convertValue(testCase.value, jacksonTypeRef<Annotation>())

        val e = assertThrows<OpenAIInvalidDataException> { annotation.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
