// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseComputerToolCallTest {

    @Test
    fun createResponseComputerToolCall() {
        val responseComputerToolCall =
            ResponseComputerToolCall.builder()
                .id("id")
                .action(
                    ResponseComputerToolCall.Action.Click.builder()
                        .button(ResponseComputerToolCall.Action.Click.Button.LEFT)
                        .x(0L)
                        .y(0L)
                        .build()
                )
                .callId("call_id")
                .addPendingSafetyCheck(
                    ResponseComputerToolCall.PendingSafetyCheck.builder()
                        .id("id")
                        .code("code")
                        .message("message")
                        .build()
                )
                .status(ResponseComputerToolCall.Status.IN_PROGRESS)
                .type(ResponseComputerToolCall.Type.COMPUTER_CALL)
                .build()
        assertThat(responseComputerToolCall).isNotNull
        assertThat(responseComputerToolCall.id()).isEqualTo("id")
        assertThat(responseComputerToolCall.action())
            .isEqualTo(
                ResponseComputerToolCall.Action.ofClick(
                    ResponseComputerToolCall.Action.Click.builder()
                        .button(ResponseComputerToolCall.Action.Click.Button.LEFT)
                        .x(0L)
                        .y(0L)
                        .build()
                )
            )
        assertThat(responseComputerToolCall.callId()).isEqualTo("call_id")
        assertThat(responseComputerToolCall.pendingSafetyChecks())
            .containsExactly(
                ResponseComputerToolCall.PendingSafetyCheck.builder()
                    .id("id")
                    .code("code")
                    .message("message")
                    .build()
            )
        assertThat(responseComputerToolCall.status())
            .isEqualTo(ResponseComputerToolCall.Status.IN_PROGRESS)
        assertThat(responseComputerToolCall.type())
            .isEqualTo(ResponseComputerToolCall.Type.COMPUTER_CALL)
    }
}
