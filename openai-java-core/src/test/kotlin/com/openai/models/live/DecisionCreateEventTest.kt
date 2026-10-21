// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionCreateEventTest {

    @Test
    fun createAndRoundtrip() {
        val decisionCreateEvent = DecisionCreateEvent.builder().eventId("decision_1").build()

        assertThat(decisionCreateEvent.eventId()).isEqualTo("decision_1")

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionCreateEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionCreateEvent),
                jacksonTypeRef<DecisionCreateEvent>(),
            )

        assertThat(roundtrippedDecisionCreateEvent).isEqualTo(decisionCreateEvent)
    }
}
