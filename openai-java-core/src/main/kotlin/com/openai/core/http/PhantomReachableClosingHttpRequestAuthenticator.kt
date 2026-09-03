package com.openai.core.http

import com.openai.core.closeWhenPhantomReachable
import java.util.concurrent.CompletableFuture

/**
 * A delegating wrapper around an authenticator that closes it once it's only phantom reachable.
 *
 * This lets provider integrations release owned resources even if the user forgets to close the
 * client.
 */
internal class PhantomReachableClosingHttpRequestAuthenticator(
    private val authenticator: HttpRequestAuthenticator
) : HttpRequestAuthenticator {
    init {
        closeWhenPhantomReachable(this, authenticator)
    }

    override fun authenticate(request: HttpRequest): HttpRequest =
        authenticator.authenticate(request)

    override fun authenticateAsync(request: HttpRequest): CompletableFuture<HttpRequest> =
        authenticator.authenticateAsync(request)

    override fun close() = authenticator.close()
}
