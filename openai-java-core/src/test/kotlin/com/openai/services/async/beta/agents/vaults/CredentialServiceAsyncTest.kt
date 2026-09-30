// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.vaults

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.findAll
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.reset
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.beta.agents.vaults.credentials.CredentialAuthCreateParam
import com.openai.models.beta.agents.vaults.credentials.CredentialAuthRotateParam
import com.openai.models.beta.agents.vaults.credentials.CredentialCreateParams
import com.openai.models.beta.agents.vaults.credentials.CredentialDeleteParams
import com.openai.models.beta.agents.vaults.credentials.CredentialRetrieveParams
import com.openai.models.beta.agents.vaults.credentials.CredentialUpdateParams
import com.openai.models.beta.agents.vaults.credentials.McpOAuthTokenEndpointAuthRotateParam
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
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
                    .metadata(
                        CredentialCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
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
                    .metadata(
                        CredentialUpdateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        val credential = credentialFuture.get()
        credential.validate()
    }

    @Test
    fun listStopsOnExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        try {
            // A terminal page can still contain items and a cursor
            stubFor(
                get(anyUrl())
                    .willReturn(okJson("{\"data\":[{\"id\":\"item_1\"}],\"has_more\":false}"))
            )
            val page = client.beta().agents().vaults().credentials().list("vault_id").get()
            assertThat(page.items()).hasSize(1)
            assertThat(page.hasNextPage()).isFalse()

            val count = AtomicInteger()
            page.autoPager().subscribe { count.incrementAndGet() }.onCompleteFuture().get()
            assertThat(count.get()).isEqualTo(1)

            assertThat(findAll(getRequestedFor(anyUrl()))).hasSize(1)
        } finally {
            client.close()
        }
    }

    @Test
    fun listContinuesUntilExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
        // Both explicit true and a missing flag preserve normal cursor traversal.
        for (firstResponse in
            listOf(
                "{\"data\":[{\"id\":\"item_1\"}],\"has_more\":true}",
                "{\"data\":[{\"id\":\"item_1\"}]}",
            )) {
            reset()
            val client =
                OpenAIOkHttpClientAsync.builder()
                    .baseUrl(wmRuntimeInfo.httpBaseUrl)
                    .apiKey("My API Key")
                    .adminApiKey("My Admin API Key")
                    .build()
            try {
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("Started")
                        .willReturn(okJson(firstResponse))
                        .willSetStateTo("terminal")
                )
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("terminal")
                        .willReturn(okJson("{\"data\":[{\"id\":\"item_1\"}],\"has_more\":false}"))
                        .willSetStateTo("unexpected")
                )
                // Bound a regression to one extra request instead of an infinite loop.
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("unexpected")
                        .willReturn(okJson("{}"))
                )
                val page = client.beta().agents().vaults().credentials().list("vault_id").get()
                assertThat(page.hasNextPage()).isTrue()

                val count = AtomicInteger()
                page.autoPager().subscribe { count.incrementAndGet() }.onCompleteFuture().get()
                assertThat(count.get()).isEqualTo(2)

                assertThat(findAll(getRequestedFor(anyUrl()))).hasSize(2)
            } finally {
                client.close()
            }
        }
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
