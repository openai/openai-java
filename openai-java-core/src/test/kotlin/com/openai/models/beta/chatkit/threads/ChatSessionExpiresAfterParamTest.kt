// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatSessionExpiresAfterParamTest {

    @Test
    fun create() {
        val chatSessionExpiresAfterParam =
            ChatSessionExpiresAfterParam.builder().seconds(1L).build()

        assertThat(chatSessionExpiresAfterParam.seconds()).isEqualTo(1L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatSessionExpiresAfterParam =
            ChatSessionExpiresAfterParam.builder().seconds(1L).build()

        val roundtrippedChatSessionExpiresAfterParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatSessionExpiresAfterParam),
                jacksonTypeRef<ChatSessionExpiresAfterParam>(),
            )

        assertThat(roundtrippedChatSessionExpiresAfterParam).isEqualTo(chatSessionExpiresAfterParam)
    }
}
