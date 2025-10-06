// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreadListParamsTest {

    @Test
    fun create() {
        ThreadListParams.builder()
            .after("after")
            .before("before")
            .limit(0L)
            .order(ThreadListParams.Order.ASC)
            .user("x")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ThreadListParams.builder()
                .after("after")
                .before("before")
                .limit(0L)
                .order(ThreadListParams.Order.ASC)
                .user("x")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("limit", "0")
                    .put("order", "asc")
                    .put("user", "x")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ThreadListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
