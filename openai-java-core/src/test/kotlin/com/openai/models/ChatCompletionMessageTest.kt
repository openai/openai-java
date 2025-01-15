// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionMessageTest {

    @Test
    fun createChatCompletionMessage() {
        val chatCompletionMessage =
            ChatCompletionMessage.builder()
                .content("content")
                .refusal("refusal")
                .role(ChatCompletionMessage.Role.ASSISTANT)
                .audio(
                    ChatCompletionAudio.builder()
                        .id("id")
                        .data("data")
                        .expiresAt(0L)
                        .transcript("transcript")
                        .build()
                )
                .functionCall(
                    ChatCompletionMessage.FunctionCall.builder()
                        .arguments("arguments")
                        .name("name")
                        .build()
                )
                .addToolCall(
                    ChatCompletionMessageToolCall.builder()
                        .id("id")
                        .function(
                            ChatCompletionMessageToolCall.Function.builder()
                                .arguments("arguments")
                                .name("name")
                                .build()
                        )
                        .type(ChatCompletionMessageToolCall.Type.FUNCTION)
                        .build()
                )
                .build()
        assertThat(chatCompletionMessage).isNotNull
        assertThat(chatCompletionMessage.content()).contains("content")
        assertThat(chatCompletionMessage.refusal()).contains("refusal")
        assertThat(chatCompletionMessage.role()).isEqualTo(ChatCompletionMessage.Role.ASSISTANT)
        assertThat(chatCompletionMessage.audio())
            .contains(
                ChatCompletionAudio.builder()
                    .id("id")
                    .data("data")
                    .expiresAt(0L)
                    .transcript("transcript")
                    .build()
            )
        assertThat(chatCompletionMessage.functionCall())
            .contains(
                ChatCompletionMessage.FunctionCall.builder()
                    .arguments("arguments")
                    .name("name")
                    .build()
            )
        assertThat(chatCompletionMessage.toolCalls().get())
            .containsExactly(
                ChatCompletionMessageToolCall.builder()
                    .id("id")
                    .function(
                        ChatCompletionMessageToolCall.Function.builder()
                            .arguments("arguments")
                            .name("name")
                            .build()
                    )
                    .type(ChatCompletionMessageToolCall.Type.FUNCTION)
                    .build()
            )
    }
}
