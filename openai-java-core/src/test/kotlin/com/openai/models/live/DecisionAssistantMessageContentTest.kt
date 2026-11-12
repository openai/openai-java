// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class DecisionAssistantMessageContentTest {

    @Test
    fun ofString() {
        val string = "string"

        val decisionAssistantMessageContent = DecisionAssistantMessageContent.ofString(string)

        assertThat(decisionAssistantMessageContent.string()).contains(string)
    }

    @Test
    fun ofStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionAssistantMessageContent = DecisionAssistantMessageContent.ofString("string")

        val roundtrippedDecisionAssistantMessageContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionAssistantMessageContent),
                jacksonTypeRef<DecisionAssistantMessageContent>(),
            )

        assertThat(roundtrippedDecisionAssistantMessageContent)
            .isEqualTo(decisionAssistantMessageContent)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        OBJECT(JsonValue.from(mapOf("invalid" to "object"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val decisionAssistantMessageContent =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<DecisionAssistantMessageContent>())

        val e =
            assertThrows<OpenAIInvalidDataException> { decisionAssistantMessageContent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
