// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults.credentials

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CredentialTest {

    @Test
    fun create() {
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
                .name("name")
                .updatedAt(0L)
                .vaultId("vault_id")
                .build()

        assertThat(credential.id()).isEqualTo("id")
        assertThat(credential.auth())
            .isEqualTo(
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
        assertThat(credential.createdAt()).isEqualTo(0L)
        assertThat(credential.name()).isEqualTo("name")
        assertThat(credential.updatedAt()).isEqualTo(0L)
        assertThat(credential.vaultId()).isEqualTo("vault_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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
                .name("name")
                .updatedAt(0L)
                .vaultId("vault_id")
                .build()

        val roundtrippedCredential =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credential),
                jacksonTypeRef<Credential>(),
            )

        assertThat(roundtrippedCredential).isEqualTo(credential)
    }
}
