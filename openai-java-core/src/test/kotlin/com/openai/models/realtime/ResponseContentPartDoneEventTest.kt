// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseContentPartDoneEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseContentPartDoneEvent =
            ResponseContentPartDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(
                    ResponseContentPartDoneEvent.Part.builder()
                        .audio("audio")
                        .text("text")
                        .transcript("transcript")
                        .type(ResponseContentPartDoneEvent.Part.Type.TEXT)
                        .build()
                )
                .responseId("response_id")
                .build()

        assertThat(responseContentPartDoneEvent.contentIndex()).contains(0L)
        assertThat(responseContentPartDoneEvent.eventId()).contains("event_id")
        assertThat(responseContentPartDoneEvent.itemId()).contains("item_id")
        assertThat(responseContentPartDoneEvent.outputIndex()).contains(0L)
        assertThat(responseContentPartDoneEvent.part())
            .contains(
                ResponseContentPartDoneEvent.Part.builder()
                    .audio("audio")
                    .text("text")
                    .transcript("transcript")
                    .type(ResponseContentPartDoneEvent.Part.Type.TEXT)
                    .build()
            )
        assertThat(responseContentPartDoneEvent.responseId()).contains("response_id")

        val jsonMapper = jsonMapper()

        val roundtrippedResponseContentPartDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseContentPartDoneEvent),
                jacksonTypeRef<ResponseContentPartDoneEvent>(),
            )

        assertThat(roundtrippedResponseContentPartDoneEvent).isEqualTo(responseContentPartDoneEvent)
    }
}
