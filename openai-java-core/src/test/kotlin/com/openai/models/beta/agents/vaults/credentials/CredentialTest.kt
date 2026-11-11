// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults.credentials

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CredentialTest {

    @Test
    fun createAndRoundtrip() {
        val credential =
            Credential.builder()
                .id("id")
                .auth(
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
                .createdAt(0L)
                .metadata(
                    Credential.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .name("name")
                .updatedAt(0L)
                .vaultId("vault_id")
                .build()

        assertThat(credential.id()).contains("id")
        assertThat(credential.auth())
            .contains(
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
            )
        assertThat(credential.createdAt()).contains(0L)
        assertThat(credential.metadata())
            .contains(
                Credential.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(credential.name()).contains("name")
        assertThat(credential.updatedAt()).contains(0L)
        assertThat(credential.vaultId()).contains("vault_id")

        val jsonMapper = jsonMapper()

        val roundtrippedCredential =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credential),
                jacksonTypeRef<Credential>(),
            )

        assertThat(roundtrippedCredential).isEqualTo(credential)
    }
}
