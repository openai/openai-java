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

internal class AgentToolParamTest {

    @Test
    fun ofFunction() {
        val function =
            AgentToolParam.Function.builder()
                .description("description")
                .name("name")
                .parameters(
                    AgentToolParam.Function.Parameters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .deferLoading(true)
                .build()

        val agentToolParam = AgentToolParam.ofFunction(function)

        assertThat(agentToolParam.function()).contains(function)
        assertThat(agentToolParam.toolSearch()).isEmpty
        assertThat(agentToolParam.programmaticToolCalling()).isEmpty
        assertThat(agentToolParam.mcp()).isEmpty
        assertThat(agentToolParam.webSearch()).isEmpty
    }

    @Test
    fun ofFunctionRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentToolParam =
            AgentToolParam.ofFunction(
                AgentToolParam.Function.builder()
                    .description("description")
                    .name("name")
                    .parameters(
                        AgentToolParam.Function.Parameters.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .deferLoading(true)
                    .build()
            )

        val roundtrippedAgentToolParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentToolParam),
                jacksonTypeRef<AgentToolParam>(),
            )

        assertThat(roundtrippedAgentToolParam).isEqualTo(agentToolParam)
    }

    @Test
    fun ofToolSearch() {
        val agentToolParam = AgentToolParam.ofToolSearch()

        assertThat(agentToolParam.function()).isEmpty
        assertThat(agentToolParam.toolSearch())
            .contains(JsonValue.from(mapOf("type" to "tool_search")))
        assertThat(agentToolParam.programmaticToolCalling()).isEmpty
        assertThat(agentToolParam.mcp()).isEmpty
        assertThat(agentToolParam.webSearch()).isEmpty
    }

    @Test
    fun ofToolSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentToolParam = AgentToolParam.ofToolSearch()

        val roundtrippedAgentToolParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentToolParam),
                jacksonTypeRef<AgentToolParam>(),
            )

        assertThat(roundtrippedAgentToolParam).isEqualTo(agentToolParam)
    }

    @Test
    fun ofProgrammaticToolCalling() {
        val programmaticToolCalling =
            AgentToolParam.ProgrammaticToolCalling.builder().enabled(true).build()

        val agentToolParam = AgentToolParam.ofProgrammaticToolCalling(programmaticToolCalling)

        assertThat(agentToolParam.function()).isEmpty
        assertThat(agentToolParam.toolSearch()).isEmpty
        assertThat(agentToolParam.programmaticToolCalling()).contains(programmaticToolCalling)
        assertThat(agentToolParam.mcp()).isEmpty
        assertThat(agentToolParam.webSearch()).isEmpty
    }

    @Test
    fun ofProgrammaticToolCallingRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentToolParam =
            AgentToolParam.ofProgrammaticToolCalling(
                AgentToolParam.ProgrammaticToolCalling.builder().enabled(true).build()
            )

        val roundtrippedAgentToolParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentToolParam),
                jacksonTypeRef<AgentToolParam>(),
            )

        assertThat(roundtrippedAgentToolParam).isEqualTo(agentToolParam)
    }

    @Test
    fun ofMcp() {
        val mcp =
            AgentToolParam.Mcp.builder()
                .serverLabel("server_label")
                .transport(
                    McpTransportParam.Http.builder()
                        .serverUrl("server_url")
                        .authorization("authorization")
                        .headers(
                            McpTransportParam.Http.Headers.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .build()
                )
                .addAllowedTool("string")
                .connectionOrigin(AgentToolParam.Mcp.ConnectionOrigin.SERVICE)
                .credentialId("credential_id")
                .requestMetadata(
                    AgentToolParam.Mcp.RequestMetadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .required(true)
                .build()

        val agentToolParam = AgentToolParam.ofMcp(mcp)

        assertThat(agentToolParam.function()).isEmpty
        assertThat(agentToolParam.toolSearch()).isEmpty
        assertThat(agentToolParam.programmaticToolCalling()).isEmpty
        assertThat(agentToolParam.mcp()).contains(mcp)
        assertThat(agentToolParam.webSearch()).isEmpty
    }

    @Test
    fun ofMcpRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentToolParam =
            AgentToolParam.ofMcp(
                AgentToolParam.Mcp.builder()
                    .serverLabel("server_label")
                    .transport(
                        McpTransportParam.Http.builder()
                            .serverUrl("server_url")
                            .authorization("authorization")
                            .headers(
                                McpTransportParam.Http.Headers.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .build()
                    )
                    .addAllowedTool("string")
                    .connectionOrigin(AgentToolParam.Mcp.ConnectionOrigin.SERVICE)
                    .credentialId("credential_id")
                    .requestMetadata(
                        AgentToolParam.Mcp.RequestMetadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .required(true)
                    .build()
            )

        val roundtrippedAgentToolParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentToolParam),
                jacksonTypeRef<AgentToolParam>(),
            )

        assertThat(roundtrippedAgentToolParam).isEqualTo(agentToolParam)
    }

    @Test
    fun ofWebSearch() {
        val webSearch =
            AgentToolParam.WebSearch.builder()
                .addAllowedDomain("string")
                .contextSize(AgentToolParam.WebSearch.ContextSize.LOW)
                .location(
                    AgentToolParam.WebSearch.Location.builder()
                        .city("city")
                        .country("country")
                        .region("region")
                        .timezone("timezone")
                        .build()
                )
                .mode(AgentToolParam.WebSearch.Mode.DISABLED)
                .build()

        val agentToolParam = AgentToolParam.ofWebSearch(webSearch)

        assertThat(agentToolParam.function()).isEmpty
        assertThat(agentToolParam.toolSearch()).isEmpty
        assertThat(agentToolParam.programmaticToolCalling()).isEmpty
        assertThat(agentToolParam.mcp()).isEmpty
        assertThat(agentToolParam.webSearch()).contains(webSearch)
    }

    @Test
    fun ofWebSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentToolParam =
            AgentToolParam.ofWebSearch(
                AgentToolParam.WebSearch.builder()
                    .addAllowedDomain("string")
                    .contextSize(AgentToolParam.WebSearch.ContextSize.LOW)
                    .location(
                        AgentToolParam.WebSearch.Location.builder()
                            .city("city")
                            .country("country")
                            .region("region")
                            .timezone("timezone")
                            .build()
                    )
                    .mode(AgentToolParam.WebSearch.Mode.DISABLED)
                    .build()
            )

        val roundtrippedAgentToolParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentToolParam),
                jacksonTypeRef<AgentToolParam>(),
            )

        assertThat(roundtrippedAgentToolParam).isEqualTo(agentToolParam)
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
        val agentToolParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AgentToolParam>())

        val e = assertThrows<OpenAIInvalidDataException> { agentToolParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
