// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.evals

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
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.evals.runs.RunCancelParams
import com.openai.models.evals.runs.RunCancelResponse
import com.openai.models.evals.runs.RunCreateParams
import com.openai.models.evals.runs.RunCreateResponse
import com.openai.models.evals.runs.RunDeleteParams
import com.openai.models.evals.runs.RunDeleteResponse
import com.openai.models.evals.runs.RunListPage
import com.openai.models.evals.runs.RunListPageResponse
import com.openai.models.evals.runs.RunListParams
import com.openai.models.evals.runs.RunRetrieveParams
import com.openai.models.evals.runs.RunRetrieveResponse
import com.openai.services.blocking.evals.runs.OutputItemService
import com.openai.services.blocking.evals.runs.OutputItemServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class RunServiceImpl internal constructor(private val clientOptions: ClientOptions) : RunService {

    private val withRawResponse: RunService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val outputItems: OutputItemService by lazy { OutputItemServiceImpl(clientOptions) }

    override fun withRawResponse(): RunService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RunService =
        RunServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

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

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val outputItems: OutputItemService.WithRawResponse by lazy {
            OutputItemServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RunService.WithRawResponse =
            RunServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun outputItems(): OutputItemService.WithRawResponse = outputItems

        private val createHandler: Handler<RunCreateResponse> =
            jsonHandler<RunCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: RunCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RunCreateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("evalId", params.evalId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("evals", params._pathParam(0), "runs")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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

        override fun retrieve(
            params: RunRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RunRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("runId", params.runId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("evals", params._pathParam(0), "runs", params._pathParam(1))
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<RunListPageResponse> =
            jsonHandler<RunListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: RunListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RunListPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("evalId", params.evalId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("evals", params._pathParam(0), "runs")
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        RunListPage.builder()
                            .service(RunServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<RunDeleteResponse> =
            jsonHandler<RunDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: RunDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RunDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("runId", params.runId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("evals", params._pathParam(0), "runs", params._pathParam(1))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
            jsonHandler<RunCancelResponse>(clientOptions.jsonMapper)

        override fun cancel(
            params: RunCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RunCancelResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("runId", params.runId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("evals", params._pathParam(0), "runs", params._pathParam(1))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
