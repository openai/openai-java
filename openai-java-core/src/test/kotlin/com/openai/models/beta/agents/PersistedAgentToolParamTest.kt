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

internal class PersistedAgentToolParamTest {

    @Test
    fun ofFunction() {
        val function =
            PersistedAgentToolParam.Function.builder()
                .description("description")
                .name("name")
                .parameters(
                    PersistedAgentToolParam.Function.Parameters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .deferLoading(true)
                .build()

        val persistedAgentToolParam = PersistedAgentToolParam.ofFunction(function)

        assertThat(persistedAgentToolParam.function()).contains(function)
        assertThat(persistedAgentToolParam.toolSearch()).isEmpty
        assertThat(persistedAgentToolParam.programmaticToolCalling()).isEmpty
        assertThat(persistedAgentToolParam.mcp()).isEmpty
        assertThat(persistedAgentToolParam.webSearch()).isEmpty
    }

    @Test
    fun ofFunctionRoundtrip() {
        val jsonMapper = jsonMapper()
        val persistedAgentToolParam =
            PersistedAgentToolParam.ofFunction(
                PersistedAgentToolParam.Function.builder()
                    .description("description")
                    .name("name")
                    .parameters(
                        PersistedAgentToolParam.Function.Parameters.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .deferLoading(true)
                    .build()
            )

        val roundtrippedPersistedAgentToolParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(persistedAgentToolParam),
                jacksonTypeRef<PersistedAgentToolParam>(),
            )

        assertThat(roundtrippedPersistedAgentToolParam).isEqualTo(persistedAgentToolParam)
    }

    @Test
    fun ofToolSearch() {
        val persistedAgentToolParam = PersistedAgentToolParam.ofToolSearch()

        assertThat(persistedAgentToolParam.function()).isEmpty
        assertThat(persistedAgentToolParam.toolSearch())
            .contains(JsonValue.from(mapOf("type" to "tool_search")))
        assertThat(persistedAgentToolParam.programmaticToolCalling()).isEmpty
        assertThat(persistedAgentToolParam.mcp()).isEmpty
        assertThat(persistedAgentToolParam.webSearch()).isEmpty
    }

    @Test
    fun ofToolSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val persistedAgentToolParam = PersistedAgentToolParam.ofToolSearch()

        val roundtrippedPersistedAgentToolParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(persistedAgentToolParam),
                jacksonTypeRef<PersistedAgentToolParam>(),
            )

