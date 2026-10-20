package com.openai.auth

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import java.io.ByteArrayInputStream
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit.SECONDS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoInteractions
import org.mockito.kotlin.whenever

@Timeout(15)
internal class WorkloadIdentityAuthSynchronousProviderFailureTest {

    @Test
    fun getTokenAsync_clearsForegroundRefreshAfterSynchronousProviderFailure() {
        val failure = IllegalStateException("provider failed")
        val provider = mock<SubjectTokenProvider>()
        whenever(provider.getTokenAsync(any(), any())).thenThrow(failure)
        val httpClient = mock<HttpClient>()
        val auth = createAuth(provider, httpClient)

        assertFailure(auth.getTokenAsync(), failure)
        assertFailure(auth.getTokenAsync(), failure)

        verify(provider, times(2)).getTokenAsync(any(), any())
        verifyNoInteractions(httpClient)
    }

    @Test
    fun getTokenAsync_keepsCachedTokenAndAllowsAnotherBackgroundRefreshAfterSynchronousFailure() {
        val provider = mock<SubjectTokenProvider>()
        whenever(provider.tokenType()).thenReturn(SubjectTokenType.JWT)
        whenever(provider.getToken(any(), any())).thenReturn("subject-token")
        whenever(provider.getTokenAsync(any(), any()))
            .thenThrow(IllegalStateException("provider failed"))
        val httpClient = mock<HttpClient>()
        val cachedResponse = mockTokenResponse("cached-token", expiresIn = 600)
        whenever(httpClient.execute(any<HttpRequest>())).thenReturn(cachedResponse)
        val auth = createAuth(provider, httpClient)

        assertThat(auth.getToken()).isEqualTo("cached-token")
        assertThat(auth.getTokenAsync().get(5, SECONDS)).isEqualTo("cached-token")
        assertThat(auth.getTokenAsync().get(5, SECONDS)).isEqualTo("cached-token")

        verify(provider, times(2)).getTokenAsync(any(), any())
        verify(httpClient, times(1)).execute(any<HttpRequest>())
    }

    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun getTokenAsync_recoversAfterProviderFailure(synchronousFailure: Boolean) {
        val failure = IllegalStateException("provider failed")
        val provider = mock<SubjectTokenProvider>()
        whenever(provider.tokenType()).thenReturn(SubjectTokenType.JWT)
        whenever(provider.getTokenAsync(any(), any()))
            .thenAnswer {
                if (synchronousFailure) throw failure
                CompletableFuture<String>().also { it.completeExceptionally(failure) }
            }
            .thenReturn(CompletableFuture.completedFuture("subject-token"))
        val httpClient = mock<HttpClient>()
        val recoveredResponse = mockTokenResponse("recovered-token")
        whenever(httpClient.executeAsync(any<HttpRequest>()))
            .thenReturn(CompletableFuture.completedFuture(recoveredResponse))
        val auth = createAuth(provider, httpClient)

        assertFailure(auth.getTokenAsync(), failure)
        assertThat(auth.getTokenAsync().get(5, SECONDS)).isEqualTo("recovered-token")
        assertThat(auth.getTokenAsync().get(5, SECONDS)).isEqualTo("recovered-token")

        verify(provider, times(2)).getTokenAsync(any(), any())
        verify(httpClient, times(1)).executeAsync(any<HttpRequest>())
    }

