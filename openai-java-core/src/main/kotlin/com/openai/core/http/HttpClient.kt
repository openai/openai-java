package com.openai.core.http

import com.openai.core.RequestOptions
import java.lang.AutoCloseable
import java.util.concurrent.CompletableFuture

interface HttpClient : AutoCloseable {

    fun execute(
        request: HttpRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse

    fun execute(request: HttpRequest): HttpResponse = execute(request, RequestOptions.none())

    fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>

    fun executeAsync(request: HttpRequest): CompletableFuture<HttpResponse> =
        executeAsync(request, RequestOptions.none())

    /**
     * Executes an HTTP request asynchronously with cancellation support.
     *
     * @param request the HTTP request to execute
     * @param requestOptions options for this request
     * @param cancellationToken token that can be used to cancel the operation
     * @return a CompletableFuture that completes with the HTTP response
     */
    fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
        cancellationToken: CancellationToken = CancellationToken.none(),
    ): CompletableFuture<HttpResponse> {
        // Default implementation delegates to non-cancellable version for backward compatibility
        // Implementations should override this to provide proper cancellation support
        return executeAsync(request, requestOptions)
    }

    /** Overridden from [AutoCloseable] to not have a checked exception in its signature. */
    override fun close()
}
