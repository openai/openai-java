// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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
}
