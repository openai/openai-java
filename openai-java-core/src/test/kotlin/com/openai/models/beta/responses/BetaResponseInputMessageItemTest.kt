// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.PromptCacheBreakpointTtl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseInputMessageItemTest {

    @Test
    fun createAndRoundtrip() {
        val betaResponseInputMessageItem =
            BetaResponseInputMessageItem.builder()
                .id("id")
                .addContent(
                    BetaResponseInputText.builder()
                        .text("text")
                        .promptCacheBreakpoint(
                            BetaResponseInputText.PromptCacheBreakpoint.builder()
                                .ttl(PromptCacheBreakpointTtl._30M)
                                .build()
                        )
                        .build()
                )
                .role(BetaResponseInputMessageItem.Role.USER)
                .agent(BetaResponseInputMessageItem.Agent.builder().agentName("agent_name").build())
                .status(BetaResponseInputMessageItem.Status.IN_PROGRESS)
                .build()

        assertThat(betaResponseInputMessageItem.id()).isEqualTo("id")
        assertThat(betaResponseInputMessageItem.content())
            .containsExactly(
                BetaResponseInputContent.ofInputText(
                    BetaResponseInputText.builder()
                        .text("text")
                        .promptCacheBreakpoint(
                            BetaResponseInputText.PromptCacheBreakpoint.builder()
                                .ttl(PromptCacheBreakpointTtl._30M)
                                .build()
                        )
                        .build()
                )
            )
        assertThat(betaResponseInputMessageItem.role())
            .isEqualTo(BetaResponseInputMessageItem.Role.USER)
        assertThat(betaResponseInputMessageItem.agent())
            .contains(BetaResponseInputMessageItem.Agent.builder().agentName("agent_name").build())
        assertThat(betaResponseInputMessageItem.status())
            .contains(BetaResponseInputMessageItem.Status.IN_PROGRESS)

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseInputMessageItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputMessageItem),
                jacksonTypeRef<BetaResponseInputMessageItem>(),
            )

        assertThat(roundtrippedBetaResponseInputMessageItem).isEqualTo(betaResponseInputMessageItem)
    }
}
