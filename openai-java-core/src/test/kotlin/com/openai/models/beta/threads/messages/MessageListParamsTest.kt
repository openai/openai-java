// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageListParamsTest {

    @Test
    fun create() {
        MessageListParams.builder()
            .threadId("thread_id")
            .after("after")
            .before("before")
            .limit(0L)
            .order(MessageListParams.Order.ASC)
            .runId("run_id")
            .build()
    }

    @Test
    fun pathParams() {
        val params = MessageListParams.builder().threadId("thread_id").build()

        assertThat(params._pathParam(0)).isEqualTo("thread_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            MessageListParams.builder()
                .threadId("thread_id")
                .after("after")
                .before("before")
                .limit(0L)
                .order(MessageListParams.Order.ASC)
                .runId("run_id")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("limit", "0")
                    .put("order", "asc")
                    .put("run_id", "run_id")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = MessageListParams.builder().threadId("thread_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
