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

internal class CredentialAuthCreateParamTest {

    @Test
    fun ofMcpOAuth() {
        val mcpOauth =
            CredentialAuthCreateParam.McpOAuth.builder()
                .accessToken("access_token")
                .mcpServerUrl("mcp_server_url")
                .expiresAt("expires_at")
                .refresh(
                    CredentialAuthCreateParam.McpOAuth.Refresh.builder()
                        .clientId("client_id")
                        .refreshToken("refresh_token")
                        .tokenEndpoint("token_endpoint")
                        .tokenEndpointAuthNone()
                        .resource("resource")
                        .scope("scope")
                        .build()
                )
                .build()

        val credentialAuthCreateParam = CredentialAuthCreateParam.ofMcpOAuth(mcpOauth)

        assertThat(credentialAuthCreateParam.mcpOauth()).contains(mcpOauth)
        assertThat(credentialAuthCreateParam.staticBearer()).isEmpty
    }

    @Test
    fun ofMcpOAuthRoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialAuthCreateParam =
            CredentialAuthCreateParam.ofMcpOAuth(
                CredentialAuthCreateParam.McpOAuth.builder()
                    .accessToken("access_token")
                    .mcpServerUrl("mcp_server_url")
                    .expiresAt("expires_at")
                    .refresh(
                        CredentialAuthCreateParam.McpOAuth.Refresh.builder()
                            .clientId("client_id")
                            .refreshToken("refresh_token")
                            .tokenEndpoint("token_endpoint")
                            .tokenEndpointAuthNone()
                            .resource("resource")
                            .scope("scope")
                            .build()
                    )
                    .build()
            )

        val roundtrippedCredentialAuthCreateParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialAuthCreateParam),
                jacksonTypeRef<CredentialAuthCreateParam>(),
            )

        assertThat(roundtrippedCredentialAuthCreateParam).isEqualTo(credentialAuthCreateParam)
    }

    @Test
    fun ofStaticBearer() {
        val staticBearer =
            CredentialAuthCreateParam.StaticBearer.builder()
                .token("token")
                .mcpServerUrl("mcp_server_url")
                .build()

        val credentialAuthCreateParam = CredentialAuthCreateParam.ofStaticBearer(staticBearer)

        assertThat(credentialAuthCreateParam.mcpOauth()).isEmpty
        assertThat(credentialAuthCreateParam.staticBearer()).contains(staticBearer)
    }

    @Test
    fun ofStaticBearerRoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialAuthCreateParam =
            CredentialAuthCreateParam.ofStaticBearer(
                CredentialAuthCreateParam.StaticBearer.builder()
                    .token("token")
                    .mcpServerUrl("mcp_server_url")
                    .build()
            )

        val roundtrippedCredentialAuthCreateParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialAuthCreateParam),
                jacksonTypeRef<CredentialAuthCreateParam>(),
            )

        assertThat(roundtrippedCredentialAuthCreateParam).isEqualTo(credentialAuthCreateParam)
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
        val credentialAuthCreateParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<CredentialAuthCreateParam>())

        val e = assertThrows<OpenAIInvalidDataException> { credentialAuthCreateParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
