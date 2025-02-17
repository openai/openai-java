// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.chat.completions

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.prepare
import com.openai.errors.OpenAIError
import com.openai.models.ChatCompletionMessageListPage
import com.openai.models.ChatCompletionMessageListParams

class MessageServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MessageService {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val listHandler: Handler<ChatCompletionMessageListPage.Response> =
        jsonHandler<ChatCompletionMessageListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /**
     * Get the messages in a stored chat completion. Only chat completions that have been created
     * with the `store` parameter set to `true` will be returned.
     */
    override fun list(
        params: ChatCompletionMessageListParams,
        requestOptions: RequestOptions,
    ): ChatCompletionMessageListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("chat", "completions", params.getPathParam(0), "messages")
                .build()
                .prepare(clientOptions, params, null)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { listHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
            .let { ChatCompletionMessageListPage.of(this, params, it) }
    }
}
