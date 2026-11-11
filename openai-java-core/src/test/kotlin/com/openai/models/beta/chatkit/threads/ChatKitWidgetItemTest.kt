// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatKitWidgetItemTest {

    @Test
    fun createAndRoundtrip() {
        val chatkitWidgetItem =
            ChatKitWidgetItem.builder()
                .id("id")
                .createdAt(0L)
                .threadId("thread_id")
                .widget("widget")
                .build()

        assertThat(chatkitWidgetItem.id()).contains("id")
        assertThat(chatkitWidgetItem.createdAt()).contains(0L)
        assertThat(chatkitWidgetItem.threadId()).contains("thread_id")
        assertThat(chatkitWidgetItem.widget()).contains("widget")

        val jsonMapper = jsonMapper()

        val roundtrippedChatKitWidgetItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatkitWidgetItem),
                jacksonTypeRef<ChatKitWidgetItem>(),
            )

        assertThat(roundtrippedChatKitWidgetItem).isEqualTo(chatkitWidgetItem)
    }
}
