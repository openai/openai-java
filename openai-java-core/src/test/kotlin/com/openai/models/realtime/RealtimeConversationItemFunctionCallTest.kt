// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeConversationItemFunctionCallTest {

    @Test
    fun create() {
        val realtimeConversationItemFunctionCall =
            RealtimeConversationItemFunctionCall.builder()
                .arguments("arguments")
                .name("name")
                .id("id")
                .callId("call_id")
                .object_(RealtimeConversationItemFunctionCall.Object.REALTIME_ITEM)
                .status(RealtimeConversationItemFunctionCall.Status.COMPLETED)
                .build()

        assertThat(realtimeConversationItemFunctionCall.arguments()).isEqualTo("arguments")
        assertThat(realtimeConversationItemFunctionCall.name()).isEqualTo("name")
        assertThat(realtimeConversationItemFunctionCall.id()).contains("id")
        assertThat(realtimeConversationItemFunctionCall.callId()).contains("call_id")
        assertThat(realtimeConversationItemFunctionCall.object_())
            .contains(RealtimeConversationItemFunctionCall.Object.REALTIME_ITEM)
        assertThat(realtimeConversationItemFunctionCall.status())
            .contains(RealtimeConversationItemFunctionCall.Status.COMPLETED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeConversationItemFunctionCall =
            RealtimeConversationItemFunctionCall.builder()
                .arguments("arguments")
                .name("name")
                .id("id")
                .callId("call_id")
                .object_(RealtimeConversationItemFunctionCall.Object.REALTIME_ITEM)
                .status(RealtimeConversationItemFunctionCall.Status.COMPLETED)
                .build()

        val roundtrippedRealtimeConversationItemFunctionCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeConversationItemFunctionCall),
                jacksonTypeRef<RealtimeConversationItemFunctionCall>(),
            )

        assertThat(roundtrippedRealtimeConversationItemFunctionCall)
            .isEqualTo(realtimeConversationItemFunctionCall)
    }
}
