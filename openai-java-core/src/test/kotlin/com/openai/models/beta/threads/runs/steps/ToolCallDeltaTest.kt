// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ToolCallDeltaTest {

    @Test
    fun ofCodeInterpreter() {
        val codeInterpreter =
            CodeInterpreterToolCallDelta.builder()
                .index(0L)
                .id("id")
                .codeInterpreter(
                    CodeInterpreterToolCallDelta.CodeInterpreter.builder()
                        .input("input")
                        .addOutput(CodeInterpreterLogs.builder().index(0L).logs("logs").build())
                        .build()
                )
                .build()

        val toolCallDelta = ToolCallDelta.ofCodeInterpreter(codeInterpreter)

        assertThat(toolCallDelta.codeInterpreter()).contains(codeInterpreter)
        assertThat(toolCallDelta.fileSearch()).isEmpty
        assertThat(toolCallDelta.function()).isEmpty
    }

    @Test
    fun ofCodeInterpreterRoundtrip() {
        val jsonMapper = jsonMapper()
        val toolCallDelta =
            ToolCallDelta.ofCodeInterpreter(
                CodeInterpreterToolCallDelta.builder()
                    .index(0L)
                    .id("id")
                    .codeInterpreter(
                        CodeInterpreterToolCallDelta.CodeInterpreter.builder()
                            .input("input")
                            .addOutput(CodeInterpreterLogs.builder().index(0L).logs("logs").build())
                            .build()
                    )
                    .build()
            )

        val roundtrippedToolCallDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolCallDelta),
                jacksonTypeRef<ToolCallDelta>(),
            )

        assertThat(roundtrippedToolCallDelta).isEqualTo(toolCallDelta)
    }

    @Test
    fun ofFileSearch() {
        val fileSearch =
            FileSearchToolCallDelta.builder()
                .fileSearch(JsonValue.from(mapOf<String, Any>()))
                .index(0L)
                .id("id")
                .build()

        val toolCallDelta = ToolCallDelta.ofFileSearch(fileSearch)

        assertThat(toolCallDelta.codeInterpreter()).isEmpty
        assertThat(toolCallDelta.fileSearch()).contains(fileSearch)
        assertThat(toolCallDelta.function()).isEmpty
    }

    @Test
    fun ofFileSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val toolCallDelta =
            ToolCallDelta.ofFileSearch(
                FileSearchToolCallDelta.builder()
                    .fileSearch(JsonValue.from(mapOf<String, Any>()))
                    .index(0L)
                    .id("id")
                    .build()
            )

        val roundtrippedToolCallDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolCallDelta),
                jacksonTypeRef<ToolCallDelta>(),
            )

        assertThat(roundtrippedToolCallDelta).isEqualTo(toolCallDelta)
    }

    @Test
    fun ofFunction() {
        val function =
            FunctionToolCallDelta.builder()
                .index(0L)
                .id("id")
                .function(
                    FunctionToolCallDelta.Function.builder()
                        .arguments("arguments")
                        .name("name")
                        .output("output")
                        .build()
                )
                .build()

        val toolCallDelta = ToolCallDelta.ofFunction(function)

        assertThat(toolCallDelta.codeInterpreter()).isEmpty
        assertThat(toolCallDelta.fileSearch()).isEmpty
        assertThat(toolCallDelta.function()).contains(function)
    }

    @Test
    fun ofFunctionRoundtrip() {
        val jsonMapper = jsonMapper()
        val toolCallDelta =
            ToolCallDelta.ofFunction(
                FunctionToolCallDelta.builder()
                    .index(0L)
                    .id("id")
                    .function(
                        FunctionToolCallDelta.Function.builder()
                            .arguments("arguments")
                            .name("name")
                            .output("output")
                            .build()
                    )
                    .build()
            )

        val roundtrippedToolCallDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolCallDelta),
                jacksonTypeRef<ToolCallDelta>(),
            )

        assertThat(roundtrippedToolCallDelta).isEqualTo(toolCallDelta)
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
        val toolCallDelta =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ToolCallDelta>())

        val e = assertThrows<OpenAIInvalidDataException> { toolCallDelta.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
