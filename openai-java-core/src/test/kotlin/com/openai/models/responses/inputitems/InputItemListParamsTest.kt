// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses.inputitems

import com.openai.core.http.QueryParams
import com.openai.models.responses.ResponseIncludable
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputItemListParamsTest {

    @Test
    fun create() {
        InputItemListParams.builder()
            .responseId("response_id")
            .after("after")
            .addInclude(ResponseIncludable.CODE_INTERPRETER_CALL_OUTPUTS)
            .limit(0L)
            .order(InputItemListParams.Order.ASC)
            .build()
    }

    @Test
    fun pathParams() {
        val params = InputItemListParams.builder().responseId("response_id").build()

        assertThat(params._pathParam(0)).isEqualTo("response_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            InputItemListParams.builder()
                .responseId("response_id")
                .after("after")
                .addInclude(ResponseIncludable.CODE_INTERPRETER_CALL_OUTPUTS)
                .limit(0L)
                .order(InputItemListParams.Order.ASC)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("include[]", "code_interpreter_call.outputs")
                    .put("limit", "0")
                    .put("order", "asc")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = InputItemListParams.builder().responseId("response_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
