// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionStoredUserMessageTest {

    @Test
    fun createAndRoundtrip() {
        val decisionStoredUserMessage =
            DecisionStoredUserMessage.builder()
                .id("id")
                .content("string")
                .type(DecisionStoredUserMessage.Type.MESSAGE)
                .build()

        assertThat(decisionStoredUserMessage.id()).contains("id")
        assertThat(decisionStoredUserMessage.content())
            .contains(DecisionStoredUserMessage.Content.ofString("string"))
        assertThat(decisionStoredUserMessage.type()).contains(JsonValue.from("message"))

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionStoredUserMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionStoredUserMessage),
                jacksonTypeRef<DecisionStoredUserMessage>(),
            )

        assertThat(roundtrippedDecisionStoredUserMessage).isEqualTo(decisionStoredUserMessage)
    }
}
