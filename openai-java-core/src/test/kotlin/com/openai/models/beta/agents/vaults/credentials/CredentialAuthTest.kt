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

internal class CredentialAuthTest {

    @Test
    fun ofMcpO() {
        val mcpO =
            CredentialAuth.McpOAuth.builder()
                .expiresAt("expires_at")
                .mcpServerUrl("mcp_server_url")
                .refresh(
                    CredentialAuth.McpOAuth.Refresh.builder()
                        .clientId("client_id")
                        .resource("resource")
                        .scope("scope")
                        .tokenEndpoint("token_endpoint")
                        .tokenEndpointAuthNone()
                        .build()
                )
                .build()

        val credentialAuth = CredentialAuth.ofMcpO(mcpO)

        assertThat(credentialAuth.mcpO()).contains(mcpO)
        assertThat(credentialAuth.staticBearer()).isEmpty
    }

    @Test
    fun ofMcpORoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialAuth =
            CredentialAuth.ofMcpO(
                CredentialAuth.McpOAuth.builder()
                    .expiresAt("expires_at")
                    .mcpServerUrl("mcp_server_url")
                    .refresh(
                        CredentialAuth.McpOAuth.Refresh.builder()
                            .clientId("client_id")
                            .resource("resource")
                            .scope("scope")
                            .tokenEndpoint("token_endpoint")
                            .tokenEndpointAuthNone()
                            .build()
                    )
                    .build()
            )

        val roundtrippedCredentialAuth =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialAuth),
                jacksonTypeRef<CredentialAuth>(),
            )

        assertThat(roundtrippedCredentialAuth).isEqualTo(credentialAuth)
    }

    @Test
    fun ofStaticBearer() {
        val staticBearer =
            CredentialAuth.StaticBearer.builder().mcpServerUrl("mcp_server_url").build()

        val credentialAuth = CredentialAuth.ofStaticBearer(staticBearer)

        assertThat(credentialAuth.mcpO()).isEmpty
        assertThat(credentialAuth.staticBearer()).contains(staticBearer)
    }

    @Test
    fun ofStaticBearerRoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialAuth =
            CredentialAuth.ofStaticBearer(
                CredentialAuth.StaticBearer.builder().mcpServerUrl("mcp_server_url").build()
            )

        val roundtrippedCredentialAuth =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialAuth),
                jacksonTypeRef<CredentialAuth>(),
            )

        assertThat(roundtrippedCredentialAuth).isEqualTo(credentialAuth)
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
        val credentialAuth =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<CredentialAuth>())

        val e = assertThrows<OpenAIInvalidDataException> { credentialAuth.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
