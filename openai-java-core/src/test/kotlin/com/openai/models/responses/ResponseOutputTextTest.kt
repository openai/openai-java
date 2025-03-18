// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseOutputTextTest {

    @Test
    fun create() {
        val responseOutputText =
            ResponseOutputText.builder()
                .addAnnotation(
                    ResponseOutputText.Annotation.FileCitation.builder()
                        .fileId("file_id")
                        .index(0L)
                        .build()
                )
                .text("text")
                .build()

        assertThat(responseOutputText.annotations())
            .containsExactly(
                ResponseOutputText.Annotation.ofFileCitation(
                    ResponseOutputText.Annotation.FileCitation.builder()
                        .fileId("file_id")
                        .index(0L)
                        .build()
                )
            )
        assertThat(responseOutputText.text()).isEqualTo("text")
    }
}
