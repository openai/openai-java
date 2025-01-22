// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TextDeltaBlockTest {

    @Test
    fun createTextDeltaBlock() {
        val textDeltaBlock =
            TextDeltaBlock.builder()
                .index(0L)
                .text(
                    TextDelta.builder()
                        .addAnnotation(
                            FileCitationDeltaAnnotation.builder()
                                .index(0L)
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
                        .value("value")
                        .build()
                )
                .build()
        assertThat(textDeltaBlock).isNotNull
        assertThat(textDeltaBlock.index()).isEqualTo(0L)
        assertThat(textDeltaBlock.text())
            .contains(
                TextDelta.builder()
                    .addAnnotation(
                        FileCitationDeltaAnnotation.builder()
                            .index(0L)
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
                    .value("value")
                    .build()
            )
    }
}
