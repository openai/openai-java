// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.evals.runs

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.ErrorObject
import com.openai.models.evals.runs.outputitems.OutputItemListPageAsync
import com.openai.models.evals.runs.outputitems.OutputItemListParams
import com.openai.models.evals.runs.outputitems.OutputItemRetrieveParams
import com.openai.models.evals.runs.outputitems.OutputItemRetrieveResponse
import java.util.concurrent.CompletableFuture

class OutputItemServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    OutputItemServiceAsync {

    private val withRawResponse: OutputItemServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): OutputItemServiceAsync.WithRawResponse = withRawResponse

    override fun retrieve(
        params: OutputItemRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<OutputItemRetrieveResponse> =
        // get /evals/{eval_id}/runs/{run_id}/output_items/{output_item_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: OutputItemListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<OutputItemListPageAsync> =
        // get /evals/{eval_id}/runs/{run_id}/output_items
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OutputItemServiceAsync.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<OutputItemRetrieveResponse> =
            jsonHandler<OutputItemRetrieveResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieve(
            params: OutputItemRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OutputItemRetrieveResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "evals",
                        params._pathParam(0),
                        "runs",
                        params._pathParam(1),
                        "output_items",
                        params._pathParam(2),
                    )
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

        private val listHandler: Handler<OutputItemListPageAsync.Response> =
            jsonHandler<OutputItemListPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: OutputItemListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OutputItemListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "evals",
                        params._pathParam(0),
                        "runs",
                        params._pathParam(1),
                        "output_items",
                    )
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
                                OutputItemListPageAsync.of(
                                    OutputItemServiceAsyncImpl(clientOptions),
                                    params,
                                    it,
                                )
                            }
                    }
                }
        }
    }
}
