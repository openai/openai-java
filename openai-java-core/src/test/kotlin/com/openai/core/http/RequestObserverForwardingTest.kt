package com.openai.core.http

import com.openai.auth.WorkloadIdentityAuth
import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import com.openai.errors.OpenAIRetryableException
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class RequestObserverForwardingTest {

    private val request =
        HttpRequest.builder()
            .method(HttpMethod.GET)
            .baseUrl("https://example.com")
            .addPathSegment("user name")
            .build()
    private val requestOptions = RequestOptions.none()

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun authenticationAndLifecycleWrappersForwardObservationForEachRetry(async: Boolean) {
        val transport = RecordingTransport(503, 200)
        val authenticatedRequests = mutableListOf<HttpRequest>()
        val authenticator =
            object : HttpRequestAuthenticator {
                override fun authenticate(request: HttpRequest): HttpRequest {
                    authenticatedRequests.add(request)
                    return request.toBuilder().putHeader("X-Test-Authenticated", "true").build()
                }

                override fun authenticateAsync(
                    request: HttpRequest
                ): CompletableFuture<HttpRequest> =
                    CompletableFuture.completedFuture(authenticate(request))

                override fun close() {}
            }
        val client =
            retrying(
                AuthenticatingHttpClient(
                    WorkloadIdentityHttpClient(
                        PhantomReachableClosingHttpClient(transport),
                        workloadIdentityAuth = null,
                    ),
                    authenticator,
                )
            )
        val reportedUrls = mutableListOf<String?>()
        val observer = RequestObserver { method, url ->
            assertThat(method).isEqualTo(HttpMethod.GET)
            assertThat(transport.requests.last().headers.values("X-Test-Authenticated"))
                .containsExactly("true")
            reportedUrls.add(url)
        }

        execute(client, observer, async).use { assertThat(it.statusCode()).isEqualTo(200) }

        assertThat(authenticatedRequests).hasSize(2)
        assertForwarding(transport, observer, reportedUrls)
        assertThat(transport.requests.map { it.headers.values("X-Stainless-Retry-Count").single() })
            .containsExactly("0", "1")
        verify(transport.responses.first()).close()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun workloadIdentityRefreshPreservesObservationAndClosesRejectedResponse(async: Boolean) {
        val transport = RecordingTransport(401, 200)
        val auth = mock<WorkloadIdentityAuth>()
        if (async) {
            whenever(auth.getTokenAsync())
                .thenReturn(
                    CompletableFuture.completedFuture("fake-first-token"),
                    CompletableFuture.completedFuture("fake-refreshed-token"),
                )
        } else {
            whenever(auth.getToken()).thenReturn("fake-first-token", "fake-refreshed-token")
        }
        val client = WorkloadIdentityHttpClient(transport, auth)
        val reportedUrls = mutableListOf<String?>()
        val observer = RequestObserver { _, url -> reportedUrls.add(url) }

        val failure = runCatching { execute(client, observer, async) }.exceptionOrNull()
        if (async) {
            assertThat(failure)
                .isInstanceOf(CompletionException::class.java)
                .hasCauseInstanceOf(OpenAIRetryableException::class.java)
        } else {
            assertThat(failure).isInstanceOf(OpenAIRetryableException::class.java)
        }
        assertThat(reportedUrls).containsExactly("https://example.com/user%20name")
        verify(auth).invalidateToken()
        verify(transport.responses.first()).close()

        execute(client, observer, async).use { assertThat(it.statusCode()).isEqualTo(200) }

        assertForwarding(transport, observer, reportedUrls)
        assertThat(transport.requests.map { it.headers.values("Authorization").single() })
            .containsExactly("Bearer fake-first-token", "Bearer fake-refreshed-token")
    }

    private fun assertForwarding(
        transport: RecordingTransport,
        observer: RequestObserver,
        reportedUrls: List<String?>,
    ) {
        assertThat(transport.observers).hasSize(2).allSatisfy { assertThat(it).isSameAs(observer) }
        assertThat(transport.options).hasSize(2).allSatisfy {
            assertThat(it).isSameAs(requestOptions)
        }
        assertThat(reportedUrls)
            .containsExactly("https://example.com/user%20name", "https://example.com/user%20name")
    }

    private fun execute(
        client: HttpClient,
        observer: RequestObserver,
        async: Boolean,
    ): HttpResponse =
        if (async) client.executeAsync(request, requestOptions, observer).join()
        else client.execute(request, requestOptions, observer)

    private fun retrying(delegate: HttpClient): HttpClient =
        RetryingHttpClient.builder()
            .httpClient(delegate)
            .maxRetries(1)
            .sleeper(
                object : Sleeper {
                    override fun sleep(duration: Duration) {}

                    override fun sleepAsync(duration: Duration): CompletableFuture<Void> =
                        CompletableFuture.completedFuture(null)

                    override fun close() {}
                }
            )
            .build()

    private class RecordingTransport(vararg statuses: Int) : HttpClient {
        val requests = mutableListOf<HttpRequest>()
        val options = mutableListOf<RequestOptions>()
        val observers = mutableListOf<RequestObserver>()
        val responses =
            statuses.map { status ->
                mock<HttpResponse>().also {
                    whenever(it.statusCode()).thenReturn(status)
                    whenever(it.headers()).thenReturn(Headers.builder().build())
                }
            }

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
            error("The wrapper discarded the observer")

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> = error("The wrapper discarded the observer")

        override fun execute(
            request: HttpRequest,
            requestOptions: RequestOptions,
            observer: RequestObserver,
        ): HttpResponse {
            requests.add(request)
            options.add(requestOptions)
            observers.add(observer)
            observer.onRequestStart(request.method, "https://example.com/user%20name")
            return responses[requests.lastIndex]
        }

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
            observer: RequestObserver,
        ): CompletableFuture<HttpResponse> =
            CompletableFuture.completedFuture(execute(request, requestOptions, observer))

        override fun close() {}
    }
}