    @Test
    fun getTokenAsync_recoversBackgroundRefreshWithoutDiscardingCachedToken() {
        val provider = mock<SubjectTokenProvider>()
        whenever(provider.tokenType()).thenReturn(SubjectTokenType.JWT)
        whenever(provider.getToken(any(), any())).thenReturn("subject-token")
        whenever(provider.getTokenAsync(any(), any()))
            .thenThrow(IllegalStateException("provider failed"))
            .thenReturn(CompletableFuture.completedFuture("subject-token"))
        val httpClient = mock<HttpClient>()
        val cachedResponse = mockTokenResponse("cached-token", expiresIn = 600)
        whenever(httpClient.execute(any<HttpRequest>())).thenReturn(cachedResponse)
        val exchange = CompletableFuture<HttpResponse>()
        whenever(httpClient.executeAsync(any<HttpRequest>())).thenReturn(exchange)
        val auth = createAuth(provider, httpClient)

        assertThat(auth.getToken()).isEqualTo("cached-token")
        // A failed refresh leaves the valid token available.
        assertThat(auth.getTokenAsync().get(5, SECONDS)).isEqualTo("cached-token")
        // The next call starts recovery; concurrent requests keep using the cached token.
        assertThat(auth.getTokenAsync().get(5, SECONDS)).isEqualTo("cached-token")
        assertThat(auth.getTokenAsync().get(5, SECONDS)).isEqualTo("cached-token")

        exchange.complete(mockTokenResponse("recovered-token"))
        assertThat(auth.getTokenAsync().get(5, SECONDS)).isEqualTo("recovered-token")

        verify(provider, times(2)).getTokenAsync(any(), any())
        verify(httpClient, times(1)).executeAsync(any<HttpRequest>())
    }

    @Test
    fun getTokenAsync_settlesConcurrentWaitersAfterSynchronousProviderFailure() {
        val failure = IllegalStateException("provider failed")
        val providerStarted = CountDownLatch(1)
        val releaseProvider = CountDownLatch(1)
        val provider = mock<SubjectTokenProvider>()
        whenever(provider.tokenType()).thenReturn(SubjectTokenType.JWT)
        whenever(provider.getTokenAsync(any(), any()))
            .thenAnswer {
                providerStarted.countDown()
                check(releaseProvider.await(5, SECONDS)) { "Provider was not released" }
                throw failure
            }
            .thenReturn(CompletableFuture.completedFuture("subject-token"))
        val httpClient = mock<HttpClient>()
        val recoveredResponse = mockTokenResponse("recovered-token")
        whenever(httpClient.executeAsync(any<HttpRequest>()))
            .thenReturn(CompletableFuture.completedFuture(recoveredResponse))
        val auth = createAuth(provider, httpClient)
        val executor = Executors.newSingleThreadExecutor()

        try {
            val initiatingCall = executor.submit<CompletableFuture<String>> { auth.getTokenAsync() }
            assertThat(providerStarted.await(5, SECONDS)).isTrue()
            val waiters = List(3) { auth.getTokenAsync() }
            waiters.forEach { assertThat(it).isNotDone() }
            verify(provider, times(1)).getTokenAsync(any(), any())

            releaseProvider.countDown()
            assertFailure(initiatingCall.get(5, SECONDS), failure)
            waiters.forEach { assertFailure(it, failure) }

            assertThat(auth.getTokenAsync().get(5, SECONDS)).isEqualTo("recovered-token")
            verify(provider, times(2)).getTokenAsync(any(), any())
            verify(httpClient, times(1)).executeAsync(any<HttpRequest>())
        } finally {
            releaseProvider.countDown()
            executor.shutdownNow()
            assertThat(executor.awaitTermination(5, SECONDS)).isTrue()
        }
    }

    private fun assertFailure(future: CompletableFuture<String>, failure: Throwable) {
        val thrown = assertThrows<ExecutionException> { future.get(5, SECONDS) }
        assertThat(thrown.cause).isSameAs(failure)
    }

    private fun createAuth(
        provider: SubjectTokenProvider,
        httpClient: HttpClient,
    ): WorkloadIdentityAuth =
        WorkloadIdentityAuth(
            config =
                WorkloadIdentity.builder()
                    .clientId("client-id")
                    .identityProviderId("provider-id")
                    .serviceAccountId("service-account-id")
                    .provider(provider)
                    .refreshBufferSeconds(1200)
                    .build(),
            httpClient = httpClient,
            jsonMapper = JsonMapper(),
        )

    private fun mockTokenResponse(token: String, expiresIn: Int = 3600): HttpResponse {
        val body =
            """
            {
                "access_token": "$token",
                "issued_token_type": "urn:ietf:params:oauth:token-type:access_token",
                "token_type": "Bearer",
                "expires_in": $expiresIn
            }
            """
                .trimIndent()
        val response = mock<HttpResponse>()
        whenever(response.statusCode()).thenReturn(200)
        whenever(response.body()).thenAnswer { ByteArrayInputStream(body.toByteArray()) }
        return response
    }
}
