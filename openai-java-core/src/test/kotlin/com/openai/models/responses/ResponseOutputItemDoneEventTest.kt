// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseOutputItemDoneEventTest {

    @Test
    fun create() {
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
                                        .filename("filename")
                                        .index(0L)
                                        .build()
                                )
                                .text("text")
                                .addLogprob(
                                    ResponseOutputText.Logprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .addTopLogprob(
                                            ResponseOutputText.Logprob.TopLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .status(ResponseOutputMessage.Status.IN_PROGRESS)
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

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
                                        .filename("filename")
                                        .index(0L)
                                        .build()
                                )
                                .text("text")
                                .addLogprob(
                                    ResponseOutputText.Logprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .addTopLogprob(
                                            ResponseOutputText.Logprob.TopLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .status(ResponseOutputMessage.Status.IN_PROGRESS)
                        .build()
                )
            )
        assertThat(responseOutputItemDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseOutputItemDoneEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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
                                        .filename("filename")
                                        .index(0L)
                                        .build()
                                )
                                .text("text")
                                .addLogprob(
                                    ResponseOutputText.Logprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .addTopLogprob(
                                            ResponseOutputText.Logprob.TopLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .status(ResponseOutputMessage.Status.IN_PROGRESS)
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseOutputItemDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItemDoneEvent),
                jacksonTypeRef<ResponseOutputItemDoneEvent>(),
            )

        assertThat(roundtrippedResponseOutputItemDoneEvent).isEqualTo(responseOutputItemDoneEvent)
    }
}
