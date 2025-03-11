// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseOutputItemDoneEventTest {

    @Test
    fun createResponseOutputItemDoneEvent() {
        val responseOutputItemDoneEvent =
            ResponseOutputItemDoneEvent.builder()
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
        assertThat(responseOutputItemDoneEvent).isNotNull
        assertThat(responseOutputItemDoneEvent.item())
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
        assertThat(responseOutputItemDoneEvent.outputIndex()).isEqualTo(0L)
    }
}
