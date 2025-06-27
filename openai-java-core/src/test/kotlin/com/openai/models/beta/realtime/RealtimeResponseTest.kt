// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeResponseTest {

    @Test
    fun create() {
        val realtimeResponse =
            RealtimeResponse.builder()
                .id("id")
                .conversationId("conversation_id")
                .maxOutputTokens(0L)
                .metadata(
                    RealtimeResponse.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .addModality(RealtimeResponse.Modality.TEXT)
                .object_(RealtimeResponse.Object.REALTIME_RESPONSE)
                .addOutput(
                    ConversationItem.builder()
                        .id("id")
                        .arguments("arguments")
                        .callId("call_id")
                        .addContent(
                            ConversationItemContent.builder()
                                .id("id")
                                .audio("audio")
                                .text("text")
                                .transcript("transcript")
                                .type(ConversationItemContent.Type.INPUT_TEXT)
                                .build()
                        )
                        .name("name")
                        .object_(ConversationItem.Object.REALTIME_ITEM)
                        .output("output")
                        .role(ConversationItem.Role.USER)
                        .status(ConversationItem.Status.COMPLETED)
                        .type(ConversationItem.Type.MESSAGE)
                        .build()
                )
                .outputAudioFormat(RealtimeResponse.OutputAudioFormat.PCM16)
                .status(RealtimeResponse.Status.COMPLETED)
                .statusDetails(
                    RealtimeResponseStatus.builder()
                        .error(
                            RealtimeResponseStatus.Error.builder().code("code").type("type").build()
                        )
                        .reason(RealtimeResponseStatus.Reason.TURN_DETECTED)
                        .type(RealtimeResponseStatus.Type.COMPLETED)
                        .build()
                )
                .temperature(0.0)
                .usage(
                    RealtimeResponseUsage.builder()
                        .inputTokenDetails(
                            RealtimeResponseUsage.InputTokenDetails.builder()
                                .audioTokens(0L)
                                .cachedTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .inputTokens(0L)
                        .outputTokenDetails(
                            RealtimeResponseUsage.OutputTokenDetails.builder()
                                .audioTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .outputTokens(0L)
                        .totalTokens(0L)
                        .build()
                )
                .voice(RealtimeResponse.Voice.ALLOY)
                .build()

        assertThat(realtimeResponse.id()).contains("id")
        assertThat(realtimeResponse.conversationId()).contains("conversation_id")
        assertThat(realtimeResponse.maxOutputTokens())
            .contains(RealtimeResponse.MaxOutputTokens.ofInteger(0L))
        assertThat(realtimeResponse.metadata())
            .contains(
                RealtimeResponse.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(realtimeResponse.modalities().getOrNull())
            .containsExactly(RealtimeResponse.Modality.TEXT)
        assertThat(realtimeResponse.object_()).contains(RealtimeResponse.Object.REALTIME_RESPONSE)
        assertThat(realtimeResponse.output().getOrNull())
            .containsExactly(
                ConversationItem.builder()
                    .id("id")
                    .arguments("arguments")
                    .callId("call_id")
                    .addContent(
                        ConversationItemContent.builder()
                            .id("id")
                            .audio("audio")
                            .text("text")
                            .transcript("transcript")
                            .type(ConversationItemContent.Type.INPUT_TEXT)
                            .build()
                    )
                    .name("name")
                    .object_(ConversationItem.Object.REALTIME_ITEM)
                    .output("output")
                    .role(ConversationItem.Role.USER)
                    .status(ConversationItem.Status.COMPLETED)
                    .type(ConversationItem.Type.MESSAGE)
                    .build()
            )
        assertThat(realtimeResponse.outputAudioFormat())
            .contains(RealtimeResponse.OutputAudioFormat.PCM16)
        assertThat(realtimeResponse.status()).contains(RealtimeResponse.Status.COMPLETED)
        assertThat(realtimeResponse.statusDetails())
            .contains(
                RealtimeResponseStatus.builder()
                    .error(RealtimeResponseStatus.Error.builder().code("code").type("type").build())
                    .reason(RealtimeResponseStatus.Reason.TURN_DETECTED)
                    .type(RealtimeResponseStatus.Type.COMPLETED)
                    .build()
            )
        assertThat(realtimeResponse.temperature()).contains(0.0)
        assertThat(realtimeResponse.usage())
            .contains(
                RealtimeResponseUsage.builder()
                    .inputTokenDetails(
                        RealtimeResponseUsage.InputTokenDetails.builder()
                            .audioTokens(0L)
                            .cachedTokens(0L)
                            .textTokens(0L)
                            .build()
                    )
                    .inputTokens(0L)
                    .outputTokenDetails(
                        RealtimeResponseUsage.OutputTokenDetails.builder()
                            .audioTokens(0L)
                            .textTokens(0L)
                            .build()
                    )
                    .outputTokens(0L)
                    .totalTokens(0L)
                    .build()
            )
        assertThat(realtimeResponse.voice()).contains(RealtimeResponse.Voice.ALLOY)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeResponse =
            RealtimeResponse.builder()
                .id("id")
                .conversationId("conversation_id")
                .maxOutputTokens(0L)
                .metadata(
                    RealtimeResponse.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .addModality(RealtimeResponse.Modality.TEXT)
                .object_(RealtimeResponse.Object.REALTIME_RESPONSE)
                .addOutput(
                    ConversationItem.builder()
                        .id("id")
                        .arguments("arguments")
                        .callId("call_id")
                        .addContent(
                            ConversationItemContent.builder()
                                .id("id")
                                .audio("audio")
                                .text("text")
                                .transcript("transcript")
                                .type(ConversationItemContent.Type.INPUT_TEXT)
                                .build()
                        )
                        .name("name")
                        .object_(ConversationItem.Object.REALTIME_ITEM)
                        .output("output")
                        .role(ConversationItem.Role.USER)
                        .status(ConversationItem.Status.COMPLETED)
                        .type(ConversationItem.Type.MESSAGE)
                        .build()
                )
                .outputAudioFormat(RealtimeResponse.OutputAudioFormat.PCM16)
                .status(RealtimeResponse.Status.COMPLETED)
                .statusDetails(
                    RealtimeResponseStatus.builder()
                        .error(
                            RealtimeResponseStatus.Error.builder().code("code").type("type").build()
                        )
                        .reason(RealtimeResponseStatus.Reason.TURN_DETECTED)
                        .type(RealtimeResponseStatus.Type.COMPLETED)
                        .build()
                )
                .temperature(0.0)
                .usage(
                    RealtimeResponseUsage.builder()
                        .inputTokenDetails(
                            RealtimeResponseUsage.InputTokenDetails.builder()
                                .audioTokens(0L)
                                .cachedTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .inputTokens(0L)
                        .outputTokenDetails(
                            RealtimeResponseUsage.OutputTokenDetails.builder()
                                .audioTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .outputTokens(0L)
                        .totalTokens(0L)
                        .build()
                )
                .voice(RealtimeResponse.Voice.ALLOY)
                .build()

        val roundtrippedRealtimeResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeResponse),
                jacksonTypeRef<RealtimeResponse>(),
            )

        assertThat(roundtrippedRealtimeResponse).isEqualTo(realtimeResponse)
    }
}
