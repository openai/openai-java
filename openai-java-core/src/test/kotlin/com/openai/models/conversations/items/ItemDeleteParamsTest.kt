// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations.items

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ItemDeleteParamsTest {

    @Test
    fun create() {
        ItemDeleteParams.builder().conversationId("conv_123").itemId("msg_abc").build()
    }

    @Test
    fun pathParams() {
        val params = ItemDeleteParams.builder().conversationId("conv_123").itemId("msg_abc").build()

        assertThat(params._pathParam(0)).isEqualTo("conv_123")
        assertThat(params._pathParam(1)).isEqualTo("msg_abc")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
