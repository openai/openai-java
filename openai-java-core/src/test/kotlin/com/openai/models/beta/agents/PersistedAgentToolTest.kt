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

internal class PersistedAgentToolTest {

    @Test
    fun ofFunction() {
        val function =
            PersistedAgentTool.Function.builder()
                .deferLoading(true)
                .description("description")
                .name("name")
                .parameters(
                    PersistedAgentTool.Function.Parameters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val persistedAgentTool = PersistedAgentTool.ofFunction(function)

        assertThat(persistedAgentTool.function()).contains(function)
        assertThat(persistedAgentTool.toolSearch()).isEmpty
        assertThat(persistedAgentTool.programmaticToolCalling()).isEmpty
        assertThat(persistedAgentTool.mcp()).isEmpty
        assertThat(persistedAgentTool.webSearch()).isEmpty
    }

    @Test
    fun ofFunctionRoundtrip() {
        val jsonMapper = jsonMapper()
        val persistedAgentTool =
            PersistedAgentTool.ofFunction(
                PersistedAgentTool.Function.builder()
                    .deferLoading(true)
                    .description("description")
                    .name("name")
                    .parameters(
                        PersistedAgentTool.Function.Parameters.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )

        val roundtrippedPersistedAgentTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(persistedAgentTool),
                jacksonTypeRef<PersistedAgentTool>(),
            )

        assertThat(roundtrippedPersistedAgentTool).isEqualTo(persistedAgentTool)
    }

    @Test
    fun ofToolSearch() {
        val persistedAgentTool = PersistedAgentTool.ofToolSearch()

        assertThat(persistedAgentTool.function()).isEmpty
        assertThat(persistedAgentTool.toolSearch())
            .contains(JsonValue.from(mapOf("type" to "tool_search")))
        assertThat(persistedAgentTool.programmaticToolCalling()).isEmpty
        assertThat(persistedAgentTool.mcp()).isEmpty
        assertThat(persistedAgentTool.webSearch()).isEmpty
    }

    @Test
    fun ofToolSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val persistedAgentTool = PersistedAgentTool.ofToolSearch()

        val roundtrippedPersistedAgentTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(persistedAgentTool),
                jacksonTypeRef<PersistedAgentTool>(),
            )

        assertThat(roundtrippedPersistedAgentTool).isEqualTo(persistedAgentTool)
    }

    @Test
    fun ofProgrammaticToolCalling() {
        val programmaticToolCalling =
            PersistedAgentTool.ProgrammaticToolCalling.builder().enabled(true).build()

        val persistedAgentTool =
            PersistedAgentTool.ofProgrammaticToolCalling(programmaticToolCalling)

        assertThat(persistedAgentTool.function()).isEmpty
        assertThat(persistedAgentTool.toolSearch()).isEmpty
        assertThat(persistedAgentTool.programmaticToolCalling()).contains(programmaticToolCalling)
        assertThat(persistedAgentTool.mcp()).isEmpty
        assertThat(persistedAgentTool.webSearch()).isEmpty
    }

    @Test
    fun ofProgrammaticToolCallingRoundtrip() {
        val jsonMapper = jsonMapper()
        val persistedAgentTool =
            PersistedAgentTool.ofProgrammaticToolCalling(
                PersistedAgentTool.ProgrammaticToolCalling.builder().enabled(true).build()
            )

        val roundtrippedPersistedAgentTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(persistedAgentTool),
                jacksonTypeRef<PersistedAgentTool>(),
            )

        assertThat(roundtrippedPersistedAgentTool).isEqualTo(persistedAgentTool)
    }

    @Test
    fun ofMcp() {
        val mcp =
            PersistedAgentTool.Mcp.builder()
                .addAllowedTool("string")
                .connectionOrigin(PersistedAgentTool.Mcp.ConnectionOrigin.SERVICE)
                .credentialId("credential_id")
                .requestMetadata(
                    PersistedAgentTool.Mcp.RequestMetadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .required(true)
                .serverLabel("server_label")
                .transport(
                    PersistedMcpTransport.Http.builder()
                        .headers(
                            PersistedMcpTransport.Http.Headers.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .serverUrl("server_url")
                        .build()
                )
                .build()

        val persistedAgentTool = PersistedAgentTool.ofMcp(mcp)

        assertThat(persistedAgentTool.function()).isEmpty
        assertThat(persistedAgentTool.toolSearch()).isEmpty
        assertThat(persistedAgentTool.programmaticToolCalling()).isEmpty
        assertThat(persistedAgentTool.mcp()).contains(mcp)
        assertThat(persistedAgentTool.webSearch()).isEmpty
    }

    @Test
    fun ofMcpRoundtrip() {
        val jsonMapper = jsonMapper()
        val persistedAgentTool =
            PersistedAgentTool.ofMcp(
                PersistedAgentTool.Mcp.builder()
                    .addAllowedTool("string")
                    .connectionOrigin(PersistedAgentTool.Mcp.ConnectionOrigin.SERVICE)
                    .credentialId("credential_id")
                    .requestMetadata(
                        PersistedAgentTool.Mcp.RequestMetadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .required(true)
                    .serverLabel("server_label")
                    .transport(
                        PersistedMcpTransport.Http.builder()
                            .headers(
                                PersistedMcpTransport.Http.Headers.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .serverUrl("server_url")
                            .build()
                    )
                    .build()
            )

        val roundtrippedPersistedAgentTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(persistedAgentTool),
                jacksonTypeRef<PersistedAgentTool>(),
            )

        assertThat(roundtrippedPersistedAgentTool).isEqualTo(persistedAgentTool)
    }

    @Test
    fun ofWebSearch() {
        val webSearch =
            PersistedAgentTool.WebSearch.builder()
                .addAllowedDomain("string")
                .contextSize(PersistedAgentTool.WebSearch.ContextSize.LOW)
                .location(
                    PersistedAgentTool.WebSearch.Location.builder()
                        .city("city")
                        .country("country")
                        .region("region")
                        .timezone("timezone")
                        .build()
                )
                .mode(PersistedAgentTool.WebSearch.Mode.DISABLED)
                .build()

        val persistedAgentTool = PersistedAgentTool.ofWebSearch(webSearch)

        assertThat(persistedAgentTool.function()).isEmpty
        assertThat(persistedAgentTool.toolSearch()).isEmpty
        assertThat(persistedAgentTool.programmaticToolCalling()).isEmpty
        assertThat(persistedAgentTool.mcp()).isEmpty
        assertThat(persistedAgentTool.webSearch()).contains(webSearch)
    }

    @Test
    fun ofWebSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val persistedAgentTool =
            PersistedAgentTool.ofWebSearch(
                PersistedAgentTool.WebSearch.builder()
                    .addAllowedDomain("string")
                    .contextSize(PersistedAgentTool.WebSearch.ContextSize.LOW)
                    .location(
                        PersistedAgentTool.WebSearch.Location.builder()
                            .city("city")
                            .country("country")
                            .region("region")
                            .timezone("timezone")
                            .build()
                    )
                    .mode(PersistedAgentTool.WebSearch.Mode.DISABLED)
                    .build()
            )

        val roundtrippedPersistedAgentTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(persistedAgentTool),
                jacksonTypeRef<PersistedAgentTool>(),
            )

        assertThat(roundtrippedPersistedAgentTool).isEqualTo(persistedAgentTool)
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
        val persistedAgentTool =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<PersistedAgentTool>())

        val e = assertThrows<OpenAIInvalidDataException> { persistedAgentTool.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
