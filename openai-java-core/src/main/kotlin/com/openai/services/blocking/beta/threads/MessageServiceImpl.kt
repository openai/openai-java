// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.ErrorObject
import com.openai.models.beta.threads.messages.Message
import com.openai.models.beta.threads.messages.MessageCreateParams
import com.openai.models.beta.threads.messages.MessageDeleteParams
import com.openai.models.beta.threads.messages.MessageDeleted
import com.openai.models.beta.threads.messages.MessageListPage
import com.openai.models.beta.threads.messages.MessageListParams
import com.openai.models.beta.threads.messages.MessageRetrieveParams
import com.openai.models.beta.threads.messages.MessageUpdateParams

class MessageServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MessageService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: MessageService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MessageService.WithRawResponse = withRawResponse

    override fun create(params: MessageCreateParams, requestOptions: RequestOptions): Message =
        // post /threads/{thread_id}/messages
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(params: MessageRetrieveParams, requestOptions: RequestOptions): Message =
        // get /threads/{thread_id}/messages/{message_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(params: MessageUpdateParams, requestOptions: RequestOptions): Message =
        // post /threads/{thread_id}/messages/{message_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(params: MessageListParams, requestOptions: RequestOptions): MessageListPage =
        // get /threads/{thread_id}/messages
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: MessageDeleteParams,
        requestOptions: RequestOptions,
    ): MessageDeleted =
        // delete /threads/{thread_id}/messages/{message_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MessageService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<Message> =
            jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: MessageCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("threads", params._pathParam(0), "messages")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<Message> =
            jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: MessageRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "threads",
                        params._pathParam(0),
                        "messages",
                        params._pathParam(1),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateHandler: Handler<Message> =
            jsonHandler<Message>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun update(
            params: MessageUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "threads",
                        params._pathParam(0),
                        "messages",
                        params._pathParam(1),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

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
                    .addPathSegments("threads", params._pathParam(0), "messages")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
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

        private val deleteHandler: Handler<MessageDeleted> =
            jsonHandler<MessageDeleted>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun delete(
            params: MessageDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageDeleted> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments(
                        "threads",
                        params._pathParam(0),
                        "messages",
                        params._pathParam(1),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
