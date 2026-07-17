// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.openai.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCancelParamsTest {

    @Test
    fun create() {
        ResponseCancelParams.builder()
            .responseId("resp_677efb5139a88190b512bc3fef8e535d")
            .addBeta(ResponseCancelParams.Beta.RESPONSES_MULTI_AGENT_V1)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ResponseCancelParams.builder()
                .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("resp_677efb5139a88190b512bc3fef8e535d")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            ResponseCancelParams.builder()
                .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                .addBeta(ResponseCancelParams.Beta.RESPONSES_MULTI_AGENT_V1)
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("openai-beta", "responses_multi_agent=v1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            ResponseCancelParams.builder()
                .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }
}
