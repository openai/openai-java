// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.vectorstores

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VectorStoreListParamsTest {

    @Test
    fun create() {
        VectorStoreListParams.builder()
            .after("after")
            .before("before")
            .limit(0L)
            .order(VectorStoreListParams.Order.ASC)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            VectorStoreListParams.builder()
                .after("after")
                .before("before")
                .limit(0L)
                .order(VectorStoreListParams.Order.ASC)
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("before", "before")
        expected.put("limit", "0")
        expected.put("order", VectorStoreListParams.Order.ASC.toString())
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = VectorStoreListParams.builder().build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }
}
