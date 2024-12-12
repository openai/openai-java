// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BatchListParamsTest {

    @Test
    fun createBatchListParams() {
        BatchListParams.builder().after("after").limit(0L).build()
    }

    @Test
    fun getQueryParams() {
        val params = BatchListParams.builder().after("after").limit(0L).build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("limit", "0")
        assertThat(params.getQueryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = BatchListParams.builder().build()
        val expected = QueryParams.builder()
        assertThat(params.getQueryParams()).isEqualTo(expected.build())
    }
}
