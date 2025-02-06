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
import com.openai.core.http.StreamResponse
import com.openai.core.http.map
import com.openai.core.json
import com.openai.core.prepare
import com.openai.errors.OpenAIError
import com.openai.models.AssistantStreamEvent
import com.openai.models.BetaThreadCreateAndRunParams
import com.openai.models.BetaThreadCreateParams
import com.openai.models.BetaThreadDeleteParams
import com.openai.models.BetaThreadRetrieveParams
import com.openai.models.BetaThreadUpdateParams
import com.openai.models.Run
import com.openai.models.Thread
import com.openai.models.ThreadDeleted
import com.openai.services.blocking.beta.threads.MessageService
import com.openai.services.blocking.beta.threads.MessageServiceImpl
import com.openai.services.blocking.beta.threads.RunService
import com.openai.services.blocking.beta.threads.RunServiceImpl

class ThreadServiceImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : ThreadService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val runs: RunService by lazy { RunServiceImpl(clientOptions) }

    private val messages: MessageService by lazy { MessageServiceImpl(clientOptions) }

    override fun runs(): RunService = runs

    override fun messages(): MessageService = messages

    private val createHandler: Handler<Thread> =
        jsonHandler<Thread>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create a thread. */
    override fun create(params: BetaThreadCreateParams, requestOptions: RequestOptions): Thread {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("threads")
                .putAllHeaders(DEFAULT_HEADERS)
                .body(json(clientOptions.jsonMapper, params._body()))
                .build()
                .prepare(clientOptions, params, deploymentModel = null)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { createHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
    }

    private val retrieveHandler: Handler<Thread> =
        jsonHandler<Thread>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieves a thread. */
    override fun retrieve(
        params: BetaThreadRetrieveParams,
        requestOptions: RequestOptions
    ): Thread {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("threads", params.getPathParam(0))
                .putAllHeaders(DEFAULT_HEADERS)
                .build()
                .prepare(clientOptions, params, deploymentModel = null)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { retrieveHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
    }

    private val updateHandler: Handler<Thread> =
        jsonHandler<Thread>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Modifies a thread. */
    override fun update(params: BetaThreadUpdateParams, requestOptions: RequestOptions): Thread {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("threads", params.getPathParam(0))
                .putAllHeaders(DEFAULT_HEADERS)
                .body(json(clientOptions.jsonMapper, params._body()))
                .build()
                .prepare(clientOptions, params, deploymentModel = null)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { updateHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
    }

    private val deleteHandler: Handler<ThreadDeleted> =
        jsonHandler<ThreadDeleted>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Delete a thread. */
    override fun delete(
        params: BetaThreadDeleteParams,
        requestOptions: RequestOptions
    ): ThreadDeleted {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("threads", params.getPathParam(0))
                .putAllHeaders(DEFAULT_HEADERS)
                .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
                .prepare(clientOptions, params, deploymentModel = null)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { deleteHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
    }

    private val createAndRunHandler: Handler<Run> =
        jsonHandler<Run>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create a thread and run it in one request. */
    override fun createAndRun(
        params: BetaThreadCreateAndRunParams,
        requestOptions: RequestOptions
    ): Run {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("threads", "runs")
                .putAllHeaders(DEFAULT_HEADERS)
                .body(json(clientOptions.jsonMapper, params._body()))
                .build()
                .prepare(clientOptions, params, params.model().map { it.toString() }.orElse(null))
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { createAndRunHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
    }

    private val createAndRunStreamingHandler: Handler<StreamResponse<AssistantStreamEvent>> =
        sseHandler(clientOptions.jsonMapper)
            .mapJson<AssistantStreamEvent>(includeEventAndData = true)
            .withErrorHandler(errorHandler)

    /** Create a thread and run it in one request. */
    override fun createAndRunStreaming(
        params: BetaThreadCreateAndRunParams,
        requestOptions: RequestOptions
    ): StreamResponse<AssistantStreamEvent> {
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
                            .build()
                    )
                )
                .build()
                .prepare(clientOptions, params, params.model().map { it.toString() }.orElse(null))
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .let { createAndRunStreamingHandler.handle(it) }
            .let { streamResponse ->
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    streamResponse.map { it.validate() }
                } else {
                    streamResponse
                }
            }
    }
}
