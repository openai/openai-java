package com.openai.core.http

import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PhantomReachableClosingHttpRequestAttemptAuthenticatorTest {

    @Test
    fun forwardsAllSyncAndAsyncAttemptTimeouts() {
        val observed = mutableListOf<HttpRequestAttemptTimeouts>()
        val delegate =
            object : HttpRequestAttemptAuthenticator {
                override fun authenticate(
                    request: HttpRequest,
                    timeout: Duration?,
                ): AuthenticatedHttpRequest = error("Duration-only boundary must not be used")

                override fun authenticate(
                    request: HttpRequest,
                    timeouts: HttpRequestAttemptTimeouts,
                ): AuthenticatedHttpRequest {
                    observed += timeouts
                    return AuthenticatedHttpRequest.create(request) {}
                }

                override fun authenticateAsync(
                    request: HttpRequest,
                    timeouts: HttpRequestAttemptTimeouts,
                ): CompletableFuture<AuthenticatedHttpRequest> =
                    CompletableFuture.completedFuture(authenticate(request, timeouts))
            }
        val wrapper = PhantomReachableClosingHttpRequestAttemptAuthenticator(delegate)
        val timeouts =
            HttpRequestAttemptTimeouts.create(
                Duration.ofMillis(11),
                Duration.ofMillis(22),
                Duration.ofMillis(33),
                Duration.ofMillis(44),
            )

        wrapper.authenticate(request(), timeouts)
        wrapper.authenticateAsync(request(), timeouts).get(5, TimeUnit.SECONDS)

        assertThat(observed).containsExactly(timeouts, timeouts)
    }
}
