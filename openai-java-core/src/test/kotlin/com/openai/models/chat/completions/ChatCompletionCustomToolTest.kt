// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionCustomToolTest {

    @Test
    fun create() {
        val chatCompletionCustomTool =
            ChatCompletionCustomTool.builder()
                .custom(
                    ChatCompletionCustomTool.Custom.builder()
                        .name("name")
                        .description("description")
                        .formatText()
                        .build()
                )
                .build()

        assertThat(chatCompletionCustomTool.custom())
            .isEqualTo(
                ChatCompletionCustomTool.Custom.builder()
                    .name("name")
                    .description("description")
                    .formatText()
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionCustomTool =
            ChatCompletionCustomTool.builder()
                .custom(
                    ChatCompletionCustomTool.Custom.builder()
                        .name("name")
                        .description("description")
                        .formatText()
                        .build()
                )
                .build()

        val roundtrippedChatCompletionCustomTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionCustomTool),
                jacksonTypeRef<ChatCompletionCustomTool>(),
            )

        assertThat(roundtrippedChatCompletionCustomTool).isEqualTo(chatCompletionCustomTool)
    }
}
