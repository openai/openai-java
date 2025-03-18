// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads

import com.openai.core.ClientOptions
import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.mapJson
import com.openai.core.handlers.sseHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.core.http.json
import com.openai.core.http.map
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.errors.OpenAIError
import com.openai.models.beta.assistants.AssistantStreamEvent
import com.openai.models.beta.threads.runs.Run
import com.openai.models.beta.threads.runs.RunCancelParams
import com.openai.models.beta.threads.runs.RunCreateParams
import com.openai.models.beta.threads.runs.RunListPage
import com.openai.models.beta.threads.runs.RunListParams
import com.openai.models.beta.threads.runs.RunRetrieveParams
import com.openai.models.beta.threads.runs.RunSubmitToolOutputsParams
import com.openai.models.beta.threads.runs.RunUpdateParams
import com.openai.services.blocking.beta.threads.runs.StepService
import com.openai.services.blocking.beta.threads.runs.StepServiceImpl

class RunServiceImpl internal constructor(private val clientOptions: ClientOptions) : RunService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: RunService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val steps: StepService by lazy { StepServiceImpl(clientOptions) }

    override fun withRawResponse(): RunService.WithRawResponse = withRawResponse

    override fun steps(): StepService = steps

    override fun create(params: RunCreateParams, requestOptions: RequestOptions): Run =
        // post /threads/{thread_id}/runs
        withRawResponse().create(params, requestOptions).parse()

    override fun createStreaming(
        params: RunCreateParams,
        requestOptions: RequestOptions,
    ): StreamResponse<AssistantStreamEvent> =
        // post /threads/{thread_id}/runs
        withRawResponse().createStreaming(params, requestOptions).parse()

    override fun retrieve(params: RunRetrieveParams, requestOptions: RequestOptions): Run =
        // get /threads/{thread_id}/runs/{run_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(params: RunUpdateParams, requestOptions: RequestOptions): Run =
        // post /threads/{thread_id}/runs/{run_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(params: RunListParams, requestOptions: RequestOptions): RunListPage =
        // get /threads/{thread_id}/runs
        withRawResponse().list(params, requestOptions).parse()

    override fun cancel(params: RunCancelParams, requestOptions: RequestOptions): Run =
        // post /threads/{thread_id}/runs/{run_id}/cancel
        withRawResponse().cancel(params, requestOptions).parse()

    override fun submitToolOutputs(
        params: RunSubmitToolOutputsParams,
        requestOptions: RequestOptions,
    ): Run =
        // post /threads/{thread_id}/runs/{run_id}/submit_tool_outputs
        withRawResponse().submitToolOutputs(params, requestOptions).parse()

    override fun submitToolOutputsStreaming(
        params: RunSubmitToolOutputsParams,
        requestOptions: RequestOptions,
    ): StreamResponse<AssistantStreamEvent> =
        // post /threads/{thread_id}/runs/{run_id}/submit_tool_outputs
        withRawResponse().submitToolOutputsStreaming(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RunService.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val steps: StepService.WithRawResponse by lazy {
            StepServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun steps(): StepService.WithRawResponse = steps

        private val createHandler: Handler<Run> =
            jsonHandler<Run>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: RunCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Run> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("threads", params._pathParam(0), "runs")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        params.model().map { it.toString() }.orElse(null),
                    )
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

        private val createStreamingHandler: Handler<StreamResponse<AssistantStreamEvent>> =
            sseHandler(clientOptions.jsonMapper)
                .mapJson<AssistantStreamEvent>(includeEventAndData = true)
                .withErrorHandler(errorHandler)

        override fun createStreaming(
            params: RunCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("threads", params._pathParam(0), "runs")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(
                        json(
                            clientOptions.jsonMapper,
                            params
                                ._body()
                                .toBuilder()
                                .putAdditionalProperty("stream", JsonValue.from(true))
                                .build(),
                        )
                    )
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        params.model().map { it.toString() }.orElse(null),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .let { createStreamingHandler.handle(it) }
                    .let { streamResponse ->
                        if (requestOptions.responseValidation!!) {
                            streamResponse.map { it.validate() }
                        } else {
                            streamResponse
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<Run> =
            jsonHandler<Run>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: RunRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Run> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("threads", params._pathParam(0), "runs", params._pathParam(1))
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
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

        private val updateHandler: Handler<Run> =
            jsonHandler<Run>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun update(
            params: RunUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Run> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("threads", params._pathParam(0), "runs", params._pathParam(1))
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { updateHandler.handle(it) }
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
                    .addPathSegments("threads", params._pathParam(0), "runs")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
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

        private val cancelHandler: Handler<Run> =
            jsonHandler<Run>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun cancel(
            params: RunCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Run> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "threads",
                        params._pathParam(0),
                        "runs",
                        params._pathParam(1),
                        "cancel",
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
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

        private val submitToolOutputsHandler: Handler<Run> =
            jsonHandler<Run>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun submitToolOutputs(
            params: RunSubmitToolOutputsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Run> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "threads",
                        params._pathParam(0),
                        "runs",
                        params._pathParam(1),
                        "submit_tool_outputs",
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { submitToolOutputsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val submitToolOutputsStreamingHandler:
            Handler<StreamResponse<AssistantStreamEvent>> =
            sseHandler(clientOptions.jsonMapper)
                .mapJson<AssistantStreamEvent>(includeEventAndData = true)
                .withErrorHandler(errorHandler)

        override fun submitToolOutputsStreaming(
            params: RunSubmitToolOutputsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "threads",
                        params._pathParam(0),
                        "runs",
                        params._pathParam(1),
                        "submit_tool_outputs",
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(
                        json(
                            clientOptions.jsonMapper,
                            params
                                ._body()
                                .toBuilder()
                                .putAdditionalProperty("stream", JsonValue.from(true))
                                .build(),
                        )
                    )
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .let { submitToolOutputsStreamingHandler.handle(it) }
                    .let { streamResponse ->
                        if (requestOptions.responseValidation!!) {
                            streamResponse.map { it.validate() }
                        } else {
                            streamResponse
                        }
                    }
            }
        }
    }
}
