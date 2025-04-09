// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.chat.completions.ChatCompletionAudio
import com.openai.models.chat.completions.ChatCompletionMessage
import com.openai.models.chat.completions.ChatCompletionMessageToolCall
import com.openai.models.chat.completions.ChatCompletionStoreMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageListPageResponseTest {

    @Test
    fun create() {
        val messageListPageResponse =
            MessageListPageResponse.builder()
                .addData(
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(messageListPageResponse.data())
            .containsExactly(
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
            )
        assertThat(messageListPageResponse.firstId()).isEqualTo("first_id")
        assertThat(messageListPageResponse.hasMore()).isEqualTo(true)
        assertThat(messageListPageResponse.lastId()).isEqualTo("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageListPageResponse =
            MessageListPageResponse.builder()
                .addData(
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedMessageListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageListPageResponse),
                jacksonTypeRef<MessageListPageResponse>(),
            )

        assertThat(roundtrippedMessageListPageResponse).isEqualTo(messageListPageResponse)
    }
}
