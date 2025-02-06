// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaVectorStoreFileListParamsTest {

    @Test
    fun create() {
        BetaVectorStoreFileListParams.builder()
            .vectorStoreId("vector_store_id")
            .after("after")
            .before("before")
            .filter(BetaVectorStoreFileListParams.Filter.IN_PROGRESS)
            .limit(0L)
            .order(BetaVectorStoreFileListParams.Order.ASC)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            BetaVectorStoreFileListParams.builder()
                .vectorStoreId("vector_store_id")
                .after("after")
                .before("before")
                .filter(BetaVectorStoreFileListParams.Filter.IN_PROGRESS)
                .limit(0L)
                .order(BetaVectorStoreFileListParams.Order.ASC)
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("before", "before")
        expected.put("filter", BetaVectorStoreFileListParams.Filter.IN_PROGRESS.toString())
        expected.put("limit", "0")
        expected.put("order", BetaVectorStoreFileListParams.Order.ASC.toString())
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            BetaVectorStoreFileListParams.builder().vectorStoreId("vector_store_id").build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params =
            BetaVectorStoreFileListParams.builder().vectorStoreId("vector_store_id").build()
        assertThat(params).isNotNull
        // path param "vectorStoreId"
        assertThat(params.getPathParam(0)).isEqualTo("vector_store_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
