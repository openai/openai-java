// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseErrorEventTest {

    @Test
    fun create() {
        val responseErrorEvent =
            ResponseErrorEvent.builder().code("code").message("message").param("param").build()

        assertThat(responseErrorEvent.code()).contains("code")
        assertThat(responseErrorEvent.message()).isEqualTo("message")
        assertThat(responseErrorEvent.param()).contains("param")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseErrorEvent =
            ResponseErrorEvent.builder().code("code").message("message").param("param").build()

        val roundtrippedResponseErrorEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseErrorEvent),
                jacksonTypeRef<ResponseErrorEvent>(),
            )

        assertThat(roundtrippedResponseErrorEvent).isEqualTo(responseErrorEvent)
    }
}
