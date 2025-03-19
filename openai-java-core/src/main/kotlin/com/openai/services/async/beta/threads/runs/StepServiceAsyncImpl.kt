// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.threads.runs

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
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.ErrorObject
import com.openai.models.beta.threads.runs.steps.RunStep
import com.openai.models.beta.threads.runs.steps.StepListPageAsync
import com.openai.models.beta.threads.runs.steps.StepListParams
import com.openai.models.beta.threads.runs.steps.StepRetrieveParams
import java.util.concurrent.CompletableFuture

class StepServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    StepServiceAsync {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: StepServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): StepServiceAsync.WithRawResponse = withRawResponse

    override fun retrieve(
        params: StepRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<RunStep> =
        // get /threads/{thread_id}/runs/{run_id}/steps/{step_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: StepListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<StepListPageAsync> =
        // get /threads/{thread_id}/runs/{run_id}/steps
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        StepServiceAsync.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<RunStep> =
            jsonHandler<RunStep>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: StepRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RunStep>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "threads",
                        params._pathParam(0),
                        "runs",
                        params._pathParam(1),
                        "steps",
                        params._pathParam(2),
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

        private val listHandler: Handler<StepListPageAsync.Response> =
            jsonHandler<StepListPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: StepListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StepListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "threads",
                        params._pathParam(0),
                        "runs",
                        params._pathParam(1),
                        "steps",
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
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                StepListPageAsync.of(
                                    StepServiceAsyncImpl(clientOptions),
                                    params,
                                    it,
                                )
                            }
                    }
                }
        }
    }
}
