// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.completions.CompletionUsage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionListPageResponseTest {

    @Test
    fun create() {
        val chatCompletionListPageResponse =
            ChatCompletionListPageResponse.builder()
                .addData(
                    ChatCompletion.builder()
                        .id("id")
                        .addChoice(
                            ChatCompletion.Choice.builder()
                                .finishReason(ChatCompletion.Choice.FinishReason.STOP)
                                .index(0L)
                                .logprobs(
                                    ChatCompletion.Choice.Logprobs.builder()
                                        .addContent(
                                            ChatCompletionTokenLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .addTopLogprob(
                                                    ChatCompletionTokenLogprob.TopLogprob.builder()
                                                        .token("token")
                                                        .addByte(0L)
                                                        .logprob(0.0)
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .addRefusal(
                                            ChatCompletionTokenLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .addTopLogprob(
                                                    ChatCompletionTokenLogprob.TopLogprob.builder()
                                                        .token("token")
                                                        .addByte(0L)
                                                        .logprob(0.0)
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .message(
                                    ChatCompletionMessage.builder()
                                        .content("content")
                                        .refusal("refusal")
                                        .addAnnotation(
                                            ChatCompletionMessage.Annotation.builder()
                                                .urlCitation(
                                                    ChatCompletionMessage.Annotation.UrlCitation
                                                        .builder()
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
                                        .build()
                                )
                                .build()
                        )
                        .created(0L)
                        .model("model")
                        .serviceTier(ChatCompletion.ServiceTier.SCALE)
                        .systemFingerprint("system_fingerprint")
                        .usage(
                            CompletionUsage.builder()
                                .completionTokens(0L)
                                .promptTokens(0L)
                                .totalTokens(0L)
                                .completionTokensDetails(
                                    CompletionUsage.CompletionTokensDetails.builder()
                                        .acceptedPredictionTokens(0L)
                                        .audioTokens(0L)
                                        .reasoningTokens(0L)
                                        .rejectedPredictionTokens(0L)
                                        .build()
                                )
                                .promptTokensDetails(
                                    CompletionUsage.PromptTokensDetails.builder()
                                        .audioTokens(0L)
                                        .cachedTokens(0L)
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(chatCompletionListPageResponse.data())
            .containsExactly(
                ChatCompletion.builder()
                    .id("id")
                    .addChoice(
                        ChatCompletion.Choice.builder()
                            .finishReason(ChatCompletion.Choice.FinishReason.STOP)
                            .index(0L)
                            .logprobs(
                                ChatCompletion.Choice.Logprobs.builder()
                                    .addContent(
                                        ChatCompletionTokenLogprob.builder()
                                            .token("token")
                                            .addByte(0L)
                                            .logprob(0.0)
                                            .addTopLogprob(
                                                ChatCompletionTokenLogprob.TopLogprob.builder()
                                                    .token("token")
                                                    .addByte(0L)
                                                    .logprob(0.0)
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .addRefusal(
                                        ChatCompletionTokenLogprob.builder()
                                            .token("token")
                                            .addByte(0L)
                                            .logprob(0.0)
                                            .addTopLogprob(
                                                ChatCompletionTokenLogprob.TopLogprob.builder()
                                                    .token("token")
                                                    .addByte(0L)
                                                    .logprob(0.0)
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .message(
                                ChatCompletionMessage.builder()
                                    .content("content")
                                    .refusal("refusal")
                                    .addAnnotation(
                                        ChatCompletionMessage.Annotation.builder()
                                            .urlCitation(
                                                ChatCompletionMessage.Annotation.UrlCitation
                                                    .builder()
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
                                    .build()
                            )
                            .build()
                    )
                    .created(0L)
                    .model("model")
                    .serviceTier(ChatCompletion.ServiceTier.SCALE)
                    .systemFingerprint("system_fingerprint")
                    .usage(
                        CompletionUsage.builder()
                            .completionTokens(0L)
                            .promptTokens(0L)
                            .totalTokens(0L)
                            .completionTokensDetails(
                                CompletionUsage.CompletionTokensDetails.builder()
                                    .acceptedPredictionTokens(0L)
                                    .audioTokens(0L)
                                    .reasoningTokens(0L)
                                    .rejectedPredictionTokens(0L)
                                    .build()
                            )
                            .promptTokensDetails(
                                CompletionUsage.PromptTokensDetails.builder()
                                    .audioTokens(0L)
                                    .cachedTokens(0L)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(chatCompletionListPageResponse.firstId()).isEqualTo("first_id")
        assertThat(chatCompletionListPageResponse.hasMore()).isEqualTo(true)
        assertThat(chatCompletionListPageResponse.lastId()).isEqualTo("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionListPageResponse =
            ChatCompletionListPageResponse.builder()
                .addData(
                    ChatCompletion.builder()
                        .id("id")
                        .addChoice(
                            ChatCompletion.Choice.builder()
                                .finishReason(ChatCompletion.Choice.FinishReason.STOP)
                                .index(0L)
                                .logprobs(
                                    ChatCompletion.Choice.Logprobs.builder()
                                        .addContent(
                                            ChatCompletionTokenLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .addTopLogprob(
                                                    ChatCompletionTokenLogprob.TopLogprob.builder()
                                                        .token("token")
                                                        .addByte(0L)
                                                        .logprob(0.0)
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .addRefusal(
                                            ChatCompletionTokenLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .addTopLogprob(
                                                    ChatCompletionTokenLogprob.TopLogprob.builder()
                                                        .token("token")
                                                        .addByte(0L)
                                                        .logprob(0.0)
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .message(
                                    ChatCompletionMessage.builder()
                                        .content("content")
                                        .refusal("refusal")
                                        .addAnnotation(
                                            ChatCompletionMessage.Annotation.builder()
                                                .urlCitation(
                                                    ChatCompletionMessage.Annotation.UrlCitation
                                                        .builder()
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
                                        .build()
                                )
                                .build()
                        )
                        .created(0L)
                        .model("model")
                        .serviceTier(ChatCompletion.ServiceTier.SCALE)
                        .systemFingerprint("system_fingerprint")
                        .usage(
                            CompletionUsage.builder()
                                .completionTokens(0L)
                                .promptTokens(0L)
                                .totalTokens(0L)
                                .completionTokensDetails(
                                    CompletionUsage.CompletionTokensDetails.builder()
                                        .acceptedPredictionTokens(0L)
                                        .audioTokens(0L)
                                        .reasoningTokens(0L)
                                        .rejectedPredictionTokens(0L)
                                        .build()
                                )
                                .promptTokensDetails(
                                    CompletionUsage.PromptTokensDetails.builder()
                                        .audioTokens(0L)
                                        .cachedTokens(0L)
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedChatCompletionListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionListPageResponse),
                jacksonTypeRef<ChatCompletionListPageResponse>(),
            )

        assertThat(roundtrippedChatCompletionListPageResponse)
            .isEqualTo(chatCompletionListPageResponse)
    }
}
