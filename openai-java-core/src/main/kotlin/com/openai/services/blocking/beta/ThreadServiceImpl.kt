// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

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
import com.openai.models.beta.threads.Thread
import com.openai.models.beta.threads.ThreadCreateAndRunParams
import com.openai.models.beta.threads.ThreadCreateParams
import com.openai.models.beta.threads.ThreadDeleteParams
import com.openai.models.beta.threads.ThreadDeleted
import com.openai.models.beta.threads.ThreadRetrieveParams
import com.openai.models.beta.threads.ThreadUpdateParams
import com.openai.models.beta.threads.runs.Run
import com.openai.services.blocking.beta.threads.MessageService
import com.openai.services.blocking.beta.threads.MessageServiceImpl
import com.openai.services.blocking.beta.threads.RunService
import com.openai.services.blocking.beta.threads.RunServiceImpl

class ThreadServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ThreadService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: ThreadService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val runs: RunService by lazy { RunServiceImpl(clientOptions) }

    private val messages: MessageService by lazy { MessageServiceImpl(clientOptions) }

    override fun withRawResponse(): ThreadService.WithRawResponse = withRawResponse

    override fun runs(): RunService = runs

    override fun messages(): MessageService = messages

    override fun create(params: ThreadCreateParams, requestOptions: RequestOptions): Thread =
        // post /threads
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(params: ThreadRetrieveParams, requestOptions: RequestOptions): Thread =
        // get /threads/{thread_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(params: ThreadUpdateParams, requestOptions: RequestOptions): Thread =
        // post /threads/{thread_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun delete(params: ThreadDeleteParams, requestOptions: RequestOptions): ThreadDeleted =
        // delete /threads/{thread_id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun createAndRun(
        params: ThreadCreateAndRunParams,
        requestOptions: RequestOptions,
    ): Run =
        // post /threads/runs
        withRawResponse().createAndRun(params, requestOptions).parse()

    override fun createAndRunStreaming(
        params: ThreadCreateAndRunParams,
        requestOptions: RequestOptions,
    ): StreamResponse<AssistantStreamEvent> =
        // post /threads/runs
        withRawResponse().createAndRunStreaming(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ThreadService.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val runs: RunService.WithRawResponse by lazy {
            RunServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val messages: MessageService.WithRawResponse by lazy {
            MessageServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun runs(): RunService.WithRawResponse = runs

        override fun messages(): MessageService.WithRawResponse = messages

        private val createHandler: Handler<Thread> =
            jsonHandler<Thread>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: ThreadCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Thread> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("threads")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
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

        private val retrieveHandler: Handler<Thread> =
            jsonHandler<Thread>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: ThreadRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Thread> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("threads", params._pathParam(0))
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

        private val updateHandler: Handler<Thread> =
            jsonHandler<Thread>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun update(
            params: ThreadUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Thread> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("threads", params._pathParam(0))
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

        private val deleteHandler: Handler<ThreadDeleted> =
            jsonHandler<ThreadDeleted>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun delete(
            params: ThreadDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ThreadDeleted> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("threads", params._pathParam(0))
                    .putAllHeaders(DEFAULT_HEADERS)
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
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

        private val createAndRunHandler: Handler<Run> =
            jsonHandler<Run>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun createAndRun(
            params: ThreadCreateAndRunParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Run> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("threads", "runs")
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
                    .use { createAndRunHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val createAndRunStreamingHandler: Handler<StreamResponse<AssistantStreamEvent>> =
            sseHandler(clientOptions.jsonMapper)
                .mapJson<AssistantStreamEvent>(includeEventAndData = true)
                .withErrorHandler(errorHandler)

        override fun createAndRunStreaming(
            params: ThreadCreateAndRunParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("threads", "runs")
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
                    .let { createAndRunStreamingHandler.handle(it) }
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
