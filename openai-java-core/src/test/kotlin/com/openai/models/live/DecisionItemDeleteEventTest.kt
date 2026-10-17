// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionItemDeleteEventTest {

    @Test
    fun create() {
        val decisionItemDeleteEvent =
            DecisionItemDeleteEvent.builder()
                .itemId("msg_browser_1")
                .eventId("remove_browser_1")
                .build()

        assertThat(decisionItemDeleteEvent.itemId()).isEqualTo("msg_browser_1")
        assertThat(decisionItemDeleteEvent.eventId()).contains("remove_browser_1")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val decisionItemDeleteEvent =
            DecisionItemDeleteEvent.builder()
                .itemId("msg_browser_1")
                .eventId("remove_browser_1")
                .build()

        val roundtrippedDecisionItemDeleteEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionItemDeleteEvent),
                jacksonTypeRef<DecisionItemDeleteEvent>(),
            )

        assertThat(roundtrippedDecisionItemDeleteEvent).isEqualTo(decisionItemDeleteEvent)
    }
}
