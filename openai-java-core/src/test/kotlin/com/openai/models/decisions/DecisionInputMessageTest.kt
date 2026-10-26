// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class DecisionInputMessageTest {

    @Test
    fun ofUser() {
        val user =
            DecisionInputMessage.User.builder()
                .content("string")
                .type(DecisionInputMessage.User.Type.MESSAGE)
                .build()

        val decisionInputMessage = DecisionInputMessage.ofUser(user)

        assertThat(decisionInputMessage.user()).contains(user)
        assertThat(decisionInputMessage.developer()).isEmpty
        assertThat(decisionInputMessage.system()).isEmpty
        assertThat(decisionInputMessage.assistant()).isEmpty
    }

    @Test
    fun ofUserRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionInputMessage =
            DecisionInputMessage.ofUser(
                DecisionInputMessage.User.builder()
                    .content("string")
                    .type(DecisionInputMessage.User.Type.MESSAGE)
                    .build()
            )

        val roundtrippedDecisionInputMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionInputMessage),
                jacksonTypeRef<DecisionInputMessage>(),
            )

        assertThat(roundtrippedDecisionInputMessage).isEqualTo(decisionInputMessage)
    }

    @Test
    fun ofDeveloper() {
        val developer =
            DecisionInputMessage.Developer.builder()
                .content("string")
                .type(DecisionInputMessage.Developer.Type.MESSAGE)
                .build()

        val decisionInputMessage = DecisionInputMessage.ofDeveloper(developer)

        assertThat(decisionInputMessage.user()).isEmpty
        assertThat(decisionInputMessage.developer()).contains(developer)
        assertThat(decisionInputMessage.system()).isEmpty
        assertThat(decisionInputMessage.assistant()).isEmpty
    }

    @Test
    fun ofDeveloperRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionInputMessage =
            DecisionInputMessage.ofDeveloper(
                DecisionInputMessage.Developer.builder()
                    .content("string")
                    .type(DecisionInputMessage.Developer.Type.MESSAGE)
                    .build()
            )

        val roundtrippedDecisionInputMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionInputMessage),
                jacksonTypeRef<DecisionInputMessage>(),
            )

        assertThat(roundtrippedDecisionInputMessage).isEqualTo(decisionInputMessage)
    }

    @Test
    fun ofSystem() {
        val system =
            DecisionInputMessage.System.builder()
                .content("string")
                .type(DecisionInputMessage.System.Type.MESSAGE)
                .build()

        val decisionInputMessage = DecisionInputMessage.ofSystem(system)

        assertThat(decisionInputMessage.user()).isEmpty
        assertThat(decisionInputMessage.developer()).isEmpty
        assertThat(decisionInputMessage.system()).contains(system)
        assertThat(decisionInputMessage.assistant()).isEmpty
    }

    @Test
    fun ofSystemRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionInputMessage =
            DecisionInputMessage.ofSystem(
                DecisionInputMessage.System.builder()
                    .content("string")
                    .type(DecisionInputMessage.System.Type.MESSAGE)
                    .build()
            )

        val roundtrippedDecisionInputMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionInputMessage),
                jacksonTypeRef<DecisionInputMessage>(),
            )

        assertThat(roundtrippedDecisionInputMessage).isEqualTo(decisionInputMessage)
    }

    @Test
    fun ofAssistant() {
        val assistant =
            DecisionInputMessage.Assistant.builder()
                .content("string")
                .phase(DecisionInputMessage.Assistant.Phase.COMMENTARY)
                .type(DecisionInputMessage.Assistant.Type.MESSAGE)
                .build()

        val decisionInputMessage = DecisionInputMessage.ofAssistant(assistant)

        assertThat(decisionInputMessage.user()).isEmpty
        assertThat(decisionInputMessage.developer()).isEmpty
        assertThat(decisionInputMessage.system()).isEmpty
        assertThat(decisionInputMessage.assistant()).contains(assistant)
    }

    @Test
    fun ofAssistantRoundtrip() {
        val jsonMapper = jsonMapper()
        val decisionInputMessage =
            DecisionInputMessage.ofAssistant(
                DecisionInputMessage.Assistant.builder()
                    .content("string")
                    .phase(DecisionInputMessage.Assistant.Phase.COMMENTARY)
                    .type(DecisionInputMessage.Assistant.Type.MESSAGE)
                    .build()
            )

        val roundtrippedDecisionInputMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionInputMessage),
                jacksonTypeRef<DecisionInputMessage>(),
            )

        assertThat(roundtrippedDecisionInputMessage).isEqualTo(decisionInputMessage)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val decisionInputMessage =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<DecisionInputMessage>())

        val e = assertThrows<OpenAIInvalidDataException> { decisionInputMessage.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
