// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.FunctionDefinition
import com.openai.models.FunctionParameters
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AssistantToolTest {

    @Test
    fun ofCodeInterpreter() {
        val codeInterpreter = CodeInterpreterTool.builder().build()

        val assistantTool = AssistantTool.ofCodeInterpreter(codeInterpreter)

        assertThat(assistantTool.codeInterpreter()).contains(codeInterpreter)
        assertThat(assistantTool.fileSearch()).isEmpty
        assertThat(assistantTool.function()).isEmpty
    }

    @Test
    fun ofCodeInterpreterRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantTool = AssistantTool.ofCodeInterpreter(CodeInterpreterTool.builder().build())

        val roundtrippedAssistantTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantTool),
                jacksonTypeRef<AssistantTool>(),
            )

        assertThat(roundtrippedAssistantTool).isEqualTo(assistantTool)
    }

    @Test
    fun ofFileSearch() {
        val fileSearch =
            FileSearchTool.builder()
                .fileSearch(
                    FileSearchTool.FileSearch.builder()
                        .maxNumResults(1L)
                        .rankingOptions(
                            FileSearchTool.FileSearch.RankingOptions.builder()
                                .scoreThreshold(0.0)
                                .ranker(FileSearchTool.FileSearch.RankingOptions.Ranker.AUTO)
                                .build()
                        )
                        .build()
                )
                .build()

        val assistantTool = AssistantTool.ofFileSearch(fileSearch)

        assertThat(assistantTool.codeInterpreter()).isEmpty
        assertThat(assistantTool.fileSearch()).contains(fileSearch)
        assertThat(assistantTool.function()).isEmpty
    }

    @Test
    fun ofFileSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantTool =
            AssistantTool.ofFileSearch(
                FileSearchTool.builder()
                    .fileSearch(
                        FileSearchTool.FileSearch.builder()
                            .maxNumResults(1L)
                            .rankingOptions(
                                FileSearchTool.FileSearch.RankingOptions.builder()
                                    .scoreThreshold(0.0)
                                    .ranker(FileSearchTool.FileSearch.RankingOptions.Ranker.AUTO)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedAssistantTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantTool),
                jacksonTypeRef<AssistantTool>(),
            )

        assertThat(roundtrippedAssistantTool).isEqualTo(assistantTool)
    }

    @Test
    fun ofFunction() {
        val function =
            FunctionTool.builder()
                .function(
                    FunctionDefinition.builder()
                        .name("name")
                        .description("description")
                        .parameters(
                            FunctionParameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .build()
                )
                .build()

        val assistantTool = AssistantTool.ofFunction(function)

        assertThat(assistantTool.codeInterpreter()).isEmpty
        assertThat(assistantTool.fileSearch()).isEmpty
        assertThat(assistantTool.function()).contains(function)
    }

    @Test
    fun ofFunctionRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantTool =
            AssistantTool.ofFunction(
                FunctionTool.builder()
                    .function(
                        FunctionDefinition.builder()
                            .name("name")
                            .description("description")
                            .parameters(
                                FunctionParameters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .strict(true)
                            .build()
                    )
                    .build()
            )

        val roundtrippedAssistantTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantTool),
                jacksonTypeRef<AssistantTool>(),
            )

        assertThat(roundtrippedAssistantTool).isEqualTo(assistantTool)
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
        val assistantTool =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AssistantTool>())

        val e = assertThrows<OpenAIInvalidDataException> { assistantTool.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
