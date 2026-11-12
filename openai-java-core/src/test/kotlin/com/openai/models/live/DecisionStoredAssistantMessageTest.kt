// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionStoredAssistantMessageTest {

    @Test
    fun createAndRoundtrip() {
        val decisionStoredAssistantMessage =
            DecisionStoredAssistantMessage.builder()
                .id("id")
                .content("string")
                .phase(DecisionStoredAssistantMessage.Phase.COMMENTARY)
                .type(DecisionStoredAssistantMessage.Type.MESSAGE)
                .build()

        assertThat(decisionStoredAssistantMessage.id()).contains("id")
        assertThat(decisionStoredAssistantMessage.content())
            .contains(DecisionAssistantMessageContent.ofString("string"))
        assertThat(decisionStoredAssistantMessage.phase())
            .contains(DecisionStoredAssistantMessage.Phase.COMMENTARY)
        assertThat(decisionStoredAssistantMessage.type()).contains(JsonValue.from("message"))

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionStoredAssistantMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionStoredAssistantMessage),
                jacksonTypeRef<DecisionStoredAssistantMessage>(),
            )

        assertThat(roundtrippedDecisionStoredAssistantMessage)
            .isEqualTo(decisionStoredAssistantMessage)
    }
}
