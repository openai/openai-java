// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class McpTransportTest {

    @Test
    fun ofHttp() {
        val http = McpTransport.Http.builder().serverUrl("server_url").build()

        val mcpTransport = McpTransport.ofHttp(http)

        assertThat(mcpTransport.http()).contains(http)
        assertThat(mcpTransport.stdio()).isEmpty
    }

    @Test
    fun ofHttpRoundtrip() {
        val jsonMapper = jsonMapper()
        val mcpTransport =
            McpTransport.ofHttp(McpTransport.Http.builder().serverUrl("server_url").build())

        val roundtrippedMcpTransport =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpTransport),
                jacksonTypeRef<McpTransport>(),
            )

        assertThat(roundtrippedMcpTransport).isEqualTo(mcpTransport)
    }

    @Test
    fun ofStdio() {
        val stdio =
            McpTransport.Stdio.builder()
                .addArg("string")
                .command("command")
                .cwd("cwd")
                .addEnvVar("string")
                .build()

        val mcpTransport = McpTransport.ofStdio(stdio)

        assertThat(mcpTransport.http()).isEmpty
        assertThat(mcpTransport.stdio()).contains(stdio)
    }

    @Test
    fun ofStdioRoundtrip() {
        val jsonMapper = jsonMapper()
        val mcpTransport =
            McpTransport.ofStdio(
                McpTransport.Stdio.builder()
                    .addArg("string")
                    .command("command")
                    .cwd("cwd")
                    .addEnvVar("string")
                    .build()
            )

        val roundtrippedMcpTransport =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpTransport),
                jacksonTypeRef<McpTransport>(),
            )

        assertThat(roundtrippedMcpTransport).isEqualTo(mcpTransport)
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
        val mcpTransport = jsonMapper().convertValue(testCase.value, jacksonTypeRef<McpTransport>())

        val e = assertThrows<OpenAIInvalidDataException> { mcpTransport.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
