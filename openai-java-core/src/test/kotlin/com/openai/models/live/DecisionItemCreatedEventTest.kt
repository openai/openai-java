// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionItemCreatedEventTest {

    @Test
    fun createAndRoundtrip() {
        val decisionItemCreatedEvent =
            DecisionItemCreatedEvent.builder()
                .eventId("evt_item_1")
                .item(
                    DecisionItemCreatedEvent.Item.builder()
                        .id("msg_browser_1")
                        .content("string")
                        .type(DecisionItemCreatedEvent.Item.Type.MESSAGE)
                        .build()
                )
                .clientEventId("browser_1")
                .build()

        assertThat(decisionItemCreatedEvent.eventId()).contains("evt_item_1")
        assertThat(decisionItemCreatedEvent.item())
            .contains(
                DecisionItemCreatedEvent.Item.builder()
                    .id("msg_browser_1")
                    .content("string")
                    .type(DecisionItemCreatedEvent.Item.Type.MESSAGE)
                    .build()
            )
        assertThat(decisionItemCreatedEvent.clientEventId()).contains("browser_1")

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionItemCreatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionItemCreatedEvent),
                jacksonTypeRef<DecisionItemCreatedEvent>(),
            )

        assertThat(roundtrippedDecisionItemCreatedEvent).isEqualTo(decisionItemCreatedEvent)
    }
}
