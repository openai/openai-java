// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseConfigurationUpdateItemParamTest {

    @Test
    fun create() {
        val betaResponseConfigurationUpdateItemParam =
            BetaResponseConfigurationUpdateItemParam.builder()
                .id("cnfu_123")
                .agent(
                    BetaResponseConfigurationUpdateItemParam.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .reasoning(
                    BetaResponseConfigurationUpdateItemParam.Reasoning.builder()
                        .effort(BetaResponseConfigurationUpdateItemParam.Reasoning.Effort.NONE)
                        .build()
                )
                .build()

        assertThat(betaResponseConfigurationUpdateItemParam.id()).contains("cnfu_123")
        assertThat(betaResponseConfigurationUpdateItemParam.agent())
            .contains(
                BetaResponseConfigurationUpdateItemParam.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
        assertThat(betaResponseConfigurationUpdateItemParam.reasoning())
            .contains(
                BetaResponseConfigurationUpdateItemParam.Reasoning.builder()
                    .effort(BetaResponseConfigurationUpdateItemParam.Reasoning.Effort.NONE)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseConfigurationUpdateItemParam =
            BetaResponseConfigurationUpdateItemParam.builder()
                .id("cnfu_123")
                .agent(
                    BetaResponseConfigurationUpdateItemParam.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .reasoning(
                    BetaResponseConfigurationUpdateItemParam.Reasoning.builder()
                        .effort(BetaResponseConfigurationUpdateItemParam.Reasoning.Effort.NONE)
                        .build()
                )
                .build()

        val roundtrippedBetaResponseConfigurationUpdateItemParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseConfigurationUpdateItemParam),
                jacksonTypeRef<BetaResponseConfigurationUpdateItemParam>(),
            )

        assertThat(roundtrippedBetaResponseConfigurationUpdateItemParam)
            .isEqualTo(betaResponseConfigurationUpdateItemParam)
    }
}
