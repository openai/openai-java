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
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.ErrorObject
import com.openai.models.batches.Batch
import com.openai.models.batches.BatchCancelParams
import com.openai.models.batches.BatchCreateParams
import com.openai.models.batches.BatchListPageAsync
import com.openai.models.batches.BatchListPageResponse
import com.openai.models.batches.BatchListParams
import com.openai.models.batches.BatchRetrieveParams
import java.util.concurrent.CompletableFuture

class BatchServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    BatchServiceAsync {

    private val withRawResponse: BatchServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BatchServiceAsync.WithRawResponse = withRawResponse

    override fun create(
        params: BatchCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Batch> =
        // post /batches
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: BatchRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Batch> =
        // get /batches/{batch_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: BatchListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BatchListPageAsync> =
        // get /batches
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun cancel(
        params: BatchCancelParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Batch> =
        // post /batches/{batch_id}/cancel
        withRawResponse().cancel(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BatchServiceAsync.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<Batch> =
            jsonHandler<Batch>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: BatchCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Batch>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("batches")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
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

        private val retrieveHandler: Handler<Batch> =
            jsonHandler<Batch>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: BatchRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Batch>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("batches", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
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

        private val listHandler: Handler<BatchListPageResponse> =
            jsonHandler<BatchListPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: BatchListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BatchListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("batches")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                BatchListPageAsync.builder()
                                    .service(BatchServiceAsyncImpl(clientOptions))
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val cancelHandler: Handler<Batch> =
            jsonHandler<Batch>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun cancel(
            params: BatchCancelParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Batch>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("batches", params._pathParam(0), "cancel")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
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
    }
}
