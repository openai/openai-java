// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelRetrieveParamsTest {

    @Test
    fun create() {
        ModelRetrieveParams.builder().model("gpt-5.6-sol").build()
    }

    @Test
    fun pathParams() {
        val params = ModelRetrieveParams.builder().model("gpt-5.6-sol").build()

        assertThat(params._pathParam(0)).isEqualTo("gpt-5.6-sol")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
