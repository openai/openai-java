// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class RealtimeToolsConfigUnionTest {

    @Test
    fun ofFunction() {
        val function =
            RealtimeFunctionTool.builder()
                .description("description")
                .name("name")
                .parameters(JsonValue.from(mapOf<String, Any>()))
                .type(RealtimeFunctionTool.Type.FUNCTION)
                .build()

        val realtimeToolsConfigUnion = RealtimeToolsConfigUnion.ofFunction(function)

        assertThat(realtimeToolsConfigUnion.function()).contains(function)
        assertThat(realtimeToolsConfigUnion.mcp()).isEmpty
    }

    @Test
    fun ofFunctionRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeToolsConfigUnion =
            RealtimeToolsConfigUnion.ofFunction(
                RealtimeFunctionTool.builder()
                    .description("description")
                    .name("name")
                    .parameters(JsonValue.from(mapOf<String, Any>()))
                    .type(RealtimeFunctionTool.Type.FUNCTION)
                    .build()
            )

        val roundtrippedRealtimeToolsConfigUnion =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeToolsConfigUnion),
                jacksonTypeRef<RealtimeToolsConfigUnion>(),
            )

        assertThat(roundtrippedRealtimeToolsConfigUnion).isEqualTo(realtimeToolsConfigUnion)
    }

    @Test
    fun ofMcp() {
        val mcp =
            RealtimeToolsConfigUnion.Mcp.builder()
                .serverLabel("server_label")
                .allowedToolsOfMcp(listOf("string"))
                .authorization("authorization")
                .connectorId(RealtimeToolsConfigUnion.Mcp.ConnectorId.CONNECTOR_DROPBOX)
                .deferLoading(true)
                .headers(
                    RealtimeToolsConfigUnion.Mcp.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .requireApproval(
                    RealtimeToolsConfigUnion.Mcp.RequireApproval.McpToolApprovalSetting.ALWAYS
                )
                .serverDescription("server_description")
                .serverUrl("https://example.com")
                .build()

        val realtimeToolsConfigUnion = RealtimeToolsConfigUnion.ofMcp(mcp)

        assertThat(realtimeToolsConfigUnion.function()).isEmpty
        assertThat(realtimeToolsConfigUnion.mcp()).contains(mcp)
    }

    @Test
    fun ofMcpRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeToolsConfigUnion =
            RealtimeToolsConfigUnion.ofMcp(
                RealtimeToolsConfigUnion.Mcp.builder()
                    .serverLabel("server_label")
                    .allowedToolsOfMcp(listOf("string"))
                    .authorization("authorization")
                    .connectorId(RealtimeToolsConfigUnion.Mcp.ConnectorId.CONNECTOR_DROPBOX)
                    .deferLoading(true)
                    .headers(
                        RealtimeToolsConfigUnion.Mcp.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .requireApproval(
                        RealtimeToolsConfigUnion.Mcp.RequireApproval.McpToolApprovalSetting.ALWAYS
                    )
                    .serverDescription("server_description")
                    .serverUrl("https://example.com")
                    .build()
            )

        val roundtrippedRealtimeToolsConfigUnion =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeToolsConfigUnion),
                jacksonTypeRef<RealtimeToolsConfigUnion>(),
            )

        assertThat(roundtrippedRealtimeToolsConfigUnion).isEqualTo(realtimeToolsConfigUnion)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val realtimeToolsConfigUnion =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<RealtimeToolsConfigUnion>())

        val e = assertThrows<OpenAIInvalidDataException> { realtimeToolsConfigUnion.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
