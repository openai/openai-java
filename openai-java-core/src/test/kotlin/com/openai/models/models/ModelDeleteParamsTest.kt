// File generated from our OpenAPI spec by Stainless.

package com.openai.models.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelDeleteParamsTest {

    @Test
    fun create() {
        ModelDeleteParams.builder().model("ft:gpt-4o-mini:acemeco:suffix:abc123").build()
    }

    @Test
    fun pathParams() {
        val params =
            ModelDeleteParams.builder().model("ft:gpt-4o-mini:acemeco:suffix:abc123").build()

        assertThat(params._pathParam(0)).isEqualTo("ft:gpt-4o-mini:acemeco:suffix:abc123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
