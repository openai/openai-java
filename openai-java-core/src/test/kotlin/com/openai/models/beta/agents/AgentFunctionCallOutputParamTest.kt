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

internal class AgentFunctionCallOutputParamTest {

    @Test
    fun ofString() {
        val string = "string"

        val agentFunctionCallOutputParam = AgentFunctionCallOutputParam.ofString(string)

        assertThat(agentFunctionCallOutputParam.string()).contains(string)
    }

    @Test
    fun ofStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentFunctionCallOutputParam = AgentFunctionCallOutputParam.ofString("string")

        val roundtrippedAgentFunctionCallOutputParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentFunctionCallOutputParam),
                jacksonTypeRef<AgentFunctionCallOutputParam>(),
            )

        assertThat(roundtrippedAgentFunctionCallOutputParam).isEqualTo(agentFunctionCallOutputParam)
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
        val agentFunctionCallOutputParam =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<AgentFunctionCallOutputParam>())

        val e = assertThrows<OpenAIInvalidDataException> { agentFunctionCallOutputParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
