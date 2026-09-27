// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AgentFunctionCallOutputTest {

    @Test
    fun ofString() {
        val string = "string"

        val agentFunctionCallOutput = AgentFunctionCallOutput.ofString(string)

        assertThat(agentFunctionCallOutput.string()).contains(string)
    }

    @Test
    fun ofStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentFunctionCallOutput = AgentFunctionCallOutput.ofString("string")

        val roundtrippedAgentFunctionCallOutput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentFunctionCallOutput),
                jacksonTypeRef<AgentFunctionCallOutput>(),
            )

        assertThat(roundtrippedAgentFunctionCallOutput).isEqualTo(agentFunctionCallOutput)
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
        val agentFunctionCallOutput =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AgentFunctionCallOutput>())

        val e = assertThrows<OpenAIInvalidDataException> { agentFunctionCallOutput.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
