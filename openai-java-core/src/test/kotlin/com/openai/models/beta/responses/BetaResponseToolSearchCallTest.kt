// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseToolSearchCallTest {

    @Test
    fun create() {
        val betaResponseToolSearchCall =
            BetaResponseToolSearchCall.builder()
                .id("id")
                .arguments(JsonValue.from(mapOf<String, Any>()))
                .callId("call_id")
                .execution(BetaResponseToolSearchCall.Execution.SERVER)
                .status(BetaResponseToolSearchCall.Status.IN_PROGRESS)
                .agent(BetaResponseToolSearchCall.Agent.builder().agentName("agent_name").build())
                .createdBy("created_by")
                .build()

        assertThat(betaResponseToolSearchCall.id()).isEqualTo("id")
        assertThat(betaResponseToolSearchCall._arguments())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(betaResponseToolSearchCall.callId()).contains("call_id")
        assertThat(betaResponseToolSearchCall.execution())
            .isEqualTo(BetaResponseToolSearchCall.Execution.SERVER)
        assertThat(betaResponseToolSearchCall.status())
            .isEqualTo(BetaResponseToolSearchCall.Status.IN_PROGRESS)
        assertThat(betaResponseToolSearchCall.agent())
            .contains(BetaResponseToolSearchCall.Agent.builder().agentName("agent_name").build())
        assertThat(betaResponseToolSearchCall.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseToolSearchCall =
            BetaResponseToolSearchCall.builder()
                .id("id")
                .arguments(JsonValue.from(mapOf<String, Any>()))
                .callId("call_id")
                .execution(BetaResponseToolSearchCall.Execution.SERVER)
                .status(BetaResponseToolSearchCall.Status.IN_PROGRESS)
                .agent(BetaResponseToolSearchCall.Agent.builder().agentName("agent_name").build())
                .createdBy("created_by")
                .build()

        val roundtrippedBetaResponseToolSearchCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseToolSearchCall),
                jacksonTypeRef<BetaResponseToolSearchCall>(),
            )

        assertThat(roundtrippedBetaResponseToolSearchCall).isEqualTo(betaResponseToolSearchCall)
    }
}
