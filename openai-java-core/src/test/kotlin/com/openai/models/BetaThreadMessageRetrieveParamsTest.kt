// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaThreadMessageRetrieveParamsTest {

    @Test
    fun createBetaThreadMessageRetrieveParams() {
        BetaThreadMessageRetrieveParams.builder()
            .threadId("thread_id")
            .messageId("message_id")
            .build()
    }

    @Test
    fun getPathParam() {
        val params =
            BetaThreadMessageRetrieveParams.builder()
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
