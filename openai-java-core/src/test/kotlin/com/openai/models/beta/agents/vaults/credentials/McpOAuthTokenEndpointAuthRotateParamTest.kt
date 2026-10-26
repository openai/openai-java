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

internal class McpOAuthTokenEndpointAuthRotateParamTest {

    @Test
    fun ofClientSecretBasic() {
        val clientSecretBasic =
            McpOAuthTokenEndpointAuthRotateParam.ClientSecretBasic.builder()
                .clientSecret("client_secret")
                .build()

        val mcpOAuthTokenEndpointAuthRotateParam =
            McpOAuthTokenEndpointAuthRotateParam.ofClientSecretBasic(clientSecretBasic)

        assertThat(mcpOAuthTokenEndpointAuthRotateParam.clientSecretBasic())
            .contains(clientSecretBasic)
        assertThat(mcpOAuthTokenEndpointAuthRotateParam.clientSecretPost()).isEmpty
    }

    @Test
    fun ofClientSecretBasicRoundtrip() {
        val jsonMapper = jsonMapper()
        val mcpOAuthTokenEndpointAuthRotateParam =
            McpOAuthTokenEndpointAuthRotateParam.ofClientSecretBasic(
                McpOAuthTokenEndpointAuthRotateParam.ClientSecretBasic.builder()
                    .clientSecret("client_secret")
                    .build()
            )

        val roundtrippedMcpOAuthTokenEndpointAuthRotateParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpOAuthTokenEndpointAuthRotateParam),
                jacksonTypeRef<McpOAuthTokenEndpointAuthRotateParam>(),
            )

        assertThat(roundtrippedMcpOAuthTokenEndpointAuthRotateParam)
            .isEqualTo(mcpOAuthTokenEndpointAuthRotateParam)
    }

    @Test
    fun ofClientSecretPost() {
        val clientSecretPost =
            McpOAuthTokenEndpointAuthRotateParam.ClientSecretPost.builder()
                .clientSecret("client_secret")
                .build()

        val mcpOAuthTokenEndpointAuthRotateParam =
            McpOAuthTokenEndpointAuthRotateParam.ofClientSecretPost(clientSecretPost)

        assertThat(mcpOAuthTokenEndpointAuthRotateParam.clientSecretBasic()).isEmpty
        assertThat(mcpOAuthTokenEndpointAuthRotateParam.clientSecretPost())
            .contains(clientSecretPost)
    }

    @Test
    fun ofClientSecretPostRoundtrip() {
        val jsonMapper = jsonMapper()
        val mcpOAuthTokenEndpointAuthRotateParam =
            McpOAuthTokenEndpointAuthRotateParam.ofClientSecretPost(
                McpOAuthTokenEndpointAuthRotateParam.ClientSecretPost.builder()
                    .clientSecret("client_secret")
                    .build()
            )

        val roundtrippedMcpOAuthTokenEndpointAuthRotateParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpOAuthTokenEndpointAuthRotateParam),
                jacksonTypeRef<McpOAuthTokenEndpointAuthRotateParam>(),
            )

        assertThat(roundtrippedMcpOAuthTokenEndpointAuthRotateParam)
            .isEqualTo(mcpOAuthTokenEndpointAuthRotateParam)
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
        val mcpOAuthTokenEndpointAuthRotateParam =
            jsonMapper()
                .convertValue(
                    testCase.value,
                    jacksonTypeRef<McpOAuthTokenEndpointAuthRotateParam>(),
                )

        val e =
            assertThrows<OpenAIInvalidDataException> {
                mcpOAuthTokenEndpointAuthRotateParam.validate()
            }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
