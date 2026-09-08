// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseOutputTextAnnotationAddedEventTest {

    @Test
    fun create() {
        val responseOutputTextAnnotationAddedEvent =
            ResponseOutputTextAnnotationAddedEvent.builder()
                .annotation(
                    ResponseOutputTextAnnotationAddedEvent.Annotation.FileCitation.builder()
                        .fileId("file_id")
                        .filename("filename")
                        .index(0L)
                        .build()
                )
                .annotationIndex(0L)
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseOutputTextAnnotationAddedEvent.annotation())
            .contains(
                ResponseOutputTextAnnotationAddedEvent.Annotation.ofFileCitation(
                    ResponseOutputTextAnnotationAddedEvent.Annotation.FileCitation.builder()
                        .fileId("file_id")
                        .filename("filename")
                        .index(0L)
                        .build()
                )
            )
        assertThat(responseOutputTextAnnotationAddedEvent.annotationIndex()).isEqualTo(0L)
        assertThat(responseOutputTextAnnotationAddedEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseOutputTextAnnotationAddedEvent.itemId()).isEqualTo("item_id")
        assertThat(responseOutputTextAnnotationAddedEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseOutputTextAnnotationAddedEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputTextAnnotationAddedEvent =
            ResponseOutputTextAnnotationAddedEvent.builder()
                .annotation(
                    ResponseOutputTextAnnotationAddedEvent.Annotation.FileCitation.builder()
                        .fileId("file_id")
                        .filename("filename")
                        .index(0L)
                        .build()
                )
                .annotationIndex(0L)
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseOutputTextAnnotationAddedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputTextAnnotationAddedEvent),
                jacksonTypeRef<ResponseOutputTextAnnotationAddedEvent>(),
            )

        assertThat(roundtrippedResponseOutputTextAnnotationAddedEvent)
            .isEqualTo(responseOutputTextAnnotationAddedEvent)
    }
}
