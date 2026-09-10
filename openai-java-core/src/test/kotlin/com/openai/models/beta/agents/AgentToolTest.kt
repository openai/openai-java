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

internal class AgentToolTest {

    @Test
    fun ofFunction() {
        val function =
            AgentTool.Function.builder()
                .deferLoading(true)
                .description("description")
                .name("name")
                .parameters(
                    AgentTool.Function.Parameters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val agentTool = AgentTool.ofFunction(function)

        assertThat(agentTool.function()).contains(function)
        assertThat(agentTool.programmaticToolCalling()).isEmpty
        assertThat(agentTool.mcp()).isEmpty
        assertThat(agentTool.webSearch()).isEmpty
    }

    @Test
    fun ofFunctionRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentTool =
            AgentTool.ofFunction(
                AgentTool.Function.builder()
                    .deferLoading(true)
                    .description("description")
                    .name("name")
                    .parameters(
                        AgentTool.Function.Parameters.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )

        val roundtrippedAgentTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentTool),
                jacksonTypeRef<AgentTool>(),
            )

        assertThat(roundtrippedAgentTool).isEqualTo(agentTool)
    }

    @Test
    fun ofProgrammaticToolCalling() {
        val programmaticToolCalling =
            AgentTool.ProgrammaticToolCalling.builder().enabled(true).build()

        val agentTool = AgentTool.ofProgrammaticToolCalling(programmaticToolCalling)

        assertThat(agentTool.function()).isEmpty
        assertThat(agentTool.programmaticToolCalling()).contains(programmaticToolCalling)
        assertThat(agentTool.mcp()).isEmpty
        assertThat(agentTool.webSearch()).isEmpty
    }

    @Test
    fun ofProgrammaticToolCallingRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentTool =
            AgentTool.ofProgrammaticToolCalling(
                AgentTool.ProgrammaticToolCalling.builder().enabled(true).build()
            )

        val roundtrippedAgentTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentTool),
                jacksonTypeRef<AgentTool>(),
            )

        assertThat(roundtrippedAgentTool).isEqualTo(agentTool)
    }

    @Test
    fun ofMcp() {
        val mcp =
            AgentTool.Mcp.builder()
                .addAllowedTool("string")
                .connectionOrigin(AgentTool.Mcp.ConnectionOrigin.SERVICE)
                .credentialId("credential_id")
                .requestMetadata(
                    AgentTool.Mcp.RequestMetadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .required(true)
                .serverLabel("server_label")
                .httpTransport("server_url")
                .build()

        val agentTool = AgentTool.ofMcp(mcp)

        assertThat(agentTool.function()).isEmpty
        assertThat(agentTool.programmaticToolCalling()).isEmpty
        assertThat(agentTool.mcp()).contains(mcp)
        assertThat(agentTool.webSearch()).isEmpty
    }

    @Test
    fun ofMcpRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentTool =
            AgentTool.ofMcp(
                AgentTool.Mcp.builder()
                    .addAllowedTool("string")
                    .connectionOrigin(AgentTool.Mcp.ConnectionOrigin.SERVICE)
                    .credentialId("credential_id")
                    .requestMetadata(
                        AgentTool.Mcp.RequestMetadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .required(true)
                    .serverLabel("server_label")
                    .httpTransport("server_url")
                    .build()
            )

        val roundtrippedAgentTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentTool),
                jacksonTypeRef<AgentTool>(),
            )

        assertThat(roundtrippedAgentTool).isEqualTo(agentTool)
    }

    @Test
    fun ofWebSearch() {
        val webSearch =
            AgentTool.WebSearch.builder()
                .addAllowedDomain("string")
                .contextSize(AgentTool.WebSearch.ContextSize.LOW)
                .location(
                    AgentTool.WebSearch.Location.builder()
                        .city("city")
                        .country("country")
                        .region("region")
                        .timezone("timezone")
                        .build()
                )
                .mode(AgentTool.WebSearch.Mode.DISABLED)
                .build()

        val agentTool = AgentTool.ofWebSearch(webSearch)

        assertThat(agentTool.function()).isEmpty
        assertThat(agentTool.programmaticToolCalling()).isEmpty
        assertThat(agentTool.mcp()).isEmpty
        assertThat(agentTool.webSearch()).contains(webSearch)
    }

    @Test
    fun ofWebSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentTool =
            AgentTool.ofWebSearch(
                AgentTool.WebSearch.builder()
                    .addAllowedDomain("string")
                    .contextSize(AgentTool.WebSearch.ContextSize.LOW)
                    .location(
                        AgentTool.WebSearch.Location.builder()
                            .city("city")
                            .country("country")
                            .region("region")
                            .timezone("timezone")
                            .build()
                    )
                    .mode(AgentTool.WebSearch.Mode.DISABLED)
                    .build()
            )

        val roundtrippedAgentTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentTool),
                jacksonTypeRef<AgentTool>(),
            )

        assertThat(roundtrippedAgentTool).isEqualTo(agentTool)
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
        val agentTool = jsonMapper().convertValue(testCase.value, jacksonTypeRef<AgentTool>())

        val e = assertThrows<OpenAIInvalidDataException> { agentTool.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
