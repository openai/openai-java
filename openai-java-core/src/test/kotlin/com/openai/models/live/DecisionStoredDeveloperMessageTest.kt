// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionStoredDeveloperMessageTest {

    @Test
    fun createAndRoundtrip() {
        val decisionStoredDeveloperMessage =
            DecisionStoredDeveloperMessage.builder()
                .id("id")
                .content("string")
                .type(DecisionStoredDeveloperMessage.Type.MESSAGE)
                .build()

        assertThat(decisionStoredDeveloperMessage.id()).contains("id")
        assertThat(decisionStoredDeveloperMessage.content())
            .contains(DecisionStoredDeveloperMessage.Content.ofString("string"))
        assertThat(decisionStoredDeveloperMessage.type()).contains(JsonValue.from("message"))

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionStoredDeveloperMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionStoredDeveloperMessage),
                jacksonTypeRef<DecisionStoredDeveloperMessage>(),
            )

        assertThat(roundtrippedDecisionStoredDeveloperMessage)
            .isEqualTo(decisionStoredDeveloperMessage)
    }
}
