// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FilePathAnnotationTest {

    @Test
    fun createAndRoundtrip() {
        val filePathAnnotation =
            FilePathAnnotation.builder()
                .endIndex(0L)
                .filePath(FilePathAnnotation.FilePath.builder().fileId("file_id").build())
                .startIndex(0L)
                .text("text")
                .build()

        assertThat(filePathAnnotation.endIndex()).isEqualTo(0L)
        assertThat(filePathAnnotation.filePath())
            .isEqualTo(FilePathAnnotation.FilePath.builder().fileId("file_id").build())
        assertThat(filePathAnnotation.startIndex()).isEqualTo(0L)
        assertThat(filePathAnnotation.text()).isEqualTo("text")

        val jsonMapper = jsonMapper()

        val roundtrippedFilePathAnnotation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(filePathAnnotation),
                jacksonTypeRef<FilePathAnnotation>(),
            )

        assertThat(roundtrippedFilePathAnnotation).isEqualTo(filePathAnnotation)
    }
}
