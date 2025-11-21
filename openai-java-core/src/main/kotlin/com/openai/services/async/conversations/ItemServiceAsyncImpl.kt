// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.conversations

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.conversations.Conversation
import com.openai.models.conversations.items.ConversationItem
import com.openai.models.conversations.items.ConversationItemList
import com.openai.models.conversations.items.ItemCreateParams
import com.openai.models.conversations.items.ItemDeleteParams
import com.openai.models.conversations.items.ItemListPageAsync
import com.openai.models.conversations.items.ItemListParams
import com.openai.models.conversations.items.ItemRetrieveParams
import com.openai.core.http.CancellationTokenSource
import com.openai.core.withCancellation
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ItemServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ItemServiceAsync {

    private val withRawResponse: ItemServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ItemServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ItemServiceAsync =
        ItemServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: ItemCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ConversationItemList> =
        // post /conversations/{conversation_id}/items
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: ItemRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ConversationItem> =
        // get /conversations/{conversation_id}/items/{item_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: ItemListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ItemListPageAsync> =
        // get /conversations/{conversation_id}/items
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: ItemDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Conversation> =
        // delete /conversations/{conversation_id}/items/{item_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ItemServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ItemServiceAsync.WithRawResponse =
            ItemServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<ConversationItemList> =
            jsonHandler<ConversationItemList>(clientOptions.jsonMapper)

        override fun create(
            params: ItemCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ConversationItemList>> {
            val cancellationTokenSource = CancellationTokenSource()
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("conversationId", params.conversationId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("conversations", params._pathParam(0), "items")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val delegate =
                request
                    .thenComposeAsync {
                        clientOptions.httpClient.executeAsync(
                            it,
                            requestOptions,
                            cancellationTokenSource.token()
                        )
                    }
                    .thenApply { response ->
                        errorHandler.handle(response).parseable {
                            response
                                .use { createHandler.handle(it) }
                                .also {
                                    if (requestOptions.responseValidation!!) {
                                        it.validate()
                                    }
                                }
                        }
                    }
            return delegate.withCancellation(cancellationTokenSource)
        }

        private val retrieveHandler: Handler<ConversationItem> =
            jsonHandler<ConversationItem>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ItemRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ConversationItem>> {
            val cancellationTokenSource = CancellationTokenSource()
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("itemId", params.itemId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "conversations",
                        params._pathParam(0),
                        "items",
                        params._pathParam(1),
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val delegate =
                request
                    .thenComposeAsync {
                        clientOptions.httpClient.executeAsync(
                            it,
                            requestOptions,
                            cancellationTokenSource.token()
                        )
                    }
                    .thenApply { response ->
                        errorHandler.handle(response).parseable {
                            response
                                .use { retrieveHandler.handle(it) }
                                .also {
                                    if (requestOptions.responseValidation!!) {
                                        it.validate()
                                    }
                                }
                        }
                    }
            return delegate.withCancellation(cancellationTokenSource)
        }

        private val listHandler: Handler<ConversationItemList> =
            jsonHandler<ConversationItemList>(clientOptions.jsonMapper)

        override fun list(
            params: ItemListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ItemListPageAsync>> {
            val cancellationTokenSource = CancellationTokenSource()
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("conversationId", params.conversationId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("conversations", params._pathParam(0), "items")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val delegate =
                request
                    .thenComposeAsync {
                        clientOptions.httpClient.executeAsync(
                            it,
                            requestOptions,
                            cancellationTokenSource.token()
                        )
                    }
                    .thenApply { response ->
                        errorHandler.handle(response).parseable {
                            response
                                .use { listHandler.handle(it) }
                                .also {
                                    if (requestOptions.responseValidation!!) {
                                        it.validate()
                                    }
                                }
                                .let {
                                    ItemListPageAsync.builder()
                                        .service(ItemServiceAsyncImpl(clientOptions))
                                        .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                        .params(params)
                                        .response(it)
                                        .build()
                                }
                        }
                    }
            return delegate.withCancellation(cancellationTokenSource)
        }

        private val deleteHandler: Handler<Conversation> =
            jsonHandler<Conversation>(clientOptions.jsonMapper)

        override fun delete(
            params: ItemDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Conversation>> {
            val cancellationTokenSource = CancellationTokenSource()
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("itemId", params.itemId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "conversations",
                        params._pathParam(0),
                        "items",
                        params._pathParam(1),
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val delegate =
                request
                    .thenComposeAsync {
                        clientOptions.httpClient.executeAsync(
                            it,
                            requestOptions,
                            cancellationTokenSource.token()
                        )
                    }
                    .thenApply { response ->
                        errorHandler.handle(response).parseable {
                            response
                                .use { deleteHandler.handle(it) }
                                .also {
                                    if (requestOptions.responseValidation!!) {
                                        it.validate()
                                    }
                                }
                        }
                    }
            return delegate.withCancellation(cancellationTokenSource)
        }
    }
}
