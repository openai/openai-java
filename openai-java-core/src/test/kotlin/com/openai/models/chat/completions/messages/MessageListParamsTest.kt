// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions.messages

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageListParamsTest {

    @Test
    fun create() {
        MessageListParams.builder()
            .completionId("completion_id")
            .after("after")
            .limit(0L)
            .order(MessageListParams.Order.ASC)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            MessageListParams.builder()
                .completionId("completion_id")
                .after("after")
                .limit(0L)
                .order(MessageListParams.Order.ASC)
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("limit", "0")
        expected.put("order", MessageListParams.Order.ASC.toString())
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = MessageListParams.builder().completionId("completion_id").build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params = MessageListParams.builder().completionId("completion_id").build()
        assertThat(params).isNotNull
        // path param "completionId"
        assertThat(params.getPathParam(0)).isEqualTo("completion_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
