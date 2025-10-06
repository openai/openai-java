// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatSessionRateLimitsTest {

    @Test
    fun create() {
        val chatSessionRateLimits =
            ChatSessionRateLimits.builder().maxRequestsPer1Minute(0L).build()

        assertThat(chatSessionRateLimits.maxRequestsPer1Minute()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatSessionRateLimits =
            ChatSessionRateLimits.builder().maxRequestsPer1Minute(0L).build()

        val roundtrippedChatSessionRateLimits =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatSessionRateLimits),
                jacksonTypeRef<ChatSessionRateLimits>(),
            )

        assertThat(roundtrippedChatSessionRateLimits).isEqualTo(chatSessionRateLimits)
    }
}
