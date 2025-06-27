// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeResponseStatusTest {

    @Test
    fun create() {
        val realtimeResponseStatus =
            RealtimeResponseStatus.builder()
                .error(RealtimeResponseStatus.Error.builder().code("code").type("type").build())
                .reason(RealtimeResponseStatus.Reason.TURN_DETECTED)
                .type(RealtimeResponseStatus.Type.COMPLETED)
                .build()

        assertThat(realtimeResponseStatus.error())
            .contains(RealtimeResponseStatus.Error.builder().code("code").type("type").build())
        assertThat(realtimeResponseStatus.reason())
            .contains(RealtimeResponseStatus.Reason.TURN_DETECTED)
        assertThat(realtimeResponseStatus.type()).contains(RealtimeResponseStatus.Type.COMPLETED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeResponseStatus =
            RealtimeResponseStatus.builder()
                .error(RealtimeResponseStatus.Error.builder().code("code").type("type").build())
                .reason(RealtimeResponseStatus.Reason.TURN_DETECTED)
                .type(RealtimeResponseStatus.Type.COMPLETED)
                .build()

        val roundtrippedRealtimeResponseStatus =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeResponseStatus),
                jacksonTypeRef<RealtimeResponseStatus>(),
            )

        assertThat(roundtrippedRealtimeResponseStatus).isEqualTo(realtimeResponseStatus)
    }
}
