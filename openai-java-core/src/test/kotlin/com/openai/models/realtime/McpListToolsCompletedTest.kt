// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class McpListToolsCompletedTest {

    @Test
    fun create() {
        val mcpListToolsCompleted =
            McpListToolsCompleted.builder().eventId("event_id").itemId("item_id").build()

        assertThat(mcpListToolsCompleted.eventId()).isEqualTo("event_id")
        assertThat(mcpListToolsCompleted.itemId()).isEqualTo("item_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val mcpListToolsCompleted =
            McpListToolsCompleted.builder().eventId("event_id").itemId("item_id").build()

        val roundtrippedMcpListToolsCompleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpListToolsCompleted),
                jacksonTypeRef<McpListToolsCompleted>(),
            )

        assertThat(roundtrippedMcpListToolsCompleted).isEqualTo(mcpListToolsCompleted)
    }
}
