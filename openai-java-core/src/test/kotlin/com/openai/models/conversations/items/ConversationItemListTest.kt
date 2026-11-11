// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.conversations.items

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.PromptCacheBreakpointTtl
import com.openai.models.conversations.Message
import com.openai.models.responses.ResponseInputText
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemListTest {

    @Test
    fun createAndRoundtrip() {
        val conversationItemList =
            ConversationItemList.builder()
                .addData(
                    Message.builder()
                        .id("id")
                        .addContent(
                            ResponseInputText.builder()
                                .text("text")
                                .promptCacheBreakpoint(
                                    ResponseInputText.PromptCacheBreakpoint.builder()
                                        .ttl(PromptCacheBreakpointTtl._30M)
                                        .build()
                                )
                                .build()
                        )
                        .role(Message.Role.UNKNOWN)
                        .status(Message.Status.IN_PROGRESS)
                        .phase(Message.Phase.COMMENTARY)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(conversationItemList.data().getOrNull())
            .containsExactly(
                ConversationItem.ofMessage(
                    Message.builder()
                        .id("id")
                        .addContent(
                            ResponseInputText.builder()
                                .text("text")
                                .promptCacheBreakpoint(
                                    ResponseInputText.PromptCacheBreakpoint.builder()
                                        .ttl(PromptCacheBreakpointTtl._30M)
                                        .build()
                                )
                                .build()
                        )
                        .role(Message.Role.UNKNOWN)
                        .status(Message.Status.IN_PROGRESS)
                        .phase(Message.Phase.COMMENTARY)
                        .build()
                )
            )
        assertThat(conversationItemList.firstId()).contains("first_id")
        assertThat(conversationItemList.hasMore()).contains(true)
        assertThat(conversationItemList.lastId()).contains("last_id")

        val jsonMapper = jsonMapper()

        val roundtrippedConversationItemList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemList),
                jacksonTypeRef<ConversationItemList>(),
            )

        assertThat(roundtrippedConversationItemList).isEqualTo(conversationItemList)
    }
}
