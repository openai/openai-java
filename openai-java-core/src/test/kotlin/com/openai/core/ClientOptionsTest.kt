package com.openai.core

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.auth.SubjectTokenProvider
import com.openai.auth.SubjectTokenType
import com.openai.auth.WorkloadIdentity
import com.openai.azure.credential.AzureApiKeyCredential
import com.openai.client.OpenAIClientAsyncImpl
import com.openai.client.OpenAIClientImpl
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestAuthenticator
import com.openai.core.http.HttpResponse
import com.openai.credential.BearerTokenCredential
import com.openai.credential.WorkloadIdentityCredential
import java.lang.ref.WeakReference
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutorService
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

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
    fun toBuilder_closingDerivedOptionsDoesNotCloseSharedResources() {
        val executor = mock<ExecutorService>()
        val sleeper = mock<Sleeper>()
        val original =
            ClientOptions.builder()
                .httpClient(httpClient)
                .streamHandlerExecutor(executor)
                .sleeper(sleeper)
                .apiKey("My API Key")
                .build()
        val derived = original.toBuilder().baseUrl("https://example.test").build()

        derived.close()

        verify(httpClient, never()).close()
        verify(executor, never()).shutdown()
        verify(sleeper, never()).close()

        original.close()

        verify(httpClient).close()
        verify(executor).shutdown()
        verify(sleeper).close()
    }

    @Test
    fun toBuilder_closingOriginalOptionsDoesNotCloseResourcesUsedByDerivedOptions() {
        val executor = mock<ExecutorService>()
        val sleeper = mock<Sleeper>()
        val original =
            ClientOptions.builder()
                .httpClient(httpClient)
                .streamHandlerExecutor(executor)
                .sleeper(sleeper)
                .apiKey("My API Key")
                .build()
        val derived = original.toBuilder().build()

        original.close()

        verify(httpClient, never()).close()
        verify(executor, never()).shutdown()
        verify(sleeper, never()).close()

        derived.close()
        derived.close()

        verify(httpClient, times(1)).close()
        verify(executor, times(1)).shutdown()
        verify(sleeper, times(1)).close()
    }

    @Test
    fun toBuilder_replacingHttpClientOnlyClosesReplacement() {
        val replacement = mock<HttpClient>()
        val original = ClientOptions.builder().httpClient(httpClient).apiKey("My API Key").build()
        val derived = original.toBuilder().httpClient(replacement).build()

        derived.close()

        verify(replacement).close()
        verify(httpClient, never()).close()

        original.close()

        verify(httpClient).close()
    }

    @Test
    fun syncClientCloseClosesInternalUserAgentOptions() {
        val options = ClientOptions.builder().httpClient(httpClient).apiKey("My API Key").build()

        OpenAIClientImpl(options).close()

        verify(httpClient).close()
    }

    @Test
    fun asyncClientCloseClosesInternalUserAgentOptions() {
        val options = ClientOptions.builder().httpClient(httpClient).apiKey("My API Key").build()

        OpenAIClientAsyncImpl(options).close()

        verify(httpClient).close()
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
    fun inFlightAsyncRequest_keepsResourcesOpenWhenClientOptionsIsGarbageCollected() {
        val pendingResponse = CompletableFuture<HttpResponse>()
        val sleeper = mock<Sleeper>()
        val executor = mock<ExecutorService>()
        whenever(
                httpClient.executeAsync(
                    any<HttpRequest>(),
                    any(),
                )
            )
            .thenReturn(pendingResponse)

        val (requestFuture, optionsReference) =
            startPendingAsyncRequest(httpClient, sleeper, executor)

        val deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
        while (System.nanoTime() < deadline && optionsReference.get() != null) {
            System.gc()
            Thread.sleep(10)
        }

        assertThat(optionsReference.get()).isNull()
        verify(httpClient, never()).close()
        verify(sleeper, never()).close()
        verify(executor, never()).shutdown()

        requestFuture.cancel(false)
    }

    private fun startPendingAsyncRequest(
        httpClient: HttpClient,
        sleeper: Sleeper,
        executor: ExecutorService,
    ): Pair<CompletableFuture<HttpResponse>, WeakReference<ClientOptions>> {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .sleeper(sleeper)
                .streamHandlerExecutor(executor)
                .build()
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://example.com")
                .build()
        val future = clientOptions.httpClient.executeAsync(request)
        return future to WeakReference(clientOptions)
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
