// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionStoreMessageTest {

    @Test
    fun create() {
        val chatCompletionStoreMessage =
            ChatCompletionStoreMessage.builder()
                .content("content")
                .refusal("refusal")
                .addAnnotation(
                    ChatCompletionMessage.Annotation.builder()
                        .urlCitation(
                            ChatCompletionMessage.Annotation.UrlCitation.builder()
                                .endIndex(0L)
                                .startIndex(0L)
                                .title("title")
                                .url("url")
                                .build()
                        )
                        .build()
                )
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
                        .build()
                )
                .id("id")
                .build()

        assertThat(chatCompletionStoreMessage.content()).contains("content")
        assertThat(chatCompletionStoreMessage.refusal()).contains("refusal")
        assertThat(chatCompletionStoreMessage.annotations().getOrNull())
            .containsExactly(
                ChatCompletionMessage.Annotation.builder()
                    .urlCitation(
                        ChatCompletionMessage.Annotation.UrlCitation.builder()
                            .endIndex(0L)
                            .startIndex(0L)
                            .title("title")
                            .url("url")
                            .build()
                    )
                    .build()
            )
        assertThat(chatCompletionStoreMessage.audio())
            .contains(
                ChatCompletionAudio.builder()
                    .id("id")
                    .data("data")
                    .expiresAt(0L)
                    .transcript("transcript")
                    .build()
            )
        assertThat(chatCompletionStoreMessage.functionCall())
            .contains(
                ChatCompletionMessage.FunctionCall.builder()
                    .arguments("arguments")
                    .name("name")
                    .build()
            )
        assertThat(chatCompletionStoreMessage.toolCalls().getOrNull())
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
        assertThat(chatCompletionStoreMessage.id()).isEqualTo("id")
    }
}
