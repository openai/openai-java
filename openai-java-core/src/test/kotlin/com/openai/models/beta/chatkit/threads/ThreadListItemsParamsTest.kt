// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreadListItemsParamsTest {

    @Test
    fun create() {
        ThreadListItemsParams.builder()
            .threadId("cthr_123")
            .after("after")
            .before("before")
            .limit(0L)
            .order(ThreadListItemsParams.Order.ASC)
            .build()
    }

    @Test
    fun pathParams() {
        val params = ThreadListItemsParams.builder().threadId("cthr_123").build()

        assertThat(params._pathParam(0)).isEqualTo("cthr_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ThreadListItemsParams.builder()
                .threadId("cthr_123")
                .after("after")
                .before("before")
                .limit(0L)
                .order(ThreadListItemsParams.Order.ASC)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("limit", "0")
                    .put("order", "asc")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ThreadListItemsParams.builder().threadId("cthr_123").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