        assertThat(roundtrippedPersistedAgentToolParam).isEqualTo(persistedAgentToolParam)
    }

    @Test
    fun ofProgrammaticToolCalling() {
        val programmaticToolCalling =
            PersistedAgentToolParam.ProgrammaticToolCalling.builder().enabled(true).build()

        val persistedAgentToolParam =
            PersistedAgentToolParam.ofProgrammaticToolCalling(programmaticToolCalling)

        assertThat(persistedAgentToolParam.function()).isEmpty
        assertThat(persistedAgentToolParam.toolSearch()).isEmpty
        assertThat(persistedAgentToolParam.programmaticToolCalling())
            .contains(programmaticToolCalling)
        assertThat(persistedAgentToolParam.mcp()).isEmpty
        assertThat(persistedAgentToolParam.webSearch()).isEmpty
    }

    @Test
    fun ofProgrammaticToolCallingRoundtrip() {
        val jsonMapper = jsonMapper()
        val persistedAgentToolParam =
            PersistedAgentToolParam.ofProgrammaticToolCalling(
                PersistedAgentToolParam.ProgrammaticToolCalling.builder().enabled(true).build()
            )

        val roundtrippedPersistedAgentToolParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(persistedAgentToolParam),
                jacksonTypeRef<PersistedAgentToolParam>(),
            )

        assertThat(roundtrippedPersistedAgentToolParam).isEqualTo(persistedAgentToolParam)
    }

    @Test
    fun ofMcp() {
        val mcp =
            PersistedAgentToolParam.Mcp.builder()
                .serverLabel("server_label")
                .transport(
                    PersistedMcpTransportParam.Http.builder()
                        .serverUrl("server_url")
                        .headers(
                            PersistedMcpTransportParam.Http.Headers.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .build()
                )
                .addAllowedTool("string")
                .connectionOrigin(PersistedAgentToolParam.Mcp.ConnectionOrigin.SERVICE)
                .credentialId("credential_id")
                .requestMetadata(
                    PersistedAgentToolParam.Mcp.RequestMetadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .required(true)
                .build()

        val persistedAgentToolParam = PersistedAgentToolParam.ofMcp(mcp)

        assertThat(persistedAgentToolParam.function()).isEmpty
        assertThat(persistedAgentToolParam.toolSearch()).isEmpty
        assertThat(persistedAgentToolParam.programmaticToolCalling()).isEmpty
        assertThat(persistedAgentToolParam.mcp()).contains(mcp)
        assertThat(persistedAgentToolParam.webSearch()).isEmpty
    }

    @Test
    fun ofMcpRoundtrip() {
        val jsonMapper = jsonMapper()
        val persistedAgentToolParam =
            PersistedAgentToolParam.ofMcp(
                PersistedAgentToolParam.Mcp.builder()
                    .serverLabel("server_label")
                    .transport(
                        PersistedMcpTransportParam.Http.builder()
                            .serverUrl("server_url")
                            .headers(
                                PersistedMcpTransportParam.Http.Headers.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .build()
                    )
                    .addAllowedTool("string")
                    .connectionOrigin(PersistedAgentToolParam.Mcp.ConnectionOrigin.SERVICE)
                    .credentialId("credential_id")
                    .requestMetadata(
                        PersistedAgentToolParam.Mcp.RequestMetadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .required(true)
                    .build()
            )

        val roundtrippedPersistedAgentToolParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(persistedAgentToolParam),
                jacksonTypeRef<PersistedAgentToolParam>(),
            )

        assertThat(roundtrippedPersistedAgentToolParam).isEqualTo(persistedAgentToolParam)
    }

    @Test
    fun ofWebSearch() {
        val webSearch =
            PersistedAgentToolParam.WebSearch.builder()
                .addAllowedDomain("string")
                .contextSize(PersistedAgentToolParam.WebSearch.ContextSize.LOW)
                .location(
                    PersistedAgentToolParam.WebSearch.Location.builder()
                        .city("city")
                        .country("country")
                        .region("region")
                        .timezone("timezone")
                        .build()
                )
                .mode(PersistedAgentToolParam.WebSearch.Mode.DISABLED)
                .build()

        val persistedAgentToolParam = PersistedAgentToolParam.ofWebSearch(webSearch)

        assertThat(persistedAgentToolParam.function()).isEmpty
        assertThat(persistedAgentToolParam.toolSearch()).isEmpty
        assertThat(persistedAgentToolParam.programmaticToolCalling()).isEmpty
        assertThat(persistedAgentToolParam.mcp()).isEmpty
        assertThat(persistedAgentToolParam.webSearch()).contains(webSearch)
    }

    @Test
    fun ofWebSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val persistedAgentToolParam =
            PersistedAgentToolParam.ofWebSearch(
                PersistedAgentToolParam.WebSearch.builder()
                    .addAllowedDomain("string")
                    .contextSize(PersistedAgentToolParam.WebSearch.ContextSize.LOW)
                    .location(
                        PersistedAgentToolParam.WebSearch.Location.builder()
                            .city("city")
                            .country("country")
                            .region("region")
                            .timezone("timezone")
                            .build()
                    )
                    .mode(PersistedAgentToolParam.WebSearch.Mode.DISABLED)
                    .build()
            )

        val roundtrippedPersistedAgentToolParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(persistedAgentToolParam),
                jacksonTypeRef<PersistedAgentToolParam>(),
            )

        assertThat(roundtrippedPersistedAgentToolParam).isEqualTo(persistedAgentToolParam)
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
        val persistedAgentToolParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<PersistedAgentToolParam>())

        val e = assertThrows<OpenAIInvalidDataException> { persistedAgentToolParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
