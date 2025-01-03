// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

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
import com.openai.models.Assistant
import com.openai.models.AssistantDeleted
import com.openai.models.BetaAssistantCreateParams
import com.openai.models.BetaAssistantDeleteParams
import com.openai.models.BetaAssistantListPageAsync
import com.openai.models.BetaAssistantListParams
import com.openai.models.BetaAssistantRetrieveParams
import com.openai.models.BetaAssistantUpdateParams
import java.util.concurrent.CompletableFuture

class AssistantServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : AssistantServiceAsync {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<Assistant> =
        jsonHandler<Assistant>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create an assistant with a model and instructions. */
    override fun create(
        params: BetaAssistantCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Assistant> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("assistants")
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

    private val retrieveHandler: Handler<Assistant> =
        jsonHandler<Assistant>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieves an assistant. */
    override fun retrieve(
        params: BetaAssistantRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Assistant> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("assistants", params.getPathParam(0))
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

    private val updateHandler: Handler<Assistant> =
        jsonHandler<Assistant>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Modifies an assistant. */
    override fun update(
        params: BetaAssistantUpdateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Assistant> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("assistants", params.getPathParam(0))
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

    private val listHandler: Handler<BetaAssistantListPageAsync.Response> =
        jsonHandler<BetaAssistantListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of assistants. */
    override fun list(
        params: BetaAssistantListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<BetaAssistantListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("assistants")
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
                .let { BetaAssistantListPageAsync.of(this, params, it) }
        }
    }

    private val deleteHandler: Handler<AssistantDeleted> =
        jsonHandler<AssistantDeleted>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Delete an assistant. */
    override fun delete(
        params: BetaAssistantDeleteParams,
        requestOptions: RequestOptions
    ): CompletableFuture<AssistantDeleted> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("assistants", params.getPathParam(0))
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