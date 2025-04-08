// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs.outputitems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OutputItemRetrieveParamsTest {

    @Test
    fun create() {
        OutputItemRetrieveParams.builder()
            .evalId("eval_id")
            .runId("run_id")
            .outputItemId("output_item_id")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            OutputItemRetrieveParams.builder()
                .evalId("eval_id")
                .runId("run_id")
                .outputItemId("output_item_id")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("eval_id")
        assertThat(params._pathParam(1)).isEqualTo("run_id")
        assertThat(params._pathParam(2)).isEqualTo("output_item_id")
        // out-of-bound path param
        assertThat(params._pathParam(3)).isEqualTo("")
    }
}
