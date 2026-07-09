// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseComputerToolCallOutputItemTest {

    @Test
    fun create() {
        val betaResponseComputerToolCallOutputItem =
            BetaResponseComputerToolCallOutputItem.builder()
                .id("id")
                .callId("call_id")
                .output(
                    BetaResponseComputerToolCallOutputScreenshot.builder()
                        .fileId("file_id")
                        .imageUrl("https://example.com")
                        .build()
                )
                .status(BetaResponseComputerToolCallOutputItem.Status.COMPLETED)
                .addAcknowledgedSafetyCheck(
                    BetaResponseComputerToolCallOutputItem.AcknowledgedSafetyCheck.builder()
                        .id("id")
                        .code("code")
                        .message("message")
                        .build()
                )
                .agent(
                    BetaResponseComputerToolCallOutputItem.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .createdBy("created_by")
                .build()

        assertThat(betaResponseComputerToolCallOutputItem.id()).isEqualTo("id")
        assertThat(betaResponseComputerToolCallOutputItem.callId()).isEqualTo("call_id")
        assertThat(betaResponseComputerToolCallOutputItem.output())
            .isEqualTo(
                BetaResponseComputerToolCallOutputScreenshot.builder()
                    .fileId("file_id")
                    .imageUrl("https://example.com")
                    .build()
            )
        assertThat(betaResponseComputerToolCallOutputItem.status())
            .isEqualTo(BetaResponseComputerToolCallOutputItem.Status.COMPLETED)
        assertThat(betaResponseComputerToolCallOutputItem.acknowledgedSafetyChecks().getOrNull())
            .containsExactly(
                BetaResponseComputerToolCallOutputItem.AcknowledgedSafetyCheck.builder()
                    .id("id")
                    .code("code")
                    .message("message")
                    .build()
            )
        assertThat(betaResponseComputerToolCallOutputItem.agent())
            .contains(
                BetaResponseComputerToolCallOutputItem.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
        assertThat(betaResponseComputerToolCallOutputItem.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseComputerToolCallOutputItem =
            BetaResponseComputerToolCallOutputItem.builder()
                .id("id")
                .callId("call_id")
                .output(
                    BetaResponseComputerToolCallOutputScreenshot.builder()
                        .fileId("file_id")
                        .imageUrl("https://example.com")
                        .build()
                )
                .status(BetaResponseComputerToolCallOutputItem.Status.COMPLETED)
                .addAcknowledgedSafetyCheck(
                    BetaResponseComputerToolCallOutputItem.AcknowledgedSafetyCheck.builder()
                        .id("id")
                        .code("code")
                        .message("message")
                        .build()
                )
                .agent(
                    BetaResponseComputerToolCallOutputItem.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .createdBy("created_by")
                .build()

        val roundtrippedBetaResponseComputerToolCallOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseComputerToolCallOutputItem),
                jacksonTypeRef<BetaResponseComputerToolCallOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseComputerToolCallOutputItem)
            .isEqualTo(betaResponseComputerToolCallOutputItem)
    }
}
