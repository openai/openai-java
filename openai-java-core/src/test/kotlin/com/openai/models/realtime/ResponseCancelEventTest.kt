// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCancelEventTest {

    @Test
    fun create() {
        val responseCancelEvent =
            ResponseCancelEvent.builder().eventId("event_id").responseId("response_id").build()

        assertThat(responseCancelEvent.eventId()).contains("event_id")
        assertThat(responseCancelEvent.responseId()).contains("response_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCancelEvent =
            ResponseCancelEvent.builder().eventId("event_id").responseId("response_id").build()

        val roundtrippedResponseCancelEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCancelEvent),
                jacksonTypeRef<ResponseCancelEvent>(),
            )

        assertThat(roundtrippedResponseCancelEvent).isEqualTo(responseCancelEvent)
    }
}
