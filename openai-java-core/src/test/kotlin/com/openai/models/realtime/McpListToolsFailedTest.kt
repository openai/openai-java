// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class McpListToolsFailedTest {

    @Test
    fun create() {
        val mcpListToolsFailed =
            McpListToolsFailed.builder().eventId("event_id").itemId("item_id").build()

        assertThat(mcpListToolsFailed.eventId()).isEqualTo("event_id")
        assertThat(mcpListToolsFailed.itemId()).isEqualTo("item_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val mcpListToolsFailed =
            McpListToolsFailed.builder().eventId("event_id").itemId("item_id").build()

        val roundtrippedMcpListToolsFailed =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpListToolsFailed),
                jacksonTypeRef<McpListToolsFailed>(),
            )

        assertThat(roundtrippedMcpListToolsFailed).isEqualTo(mcpListToolsFailed)
    }
}
