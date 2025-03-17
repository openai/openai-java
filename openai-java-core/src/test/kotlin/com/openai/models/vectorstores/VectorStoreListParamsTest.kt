// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VectorStoreListParamsTest {

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

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("limit", "0")
                    .put("order", "asc")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = VectorStoreListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
