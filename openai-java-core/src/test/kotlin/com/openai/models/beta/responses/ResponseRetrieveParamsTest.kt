// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseRetrieveParamsTest {

    @Test
    fun create() {
        ResponseRetrieveParams.builder()
            .responseId("resp_677efb5139a88190b512bc3fef8e535d")
            .addInclude(BetaResponseIncludable.FILE_SEARCH_CALL_RESULTS)
            .includeObfuscation(true)
            .startingAfter(0L)
            .addBeta(ResponseRetrieveParams.Beta.RESPONSES_MULTI_AGENT_V1)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ResponseRetrieveParams.builder()
                .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("resp_677efb5139a88190b512bc3fef8e535d")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            ResponseRetrieveParams.builder()
                .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                .addInclude(BetaResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                .includeObfuscation(true)
                .startingAfter(0L)
                .addBeta(ResponseRetrieveParams.Beta.RESPONSES_MULTI_AGENT_V1)
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("openai-beta", "responses_multi_agent=v1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            ResponseRetrieveParams.builder()
                .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun queryParams() {
        val params =
            ResponseRetrieveParams.builder()
                .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                .addInclude(BetaResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                .includeObfuscation(true)
                .startingAfter(0L)
                .addBeta(ResponseRetrieveParams.Beta.RESPONSES_MULTI_AGENT_V1)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("include[]", "file_search_call.results")
                    .put("include_obfuscation", "true")
                    .put("starting_after", "0")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ResponseRetrieveParams.builder()
                .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
