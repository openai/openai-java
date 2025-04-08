// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs.outputitems

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OutputItemListParamsTest {

    @Test
    fun create() {
        OutputItemListParams.builder()
            .evalId("eval_id")
            .runId("run_id")
            .after("after")
            .limit(0L)
            .order(OutputItemListParams.Order.ASC)
            .status(OutputItemListParams.Status.FAIL)
            .build()
    }

    @Test
    fun pathParams() {
        val params = OutputItemListParams.builder().evalId("eval_id").runId("run_id").build()

        assertThat(params._pathParam(0)).isEqualTo("eval_id")
        assertThat(params._pathParam(1)).isEqualTo("run_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            OutputItemListParams.builder()
                .evalId("eval_id")
                .runId("run_id")
                .after("after")
                .limit(0L)
                .order(OutputItemListParams.Order.ASC)
                .status(OutputItemListParams.Status.FAIL)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("limit", "0")
                    .put("order", "asc")
                    .put("status", "fail")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = OutputItemListParams.builder().evalId("eval_id").runId("run_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
