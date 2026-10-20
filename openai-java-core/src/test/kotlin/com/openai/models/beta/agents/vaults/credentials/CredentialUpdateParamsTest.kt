// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults.credentials

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CredentialUpdateParamsTest {

    @Test
    fun create() {
        CredentialUpdateParams.builder()
            .vaultId("vault_id")
            .credentialId("credential_id")
            .auth(
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
            .metadata(
                CredentialUpdateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            CredentialUpdateParams.builder()
                .vaultId("vault_id")
                .credentialId("credential_id")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("vault_id")
        assertThat(params._pathParam(1)).isEqualTo("credential_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            CredentialUpdateParams.builder()
                .vaultId("vault_id")
                .credentialId("credential_id")
                .auth(
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
                .metadata(
                    CredentialUpdateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.auth())
            .contains(
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
            )
        assertThat(body.metadata())
            .contains(
                CredentialUpdateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            CredentialUpdateParams.builder()
                .vaultId("vault_id")
                .credentialId("credential_id")
                .build()

        val body = params._body()
    }
}
