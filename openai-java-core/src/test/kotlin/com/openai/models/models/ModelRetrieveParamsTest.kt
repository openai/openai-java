// File generated from our OpenAPI spec by Stainless.

package com.openai.models.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelRetrieveParamsTest {

    @Test
    fun create() {
        ModelRetrieveParams.builder().model("gpt-4o-mini").build()
    }

    @Test
    fun pathParams() {
        val params = ModelRetrieveParams.builder().model("gpt-4o-mini").build()

        assertThat(params._pathParam(0)).isEqualTo("gpt-4o-mini")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
