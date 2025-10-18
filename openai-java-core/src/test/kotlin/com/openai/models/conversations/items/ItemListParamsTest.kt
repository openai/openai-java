// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations.items

import com.openai.core.http.QueryParams
import com.openai.models.responses.ResponseIncludable
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ItemListParamsTest {

    @Test
    fun create() {
        ItemListParams.builder()
            .conversationId("conv_123")
            .after("after")
            .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
            .limit(0L)
            .order(ItemListParams.Order.ASC)
            .build()
    }

    @Test
    fun pathParams() {
        val params = ItemListParams.builder().conversationId("conv_123").build()

        assertThat(params._pathParam(0)).isEqualTo("conv_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ItemListParams.builder()
                .conversationId("conv_123")
                .after("after")
                .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                .limit(0L)
                .order(ItemListParams.Order.ASC)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("include[]", "file_search_call.results")
                    .put("limit", "0")
                    .put("order", "asc")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ItemListParams.builder().conversationId("conv_123").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
