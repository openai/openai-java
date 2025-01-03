// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileCitationDeltaAnnotationTest {

    @Test
    fun createFileCitationDeltaAnnotation() {
        val fileCitationDeltaAnnotation =
            FileCitationDeltaAnnotation.builder()
                .index(0L)
                .type(FileCitationDeltaAnnotation.Type.FILE_CITATION)
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
        assertThat(fileCitationDeltaAnnotation).isNotNull
        assertThat(fileCitationDeltaAnnotation.index()).isEqualTo(0L)
        assertThat(fileCitationDeltaAnnotation.type())
            .isEqualTo(FileCitationDeltaAnnotation.Type.FILE_CITATION)
        assertThat(fileCitationDeltaAnnotation.endIndex()).contains(0L)
        assertThat(fileCitationDeltaAnnotation.fileCitation())
            .contains(
                FileCitationDeltaAnnotation.FileCitation.builder()
                    .fileId("file_id")
                    .quote("quote")
                    .build()
            )
        assertThat(fileCitationDeltaAnnotation.startIndex()).contains(0L)
        assertThat(fileCitationDeltaAnnotation.text()).contains("text")
    }
}
