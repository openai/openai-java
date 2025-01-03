// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FilePathAnnotationTest {

    @Test
    fun createFilePathAnnotation() {
        val filePathAnnotation =
            FilePathAnnotation.builder()
                .endIndex(0L)
                .filePath(FilePathAnnotation.FilePath.builder().fileId("file_id").build())
                .startIndex(0L)
                .text("text")
                .type(FilePathAnnotation.Type.FILE_PATH)
                .build()
        assertThat(filePathAnnotation).isNotNull
        assertThat(filePathAnnotation.endIndex()).isEqualTo(0L)
        assertThat(filePathAnnotation.filePath())
            .isEqualTo(FilePathAnnotation.FilePath.builder().fileId("file_id").build())
        assertThat(filePathAnnotation.startIndex()).isEqualTo(0L)
        assertThat(filePathAnnotation.text()).isEqualTo("text")
        assertThat(filePathAnnotation.type()).isEqualTo(FilePathAnnotation.Type.FILE_PATH)
    }
}
