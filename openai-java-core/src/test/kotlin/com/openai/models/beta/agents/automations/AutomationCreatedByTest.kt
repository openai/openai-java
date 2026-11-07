// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AutomationCreatedByTest {

    @Test
    fun ofDeveloper() {
        val automationCreatedBy = AutomationCreatedBy.ofDeveloper()

        assertThat(automationCreatedBy.developer())
            .contains(JsonValue.from(mapOf("type" to "developer")))
        assertThat(automationCreatedBy.agent()).isEmpty
    }

    @Test
    fun ofDeveloperRoundtrip() {
        val jsonMapper = jsonMapper()
        val automationCreatedBy = AutomationCreatedBy.ofDeveloper()

        val roundtrippedAutomationCreatedBy =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationCreatedBy),
                jacksonTypeRef<AutomationCreatedBy>(),
            )

        assertThat(roundtrippedAutomationCreatedBy).isEqualTo(automationCreatedBy)
    }

    @Test
    fun ofAgent() {
        val agent =
            AutomationCreatedBy.Agent.builder()
                .sessionId("session_id")
                .toolCallId("tool_call_id")
                .build()

        val automationCreatedBy = AutomationCreatedBy.ofAgent(agent)

        assertThat(automationCreatedBy.developer()).isEmpty
        assertThat(automationCreatedBy.agent()).contains(agent)
    }

    @Test
    fun ofAgentRoundtrip() {
        val jsonMapper = jsonMapper()
        val automationCreatedBy =
            AutomationCreatedBy.ofAgent(
                AutomationCreatedBy.Agent.builder()
                    .sessionId("session_id")
                    .toolCallId("tool_call_id")
                    .build()
            )

        val roundtrippedAutomationCreatedBy =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationCreatedBy),
                jacksonTypeRef<AutomationCreatedBy>(),
            )

        assertThat(roundtrippedAutomationCreatedBy).isEqualTo(automationCreatedBy)
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
        val automationCreatedBy =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AutomationCreatedBy>())

        val e = assertThrows<OpenAIInvalidDataException> { automationCreatedBy.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
