// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseTextDoneEventTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(responseTextDoneEvent.contentIndex()).contains(0L)
        assertThat(responseTextDoneEvent.itemId()).contains("item_id")
        assertThat(responseTextDoneEvent.logprobs().getOrNull())
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
        assertThat(responseTextDoneEvent.outputIndex()).contains(0L)
        assertThat(responseTextDoneEvent.sequenceNumber()).contains(0L)
        assertThat(responseTextDoneEvent.text()).contains("text")

        val jsonMapper = jsonMapper()

        val roundtrippedResponseTextDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseTextDoneEvent),
                jacksonTypeRef<ResponseTextDoneEvent>(),
            )

        assertThat(roundtrippedResponseTextDoneEvent).isEqualTo(responseTextDoneEvent)
    }
}
