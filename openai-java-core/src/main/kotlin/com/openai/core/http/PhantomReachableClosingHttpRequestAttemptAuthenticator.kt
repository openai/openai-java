package com.openai.core.http

import com.openai.core.closeWhenPhantomReachable
import java.time.Duration
import java.util.concurrent.CompletableFuture

/** Closes a delegated attempt authenticator after this wrapper becomes phantom reachable. */
internal class PhantomReachableClosingHttpRequestAttemptAuthenticator(
    private val authenticator: HttpRequestAttemptAuthenticator
) : HttpRequestAttemptAuthenticator {
    init {
        closeWhenPhantomReachable(this, authenticator)
    }

    override fun authenticate(request: HttpRequest, timeout: Duration?): AuthenticatedHttpRequest =
        authenticator.authenticate(request, timeout)

    override fun authenticate(
        request: HttpRequest,
        timeouts: HttpRequestAttemptTimeouts,
    ): AuthenticatedHttpRequest = authenticator.authenticate(request, timeouts)

    override fun authenticateAsync(
        request: HttpRequest,
        timeout: Duration?,
    ): CompletableFuture<AuthenticatedHttpRequest> =
        authenticator.authenticateAsync(request, timeout)

    override fun authenticateAsync(
        request: HttpRequest,
        timeouts: HttpRequestAttemptTimeouts,
    ): CompletableFuture<AuthenticatedHttpRequest> =
        authenticator.authenticateAsync(request, timeouts)

    override fun close() = authenticator.close()
}
