// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.chatkit

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
import com.openai.models.beta.chatkit.threads.ChatKitThread
import com.openai.models.beta.chatkit.threads.ChatKitThreadItemList
import com.openai.models.beta.chatkit.threads.ThreadDeleteParams
import com.openai.models.beta.chatkit.threads.ThreadDeleteResponse
import com.openai.models.beta.chatkit.threads.ThreadListItemsPage
import com.openai.models.beta.chatkit.threads.ThreadListItemsParams
import com.openai.models.beta.chatkit.threads.ThreadListPage
import com.openai.models.beta.chatkit.threads.ThreadListPageResponse
import com.openai.models.beta.chatkit.threads.ThreadListParams
import com.openai.models.beta.chatkit.threads.ThreadRetrieveParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ThreadServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ThreadService {

    companion object {

        private val DEFAULT_HEADERS =
            Headers.builder().put("OpenAI-Beta", "chatkit_beta=v1").build()
    }

    private val withRawResponse: ThreadService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ThreadService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ThreadService =
        ThreadServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: ThreadRetrieveParams,
        requestOptions: RequestOptions,
    ): ChatKitThread =
        // get /chatkit/threads/{thread_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: ThreadListParams, requestOptions: RequestOptions): ThreadListPage =
        // get /chatkit/threads
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: ThreadDeleteParams,
        requestOptions: RequestOptions,
    ): ThreadDeleteResponse =
        // delete /chatkit/threads/{thread_id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun listItems(
        params: ThreadListItemsParams,
        requestOptions: RequestOptions,
    ): ThreadListItemsPage =
        // get /chatkit/threads/{thread_id}/items
        withRawResponse().listItems(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ThreadService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ThreadService.WithRawResponse =
            ThreadServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<ChatKitThread> =
            jsonHandler<ChatKitThread>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ThreadRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChatKitThread> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("threadId", params.threadId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("chatkit", "threads", params._pathParam(0))
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

        private val listHandler: Handler<ThreadListPageResponse> =
            jsonHandler<ThreadListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: ThreadListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ThreadListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("chatkit", "threads")
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
                        ThreadListPage.builder()
                            .service(ThreadServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<ThreadDeleteResponse> =
            jsonHandler<ThreadDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: ThreadDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ThreadDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("threadId", params.threadId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("chatkit", "threads", params._pathParam(0))
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

        private val listItemsHandler: Handler<ChatKitThreadItemList> =
            jsonHandler<ChatKitThreadItemList>(clientOptions.jsonMapper)

        override fun listItems(
            params: ThreadListItemsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ThreadListItemsPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("threadId", params.threadId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("chatkit", "threads", params._pathParam(0), "items")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listItemsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        ThreadListItemsPage.builder()
                            .service(ThreadServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
