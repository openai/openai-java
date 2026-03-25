// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseComputerToolCallTest {

    @Test
    fun create() {
        val responseComputerToolCall =
            ResponseComputerToolCall.builder()
                .id("id")
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
                .action(
                    ResponseComputerToolCall.Action.Click.builder()
                        .button(ResponseComputerToolCall.Action.Click.Button.LEFT)
                        .x(0L)
                        .y(0L)
                        .addKey("string")
                        .build()
                )
                .addAction(
                    ComputerAction.Click.builder()
                        .button(ComputerAction.Click.Button.LEFT)
                        .x(0L)
                        .y(0L)
                        .addKey("string")
                        .build()
                )
                .build()

        assertThat(responseComputerToolCall.id()).isEqualTo("id")
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
        assertThat(responseComputerToolCall.action())
            .contains(
                ResponseComputerToolCall.Action.ofClick(
                    ResponseComputerToolCall.Action.Click.builder()
                        .button(ResponseComputerToolCall.Action.Click.Button.LEFT)
                        .x(0L)
                        .y(0L)
                        .addKey("string")
                        .build()
                )
            )
        assertThat(responseComputerToolCall.actions().getOrNull())
            .containsExactly(
                ComputerAction.ofClick(
                    ComputerAction.Click.builder()
                        .button(ComputerAction.Click.Button.LEFT)
                        .x(0L)
                        .y(0L)
                        .addKey("string")
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseComputerToolCall =
            ResponseComputerToolCall.builder()
                .id("id")
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
                .action(
                    ResponseComputerToolCall.Action.Click.builder()
                        .button(ResponseComputerToolCall.Action.Click.Button.LEFT)
                        .x(0L)
                        .y(0L)
                        .addKey("string")
                        .build()
                )
                .addAction(
                    ComputerAction.Click.builder()
                        .button(ComputerAction.Click.Button.LEFT)
                        .x(0L)
                        .y(0L)
                        .addKey("string")
                        .build()
                )
                .build()

        val roundtrippedResponseComputerToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseComputerToolCall),
                jacksonTypeRef<ResponseComputerToolCall>(),
            )

        assertThat(roundtrippedResponseComputerToolCall).isEqualTo(responseComputerToolCall)
    }
}
