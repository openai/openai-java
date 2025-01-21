// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.openai.core.ClientOptions
import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.mapJson
import com.openai.core.handlers.sseHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.StreamResponse
import com.openai.core.http.map
import com.openai.core.http.toAsync
import com.openai.core.json
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
import com.openai.services.async.beta.threads.MessageServiceAsync
import com.openai.services.async.beta.threads.MessageServiceAsyncImpl
import com.openai.services.async.beta.threads.RunServiceAsync
import com.openai.services.async.beta.threads.RunServiceAsyncImpl
import java.util.concurrent.CompletableFuture

class ThreadServiceAsyncImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : ThreadServiceAsync {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val runs: RunServiceAsync by lazy { RunServiceAsyncImpl(clientOptions) }

    private val messages: MessageServiceAsync by lazy { MessageServiceAsyncImpl(clientOptions) }

    override fun runs(): RunServiceAsync = runs

    override fun messages(): MessageServiceAsync = messages

    private val createHandler: Handler<Thread> =
        jsonHandler<Thread>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create a thread. */
    override fun create(
        params: BetaThreadCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Thread> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("threads")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val retrieveHandler: Handler<Thread> =
        jsonHandler<Thread>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieves a thread. */
    override fun retrieve(
        params: BetaThreadRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Thread> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("threads", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val updateHandler: Handler<Thread> =
        jsonHandler<Thread>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Modifies a thread. */
    override fun update(
        params: BetaThreadUpdateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Thread> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("threads", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { updateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val deleteHandler: Handler<ThreadDeleted> =
        jsonHandler<ThreadDeleted>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Delete a thread. */
    override fun delete(
        params: BetaThreadDeleteParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ThreadDeleted> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("threads", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .apply { params.getBody().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { deleteHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val createAndRunHandler: Handler<Run> =
        jsonHandler<Run>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create a thread and run it in one request. */
    override fun createAndRun(
        params: BetaThreadCreateAndRunParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Run> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("threads", "runs")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { createAndRunHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val createAndRunStreamingHandler: Handler<StreamResponse<AssistantStreamEvent>> =
        sseHandler(clientOptions.jsonMapper)
            .mapJson<AssistantStreamEvent>()
            .withErrorHandler(errorHandler)

    /** Create a thread and run it in one request. */
    override fun createAndRunStreaming(
        params: BetaThreadCreateAndRunParams,
        requestOptions: RequestOptions
    ): AsyncStreamResponse<AssistantStreamEvent> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("threads", "runs")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .body(
                    json(
                        clientOptions.jsonMapper,
                        params
                            .getBody()
                            .toBuilder()
                            .putAdditionalProperty("stream", JsonValue.from(true))
                            .build()
                    )
                )
                .build()
        return clientOptions.httpClient
            .executeAsync(request, requestOptions)
            .thenApply { response ->
                response
                    .let { createAndRunStreamingHandler.handle(it) }
                    .let { streamResponse ->
                        if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                            streamResponse.map { it.validate() }
                        } else {
                            streamResponse
                        }
                    }
            }
            .toAsync(clientOptions.streamHandlerExecutor)
    }
}
