// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionAllowedToolChoiceTest {

    @Test
    fun create() {
        val chatCompletionAllowedToolChoice =
            ChatCompletionAllowedToolChoice.builder()
                .allowedTools(
                    ChatCompletionAllowedTools.builder()
                        .mode(ChatCompletionAllowedTools.Mode.AUTO)
                        .addTool(
                            ChatCompletionAllowedTools.Tool.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(chatCompletionAllowedToolChoice.allowedTools())
            .isEqualTo(
                ChatCompletionAllowedTools.builder()
                    .mode(ChatCompletionAllowedTools.Mode.AUTO)
                    .addTool(
                        ChatCompletionAllowedTools.Tool.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionAllowedToolChoice =
            ChatCompletionAllowedToolChoice.builder()
                .allowedTools(
                    ChatCompletionAllowedTools.builder()
                        .mode(ChatCompletionAllowedTools.Mode.AUTO)
                        .addTool(
                            ChatCompletionAllowedTools.Tool.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedChatCompletionAllowedToolChoice =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionAllowedToolChoice),
                jacksonTypeRef<ChatCompletionAllowedToolChoice>(),
            )

        assertThat(roundtrippedChatCompletionAllowedToolChoice)
            .isEqualTo(chatCompletionAllowedToolChoice)
    }
}
