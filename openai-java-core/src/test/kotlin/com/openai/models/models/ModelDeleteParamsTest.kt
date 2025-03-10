// File generated from our OpenAPI spec by Stainless.

package com.openai.models.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ModelDeleteParamsTest {

    @Test
    fun create() {
        ModelDeleteParams.builder().model("ft:gpt-4o-mini:acemeco:suffix:abc123").build()
    }

    @Test
    fun getPathParam() {
        val params =
            ModelDeleteParams.builder().model("ft:gpt-4o-mini:acemeco:suffix:abc123").build()
        assertThat(params).isNotNull
        // path param "model"
        assertThat(params.getPathParam(0)).isEqualTo("ft:gpt-4o-mini:acemeco:suffix:abc123")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
