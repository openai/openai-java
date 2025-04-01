// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseTextAnnotationDeltaEventTest {

    @Test
    fun create() {
        val responseTextAnnotationDeltaEvent =
            ResponseTextAnnotationDeltaEvent.builder()
                .annotation(
                    ResponseTextAnnotationDeltaEvent.Annotation.FileCitation.builder()
                        .fileId("file_id")
                        .index(0L)
                        .build()
                )
                .annotationIndex(0L)
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        assertThat(responseTextAnnotationDeltaEvent.annotation())
            .isEqualTo(
                ResponseTextAnnotationDeltaEvent.Annotation.ofFileCitation(
                    ResponseTextAnnotationDeltaEvent.Annotation.FileCitation.builder()
                        .fileId("file_id")
                        .index(0L)
                        .build()
                )
            )
        assertThat(responseTextAnnotationDeltaEvent.annotationIndex()).isEqualTo(0L)
        assertThat(responseTextAnnotationDeltaEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseTextAnnotationDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseTextAnnotationDeltaEvent.outputIndex()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseTextAnnotationDeltaEvent =
            ResponseTextAnnotationDeltaEvent.builder()
                .annotation(
                    ResponseTextAnnotationDeltaEvent.Annotation.FileCitation.builder()
                        .fileId("file_id")
                        .index(0L)
                        .build()
                )
                .annotationIndex(0L)
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        val roundtrippedResponseTextAnnotationDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseTextAnnotationDeltaEvent),
                jacksonTypeRef<ResponseTextAnnotationDeltaEvent>(),
            )

        assertThat(roundtrippedResponseTextAnnotationDeltaEvent)
            .isEqualTo(responseTextAnnotationDeltaEvent)
    }
}
