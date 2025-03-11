// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.openai.models.ComparisonFilter
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VectorStoreSearchParamsTest {

    @Test
    fun create() {
        VectorStoreSearchParams.builder()
            .vectorStoreId("vs_abc123")
            .query("string")
            .filters(
                ComparisonFilter.builder()
                    .key("key")
                    .type(ComparisonFilter.Type.EQ)
                    .value("string")
                    .build()
            )
            .maxNumResults(1L)
            .rankingOptions(
                VectorStoreSearchParams.RankingOptions.builder()
                    .ranker(VectorStoreSearchParams.RankingOptions.Ranker.AUTO)
                    .scoreThreshold(0.0)
                    .build()
            )
            .rewriteQuery(true)
            .build()
    }

    @Test
    fun body() {
        val params =
            VectorStoreSearchParams.builder()
                .vectorStoreId("vs_abc123")
                .query("string")
                .filters(
                    ComparisonFilter.builder()
                        .key("key")
                        .type(ComparisonFilter.Type.EQ)
                        .value("string")
                        .build()
                )
                .maxNumResults(1L)
                .rankingOptions(
                    VectorStoreSearchParams.RankingOptions.builder()
                        .ranker(VectorStoreSearchParams.RankingOptions.Ranker.AUTO)
                        .scoreThreshold(0.0)
                        .build()
                )
                .rewriteQuery(true)
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.query()).isEqualTo(VectorStoreSearchParams.Query.ofString("string"))
        assertThat(body.filters())
            .contains(
                VectorStoreSearchParams.Filters.ofComparisonFilter(
                    ComparisonFilter.builder()
                        .key("key")
                        .type(ComparisonFilter.Type.EQ)
                        .value("string")
                        .build()
                )
            )
        assertThat(body.maxNumResults()).contains(1L)
        assertThat(body.rankingOptions())
            .contains(
                VectorStoreSearchParams.RankingOptions.builder()
                    .ranker(VectorStoreSearchParams.RankingOptions.Ranker.AUTO)
                    .scoreThreshold(0.0)
                    .build()
            )
        assertThat(body.rewriteQuery()).contains(true)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            VectorStoreSearchParams.builder().vectorStoreId("vs_abc123").query("string").build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.query()).isEqualTo(VectorStoreSearchParams.Query.ofString("string"))
    }

    @Test
    fun getPathParam() {
        val params =
            VectorStoreSearchParams.builder().vectorStoreId("vs_abc123").query("string").build()
        assertThat(params).isNotNull
        // path param "vectorStoreId"
        assertThat(params.getPathParam(0)).isEqualTo("vs_abc123")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
