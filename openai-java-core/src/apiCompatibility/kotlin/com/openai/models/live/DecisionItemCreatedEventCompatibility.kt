// Curated from DecisionItemCreatedEventTest at 3d194e30df1ed215a3292dacf9ffe13fc50a6266.
// Preserve all unaffected consumer expressions for the next-major Live migration.
// Only the intentionally replaced item/question constructors use wire-shaped values.
// The ordinary current SDK tests retain typed-constructor and runtime coverage.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionItemCreatedEventCompatibility {

    @Test
    fun createAndRoundtrip() {
        val decisionItemCreatedEvent =
            DecisionItemCreatedEvent.builder()
                .eventId("evt_item_1")
                .item(
                    jsonMapper()
                        .readValue(
                            """{"id":"msg_browser_1","content":"string","type":"message"}""",
                            DecisionItemCreatedEvent.Item::class.java,
                        )
                )
                .clientEventId("browser_1")
                .build()

        assertThat(decisionItemCreatedEvent.eventId()).isEqualTo("evt_item_1")
        assertThat(decisionItemCreatedEvent.item())
            .isEqualTo(
                jsonMapper()
                    .readValue(
                        """{"id":"msg_browser_1","content":"string","type":"message"}""",
                        DecisionItemCreatedEvent.Item::class.java,
                    )
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
