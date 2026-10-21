// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.ComparisonFilter
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileSearchToolTest {

    @Test
    fun createAndRoundtrip() {
        val fileSearchTool =
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
                        .hybridSearch(
                            FileSearchTool.RankingOptions.HybridSearch.builder()
                                .embeddingWeight(0.0)
                                .textWeight(0.0)
                                .build()
                        )
                        .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                        .scoreThreshold(0.0)
                        .build()
                )
                .build()

        assertThat(fileSearchTool.vectorStoreIds()).containsExactly("string")
        assertThat(fileSearchTool.filters())
            .contains(
                FileSearchTool.Filters.ofComparisonFilter(
                    ComparisonFilter.builder()
                        .key("key")
                        .type(ComparisonFilter.Type.EQ)
                        .value("string")
                        .build()
                )
            )
        assertThat(fileSearchTool.maxNumResults()).contains(0L)
        assertThat(fileSearchTool.rankingOptions())
            .contains(
                FileSearchTool.RankingOptions.builder()
                    .hybridSearch(
                        FileSearchTool.RankingOptions.HybridSearch.builder()
                            .embeddingWeight(0.0)
                            .textWeight(0.0)
                            .build()
                    )
                    .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                    .scoreThreshold(0.0)
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedFileSearchTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileSearchTool),
                jacksonTypeRef<FileSearchTool>(),
            )

        assertThat(roundtrippedFileSearchTool).isEqualTo(fileSearchTool)
    }
}
