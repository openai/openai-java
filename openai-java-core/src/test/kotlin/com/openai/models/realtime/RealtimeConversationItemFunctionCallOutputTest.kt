// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeConversationItemFunctionCallOutputTest {

    @Test
    fun create() {
        val realtimeConversationItemFunctionCallOutput =
            RealtimeConversationItemFunctionCallOutput.builder()
                .callId("call_id")
                .output("output")
                .id("id")
                .object_(RealtimeConversationItemFunctionCallOutput.Object.REALTIME_ITEM)
                .status(RealtimeConversationItemFunctionCallOutput.Status.COMPLETED)
                .build()

        assertThat(realtimeConversationItemFunctionCallOutput.callId()).isEqualTo("call_id")
        assertThat(realtimeConversationItemFunctionCallOutput.output()).isEqualTo("output")
        assertThat(realtimeConversationItemFunctionCallOutput.id()).contains("id")
        assertThat(realtimeConversationItemFunctionCallOutput.object_())
            .contains(RealtimeConversationItemFunctionCallOutput.Object.REALTIME_ITEM)
        assertThat(realtimeConversationItemFunctionCallOutput.status())
            .contains(RealtimeConversationItemFunctionCallOutput.Status.COMPLETED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeConversationItemFunctionCallOutput =
            RealtimeConversationItemFunctionCallOutput.builder()
                .callId("call_id")
                .output("output")
                .id("id")
                .object_(RealtimeConversationItemFunctionCallOutput.Object.REALTIME_ITEM)
                .status(RealtimeConversationItemFunctionCallOutput.Status.COMPLETED)
                .build()

        val roundtrippedRealtimeConversationItemFunctionCallOutput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeConversationItemFunctionCallOutput),
                jacksonTypeRef<RealtimeConversationItemFunctionCallOutput>(),
            )

        assertThat(roundtrippedRealtimeConversationItemFunctionCallOutput)
            .isEqualTo(realtimeConversationItemFunctionCallOutput)
    }
}
