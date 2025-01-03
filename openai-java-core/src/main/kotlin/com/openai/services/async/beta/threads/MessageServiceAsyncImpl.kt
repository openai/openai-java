// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.threads

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.json
import com.openai.errors.OpenAIError
import com.openai.models.BetaThreadMessageCreateParams
import com.openai.models.BetaThreadMessageDeleteParams
import com.openai.models.BetaThreadMessageListPageAsync
import com.openai.models.BetaThreadMessageListParams
import com.openai.models.BetaThreadMessageRetrieveParams
import com.openai.models.BetaThreadMessageUpdateParams
import com.openai.models.Message
import com.openai.models.MessageDeleted
import java.util.concurrent.CompletableFuture

class MessageServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : MessageServiceAsync {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<Message> =
        jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create a message. */
    override fun create(
        params: BetaThreadMessageCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Message> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("threads", params.getPathParam(0), "messages")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
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

    private val retrieveHandler: Handler<Message> =
        jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieve a message. */
    override fun retrieve(
        params: BetaThreadMessageRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Message> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments(
                    "threads",
                    params.getPathParam(0),
                    "messages",
                    params.getPathParam(1)
                )
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
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

    private val updateHandler: Handler<Message> =
        jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Modifies a message. */
    override fun update(
        params: BetaThreadMessageUpdateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Message> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments(
                    "threads",
                    params.getPathParam(0),
                    "messages",
                    params.getPathParam(1)
                )
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
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

    private val listHandler: Handler<BetaThreadMessageListPageAsync.Response> =
        jsonHandler<BetaThreadMessageListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of messages for a given thread. */
    override fun list(
        params: BetaThreadMessageListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<BetaThreadMessageListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("threads", params.getPathParam(0), "messages")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { BetaThreadMessageListPageAsync.of(this, params, it) }
        }
    }

    private val deleteHandler: Handler<MessageDeleted> =
        jsonHandler<MessageDeleted>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Deletes a message. */
    override fun delete(
        params: BetaThreadMessageDeleteParams,
        requestOptions: RequestOptions
    ): CompletableFuture<MessageDeleted> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments(
                    "threads",
                    params.getPathParam(0),
                    "messages",
                    params.getPathParam(1)
                )
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
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
}
