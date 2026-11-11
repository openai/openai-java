// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ErrorTest {

    @Test
    fun createAndRoundtrip() {
        val error =
            Error.builder()
                .code("code")
                .message("message")
                .type("type")
                .clientEventId("client_event_id")
                .param("param")
                .build()

        assertThat(error.code()).contains("code")
        assertThat(error.message()).contains("message")
        assertThat(error.type()).contains("type")
        assertThat(error.clientEventId()).contains("client_event_id")
        assertThat(error.param()).contains("param")

        val jsonMapper = jsonMapper()

        val roundtrippedError =
            jsonMapper.readValue(jsonMapper.writeValueAsString(error), jacksonTypeRef<Error>())

        assertThat(roundtrippedError).isEqualTo(error)
    }
}
