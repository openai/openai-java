// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaVectorStoreFileBatchListFilesParamsTest {

    @Test
    fun create() {
        BetaVectorStoreFileBatchListFilesParams.builder()
            .vectorStoreId("vector_store_id")
            .batchId("batch_id")
            .after("after")
            .before("before")
            .filter(BetaVectorStoreFileBatchListFilesParams.Filter.IN_PROGRESS)
            .limit(0L)
            .order(BetaVectorStoreFileBatchListFilesParams.Order.ASC)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            BetaVectorStoreFileBatchListFilesParams.builder()
                .vectorStoreId("vector_store_id")
                .batchId("batch_id")
                .after("after")
                .before("before")
                .filter(BetaVectorStoreFileBatchListFilesParams.Filter.IN_PROGRESS)
                .limit(0L)
                .order(BetaVectorStoreFileBatchListFilesParams.Order.ASC)
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("before", "before")
        expected.put(
            "filter",
            BetaVectorStoreFileBatchListFilesParams.Filter.IN_PROGRESS.toString()
        )
        expected.put("limit", "0")
        expected.put("order", BetaVectorStoreFileBatchListFilesParams.Order.ASC.toString())
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            BetaVectorStoreFileBatchListFilesParams.builder()
                .vectorStoreId("vector_store_id")
                .batchId("batch_id")
                .build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params =
            BetaVectorStoreFileBatchListFilesParams.builder()
                .vectorStoreId("vector_store_id")
                .batchId("batch_id")
                .build()
        assertThat(params).isNotNull
        // path param "vectorStoreId"
        assertThat(params.getPathParam(0)).isEqualTo("vector_store_id")
        // path param "batchId"
        assertThat(params.getPathParam(1)).isEqualTo("batch_id")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
