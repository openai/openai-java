// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseCompactionItemParamTest {

    @Test
    fun create() {
        val betaResponseCompactionItemParam =
            BetaResponseCompactionItemParam.builder()
                .encryptedContent("encrypted_content")
                .id("cmp_123")
                .agent(
                    BetaResponseCompactionItemParam.Agent.builder().agentName("agent_name").build()
                )
                .build()

        assertThat(betaResponseCompactionItemParam.encryptedContent())
            .isEqualTo("encrypted_content")
        assertThat(betaResponseCompactionItemParam.id()).contains("cmp_123")
        assertThat(betaResponseCompactionItemParam.agent())
            .contains(
                BetaResponseCompactionItemParam.Agent.builder().agentName("agent_name").build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseCompactionItemParam =
            BetaResponseCompactionItemParam.builder()
                .encryptedContent("encrypted_content")
                .id("cmp_123")
                .agent(
                    BetaResponseCompactionItemParam.Agent.builder().agentName("agent_name").build()
                )
                .build()

        val roundtrippedBetaResponseCompactionItemParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseCompactionItemParam),
                jacksonTypeRef<BetaResponseCompactionItemParam>(),
            )

        assertThat(roundtrippedBetaResponseCompactionItemParam)
            .isEqualTo(betaResponseCompactionItemParam)
    }
}
