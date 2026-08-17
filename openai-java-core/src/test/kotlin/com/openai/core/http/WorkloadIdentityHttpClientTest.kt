package com.openai.core.http

import com.openai.auth.WorkloadIdentityAuth
import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import com.openai.errors.OpenAIRetryableException
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.io.OutputStream
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.argThat
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExtendWith(MockitoExtension::class)
internal class WorkloadIdentityHttpClientTest {

    @Test
    fun executeInjectsBearerToken() {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.getToken()).thenReturn("test-token")
        val delegateHttpClient = mock<HttpClient>()
        whenever(delegateHttpClient.execute(any(), any())).thenReturn(mockResponse(200, "success"))
        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)

        val result = client.execute(request(), RequestOptions.none())

        assertThat(result.statusCode()).isEqualTo(200)
        verify(delegateHttpClient)
            .execute(
                argThat { req ->
                    req.headers.values("Authorization").contains("Bearer test-token")
                },
                any(),
            )
    }

    @Test
    fun executeWithX509RefusesRedirectsForApiRequest() {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.getTokenLease()).thenReturn(tokenLease("test-token"))
        whenever(workloadIdentityAuth.isX509).thenReturn(true)
        val delegateHttpClient = mock<HttpClient>()
        whenever(delegateHttpClient.execute(any(), any())).thenReturn(mockResponse(200, "success"))
        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)

        client.execute(request(), RequestOptions.none())

        verify(delegateHttpClient).execute(argThat { req -> !req.followRedirects }, any())
    }

    @ParameterizedTest
    @CsvSource(
        value =
            [
                "false|https://MTLS.API.OPENAI.COM/v1|https://mtls.api.openai.com:443/v1/models",
                "true|https://MTLS.API.OPENAI.COM/v1|https://mtls.api.openai.com:443/v1/models",
                "false|https://regional.example:8443/v1|https://REGIONAL.EXAMPLE:8443/models",
                "true|https://regional.example:8443/v1|https://REGIONAL.EXAMPLE:8443/models",
            ],
        delimiter = '|',
    )
    fun x509AllowsNormalizedConfiguredHttpsOrigin(
        async: Boolean,
        configuredBaseUrl: String,
        requestUrl: String,
    ) {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.isX509).thenReturn(true)
        val token = tokenLease("test-token")
        val delegateHttpClient = mock<HttpClient>()
        val response = mockResponse(200, "success")
        if (async) {
            whenever(workloadIdentityAuth.getTokenLeaseAsync())
                .thenReturn(CompletableFuture.completedFuture(token))
            whenever(delegateHttpClient.executeAsync(any(), any()))
                .thenReturn(CompletableFuture.completedFuture(response))
        } else {
            whenever(workloadIdentityAuth.getTokenLease()).thenReturn(token)
            whenever(delegateHttpClient.execute(any(), any())).thenReturn(response)
        }
        val client =
            WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth, configuredBaseUrl)
        val request = HttpRequest.builder().method(HttpMethod.GET).baseUrl(requestUrl).build()

        val actual =
            if (async) client.executeAsync(request, RequestOptions.none()).get()
            else client.execute(request, RequestOptions.none())

        assertThat(actual).isSameAs(response)
    }

    @ParameterizedTest
    @CsvSource(
        value =
            [
                "false|api-key",
                "true|api-key",
                "false|API-Key",
                "true|API-Key",
                "false|x-api-key",
                "true|x-api-key",
                "false|X-API-Key",
                "true|X-API-Key",
                "false|api_key",
                "true|api_key",
                "false|API_KEY",
                "true|API_KEY",
                "false|x_api_key",
                "true|x_api_key",
                "false|X_API_KEY",
                "true|X_API_KEY",
                "false|x-api_key",
                "true|x-api_key",
                "false|X_API-Key",
                "true|X_API-Key",
                "false|Proxy-Authorization",
                "true|Proxy-Authorization",
                "false|PROXY-AUTHORIZATION",
                "true|PROXY-AUTHORIZATION",
                "false|proxy_authorization",
                "true|proxy_authorization",
                "false|PROXY_AUTHORIZATION",
                "true|PROXY_AUTHORIZATION",
            ],
        delimiter = '|',
    )
    fun x509RejectsMixedApiKeyHeadersBeforeTokenExchange(async: Boolean, header: String) {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.isX509).thenReturn(true)
        val delegateHttpClient = mock<HttpClient>()
        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)
        val request = request().toBuilder().putHeader(header, "secret-api-key").build()

        assertThatThrownBy {
                if (async) client.executeAsync(request, RequestOptions.none())
                else client.execute(request, RequestOptions.none())
            }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("must not include API-key credentials")

        verify(workloadIdentityAuth, never()).getTokenLease()
        verify(workloadIdentityAuth, never()).getTokenLeaseAsync()
        verify(delegateHttpClient, never()).execute(any(), any())
        verify(delegateHttpClient, never()).executeAsync(any(), any())
    }

    @ParameterizedTest
    @CsvSource(
        value =
            [
                "false|Host|attacker.invalid",
                "true|Host|attacker.invalid",
                "false|hOsT|attacker.invalid:443",
                "true|hOsT|attacker.invalid:443",
                "false|Host|mtls.api.openai.com:8443",
                "true|Host|mtls.api.openai.com:8443",
                "false|Host|mtls.api.openai.com@attacker.invalid",
                "true|Host|mtls.api.openai.com@attacker.invalid",
                "false|:authority|attacker.invalid",
                "true|:authority|attacker.invalid",
            ],
        delimiter = '|',
    )
    fun x509RejectsVirtualHostConfusionBeforeTokenExchange(
        async: Boolean,
        header: String,
        value: String,
    ) {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.isX509).thenReturn(true)
        val delegateHttpClient = mock<HttpClient>()
        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)
        val request = request().toBuilder().putHeader(header, value).build()

        assertThatThrownBy {
                if (async) client.executeAsync(request, RequestOptions.none())
                else client.execute(request, RequestOptions.none())
            }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("must use the configured HTTPS authority")

        verify(workloadIdentityAuth, never()).getTokenLease()
        verify(workloadIdentityAuth, never()).getTokenLeaseAsync()
        verify(delegateHttpClient, never()).execute(any(), any())
        verify(delegateHttpClient, never()).executeAsync(any(), any())
    }

    @ParameterizedTest
    @CsvSource(
        value =
            [
                "false|https://mtls.api.openai.com/v1|MTLS.API.OPENAI.COM",
                "true|https://mtls.api.openai.com/v1|MTLS.API.OPENAI.COM",
                "false|https://mtls.api.openai.com/v1|mtls.api.openai.com:443",
                "true|https://mtls.api.openai.com/v1|mtls.api.openai.com:443",
                "false|https://regional.example:8443/v1|REGIONAL.EXAMPLE:8443",
                "true|https://regional.example:8443/v1|REGIONAL.EXAMPLE:8443",
            ],
        delimiter = '|',
    )
    fun x509AllowsMatchingNormalizedHostAuthority(
        async: Boolean,
        baseUrl: String,
        authority: String,
    ) {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.isX509).thenReturn(true)
        val token = tokenLease("test-token")
        val delegateHttpClient = mock<HttpClient>()
        val response = mockResponse(200, "success")
        if (async) {
            whenever(workloadIdentityAuth.getTokenLeaseAsync())
                .thenReturn(CompletableFuture.completedFuture(token))
            whenever(delegateHttpClient.executeAsync(any(), any()))
                .thenReturn(CompletableFuture.completedFuture(response))
        } else {
            whenever(workloadIdentityAuth.getTokenLease()).thenReturn(token)
            whenever(delegateHttpClient.execute(any(), any())).thenReturn(response)
        }
        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth, baseUrl)
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl(baseUrl)
                .putHeader("Host", authority)
                .build()

        val actual =
            if (async) client.executeAsync(request, RequestOptions.none()).get()
            else client.execute(request, RequestOptions.none())

        assertThat(actual).isSameAs(response)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun x509RejectsDuplicateHostAuthorities(async: Boolean) {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.isX509).thenReturn(true)
        val delegateHttpClient = mock<HttpClient>()
        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)
        val request =
            request()
                .toBuilder()
                .putHeader("Host", "mtls.api.openai.com")
                .putHeader("host", "attacker.invalid")
                .build()

        assertThatThrownBy {
                if (async) client.executeAsync(request, RequestOptions.none())
                else client.execute(request, RequestOptions.none())
            }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("must use the configured HTTPS authority")

        verify(workloadIdentityAuth, never()).getTokenLease()
        verify(workloadIdentityAuth, never()).getTokenLeaseAsync()
        verify(delegateHttpClient, never()).execute(any(), any())
        verify(delegateHttpClient, never()).executeAsync(any(), any())
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun x509PreservesConfiguredAdministratorAuthorization(async: Boolean) {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.isX509).thenReturn(true)
        val delegateHttpClient = mock<HttpClient>()
        val response = mockResponse(200, "admin success")
        if (async) {
            whenever(delegateHttpClient.executeAsync(any(), any()))
                .thenReturn(CompletableFuture.completedFuture(response))
        } else {
            whenever(delegateHttpClient.execute(any(), any())).thenReturn(response)
        }
        val client =
            WorkloadIdentityHttpClient(
                delegateHttpClient,
                workloadIdentityAuth,
                "https://mtls.api.openai.com/v1",
                "admin-secret",
            )
        val request =
            request().toBuilder().putHeader("Authorization", "Bearer admin-secret").build()

        val actual =
            if (async) client.executeAsync(request, RequestOptions.none()).get()
            else client.execute(request, RequestOptions.none())

        assertThat(actual).isSameAs(response)
        if (async) {
            verify(delegateHttpClient)
                .executeAsync(
                    argThat { current ->
                        current.headers.values("Authorization") == listOf("Bearer admin-secret") &&
                            !current.followRedirects
                    },
                    any(),
                )
        } else {
            verify(delegateHttpClient)
                .execute(
                    argThat { current ->
                        current.headers.values("Authorization") == listOf("Bearer admin-secret") &&
                            !current.followRedirects
                    },
                    any(),
                )
        }
        verify(workloadIdentityAuth, never()).getTokenLease()
        verify(workloadIdentityAuth, never()).getTokenLeaseAsync()
    }

    @ParameterizedTest
    @CsvSource(
        value =
            [
                "false|false|Bearer admin-secret",
                "true|false|Bearer admin-secret",
                "false|true|Basic customer-secret",
                "true|true|Basic customer-secret",
                "false|true|Bearer attacker-secret",
                "true|true|Bearer attacker-secret",
            ],
        delimiter = '|',
    )
    fun x509RejectsUnexpectedAuthorizationBeforeTokenExchange(
        async: Boolean,
        configuredAdministrator: Boolean,
        authorization: String,
    ) {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.isX509).thenReturn(true)
        val delegateHttpClient = mock<HttpClient>()
        val client =
            WorkloadIdentityHttpClient(
                delegateHttpClient,
                workloadIdentityAuth,
                "https://mtls.api.openai.com/v1",
                if (configuredAdministrator) "admin-secret" else null,
            )
        val request = request().toBuilder().putHeader("Authorization", authorization).build()

        assertThatThrownBy {
                if (async) client.executeAsync(request, RequestOptions.none())
                else client.execute(request, RequestOptions.none())
            }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("must not override the selected authorization")

        verify(workloadIdentityAuth, never()).getTokenLease()
        verify(workloadIdentityAuth, never()).getTokenLeaseAsync()
        verify(delegateHttpClient, never()).execute(any(), any())
        verify(delegateHttpClient, never()).executeAsync(any(), any())
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun x509RejectsDuplicateAdministratorAuthorization(async: Boolean) {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.isX509).thenReturn(true)
        val delegateHttpClient = mock<HttpClient>()
        val client =
            WorkloadIdentityHttpClient(
                delegateHttpClient,
                workloadIdentityAuth,
                "https://mtls.api.openai.com/v1",
                "admin-secret",
            )
        val request =
            request()
                .toBuilder()
                .putHeader("Authorization", "Bearer admin-secret")
                .putHeader("authorization", "Basic customer-secret")
                .build()

        assertThatThrownBy {
                if (async) client.executeAsync(request, RequestOptions.none())
                else client.execute(request, RequestOptions.none())
            }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("must not override the selected authorization")

        verify(workloadIdentityAuth, never()).getTokenLease()
        verify(workloadIdentityAuth, never()).getTokenLeaseAsync()
        verify(delegateHttpClient, never()).execute(any(), any())
        verify(delegateHttpClient, never()).executeAsync(any(), any())
    }

    @Test
    fun executeOn401PreservesSubjectTokenRetrySignal() {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.getToken()).thenReturn("test-token")
        val delegateHttpClient = mock<HttpClient>()
        val response401 = mock<HttpResponse>()
        whenever(response401.statusCode()).thenReturn(401)
        whenever(delegateHttpClient.execute(any(), any())).thenReturn(response401)
        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)

        assertThatThrownBy { client.execute(request(), RequestOptions.none()) }
            .isInstanceOf(OpenAIRetryableException::class.java)
            .hasMessage("OAuth token is expired")

        verify(delegateHttpClient).execute(any(), any())
        verify(workloadIdentityAuth).invalidateToken()
        verify(response401).close()
    }

    @Test
    fun executeAsyncOn401PreservesSubjectTokenRetrySignal() {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.getTokenAsync())
            .thenReturn(CompletableFuture.completedFuture("test-token"))
        val delegateHttpClient = mock<HttpClient>()
        val response401 = mock<HttpResponse>()
        whenever(response401.statusCode()).thenReturn(401)
        whenever(delegateHttpClient.executeAsync(any(), any()))
            .thenReturn(CompletableFuture.completedFuture(response401))
        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)

        assertThatThrownBy { client.executeAsync(request(), RequestOptions.none()).get() }
            .hasCauseInstanceOf(OpenAIRetryableException::class.java)
            .cause()
            .hasMessage("OAuth token is expired")

        verify(delegateHttpClient).executeAsync(any(), any())
        verify(workloadIdentityAuth).invalidateToken()
        verify(response401).close()
    }

    @Test
    fun executeOn401InvalidatesAndReplaysExactlyOnce() {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.isX509).thenReturn(true)
        val oldToken = tokenLease("old-token")
        val newToken = tokenLease("new-token")
        whenever(workloadIdentityAuth.getTokenLease()).thenReturn(oldToken, newToken)
        val delegateHttpClient = mock<HttpClient>()
        val response401 = mock<HttpResponse>()
        whenever(response401.statusCode()).thenReturn(401)
        whenever(delegateHttpClient.execute(any(), any()))
            .thenReturn(response401, mockResponse(200, "success"))
        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)

        val result = client.execute(request(repeatable = true), RequestOptions.none())

        assertThat(result.statusCode()).isEqualTo(200)
        verify(delegateHttpClient, times(2)).execute(any(), any())
        verify(workloadIdentityAuth).invalidateToken(oldToken)
        verify(response401).close()
    }

    @Test
    fun executeOnRepeated401DoesNotReplayMoreThanOnce() {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.isX509).thenReturn(true)
        val oldToken = tokenLease("old-token")
        val newToken = tokenLease("new-token")
        whenever(workloadIdentityAuth.getTokenLease()).thenReturn(oldToken, newToken)
        val delegateHttpClient = mock<HttpClient>()
        val first401 = mock<HttpResponse>()
        val second401 = mock<HttpResponse>()
        whenever(first401.statusCode()).thenReturn(401)
        whenever(second401.statusCode()).thenReturn(401)
        whenever(delegateHttpClient.execute(any(), any())).thenReturn(first401, second401)
        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)

        val result = client.execute(request(), RequestOptions.none())

        assertThat(result).isSameAs(second401)
        verify(delegateHttpClient, times(2)).execute(any(), any())
        verify(workloadIdentityAuth).invalidateToken(oldToken)
        verify(workloadIdentityAuth).invalidateToken(newToken)
    }

    @Test
    fun executeOn401DoesNotReplayNonRepeatableBody() {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.isX509).thenReturn(true)
        val token = tokenLease("test-token")
        whenever(workloadIdentityAuth.getTokenLease()).thenReturn(token)
        val delegateHttpClient = mock<HttpClient>()
        val response401 = mock<HttpResponse>()
        whenever(response401.statusCode()).thenReturn(401)
        whenever(delegateHttpClient.execute(any(), any())).thenReturn(response401)
        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)

        val result = client.execute(request(repeatable = false), RequestOptions.none())

        assertThat(result).isSameAs(response401)
        verify(delegateHttpClient).execute(any(), any())
        verify(workloadIdentityAuth).invalidateToken(token)
    }

    @Test
    fun executeAsyncOn401InvalidatesAndReplaysExactlyOnce() {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.isX509).thenReturn(true)
        val oldToken = tokenLease("old-token")
        val newToken = tokenLease("new-token")
        whenever(workloadIdentityAuth.getTokenLeaseAsync())
            .thenReturn(
                CompletableFuture.completedFuture(oldToken),
                CompletableFuture.completedFuture(newToken),
            )
        val delegateHttpClient = mock<HttpClient>()
        val response401 = mock<HttpResponse>()
        whenever(response401.statusCode()).thenReturn(401)
        whenever(delegateHttpClient.executeAsync(any(), any()))
            .thenReturn(
                CompletableFuture.completedFuture(response401),
                CompletableFuture.completedFuture(mockResponse(200, "success")),
            )
        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)

        val result = client.executeAsync(request(repeatable = true), RequestOptions.none()).get()

        assertThat(result.statusCode()).isEqualTo(200)
        verify(delegateHttpClient, times(2)).executeAsync(any(), any())
        verify(workloadIdentityAuth).invalidateToken(oldToken)
        verify(response401).close()
    }

    @Test
    fun executeAsyncOnRepeated401DoesNotReplayMoreThanOnce() {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.isX509).thenReturn(true)
        val oldToken = tokenLease("old-token")
        val newToken = tokenLease("new-token")
        whenever(workloadIdentityAuth.getTokenLeaseAsync())
            .thenReturn(
                CompletableFuture.completedFuture(oldToken),
                CompletableFuture.completedFuture(newToken),
            )
        val delegateHttpClient = mock<HttpClient>()
        val first401 = mock<HttpResponse>()
        val second401 = mock<HttpResponse>()
        whenever(first401.statusCode()).thenReturn(401)
        whenever(second401.statusCode()).thenReturn(401)
        whenever(delegateHttpClient.executeAsync(any(), any()))
            .thenReturn(
                CompletableFuture.completedFuture(first401),
                CompletableFuture.completedFuture(second401),
            )
        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)

        val result = client.executeAsync(request(), RequestOptions.none()).get()

        assertThat(result).isSameAs(second401)
        verify(delegateHttpClient, times(2)).executeAsync(any(), any())
        verify(workloadIdentityAuth).invalidateToken(oldToken)
        verify(workloadIdentityAuth).invalidateToken(newToken)
    }

    @Test
    fun executeAsyncOn401DoesNotReplayNonRepeatableBody() {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.isX509).thenReturn(true)
        val token = tokenLease("test-token")
        whenever(workloadIdentityAuth.getTokenLeaseAsync())
            .thenReturn(CompletableFuture.completedFuture(token))
        val delegateHttpClient = mock<HttpClient>()
        val response401 = mock<HttpResponse>()
        whenever(response401.statusCode()).thenReturn(401)
        whenever(delegateHttpClient.executeAsync(any(), any()))
            .thenReturn(CompletableFuture.completedFuture(response401))
        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)

        val result = client.executeAsync(request(repeatable = false), RequestOptions.none()).get()

        assertThat(result).isSameAs(response401)
        verify(delegateHttpClient).executeAsync(any(), any())
        verify(workloadIdentityAuth).invalidateToken(token)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun absentWorkloadIdentityPreservesTransparentTransport(async: Boolean) {
        val transport = mock<HttpClient>()
        val response = mockResponse(200, "legacy pass-through")
        if (async) {
            whenever(transport.executeAsync(any(), any()))
                .thenReturn(CompletableFuture.completedFuture(response))
        } else {
            whenever(transport.execute(any(), any())).thenReturn(response)
        }
        val client = WorkloadIdentityHttpClient(transport, null)
        val request = request()

        val actual =
            if (async) client.executeAsync(request, RequestOptions.none()).get()
            else client.execute(request, RequestOptions.none())

        assertThat(actual).isSameAs(response)
        if (async) verify(transport).executeAsync(request, RequestOptions.none())
        else verify(transport).execute(request, RequestOptions.none())
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun x509ReauthenticationPreservesTransientRetryBudget(async: Boolean) {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.isX509).thenReturn(true)
        val oldToken = tokenLease("old-token")
        val newToken = tokenLease("new-token")
        if (async) {
            whenever(workloadIdentityAuth.getTokenLeaseAsync())
                .thenReturn(
                    CompletableFuture.completedFuture(oldToken),
                    CompletableFuture.completedFuture(newToken),
                )
        } else {
            whenever(workloadIdentityAuth.getTokenLease()).thenReturn(oldToken, newToken)
        }
        val transport = mock<HttpClient>()
        val calls = AtomicInteger()
        val responses =
            listOf(
                mockResponse(500, "first transient error"),
                mockResponse(401, "expired bearer"),
                mockResponse(500, "second transient error"),
                mockResponse(500, "retry budget exhausted"),
                mockResponse(200, "must not be reached"),
            )
        if (async) {
            whenever(transport.executeAsync(any(), any())).thenAnswer {
                CompletableFuture.completedFuture(responses[calls.incrementAndGet() - 1])
            }
        } else {
            whenever(transport.execute(any(), any())).thenAnswer {
                responses[calls.incrementAndGet() - 1]
            }
        }
        val retryingTransport =
            RetryingHttpClient.builder()
                .httpClient(transport)
                .sleeper(NoopSleeper())
                .maxRetries(2)
                .build()
        val client = WorkloadIdentityHttpClient(retryingTransport, workloadIdentityAuth)

        val response =
            if (async) client.executeAsync(request(), RequestOptions.none()).get()
            else client.execute(request(), RequestOptions.none())

        assertThat(response.statusCode()).isEqualTo(500)
        if (async) verify(transport, times(4)).executeAsync(any(), any())
        else verify(transport, times(4)).execute(any(), any())
        verify(workloadIdentityAuth).invalidateToken(oldToken)
    }

    @Test
    fun executeAsyncInjectsBearerToken() {
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.getTokenAsync())
            .thenReturn(CompletableFuture.completedFuture("test-token"))
        val delegateHttpClient = mock<HttpClient>()
        whenever(delegateHttpClient.executeAsync(any(), any()))
            .thenReturn(CompletableFuture.completedFuture(mockResponse(200, "success")))
        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)

        val result = client.executeAsync(request(), RequestOptions.none()).get()

        assertThat(result.statusCode()).isEqualTo(200)
        verify(delegateHttpClient)
            .executeAsync(
                argThat { req ->
                    req.headers.values("Authorization").contains("Bearer test-token")
                },
                any(),
            )
    }

    private fun request(repeatable: Boolean? = null): HttpRequest =
        HttpRequest.builder()
            .method(if (repeatable == null) HttpMethod.GET else HttpMethod.POST)
            .baseUrl("https://mtls.api.openai.com/v1/models")
            .apply {
                repeatable?.let {
                    body(
                        object : HttpRequestBody {
                            override fun writeTo(outputStream: OutputStream) {}

                            override fun contentType(): String = "application/octet-stream"

                            override fun contentLength(): Long = 0

                            override fun repeatable(): Boolean = it

                            override fun close() {}
                        }
                    )
                }
            }
            .build()

    private fun tokenLease(value: String) = WorkloadIdentityAuth.TokenLease(value)

    private class NoopSleeper : Sleeper {
        override fun sleep(duration: Duration) {}

        override fun sleepAsync(duration: Duration): CompletableFuture<Void> =
            CompletableFuture.completedFuture(null)

        override fun close() {}
    }

    private fun mockResponse(statusCode: Int, body: String): HttpResponse =
        object : HttpResponse {
            override fun statusCode() = statusCode

            override fun headers() = Headers.builder().build()

            override fun body(): InputStream = ByteArrayInputStream(body.toByteArray())

            override fun close() {}
        }
}
