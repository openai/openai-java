// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.evals.runs

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.evals.runs.outputitems.OutputItemListPageAsync
import com.openai.models.evals.runs.outputitems.OutputItemListPageResponse
import com.openai.models.evals.runs.outputitems.OutputItemListParams
import com.openai.models.evals.runs.outputitems.OutputItemRetrieveParams
import com.openai.models.evals.runs.outputitems.OutputItemRetrieveResponse
import com.openai.core.http.CancellationTokenSource
import com.openai.core.withCancellation
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class OutputItemServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    OutputItemServiceAsync {

    private val withRawResponse: OutputItemServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): OutputItemServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OutputItemServiceAsync =
        OutputItemServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

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

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OutputItemServiceAsync.WithRawResponse =
            OutputItemServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<OutputItemRetrieveResponse> =
            jsonHandler<OutputItemRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: OutputItemRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OutputItemRetrieveResponse>> {
            val cancellationTokenSource = CancellationTokenSource()
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("outputItemId", params.outputItemId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
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
            val delegate =
                request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(
                            it,
                            requestOptions,
                            cancellationTokenSource.token()
                        ) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        return delegate.withCancellation(cancellationTokenSource)
        }

        private val listHandler: Handler<OutputItemListPageResponse> =
            jsonHandler<OutputItemListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: OutputItemListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OutputItemListPageAsync>> {
            val cancellationTokenSource = CancellationTokenSource()
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("runId", params.runId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
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
            val delegate =
                request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(
                            it,
                            requestOptions,
                            cancellationTokenSource.token()
                        ) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                OutputItemListPageAsync.builder()
                                    .service(OutputItemServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        return delegate.withCancellation(cancellationTokenSource)
        }
    }
}
