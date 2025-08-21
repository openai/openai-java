// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.conversations

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.conversations.Conversation
import com.openai.models.conversations.items.ConversationItem
import com.openai.models.conversations.items.ConversationItemList
import com.openai.models.conversations.items.ItemCreateParams
import com.openai.models.conversations.items.ItemDeleteParams
import com.openai.models.conversations.items.ItemListPageAsync
import com.openai.models.conversations.items.ItemListParams
import com.openai.models.conversations.items.ItemRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ItemServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ItemServiceAsync

    /** Create items in a conversation with the given ID. */
    fun create(
        conversationId: String,
        params: ItemCreateParams,
    ): CompletableFuture<ConversationItemList> =
        create(conversationId, params, RequestOptions.none())

    /** @see create */
    fun create(
        conversationId: String,
        params: ItemCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ConversationItemList> =
        create(params.toBuilder().conversationId(conversationId).build(), requestOptions)

    /** @see create */
    fun create(params: ItemCreateParams): CompletableFuture<ConversationItemList> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ItemCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ConversationItemList>

    /** Get a single item from a conversation with the given IDs. */
    fun retrieve(itemId: String, params: ItemRetrieveParams): CompletableFuture<ConversationItem> =
        retrieve(itemId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        itemId: String,
        params: ItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ConversationItem> =
        retrieve(params.toBuilder().itemId(itemId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: ItemRetrieveParams): CompletableFuture<ConversationItem> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ConversationItem>

    /** List all items for a conversation with the given ID. */
    fun list(conversationId: String): CompletableFuture<ItemListPageAsync> =
        list(conversationId, ItemListParams.none())

    /** @see list */
    fun list(
        conversationId: String,
        params: ItemListParams = ItemListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ItemListPageAsync> =
        list(params.toBuilder().conversationId(conversationId).build(), requestOptions)

    /** @see list */
    fun list(
        conversationId: String,
        params: ItemListParams = ItemListParams.none(),
    ): CompletableFuture<ItemListPageAsync> = list(conversationId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ItemListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ItemListPageAsync>

    /** @see list */
    fun list(params: ItemListParams): CompletableFuture<ItemListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        conversationId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ItemListPageAsync> =
        list(conversationId, ItemListParams.none(), requestOptions)

    /** Delete an item from a conversation with the given IDs. */
    fun delete(itemId: String, params: ItemDeleteParams): CompletableFuture<Conversation> =
        delete(itemId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        itemId: String,
        params: ItemDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Conversation> =
        delete(params.toBuilder().itemId(itemId).build(), requestOptions)

    /** @see delete */
    fun delete(params: ItemDeleteParams): CompletableFuture<Conversation> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ItemDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Conversation>

    /** A view of [ItemServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ItemServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /conversations/{conversation_id}/items`, but is
         * otherwise the same as [ItemServiceAsync.create].
         */
        fun create(
            conversationId: String,
            params: ItemCreateParams,
        ): CompletableFuture<HttpResponseFor<ConversationItemList>> =
            create(conversationId, params, RequestOptions.none())

        /** @see create */
        fun create(
            conversationId: String,
            params: ItemCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ConversationItemList>> =
            create(params.toBuilder().conversationId(conversationId).build(), requestOptions)

        /** @see create */
        fun create(
            params: ItemCreateParams
        ): CompletableFuture<HttpResponseFor<ConversationItemList>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: ItemCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ConversationItemList>>

        /**
         * Returns a raw HTTP response for `get /conversations/{conversation_id}/items/{item_id}`,
         * but is otherwise the same as [ItemServiceAsync.retrieve].
         */
        fun retrieve(
            itemId: String,
            params: ItemRetrieveParams,
        ): CompletableFuture<HttpResponseFor<ConversationItem>> =
            retrieve(itemId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            itemId: String,
            params: ItemRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ConversationItem>> =
            retrieve(params.toBuilder().itemId(itemId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: ItemRetrieveParams
        ): CompletableFuture<HttpResponseFor<ConversationItem>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ItemRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ConversationItem>>

        /**
         * Returns a raw HTTP response for `get /conversations/{conversation_id}/items`, but is
         * otherwise the same as [ItemServiceAsync.list].
         */
        fun list(conversationId: String): CompletableFuture<HttpResponseFor<ItemListPageAsync>> =
            list(conversationId, ItemListParams.none())

        /** @see list */
        fun list(
            conversationId: String,
            params: ItemListParams = ItemListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ItemListPageAsync>> =
            list(params.toBuilder().conversationId(conversationId).build(), requestOptions)

        /** @see list */
        fun list(
            conversationId: String,
            params: ItemListParams = ItemListParams.none(),
        ): CompletableFuture<HttpResponseFor<ItemListPageAsync>> =
            list(conversationId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: ItemListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ItemListPageAsync>>

        /** @see list */
        fun list(params: ItemListParams): CompletableFuture<HttpResponseFor<ItemListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            conversationId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ItemListPageAsync>> =
            list(conversationId, ItemListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /conversations/{conversation_id}/items/{item_id}`, but is otherwise the same as
         * [ItemServiceAsync.delete].
         */
        fun delete(
            itemId: String,
            params: ItemDeleteParams,
        ): CompletableFuture<HttpResponseFor<Conversation>> =
            delete(itemId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            itemId: String,
            params: ItemDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Conversation>> =
            delete(params.toBuilder().itemId(itemId).build(), requestOptions)

        /** @see delete */
        fun delete(params: ItemDeleteParams): CompletableFuture<HttpResponseFor<Conversation>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: ItemDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Conversation>>
    }
}
