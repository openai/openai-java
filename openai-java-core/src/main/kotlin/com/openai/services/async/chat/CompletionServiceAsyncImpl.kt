// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.chat

import com.openai.core.ClientOptions
import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.mapJson
import com.openai.core.handlers.sseHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.StreamResponse
import com.openai.core.http.map
import com.openai.core.http.toAsync
import com.openai.core.json
import com.openai.core.prepareAsync
import com.openai.errors.OpenAIError
import com.openai.models.ChatCompletion
import com.openai.models.ChatCompletionChunk
import com.openai.models.ChatCompletionCreateParams
import com.openai.models.ChatCompletionDeleteParams
import com.openai.models.ChatCompletionDeleted
import com.openai.models.ChatCompletionRetrieveParams
import com.openai.models.ChatCompletionUpdateParams
import com.openai.services.async.chat.completions.MessageServiceAsync
import com.openai.services.async.chat.completions.MessageServiceAsyncImpl
import java.util.concurrent.CompletableFuture

class CompletionServiceAsyncImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : CompletionServiceAsync {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val messages: MessageServiceAsync by lazy { MessageServiceAsyncImpl(clientOptions) }

    override fun messages(): MessageServiceAsync = messages

    private val createHandler: Handler<ChatCompletion> =
        jsonHandler<ChatCompletion>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Creates a model response for the given chat conversation. Learn more in the
     * [text generation](https://platform.openai.com/docs/guides/text-generation),
     * [vision](https://platform.openai.com/docs/guides/vision), and
     * [audio](https://platform.openai.com/docs/guides/audio) guides.
     *
     * Parameter support can differ depending on the model used to generate the response,
     * particularly for newer reasoning models. Parameters that are only supported for reasoning
     * models are noted below. For the current state of unsupported parameters in reasoning models,
     * [refer to the reasoning guide](https://platform.openai.com/docs/guides/reasoning).
     */
    override fun create(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ChatCompletion> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("chat", "completions")
                .body(json(clientOptions.jsonMapper, params._body()))
                .build()
                .prepareAsync(clientOptions, params, params.model().toString())
        return request
            .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
            .thenApply { response ->
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                            it.validate()
                        }
                    }
            }
    }

    private val createStreamingHandler: Handler<StreamResponse<ChatCompletionChunk>> =
        sseHandler(clientOptions.jsonMapper)
            .mapJson<ChatCompletionChunk>()
            .withErrorHandler(errorHandler)

    /**
     * Creates a model response for the given chat conversation. Learn more in the
     * [text generation](https://platform.openai.com/docs/guides/text-generation),
     * [vision](https://platform.openai.com/docs/guides/vision), and
     * [audio](https://platform.openai.com/docs/guides/audio) guides.
     *
     * Parameter support can differ depending on the model used to generate the response,
     * particularly for newer reasoning models. Parameters that are only supported for reasoning
     * models are noted below. For the current state of unsupported parameters in reasoning models,
     * [refer to the reasoning guide](https://platform.openai.com/docs/guides/reasoning).
     */
    override fun createStreaming(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions
    ): AsyncStreamResponse<ChatCompletionChunk> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("chat", "completions")
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
                .prepareAsync(clientOptions, params, params.model().toString())
        return request
            .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
            .thenApply { response ->
                response
                    .let { createStreamingHandler.handle(it) }
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

    private val retrieveHandler: Handler<ChatCompletion> =
        jsonHandler<ChatCompletion>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Get a stored chat completion. Only chat completions that have been created with the `store`
     * parameter set to `true` will be returned.
     */
    override fun retrieve(
        params: ChatCompletionRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ChatCompletion> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("chat", "completions", params.getPathParam(0))
                .build()
                .prepareAsync(clientOptions, params)
        return request
            .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
            .thenApply { response ->
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                            it.validate()
                        }
                    }
            }
    }

    private val updateHandler: Handler<ChatCompletion> =
        jsonHandler<ChatCompletion>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Modify a stored chat completion. Only chat completions that have been created with the
     * `store` parameter set to `true` can be modified. Currently, the only supported modification
     * is to update the `metadata` field.
     */
    override fun update(
        params: ChatCompletionUpdateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ChatCompletion> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("chat", "completions", params.getPathParam(0))
                .body(json(clientOptions.jsonMapper, params._body()))
                .build()
                .prepareAsync(clientOptions, params)
        return request
            .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
            .thenApply { response ->
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                            it.validate()
                        }
                    }
            }
    }

    private val deleteHandler: Handler<ChatCompletionDeleted> =
        jsonHandler<ChatCompletionDeleted>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Delete a stored chat completion. Only chat completions that have been created with the
     * `store` parameter set to `true` can be deleted.
     */
    override fun delete(
        params: ChatCompletionDeleteParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ChatCompletionDeleted> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("chat", "completions", params.getPathParam(0))
                .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
                .prepareAsync(clientOptions, params)
        return request
            .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
            .thenApply { response ->
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                            it.validate()
                        }
                    }
            }
    }
}
