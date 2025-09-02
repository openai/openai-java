// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeErrorTest {

    @Test
    fun create() {
        val realtimeError =
            RealtimeError.builder()
                .message("message")
                .type("type")
                .code("code")
                .eventId("event_id")
                .param("param")
                .build()

        assertThat(realtimeError.message()).isEqualTo("message")
        assertThat(realtimeError.type()).isEqualTo("type")
        assertThat(realtimeError.code()).contains("code")
        assertThat(realtimeError.eventId()).contains("event_id")
        assertThat(realtimeError.param()).contains("param")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeError =
            RealtimeError.builder()
                .message("message")
                .type("type")
                .code("code")
                .eventId("event_id")
                .param("param")
                .build()

        val roundtrippedRealtimeError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeError),
                jacksonTypeRef<RealtimeError>(),
            )

        assertThat(roundtrippedRealtimeError).isEqualTo(realtimeError)
    }
}
