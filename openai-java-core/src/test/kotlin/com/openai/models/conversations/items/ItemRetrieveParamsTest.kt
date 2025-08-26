// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations.items

import com.openai.core.http.QueryParams
import com.openai.models.responses.ResponseIncludable
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ItemRetrieveParamsTest {

    @Test
    fun create() {
        ItemRetrieveParams.builder()
            .conversationId("conv_123")
            .itemId("msg_abc")
            .addInclude(ResponseIncludable.CODE_INTERPRETER_CALL_OUTPUTS)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ItemRetrieveParams.builder().conversationId("conv_123").itemId("msg_abc").build()

        assertThat(params._pathParam(0)).isEqualTo("conv_123")
        assertThat(params._pathParam(1)).isEqualTo("msg_abc")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ItemRetrieveParams.builder()
                .conversationId("conv_123")
                .itemId("msg_abc")
                .addInclude(ResponseIncludable.CODE_INTERPRETER_CALL_OUTPUTS)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder().put("include[]", "code_interpreter_call.outputs").build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ItemRetrieveParams.builder().conversationId("conv_123").itemId("msg_abc").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
