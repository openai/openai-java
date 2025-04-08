// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalDeleteParamsTest {

    @Test
    fun create() {
        EvalDeleteParams.builder().evalId("eval_id").build()
    }

    @Test
    fun pathParams() {
        val params = EvalDeleteParams.builder().evalId("eval_id").build()

        assertThat(params._pathParam(0)).isEqualTo("eval_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
