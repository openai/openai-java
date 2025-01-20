// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

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
import com.openai.models.Model
import com.openai.models.ModelDeleteParams
import com.openai.models.ModelDeleted
import com.openai.models.ModelListPageAsync
import com.openai.models.ModelListParams
import com.openai.models.ModelRetrieveParams
import java.util.concurrent.CompletableFuture

class ModelServiceAsyncImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : ModelServiceAsync {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Model> =
        jsonHandler<Model>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Retrieves a model instance, providing basic information about the model such as the owner and
     * permissioning.
     */
    override fun retrieve(
        params: ModelRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Model> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("models", params.getPathParam(0))
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

    private val listHandler: Handler<ModelListPageAsync.Response> =
        jsonHandler<ModelListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /**
     * Lists the currently available models, and provides basic information about each one such as
     * the owner and availability.
     */
    override fun list(
        params: ModelListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ModelListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("models")
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
                .let { ModelListPageAsync.of(this, params, it) }
        }
    }

    private val deleteHandler: Handler<ModelDeleted> =
        jsonHandler<ModelDeleted>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Delete a fine-tuned model. You must have the Owner role in your organization to delete a
     * model.
     */
    override fun delete(
        params: ModelDeleteParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ModelDeleted> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("models", params.getPathParam(0))
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
