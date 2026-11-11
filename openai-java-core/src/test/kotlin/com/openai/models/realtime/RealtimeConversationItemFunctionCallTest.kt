// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeConversationItemFunctionCallTest {

    @Test
    fun createAndRoundtrip() {
        val realtimeConversationItemFunctionCall =
            RealtimeConversationItemFunctionCall.builder()
                .arguments("arguments")
                .name("name")
                .id("id")
                .callId("call_id")
                .object_(RealtimeConversationItemFunctionCall.Object.REALTIME_ITEM)
                .status(RealtimeConversationItemFunctionCall.Status.COMPLETED)
                .build()

        assertThat(realtimeConversationItemFunctionCall.arguments()).contains("arguments")
        assertThat(realtimeConversationItemFunctionCall.name()).contains("name")
        assertThat(realtimeConversationItemFunctionCall.id()).contains("id")
        assertThat(realtimeConversationItemFunctionCall.callId()).contains("call_id")
        assertThat(realtimeConversationItemFunctionCall.object_())
            .contains(JsonValue.from("realtime.item"))
        assertThat(realtimeConversationItemFunctionCall.status())
            .contains(RealtimeConversationItemFunctionCall.Status.COMPLETED)

        val jsonMapper = jsonMapper()

        val roundtrippedRealtimeConversationItemFunctionCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeConversationItemFunctionCall),
                jacksonTypeRef<RealtimeConversationItemFunctionCall>(),
            )

        assertThat(roundtrippedRealtimeConversationItemFunctionCall)
            .isEqualTo(realtimeConversationItemFunctionCall)
    }
}
