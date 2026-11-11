// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseSteerEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseSteerEvent =
            ResponseSteerEvent.builder()
                .input("string")
                .previousResponseId("previous_response_id")
                .build()

        assertThat(responseSteerEvent.input()).contains(ResponseSteerInput.ofText("string"))
        assertThat(responseSteerEvent.previousResponseId()).contains("previous_response_id")

        val jsonMapper = jsonMapper()

        val roundtrippedResponseSteerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseSteerEvent),
                jacksonTypeRef<ResponseSteerEvent>(),
            )

        assertThat(roundtrippedResponseSteerEvent).isEqualTo(responseSteerEvent)
    }
}
