// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.evals

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
import com.openai.models.evals.runs.RunCancelParams
import com.openai.models.evals.runs.RunCancelResponse
import com.openai.models.evals.runs.RunCreateParams
import com.openai.models.evals.runs.RunCreateResponse
import com.openai.models.evals.runs.RunDeleteParams
import com.openai.models.evals.runs.RunDeleteResponse
import com.openai.models.evals.runs.RunListPageAsync
import com.openai.models.evals.runs.RunListParams
import com.openai.models.evals.runs.RunRetrieveParams
import com.openai.models.evals.runs.RunRetrieveResponse
import com.openai.services.async.evals.runs.OutputItemServiceAsync
import com.openai.services.async.evals.runs.OutputItemServiceAsyncImpl
import java.util.concurrent.CompletableFuture

class RunServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    RunServiceAsync {

    private val withRawResponse: RunServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val outputItems: OutputItemServiceAsync by lazy {
        OutputItemServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): RunServiceAsync.WithRawResponse = withRawResponse

    override fun outputItems(): OutputItemServiceAsync = outputItems

    override fun create(
        params: RunCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<RunCreateResponse> =
        // post /evals/{eval_id}/runs
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: RunRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<RunRetrieveResponse> =
        // get /evals/{eval_id}/runs/{run_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: RunListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<RunListPageAsync> =
        // get /evals/{eval_id}/runs
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: RunDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<RunDeleteResponse> =
        // delete /evals/{eval_id}/runs/{run_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun cancel(
        params: RunCancelParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<RunCancelResponse> =
        // post /evals/{eval_id}/runs/{run_id}
        withRawResponse().cancel(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RunServiceAsync.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val outputItems: OutputItemServiceAsync.WithRawResponse by lazy {
            OutputItemServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun outputItems(): OutputItemServiceAsync.WithRawResponse = outputItems

        private val createHandler: Handler<RunCreateResponse> =
            jsonHandler<RunCreateResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: RunCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RunCreateResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("evals", params._pathParam(0), "runs")
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

        private val retrieveHandler: Handler<RunRetrieveResponse> =
            jsonHandler<RunRetrieveResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieve(
            params: RunRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RunRetrieveResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("evals", params._pathParam(0), "runs", params._pathParam(1))
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

        private val listHandler: Handler<RunListPageAsync.Response> =
            jsonHandler<RunListPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: RunListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RunListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("evals", params._pathParam(0), "runs")
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
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
                                RunListPageAsync.of(RunServiceAsyncImpl(clientOptions), params, it)
                            }
                    }
                }
        }

        private val deleteHandler: Handler<RunDeleteResponse> =
            jsonHandler<RunDeleteResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun delete(
            params: RunDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RunDeleteResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("evals", params._pathParam(0), "runs", params._pathParam(1))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { deleteHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val cancelHandler: Handler<RunCancelResponse> =
            jsonHandler<RunCancelResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun cancel(
            params: RunCancelParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RunCancelResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("evals", params._pathParam(0), "runs", params._pathParam(1))
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
    }
}
