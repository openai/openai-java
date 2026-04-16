// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeResponseCreateMcpToolTest {

    @Test
    fun create() {
        val realtimeResponseCreateMcpTool =
            RealtimeResponseCreateMcpTool.builder()
                .serverLabel("server_label")
                .allowedToolsOfMcp(listOf("string"))
                .authorization("authorization")
                .connectorId(RealtimeResponseCreateMcpTool.ConnectorId.CONNECTOR_DROPBOX)
                .deferLoading(true)
                .headers(
                    RealtimeResponseCreateMcpTool.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .requireApproval(
                    RealtimeResponseCreateMcpTool.RequireApproval.McpToolApprovalSetting.ALWAYS
                )
                .serverDescription("server_description")
                .serverUrl("server_url")
                .build()

        assertThat(realtimeResponseCreateMcpTool.serverLabel()).isEqualTo("server_label")
        assertThat(realtimeResponseCreateMcpTool.allowedTools())
            .contains(RealtimeResponseCreateMcpTool.AllowedTools.ofMcp(listOf("string")))
        assertThat(realtimeResponseCreateMcpTool.authorization()).contains("authorization")
        assertThat(realtimeResponseCreateMcpTool.connectorId())
            .contains(RealtimeResponseCreateMcpTool.ConnectorId.CONNECTOR_DROPBOX)
        assertThat(realtimeResponseCreateMcpTool.deferLoading()).contains(true)
        assertThat(realtimeResponseCreateMcpTool.headers())
            .contains(
                RealtimeResponseCreateMcpTool.Headers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(realtimeResponseCreateMcpTool.requireApproval())
            .contains(
                RealtimeResponseCreateMcpTool.RequireApproval.ofMcpToolApprovalSetting(
                    RealtimeResponseCreateMcpTool.RequireApproval.McpToolApprovalSetting.ALWAYS
                )
            )
        assertThat(realtimeResponseCreateMcpTool.serverDescription()).contains("server_description")
        assertThat(realtimeResponseCreateMcpTool.serverUrl()).contains("server_url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeResponseCreateMcpTool =
            RealtimeResponseCreateMcpTool.builder()
                .serverLabel("server_label")
                .allowedToolsOfMcp(listOf("string"))
                .authorization("authorization")
                .connectorId(RealtimeResponseCreateMcpTool.ConnectorId.CONNECTOR_DROPBOX)
                .deferLoading(true)
                .headers(
                    RealtimeResponseCreateMcpTool.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .requireApproval(
                    RealtimeResponseCreateMcpTool.RequireApproval.McpToolApprovalSetting.ALWAYS
                )
                .serverDescription("server_description")
                .serverUrl("server_url")
                .build()

        val roundtrippedRealtimeResponseCreateMcpTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeResponseCreateMcpTool),
                jacksonTypeRef<RealtimeResponseCreateMcpTool>(),
            )

        assertThat(roundtrippedRealtimeResponseCreateMcpTool)
            .isEqualTo(realtimeResponseCreateMcpTool)
    }
}
