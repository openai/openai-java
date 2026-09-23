// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults.credentials

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CredentialCreateParamsTest {

    @Test
    fun create() {
        CredentialCreateParams.builder()
            .vaultId("vault_id")
            .auth(
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
            .name("x")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            CredentialCreateParams.builder()
                .vaultId("vault_id")
                .auth(
                    CredentialAuthCreateParam.McpOAuth.builder()
                        .accessToken("access_token")
                        .mcpServerUrl("mcp_server_url")
                        .build()
                )
                .name("x")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("vault_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            CredentialCreateParams.builder()
                .vaultId("vault_id")
                .auth(
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
                .name("x")
                .build()

        val body = params._body()

        assertThat(body.auth())
            .isEqualTo(
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
            )
        assertThat(body.name()).isEqualTo("x")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            CredentialCreateParams.builder()
                .vaultId("vault_id")
                .auth(
                    CredentialAuthCreateParam.McpOAuth.builder()
                        .accessToken("access_token")
                        .mcpServerUrl("mcp_server_url")
                        .build()
                )
                .name("x")
                .build()

        val body = params._body()

        assertThat(body.auth())
            .isEqualTo(
                CredentialAuthCreateParam.ofMcpOAuth(
                    CredentialAuthCreateParam.McpOAuth.builder()
                        .accessToken("access_token")
                        .mcpServerUrl("mcp_server_url")
                        .build()
                )
            )
        assertThat(body.name()).isEqualTo("x")
    }
}
