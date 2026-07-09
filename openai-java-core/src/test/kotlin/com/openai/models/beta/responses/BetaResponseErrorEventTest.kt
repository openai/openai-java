// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseErrorEventTest {

    @Test
    fun create() {
        val betaResponseErrorEvent =
            BetaResponseErrorEvent.builder()
                .code("code")
                .message("message")
                .param("param")
                .sequenceNumber(0L)
                .agent(BetaResponseErrorEvent.Agent.builder().agentName("agent_name").build())
                .build()

        assertThat(betaResponseErrorEvent.code()).contains("code")
        assertThat(betaResponseErrorEvent.message()).isEqualTo("message")
        assertThat(betaResponseErrorEvent.param()).contains("param")
        assertThat(betaResponseErrorEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseErrorEvent.agent())
            .contains(BetaResponseErrorEvent.Agent.builder().agentName("agent_name").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseErrorEvent =
            BetaResponseErrorEvent.builder()
                .code("code")
                .message("message")
                .param("param")
                .sequenceNumber(0L)
                .agent(BetaResponseErrorEvent.Agent.builder().agentName("agent_name").build())
                .build()

        val roundtrippedBetaResponseErrorEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseErrorEvent),
                jacksonTypeRef<BetaResponseErrorEvent>(),
            )

        assertThat(roundtrippedBetaResponseErrorEvent).isEqualTo(betaResponseErrorEvent)
    }
}
