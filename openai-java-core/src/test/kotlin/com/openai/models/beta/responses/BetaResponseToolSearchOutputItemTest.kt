// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseToolSearchOutputItemTest {

    @Test
    fun createAndRoundtrip() {
        val betaResponseToolSearchOutputItem =
            BetaResponseToolSearchOutputItem.builder()
                .id("id")
                .callId("call_id")
                .execution(BetaResponseToolSearchOutputItem.Execution.SERVER)
                .status(BetaResponseToolSearchOutputItem.Status.IN_PROGRESS)
                .addTool(
                    BetaFunctionTool.builder()
                        .name("name")
                        .parameters(
                            BetaFunctionTool.Parameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .addAllowedCaller(BetaFunctionTool.AllowedCaller.DIRECT)
                        .async(true)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            BetaFunctionTool.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .agent(
                    BetaResponseToolSearchOutputItem.Agent.builder().agentName("agent_name").build()
                )
                .createdBy("created_by")
                .build()

        assertThat(betaResponseToolSearchOutputItem.id()).contains("id")
        assertThat(betaResponseToolSearchOutputItem.callId()).contains("call_id")
        assertThat(betaResponseToolSearchOutputItem.execution())
            .contains(BetaResponseToolSearchOutputItem.Execution.SERVER)
        assertThat(betaResponseToolSearchOutputItem.status())
            .contains(BetaResponseToolSearchOutputItem.Status.IN_PROGRESS)
        assertThat(betaResponseToolSearchOutputItem.tools().getOrNull())
            .containsExactly(
                BetaTool.ofFunction(
                    BetaFunctionTool.builder()
                        .name("name")
                        .parameters(
                            BetaFunctionTool.Parameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .addAllowedCaller(BetaFunctionTool.AllowedCaller.DIRECT)
                        .async(true)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            BetaFunctionTool.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
            )
        assertThat(betaResponseToolSearchOutputItem.agent())
            .contains(
                BetaResponseToolSearchOutputItem.Agent.builder().agentName("agent_name").build()
            )
        assertThat(betaResponseToolSearchOutputItem.createdBy()).contains("created_by")

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseToolSearchOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseToolSearchOutputItem),
                jacksonTypeRef<BetaResponseToolSearchOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseToolSearchOutputItem)
            .isEqualTo(betaResponseToolSearchOutputItem)
    }
}
