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

internal class PersistedMcpTransportParamTest {

    @Test
    fun ofHttp() {
        val http =
            PersistedMcpTransportParam.Http.builder()
                .serverUrl("server_url")
                .headers(
                    PersistedMcpTransportParam.Http.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val persistedMcpTransportParam = PersistedMcpTransportParam.ofHttp(http)

        assertThat(persistedMcpTransportParam.http()).contains(http)
        assertThat(persistedMcpTransportParam.stdio()).isEmpty
    }

    @Test
    fun ofHttpRoundtrip() {
        val jsonMapper = jsonMapper()
        val persistedMcpTransportParam =
            PersistedMcpTransportParam.ofHttp(
                PersistedMcpTransportParam.Http.builder()
                    .serverUrl("server_url")
                    .headers(
                        PersistedMcpTransportParam.Http.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        val roundtrippedPersistedMcpTransportParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(persistedMcpTransportParam),
                jacksonTypeRef<PersistedMcpTransportParam>(),
            )

        assertThat(roundtrippedPersistedMcpTransportParam).isEqualTo(persistedMcpTransportParam)
    }

    @Test
    fun ofStdio() {
        val stdio =
            PersistedMcpTransportParam.Stdio.builder()
                .command("command")
                .cwd("cwd")
                .addArg("string")
                .addEnvVar("string")
                .build()

        val persistedMcpTransportParam = PersistedMcpTransportParam.ofStdio(stdio)

        assertThat(persistedMcpTransportParam.http()).isEmpty
        assertThat(persistedMcpTransportParam.stdio()).contains(stdio)
    }

    @Test
    fun ofStdioRoundtrip() {
        val jsonMapper = jsonMapper()
        val persistedMcpTransportParam =
            PersistedMcpTransportParam.ofStdio(
                PersistedMcpTransportParam.Stdio.builder()
                    .command("command")
                    .cwd("cwd")
                    .addArg("string")
                    .addEnvVar("string")
                    .build()
            )

        val roundtrippedPersistedMcpTransportParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(persistedMcpTransportParam),
                jacksonTypeRef<PersistedMcpTransportParam>(),
            )

        assertThat(roundtrippedPersistedMcpTransportParam).isEqualTo(persistedMcpTransportParam)
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
        val persistedMcpTransportParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<PersistedMcpTransportParam>())

        val e = assertThrows<OpenAIInvalidDataException> { persistedMcpTransportParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
