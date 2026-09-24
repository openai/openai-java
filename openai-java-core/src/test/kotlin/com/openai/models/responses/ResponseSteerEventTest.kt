// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseSteerEventTest {

    @Test
    fun create() {
        val responseSteerEvent =
            ResponseSteerEvent.builder()
                .input("string")
                .previousResponseId("previous_response_id")
                .build()

        assertThat(responseSteerEvent.input()).isEqualTo(ResponseSteerInput.ofText("string"))
        assertThat(responseSteerEvent.previousResponseId()).isEqualTo("previous_response_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseSteerEvent =
            ResponseSteerEvent.builder()
                .input("string")
                .previousResponseId("previous_response_id")
                .build()

        val roundtrippedResponseSteerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseSteerEvent),
                jacksonTypeRef<ResponseSteerEvent>(),
            )

        assertThat(roundtrippedResponseSteerEvent).isEqualTo(responseSteerEvent)
    }
}
