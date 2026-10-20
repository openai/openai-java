// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionInputMessageTest {

    @Test
    fun create() {
        val decisionInputMessage =
            DecisionInputMessage.builder()
                .content("string")
                .type(DecisionInputMessage.Type.MESSAGE)
                .build()

        assertThat(decisionInputMessage.content())
            .isEqualTo(DecisionInputMessage.Content.ofString("string"))
        assertThat(decisionInputMessage.type()).contains(DecisionInputMessage.Type.MESSAGE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val decisionInputMessage =
            DecisionInputMessage.builder()
                .content("string")
                .type(DecisionInputMessage.Type.MESSAGE)
                .build()

        val roundtrippedDecisionInputMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionInputMessage),
                jacksonTypeRef<DecisionInputMessage>(),
            )

        assertThat(roundtrippedDecisionInputMessage).isEqualTo(decisionInputMessage)
    }
}
