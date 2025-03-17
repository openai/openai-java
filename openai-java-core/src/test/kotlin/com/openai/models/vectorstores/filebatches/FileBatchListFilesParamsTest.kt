// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.filebatches

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileBatchListFilesParamsTest {

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

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("filter", "in_progress")
                    .put("limit", "0")
                    .put("order", "asc")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            FileBatchListFilesParams.builder()
                .vectorStoreId("vector_store_id")
                .batchId("batch_id")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
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
