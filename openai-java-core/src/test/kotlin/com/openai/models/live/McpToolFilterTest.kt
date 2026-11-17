// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class McpToolFilterTest {

    @Test
    fun createAndRoundtrip() {
        val mcpToolFilter = McpToolFilter.builder().readOnly(true).addToolName("string").build()

        assertThat(mcpToolFilter.readOnly()).contains(true)
        assertThat(mcpToolFilter.toolNames().getOrNull()).containsExactly("string")

        val jsonMapper = jsonMapper()

        val roundtrippedMcpToolFilter =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpToolFilter),
                jacksonTypeRef<McpToolFilter>(),
            )

        assertThat(roundtrippedMcpToolFilter).isEqualTo(mcpToolFilter)
    }
}
