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

internal class AgentSessionInputParamTest {

    @Test
    fun ofAgentSessionInputMessage() {
        val agentSessionInputMessage =
            AgentSessionInputParam.AgentSessionInputMessage.builder()
                .addInput(
                    AgentSessionInputMessageParam.builder()
                        .addInputTextContent("text")
                        .type(AgentSessionInputMessageParam.Type.MESSAGE)
                        .build()
                )
                .build()

        val agentSessionInputParam =
            AgentSessionInputParam.ofAgentSessionInputMessage(agentSessionInputMessage)

        assertThat(agentSessionInputParam.agentSessionInputMessage())
            .contains(agentSessionInputMessage)
        assertThat(agentSessionInputParam.agentSessionInputCancel()).isEmpty
        assertThat(agentSessionInputParam.agentSessionInputToolResult()).isEmpty
    }

    @Test
    fun ofAgentSessionInputMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionInputParam =
            AgentSessionInputParam.ofAgentSessionInputMessage(
                AgentSessionInputParam.AgentSessionInputMessage.builder()
                    .addInput(
                        AgentSessionInputMessageParam.builder()
                            .addInputTextContent("text")
                            .type(AgentSessionInputMessageParam.Type.MESSAGE)
                            .build()
                    )
                    .build()
            )

        val roundtrippedAgentSessionInputParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionInputParam),
                jacksonTypeRef<AgentSessionInputParam>(),
            )

        assertThat(roundtrippedAgentSessionInputParam).isEqualTo(agentSessionInputParam)
    }

    @Test
    fun ofAgentSessionInputCancel() {
        val agentSessionInputParam = AgentSessionInputParam.ofAgentSessionInputCancel()

        assertThat(agentSessionInputParam.agentSessionInputMessage()).isEmpty
        assertThat(agentSessionInputParam.agentSessionInputCancel())
            .contains(JsonValue.from(mapOf("type" to "agent.session.input.cancel")))
        assertThat(agentSessionInputParam.agentSessionInputToolResult()).isEmpty
    }

    @Test
    fun ofAgentSessionInputCancelRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionInputParam = AgentSessionInputParam.ofAgentSessionInputCancel()

        val roundtrippedAgentSessionInputParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionInputParam),
                jacksonTypeRef<AgentSessionInputParam>(),
            )

        assertThat(roundtrippedAgentSessionInputParam).isEqualTo(agentSessionInputParam)
    }

    @Test
    fun ofAgentSessionInputToolResult() {
        val agentSessionInputToolResult =
            AgentSessionInputParam.AgentSessionInputToolResult.builder()
                .callId("call_id")
                .success(true)
                .turnId("turn_id")
                .error("error")
                .output("string")
                .build()

        val agentSessionInputParam =
            AgentSessionInputParam.ofAgentSessionInputToolResult(agentSessionInputToolResult)

        assertThat(agentSessionInputParam.agentSessionInputMessage()).isEmpty
        assertThat(agentSessionInputParam.agentSessionInputCancel()).isEmpty
        assertThat(agentSessionInputParam.agentSessionInputToolResult())
            .contains(agentSessionInputToolResult)
    }

    @Test
    fun ofAgentSessionInputToolResultRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionInputParam =
            AgentSessionInputParam.ofAgentSessionInputToolResult(
                AgentSessionInputParam.AgentSessionInputToolResult.builder()
                    .callId("call_id")
                    .success(true)
                    .turnId("turn_id")
                    .error("error")
                    .output("string")
                    .build()
            )

        val roundtrippedAgentSessionInputParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionInputParam),
                jacksonTypeRef<AgentSessionInputParam>(),
            )

        assertThat(roundtrippedAgentSessionInputParam).isEqualTo(agentSessionInputParam)
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
        val agentSessionInputParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AgentSessionInputParam>())

        val e = assertThrows<OpenAIInvalidDataException> { agentSessionInputParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
