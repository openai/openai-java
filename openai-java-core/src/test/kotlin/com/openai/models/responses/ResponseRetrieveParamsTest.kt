// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseRetrieveParamsTest {

    @Test
    fun create() {
        ResponseRetrieveParams.builder()
            .responseId("resp_677efb5139a88190b512bc3fef8e535d")
            .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ResponseRetrieveParams.builder()
                .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                .build()
        val expected = QueryParams.builder()
        expected.put("include[]", ResponseIncludable.FILE_SEARCH_CALL_RESULTS.toString())
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ResponseRetrieveParams.builder()
                .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                .build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params =
            ResponseRetrieveParams.builder()
                .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                .build()
        assertThat(params).isNotNull
        // path param "responseId"
        assertThat(params.getPathParam(0)).isEqualTo("resp_677efb5139a88190b512bc3fef8e535d")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
