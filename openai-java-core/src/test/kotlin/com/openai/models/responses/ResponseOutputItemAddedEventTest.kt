// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseOutputItemAddedEventTest {

    @Test
    fun create() {
        val responseOutputItemAddedEvent =
            ResponseOutputItemAddedEvent.builder()
                .item(
                    ResponseOutputMessage.builder()
                        .id("id")
                        .addContent(
                            ResponseOutputText.builder()
                                .addAnnotation(
                                    ResponseOutputText.Annotation.FileCitation.builder()
                                        .fileId("file_id")
                                        .index(0L)
                                        .build()
                                )
                                .text("text")
                                .build()
                        )
                        .status(ResponseOutputMessage.Status.IN_PROGRESS)
                        .build()
                )
                .outputIndex(0L)
                .build()

        assertThat(responseOutputItemAddedEvent.item())
            .isEqualTo(
                ResponseOutputItem.ofMessage(
                    ResponseOutputMessage.builder()
                        .id("id")
                        .addContent(
                            ResponseOutputText.builder()
                                .addAnnotation(
                                    ResponseOutputText.Annotation.FileCitation.builder()
                                        .fileId("file_id")
                                        .index(0L)
                                        .build()
                                )
                                .text("text")
                                .build()
                        )
                        .status(ResponseOutputMessage.Status.IN_PROGRESS)
                        .build()
                )
            )
        assertThat(responseOutputItemAddedEvent.outputIndex()).isEqualTo(0L)
    }
}
