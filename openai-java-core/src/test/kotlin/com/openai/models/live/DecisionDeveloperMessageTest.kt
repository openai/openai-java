// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionDeveloperMessageTest {

    @Test
    fun createAndRoundtrip() {
        val decisionDeveloperMessage =
            DecisionDeveloperMessage.builder()
                .content("string")
                .id("id")
                .type(DecisionDeveloperMessage.Type.MESSAGE)
                .build()

        assertThat(decisionDeveloperMessage.content())
            .contains(DecisionDeveloperMessage.Content.ofString("string"))
        assertThat(decisionDeveloperMessage.id()).contains("id")
        assertThat(decisionDeveloperMessage.type()).contains(JsonValue.from("message"))

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionDeveloperMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionDeveloperMessage),
                jacksonTypeRef<DecisionDeveloperMessage>(),
            )

        assertThat(roundtrippedDecisionDeveloperMessage).isEqualTo(decisionDeveloperMessage)
    }
}
