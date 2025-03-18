// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionAssistantMessageParamTest {

    @Test
    fun create() {
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

        assertThat(chatCompletionAssistantMessageParam.audio())
            .contains(ChatCompletionAssistantMessageParam.Audio.builder().id("id").build())
        assertThat(chatCompletionAssistantMessageParam.content())
            .contains(ChatCompletionAssistantMessageParam.Content.ofText("string"))
        assertThat(chatCompletionAssistantMessageParam.functionCall())
            .contains(
                ChatCompletionAssistantMessageParam.FunctionCall.builder()
                    .arguments("arguments")
                    .name("name")
                    .build()
            )
        assertThat(chatCompletionAssistantMessageParam.name()).contains("name")
        assertThat(chatCompletionAssistantMessageParam.refusal()).contains("refusal")
        assertThat(chatCompletionAssistantMessageParam.toolCalls().getOrNull())
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
