// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FilePathDeltaAnnotationTest {

    @Test
    fun create() {
        val filePathDeltaAnnotation =
            FilePathDeltaAnnotation.builder()
                .index(0L)
                .endIndex(0L)
                .filePath(FilePathDeltaAnnotation.FilePath.builder().fileId("file_id").build())
                .startIndex(0L)
                .text("text")
                .build()

        assertThat(filePathDeltaAnnotation.index()).isEqualTo(0L)
        assertThat(filePathDeltaAnnotation.endIndex()).contains(0L)
        assertThat(filePathDeltaAnnotation.filePath())
            .contains(FilePathDeltaAnnotation.FilePath.builder().fileId("file_id").build())
        assertThat(filePathDeltaAnnotation.startIndex()).contains(0L)
        assertThat(filePathDeltaAnnotation.text()).contains("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val filePathDeltaAnnotation =
            FilePathDeltaAnnotation.builder()
                .index(0L)
                .endIndex(0L)
                .filePath(FilePathDeltaAnnotation.FilePath.builder().fileId("file_id").build())
                .startIndex(0L)
                .text("text")
                .build()

        val roundtrippedFilePathDeltaAnnotation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(filePathDeltaAnnotation),
                jacksonTypeRef<FilePathDeltaAnnotation>(),
            )

        assertThat(roundtrippedFilePathDeltaAnnotation).isEqualTo(filePathDeltaAnnotation)
    }
}
