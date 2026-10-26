// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionItemDeletedEventTest {

    @Test
    fun createAndRoundtrip() {
        val decisionItemDeletedEvent =
            DecisionItemDeletedEvent.builder()
                .eventId("evt_item_deleted_1")
                .itemId("msg_browser_1")
                .clientEventId("remove_browser_1")
                .build()

        assertThat(decisionItemDeletedEvent.eventId()).isEqualTo("evt_item_deleted_1")
        assertThat(decisionItemDeletedEvent.itemId()).isEqualTo("msg_browser_1")
        assertThat(decisionItemDeletedEvent.clientEventId()).contains("remove_browser_1")

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionItemDeletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionItemDeletedEvent),
                jacksonTypeRef<DecisionItemDeletedEvent>(),
            )

        assertThat(roundtrippedDecisionItemDeletedEvent).isEqualTo(decisionItemDeletedEvent)
    }
}
