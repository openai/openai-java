// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
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
                    ChatCompletionMessageFunctionToolCall.builder()
                        .id("id")
                        .function(
                            ChatCompletionMessageFunctionToolCall.Function.builder()
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
                ChatCompletionMessageToolCall.ofFunction(
                    ChatCompletionMessageFunctionToolCall.builder()
                        .id("id")
                        .function(
                            ChatCompletionMessageFunctionToolCall.Function.builder()
                                .arguments("arguments")
                                .name("name")
                                .build()
                        )
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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
                    ChatCompletionMessageFunctionToolCall.builder()
                        .id("id")
                        .function(
                            ChatCompletionMessageFunctionToolCall.Function.builder()
                                .arguments("arguments")
                                .name("name")
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedChatCompletionAssistantMessageParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionAssistantMessageParam),
                jacksonTypeRef<ChatCompletionAssistantMessageParam>(),
            )

        assertThat(roundtrippedChatCompletionAssistantMessageParam)
            .isEqualTo(chatCompletionAssistantMessageParam)
    }
}
