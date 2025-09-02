// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseMcpCallArgumentsDeltaTest {

    @Test
    fun create() {
        val responseMcpCallArgumentsDelta =
            ResponseMcpCallArgumentsDelta.builder()
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .obfuscation("obfuscation")
                .build()

        assertThat(responseMcpCallArgumentsDelta.delta()).isEqualTo("delta")
        assertThat(responseMcpCallArgumentsDelta.eventId()).isEqualTo("event_id")
        assertThat(responseMcpCallArgumentsDelta.itemId()).isEqualTo("item_id")
        assertThat(responseMcpCallArgumentsDelta.outputIndex()).isEqualTo(0L)
        assertThat(responseMcpCallArgumentsDelta.responseId()).isEqualTo("response_id")
        assertThat(responseMcpCallArgumentsDelta.obfuscation()).contains("obfuscation")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseMcpCallArgumentsDelta =
            ResponseMcpCallArgumentsDelta.builder()
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .obfuscation("obfuscation")
                .build()

        val roundtrippedResponseMcpCallArgumentsDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseMcpCallArgumentsDelta),
                jacksonTypeRef<ResponseMcpCallArgumentsDelta>(),
            )

        assertThat(roundtrippedResponseMcpCallArgumentsDelta)
            .isEqualTo(responseMcpCallArgumentsDelta)
    }
}
