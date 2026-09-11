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

    /**
     * Executes a request while observing its prepared method and URL.
     *
     * Transports should override this method to report their prepared request before dispatch.
     * Wrappers should forward [observer] to their delegate. The default reports an unavailable URL
     * before calling the original overload, allowing existing implementations to keep working.
     */
    fun execute(
        request: HttpRequest,
        requestOptions: RequestOptions,
        observer: RequestObserver,
    ): HttpResponse {
        try {
            observer.onRequestStart(request.method, null)
        } catch (_: RuntimeException) {
            // Observation must not prevent dispatch.
        }
        return execute(request, requestOptions)
    }

    fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>

    fun executeAsync(request: HttpRequest): CompletableFuture<HttpResponse> =
        executeAsync(request, RequestOptions.none())

    /** Asynchronous counterpart of [execute] with a per-invocation [observer]. */
    fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
        observer: RequestObserver,
    ): CompletableFuture<HttpResponse> {
        try {
            observer.onRequestStart(request.method, null)
        } catch (_: RuntimeException) {
            // Observation must not prevent dispatch.
        }
        return executeAsync(request, requestOptions)
    }

    /** Overridden from [AutoCloseable] to not have a checked exception in its signature. */
    override fun close()
}
