// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TextContentBlockTest {

    @Test
    fun createTextContentBlock() {
        val textContentBlock =
            TextContentBlock.builder()
                .text(
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
                )
                .type(TextContentBlock.Type.TEXT)
                .build()
        assertThat(textContentBlock).isNotNull
        assertThat(textContentBlock.text())
            .isEqualTo(
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
            )
        assertThat(textContentBlock.type()).isEqualTo(TextContentBlock.Type.TEXT)
    }
}
