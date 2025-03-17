// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TextDeltaTest {

    @Test
    fun createTextDelta() {
        val textDelta =
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
        assertThat(textDelta).isNotNull
        assertThat(textDelta.annotations().get())
            .containsExactly(
                AnnotationDelta.ofFileCitation(
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
            )
        assertThat(textDelta.value()).contains("value")
    }
}
