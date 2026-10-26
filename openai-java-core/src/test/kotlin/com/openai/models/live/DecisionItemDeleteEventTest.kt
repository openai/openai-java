// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionItemDeleteEventTest {

    @Test
    fun createAndRoundtrip() {
        val decisionItemDeleteEvent =
            DecisionItemDeleteEvent.builder()
                .itemId("msg_browser_1")
                .eventId("remove_browser_1")
                .build()

        assertThat(decisionItemDeleteEvent.itemId()).isEqualTo("msg_browser_1")
        assertThat(decisionItemDeleteEvent.eventId()).contains("remove_browser_1")

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionItemDeleteEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionItemDeleteEvent),
                jacksonTypeRef<DecisionItemDeleteEvent>(),
            )

        assertThat(roundtrippedDecisionItemDeleteEvent).isEqualTo(decisionItemDeleteEvent)
    }
}
