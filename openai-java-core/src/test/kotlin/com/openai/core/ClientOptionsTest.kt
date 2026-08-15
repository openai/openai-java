package com.openai.core

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.auth.SubjectTokenProvider
import com.openai.auth.SubjectTokenType
import com.openai.auth.WorkloadIdentity
import com.openai.azure.credential.AzureApiKeyCredential
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestAuthenticator
import com.openai.credential.BearerTokenCredential
import com.openai.credential.WorkloadIdentityCredential
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.verify

@ExtendWith(MockitoExtension::class)
internal class ClientOptionsTest {

    private val httpClient = mock<HttpClient>()

    @Test
    fun build_withApiKey_success() {
        val clientOptions =
            ClientOptions.builder().httpClient(httpClient).apiKey("My API Key").build()

        assertThat(
                clientOptions
                    .securityHeaders(SecurityOptions.builder().bearerAuth(true).build())
                    .values("Authorization")
            )
            .containsExactly("Bearer My API Key")
    }

    @Test
    fun build_withAzureApiKeyCredential_success() {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .credential(AzureApiKeyCredential.create("My Azure API Key"))
                .build()

        assertThat(
                clientOptions
                    .securityHeaders(SecurityOptions.builder().bearerAuth(true).build())
                    .values("api-key")
            )
            .containsExactly("My Azure API Key")
    }

    @Test
    fun build_withCredentialAfterApiKey_usesCredential() {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .apiKey("Old API Key")
                .credential(BearerTokenCredential.create("New API Key"))
                .build()

        assertThat(clientOptions.apiKey()).isEmpty()
        assertThat(
                clientOptions
                    .securityHeaders(SecurityOptions.builder().bearerAuth(true).build())
                    .values("Authorization")
            )
            .containsExactly("Bearer New API Key")
    }

    @Test
    fun build_withApiKeyAndAdminApiKey_usesRouteSpecificAuth() {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()

        assertThat(
                clientOptions
                    .securityHeaders(SecurityOptions.builder().bearerAuth(true).build())
                    .values("Authorization")
            )
            .containsExactly("Bearer My API Key")
        assertThat(
                clientOptions
                    .securityHeaders(SecurityOptions.builder().adminApiKeyAuth(true).build())
                    .values("Authorization")
            )
            .containsExactly("Bearer My Admin API Key")
    }

    @Test
    fun build_withAdminApiKeyOnly_success() {
        val clientOptions =
            ClientOptions.builder().httpClient(httpClient).adminApiKey("My Admin API Key").build()

        assertThat(clientOptions.apiKey()).isEmpty()
        assertThat(clientOptions.adminApiKey()).contains("My Admin API Key")
        assertThat(
                clientOptions
                    .securityHeaders(SecurityOptions.builder().adminApiKeyAuth(true).build())
                    .values("Authorization")
            )
            .containsExactly("Bearer My Admin API Key")
    }

    @Test
    fun build_withAdminApiKeyOnly_bearerAuthThrows() {
        val clientOptions =
            ClientOptions.builder().httpClient(httpClient).adminApiKey("My Admin API Key").build()

        val thrown =
            assertThrows<IllegalStateException> {
                clientOptions.securityHeaders(SecurityOptions.builder().bearerAuth(true).build())
            }

        assertThat(thrown.message).contains("requires apiKey or workloadIdentity")
    }

    @Test
    fun build_withoutCredentials_throws() {
        val thrown =
            assertThrows<IllegalStateException> {
                ClientOptions.builder().httpClient(httpClient).build()
            }

        assertThat(thrown.message).contains("At least one credential source")
    }

    @Test
    fun build_withHttpRequestAuthenticator_satisfiesAuthenticationAndSurvivesCloning() {
        val authenticator =
            object : HttpRequestAuthenticator {
                override fun authenticate(request: HttpRequest): HttpRequest = request
            }

        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .httpRequestAuthenticator(authenticator)
                .build()
                .toBuilder()
                .build()

        assertThat(
                clientOptions.securityHeaders(SecurityOptions.builder().bearerAuth(true).build())
            )
            .isEqualTo(com.openai.core.http.Headers.builder().build())
        assertThat(
                clientOptions.securityHeaders(
                    SecurityOptions.builder().adminApiKeyAuth(true).build()
                )
            )
            .isEqualTo(com.openai.core.http.Headers.builder().build())
    }

    @Test
    fun build_withHttpRequestAuthenticatorAndApiKey_throws() {
        val authenticator =
            object : HttpRequestAuthenticator {
                override fun authenticate(request: HttpRequest): HttpRequest = request
            }

        val thrown =
            assertThrows<IllegalStateException> {
                ClientOptions.builder()
                    .httpClient(httpClient)
                    .httpRequestAuthenticator(authenticator)
                    .apiKey("test-api-key")
                    .build()
            }

        assertThat(thrown.message).contains("Provider authentication cannot be combined")
    }

