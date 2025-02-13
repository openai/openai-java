// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.chat.completions

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.prepareAsync
import com.openai.errors.OpenAIError
import com.openai.models.ChatCompletionMessageListPageAsync
import com.openai.models.ChatCompletionMessageListParams
import java.util.concurrent.CompletableFuture

class MessageServiceAsyncImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : MessageServiceAsync {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val listHandler: Handler<ChatCompletionMessageListPageAsync.Response> =
        jsonHandler<ChatCompletionMessageListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /**
     * Get the messages in a stored chat completion. Only chat completions that have been created
     * with the `store` parameter set to `true` will be returned.
     */
    override fun list(
        params: ChatCompletionMessageListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<ChatCompletionMessageListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("chat", "completions", params.getPathParam(0), "messages")
                .build()
                .prepareAsync(clientOptions, params)
        return request
            .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
            .thenApply { response ->
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                            it.validate()
                        }
                    }
                    .let { ChatCompletionMessageListPageAsync.of(this, params, it) }
            }
    }
}
