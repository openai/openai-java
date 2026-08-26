package com.openai.core.http

import java.time.Duration
import java.util.concurrent.CompletableFuture

/** Remaining transport timeouts for one authentication attempt. */
class HttpRequestAttemptTimeouts
private constructor(
    private val connect: Duration?,
    private val read: Duration?,
    private val write: Duration?,
    private val request: Duration?,
) {
    @JvmSynthetic fun connect(): Duration? = connect

    @JvmSynthetic fun read(): Duration? = read

    @JvmSynthetic fun write(): Duration? = write

    @JvmSynthetic fun request(): Duration? = request

    companion object {
        @JvmSynthetic
        fun create(
            connect: Duration?,
            read: Duration?,
            write: Duration?,
            request: Duration?,
        ): HttpRequestAttemptTimeouts = HttpRequestAttemptTimeouts(connect, read, write, request)
    }
}

/**
 * Reserved authentication seam for integrations that must react to the exact request rejected by
 * the server without starting a second retry lifecycle.
 */
interface HttpRequestAttemptAuthenticator : AutoCloseable {

    @JvmSynthetic
    fun authenticate(request: HttpRequest, timeout: Duration?): AuthenticatedHttpRequest

    /** Authenticates one attempt using the orchestrator's remaining transport timeouts. */
    @JvmSynthetic
    fun authenticate(
        request: HttpRequest,
        timeouts: HttpRequestAttemptTimeouts,
    ): AuthenticatedHttpRequest = authenticate(request, timeouts.request())

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

    /** Authenticates one async attempt using the orchestrator's remaining transport timeouts. */
    @JvmSynthetic
    fun authenticateAsync(
        request: HttpRequest,
        timeouts: HttpRequestAttemptTimeouts,
    ): CompletableFuture<AuthenticatedHttpRequest> = authenticateAsync(request, timeouts.request())

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
