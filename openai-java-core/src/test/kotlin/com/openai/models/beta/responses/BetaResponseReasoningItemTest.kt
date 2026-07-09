// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseReasoningItemTest {

    @Test
    fun create() {
        val betaResponseReasoningItem =
            BetaResponseReasoningItem.builder()
                .id("id")
                .addSummary(BetaResponseReasoningItem.Summary.builder().text("text").build())
                .agent(BetaResponseReasoningItem.Agent.builder().agentName("agent_name").build())
                .addContent(BetaResponseReasoningItem.Content.builder().text("text").build())
                .encryptedContent("encrypted_content")
                .status(BetaResponseReasoningItem.Status.IN_PROGRESS)
                .build()

        assertThat(betaResponseReasoningItem.id()).isEqualTo("id")
        assertThat(betaResponseReasoningItem.summary())
            .containsExactly(BetaResponseReasoningItem.Summary.builder().text("text").build())
        assertThat(betaResponseReasoningItem.agent())
            .contains(BetaResponseReasoningItem.Agent.builder().agentName("agent_name").build())
        assertThat(betaResponseReasoningItem.content().getOrNull())
            .containsExactly(BetaResponseReasoningItem.Content.builder().text("text").build())
        assertThat(betaResponseReasoningItem.encryptedContent()).contains("encrypted_content")
        assertThat(betaResponseReasoningItem.status())
            .contains(BetaResponseReasoningItem.Status.IN_PROGRESS)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseReasoningItem =
            BetaResponseReasoningItem.builder()
                .id("id")
                .addSummary(BetaResponseReasoningItem.Summary.builder().text("text").build())
                .agent(BetaResponseReasoningItem.Agent.builder().agentName("agent_name").build())
                .addContent(BetaResponseReasoningItem.Content.builder().text("text").build())
                .encryptedContent("encrypted_content")
                .status(BetaResponseReasoningItem.Status.IN_PROGRESS)
                .build()

        val roundtrippedBetaResponseReasoningItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseReasoningItem),
                jacksonTypeRef<BetaResponseReasoningItem>(),
            )

        assertThat(roundtrippedBetaResponseReasoningItem).isEqualTo(betaResponseReasoningItem)
    }
}
