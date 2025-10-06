// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreadDeleteParamsTest {

    @Test
    fun create() {
        ThreadDeleteParams.builder().threadId("cthr_123").build()
    }

    @Test
    fun pathParams() {
        val params = ThreadDeleteParams.builder().threadId("cthr_123").build()

        assertThat(params._pathParam(0)).isEqualTo("cthr_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
