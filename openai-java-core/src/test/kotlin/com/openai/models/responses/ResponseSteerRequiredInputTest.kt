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

internal class ResponseSteerRequiredInputTest {

    @Test
    fun ofFunctionCallOutput() {
        val functionCallOutput =
            ResponseSteerRequiredInput.FunctionCallOutput.builder()
                .callId("call_id")
                .name("name")
                .build()

        val responseSteerRequiredInput =
            ResponseSteerRequiredInput.ofFunctionCallOutput(functionCallOutput)

        assertThat(responseSteerRequiredInput.functionCallOutput()).contains(functionCallOutput)
        assertThat(responseSteerRequiredInput.customToolCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.computerCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.shellCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.applyPatchCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.toolSearchOutput()).isEmpty
        assertThat(responseSteerRequiredInput.mcpApprovalResponse()).isEmpty
    }

    @Test
    fun ofFunctionCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseSteerRequiredInput =
            ResponseSteerRequiredInput.ofFunctionCallOutput(
                ResponseSteerRequiredInput.FunctionCallOutput.builder()
                    .callId("call_id")
                    .name("name")
                    .build()
            )

        val roundtrippedResponseSteerRequiredInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseSteerRequiredInput),
                jacksonTypeRef<ResponseSteerRequiredInput>(),
            )

        assertThat(roundtrippedResponseSteerRequiredInput).isEqualTo(responseSteerRequiredInput)
    }

    @Test
    fun ofCustomToolCallOutput() {
        val customToolCallOutput =
            ResponseSteerRequiredInput.CustomToolCallOutput.builder().callId("call_id").build()

        val responseSteerRequiredInput =
            ResponseSteerRequiredInput.ofCustomToolCallOutput(customToolCallOutput)

        assertThat(responseSteerRequiredInput.functionCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.customToolCallOutput()).contains(customToolCallOutput)
        assertThat(responseSteerRequiredInput.computerCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.shellCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.applyPatchCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.toolSearchOutput()).isEmpty
        assertThat(responseSteerRequiredInput.mcpApprovalResponse()).isEmpty
    }

    @Test
    fun ofCustomToolCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseSteerRequiredInput =
            ResponseSteerRequiredInput.ofCustomToolCallOutput(
                ResponseSteerRequiredInput.CustomToolCallOutput.builder().callId("call_id").build()
            )

        val roundtrippedResponseSteerRequiredInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseSteerRequiredInput),
                jacksonTypeRef<ResponseSteerRequiredInput>(),
            )

        assertThat(roundtrippedResponseSteerRequiredInput).isEqualTo(responseSteerRequiredInput)
    }

    @Test
    fun ofComputerCallOutput() {
        val computerCallOutput =
            ResponseSteerRequiredInput.ComputerCallOutput.builder().callId("call_id").build()

        val responseSteerRequiredInput =
            ResponseSteerRequiredInput.ofComputerCallOutput(computerCallOutput)

        assertThat(responseSteerRequiredInput.functionCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.customToolCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.computerCallOutput()).contains(computerCallOutput)
        assertThat(responseSteerRequiredInput.shellCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.applyPatchCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.toolSearchOutput()).isEmpty
        assertThat(responseSteerRequiredInput.mcpApprovalResponse()).isEmpty
    }

    @Test
    fun ofComputerCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseSteerRequiredInput =
            ResponseSteerRequiredInput.ofComputerCallOutput(
                ResponseSteerRequiredInput.ComputerCallOutput.builder().callId("call_id").build()
            )

        val roundtrippedResponseSteerRequiredInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseSteerRequiredInput),
                jacksonTypeRef<ResponseSteerRequiredInput>(),
            )

        assertThat(roundtrippedResponseSteerRequiredInput).isEqualTo(responseSteerRequiredInput)
    }

    @Test
    fun ofShellCallOutput() {
        val shellCallOutput =
            ResponseSteerRequiredInput.ShellCallOutput.builder().callId("call_id").build()

        val responseSteerRequiredInput =
            ResponseSteerRequiredInput.ofShellCallOutput(shellCallOutput)

        assertThat(responseSteerRequiredInput.functionCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.customToolCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.computerCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.shellCallOutput()).contains(shellCallOutput)
        assertThat(responseSteerRequiredInput.applyPatchCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.toolSearchOutput()).isEmpty
        assertThat(responseSteerRequiredInput.mcpApprovalResponse()).isEmpty
    }

    @Test
    fun ofShellCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseSteerRequiredInput =
            ResponseSteerRequiredInput.ofShellCallOutput(
                ResponseSteerRequiredInput.ShellCallOutput.builder().callId("call_id").build()
            )

        val roundtrippedResponseSteerRequiredInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseSteerRequiredInput),
                jacksonTypeRef<ResponseSteerRequiredInput>(),
            )

        assertThat(roundtrippedResponseSteerRequiredInput).isEqualTo(responseSteerRequiredInput)
    }

    @Test
    fun ofApplyPatchCallOutput() {
        val applyPatchCallOutput =
            ResponseSteerRequiredInput.ApplyPatchCallOutput.builder().callId("call_id").build()

        val responseSteerRequiredInput =
            ResponseSteerRequiredInput.ofApplyPatchCallOutput(applyPatchCallOutput)

        assertThat(responseSteerRequiredInput.functionCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.customToolCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.computerCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.shellCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.applyPatchCallOutput()).contains(applyPatchCallOutput)
        assertThat(responseSteerRequiredInput.toolSearchOutput()).isEmpty
        assertThat(responseSteerRequiredInput.mcpApprovalResponse()).isEmpty
    }

    @Test
    fun ofApplyPatchCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseSteerRequiredInput =
            ResponseSteerRequiredInput.ofApplyPatchCallOutput(
                ResponseSteerRequiredInput.ApplyPatchCallOutput.builder().callId("call_id").build()
            )

        val roundtrippedResponseSteerRequiredInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseSteerRequiredInput),
                jacksonTypeRef<ResponseSteerRequiredInput>(),
            )

        assertThat(roundtrippedResponseSteerRequiredInput).isEqualTo(responseSteerRequiredInput)
    }

    @Test
    fun ofToolSearchOutput() {
        val toolSearchOutput =
            ResponseSteerRequiredInput.ToolSearchOutput.builder().callId("call_id").build()

        val responseSteerRequiredInput =
            ResponseSteerRequiredInput.ofToolSearchOutput(toolSearchOutput)

        assertThat(responseSteerRequiredInput.functionCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.customToolCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.computerCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.shellCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.applyPatchCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.toolSearchOutput()).contains(toolSearchOutput)
        assertThat(responseSteerRequiredInput.mcpApprovalResponse()).isEmpty
    }

    @Test
    fun ofToolSearchOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseSteerRequiredInput =
            ResponseSteerRequiredInput.ofToolSearchOutput(
                ResponseSteerRequiredInput.ToolSearchOutput.builder().callId("call_id").build()
            )

        val roundtrippedResponseSteerRequiredInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseSteerRequiredInput),
                jacksonTypeRef<ResponseSteerRequiredInput>(),
            )

        assertThat(roundtrippedResponseSteerRequiredInput).isEqualTo(responseSteerRequiredInput)
    }

    @Test
    fun ofMcpApprovalResponse() {
        val mcpApprovalResponse =
            ResponseSteerRequiredInput.McpApprovalResponse.builder()
                .approvalRequestId("approval_request_id")
                .build()

        val responseSteerRequiredInput =
            ResponseSteerRequiredInput.ofMcpApprovalResponse(mcpApprovalResponse)

        assertThat(responseSteerRequiredInput.functionCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.customToolCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.computerCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.shellCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.applyPatchCallOutput()).isEmpty
        assertThat(responseSteerRequiredInput.toolSearchOutput()).isEmpty
        assertThat(responseSteerRequiredInput.mcpApprovalResponse()).contains(mcpApprovalResponse)
    }

    @Test
    fun ofMcpApprovalResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseSteerRequiredInput =
            ResponseSteerRequiredInput.ofMcpApprovalResponse(
                ResponseSteerRequiredInput.McpApprovalResponse.builder()
                    .approvalRequestId("approval_request_id")
                    .build()
            )

        val roundtrippedResponseSteerRequiredInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseSteerRequiredInput),
                jacksonTypeRef<ResponseSteerRequiredInput>(),
            )

        assertThat(roundtrippedResponseSteerRequiredInput).isEqualTo(responseSteerRequiredInput)
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
        val responseSteerRequiredInput =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ResponseSteerRequiredInput>())

        val e = assertThrows<OpenAIInvalidDataException> { responseSteerRequiredInput.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
