// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseComputerToolCallTest {

    @Test
    fun create() {
        val betaResponseComputerToolCall =
            BetaResponseComputerToolCall.builder()
                .id("id")
                .callId("call_id")
                .addPendingSafetyCheck(
                    BetaResponseComputerToolCall.PendingSafetyCheck.builder()
                        .id("id")
                        .code("code")
                        .message("message")
                        .build()
                )
                .status(BetaResponseComputerToolCall.Status.IN_PROGRESS)
                .type(BetaResponseComputerToolCall.Type.COMPUTER_CALL)
                .action(
                    BetaComputerAction.Click.builder()
                        .button(BetaComputerAction.Click.Button.LEFT)
                        .x(0L)
                        .y(0L)
                        .addKey("string")
                        .build()
                )
                .addAction(
                    BetaComputerAction.Click.builder()
                        .button(BetaComputerAction.Click.Button.LEFT)
                        .x(0L)
                        .y(0L)
                        .addKey("string")
                        .build()
                )
                .agent(BetaResponseComputerToolCall.Agent.builder().agentName("agent_name").build())
                .build()

        assertThat(betaResponseComputerToolCall.id()).isEqualTo("id")
        assertThat(betaResponseComputerToolCall.callId()).isEqualTo("call_id")
        assertThat(betaResponseComputerToolCall.pendingSafetyChecks())
            .containsExactly(
                BetaResponseComputerToolCall.PendingSafetyCheck.builder()
                    .id("id")
                    .code("code")
                    .message("message")
                    .build()
            )
        assertThat(betaResponseComputerToolCall.status())
            .isEqualTo(BetaResponseComputerToolCall.Status.IN_PROGRESS)
        assertThat(betaResponseComputerToolCall.type())
            .isEqualTo(BetaResponseComputerToolCall.Type.COMPUTER_CALL)
        assertThat(betaResponseComputerToolCall.action())
            .contains(
                BetaComputerAction.ofClick(
                    BetaComputerAction.Click.builder()
                        .button(BetaComputerAction.Click.Button.LEFT)
                        .x(0L)
                        .y(0L)
                        .addKey("string")
                        .build()
                )
            )
        assertThat(betaResponseComputerToolCall.actions().getOrNull())
            .containsExactly(
                BetaComputerAction.ofClick(
                    BetaComputerAction.Click.builder()
                        .button(BetaComputerAction.Click.Button.LEFT)
                        .x(0L)
                        .y(0L)
                        .addKey("string")
                        .build()
                )
            )
        assertThat(betaResponseComputerToolCall.agent())
            .contains(BetaResponseComputerToolCall.Agent.builder().agentName("agent_name").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseComputerToolCall =
            BetaResponseComputerToolCall.builder()
                .id("id")
                .callId("call_id")
                .addPendingSafetyCheck(
                    BetaResponseComputerToolCall.PendingSafetyCheck.builder()
                        .id("id")
                        .code("code")
                        .message("message")
                        .build()
                )
                .status(BetaResponseComputerToolCall.Status.IN_PROGRESS)
                .type(BetaResponseComputerToolCall.Type.COMPUTER_CALL)
                .action(
                    BetaComputerAction.Click.builder()
                        .button(BetaComputerAction.Click.Button.LEFT)
                        .x(0L)
                        .y(0L)
                        .addKey("string")
                        .build()
                )
                .addAction(
                    BetaComputerAction.Click.builder()
                        .button(BetaComputerAction.Click.Button.LEFT)
                        .x(0L)
                        .y(0L)
                        .addKey("string")
                        .build()
                )
                .agent(BetaResponseComputerToolCall.Agent.builder().agentName("agent_name").build())
                .build()

        val roundtrippedBetaResponseComputerToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseComputerToolCall),
                jacksonTypeRef<BetaResponseComputerToolCall>(),
            )

        assertThat(roundtrippedBetaResponseComputerToolCall).isEqualTo(betaResponseComputerToolCall)
    }
}
