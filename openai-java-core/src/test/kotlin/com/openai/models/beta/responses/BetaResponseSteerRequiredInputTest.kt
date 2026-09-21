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

internal class BetaResponseSteerRequiredInputTest {

    @Test
    fun ofFunctionCallOutput() {
        val functionCallOutput =
            BetaResponseSteerRequiredInput.FunctionCallOutput.builder()
                .callId("call_id")
                .name("name")
                .build()

        val betaResponseSteerRequiredInput =
            BetaResponseSteerRequiredInput.ofFunctionCallOutput(functionCallOutput)

        assertThat(betaResponseSteerRequiredInput.functionCallOutput()).contains(functionCallOutput)
        assertThat(betaResponseSteerRequiredInput.customToolCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.computerCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.shellCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.toolSearchOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.mcpApprovalResponse()).isEmpty
    }

    @Test
    fun ofFunctionCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseSteerRequiredInput =
            BetaResponseSteerRequiredInput.ofFunctionCallOutput(
                BetaResponseSteerRequiredInput.FunctionCallOutput.builder()
                    .callId("call_id")
                    .name("name")
                    .build()
            )

        val roundtrippedBetaResponseSteerRequiredInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseSteerRequiredInput),
                jacksonTypeRef<BetaResponseSteerRequiredInput>(),
            )

        assertThat(roundtrippedBetaResponseSteerRequiredInput)
            .isEqualTo(betaResponseSteerRequiredInput)
    }

    @Test
    fun ofCustomToolCallOutput() {
        val customToolCallOutput =
            BetaResponseSteerRequiredInput.CustomToolCallOutput.builder().callId("call_id").build()

        val betaResponseSteerRequiredInput =
            BetaResponseSteerRequiredInput.ofCustomToolCallOutput(customToolCallOutput)

        assertThat(betaResponseSteerRequiredInput.functionCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.customToolCallOutput())
            .contains(customToolCallOutput)
        assertThat(betaResponseSteerRequiredInput.computerCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.shellCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.toolSearchOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.mcpApprovalResponse()).isEmpty
    }

    @Test
    fun ofCustomToolCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseSteerRequiredInput =
            BetaResponseSteerRequiredInput.ofCustomToolCallOutput(
                BetaResponseSteerRequiredInput.CustomToolCallOutput.builder()
                    .callId("call_id")
                    .build()
            )

        val roundtrippedBetaResponseSteerRequiredInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseSteerRequiredInput),
                jacksonTypeRef<BetaResponseSteerRequiredInput>(),
            )

        assertThat(roundtrippedBetaResponseSteerRequiredInput)
            .isEqualTo(betaResponseSteerRequiredInput)
    }

    @Test
    fun ofComputerCallOutput() {
        val computerCallOutput =
            BetaResponseSteerRequiredInput.ComputerCallOutput.builder().callId("call_id").build()

        val betaResponseSteerRequiredInput =
            BetaResponseSteerRequiredInput.ofComputerCallOutput(computerCallOutput)

        assertThat(betaResponseSteerRequiredInput.functionCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.customToolCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.computerCallOutput()).contains(computerCallOutput)
        assertThat(betaResponseSteerRequiredInput.shellCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.toolSearchOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.mcpApprovalResponse()).isEmpty
    }

    @Test
    fun ofComputerCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseSteerRequiredInput =
            BetaResponseSteerRequiredInput.ofComputerCallOutput(
                BetaResponseSteerRequiredInput.ComputerCallOutput.builder()
                    .callId("call_id")
                    .build()
            )

        val roundtrippedBetaResponseSteerRequiredInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseSteerRequiredInput),
                jacksonTypeRef<BetaResponseSteerRequiredInput>(),
            )

        assertThat(roundtrippedBetaResponseSteerRequiredInput)
            .isEqualTo(betaResponseSteerRequiredInput)
    }

    @Test
    fun ofShellCallOutput() {
        val shellCallOutput =
            BetaResponseSteerRequiredInput.ShellCallOutput.builder().callId("call_id").build()

        val betaResponseSteerRequiredInput =
            BetaResponseSteerRequiredInput.ofShellCallOutput(shellCallOutput)

        assertThat(betaResponseSteerRequiredInput.functionCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.customToolCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.computerCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.shellCallOutput()).contains(shellCallOutput)
        assertThat(betaResponseSteerRequiredInput.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.toolSearchOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.mcpApprovalResponse()).isEmpty
    }

    @Test
    fun ofShellCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseSteerRequiredInput =
            BetaResponseSteerRequiredInput.ofShellCallOutput(
                BetaResponseSteerRequiredInput.ShellCallOutput.builder().callId("call_id").build()
            )

        val roundtrippedBetaResponseSteerRequiredInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseSteerRequiredInput),
                jacksonTypeRef<BetaResponseSteerRequiredInput>(),
            )

        assertThat(roundtrippedBetaResponseSteerRequiredInput)
            .isEqualTo(betaResponseSteerRequiredInput)
    }

    @Test
    fun ofApplyPatchCallOutput() {
        val applyPatchCallOutput =
            BetaResponseSteerRequiredInput.ApplyPatchCallOutput.builder().callId("call_id").build()

        val betaResponseSteerRequiredInput =
            BetaResponseSteerRequiredInput.ofApplyPatchCallOutput(applyPatchCallOutput)

        assertThat(betaResponseSteerRequiredInput.functionCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.customToolCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.computerCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.shellCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.applyPatchCallOutput())
            .contains(applyPatchCallOutput)
        assertThat(betaResponseSteerRequiredInput.toolSearchOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.mcpApprovalResponse()).isEmpty
    }

    @Test
    fun ofApplyPatchCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseSteerRequiredInput =
            BetaResponseSteerRequiredInput.ofApplyPatchCallOutput(
                BetaResponseSteerRequiredInput.ApplyPatchCallOutput.builder()
                    .callId("call_id")
                    .build()
            )

        val roundtrippedBetaResponseSteerRequiredInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseSteerRequiredInput),
                jacksonTypeRef<BetaResponseSteerRequiredInput>(),
            )

        assertThat(roundtrippedBetaResponseSteerRequiredInput)
            .isEqualTo(betaResponseSteerRequiredInput)
    }

    @Test
    fun ofToolSearchOutput() {
        val toolSearchOutput =
            BetaResponseSteerRequiredInput.ToolSearchOutput.builder().callId("call_id").build()

        val betaResponseSteerRequiredInput =
            BetaResponseSteerRequiredInput.ofToolSearchOutput(toolSearchOutput)

        assertThat(betaResponseSteerRequiredInput.functionCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.customToolCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.computerCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.shellCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.toolSearchOutput()).contains(toolSearchOutput)
        assertThat(betaResponseSteerRequiredInput.mcpApprovalResponse()).isEmpty
    }

    @Test
    fun ofToolSearchOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseSteerRequiredInput =
            BetaResponseSteerRequiredInput.ofToolSearchOutput(
                BetaResponseSteerRequiredInput.ToolSearchOutput.builder().callId("call_id").build()
            )

        val roundtrippedBetaResponseSteerRequiredInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseSteerRequiredInput),
                jacksonTypeRef<BetaResponseSteerRequiredInput>(),
            )

        assertThat(roundtrippedBetaResponseSteerRequiredInput)
            .isEqualTo(betaResponseSteerRequiredInput)
    }

    @Test
    fun ofMcpApprovalResponse() {
        val mcpApprovalResponse =
            BetaResponseSteerRequiredInput.McpApprovalResponse.builder()
                .approvalRequestId("approval_request_id")
                .build()

        val betaResponseSteerRequiredInput =
            BetaResponseSteerRequiredInput.ofMcpApprovalResponse(mcpApprovalResponse)

        assertThat(betaResponseSteerRequiredInput.functionCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.customToolCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.computerCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.shellCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.toolSearchOutput()).isEmpty
        assertThat(betaResponseSteerRequiredInput.mcpApprovalResponse())
            .contains(mcpApprovalResponse)
    }

    @Test
    fun ofMcpApprovalResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseSteerRequiredInput =
            BetaResponseSteerRequiredInput.ofMcpApprovalResponse(
                BetaResponseSteerRequiredInput.McpApprovalResponse.builder()
                    .approvalRequestId("approval_request_id")
                    .build()
            )

        val roundtrippedBetaResponseSteerRequiredInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseSteerRequiredInput),
                jacksonTypeRef<BetaResponseSteerRequiredInput>(),
            )

        assertThat(roundtrippedBetaResponseSteerRequiredInput)
            .isEqualTo(betaResponseSteerRequiredInput)
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
        val betaResponseSteerRequiredInput =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<BetaResponseSteerRequiredInput>())

        val e =
            assertThrows<OpenAIInvalidDataException> { betaResponseSteerRequiredInput.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
