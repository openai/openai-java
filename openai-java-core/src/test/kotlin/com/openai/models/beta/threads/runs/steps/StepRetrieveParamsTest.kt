// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StepRetrieveParamsTest {

    @Test
    fun create() {
        StepRetrieveParams.builder()
            .threadId("thread_id")
            .runId("run_id")
            .stepId("step_id")
            .addInclude(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            StepRetrieveParams.builder()
                .threadId("thread_id")
                .runId("run_id")
                .stepId("step_id")
                .addInclude(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT)
                .build()
        val expected = QueryParams.builder()
        expected.put(
            "include[]",
            RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT.toString(),
        )
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            StepRetrieveParams.builder()
                .threadId("thread_id")
                .runId("run_id")
                .stepId("step_id")
                .build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params =
            StepRetrieveParams.builder()
                .threadId("thread_id")
                .runId("run_id")
                .stepId("step_id")
                .build()
        assertThat(params).isNotNull
        // path param "threadId"
        assertThat(params.getPathParam(0)).isEqualTo("thread_id")
        // path param "runId"
        assertThat(params.getPathParam(1)).isEqualTo("run_id")
        // path param "stepId"
        assertThat(params.getPathParam(2)).isEqualTo("step_id")
        // out-of-bound path param
        assertThat(params.getPathParam(3)).isEqualTo("")
    }
}
