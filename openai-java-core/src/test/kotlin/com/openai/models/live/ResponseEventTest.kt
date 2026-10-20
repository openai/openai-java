// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseEventTest {

    @Test
    fun create() {
        val responseEvent =
            ResponseEvent.builder()
                .event(
                    ResponseEvent.Event.builder()
                        .putAdditionalProperty("type", JsonValue.from("response.output_text.delta"))
                        .putAdditionalProperty("item_id", JsonValue.from("msg_abc123"))
                        .putAdditionalProperty("output_index", JsonValue.from(0))
                        .putAdditionalProperty("content_index", JsonValue.from(0))
                        .putAdditionalProperty(
                            "delta",
                            JsonValue.from("An outdoor table is available at 7 PM."),
                        )
                        .putAdditionalProperty("sequence_number", JsonValue.from(3))
                        .putAdditionalProperty("logprobs", JsonValue.from(listOf<Any?>()))
                        .build()
                )
                .eventId("evt_response_002")
                .clientEventId("client_event_id")
                .delegationId("del_responses123")
                .build()

        assertThat(responseEvent.event())
            .isEqualTo(
                ResponseEvent.Event.builder()
                    .putAdditionalProperty("type", JsonValue.from("response.output_text.delta"))
                    .putAdditionalProperty("item_id", JsonValue.from("msg_abc123"))
                    .putAdditionalProperty("output_index", JsonValue.from(0))
                    .putAdditionalProperty("content_index", JsonValue.from(0))
                    .putAdditionalProperty(
                        "delta",
                        JsonValue.from("An outdoor table is available at 7 PM."),
                    )
                    .putAdditionalProperty("sequence_number", JsonValue.from(3))
                    .putAdditionalProperty("logprobs", JsonValue.from(listOf<Any?>()))
                    .build()
            )
        assertThat(responseEvent.eventId()).isEqualTo("evt_response_002")
        assertThat(responseEvent.clientEventId()).contains("client_event_id")
        assertThat(responseEvent.delegationId()).contains("del_responses123")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseEvent =
            ResponseEvent.builder()
                .event(
                    ResponseEvent.Event.builder()
                        .putAdditionalProperty("type", JsonValue.from("response.output_text.delta"))
                        .putAdditionalProperty("item_id", JsonValue.from("msg_abc123"))
                        .putAdditionalProperty("output_index", JsonValue.from(0))
                        .putAdditionalProperty("content_index", JsonValue.from(0))
                        .putAdditionalProperty(
                            "delta",
                            JsonValue.from("An outdoor table is available at 7 PM."),
                        )
                        .putAdditionalProperty("sequence_number", JsonValue.from(3))
                        .putAdditionalProperty("logprobs", JsonValue.from(listOf<Any?>()))
                        .build()
                )
                .eventId("evt_response_002")
                .clientEventId("client_event_id")
                .delegationId("del_responses123")
                .build()

        val roundtrippedResponseEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseEvent),
                jacksonTypeRef<ResponseEvent>(),
            )

        assertThat(roundtrippedResponseEvent).isEqualTo(responseEvent)
    }
}
