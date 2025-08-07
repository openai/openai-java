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

internal class ToolCallTest {

    @Test
    fun ofCodeInterpreter() {
        val codeInterpreter =
            CodeInterpreterToolCall.builder()
                .id("id")
                .codeInterpreter(
                    CodeInterpreterToolCall.CodeInterpreter.builder()
                        .input("input")
                        .addLogsOutput("logs")
                        .build()
                )
                .build()

        val toolCall = ToolCall.ofCodeInterpreter(codeInterpreter)

        assertThat(toolCall.codeInterpreter()).contains(codeInterpreter)
        assertThat(toolCall.fileSearch()).isEmpty
        assertThat(toolCall.function()).isEmpty
    }

    @Test
    fun ofCodeInterpreterRoundtrip() {
        val jsonMapper = jsonMapper()
        val toolCall =
            ToolCall.ofCodeInterpreter(
                CodeInterpreterToolCall.builder()
                    .id("id")
                    .codeInterpreter(
                        CodeInterpreterToolCall.CodeInterpreter.builder()
                            .input("input")
                            .addLogsOutput("logs")
                            .build()
                    )
                    .build()
            )

        val roundtrippedToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolCall),
                jacksonTypeRef<ToolCall>(),
            )

        assertThat(roundtrippedToolCall).isEqualTo(toolCall)
    }

    @Test
    fun ofFileSearch() {
        val fileSearch =
            FileSearchToolCall.builder()
                .id("id")
                .fileSearch(
                    FileSearchToolCall.FileSearch.builder()
                        .rankingOptions(
                            FileSearchToolCall.FileSearch.RankingOptions.builder()
                                .ranker(FileSearchToolCall.FileSearch.RankingOptions.Ranker.AUTO)
                                .scoreThreshold(0.0)
                                .build()
                        )
                        .addResult(
                            FileSearchToolCall.FileSearch.Result.builder()
                                .fileId("file_id")
                                .fileName("file_name")
                                .score(0.0)
                                .addContent(
                                    FileSearchToolCall.FileSearch.Result.Content.builder()
                                        .text("text")
                                        .type(
                                            FileSearchToolCall.FileSearch.Result.Content.Type.TEXT
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        val toolCall = ToolCall.ofFileSearch(fileSearch)

        assertThat(toolCall.codeInterpreter()).isEmpty
        assertThat(toolCall.fileSearch()).contains(fileSearch)
        assertThat(toolCall.function()).isEmpty
    }

    @Test
    fun ofFileSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val toolCall =
            ToolCall.ofFileSearch(
                FileSearchToolCall.builder()
                    .id("id")
                    .fileSearch(
                        FileSearchToolCall.FileSearch.builder()
                            .rankingOptions(
                                FileSearchToolCall.FileSearch.RankingOptions.builder()
                                    .ranker(
                                        FileSearchToolCall.FileSearch.RankingOptions.Ranker.AUTO
                                    )
                                    .scoreThreshold(0.0)
                                    .build()
                            )
                            .addResult(
                                FileSearchToolCall.FileSearch.Result.builder()
                                    .fileId("file_id")
                                    .fileName("file_name")
                                    .score(0.0)
                                    .addContent(
                                        FileSearchToolCall.FileSearch.Result.Content.builder()
                                            .text("text")
                                            .type(
                                                FileSearchToolCall.FileSearch.Result.Content.Type
                                                    .TEXT
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolCall),
                jacksonTypeRef<ToolCall>(),
            )

        assertThat(roundtrippedToolCall).isEqualTo(toolCall)
    }

    @Test
    fun ofFunction() {
        val function =
            FunctionToolCall.builder()
                .id("id")
                .function(
                    FunctionToolCall.Function.builder()
                        .arguments("arguments")
                        .name("name")
                        .output("output")
                        .build()
                )
                .build()

        val toolCall = ToolCall.ofFunction(function)

        assertThat(toolCall.codeInterpreter()).isEmpty
        assertThat(toolCall.fileSearch()).isEmpty
        assertThat(toolCall.function()).contains(function)
    }

    @Test
    fun ofFunctionRoundtrip() {
        val jsonMapper = jsonMapper()
        val toolCall =
            ToolCall.ofFunction(
                FunctionToolCall.builder()
                    .id("id")
                    .function(
                        FunctionToolCall.Function.builder()
                            .arguments("arguments")
                            .name("name")
                            .output("output")
                            .build()
                    )
                    .build()
            )

        val roundtrippedToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolCall),
                jacksonTypeRef<ToolCall>(),
            )

        assertThat(roundtrippedToolCall).isEqualTo(toolCall)
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
        val toolCall = jsonMapper().convertValue(testCase.value, jacksonTypeRef<ToolCall>())

        val e = assertThrows<OpenAIInvalidDataException> { toolCall.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
