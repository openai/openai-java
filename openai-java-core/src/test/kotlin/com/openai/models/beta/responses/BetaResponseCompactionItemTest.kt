// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseCompactionItemTest {

    @Test
    fun createAndRoundtrip() {
        val betaResponseCompactionItem =
            BetaResponseCompactionItem.builder()
                .id("id")
                .encryptedContent("encrypted_content")
                .agent(BetaResponseCompactionItem.Agent.builder().agentName("agent_name").build())
                .createdBy("created_by")
                .build()

        assertThat(betaResponseCompactionItem.id()).isEqualTo("id")
        assertThat(betaResponseCompactionItem.encryptedContent()).isEqualTo("encrypted_content")
        assertThat(betaResponseCompactionItem.agent())
            .contains(BetaResponseCompactionItem.Agent.builder().agentName("agent_name").build())
        assertThat(betaResponseCompactionItem.createdBy()).contains("created_by")

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseCompactionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseCompactionItem),
                jacksonTypeRef<BetaResponseCompactionItem>(),
            )

        assertThat(roundtrippedBetaResponseCompactionItem).isEqualTo(betaResponseCompactionItem)
    }
}
