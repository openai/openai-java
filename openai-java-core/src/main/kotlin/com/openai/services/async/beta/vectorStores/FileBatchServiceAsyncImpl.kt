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
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.errors.OpenAIError
import com.openai.models.BetaVectorStoreFileBatchCancelParams
import com.openai.models.BetaVectorStoreFileBatchCreateParams
import com.openai.models.BetaVectorStoreFileBatchListFilesPageAsync
import com.openai.models.BetaVectorStoreFileBatchListFilesParams
import com.openai.models.BetaVectorStoreFileBatchRetrieveParams
import com.openai.models.VectorStoreFileBatch
import java.util.concurrent.CompletableFuture

class FileBatchServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    FileBatchServiceAsync {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: FileBatchServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FileBatchServiceAsync.WithRawResponse = withRawResponse

    override fun create(
        params: BetaVectorStoreFileBatchCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VectorStoreFileBatch> =
        // post /vector_stores/{vector_store_id}/file_batches
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: BetaVectorStoreFileBatchRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VectorStoreFileBatch> =
        // get /vector_stores/{vector_store_id}/file_batches/{batch_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun cancel(
        params: BetaVectorStoreFileBatchCancelParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VectorStoreFileBatch> =
        // post /vector_stores/{vector_store_id}/file_batches/{batch_id}/cancel
        withRawResponse().cancel(params, requestOptions).thenApply { it.parse() }

    override fun listFiles(
        params: BetaVectorStoreFileBatchListFilesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BetaVectorStoreFileBatchListFilesPageAsync> =
        // get /vector_stores/{vector_store_id}/file_batches/{batch_id}/files
        withRawResponse().listFiles(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FileBatchServiceAsync.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<VectorStoreFileBatch> =
            jsonHandler<VectorStoreFileBatch>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun create(
            params: BetaVectorStoreFileBatchCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VectorStoreFileBatch>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("vector_stores", params.getPathParam(0), "file_batches")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveHandler: Handler<VectorStoreFileBatch> =
            jsonHandler<VectorStoreFileBatch>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieve(
            params: BetaVectorStoreFileBatchRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VectorStoreFileBatch>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "vector_stores",
                        params.getPathParam(0),
                        "file_batches",
                        params.getPathParam(1),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val cancelHandler: Handler<VectorStoreFileBatch> =
            jsonHandler<VectorStoreFileBatch>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun cancel(
            params: BetaVectorStoreFileBatchCancelParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VectorStoreFileBatch>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "vector_stores",
                        params.getPathParam(0),
                        "file_batches",
                        params.getPathParam(1),
                        "cancel",
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { cancelHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listFilesHandler: Handler<BetaVectorStoreFileBatchListFilesPageAsync.Response> =
            jsonHandler<BetaVectorStoreFileBatchListFilesPageAsync.Response>(
                    clientOptions.jsonMapper
                )
                .withErrorHandler(errorHandler)

        override fun listFiles(
            params: BetaVectorStoreFileBatchListFilesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BetaVectorStoreFileBatchListFilesPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "vector_stores",
                        params.getPathParam(0),
                        "file_batches",
                        params.getPathParam(1),
                        "files",
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listFilesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                BetaVectorStoreFileBatchListFilesPageAsync.of(
                                    FileBatchServiceAsyncImpl(clientOptions),
                                    params,
                                    it,
                                )
                            }
                    }
                }
        }
    }
}
