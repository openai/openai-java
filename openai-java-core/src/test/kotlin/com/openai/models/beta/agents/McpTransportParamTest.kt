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

internal class McpTransportParamTest {

    @Test
    fun ofHttp() {
        val http =
            McpTransportParam.Http.builder()
                .serverUrl("server_url")
                .authorization("authorization")
                .headers(
                    McpTransportParam.Http.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val mcpTransportParam = McpTransportParam.ofHttp(http)

        assertThat(mcpTransportParam.http()).contains(http)
        assertThat(mcpTransportParam.stdio()).isEmpty
    }

    @Test
    fun ofHttpRoundtrip() {
        val jsonMapper = jsonMapper()
        val mcpTransportParam =
            McpTransportParam.ofHttp(
                McpTransportParam.Http.builder()
                    .serverUrl("server_url")
                    .authorization("authorization")
                    .headers(
                        McpTransportParam.Http.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        val roundtrippedMcpTransportParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpTransportParam),
                jacksonTypeRef<McpTransportParam>(),
            )

        assertThat(roundtrippedMcpTransportParam).isEqualTo(mcpTransportParam)
    }

    @Test
    fun ofStdio() {
        val stdio =
            McpTransportParam.Stdio.builder()
                .command("command")
                .cwd("cwd")
                .addArg("string")
                .env(
                    McpTransportParam.Stdio.Env.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .addEnvVar("string")
                .build()

        val mcpTransportParam = McpTransportParam.ofStdio(stdio)

        assertThat(mcpTransportParam.http()).isEmpty
        assertThat(mcpTransportParam.stdio()).contains(stdio)
    }

    @Test
    fun ofStdioRoundtrip() {
        val jsonMapper = jsonMapper()
        val mcpTransportParam =
            McpTransportParam.ofStdio(
                McpTransportParam.Stdio.builder()
                    .command("command")
                    .cwd("cwd")
                    .addArg("string")
                    .env(
                        McpTransportParam.Stdio.Env.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .addEnvVar("string")
                    .build()
            )

        val roundtrippedMcpTransportParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpTransportParam),
                jacksonTypeRef<McpTransportParam>(),
            )

        assertThat(roundtrippedMcpTransportParam).isEqualTo(mcpTransportParam)
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
        val mcpTransportParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<McpTransportParam>())

        val e = assertThrows<OpenAIInvalidDataException> { mcpTransportParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
