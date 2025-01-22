// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChatCompletionAssistantMessageParamTest {

    @Test
    fun createChatCompletionAssistantMessageParam() {
        val chatCompletionAssistantMessageParam =
            ChatCompletionAssistantMessageParam.builder()
                .audio(ChatCompletionAssistantMessageParam.Audio.builder().id("id").build())
                .content("string")
                .functionCall(
                    ChatCompletionAssistantMessageParam.FunctionCall.builder()
                        .arguments("arguments")
                        .name("name")
                        .build()
                )
                .name("name")
                .refusal("refusal")
                .addToolCall(
                    ChatCompletionMessageToolCall.builder()
                        .id("id")
                        .function(
                            ChatCompletionMessageToolCall.Function.builder()
                                .arguments("arguments")
                                .name("name")
                                .build()
                        )
                        .build()
                )
                .build()
        assertThat(chatCompletionAssistantMessageParam).isNotNull
        assertThat(chatCompletionAssistantMessageParam.audio())
            .contains(ChatCompletionAssistantMessageParam.Audio.builder().id("id").build())
        assertThat(chatCompletionAssistantMessageParam.content())
            .contains(ChatCompletionAssistantMessageParam.Content.ofTextContent("string"))
        assertThat(chatCompletionAssistantMessageParam.functionCall())
            .contains(
                ChatCompletionAssistantMessageParam.FunctionCall.builder()
                    .arguments("arguments")
                    .name("name")
                    .build()
            )
        assertThat(chatCompletionAssistantMessageParam.name()).contains("name")
        assertThat(chatCompletionAssistantMessageParam.refusal()).contains("refusal")
        assertThat(chatCompletionAssistantMessageParam.toolCalls().get())
            .containsExactly(
                ChatCompletionMessageToolCall.builder()
                    .id("id")
                    .function(
                        ChatCompletionMessageToolCall.Function.builder()
                            .arguments("arguments")
                            .name("name")
                            .build()
                    )
                    .build()
            )
    }
}
