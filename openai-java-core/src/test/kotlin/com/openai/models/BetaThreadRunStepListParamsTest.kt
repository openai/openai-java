// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaThreadRunStepListParamsTest {

    @Test
    fun create() {
        BetaThreadRunStepListParams.builder()
            .threadId("thread_id")
            .runId("run_id")
            .after("after")
            .before("before")
            .addInclude(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT)
            .limit(0L)
            .order(BetaThreadRunStepListParams.Order.ASC)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            BetaThreadRunStepListParams.builder()
                .threadId("thread_id")
                .runId("run_id")
                .after("after")
                .before("before")
                .addInclude(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT)
                .limit(0L)
                .order(BetaThreadRunStepListParams.Order.ASC)
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("before", "before")
        expected.put(
            "include[]",
            RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT.toString(),
        )
        expected.put("limit", "0")
        expected.put("order", BetaThreadRunStepListParams.Order.ASC.toString())
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            BetaThreadRunStepListParams.builder().threadId("thread_id").runId("run_id").build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params =
            BetaThreadRunStepListParams.builder().threadId("thread_id").runId("run_id").build()
        assertThat(params).isNotNull
        // path param "threadId"
        assertThat(params.getPathParam(0)).isEqualTo("thread_id")
        // path param "runId"
        assertThat(params.getPathParam(1)).isEqualTo("run_id")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
