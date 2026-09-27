package com.openai.services

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.equalToJson
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import com.openai.client.OpenAIClient
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.LogLevel
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.vaults.credentials.Credential
import com.openai.models.beta.agents.vaults.credentials.CredentialAuthCreateParam
import com.openai.models.beta.agents.vaults.credentials.CredentialAuthRotateParam
import com.openai.models.beta.agents.vaults.credentials.CredentialCreateParams
import com.openai.models.beta.agents.vaults.credentials.CredentialNetworkingParam
import com.openai.models.beta.agents.vaults.credentials.CredentialRetrieveParams
import com.openai.models.beta.agents.vaults.credentials.CredentialUpdateParams
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.parallel.ResourceLock
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.slf4j.LoggerFactory

internal class EnvironmentCredentialsTest {
    private val server = WireMockServer(wireMockConfig().dynamicPort())
    private lateinit var client: OpenAIClient

    @BeforeEach
    fun setUp() {
        server.start()
        client = clientBuilder().build()
    }

    @AfterEach
    fun tearDown() {
        try {
            client.close()
        } finally {
            server.stop()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun createLimitedNetworking(async: Boolean) {
        val metadata =
            """{"type":"environment_variable","secret_name":"SDK_TEST_KEY","networking":{"type":"limited","allowed_hosts":["service.example.test"]}}"""
        stubCreate(metadata)
        val networking =
            CredentialNetworkingParam.ofLimited(
                CredentialNetworkingParam.Limited.builder()
                    .addAllowedHost("service.example.test")
                    .build()
            )

        val credential = create(environmentAuth(networking), async)

        credential.validate()
        assertThat(credential.auth().isEnvironmentVariable()).isTrue()
        val auth = credential.auth().asEnvironmentVariable()
        assertThat(auth.secretName()).isEqualTo("SDK_TEST_KEY")
        assertThat(auth.networking().asLimited().allowedHosts())
            .containsExactly("service.example.test")
        verifyCreate(
            """{"type":"environment_variable","secret_name":"SDK_TEST_KEY","secret_value":"fake-environment-secret","networking":{"type":"limited","allowed_hosts":["service.example.test"]}}"""
        )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun createUnrestrictedNetworking(async: Boolean) {
        stubCreate(unrestrictedMetadata())

        val credential = create(environmentAuth(CredentialNetworkingParam.ofUnrestricted()), async)

        credential.validate()
        assertThat(credential.auth().asEnvironmentVariable().networking().isUnrestricted()).isTrue()
        verifyCreate(
            """{"type":"environment_variable","secret_name":"SDK_TEST_KEY","secret_value":"fake-environment-secret","networking":{"type":"unrestricted"}}"""
        )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun rotationSendsOnlyReplacementSecret(async: Boolean) {
        server.stubFor(
            post(urlEqualTo(CREDENTIAL_PATH)).willReturn(jsonResponse(unrestrictedMetadata()))
        )
        val params =
            CredentialUpdateParams.builder()
                .vaultId("vault_test")
                .credentialId("credential_test")
                .auth(
                    CredentialAuthRotateParam.EnvironmentVariable.builder()
                        .secretValue("fake-replacement-secret")
                        .build()
                )
                .build()

        val credential =
            if (async) {
                client
                    .async()
                    .beta()
                    .agents()
                    .vaults()
                    .credentials()
                    .update(params)
                    .get(10, TimeUnit.SECONDS)
            } else {
                client.beta().agents().vaults().credentials().update(params)
            }

        credential.validate()
        assertThat(credential.auth().asEnvironmentVariable().secretName()).isEqualTo("SDK_TEST_KEY")
        server.verify(
            1,
            postRequestedFor(urlEqualTo(CREDENTIAL_PATH))
                .withRequestBody(
                    equalToJson(
                        """{"auth":{"type":"environment_variable","secret_value":"fake-replacement-secret"}}"""
                    )
                ),
        )
        assertThat(server.allServeEvents).hasSize(1)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun retrieveDecodesMetadataOnlyResponse(async: Boolean) {
        server.stubFor(
            get(urlEqualTo(CREDENTIAL_PATH)).willReturn(jsonResponse(unrestrictedMetadata()))
        )
        val params =
            CredentialRetrieveParams.builder()
                .vaultId("vault_test")
                .credentialId("credential_test")
                .build()

        val credential =
            if (async) {
                client
                    .async()
                    .beta()
                    .agents()
                    .vaults()
                    .credentials()
                    .retrieve(params)
                    .get(10, TimeUnit.SECONDS)
            } else {
                client.beta().agents().vaults().credentials().retrieve(params)
            }

        credential.validate()
        val auth = credential.auth().asEnvironmentVariable()
        assertThat(auth.secretName()).isEqualTo("SDK_TEST_KEY")
        assertThat(auth.networking().isUnrestricted()).isTrue()
        val metadata = jsonMapper().readTree(jsonMapper().writeValueAsString(auth))
        assertThat(metadata.fieldNames().asSequence().toSet())
            .containsExactlyInAnyOrder("type", "secret_name", "networking")
        server.verify(1, getRequestedFor(urlEqualTo(CREDENTIAL_PATH)))
        assertThat(server.allServeEvents).hasSize(1)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun existingCredentialVariantsKeepTheirWireShape(async: Boolean) {
        stubCreate(
            """{"type":"static_bearer","mcp_server_url":"https://service.example.test/mcp"}"""
        )
        val bearer =
            CredentialAuthCreateParam.ofStaticBearer(
                CredentialAuthCreateParam.StaticBearer.builder()
                    .mcpServerUrl("https://service.example.test/mcp")
                    .token("fake-mcp-token")
                    .build()
            )

        assertThat(create(bearer, async).auth().isStaticBearer()).isTrue()
        verifyCreate(
            """{"type":"static_bearer","mcp_server_url":"https://service.example.test/mcp","token":"fake-mcp-token"}"""
        )

        server.resetAll()
        stubCreate("""{"type":"mcp_oauth","mcp_server_url":"https://service.example.test/mcp"}""")
        val oauth =
            CredentialAuthCreateParam.ofMcpOAuth(
                CredentialAuthCreateParam.McpOAuth.builder()
                    .mcpServerUrl("https://service.example.test/mcp")
                    .accessToken("fake-oauth-token")
                    .build()
            )

        assertThat(create(oauth, async).auth().isMcpO()).isTrue()
        verifyCreate(
            """{"type":"mcp_oauth","mcp_server_url":"https://service.example.test/mcp","access_token":"fake-oauth-token"}"""
        )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    @ResourceLock("stderr")
    fun infoDiagnosticsDoNotLogEnvironmentSecrets(async: Boolean) {
        LoggerFactory.getILoggerFactory()
        client.close()
        client = clientBuilder().logLevel(LogLevel.INFO).build()
        stubCreate(unrestrictedMetadata())
        val originalErr = System.err
        val captured = ByteArrayOutputStream()
        try {
            System.setErr(PrintStream(captured))

            create(environmentAuth(CredentialNetworkingParam.ofUnrestricted()), async)

            assertThat(captured.toString("UTF-8"))
                .contains("--> POST", "<-- 200")
                .doesNotContain("fake-environment-secret", "fake-credential-api-key")
        } finally {
            System.setErr(originalErr)
        }
    }

    private fun clientBuilder() =
        OpenAIOkHttpClient.builder()
            .baseUrl(server.baseUrl())
            .apiKey("fake-credential-api-key")
            .maxRetries(0)

    private fun environmentAuth(networking: CredentialNetworkingParam) =
        CredentialAuthCreateParam.ofEnvironmentVariable(
            CredentialAuthCreateParam.EnvironmentVariable.builder()
                .secretName("SDK_TEST_KEY")
                .secretValue("fake-environment-secret")
                .networking(networking)
                .build()
        )

    private fun create(auth: CredentialAuthCreateParam, async: Boolean): Credential {
        val params =
            CredentialCreateParams.builder()
                .vaultId("vault_test")
                .name("Test credential")
                .auth(auth)
                .build()
        return if (async) {
            client
                .async()
                .beta()
                .agents()
                .vaults()
                .credentials()
                .create(params)
                .get(10, TimeUnit.SECONDS)
        } else {
            client.beta().agents().vaults().credentials().create(params)
        }
    }

    private fun stubCreate(auth: String) {
        server.stubFor(post(urlEqualTo(CREATE_PATH)).willReturn(jsonResponse(auth)))
    }

    private fun verifyCreate(auth: String) {
        server.verify(
            1,
            postRequestedFor(urlEqualTo(CREATE_PATH))
                .withHeader("Authorization", equalTo("Bearer fake-credential-api-key"))
                .withHeader("OpenAI-Beta", equalTo("agents=v1"))
                .withRequestBody(equalToJson("""{"name":"Test credential","auth":$auth}""")),
        )
        assertThat(server.allServeEvents).hasSize(1)
    }

    private fun jsonResponse(auth: String) =
        aResponse()
            .withHeader("Content-Type", "application/json")
            .withBody(
                """{"id":"credential_test","metadata":{},"auth":$auth,"created_at":1700000000,"updated_at":1700000000,"name":"Test credential","object":"vault.credential","vault_id":"vault_test"}"""
            )

    private fun unrestrictedMetadata() =
        """{"type":"environment_variable","secret_name":"SDK_TEST_KEY","networking":{"type":"unrestricted"}}"""

    companion object {
        private const val CREATE_PATH = "/vaults/vault_test/credentials"
        private const val CREDENTIAL_PATH = "$CREATE_PATH/credential_test"
    }
}
