// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RunRetrieveParamsTest {

    @Test
    fun create() {
        RunRetrieveParams.builder().evalId("eval_id").runId("run_id").build()
    }

    @Test
    fun pathParams() {
        val params = RunRetrieveParams.builder().evalId("eval_id").runId("run_id").build()

        assertThat(params._pathParam(0)).isEqualTo("eval_id")
        assertThat(params._pathParam(1)).isEqualTo("run_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
