// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TextTest {

    @Test
    fun createText() {
        val text =
            Text.builder()
                .annotations(
                    listOf(
                        Annotation.ofFileCitationAnnotation(
                            FileCitationAnnotation.builder()
                                .endIndex(0L)
                                .fileCitation(
                                    FileCitationAnnotation.FileCitation.builder()
                                        .fileId("file_id")
                                        .build()
                                )
                                .startIndex(0L)
                                .text("text")
                                .type(FileCitationAnnotation.Type.FILE_CITATION)
                                .build()
                        )
                    )
                )
                .value("value")
                .build()
        assertThat(text).isNotNull
        assertThat(text.annotations())
            .containsExactly(
                Annotation.ofFileCitationAnnotation(
                    FileCitationAnnotation.builder()
                        .endIndex(0L)
                        .fileCitation(
                            FileCitationAnnotation.FileCitation.builder().fileId("file_id").build()
                        )
                        .startIndex(0L)
                        .text("text")
                        .type(FileCitationAnnotation.Type.FILE_CITATION)
                        .build()
                )
            )
        assertThat(text.value()).isEqualTo("value")
    }
}
