// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.vaults

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.beta.agents.vaults.credentials.CredentialAuthCreateParam
import com.openai.models.beta.agents.vaults.credentials.CredentialAuthRotateParam
import com.openai.models.beta.agents.vaults.credentials.CredentialCreateParams
import com.openai.models.beta.agents.vaults.credentials.CredentialDeleteParams
import com.openai.models.beta.agents.vaults.credentials.CredentialRetrieveParams
import com.openai.models.beta.agents.vaults.credentials.CredentialUpdateParams
import com.openai.models.beta.agents.vaults.credentials.McpOAuthTokenEndpointAuthRotateParam
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CredentialServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val credentialService = client.beta().agents().vaults().credentials()

        val credential =
            credentialService.create(
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
            )

        credential.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val credentialService = client.beta().agents().vaults().credentials()

        val credential =
            credentialService.retrieve(
                CredentialRetrieveParams.builder()
                    .vaultId("vault_id")
                    .credentialId("credential_id")
                    .build()
            )

        credential.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val credentialService = client.beta().agents().vaults().credentials()

        val credential =
            credentialService.update(
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
                                        McpOAuthTokenEndpointAuthRotateParam.ClientSecretBasic
                                            .builder()
                                            .clientSecret("client_secret")
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        credential.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val credentialService = client.beta().agents().vaults().credentials()

        val page = credentialService.list("vault_id")

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val credentialService = client.beta().agents().vaults().credentials()

        val credentialDeleted =
            credentialService.delete(
                CredentialDeleteParams.builder()
                    .vaultId("vault_id")
                    .credentialId("credential_id")
                    .build()
            )

        credentialDeleted.validate()
    }
}
