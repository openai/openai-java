// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaFileSearchToolTest {

    @Test
    fun create() {
        val betaFileSearchTool =
            BetaFileSearchTool.builder()
                .addVectorStoreId("string")
                .filters(
                    BetaFileSearchTool.Filters.ComparisonFilter.builder()
                        .key("key")
                        .type(BetaFileSearchTool.Filters.ComparisonFilter.Type.EQ)
                        .value("string")
                        .build()
                )
                .maxNumResults(0L)
                .rankingOptions(
                    BetaFileSearchTool.RankingOptions.builder()
                        .hybridSearch(
                            BetaFileSearchTool.RankingOptions.HybridSearch.builder()
                                .embeddingWeight(0.0)
                                .textWeight(0.0)
                                .build()
                        )
                        .ranker(BetaFileSearchTool.RankingOptions.Ranker.AUTO)
                        .scoreThreshold(0.0)
                        .build()
                )
                .build()

        assertThat(betaFileSearchTool.vectorStoreIds()).containsExactly("string")
        assertThat(betaFileSearchTool.filters())
            .contains(
                BetaFileSearchTool.Filters.ofComparisonFilter(
                    BetaFileSearchTool.Filters.ComparisonFilter.builder()
                        .key("key")
                        .type(BetaFileSearchTool.Filters.ComparisonFilter.Type.EQ)
                        .value("string")
                        .build()
                )
            )
        assertThat(betaFileSearchTool.maxNumResults()).contains(0L)
        assertThat(betaFileSearchTool.rankingOptions())
            .contains(
                BetaFileSearchTool.RankingOptions.builder()
                    .hybridSearch(
                        BetaFileSearchTool.RankingOptions.HybridSearch.builder()
                            .embeddingWeight(0.0)
                            .textWeight(0.0)
                            .build()
                    )
                    .ranker(BetaFileSearchTool.RankingOptions.Ranker.AUTO)
                    .scoreThreshold(0.0)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaFileSearchTool =
            BetaFileSearchTool.builder()
                .addVectorStoreId("string")
                .filters(
                    BetaFileSearchTool.Filters.ComparisonFilter.builder()
                        .key("key")
                        .type(BetaFileSearchTool.Filters.ComparisonFilter.Type.EQ)
                        .value("string")
                        .build()
                )
                .maxNumResults(0L)
                .rankingOptions(
                    BetaFileSearchTool.RankingOptions.builder()
                        .hybridSearch(
                            BetaFileSearchTool.RankingOptions.HybridSearch.builder()
                                .embeddingWeight(0.0)
                                .textWeight(0.0)
                                .build()
                        )
                        .ranker(BetaFileSearchTool.RankingOptions.Ranker.AUTO)
                        .scoreThreshold(0.0)
                        .build()
                )
                .build()

        val roundtrippedBetaFileSearchTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaFileSearchTool),
                jacksonTypeRef<BetaFileSearchTool>(),
            )

        assertThat(roundtrippedBetaFileSearchTool).isEqualTo(betaFileSearchTool)
    }
}
