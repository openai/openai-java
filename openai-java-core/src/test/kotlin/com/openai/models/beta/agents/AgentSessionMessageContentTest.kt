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

internal class AgentSessionMessageContentTest {

    @Test
    fun ofInputText() {
        val inputText = AgentSessionMessageContent.InputText.builder().text("text").build()

        val agentSessionMessageContent = AgentSessionMessageContent.ofInputText(inputText)

        assertThat(agentSessionMessageContent.inputText()).contains(inputText)
        assertThat(agentSessionMessageContent.inputImage()).isEmpty
        assertThat(agentSessionMessageContent.outputText()).isEmpty
    }

    @Test
    fun ofInputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionMessageContent =
            AgentSessionMessageContent.ofInputText(
                AgentSessionMessageContent.InputText.builder().text("text").build()
            )

        val roundtrippedAgentSessionMessageContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionMessageContent),
                jacksonTypeRef<AgentSessionMessageContent>(),
            )

        assertThat(roundtrippedAgentSessionMessageContent).isEqualTo(agentSessionMessageContent)
    }

    @Test
    fun ofInputImage() {
        val inputImage =
            AgentSessionMessageContent.InputImage.builder().imageUrl("image_url").build()

        val agentSessionMessageContent = AgentSessionMessageContent.ofInputImage(inputImage)

        assertThat(agentSessionMessageContent.inputText()).isEmpty
        assertThat(agentSessionMessageContent.inputImage()).contains(inputImage)
        assertThat(agentSessionMessageContent.outputText()).isEmpty
    }

    @Test
    fun ofInputImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionMessageContent =
            AgentSessionMessageContent.ofInputImage(
                AgentSessionMessageContent.InputImage.builder().imageUrl("image_url").build()
            )

        val roundtrippedAgentSessionMessageContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionMessageContent),
                jacksonTypeRef<AgentSessionMessageContent>(),
            )

        assertThat(roundtrippedAgentSessionMessageContent).isEqualTo(agentSessionMessageContent)
    }

    @Test
    fun ofOutputText() {
        val outputText = AgentSessionMessageContent.OutputText.builder().text("text").build()

        val agentSessionMessageContent = AgentSessionMessageContent.ofOutputText(outputText)

        assertThat(agentSessionMessageContent.inputText()).isEmpty
        assertThat(agentSessionMessageContent.inputImage()).isEmpty
        assertThat(agentSessionMessageContent.outputText()).contains(outputText)
    }

    @Test
    fun ofOutputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionMessageContent =
            AgentSessionMessageContent.ofOutputText(
                AgentSessionMessageContent.OutputText.builder().text("text").build()
            )

        val roundtrippedAgentSessionMessageContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionMessageContent),
                jacksonTypeRef<AgentSessionMessageContent>(),
            )

        assertThat(roundtrippedAgentSessionMessageContent).isEqualTo(agentSessionMessageContent)
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
        val agentSessionMessageContent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AgentSessionMessageContent>())

        val e = assertThrows<OpenAIInvalidDataException> { agentSessionMessageContent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
