// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ComparisonFilter
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ToolTest {

    @Test
    fun ofFileSearch() {
        val fileSearch =
            FileSearchTool.builder()
                .addVectorStoreId("string")
                .filters(
                    ComparisonFilter.builder()
                        .key("key")
                        .type(ComparisonFilter.Type.EQ)
                        .value("string")
                        .build()
                )
                .maxNumResults(0L)
                .rankingOptions(
                    FileSearchTool.RankingOptions.builder()
                        .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                        .scoreThreshold(0.0)
                        .build()
                )
                .build()

        val tool = Tool.ofFileSearch(fileSearch)

        assertThat(tool.fileSearch()).contains(fileSearch)
        assertThat(tool.function()).isEmpty
        assertThat(tool.webSearch()).isEmpty
        assertThat(tool.computerUsePreview()).isEmpty
    }

    @Test
    fun ofFileSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool =
            Tool.ofFileSearch(
                FileSearchTool.builder()
                    .addVectorStoreId("string")
                    .filters(
                        ComparisonFilter.builder()
                            .key("key")
                            .type(ComparisonFilter.Type.EQ)
                            .value("string")
                            .build()
                    )
                    .maxNumResults(0L)
                    .rankingOptions(
                        FileSearchTool.RankingOptions.builder()
                            .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                            .scoreThreshold(0.0)
                            .build()
                    )
                    .build()
            )

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
    }

    @Test
    fun ofFunction() {
        val function =
            FunctionTool.builder()
                .name("name")
                .parameters(
                    FunctionTool.Parameters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .strict(true)
                .description("description")
                .build()

        val tool = Tool.ofFunction(function)

        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.function()).contains(function)
        assertThat(tool.webSearch()).isEmpty
        assertThat(tool.computerUsePreview()).isEmpty
    }

    @Test
    fun ofFunctionRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool =
            Tool.ofFunction(
                FunctionTool.builder()
                    .name("name")
                    .parameters(
                        FunctionTool.Parameters.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .strict(true)
                    .description("description")
                    .build()
            )

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
    }

    @Test
    fun ofWebSearch() {
        val webSearch =
            WebSearchTool.builder()
                .type(WebSearchTool.Type.WEB_SEARCH_PREVIEW)
                .searchContextSize(WebSearchTool.SearchContextSize.LOW)
                .userLocation(
                    WebSearchTool.UserLocation.builder()
                        .city("city")
                        .country("country")
                        .region("region")
                        .timezone("timezone")
                        .build()
                )
                .build()

        val tool = Tool.ofWebSearch(webSearch)

        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.function()).isEmpty
        assertThat(tool.webSearch()).contains(webSearch)
        assertThat(tool.computerUsePreview()).isEmpty
    }

    @Test
    fun ofWebSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool =
            Tool.ofWebSearch(
                WebSearchTool.builder()
                    .type(WebSearchTool.Type.WEB_SEARCH_PREVIEW)
                    .searchContextSize(WebSearchTool.SearchContextSize.LOW)
                    .userLocation(
                        WebSearchTool.UserLocation.builder()
                            .city("city")
                            .country("country")
                            .region("region")
                            .timezone("timezone")
                            .build()
                    )
                    .build()
            )

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
    }

    @Test
    fun ofComputerUsePreview() {
        val computerUsePreview =
            ComputerTool.builder()
                .displayHeight(0L)
                .displayWidth(0L)
                .environment(ComputerTool.Environment.WINDOWS)
                .build()

        val tool = Tool.ofComputerUsePreview(computerUsePreview)

        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.function()).isEmpty
        assertThat(tool.webSearch()).isEmpty
        assertThat(tool.computerUsePreview()).contains(computerUsePreview)
    }

    @Test
    fun ofComputerUsePreviewRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool =
            Tool.ofComputerUsePreview(
                ComputerTool.builder()
                    .displayHeight(0L)
                    .displayWidth(0L)
                    .environment(ComputerTool.Environment.WINDOWS)
                    .build()
            )

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
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
        val tool = jsonMapper().convertValue(testCase.value, jacksonTypeRef<Tool>())

        val e = assertThrows<OpenAIInvalidDataException> { tool.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
