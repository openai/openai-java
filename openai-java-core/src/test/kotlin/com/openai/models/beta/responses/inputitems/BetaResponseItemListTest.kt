// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses.inputitems

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.beta.responses.BetaResponseInputMessageItem
import com.openai.models.beta.responses.BetaResponseInputText
import com.openai.models.beta.responses.BetaResponseItem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseItemListTest {

    @Test
    fun create() {
        val betaResponseItemList =
            BetaResponseItemList.builder()
                .addData(
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
                        .agent(
                            BetaResponseInputMessageItem.Agent.builder()
                                .agentName("agent_name")
                                .build()
                        )
                        .status(BetaResponseInputMessageItem.Status.IN_PROGRESS)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(betaResponseItemList.data())
            .containsExactly(
                BetaResponseItem.ofBetaResponseInputMessageItem(
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
                        .agent(
                            BetaResponseInputMessageItem.Agent.builder()
                                .agentName("agent_name")
                                .build()
                        )
                        .status(BetaResponseInputMessageItem.Status.IN_PROGRESS)
                        .build()
                )
            )
        assertThat(betaResponseItemList.firstId()).isEqualTo("first_id")
        assertThat(betaResponseItemList.hasMore()).isEqualTo(true)
        assertThat(betaResponseItemList.lastId()).isEqualTo("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItemList =
            BetaResponseItemList.builder()
                .addData(
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
                        .agent(
                            BetaResponseInputMessageItem.Agent.builder()
                                .agentName("agent_name")
                                .build()
                        )
                        .status(BetaResponseInputMessageItem.Status.IN_PROGRESS)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedBetaResponseItemList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItemList),
                jacksonTypeRef<BetaResponseItemList>(),
            )

        assertThat(roundtrippedBetaResponseItemList).isEqualTo(betaResponseItemList)
    }
}
