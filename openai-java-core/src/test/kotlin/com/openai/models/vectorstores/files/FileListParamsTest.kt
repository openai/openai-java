// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileListParamsTest {

    @Test
    fun create() {
        FileListParams.builder()
            .vectorStoreId("vector_store_id")
            .after("after")
            .before("before")
            .filter(FileListParams.Filter.IN_PROGRESS)
            .limit(0L)
            .order(FileListParams.Order.ASC)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            FileListParams.builder()
                .vectorStoreId("vector_store_id")
                .after("after")
                .before("before")
                .filter(FileListParams.Filter.IN_PROGRESS)
                .limit(0L)
                .order(FileListParams.Order.ASC)
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("before", "before")
        expected.put("filter", FileListParams.Filter.IN_PROGRESS.toString())
        expected.put("limit", "0")
        expected.put("order", FileListParams.Order.ASC.toString())
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = FileListParams.builder().vectorStoreId("vector_store_id").build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params = FileListParams.builder().vectorStoreId("vector_store_id").build()
        assertThat(params).isNotNull
        // path param "vectorStoreId"
        assertThat(params.getPathParam(0)).isEqualTo("vector_store_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
