// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseCodeInterpreterToolCallTest {

    @Test
    fun create() {
        val betaResponseCodeInterpreterToolCall =
            BetaResponseCodeInterpreterToolCall.builder()
                .id("id")
                .code("code")
                .containerId("container_id")
                .addLogsOutput("logs")
                .status(BetaResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseCodeInterpreterToolCall.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseCodeInterpreterToolCall.id()).isEqualTo("id")
        assertThat(betaResponseCodeInterpreterToolCall.code()).contains("code")
        assertThat(betaResponseCodeInterpreterToolCall.containerId()).isEqualTo("container_id")
        assertThat(betaResponseCodeInterpreterToolCall.outputs().getOrNull())
            .containsExactly(
                BetaResponseCodeInterpreterToolCall.Output.ofLogs(
                    BetaResponseCodeInterpreterToolCall.Output.Logs.builder().logs("logs").build()
                )
            )
        assertThat(betaResponseCodeInterpreterToolCall.status())
            .isEqualTo(BetaResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
        assertThat(betaResponseCodeInterpreterToolCall.agent())
            .contains(
                BetaResponseCodeInterpreterToolCall.Agent.builder().agentName("agent_name").build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseCodeInterpreterToolCall =
            BetaResponseCodeInterpreterToolCall.builder()
                .id("id")
                .code("code")
                .containerId("container_id")
                .addLogsOutput("logs")
                .status(BetaResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseCodeInterpreterToolCall.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseCodeInterpreterToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseCodeInterpreterToolCall),
                jacksonTypeRef<BetaResponseCodeInterpreterToolCall>(),
            )

        assertThat(roundtrippedBetaResponseCodeInterpreterToolCall)
            .isEqualTo(betaResponseCodeInterpreterToolCall)
    }
}
