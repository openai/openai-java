// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults.credentials

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CredentialListPageResponseTest {

    @Test
    fun create() {
        val credentialListPageResponse =
            CredentialListPageResponse.builder()
                .addData(
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(credentialListPageResponse.data())
            .containsExactly(
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
            )
        assertThat(credentialListPageResponse.firstId()).contains("first_id")
        assertThat(credentialListPageResponse.hasMore()).isEqualTo(true)
        assertThat(credentialListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val credentialListPageResponse =
            CredentialListPageResponse.builder()
                .addData(
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedCredentialListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialListPageResponse),
                jacksonTypeRef<CredentialListPageResponse>(),
            )

        assertThat(roundtrippedCredentialListPageResponse).isEqualTo(credentialListPageResponse)
    }
}
