// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TextDeltaTest {

    @Test
    fun createTextDelta() {
        val textDelta =
            TextDelta.builder()
                .annotations(
                    listOf(
                        AnnotationDelta.ofFileCitationDeltaAnnotation(
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
                        )
                    )
                )
                .value("value")
                .build()
        assertThat(textDelta).isNotNull
        assertThat(textDelta.annotations().get())
            .containsExactly(
                AnnotationDelta.ofFileCitationDeltaAnnotation(
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
                )
            )
        assertThat(textDelta.value()).contains("value")
    }
}