    @Test
    fun putHeader_canOverwriteDefaultHeader() {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .putHeader("User-Agent", "My User Agent")
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()

        assertThat(clientOptions.headers.values("User-Agent")).containsExactly("My User Agent")
    }

    @Test
    fun toBuilder_organizationCanBeUpdated() {
        var clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .organization("My Organization")
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()

        clientOptions = clientOptions.toBuilder().organization("another My Organization").build()

        assertThat(clientOptions.headers.values("OpenAI-Organization"))
            .containsExactly("another My Organization")
    }

    @Test
    fun toBuilder_whenOriginalClientOptionsGarbageCollected_doesNotCloseOriginalClient() {
        var clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        verify(httpClient, never()).close()

        // Overwrite the `clientOptions` variable so that the original `ClientOptions` is GC'd.
        clientOptions = clientOptions.toBuilder().build()
        System.gc()
        Thread.sleep(100)

        verify(httpClient, never()).close()
        // This exists so that `clientOptions` is still reachable.
        assertThat(clientOptions).isEqualTo(clientOptions)
    }

    @Test
    fun toBuilder_whenOriginalClientOptionsGarbageCollected_doesNotCloseAuthenticator() {
        val authenticator = mock<HttpRequestAuthenticator>()
        var clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .httpRequestAuthenticator(authenticator)
                .build()
        verify(authenticator, never()).close()

        clientOptions = clientOptions.toBuilder().build()
        System.gc()
        Thread.sleep(100)

        verify(authenticator, never()).close()
        // This exists so that `clientOptions` is still reachable.
        assertThat(clientOptions).isEqualTo(clientOptions)
    }

    @Test
    fun build_withWorkloadIdentity_success() {
        val provider =
            object : SubjectTokenProvider {
                override fun tokenType() = SubjectTokenType.JWT

                override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String =
                    "test-token"

                override fun getTokenAsync(
                    httpClient: HttpClient,
                    jsonMapper: JsonMapper,
                ): CompletableFuture<String> = CompletableFuture.completedFuture("test-token")
            }

        val workloadIdentity =
            WorkloadIdentity.builder()
                .identityProviderId("provider-id")
                .serviceAccountId("service-account-id")
                .provider(provider)
                .build()

        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .workloadIdentity(workloadIdentity)
                .build()

        assertThat(clientOptions.credential).isInstanceOf(WorkloadIdentityCredential::class.java)
        assertThat(clientOptions.baseUrl()).isEqualTo(ClientOptions.PRODUCTION_URL)
    }

    @Test
    fun build_withX509WorkloadIdentity_defaultsToMtlsBaseUrl() {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .workloadIdentity(
                    WorkloadIdentity.x509Builder()
                        .identityProviderId("idp_test")
                        .serviceAccountId("svc_acct_test")
                        .build()
                )
                .build()

        assertThat(clientOptions.credential).isInstanceOf(WorkloadIdentityCredential::class.java)
        assertThat(clientOptions.baseUrl()).isEqualTo("https://mtls.api.openai.com/v1")
    }

