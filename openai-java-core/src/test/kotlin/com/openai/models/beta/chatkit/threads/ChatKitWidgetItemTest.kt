// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatKitWidgetItemTest {

    @Test
    fun create() {
        val chatkitWidgetItem =
            ChatKitWidgetItem.builder()
                .id("id")
                .createdAt(0L)
                .threadId("thread_id")
                .widget("widget")
                .build()

        assertThat(chatkitWidgetItem.id()).isEqualTo("id")
        assertThat(chatkitWidgetItem.createdAt()).isEqualTo(0L)
        assertThat(chatkitWidgetItem.threadId()).isEqualTo("thread_id")
        assertThat(chatkitWidgetItem.widget()).isEqualTo("widget")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatkitWidgetItem =
            ChatKitWidgetItem.builder()
                .id("id")
                .createdAt(0L)
                .threadId("thread_id")
                .widget("widget")
                .build()

        val roundtrippedChatKitWidgetItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatkitWidgetItem),
                jacksonTypeRef<ChatKitWidgetItem>(),
            )

        assertThat(roundtrippedChatKitWidgetItem).isEqualTo(chatkitWidgetItem)
    }
}
