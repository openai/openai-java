// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class McpRequireApprovalFilterTest {

    @Test
    fun createAndRoundtrip() {
        val mcpRequireApprovalFilter =
            McpRequireApprovalFilter.builder()
                .always(McpToolFilter.builder().readOnly(true).addToolName("string").build())
                .never(McpToolFilter.builder().readOnly(true).addToolName("string").build())
                .build()

        assertThat(mcpRequireApprovalFilter.always())
            .contains(McpToolFilter.builder().readOnly(true).addToolName("string").build())
        assertThat(mcpRequireApprovalFilter.never())
            .contains(McpToolFilter.builder().readOnly(true).addToolName("string").build())

        val jsonMapper = jsonMapper()

        val roundtrippedMcpRequireApprovalFilter =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpRequireApprovalFilter),
                jacksonTypeRef<McpRequireApprovalFilter>(),
            )

        assertThat(roundtrippedMcpRequireApprovalFilter).isEqualTo(mcpRequireApprovalFilter)
    }
}
