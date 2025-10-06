// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatKitThreadItemListTest {

    @Test
    fun create() {
        val chatkitThreadItemList =
            ChatKitThreadItemList.builder()
                .addData(
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
                                    ChatKitThreadUserMessageItem.InferenceOptions.ToolChoice
                                        .builder()
                                        .id("id")
                                        .build()
                                )
                                .build()
                        )
                        .threadId("thread_id")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(chatkitThreadItemList.data())
            .containsExactly(
                ChatKitThreadItemList.Data.ofChatKitUserMessage(
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
                                    ChatKitThreadUserMessageItem.InferenceOptions.ToolChoice
                                        .builder()
                                        .id("id")
                                        .build()
                                )
                                .build()
                        )
                        .threadId("thread_id")
                        .build()
                )
            )
        assertThat(chatkitThreadItemList.firstId()).contains("first_id")
        assertThat(chatkitThreadItemList.hasMore()).isEqualTo(true)
        assertThat(chatkitThreadItemList.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatkitThreadItemList =
            ChatKitThreadItemList.builder()
                .addData(
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
                                    ChatKitThreadUserMessageItem.InferenceOptions.ToolChoice
                                        .builder()
                                        .id("id")
                                        .build()
                                )
                                .build()
                        )
                        .threadId("thread_id")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedChatKitThreadItemList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatkitThreadItemList),
                jacksonTypeRef<ChatKitThreadItemList>(),
            )

        assertThat(roundtrippedChatKitThreadItemList).isEqualTo(chatkitThreadItemList)
    }
}
