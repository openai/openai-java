// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StepListParamsTest {

    @Test
    fun create() {
        StepListParams.builder()
            .threadId("thread_id")
            .runId("run_id")
            .after("after")
            .before("before")
            .addInclude(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT)
            .limit(0L)
            .order(StepListParams.Order.ASC)
            .build()
    }

    @Test
    fun pathParams() {
        val params = StepListParams.builder().threadId("thread_id").runId("run_id").build()

        assertThat(params._pathParam(0)).isEqualTo("thread_id")
        assertThat(params._pathParam(1)).isEqualTo("run_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            StepListParams.builder()
                .threadId("thread_id")
                .runId("run_id")
                .after("after")
                .before("before")
                .addInclude(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT)
                .limit(0L)
                .order(StepListParams.Order.ASC)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("include[]", "step_details.tool_calls[*].file_search.results[*].content")
                    .put("limit", "0")
                    .put("order", "asc")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = StepListParams.builder().threadId("thread_id").runId("run_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
