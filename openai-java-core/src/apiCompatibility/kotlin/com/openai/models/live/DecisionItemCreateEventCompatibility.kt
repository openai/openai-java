// Curated from DecisionItemCreateEventTest at 3d194e30df1ed215a3292dacf9ffe13fc50a6266.
// Preserve all unaffected consumer expressions for the next-major Live migration.
// Only the intentionally replaced item/question constructors use wire-shaped values.
// The ordinary current SDK tests retain typed-constructor and runtime coverage.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionItemCreateEventCompatibility {

    @Test
    fun createAndRoundtrip() {
        val decisionItemCreateEvent =
            DecisionItemCreateEvent.builder()
                .item(
                    jsonMapper()
                        .readValue(
                            """{"content":"string","id":"id","type":"message"}""",
                            DecisionItemCreateEvent.Item::class.java,
                        )
                )
                .eventId("browser_1")
                .build()

        assertThat(decisionItemCreateEvent.item())
            .isEqualTo(
                jsonMapper()
                    .readValue(
                        """{"content":"string","id":"id","type":"message"}""",
                        DecisionItemCreateEvent.Item::class.java,
                    )
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
