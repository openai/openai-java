// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RunListParamsTest {

    @Test
    fun create() {
        RunListParams.builder()
            .evalId("eval_id")
            .after("after")
            .limit(0L)
            .order(RunListParams.Order.ASC)
            .status(RunListParams.Status.QUEUED)
            .build()
    }

    @Test
    fun pathParams() {
        val params = RunListParams.builder().evalId("eval_id").build()

        assertThat(params._pathParam(0)).isEqualTo("eval_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            RunListParams.builder()
                .evalId("eval_id")
                .after("after")
                .limit(0L)
                .order(RunListParams.Order.ASC)
                .status(RunListParams.Status.QUEUED)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("limit", "0")
                    .put("order", "asc")
                    .put("status", "queued")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = RunListParams.builder().evalId("eval_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
