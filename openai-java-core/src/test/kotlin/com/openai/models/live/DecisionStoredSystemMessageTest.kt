// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionStoredSystemMessageTest {

    @Test
    fun createAndRoundtrip() {
        val decisionStoredSystemMessage =
            DecisionStoredSystemMessage.builder()
                .id("id")
                .content("string")
                .type(DecisionStoredSystemMessage.Type.MESSAGE)
                .build()

        assertThat(decisionStoredSystemMessage.id()).contains("id")
        assertThat(decisionStoredSystemMessage.content())
            .contains(DecisionStoredSystemMessage.Content.ofString("string"))
        assertThat(decisionStoredSystemMessage.type()).contains(JsonValue.from("message"))

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionStoredSystemMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionStoredSystemMessage),
                jacksonTypeRef<DecisionStoredSystemMessage>(),
            )

        assertThat(roundtrippedDecisionStoredSystemMessage).isEqualTo(decisionStoredSystemMessage)
    }
}
