// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatSessionRateLimitsParamTest {

    @Test
    fun create() {
        val chatSessionRateLimitsParam =
            ChatSessionRateLimitsParam.builder().maxRequestsPer1Minute(1L).build()

        assertThat(chatSessionRateLimitsParam.maxRequestsPer1Minute()).contains(1L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatSessionRateLimitsParam =
            ChatSessionRateLimitsParam.builder().maxRequestsPer1Minute(1L).build()

        val roundtrippedChatSessionRateLimitsParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatSessionRateLimitsParam),
                jacksonTypeRef<ChatSessionRateLimitsParam>(),
            )

        assertThat(roundtrippedChatSessionRateLimitsParam).isEqualTo(chatSessionRateLimitsParam)
    }
}
