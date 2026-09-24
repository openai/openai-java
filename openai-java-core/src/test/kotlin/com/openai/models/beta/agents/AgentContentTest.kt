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

internal class AgentContentTest {

    @Test
    fun ofOutputText() {
        val outputText = OutputText.builder().text("text").build()

        val agentContent = AgentContent.ofOutputText(outputText)

        assertThat(agentContent.outputText()).contains(outputText)
        assertThat(agentContent.encrypted()).isEmpty
    }

    @Test
    fun ofOutputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentContent = AgentContent.ofOutputText(OutputText.builder().text("text").build())

        val roundtrippedAgentContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentContent),
                jacksonTypeRef<AgentContent>(),
            )

        assertThat(roundtrippedAgentContent).isEqualTo(agentContent)
    }

    @Test
    fun ofEncrypted() {
        val encrypted =
            AgentContent.EncryptedContent.builder().encryptedContent("encrypted_content").build()

        val agentContent = AgentContent.ofEncrypted(encrypted)

        assertThat(agentContent.outputText()).isEmpty
        assertThat(agentContent.encrypted()).contains(encrypted)
    }

    @Test
    fun ofEncryptedRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentContent =
            AgentContent.ofEncrypted(
                AgentContent.EncryptedContent.builder()
                    .encryptedContent("encrypted_content")
                    .build()
            )

        val roundtrippedAgentContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentContent),
                jacksonTypeRef<AgentContent>(),
            )

        assertThat(roundtrippedAgentContent).isEqualTo(agentContent)
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
        val agentContent = jsonMapper().convertValue(testCase.value, jacksonTypeRef<AgentContent>())

        val e = assertThrows<OpenAIInvalidDataException> { agentContent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
