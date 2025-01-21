// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.vectorStores

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.json
import com.openai.errors.OpenAIError
import com.openai.models.BetaVectorStoreFileBatchCancelParams
import com.openai.models.BetaVectorStoreFileBatchCreateParams
import com.openai.models.BetaVectorStoreFileBatchListFilesPageAsync
import com.openai.models.BetaVectorStoreFileBatchListFilesParams
import com.openai.models.BetaVectorStoreFileBatchRetrieveParams
import com.openai.models.VectorStoreFileBatch
import java.util.concurrent.CompletableFuture

class FileBatchServiceAsyncImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : FileBatchServiceAsync {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<VectorStoreFileBatch> =
        jsonHandler<VectorStoreFileBatch>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create a vector store file batch. */
    override fun create(
        params: BetaVectorStoreFileBatchCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<VectorStoreFileBatch> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("vector_stores", params.getPathParam(0), "file_batches")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
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

    private val retrieveHandler: Handler<VectorStoreFileBatch> =
        jsonHandler<VectorStoreFileBatch>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieves a vector store file batch. */
    override fun retrieve(
        params: BetaVectorStoreFileBatchRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<VectorStoreFileBatch> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments(
                    "vector_stores",
                    params.getPathParam(0),
                    "file_batches",
                    params.getPathParam(1)
                )
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
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

    private val cancelHandler: Handler<VectorStoreFileBatch> =
        jsonHandler<VectorStoreFileBatch>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Cancel a vector store file batch. This attempts to cancel the processing of files in this
     * batch as soon as possible.
     */
    override fun cancel(
        params: BetaVectorStoreFileBatchCancelParams,
        requestOptions: RequestOptions
    ): CompletableFuture<VectorStoreFileBatch> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments(
                    "vector_stores",
                    params.getPathParam(0),
                    "file_batches",
                    params.getPathParam(1),
                    "cancel"
                )
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
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

    private val listFilesHandler: Handler<BetaVectorStoreFileBatchListFilesPageAsync.Response> =
        jsonHandler<BetaVectorStoreFileBatchListFilesPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of vector store files in a batch. */
    override fun listFiles(
        params: BetaVectorStoreFileBatchListFilesParams,
        requestOptions: RequestOptions
    ): CompletableFuture<BetaVectorStoreFileBatchListFilesPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments(
                    "vector_stores",
                    params.getPathParam(0),
                    "file_batches",
                    params.getPathParam(1),
                    "files"
                )
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { listFilesHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { BetaVectorStoreFileBatchListFilesPageAsync.of(this, params, it) }
        }
    }
}
