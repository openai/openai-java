// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionAllowedToolsTest {

    @Test
    fun create() {
        val chatCompletionAllowedTools =
            ChatCompletionAllowedTools.builder()
                .mode(ChatCompletionAllowedTools.Mode.AUTO)
                .addTool(
                    ChatCompletionAllowedTools.Tool.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        assertThat(chatCompletionAllowedTools.mode())
            .isEqualTo(ChatCompletionAllowedTools.Mode.AUTO)
        assertThat(chatCompletionAllowedTools.tools())
            .containsExactly(
                ChatCompletionAllowedTools.Tool.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionAllowedTools =
            ChatCompletionAllowedTools.builder()
                .mode(ChatCompletionAllowedTools.Mode.AUTO)
                .addTool(
                    ChatCompletionAllowedTools.Tool.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val roundtrippedChatCompletionAllowedTools =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionAllowedTools),
                jacksonTypeRef<ChatCompletionAllowedTools>(),
            )

        assertThat(roundtrippedChatCompletionAllowedTools).isEqualTo(chatCompletionAllowedTools)
    }
}
