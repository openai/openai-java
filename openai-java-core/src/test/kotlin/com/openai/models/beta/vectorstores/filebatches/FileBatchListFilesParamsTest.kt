// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.vectorstores.filebatches

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileBatchListFilesParamsTest {

    @Test
    fun create() {
        FileBatchListFilesParams.builder()
            .vectorStoreId("vector_store_id")
            .batchId("batch_id")
            .after("after")
            .before("before")
            .filter(FileBatchListFilesParams.Filter.IN_PROGRESS)
            .limit(0L)
            .order(FileBatchListFilesParams.Order.ASC)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            FileBatchListFilesParams.builder()
                .vectorStoreId("vector_store_id")
                .batchId("batch_id")
                .after("after")
                .before("before")
                .filter(FileBatchListFilesParams.Filter.IN_PROGRESS)
                .limit(0L)
                .order(FileBatchListFilesParams.Order.ASC)
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("before", "before")
        expected.put("filter", FileBatchListFilesParams.Filter.IN_PROGRESS.toString())
        expected.put("limit", "0")
        expected.put("order", FileBatchListFilesParams.Order.ASC.toString())
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            FileBatchListFilesParams.builder()
                .vectorStoreId("vector_store_id")
                .batchId("batch_id")
                .build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params =
            FileBatchListFilesParams.builder()
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
