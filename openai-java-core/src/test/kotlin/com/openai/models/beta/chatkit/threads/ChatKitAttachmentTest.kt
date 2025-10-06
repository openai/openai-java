// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatKitAttachmentTest {

    @Test
    fun create() {
        val chatkitAttachment =
            ChatKitAttachment.builder()
                .id("id")
                .mimeType("mime_type")
                .name("name")
                .previewUrl("preview_url")
                .type(ChatKitAttachment.Type.IMAGE)
                .build()

        assertThat(chatkitAttachment.id()).isEqualTo("id")
        assertThat(chatkitAttachment.mimeType()).isEqualTo("mime_type")
        assertThat(chatkitAttachment.name()).isEqualTo("name")
        assertThat(chatkitAttachment.previewUrl()).contains("preview_url")
        assertThat(chatkitAttachment.type()).isEqualTo(ChatKitAttachment.Type.IMAGE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatkitAttachment =
            ChatKitAttachment.builder()
                .id("id")
                .mimeType("mime_type")
                .name("name")
                .previewUrl("preview_url")
                .type(ChatKitAttachment.Type.IMAGE)
                .build()

        val roundtrippedChatKitAttachment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatkitAttachment),
                jacksonTypeRef<ChatKitAttachment>(),
            )

        assertThat(roundtrippedChatKitAttachment).isEqualTo(chatkitAttachment)
    }
}
