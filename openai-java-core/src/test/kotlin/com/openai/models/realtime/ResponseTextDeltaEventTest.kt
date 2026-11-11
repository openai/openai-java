// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseTextDeltaEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseTextDeltaEvent =
            ResponseTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        assertThat(responseTextDeltaEvent.contentIndex()).contains(0L)
        assertThat(responseTextDeltaEvent.delta()).contains("delta")
        assertThat(responseTextDeltaEvent.eventId()).contains("event_id")
        assertThat(responseTextDeltaEvent.itemId()).contains("item_id")
        assertThat(responseTextDeltaEvent.outputIndex()).contains(0L)
        assertThat(responseTextDeltaEvent.responseId()).contains("response_id")

        val jsonMapper = jsonMapper()

        val roundtrippedResponseTextDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseTextDeltaEvent),
                jacksonTypeRef<ResponseTextDeltaEvent>(),
            )

        assertThat(roundtrippedResponseTextDeltaEvent).isEqualTo(responseTextDeltaEvent)
    }
}
