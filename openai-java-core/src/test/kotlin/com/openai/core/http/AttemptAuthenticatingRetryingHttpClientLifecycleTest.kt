package com.openai.core.http

import com.openai.core.RequestOptions
import com.openai.core.Timeout
import java.time.Clock
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AttemptAuthenticatingRetryingHttpClientLifecycleTest {
    @Test
    fun cancellationWinningAuthenticationToDispatchTransitionPreventsApiCall() {
        val authentication = CompletableFuture<AuthenticatedHttpRequest>()
        val authenticator =
            object : HttpRequestAttemptAuthenticator {
                override fun authenticate(
                    request: HttpRequest,
                    timeout: Duration?,
                ): AuthenticatedHttpRequest = error("sync path not expected")

                override fun authenticateAsync(
                    request: HttpRequest,
                    timeout: Duration?,
                ): CompletableFuture<AuthenticatedHttpRequest> = authentication
            }
        val transport = ScriptedClient(response(200))
        val beforeDispatch = CountDownLatch(1)
        val allowDispatch = CountDownLatch(1)
        val client =
            RetryingHttpClientOrchestrator(
                httpClient = transport,
                sleeper = ImmediateSleeper,
                clock = Clock.systemUTC(),
                maxRetries = 0,
                idempotencyHeader = null,
                attemptAuthenticator = authenticator,
                beforeAsyncApiDispatch = {
                    beforeDispatch.countDown()
                    check(allowDispatch.await(5, TimeUnit.SECONDS))
                },
            )
        val result = client.executeAsync(request())
        val executor = Executors.newSingleThreadExecutor()

        try {
            val completion =
                executor.submit {
                    authentication.complete(AuthenticatedHttpRequest.create(request()) {})
                }
            assertThat(beforeDispatch.await(5, TimeUnit.SECONDS)).isTrue()

            assertThat(result.cancel(true)).isTrue()
            allowDispatch.countDown()
            completion.get(5, TimeUnit.SECONDS)

            assertThat(transport.calls).isZero()
        } finally {
            allowDispatch.countDown()
            executor.shutdownNow()
            client.close()
        }
    }

    @Test
    fun syncAndAsyncAuthenticationReceiveRemainingRequestOptions() {
        listOf(false, true).forEach { async ->
            val authenticationTimeouts = mutableListOf<HttpRequestAttemptTimeouts>()
            val authenticator =
                object : HttpRequestAttemptAuthenticator {
                    override fun authenticate(
                        request: HttpRequest,
                        timeout: Duration?,
                    ): AuthenticatedHttpRequest = error("Duration-only boundary must not be used")

                    override fun authenticate(
                        request: HttpRequest,
                        timeouts: HttpRequestAttemptTimeouts,
                    ): AuthenticatedHttpRequest {
                        authenticationTimeouts += timeouts
                        return AuthenticatedHttpRequest.create(request) {}
                    }

                    override fun authenticateAsync(
                        request: HttpRequest,
                        timeouts: HttpRequestAttemptTimeouts,
                    ): CompletableFuture<AuthenticatedHttpRequest> =
                        CompletableFuture.completedFuture(authenticate(request, timeouts))
                }
            val transport = ScriptedClient(response(200))
            val client = client(transport, authenticator, maxRetries = 0)
            val timeout =
                Timeout.builder()
                    .connect(Duration.ofMillis(11))
                    .read(Duration.ofMillis(22))
                    .write(Duration.ofMillis(33))
                    .request(Duration.ofSeconds(5))
                    .build()
            val options = RequestOptions.builder().timeout(timeout).build()

            if (async) client.executeAsync(request(), options).get(5, TimeUnit.SECONDS).close()
            else client.execute(request(), options).close()

            val effective = authenticationTimeouts.single()
            assertThat(effective.connect()).isEqualTo(Duration.ofMillis(11))
            assertThat(effective.read()).isEqualTo(Duration.ofMillis(22))
            assertThat(effective.write()).isEqualTo(Duration.ofMillis(33))
            assertThat(effective.request())
                .isNotNull()
                .isPositive()
                .isLessThanOrEqualTo(Duration.ofSeconds(5))
            assertThat(transport.timeouts.single())
                .isPositive()
                .isLessThan(requireNotNull(effective.request()))
        }
    }
}
