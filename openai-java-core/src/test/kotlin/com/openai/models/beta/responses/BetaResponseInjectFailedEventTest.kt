// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseInjectFailedEventTest {

    @Test
    fun create() {
        val betaResponseInjectFailedEvent =
            BetaResponseInjectFailedEvent.builder()
                .error(
                    BetaResponseInjectFailedEvent.Error.builder()
                        .code(BetaResponseInjectFailedEvent.Error.Code.RESPONSE_ALREADY_COMPLETED)
                        .message("message")
                        .build()
                )
                .addInput(
                    BetaEasyInputMessage.builder()
                        .content("string")
                        .role(BetaEasyInputMessage.Role.USER)
                        .phase(BetaEasyInputMessage.Phase.COMMENTARY)
                        .type(BetaEasyInputMessage.Type.MESSAGE)
                        .build()
                )
                .responseId("response_id")
                .sequenceNumber(0L)
                .streamId("stream_id")
                .build()

        assertThat(betaResponseInjectFailedEvent.error())
            .isEqualTo(
                BetaResponseInjectFailedEvent.Error.builder()
                    .code(BetaResponseInjectFailedEvent.Error.Code.RESPONSE_ALREADY_COMPLETED)
                    .message("message")
                    .build()
            )
        assertThat(betaResponseInjectFailedEvent.input())
            .containsExactly(
                BetaResponseInputItem.ofBetaEasyInputMessage(
                    BetaEasyInputMessage.builder()
                        .content("string")
                        .role(BetaEasyInputMessage.Role.USER)
                        .phase(BetaEasyInputMessage.Phase.COMMENTARY)
                        .type(BetaEasyInputMessage.Type.MESSAGE)
                        .build()
                )
            )
        assertThat(betaResponseInjectFailedEvent.responseId()).isEqualTo("response_id")
        assertThat(betaResponseInjectFailedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseInjectFailedEvent.streamId()).contains("stream_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInjectFailedEvent =
            BetaResponseInjectFailedEvent.builder()
                .error(
                    BetaResponseInjectFailedEvent.Error.builder()
                        .code(BetaResponseInjectFailedEvent.Error.Code.RESPONSE_ALREADY_COMPLETED)
                        .message("message")
                        .build()
                )
                .addInput(
                    BetaEasyInputMessage.builder()
                        .content("string")
                        .role(BetaEasyInputMessage.Role.USER)
                        .phase(BetaEasyInputMessage.Phase.COMMENTARY)
                        .type(BetaEasyInputMessage.Type.MESSAGE)
                        .build()
                )
                .responseId("response_id")
                .sequenceNumber(0L)
                .streamId("stream_id")
                .build()

        val roundtrippedBetaResponseInjectFailedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInjectFailedEvent),
                jacksonTypeRef<BetaResponseInjectFailedEvent>(),
            )

        assertThat(roundtrippedBetaResponseInjectFailedEvent)
            .isEqualTo(betaResponseInjectFailedEvent)
    }
}
