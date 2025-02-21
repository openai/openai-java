// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionDeleteParamsTest {

    @Test
    fun create() {
        ChatCompletionDeleteParams.builder().completionId("completion_id").build()
    }

    @Test
    fun getPathParam() {
        val params = ChatCompletionDeleteParams.builder().completionId("completion_id").build()
        assertThat(params).isNotNull
        // path param "completionId"
        assertThat(params.getPathParam(0)).isEqualTo("completion_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
