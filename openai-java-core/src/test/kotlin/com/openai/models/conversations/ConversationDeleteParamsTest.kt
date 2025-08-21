// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationDeleteParamsTest {

    @Test
    fun create() {
        ConversationDeleteParams.builder().conversationId("conv_123").build()
    }

    @Test
    fun pathParams() {
        val params = ConversationDeleteParams.builder().conversationId("conv_123").build()

        assertThat(params._pathParam(0)).isEqualTo("conv_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
