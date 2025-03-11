// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseDeleteParamsTest {

    @Test
    fun create() {
        ResponseDeleteParams.builder().responseId("resp_677efb5139a88190b512bc3fef8e535d").build()
    }

    @Test
    fun getPathParam() {
        val params =
            ResponseDeleteParams.builder()
                .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                .build()
        assertThat(params).isNotNull
        // path param "responseId"
        assertThat(params.getPathParam(0)).isEqualTo("resp_677efb5139a88190b512bc3fef8e535d")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
