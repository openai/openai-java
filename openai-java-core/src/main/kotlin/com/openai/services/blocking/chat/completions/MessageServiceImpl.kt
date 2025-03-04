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
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.errors.OpenAIError
import com.openai.models.ChatCompletionMessageListPage
import com.openai.models.ChatCompletionMessageListParams

class MessageServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MessageService {

    private val withRawResponse: MessageService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MessageService.WithRawResponse = withRawResponse

    override fun list(
        params: ChatCompletionMessageListParams,
        requestOptions: RequestOptions,
    ): ChatCompletionMessageListPage =
        // get /chat/completions/{completion_id}/messages
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MessageService.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val listHandler: Handler<ChatCompletionMessageListPage.Response> =
            jsonHandler<ChatCompletionMessageListPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: ChatCompletionMessageListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChatCompletionMessageListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("chat", "completions", params.getPathParam(0), "messages")
                    .build()
                    .prepare(clientOptions, params, null)
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
                    .let {
                        ChatCompletionMessageListPage.of(
                            MessageServiceImpl(clientOptions),
                            params,
                            it,
                        )
                    }
            }
        }
    }
}
