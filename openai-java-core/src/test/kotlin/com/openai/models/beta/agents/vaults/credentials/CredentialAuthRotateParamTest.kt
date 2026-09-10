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

internal class CredentialAuthRotateParamTest {

    @Test
    fun ofMcpOAuth() {
        val mcpOauth =
            CredentialAuthRotateParam.McpOAuth.builder()
                .accessToken("access_token")
                .expiresAt("expires_at")
                .refresh(
                    CredentialAuthRotateParam.McpOAuth.Refresh.builder()
                        .refreshToken("refresh_token")
                        .scope("scope")
                        .tokenEndpointAuth(
                            McpOAuthTokenEndpointAuthRotateParam.ClientSecretBasic.builder()
                                .clientSecret("client_secret")
                                .build()
                        )
                        .build()
                )
                .build()

        val credentialAuthRotateParam = CredentialAuthRotateParam.ofMcpOAuth(mcpOauth)

        assertThat(credentialAuthRotateParam.mcpOauth()).contains(mcpOauth)
        assertThat(credentialAuthRotateParam.staticBearer()).isEmpty
    }

    @Test
    fun ofMcpOAuthRoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialAuthRotateParam =
            CredentialAuthRotateParam.ofMcpOAuth(
                CredentialAuthRotateParam.McpOAuth.builder()
                    .accessToken("access_token")
                    .expiresAt("expires_at")
                    .refresh(
                        CredentialAuthRotateParam.McpOAuth.Refresh.builder()
                            .refreshToken("refresh_token")
                            .scope("scope")
                            .tokenEndpointAuth(
                                McpOAuthTokenEndpointAuthRotateParam.ClientSecretBasic.builder()
                                    .clientSecret("client_secret")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedCredentialAuthRotateParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialAuthRotateParam),
                jacksonTypeRef<CredentialAuthRotateParam>(),
            )

        assertThat(roundtrippedCredentialAuthRotateParam).isEqualTo(credentialAuthRotateParam)
    }

    @Test
    fun ofStaticBearer() {
        val staticBearer = CredentialAuthRotateParam.StaticBearer.builder().token("token").build()

        val credentialAuthRotateParam = CredentialAuthRotateParam.ofStaticBearer(staticBearer)

        assertThat(credentialAuthRotateParam.mcpOauth()).isEmpty
        assertThat(credentialAuthRotateParam.staticBearer()).contains(staticBearer)
    }

    @Test
    fun ofStaticBearerRoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialAuthRotateParam =
            CredentialAuthRotateParam.ofStaticBearer(
                CredentialAuthRotateParam.StaticBearer.builder().token("token").build()
            )

        val roundtrippedCredentialAuthRotateParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialAuthRotateParam),
                jacksonTypeRef<CredentialAuthRotateParam>(),
            )

        assertThat(roundtrippedCredentialAuthRotateParam).isEqualTo(credentialAuthRotateParam)
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
        val credentialAuthRotateParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<CredentialAuthRotateParam>())

        val e = assertThrows<OpenAIInvalidDataException> { credentialAuthRotateParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
