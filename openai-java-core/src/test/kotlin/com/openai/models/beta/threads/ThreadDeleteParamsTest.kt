// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreadDeleteParamsTest {

    @Test
    fun create() {
        ThreadDeleteParams.builder().threadId("thread_id").build()
    }

    @Test
    fun pathParams() {
        val params = ThreadDeleteParams.builder().threadId("thread_id").build()

        assertThat(params._pathParam(0)).isEqualTo("thread_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
