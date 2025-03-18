// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionRetrieveParamsTest {

    @Test
    fun create() {
        ChatCompletionRetrieveParams.builder().completionId("completion_id").build()
    }

    @Test
    fun pathParams() {
        val params = ChatCompletionRetrieveParams.builder().completionId("completion_id").build()

        assertThat(params._pathParam(0)).isEqualTo("completion_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
