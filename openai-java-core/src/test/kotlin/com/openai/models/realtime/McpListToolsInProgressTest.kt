// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class McpListToolsInProgressTest {

    @Test
    fun create() {
        val mcpListToolsInProgress =
            McpListToolsInProgress.builder().eventId("event_id").itemId("item_id").build()

        assertThat(mcpListToolsInProgress.eventId()).isEqualTo("event_id")
        assertThat(mcpListToolsInProgress.itemId()).isEqualTo("item_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val mcpListToolsInProgress =
            McpListToolsInProgress.builder().eventId("event_id").itemId("item_id").build()

        val roundtrippedMcpListToolsInProgress =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpListToolsInProgress),
                jacksonTypeRef<McpListToolsInProgress>(),
            )

        assertThat(roundtrippedMcpListToolsInProgress).isEqualTo(mcpListToolsInProgress)
    }
}
