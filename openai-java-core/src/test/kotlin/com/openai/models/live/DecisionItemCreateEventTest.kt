// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionItemCreateEventTest {

    @Test
    fun createAndRoundtrip() {
        val decisionItemCreateEvent =
            DecisionItemCreateEvent.builder()
                .item(
                    DecisionItemCreateEvent.Item.builder()
                        .content("string")
                        .id("id")
                        .type(DecisionItemCreateEvent.Item.Type.MESSAGE)
                        .build()
                )
                .eventId("browser_1")
                .build()

        assertThat(decisionItemCreateEvent.item())
            .isEqualTo(
                DecisionItemCreateEvent.Item.builder()
                    .content("string")
                    .id("id")
                    .type(DecisionItemCreateEvent.Item.Type.MESSAGE)
                    .build()
            )
        assertThat(decisionItemCreateEvent.eventId()).contains("browser_1")

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionItemCreateEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionItemCreateEvent),
                jacksonTypeRef<DecisionItemCreateEvent>(),
            )

        assertThat(roundtrippedDecisionItemCreateEvent).isEqualTo(decisionItemCreateEvent)
    }
}