    @Test
    fun build_withX509WorkloadIdentity_preservesExplicitBaseUrl() {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .baseUrl("https://mtls-eu.api.openai.com/v1")
                .workloadIdentity(
                    WorkloadIdentity.x509Builder()
                        .identityProviderId("idp_test")
                        .serviceAccountId("svc_acct_test")
                        .build()
                )
                .build()

        assertThat(clientOptions.baseUrl()).isEqualTo("https://mtls-eu.api.openai.com/v1")
    }

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                "http://localhost:8080/v1",
                "ftp://mtls.api.openai.com/v1",
                "/v1",
                "https:opaque",
                "not a valid URL",
            ]
    )
    fun build_withX509WorkloadIdentity_rejectsInsecureOrNonAbsoluteBaseUrl(baseUrl: String) {
        val thrown =
            assertThrows<IllegalArgumentException> {
                ClientOptions.builder()
                    .httpClient(httpClient)
                    .baseUrl(baseUrl)
                    .workloadIdentity(
                        WorkloadIdentity.x509Builder()
                            .identityProviderId("idp_test")
                            .serviceAccountId("svc_acct_test")
                            .build()
                    )
                    .build()
            }

        assertThat(thrown).hasMessage("X.509 workload identity requires an absolute HTTPS base URL")
    }

    @Test
    fun build_withApiKey_preservesPlaintextLocalBaseUrl() {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .baseUrl("http://localhost:8080/v1")
                .apiKey("test-api-key")
                .build()

        assertThat(clientOptions.baseUrl()).isEqualTo("http://localhost:8080/v1")
    }

    @Test
    fun build_withSubjectTokenWorkloadIdentity_preservesPlaintextLocalBaseUrl() {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .baseUrl("http://localhost:8080/v1")
                .workloadIdentity(
                    WorkloadIdentity.builder()
                        .identityProviderId("idp_test")
                        .serviceAccountId("svc_acct_test")
                        .provider(mock())
                        .build()
                )
                .build()

        assertThat(clientOptions.baseUrl()).isEqualTo("http://localhost:8080/v1")
    }

    @Test
    fun toBuilder_switchingX509WorkloadIdentityToApiKey_restoresPublicDefaultBaseUrl() {
        val original =
            ClientOptions.builder()
                .httpClient(httpClient)
                .workloadIdentity(
                    WorkloadIdentity.x509Builder()
                        .identityProviderId("idp_test")
                        .serviceAccountId("svc_acct_test")
                        .build()
                )
                .build()

        val updated = original.toBuilder().apiKey("test-api-key").build()

        assertThat(updated.baseUrl()).isEqualTo(ClientOptions.PRODUCTION_URL)
    }

    @Test
    fun toBuilder_withX509WorkloadIdentity_carriesDiscriminator() {
        val original =
            ClientOptions.builder()
                .httpClient(httpClient)
                .workloadIdentity(
                    WorkloadIdentity.x509Builder()
                        .identityProviderId("idp_test")
                        .serviceAccountId("svc_acct_test")
                        .build()
                )
                .build()

        val updated = original.toBuilder().baseUrl(null as String?).build()

        assertThat(updated.baseUrl()).isEqualTo("https://mtls.api.openai.com/v1")
        assertThat(updated.credential).isSameAs(original.credential)
    }

    @Test
    fun toBuilder_withX509WorkloadIdentity_rebindsAuthWhenTransportChanges() {
        val original =
            ClientOptions.builder()
                .httpClient(httpClient)
                .workloadIdentity(
                    WorkloadIdentity.x509Builder()
                        .identityProviderId("idp_test")
                        .serviceAccountId("svc_acct_test")
                        .build()
                )
                .build()

        val updated = original.toBuilder().httpClient(mock()).build()

        assertThat(updated.credential).isNotSameAs(original.credential)
        assertThat(updated.baseUrl()).isEqualTo("https://mtls.api.openai.com/v1")
    }

    @Test
    fun toBuilder_withWorkloadIdentity_success() {
        val provider =
            object : SubjectTokenProvider {
                override fun tokenType() = SubjectTokenType.JWT

                override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String =
                    "test-token"

                override fun getTokenAsync(
                    httpClient: HttpClient,
                    jsonMapper: JsonMapper,
                ): CompletableFuture<String> = CompletableFuture.completedFuture("test-token")
            }

        val workloadIdentity =
            WorkloadIdentity.builder()
                .identityProviderId("provider-id")
                .serviceAccountId("service-account-id")
                .provider(provider)
                .build()

        var clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .workloadIdentity(workloadIdentity)
                .build()

        clientOptions = clientOptions.toBuilder().build()

        assertThat(clientOptions.credential).isInstanceOf(WorkloadIdentityCredential::class.java)
    }

    @Test
    fun toBuilder_workloadIdentityCanBeSwitchedToApiKey() {
        val provider =
            object : SubjectTokenProvider {
                override fun tokenType() = SubjectTokenType.JWT

                override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String =
                    "test-token"

                override fun getTokenAsync(
                    httpClient: HttpClient,
                    jsonMapper: JsonMapper,
                ): CompletableFuture<String> = CompletableFuture.completedFuture("test-token")
            }

        val workloadIdentity =
            WorkloadIdentity.builder()
                .identityProviderId("provider-id")
                .serviceAccountId("service-account-id")
                .provider(provider)
                .build()

        val original =
            ClientOptions.builder()
                .httpClient(httpClient)
                .workloadIdentity(workloadIdentity)
                .build()

        val updated = original.toBuilder().workloadIdentity(null).apiKey("new-api-key").build()

        assertThat(updated.credential).isNotInstanceOf(WorkloadIdentityCredential::class.java)
        assertThat(
                updated
                    .securityHeaders(SecurityOptions.builder().bearerAuth(true).build())
                    .values("Authorization")
            )
            .containsExactly("Bearer new-api-key")
    }

    @Test
    fun build_withBothCredentialAndWorkloadIdentity_throws() {
        val provider =
            object : SubjectTokenProvider {
                override fun tokenType() = SubjectTokenType.JWT

                override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String =
                    "test-token"

                override fun getTokenAsync(
                    httpClient: HttpClient,
                    jsonMapper: JsonMapper,
                ): CompletableFuture<String> = CompletableFuture.completedFuture("test-token")
            }

        val workloadIdentity =
            WorkloadIdentity.builder()
                .identityProviderId("provider-id")
                .serviceAccountId("service-account-id")
                .provider(provider)
                .build()

        val thrown =
            assertThrows<IllegalStateException> {
                ClientOptions.builder()
                    .httpClient(httpClient)
                    .apiKey("test-api-key")
                    .workloadIdentity(workloadIdentity)
                    .build()
            }

        assertThat(thrown.message).contains("Cannot specify both")
    }
}
