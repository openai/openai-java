package com.openai.core.http

import java.time.Duration
import java.util.concurrent.CompletableFuture

/**
 * Reserved authentication seam for integrations that must react to the exact request rejected by
 * the server without starting a second retry lifecycle.
 */
interface HttpRequestAttemptAuthenticator : AutoCloseable {

    @JvmSynthetic
    fun authenticate(request: HttpRequest, timeout: Duration?): AuthenticatedHttpRequest

    @JvmSynthetic
    fun authenticateAsync(
        request: HttpRequest,
        timeout: Duration?,
    ): CompletableFuture<AuthenticatedHttpRequest> =
        try {
            CompletableFuture.completedFuture(authenticate(request, timeout))
        } catch (throwable: Throwable) {
            CompletableFuture<AuthenticatedHttpRequest>().also {
                it.completeExceptionally(throwable)
            }
        }

    override fun close() {}
}

/** One authenticated wire request and the exact credential generation that produced it. */
class AuthenticatedHttpRequest
private constructor(private val request: HttpRequest, private val onUnauthorized: () -> Unit) {

    @JvmSynthetic fun request(): HttpRequest = request

    @JvmSynthetic fun onUnauthorized() = onUnauthorized.invoke()

    companion object {
        @JvmSynthetic
        fun create(request: HttpRequest, onUnauthorized: () -> Unit): AuthenticatedHttpRequest =
            AuthenticatedHttpRequest(request, onUnauthorized)
    }
}
