package com.openai.core.http

import java.time.Duration
import java.util.concurrent.CompletableFuture

/**
 * An OpenAI-owned provider integration whose authentication shares each request attempt's timeout
 * with the transport.
 */
interface TimeoutAwareHttpRequestAuthenticator : HttpRequestAuthenticator {

    fun authenticate(request: HttpRequest, requestTimeout: Duration?): HttpRequest

    fun authenticateAsync(
        request: HttpRequest,
        requestTimeout: Duration?,
    ): CompletableFuture<HttpRequest>
}
