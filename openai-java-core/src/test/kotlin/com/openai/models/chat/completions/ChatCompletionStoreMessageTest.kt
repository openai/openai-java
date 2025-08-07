// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
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
                .id("id")
                .addContentPart(ChatCompletionContentPartText.builder().text("text").build())
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
        assertThat(chatCompletionStoreMessage.id()).isEqualTo("id")
        assertThat(chatCompletionStoreMessage.contentParts().getOrNull())
            .containsExactly(
                ChatCompletionStoreMessage.ContentPart.ofChatCompletionContentPartText(
                    ChatCompletionContentPartText.builder().text("text").build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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
                .id("id")
                .addContentPart(ChatCompletionContentPartText.builder().text("text").build())
                .build()

        val roundtrippedChatCompletionStoreMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionStoreMessage),
                jacksonTypeRef<ChatCompletionStoreMessage>(),
            )

        assertThat(roundtrippedChatCompletionStoreMessage).isEqualTo(chatCompletionStoreMessage)
    }
}
