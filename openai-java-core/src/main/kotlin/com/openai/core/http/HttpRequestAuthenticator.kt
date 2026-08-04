package com.openai.core.http

import java.util.concurrent.CompletableFuture

/**
 * Authenticates a fully constructed HTTP request immediately before it is sent.
 *
 * This hook is intended for OpenAI-owned provider integrations whose authentication depends on the
 * complete request, such as AWS SigV4. It runs once per request attempt, including retries, before
 * transport logging so signed headers can be redacted consistently.
 */
interface HttpRequestAuthenticator : AutoCloseable {

    fun authenticate(request: HttpRequest): HttpRequest

    fun authenticateAsync(request: HttpRequest): CompletableFuture<HttpRequest> =
        try {
            CompletableFuture.completedFuture(authenticate(request))
        } catch (throwable: Throwable) {
            val future = CompletableFuture<HttpRequest>()
            future.completeExceptionally(throwable)
            future
        }

    override fun close() {}
}
