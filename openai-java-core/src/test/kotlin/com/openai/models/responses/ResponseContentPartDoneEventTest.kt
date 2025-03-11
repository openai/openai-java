// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseContentPartDoneEventTest {

    @Test
    fun createResponseContentPartDoneEvent() {
        val responseContentPartDoneEvent =
            ResponseContentPartDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .part(
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
                .build()
        assertThat(responseContentPartDoneEvent).isNotNull
        assertThat(responseContentPartDoneEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseContentPartDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseContentPartDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseContentPartDoneEvent.part())
            .isEqualTo(
                ResponseContentPartDoneEvent.Part.ofOutputText(
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
            )
    }
}
