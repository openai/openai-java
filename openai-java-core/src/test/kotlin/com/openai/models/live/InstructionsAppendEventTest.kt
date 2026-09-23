// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InstructionsAppendEventTest {

    @Test
    fun create() {
        val instructionsAppendEvent =
            InstructionsAppendEvent.builder()
                .content("The caller prefers outdoor seating.")
                .delegationId(null)
                .eventId("evt_instructions_001")
                .build()

        assertThat(instructionsAppendEvent.content())
            .isEqualTo("The caller prefers outdoor seating.")
        assertThat(instructionsAppendEvent.delegationId()).isEmpty
        assertThat(instructionsAppendEvent.eventId()).contains("evt_instructions_001")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val instructionsAppendEvent =
            InstructionsAppendEvent.builder()
                .content("The caller prefers outdoor seating.")
                .delegationId(null)
                .eventId("evt_instructions_001")
                .build()

        val roundtrippedInstructionsAppendEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(instructionsAppendEvent),
                jacksonTypeRef<InstructionsAppendEvent>(),
            )

        assertThat(roundtrippedInstructionsAppendEvent).isEqualTo(instructionsAppendEvent)
    }
}
