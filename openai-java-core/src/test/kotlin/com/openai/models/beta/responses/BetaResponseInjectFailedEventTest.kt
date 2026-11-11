// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseInjectFailedEventTest {

    @Test
    fun createAndRoundtrip() {
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
            .contains(
                BetaResponseInjectFailedEvent.Error.builder()
                    .code(BetaResponseInjectFailedEvent.Error.Code.RESPONSE_ALREADY_COMPLETED)
                    .message("message")
                    .build()
            )
        assertThat(betaResponseInjectFailedEvent.input().getOrNull())
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
        assertThat(betaResponseInjectFailedEvent.responseId()).contains("response_id")
        assertThat(betaResponseInjectFailedEvent.sequenceNumber()).contains(0L)
        assertThat(betaResponseInjectFailedEvent.streamId()).contains("stream_id")

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseInjectFailedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInjectFailedEvent),
                jacksonTypeRef<BetaResponseInjectFailedEvent>(),
            )

        assertThat(roundtrippedBetaResponseInjectFailedEvent)
            .isEqualTo(betaResponseInjectFailedEvent)
    }
}
