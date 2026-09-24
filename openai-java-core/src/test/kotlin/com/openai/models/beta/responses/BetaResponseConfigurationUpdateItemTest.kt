// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseConfigurationUpdateItemTest {

    @Test
    fun create() {
        val betaResponseConfigurationUpdateItem =
            BetaResponseConfigurationUpdateItem.builder()
                .id("cnfu_123")
                .agent(
                    BetaResponseConfigurationUpdateItem.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .reasoning(
                    BetaResponseConfigurationUpdateItem.Reasoning.builder()
                        .effort(BetaResponseConfigurationUpdateItem.Reasoning.Effort.NONE)
                        .build()
                )
                .build()

        assertThat(betaResponseConfigurationUpdateItem.id()).isEqualTo("cnfu_123")
        assertThat(betaResponseConfigurationUpdateItem.agent())
            .contains(
                BetaResponseConfigurationUpdateItem.Agent.builder().agentName("agent_name").build()
            )
        assertThat(betaResponseConfigurationUpdateItem.reasoning())
            .contains(
                BetaResponseConfigurationUpdateItem.Reasoning.builder()
                    .effort(BetaResponseConfigurationUpdateItem.Reasoning.Effort.NONE)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseConfigurationUpdateItem =
            BetaResponseConfigurationUpdateItem.builder()
                .id("cnfu_123")
                .agent(
                    BetaResponseConfigurationUpdateItem.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .reasoning(
                    BetaResponseConfigurationUpdateItem.Reasoning.builder()
                        .effort(BetaResponseConfigurationUpdateItem.Reasoning.Effort.NONE)
                        .build()
                )
                .build()

        val roundtrippedBetaResponseConfigurationUpdateItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseConfigurationUpdateItem),
                jacksonTypeRef<BetaResponseConfigurationUpdateItem>(),
            )

        assertThat(roundtrippedBetaResponseConfigurationUpdateItem)
            .isEqualTo(betaResponseConfigurationUpdateItem)
    }
}
