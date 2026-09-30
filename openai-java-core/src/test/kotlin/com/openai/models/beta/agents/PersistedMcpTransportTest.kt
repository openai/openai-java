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

internal class PersistedMcpTransportTest {

    @Test
    fun ofHttp() {
        val http =
            PersistedMcpTransport.Http.builder()
                .headers(
                    PersistedMcpTransport.Http.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .serverUrl("server_url")
                .build()

        val persistedMcpTransport = PersistedMcpTransport.ofHttp(http)

        assertThat(persistedMcpTransport.http()).contains(http)
        assertThat(persistedMcpTransport.stdio()).isEmpty
    }

    @Test
    fun ofHttpRoundtrip() {
        val jsonMapper = jsonMapper()
        val persistedMcpTransport =
            PersistedMcpTransport.ofHttp(
                PersistedMcpTransport.Http.builder()
                    .headers(
                        PersistedMcpTransport.Http.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .serverUrl("server_url")
                    .build()
            )

        val roundtrippedPersistedMcpTransport =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(persistedMcpTransport),
                jacksonTypeRef<PersistedMcpTransport>(),
            )

        assertThat(roundtrippedPersistedMcpTransport).isEqualTo(persistedMcpTransport)
    }

    @Test
    fun ofStdio() {
        val stdio =
            PersistedMcpTransport.Stdio.builder()
                .addArg("string")
                .command("command")
                .cwd("cwd")
                .addEnvVar("string")
                .build()

        val persistedMcpTransport = PersistedMcpTransport.ofStdio(stdio)

        assertThat(persistedMcpTransport.http()).isEmpty
        assertThat(persistedMcpTransport.stdio()).contains(stdio)
    }

    @Test
    fun ofStdioRoundtrip() {
        val jsonMapper = jsonMapper()
        val persistedMcpTransport =
            PersistedMcpTransport.ofStdio(
                PersistedMcpTransport.Stdio.builder()
                    .addArg("string")
                    .command("command")
                    .cwd("cwd")
                    .addEnvVar("string")
                    .build()
            )

        val roundtrippedPersistedMcpTransport =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(persistedMcpTransport),
                jacksonTypeRef<PersistedMcpTransport>(),
            )

        assertThat(roundtrippedPersistedMcpTransport).isEqualTo(persistedMcpTransport)
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
        val persistedMcpTransport =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<PersistedMcpTransport>())

        val e = assertThrows<OpenAIInvalidDataException> { persistedMcpTransport.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
