// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseToolSearchOutputItemParamTest {

    @Test
    fun create() {
        val betaResponseToolSearchOutputItemParam =
            BetaResponseToolSearchOutputItemParam.builder()
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
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            BetaFunctionTool.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .id("tso_123")
                .agent(
                    BetaResponseToolSearchOutputItemParam.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callId("x")
                .execution(BetaResponseToolSearchOutputItemParam.Execution.SERVER)
                .status(BetaResponseToolSearchOutputItemParam.Status.IN_PROGRESS)
                .build()

        assertThat(betaResponseToolSearchOutputItemParam.tools())
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
        assertThat(betaResponseToolSearchOutputItemParam.id()).contains("tso_123")
        assertThat(betaResponseToolSearchOutputItemParam.agent())
            .contains(
                BetaResponseToolSearchOutputItemParam.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
        assertThat(betaResponseToolSearchOutputItemParam.callId()).contains("x")
        assertThat(betaResponseToolSearchOutputItemParam.execution())
            .contains(BetaResponseToolSearchOutputItemParam.Execution.SERVER)
        assertThat(betaResponseToolSearchOutputItemParam.status())
            .contains(BetaResponseToolSearchOutputItemParam.Status.IN_PROGRESS)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseToolSearchOutputItemParam =
            BetaResponseToolSearchOutputItemParam.builder()
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
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            BetaFunctionTool.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .id("tso_123")
                .agent(
                    BetaResponseToolSearchOutputItemParam.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callId("x")
                .execution(BetaResponseToolSearchOutputItemParam.Execution.SERVER)
                .status(BetaResponseToolSearchOutputItemParam.Status.IN_PROGRESS)
                .build()

        val roundtrippedBetaResponseToolSearchOutputItemParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseToolSearchOutputItemParam),
                jacksonTypeRef<BetaResponseToolSearchOutputItemParam>(),
            )

        assertThat(roundtrippedBetaResponseToolSearchOutputItemParam)
            .isEqualTo(betaResponseToolSearchOutputItemParam)
    }
}
