// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionContentPartRefusalTest {

    @Test
    fun create() {
        val chatCompletionContentPartRefusal =
            ChatCompletionContentPartRefusal.builder().refusal("refusal").build()

        assertThat(chatCompletionContentPartRefusal.refusal()).isEqualTo("refusal")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionContentPartRefusal =
            ChatCompletionContentPartRefusal.builder().refusal("refusal").build()

        val roundtrippedChatCompletionContentPartRefusal =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionContentPartRefusal),
                jacksonTypeRef<ChatCompletionContentPartRefusal>(),
            )

        assertThat(roundtrippedChatCompletionContentPartRefusal)
            .isEqualTo(chatCompletionContentPartRefusal)
    }
}
