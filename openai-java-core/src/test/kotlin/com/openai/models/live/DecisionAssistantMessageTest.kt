// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionAssistantMessageTest {

    @Test
    fun createAndRoundtrip() {
        val decisionAssistantMessage =
            DecisionAssistantMessage.builder()
                .content("string")
                .id("id")
                .phase(DecisionAssistantMessage.Phase.COMMENTARY)
                .type(DecisionAssistantMessage.Type.MESSAGE)
                .build()

        assertThat(decisionAssistantMessage.content())
            .contains(DecisionAssistantMessageContent.ofString("string"))
        assertThat(decisionAssistantMessage.id()).contains("id")
        assertThat(decisionAssistantMessage.phase())
            .contains(DecisionAssistantMessage.Phase.COMMENTARY)
        assertThat(decisionAssistantMessage.type()).contains(JsonValue.from("message"))

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionAssistantMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionAssistantMessage),
                jacksonTypeRef<DecisionAssistantMessage>(),
            )

        assertThat(roundtrippedDecisionAssistantMessage).isEqualTo(decisionAssistantMessage)
    }
}
