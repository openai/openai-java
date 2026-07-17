// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseInputMessageItemTest {

    @Test
    fun create() {
        val betaResponseInputMessageItem =
            BetaResponseInputMessageItem.builder()
                .id("id")
                .addContent(
                    BetaResponseInputText.builder()
                        .text("text")
                        .promptCacheBreakpoint(
                            BetaResponseInputText.PromptCacheBreakpoint.builder().build()
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
                            BetaResponseInputText.PromptCacheBreakpoint.builder().build()
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputMessageItem =
            BetaResponseInputMessageItem.builder()
                .id("id")
                .addContent(
                    BetaResponseInputText.builder()
                        .text("text")
                        .promptCacheBreakpoint(
                            BetaResponseInputText.PromptCacheBreakpoint.builder().build()
                        )
                        .build()
                )
                .role(BetaResponseInputMessageItem.Role.USER)
                .agent(BetaResponseInputMessageItem.Agent.builder().agentName("agent_name").build())
                .status(BetaResponseInputMessageItem.Status.IN_PROGRESS)
                .build()

        val roundtrippedBetaResponseInputMessageItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputMessageItem),
                jacksonTypeRef<BetaResponseInputMessageItem>(),
            )

        assertThat(roundtrippedBetaResponseInputMessageItem).isEqualTo(betaResponseInputMessageItem)
    }
}
