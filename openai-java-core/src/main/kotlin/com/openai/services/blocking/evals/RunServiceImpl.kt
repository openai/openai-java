// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.evals

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
import com.openai.core.prepare
import com.openai.models.ErrorObject
import com.openai.models.evals.runs.RunCancelParams
import com.openai.models.evals.runs.RunCancelResponse
import com.openai.models.evals.runs.RunCreateParams
import com.openai.models.evals.runs.RunCreateResponse
import com.openai.models.evals.runs.RunDeleteParams
import com.openai.models.evals.runs.RunDeleteResponse
import com.openai.models.evals.runs.RunListPage
import com.openai.models.evals.runs.RunListParams
import com.openai.models.evals.runs.RunRetrieveParams
import com.openai.models.evals.runs.RunRetrieveResponse
import com.openai.services.blocking.evals.runs.OutputItemService
import com.openai.services.blocking.evals.runs.OutputItemServiceImpl

class RunServiceImpl internal constructor(private val clientOptions: ClientOptions) : RunService {

    private val withRawResponse: RunService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val outputItems: OutputItemService by lazy { OutputItemServiceImpl(clientOptions) }

    override fun withRawResponse(): RunService.WithRawResponse = withRawResponse

    override fun outputItems(): OutputItemService = outputItems

    override fun create(
        params: RunCreateParams,
        requestOptions: RequestOptions,
    ): RunCreateResponse =
        // post /evals/{eval_id}/runs
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: RunRetrieveParams,
        requestOptions: RequestOptions,
    ): RunRetrieveResponse =
        // get /evals/{eval_id}/runs/{run_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: RunListParams, requestOptions: RequestOptions): RunListPage =
        // get /evals/{eval_id}/runs
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: RunDeleteParams,
        requestOptions: RequestOptions,
    ): RunDeleteResponse =
        // delete /evals/{eval_id}/runs/{run_id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun cancel(
        params: RunCancelParams,
        requestOptions: RequestOptions,
    ): RunCancelResponse =
        // post /evals/{eval_id}/runs/{run_id}
        withRawResponse().cancel(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RunService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val outputItems: OutputItemService.WithRawResponse by lazy {
            OutputItemServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun outputItems(): OutputItemService.WithRawResponse = outputItems

        private val createHandler: Handler<RunCreateResponse> =
            jsonHandler<RunCreateResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: RunCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RunCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("evals", params._pathParam(0), "runs")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
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
        ): HttpResponseFor<RunRetrieveResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("evals", params._pathParam(0), "runs", params._pathParam(1))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<RunListPage.Response> =
            jsonHandler<RunListPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: RunListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RunListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("evals", params._pathParam(0), "runs")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let { RunListPage.of(RunServiceImpl(clientOptions), params, it) }
            }
        }

        private val deleteHandler: Handler<RunDeleteResponse> =
            jsonHandler<RunDeleteResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun delete(
            params: RunDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RunDeleteResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("evals", params._pathParam(0), "runs", params._pathParam(1))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val cancelHandler: Handler<RunCancelResponse> =
            jsonHandler<RunCancelResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun cancel(
            params: RunCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RunCancelResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("evals", params._pathParam(0), "runs", params._pathParam(1))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
