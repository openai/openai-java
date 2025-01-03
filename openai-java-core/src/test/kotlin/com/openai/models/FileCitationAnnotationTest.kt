// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileCitationAnnotationTest {

    @Test
    fun createFileCitationAnnotation() {
        val fileCitationAnnotation =
            FileCitationAnnotation.builder()
                .endIndex(0L)
                .fileCitation(
                    FileCitationAnnotation.FileCitation.builder().fileId("file_id").build()
                )
                .startIndex(0L)
                .text("text")
                .type(FileCitationAnnotation.Type.FILE_CITATION)
                .build()
        assertThat(fileCitationAnnotation).isNotNull
        assertThat(fileCitationAnnotation.endIndex()).isEqualTo(0L)
        assertThat(fileCitationAnnotation.fileCitation())
            .isEqualTo(FileCitationAnnotation.FileCitation.builder().fileId("file_id").build())
        assertThat(fileCitationAnnotation.startIndex()).isEqualTo(0L)
        assertThat(fileCitationAnnotation.text()).isEqualTo("text")
        assertThat(fileCitationAnnotation.type())
            .isEqualTo(FileCitationAnnotation.Type.FILE_CITATION)
    }
}
