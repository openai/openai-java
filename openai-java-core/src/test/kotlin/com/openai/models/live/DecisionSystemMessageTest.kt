// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionSystemMessageTest {

    @Test
    fun createAndRoundtrip() {
        val decisionSystemMessage =
            DecisionSystemMessage.builder()
                .content("string")
                .id("id")
                .type(DecisionSystemMessage.Type.MESSAGE)
                .build()

        assertThat(decisionSystemMessage.content())
            .contains(DecisionSystemMessage.Content.ofString("string"))
        assertThat(decisionSystemMessage.id()).contains("id")
        assertThat(decisionSystemMessage.type()).contains(JsonValue.from("message"))

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionSystemMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionSystemMessage),
                jacksonTypeRef<DecisionSystemMessage>(),
            )

        assertThat(roundtrippedDecisionSystemMessage).isEqualTo(decisionSystemMessage)
    }
}
