// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.conversations

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
import com.openai.core.prepare
import com.openai.models.conversations.Conversation
import com.openai.models.conversations.items.ConversationItem
import com.openai.models.conversations.items.ConversationItemList
import com.openai.models.conversations.items.ItemCreateParams
import com.openai.models.conversations.items.ItemDeleteParams
import com.openai.models.conversations.items.ItemListPage
import com.openai.models.conversations.items.ItemListParams
import com.openai.models.conversations.items.ItemRetrieveParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ItemServiceImpl internal constructor(private val clientOptions: ClientOptions) : ItemService {

    private val withRawResponse: ItemService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ItemService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ItemService =
        ItemServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: ItemCreateParams,
        requestOptions: RequestOptions,
    ): ConversationItemList =
        // post /conversations/{conversation_id}/items
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: ItemRetrieveParams,
        requestOptions: RequestOptions,
    ): ConversationItem =
        // get /conversations/{conversation_id}/items/{item_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: ItemListParams, requestOptions: RequestOptions): ItemListPage =
        // get /conversations/{conversation_id}/items
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: ItemDeleteParams, requestOptions: RequestOptions): Conversation =
        // delete /conversations/{conversation_id}/items/{item_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ItemService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ItemService.WithRawResponse =
            ItemServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<ConversationItemList> =
            jsonHandler<ConversationItemList>(clientOptions.jsonMapper)

        override fun create(
            params: ItemCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ConversationItemList> {
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

        private val retrieveHandler: Handler<ConversationItem> =
            jsonHandler<ConversationItem>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ItemRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ConversationItem> {
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

        private val listHandler: Handler<ConversationItemList> =
            jsonHandler<ConversationItemList>(clientOptions.jsonMapper)

        override fun list(
            params: ItemListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ItemListPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("conversationId", params.conversationId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("conversations", params._pathParam(0), "items")
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
                        ItemListPage.builder()
                            .service(ItemServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<Conversation> =
            jsonHandler<Conversation>(clientOptions.jsonMapper)

        override fun delete(
            params: ItemDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Conversation> {
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
