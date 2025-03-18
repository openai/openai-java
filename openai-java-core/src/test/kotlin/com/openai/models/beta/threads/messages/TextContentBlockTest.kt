// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TextContentBlockTest {

    @Test
    fun create() {
        val textContentBlock =
            TextContentBlock.builder()
                .text(
                    Text.builder()
                        .addAnnotation(
                            FileCitationAnnotation.builder()
                                .endIndex(0L)
                                .fileCitation(
                                    FileCitationAnnotation.FileCitation.builder()
                                        .fileId("file_id")
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

        assertThat(textContentBlock.text())
            .isEqualTo(
                Text.builder()
                    .addAnnotation(
                        FileCitationAnnotation.builder()
                            .endIndex(0L)
                            .fileCitation(
                                FileCitationAnnotation.FileCitation.builder()
                                    .fileId("file_id")
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
