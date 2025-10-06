// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatKitThreadUserMessageItemTest {

    @Test
    fun create() {
        val chatkitThreadUserMessageItem =
            ChatKitThreadUserMessageItem.builder()
                .id("id")
                .addAttachment(
                    ChatKitAttachment.builder()
                        .id("id")
                        .mimeType("mime_type")
                        .name("name")
                        .previewUrl("preview_url")
                        .type(ChatKitAttachment.Type.IMAGE)
                        .build()
                )
                .addInputTextContent("text")
                .createdAt(0L)
                .inferenceOptions(
                    ChatKitThreadUserMessageItem.InferenceOptions.builder()
                        .model("model")
                        .toolChoice(
                            ChatKitThreadUserMessageItem.InferenceOptions.ToolChoice.builder()
                                .id("id")
                                .build()
                        )
                        .build()
                )
                .threadId("thread_id")
                .build()

        assertThat(chatkitThreadUserMessageItem.id()).isEqualTo("id")
        assertThat(chatkitThreadUserMessageItem.attachments())
            .containsExactly(
                ChatKitAttachment.builder()
                    .id("id")
                    .mimeType("mime_type")
                    .name("name")
                    .previewUrl("preview_url")
                    .type(ChatKitAttachment.Type.IMAGE)
                    .build()
            )
        assertThat(chatkitThreadUserMessageItem.content())
            .containsExactly(
                ChatKitThreadUserMessageItem.Content.ofInputText(
                    ChatKitThreadUserMessageItem.Content.InputText.builder().text("text").build()
                )
            )
        assertThat(chatkitThreadUserMessageItem.createdAt()).isEqualTo(0L)
        assertThat(chatkitThreadUserMessageItem.inferenceOptions())
            .contains(
                ChatKitThreadUserMessageItem.InferenceOptions.builder()
                    .model("model")
                    .toolChoice(
                        ChatKitThreadUserMessageItem.InferenceOptions.ToolChoice.builder()
                            .id("id")
                            .build()
                    )
                    .build()
            )
        assertThat(chatkitThreadUserMessageItem.threadId()).isEqualTo("thread_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatkitThreadUserMessageItem =
            ChatKitThreadUserMessageItem.builder()
                .id("id")
                .addAttachment(
                    ChatKitAttachment.builder()
                        .id("id")
                        .mimeType("mime_type")
                        .name("name")
                        .previewUrl("preview_url")
                        .type(ChatKitAttachment.Type.IMAGE)
                        .build()
                )
                .addInputTextContent("text")
                .createdAt(0L)
                .inferenceOptions(
                    ChatKitThreadUserMessageItem.InferenceOptions.builder()
                        .model("model")
                        .toolChoice(
                            ChatKitThreadUserMessageItem.InferenceOptions.ToolChoice.builder()
                                .id("id")
                                .build()
                        )
                        .build()
                )
                .threadId("thread_id")
                .build()

        val roundtrippedChatKitThreadUserMessageItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatkitThreadUserMessageItem),
                jacksonTypeRef<ChatKitThreadUserMessageItem>(),
            )

        assertThat(roundtrippedChatKitThreadUserMessageItem).isEqualTo(chatkitThreadUserMessageItem)
    }
}
