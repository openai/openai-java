// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseErrorEventTest {

    @Test
    fun createResponseErrorEvent() {
        val responseErrorEvent =
            ResponseErrorEvent.builder().code("code").message("message").param("param").build()
        assertThat(responseErrorEvent).isNotNull
        assertThat(responseErrorEvent.code()).contains("code")
        assertThat(responseErrorEvent.message()).isEqualTo("message")
        assertThat(responseErrorEvent.param()).contains("param")
    }
}
