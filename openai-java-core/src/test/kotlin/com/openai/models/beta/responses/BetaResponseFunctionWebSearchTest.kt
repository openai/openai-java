// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseFunctionWebSearchTest {

    @Test
    fun create() {
        val betaResponseFunctionWebSearch =
            BetaResponseFunctionWebSearch.builder()
                .id("id")
                .action(
                    BetaResponseFunctionWebSearch.Action.Search.builder()
                        .addQuery("string")
                        .query("query")
                        .addSource(
                            BetaResponseFunctionWebSearch.Action.Search.Source.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .build()
                )
                .status(BetaResponseFunctionWebSearch.Status.IN_PROGRESS)
                .agent(
                    BetaResponseFunctionWebSearch.Agent.builder().agentName("agent_name").build()
                )
                .build()

        assertThat(betaResponseFunctionWebSearch.id()).isEqualTo("id")
        assertThat(betaResponseFunctionWebSearch.action())
            .isEqualTo(
                BetaResponseFunctionWebSearch.Action.ofSearch(
                    BetaResponseFunctionWebSearch.Action.Search.builder()
                        .addQuery("string")
                        .query("query")
                        .addSource(
                            BetaResponseFunctionWebSearch.Action.Search.Source.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .build()
                )
            )
        assertThat(betaResponseFunctionWebSearch.status())
            .isEqualTo(BetaResponseFunctionWebSearch.Status.IN_PROGRESS)
        assertThat(betaResponseFunctionWebSearch.agent())
            .contains(BetaResponseFunctionWebSearch.Agent.builder().agentName("agent_name").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFunctionWebSearch =
            BetaResponseFunctionWebSearch.builder()
                .id("id")
                .action(
                    BetaResponseFunctionWebSearch.Action.Search.builder()
                        .addQuery("string")
                        .query("query")
                        .addSource(
                            BetaResponseFunctionWebSearch.Action.Search.Source.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .build()
                )
                .status(BetaResponseFunctionWebSearch.Status.IN_PROGRESS)
                .agent(
                    BetaResponseFunctionWebSearch.Agent.builder().agentName("agent_name").build()
                )
                .build()

        val roundtrippedBetaResponseFunctionWebSearch =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFunctionWebSearch),
                jacksonTypeRef<BetaResponseFunctionWebSearch>(),
            )

        assertThat(roundtrippedBetaResponseFunctionWebSearch)
            .isEqualTo(betaResponseFunctionWebSearch)
    }
}
