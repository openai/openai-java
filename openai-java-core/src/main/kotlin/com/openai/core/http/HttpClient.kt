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

    /** Overridden from [AutoCloseable] to not have a checked exception in its signature. */
    override fun close()
}
