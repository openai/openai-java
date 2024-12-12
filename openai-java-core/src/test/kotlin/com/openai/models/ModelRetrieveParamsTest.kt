// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ModelRetrieveParamsTest {

    @Test
    fun createModelRetrieveParams() {
        ModelRetrieveParams.builder().model("gpt-4o-mini").build()
    }

    @Test
    fun getPathParam() {
        val params = ModelRetrieveParams.builder().model("gpt-4o-mini").build()
        assertThat(params).isNotNull
        // path param "model"
        assertThat(params.getPathParam(0)).isEqualTo("gpt-4o-mini")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
