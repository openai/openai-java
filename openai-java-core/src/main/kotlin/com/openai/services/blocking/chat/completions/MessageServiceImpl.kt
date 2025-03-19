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
import com.openai.models.ErrorObject
import com.openai.models.chat.completions.messages.MessageListPage
import com.openai.models.chat.completions.messages.MessageListParams

class MessageServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MessageService {

    private val withRawResponse: MessageService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MessageService.WithRawResponse = withRawResponse

    override fun list(params: MessageListParams, requestOptions: RequestOptions): MessageListPage =
        // get /chat/completions/{completion_id}/messages
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MessageService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val listHandler: Handler<MessageListPage.Response> =
            jsonHandler<MessageListPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: MessageListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("chat", "completions", params._pathParam(0), "messages")
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
                    .let { MessageListPage.of(MessageServiceImpl(clientOptions), params, it) }
            }
        }
    }
}
