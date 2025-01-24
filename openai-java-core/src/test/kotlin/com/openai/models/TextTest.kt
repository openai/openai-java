// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TextTest {

    @Test
    fun createText() {
        val text =
            Text.builder()
                .addAnnotation(
                    FileCitationAnnotation.builder()
                        .endIndex(0L)
                        .fileCitation(
                            FileCitationAnnotation.FileCitation.builder().fileId("file_id").build()
                        )
                        .startIndex(0L)
                        .text("text")
                        .build()
                )
                .value("value")
                .build()
        assertThat(text).isNotNull
        assertThat(text.annotations())
            .containsExactly(
                Annotation.ofFileCitation(
                    FileCitationAnnotation.builder()
                        .endIndex(0L)
                        .fileCitation(
                            FileCitationAnnotation.FileCitation.builder().fileId("file_id").build()
                        )
                        .startIndex(0L)
                        .text("text")
                        .build()
                )
            )
        assertThat(text.value()).isEqualTo("value")
    }
}
