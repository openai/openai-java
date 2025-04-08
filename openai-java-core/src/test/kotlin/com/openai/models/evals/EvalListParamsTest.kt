// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalListParamsTest {

    @Test
    fun create() {
        EvalListParams.builder()
            .after("after")
            .limit(0L)
            .order(EvalListParams.Order.ASC)
            .orderBy(EvalListParams.OrderBy.CREATED_AT)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            EvalListParams.builder()
                .after("after")
                .limit(0L)
                .order(EvalListParams.Order.ASC)
                .orderBy(EvalListParams.OrderBy.CREATED_AT)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("limit", "0")
                    .put("order", "asc")
                    .put("order_by", "created_at")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = EvalListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
