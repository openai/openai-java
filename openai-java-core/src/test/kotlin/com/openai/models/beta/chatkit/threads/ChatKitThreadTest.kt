// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatKitThreadTest {

    @Test
    fun create() {
        val chatkitThread =
            ChatKitThread.builder()
                .id("cthr_def456")
                .createdAt(1712345600L)
                .statusActive()
                .title("Demo feedback")
                .user("user_456")
                .build()

        assertThat(chatkitThread.id()).isEqualTo("cthr_def456")
        assertThat(chatkitThread.createdAt()).isEqualTo(1712345600L)
        assertThat(chatkitThread.status()).isEqualTo(ChatKitThread.Status.ofActive())
        assertThat(chatkitThread.title()).contains("Demo feedback")
        assertThat(chatkitThread.user()).isEqualTo("user_456")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatkitThread =
            ChatKitThread.builder()
                .id("cthr_def456")
                .createdAt(1712345600L)
                .statusActive()
                .title("Demo feedback")
                .user("user_456")
                .build()

        val roundtrippedChatKitThread =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatkitThread),
                jacksonTypeRef<ChatKitThread>(),
            )

        assertThat(roundtrippedChatKitThread).isEqualTo(chatkitThread)
    }
}
