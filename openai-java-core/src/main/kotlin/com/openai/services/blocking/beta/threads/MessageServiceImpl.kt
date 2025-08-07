// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.beta.threads.messages.Message
import com.openai.models.beta.threads.messages.MessageCreateParams
import com.openai.models.beta.threads.messages.MessageDeleteParams
import com.openai.models.beta.threads.messages.MessageDeleted
import com.openai.models.beta.threads.messages.MessageListPage
import com.openai.models.beta.threads.messages.MessageListPageResponse
import com.openai.models.beta.threads.messages.MessageListParams
import com.openai.models.beta.threads.messages.MessageRetrieveParams
import com.openai.models.beta.threads.messages.MessageUpdateParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

@Deprecated("The Assistants API is deprecated in favor of the Responses API")
class MessageServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MessageService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: MessageService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MessageService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageService =
        MessageServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    override fun create(params: MessageCreateParams, requestOptions: RequestOptions): Message =
        // post /threads/{thread_id}/messages
        withRawResponse().create(params, requestOptions).parse()

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    override fun retrieve(params: MessageRetrieveParams, requestOptions: RequestOptions): Message =
        // get /threads/{thread_id}/messages/{message_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    override fun update(params: MessageUpdateParams, requestOptions: RequestOptions): Message =
        // post /threads/{thread_id}/messages/{message_id}
        withRawResponse().update(params, requestOptions).parse()

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    override fun list(params: MessageListParams, requestOptions: RequestOptions): MessageListPage =
        // get /threads/{thread_id}/messages
        withRawResponse().list(params, requestOptions).parse()

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    override fun delete(
        params: MessageDeleteParams,
        requestOptions: RequestOptions,
    ): MessageDeleted =
        // delete /threads/{thread_id}/messages/{message_id}
        withRawResponse().delete(params, requestOptions).parse()

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MessageService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MessageService.WithRawResponse =
            MessageServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<Message> = jsonHandler<Message>(clientOptions.jsonMapper)

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        override fun create(
            params: MessageCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("threadId", params.threadId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("threads", params._pathParam(0), "messages")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
            jsonHandler<Message>(clientOptions.jsonMapper)

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        override fun retrieve(
            params: MessageRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("messageId", params.messageId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "threads",
                        params._pathParam(0),
                        "messages",
                        params._pathParam(1),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateHandler: Handler<Message> = jsonHandler<Message>(clientOptions.jsonMapper)

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        override fun update(
            params: MessageUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Message> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("messageId", params.messageId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "threads",
                        params._pathParam(0),
                        "messages",
                        params._pathParam(1),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<MessageListPageResponse> =
            jsonHandler<MessageListPageResponse>(clientOptions.jsonMapper)

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        override fun list(
            params: MessageListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("threadId", params.threadId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("threads", params._pathParam(0), "messages")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        MessageListPage.builder()
                            .service(MessageServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<MessageDeleted> =
            jsonHandler<MessageDeleted>(clientOptions.jsonMapper)

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        override fun delete(
            params: MessageDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageDeleted> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("messageId", params.messageId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "threads",
                        params._pathParam(0),
                        "messages",
                        params._pathParam(1),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
