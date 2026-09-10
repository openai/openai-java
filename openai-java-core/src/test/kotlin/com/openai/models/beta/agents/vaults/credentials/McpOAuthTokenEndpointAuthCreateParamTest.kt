// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults.credentials

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class McpOAuthTokenEndpointAuthCreateParamTest {

    @Test
    fun ofNone() {
        val mcpOAuthTokenEndpointAuthCreateParam = McpOAuthTokenEndpointAuthCreateParam.ofNone()

        assertThat(mcpOAuthTokenEndpointAuthCreateParam.none())
            .contains(JsonValue.from(mapOf("type" to "none")))
        assertThat(mcpOAuthTokenEndpointAuthCreateParam.clientSecretBasic()).isEmpty
        assertThat(mcpOAuthTokenEndpointAuthCreateParam.clientSecretPost()).isEmpty
    }

    @Test
    fun ofNoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val mcpOAuthTokenEndpointAuthCreateParam = McpOAuthTokenEndpointAuthCreateParam.ofNone()

        val roundtrippedMcpOAuthTokenEndpointAuthCreateParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpOAuthTokenEndpointAuthCreateParam),
                jacksonTypeRef<McpOAuthTokenEndpointAuthCreateParam>(),
            )

        assertThat(roundtrippedMcpOAuthTokenEndpointAuthCreateParam)
            .isEqualTo(mcpOAuthTokenEndpointAuthCreateParam)
    }

    @Test
    fun ofClientSecretBasic() {
        val clientSecretBasic =
            McpOAuthTokenEndpointAuthCreateParam.ClientSecretBasic.builder()
                .clientSecret("client_secret")
                .build()

        val mcpOAuthTokenEndpointAuthCreateParam =
            McpOAuthTokenEndpointAuthCreateParam.ofClientSecretBasic(clientSecretBasic)

        assertThat(mcpOAuthTokenEndpointAuthCreateParam.none()).isEmpty
        assertThat(mcpOAuthTokenEndpointAuthCreateParam.clientSecretBasic())
            .contains(clientSecretBasic)
        assertThat(mcpOAuthTokenEndpointAuthCreateParam.clientSecretPost()).isEmpty
    }

    @Test
    fun ofClientSecretBasicRoundtrip() {
        val jsonMapper = jsonMapper()
        val mcpOAuthTokenEndpointAuthCreateParam =
            McpOAuthTokenEndpointAuthCreateParam.ofClientSecretBasic(
                McpOAuthTokenEndpointAuthCreateParam.ClientSecretBasic.builder()
                    .clientSecret("client_secret")
                    .build()
            )

        val roundtrippedMcpOAuthTokenEndpointAuthCreateParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpOAuthTokenEndpointAuthCreateParam),
                jacksonTypeRef<McpOAuthTokenEndpointAuthCreateParam>(),
            )

        assertThat(roundtrippedMcpOAuthTokenEndpointAuthCreateParam)
            .isEqualTo(mcpOAuthTokenEndpointAuthCreateParam)
    }

    @Test
    fun ofClientSecretPost() {
        val clientSecretPost =
            McpOAuthTokenEndpointAuthCreateParam.ClientSecretPost.builder()
                .clientSecret("client_secret")
                .build()

        val mcpOAuthTokenEndpointAuthCreateParam =
            McpOAuthTokenEndpointAuthCreateParam.ofClientSecretPost(clientSecretPost)

        assertThat(mcpOAuthTokenEndpointAuthCreateParam.none()).isEmpty
        assertThat(mcpOAuthTokenEndpointAuthCreateParam.clientSecretBasic()).isEmpty
        assertThat(mcpOAuthTokenEndpointAuthCreateParam.clientSecretPost())
            .contains(clientSecretPost)
    }

    @Test
    fun ofClientSecretPostRoundtrip() {
        val jsonMapper = jsonMapper()
        val mcpOAuthTokenEndpointAuthCreateParam =
            McpOAuthTokenEndpointAuthCreateParam.ofClientSecretPost(
                McpOAuthTokenEndpointAuthCreateParam.ClientSecretPost.builder()
                    .clientSecret("client_secret")
                    .build()
            )

        val roundtrippedMcpOAuthTokenEndpointAuthCreateParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpOAuthTokenEndpointAuthCreateParam),
                jacksonTypeRef<McpOAuthTokenEndpointAuthCreateParam>(),
            )

        assertThat(roundtrippedMcpOAuthTokenEndpointAuthCreateParam)
            .isEqualTo(mcpOAuthTokenEndpointAuthCreateParam)
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
        val mcpOAuthTokenEndpointAuthCreateParam =
            jsonMapper()
                .convertValue(
                    testCase.value,
                    jacksonTypeRef<McpOAuthTokenEndpointAuthCreateParam>(),
                )

        val e =
            assertThrows<OpenAIInvalidDataException> {
                mcpOAuthTokenEndpointAuthCreateParam.validate()
            }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
