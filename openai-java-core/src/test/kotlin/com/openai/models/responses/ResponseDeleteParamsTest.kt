// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseDeleteParamsTest {

    @Test
    fun create() {
        ResponseDeleteParams.builder().responseId("resp_677efb5139a88190b512bc3fef8e535d").build()
    }

    @Test
    fun pathParams() {
        val params =
            ResponseDeleteParams.builder()
                .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("resp_677efb5139a88190b512bc3fef8e535d")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
