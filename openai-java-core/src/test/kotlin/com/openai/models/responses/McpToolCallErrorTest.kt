// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class McpToolCallErrorTest {

    @Test
    fun ofProtocol() {
        val protocol =
            McpToolCallError.McpProtocolError.builder().code(0L).message("message").build()

        val mcpToolCallError = McpToolCallError.ofProtocol(protocol)

        assertThat(mcpToolCallError.protocol()).contains(protocol)
        assertThat(mcpToolCallError.toolExecution()).isEmpty
        assertThat(mcpToolCallError.http()).isEmpty
    }

    @Test
    fun ofProtocolRoundtrip() {
        val jsonMapper = jsonMapper()
        val mcpToolCallError =
            McpToolCallError.ofProtocol(
                McpToolCallError.McpProtocolError.builder().code(0L).message("message").build()
            )

        val roundtrippedMcpToolCallError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpToolCallError),
                jacksonTypeRef<McpToolCallError>(),
            )

        assertThat(roundtrippedMcpToolCallError).isEqualTo(mcpToolCallError)
    }

    @Test
    fun ofToolExecution() {
        val toolExecution =
            McpToolCallError.McpToolExecutionError.builder()
                .content(JsonValue.from(mapOf<String, Any>()))
                .build()

        val mcpToolCallError = McpToolCallError.ofToolExecution(toolExecution)

        assertThat(mcpToolCallError.protocol()).isEmpty
        assertThat(mcpToolCallError.toolExecution()).contains(toolExecution)
        assertThat(mcpToolCallError.http()).isEmpty
    }

    @Test
    fun ofToolExecutionRoundtrip() {
        val jsonMapper = jsonMapper()
        val mcpToolCallError =
            McpToolCallError.ofToolExecution(
                McpToolCallError.McpToolExecutionError.builder()
                    .content(JsonValue.from(mapOf<String, Any>()))
                    .build()
            )

        val roundtrippedMcpToolCallError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpToolCallError),
                jacksonTypeRef<McpToolCallError>(),
            )

        assertThat(roundtrippedMcpToolCallError).isEqualTo(mcpToolCallError)
    }

    @Test
    fun ofHttp() {
        val http = McpToolCallError.HttpError.builder().code(0L).message("message").build()

        val mcpToolCallError = McpToolCallError.ofHttp(http)

        assertThat(mcpToolCallError.protocol()).isEmpty
        assertThat(mcpToolCallError.toolExecution()).isEmpty
        assertThat(mcpToolCallError.http()).contains(http)
    }

    @Test
    fun ofHttpRoundtrip() {
        val jsonMapper = jsonMapper()
        val mcpToolCallError =
            McpToolCallError.ofHttp(
                McpToolCallError.HttpError.builder().code(0L).message("message").build()
            )

        val roundtrippedMcpToolCallError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpToolCallError),
                jacksonTypeRef<McpToolCallError>(),
            )

        assertThat(roundtrippedMcpToolCallError).isEqualTo(mcpToolCallError)
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
        val mcpToolCallError =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<McpToolCallError>())

        val e = assertThrows<OpenAIInvalidDataException> { mcpToolCallError.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
