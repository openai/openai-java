// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaThreadMessageUpdateParamsTest {

    @Test
    fun createBetaThreadMessageUpdateParams() {
        BetaThreadMessageUpdateParams.builder()
            .threadId("thread_id")
            .messageId("message_id")
            .metadata(JsonValue.from(mapOf<String, Any>()))
            .build()
    }

    @Test
    fun body() {
        val params =
            BetaThreadMessageUpdateParams.builder()
                .threadId("thread_id")
                .messageId("message_id")
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .build()
        val body = params._body()
        assertThat(body).isNotNull
        assertThat(body._metadata()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BetaThreadMessageUpdateParams.builder()
                .threadId("thread_id")
                .messageId("message_id")
                .build()
        val body = params._body()
        assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
        val params =
            BetaThreadMessageUpdateParams.builder()
                .threadId("thread_id")
                .messageId("message_id")
                .build()
        assertThat(params).isNotNull
        // path param "threadId"
        assertThat(params.getPathParam(0)).isEqualTo("thread_id")
        // path param "messageId"
        assertThat(params.getPathParam(1)).isEqualTo("message_id")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
