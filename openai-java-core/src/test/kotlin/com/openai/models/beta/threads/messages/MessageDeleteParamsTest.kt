// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageDeleteParamsTest {

    @Test
    fun create() {
        MessageDeleteParams.builder().threadId("thread_id").messageId("message_id").build()
    }

    @Test
    fun pathParams() {
        val params =
            MessageDeleteParams.builder().threadId("thread_id").messageId("message_id").build()

        assertThat(params._pathParam(0)).isEqualTo("thread_id")
        assertThat(params._pathParam(1)).isEqualTo("message_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
