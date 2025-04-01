// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileCitationDeltaAnnotationTest {

    @Test
    fun create() {
        val fileCitationDeltaAnnotation =
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

        assertThat(fileCitationDeltaAnnotation.index()).isEqualTo(0L)
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileCitationDeltaAnnotation =
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

        val roundtrippedFileCitationDeltaAnnotation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileCitationDeltaAnnotation),
                jacksonTypeRef<FileCitationDeltaAnnotation>(),
            )

        assertThat(roundtrippedFileCitationDeltaAnnotation).isEqualTo(fileCitationDeltaAnnotation)
    }
}
