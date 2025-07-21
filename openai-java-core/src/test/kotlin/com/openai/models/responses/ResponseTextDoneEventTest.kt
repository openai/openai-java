// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseTextDoneEventTest {

    @Test
    fun create() {
        val responseTextDoneEvent =
            ResponseTextDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .addLogprob(
                    ResponseTextDoneEvent.Logprob.builder()
                        .token("token")
                        .logprob(0.0)
                        .addTopLogprob(
                            ResponseTextDoneEvent.Logprob.TopLogprob.builder()
                                .token("token")
                                .logprob(0.0)
                                .build()
                        )
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .text("text")
                .build()

        assertThat(responseTextDoneEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseTextDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseTextDoneEvent.logprobs())
            .containsExactly(
                ResponseTextDoneEvent.Logprob.builder()
                    .token("token")
                    .logprob(0.0)
                    .addTopLogprob(
                        ResponseTextDoneEvent.Logprob.TopLogprob.builder()
                            .token("token")
                            .logprob(0.0)
                            .build()
                    )
                    .build()
            )
        assertThat(responseTextDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseTextDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(responseTextDoneEvent.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseTextDoneEvent =
            ResponseTextDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .addLogprob(
                    ResponseTextDoneEvent.Logprob.builder()
                        .token("token")
                        .logprob(0.0)
                        .addTopLogprob(
                            ResponseTextDoneEvent.Logprob.TopLogprob.builder()
                                .token("token")
                                .logprob(0.0)
                                .build()
                        )
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .text("text")
                .build()

        val roundtrippedResponseTextDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseTextDoneEvent),
                jacksonTypeRef<ResponseTextDoneEvent>(),
            )

        assertThat(roundtrippedResponseTextDoneEvent).isEqualTo(responseTextDoneEvent)
    }
}
