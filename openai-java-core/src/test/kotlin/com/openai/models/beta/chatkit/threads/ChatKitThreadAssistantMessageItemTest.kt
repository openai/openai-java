// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatKitThreadAssistantMessageItemTest {

    @Test
    fun create() {
        val chatkitThreadAssistantMessageItem =
            ChatKitThreadAssistantMessageItem.builder()
                .id("id")
                .addContent(
                    ChatKitResponseOutputText.builder()
                        .addFileAnnotation(
                            ChatKitResponseOutputText.Annotation.File.Source.builder()
                                .filename("filename")
                                .build()
                        )
                        .text("text")
                        .build()
                )
                .createdAt(0L)
                .threadId("thread_id")
                .build()

        assertThat(chatkitThreadAssistantMessageItem.id()).isEqualTo("id")
        assertThat(chatkitThreadAssistantMessageItem.content())
            .containsExactly(
                ChatKitResponseOutputText.builder()
                    .addFileAnnotation(
                        ChatKitResponseOutputText.Annotation.File.Source.builder()
                            .filename("filename")
                            .build()
                    )
                    .text("text")
                    .build()
            )
        assertThat(chatkitThreadAssistantMessageItem.createdAt()).isEqualTo(0L)
        assertThat(chatkitThreadAssistantMessageItem.threadId()).isEqualTo("thread_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatkitThreadAssistantMessageItem =
            ChatKitThreadAssistantMessageItem.builder()
                .id("id")
                .addContent(
                    ChatKitResponseOutputText.builder()
                        .addFileAnnotation(
                            ChatKitResponseOutputText.Annotation.File.Source.builder()
                                .filename("filename")
                                .build()
                        )
                        .text("text")
                        .build()
                )
                .createdAt(0L)
                .threadId("thread_id")
                .build()

        val roundtrippedChatKitThreadAssistantMessageItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatkitThreadAssistantMessageItem),
                jacksonTypeRef<ChatKitThreadAssistantMessageItem>(),
            )

        assertThat(roundtrippedChatKitThreadAssistantMessageItem)
            .isEqualTo(chatkitThreadAssistantMessageItem)
    }
}
