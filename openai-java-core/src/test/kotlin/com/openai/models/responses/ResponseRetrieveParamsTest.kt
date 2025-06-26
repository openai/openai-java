// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseRetrieveParamsTest {

    @Test
    fun create() {
        ResponseRetrieveParams.builder()
            .responseId("resp_677efb5139a88190b512bc3fef8e535d")
            .addInclude(ResponseIncludable.CODE_INTERPRETER_CALL_OUTPUTS)
            .startingAfter(0L)
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
    fun queryParams() {
        val params =
            ResponseRetrieveParams.builder()
                .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                .addInclude(ResponseIncludable.CODE_INTERPRETER_CALL_OUTPUTS)
                .startingAfter(0L)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("include[]", "code_interpreter_call.outputs")
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
