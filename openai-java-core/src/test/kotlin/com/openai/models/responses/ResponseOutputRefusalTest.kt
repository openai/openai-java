// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseOutputRefusalTest {

    @Test
    fun createResponseOutputRefusal() {
        val responseOutputRefusal = ResponseOutputRefusal.builder().refusal("refusal").build()
        assertThat(responseOutputRefusal).isNotNull
        assertThat(responseOutputRefusal.refusal()).isEqualTo("refusal")
    }
}
