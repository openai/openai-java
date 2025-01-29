// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaThreadMessageListParamsTest {

    @Test
    fun createBetaThreadMessageListParams() {
        BetaThreadMessageListParams.builder()
            .threadId("thread_id")
            .after("after")
            .before("before")
            .limit(0L)
            .order(BetaThreadMessageListParams.Order.ASC)
            .runId("run_id")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            BetaThreadMessageListParams.builder()
                .threadId("thread_id")
                .after("after")
                .before("before")
                .limit(0L)
                .order(BetaThreadMessageListParams.Order.ASC)
                .runId("run_id")
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("before", "before")
        expected.put("limit", "0")
        expected.put("order", BetaThreadMessageListParams.Order.ASC.toString())
        expected.put("run_id", "run_id")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = BetaThreadMessageListParams.builder().threadId("thread_id").build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params = BetaThreadMessageListParams.builder().threadId("thread_id").build()
        assertThat(params).isNotNull
        // path param "threadId"
        assertThat(params.getPathParam(0)).isEqualTo("thread_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
