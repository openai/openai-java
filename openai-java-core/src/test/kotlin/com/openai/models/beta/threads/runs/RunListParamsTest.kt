// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RunListParamsTest {

    @Test
    fun create() {
        RunListParams.builder()
            .threadId("thread_id")
            .after("after")
            .before("before")
            .limit(0L)
            .order(RunListParams.Order.ASC)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            RunListParams.builder()
                .threadId("thread_id")
                .after("after")
                .before("before")
                .limit(0L)
                .order(RunListParams.Order.ASC)
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
        val params = RunListParams.builder().threadId("thread_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun getPathParam() {
        val params = RunListParams.builder().threadId("thread_id").build()
        assertThat(params).isNotNull
        // path param "threadId"
        assertThat(params.getPathParam(0)).isEqualTo("thread_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
