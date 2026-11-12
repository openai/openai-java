// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionUserMessageTest {

    @Test
    fun createAndRoundtrip() {
        val decisionUserMessage =
            DecisionUserMessage.builder()
                .content("string")
                .id("id")
                .type(DecisionUserMessage.Type.MESSAGE)
                .build()

        assertThat(decisionUserMessage.content())
            .contains(DecisionUserMessage.Content.ofString("string"))
        assertThat(decisionUserMessage.id()).contains("id")
        assertThat(decisionUserMessage.type()).contains(JsonValue.from("message"))

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionUserMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionUserMessage),
                jacksonTypeRef<DecisionUserMessage>(),
            )

        assertThat(roundtrippedDecisionUserMessage).isEqualTo(decisionUserMessage)
    }
}
