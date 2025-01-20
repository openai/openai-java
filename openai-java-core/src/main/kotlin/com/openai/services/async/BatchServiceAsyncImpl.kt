// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.json
import com.openai.errors.OpenAIError
import com.openai.models.Batch
import com.openai.models.BatchCancelParams
import com.openai.models.BatchCreateParams
import com.openai.models.BatchListPageAsync
import com.openai.models.BatchListParams
import com.openai.models.BatchRetrieveParams
import java.util.concurrent.CompletableFuture

class BatchServiceAsyncImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : BatchServiceAsync {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<Batch> =
        jsonHandler<Batch>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates and executes a batch from an uploaded file of requests */
    override fun create(
        params: BatchCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Batch> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("batches")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val retrieveHandler: Handler<Batch> =
        jsonHandler<Batch>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieves a batch. */
    override fun retrieve(
        params: BatchRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Batch> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("batches", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<BatchListPageAsync.Response> =
        jsonHandler<BatchListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List your organization's batches. */
    override fun list(
        params: BatchListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<BatchListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("batches")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { BatchListPageAsync.of(this, params, it) }
        }
    }

    private val cancelHandler: Handler<Batch> =
        jsonHandler<Batch>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Cancels an in-progress batch. The batch will be in status `cancelling` for up to 10 minutes,
     * before changing to `cancelled`, where it will have partial results (if any) available in the
     * output file.
     */
    override fun cancel(
        params: BatchCancelParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Batch> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("batches", params.getPathParam(0), "cancel")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(params.getHeaders())
                .apply { params.getBody().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { cancelHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
