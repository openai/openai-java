// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class BetaMcpToolCallErrorTest {

    @Test
    fun ofMcpProtocol() {
        val mcpProtocol =
            BetaMcpToolCallError.McpProtocolError.builder().code(0L).message("message").build()

        val betaMcpToolCallError = BetaMcpToolCallError.ofMcpProtocol(mcpProtocol)

        assertThat(betaMcpToolCallError.mcpProtocol()).contains(mcpProtocol)
        assertThat(betaMcpToolCallError.mcpToolExecution()).isEmpty
        assertThat(betaMcpToolCallError.http()).isEmpty
    }

    @Test
    fun ofMcpProtocolRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaMcpToolCallError =
            BetaMcpToolCallError.ofMcpProtocol(
                BetaMcpToolCallError.McpProtocolError.builder().code(0L).message("message").build()
            )

        val roundtrippedBetaMcpToolCallError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaMcpToolCallError),
                jacksonTypeRef<BetaMcpToolCallError>(),
            )

        assertThat(roundtrippedBetaMcpToolCallError).isEqualTo(betaMcpToolCallError)
    }

    @Test
    fun ofMcpToolExecution() {
        val mcpToolExecution =
            BetaMcpToolCallError.McpToolExecutionError.builder()
                .content(JsonValue.from(mapOf<String, Any>()))
                .build()

        val betaMcpToolCallError = BetaMcpToolCallError.ofMcpToolExecution(mcpToolExecution)

        assertThat(betaMcpToolCallError.mcpProtocol()).isEmpty
        assertThat(betaMcpToolCallError.mcpToolExecution()).contains(mcpToolExecution)
        assertThat(betaMcpToolCallError.http()).isEmpty
    }

    @Test
    fun ofMcpToolExecutionRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaMcpToolCallError =
            BetaMcpToolCallError.ofMcpToolExecution(
                BetaMcpToolCallError.McpToolExecutionError.builder()
                    .content(JsonValue.from(mapOf<String, Any>()))
                    .build()
            )

        val roundtrippedBetaMcpToolCallError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaMcpToolCallError),
                jacksonTypeRef<BetaMcpToolCallError>(),
            )

        assertThat(roundtrippedBetaMcpToolCallError).isEqualTo(betaMcpToolCallError)
    }

    @Test
    fun ofHttp() {
        val http = BetaMcpToolCallError.HttpError.builder().code(0L).message("message").build()

        val betaMcpToolCallError = BetaMcpToolCallError.ofHttp(http)

        assertThat(betaMcpToolCallError.mcpProtocol()).isEmpty
        assertThat(betaMcpToolCallError.mcpToolExecution()).isEmpty
        assertThat(betaMcpToolCallError.http()).contains(http)
    }

    @Test
    fun ofHttpRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaMcpToolCallError =
            BetaMcpToolCallError.ofHttp(
                BetaMcpToolCallError.HttpError.builder().code(0L).message("message").build()
            )

        val roundtrippedBetaMcpToolCallError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaMcpToolCallError),
                jacksonTypeRef<BetaMcpToolCallError>(),
            )

        assertThat(roundtrippedBetaMcpToolCallError).isEqualTo(betaMcpToolCallError)
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
        val betaMcpToolCallError =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<BetaMcpToolCallError>())

        val e = assertThrows<OpenAIInvalidDataException> { betaMcpToolCallError.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
