// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.vaults

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
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
internal class CredentialServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val credentialServiceAsync = client.beta().agents().vaults().credentials()

        val credentialFuture =
            credentialServiceAsync.create(
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

        val credential = credentialFuture.get()
        credential.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val credentialServiceAsync = client.beta().agents().vaults().credentials()

        val credentialFuture =
            credentialServiceAsync.retrieve(
                CredentialRetrieveParams.builder()
                    .vaultId("vault_id")
                    .credentialId("credential_id")
                    .build()
            )

        val credential = credentialFuture.get()
        credential.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val credentialServiceAsync = client.beta().agents().vaults().credentials()

        val credentialFuture =
            credentialServiceAsync.update(
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

        val credential = credentialFuture.get()
        credential.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val credentialServiceAsync = client.beta().agents().vaults().credentials()

        val pageFuture = credentialServiceAsync.list("vault_id")

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val credentialServiceAsync = client.beta().agents().vaults().credentials()

        val credentialDeletedFuture =
            credentialServiceAsync.delete(
                CredentialDeleteParams.builder()
                    .vaultId("vault_id")
                    .credentialId("credential_id")
                    .build()
            )

        val credentialDeleted = credentialDeletedFuture.get()
        credentialDeleted.validate()
    }
}
