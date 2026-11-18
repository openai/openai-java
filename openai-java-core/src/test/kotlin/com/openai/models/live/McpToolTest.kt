// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class McpToolTest {

    @Test
    fun createAndRoundtrip() {
        val mcpTool =
            McpTool.builder()
                .addAllowedCaller(McpTool.AllowedCaller.DIRECT)
                .allowedToolsOfStrings(listOf("string"))
                .authorization("authorization")
                .connectorId("connector_id")
                .deferLoading(true)
                .headers(
                    McpTool.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .requireApproval(McpTool.RequireApproval.LiveMcpRequireApprovalApiEnum.ALWAYS)
                .serverDescription("server_description")
                .serverLabel("server_label")
                .serverUrl("https://example.com")
                .tunnelId("tunnel_210b9798ad53ecc4y69z31e1071cx03v")
                .build()

        assertThat(mcpTool.allowedCallers().getOrNull())
            .containsExactly(McpTool.AllowedCaller.DIRECT)
        assertThat(mcpTool.allowedTools())
            .contains(McpTool.AllowedTools.ofStrings(listOf("string")))
        assertThat(mcpTool.authorization()).contains("authorization")
        assertThat(mcpTool.connectorId()).contains("connector_id")
        assertThat(mcpTool.deferLoading()).contains(true)
        assertThat(mcpTool.headers())
            .contains(
                McpTool.Headers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(mcpTool.requireApproval())
            .contains(
                McpTool.RequireApproval.ofLiveMcpRequireApprovalApiEnum(
                    McpTool.RequireApproval.LiveMcpRequireApprovalApiEnum.ALWAYS
                )
            )
        assertThat(mcpTool.serverDescription()).contains("server_description")
        assertThat(mcpTool.serverLabel()).contains("server_label")
        assertThat(mcpTool.serverUrl()).contains("https://example.com")
        assertThat(mcpTool.tunnelId()).contains("tunnel_210b9798ad53ecc4y69z31e1071cx03v")

        val jsonMapper = jsonMapper()

        val roundtrippedMcpTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(mcpTool), jacksonTypeRef<McpTool>())

        assertThat(roundtrippedMcpTool).isEqualTo(mcpTool)
    }
}
