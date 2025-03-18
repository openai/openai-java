// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileCitationAnnotationTest {

    @Test
    fun create() {
        val fileCitationAnnotation =
            FileCitationAnnotation.builder()
                .endIndex(0L)
                .fileCitation(
                    FileCitationAnnotation.FileCitation.builder().fileId("file_id").build()
                )
                .startIndex(0L)
                .text("text")
                .build()

        assertThat(fileCitationAnnotation.endIndex()).isEqualTo(0L)
        assertThat(fileCitationAnnotation.fileCitation())
            .isEqualTo(FileCitationAnnotation.FileCitation.builder().fileId("file_id").build())
        assertThat(fileCitationAnnotation.startIndex()).isEqualTo(0L)
        assertThat(fileCitationAnnotation.text()).isEqualTo("text")
    }
}
