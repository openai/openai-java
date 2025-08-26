// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations.items

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.conversations.Message
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemListTest {

    @Test
    fun create() {
        val conversationItemList =
            ConversationItemList.builder()
                .addData(
                    Message.builder()
                        .id("id")
                        .addInputTextContent("text")
                        .role(Message.Role.UNKNOWN)
                        .status(Message.Status.IN_PROGRESS)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(conversationItemList.data())
            .containsExactly(
                ConversationItem.ofMessage(
                    Message.builder()
                        .id("id")
                        .addInputTextContent("text")
                        .role(Message.Role.UNKNOWN)
                        .status(Message.Status.IN_PROGRESS)
                        .build()
                )
            )
        assertThat(conversationItemList.firstId()).isEqualTo("first_id")
        assertThat(conversationItemList.hasMore()).isEqualTo(true)
        assertThat(conversationItemList.lastId()).isEqualTo("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItemList =
            ConversationItemList.builder()
                .addData(
                    Message.builder()
                        .id("id")
                        .addInputTextContent("text")
                        .role(Message.Role.UNKNOWN)
                        .status(Message.Status.IN_PROGRESS)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedConversationItemList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemList),
                jacksonTypeRef<ConversationItemList>(),
            )

        assertThat(roundtrippedConversationItemList).isEqualTo(conversationItemList)
    }
}
