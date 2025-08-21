// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.conversations

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.conversations.Conversation
import com.openai.models.conversations.items.ConversationItem
import com.openai.models.conversations.items.ConversationItemList
import com.openai.models.conversations.items.ItemCreateParams
import com.openai.models.conversations.items.ItemDeleteParams
import com.openai.models.conversations.items.ItemListPage
import com.openai.models.conversations.items.ItemListParams
import com.openai.models.conversations.items.ItemRetrieveParams
import java.util.function.Consumer

interface ItemService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ItemService

    /** Create items in a conversation with the given ID. */
    fun create(conversationId: String, params: ItemCreateParams): ConversationItemList =
        create(conversationId, params, RequestOptions.none())

    /** @see create */
    fun create(
        conversationId: String,
        params: ItemCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationItemList =
        create(params.toBuilder().conversationId(conversationId).build(), requestOptions)

    /** @see create */
    fun create(params: ItemCreateParams): ConversationItemList =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ItemCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationItemList

    /** Get a single item from a conversation with the given IDs. */
    fun retrieve(itemId: String, params: ItemRetrieveParams): ConversationItem =
        retrieve(itemId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        itemId: String,
        params: ItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationItem = retrieve(params.toBuilder().itemId(itemId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: ItemRetrieveParams): ConversationItem =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationItem

    /** List all items for a conversation with the given ID. */
    fun list(conversationId: String): ItemListPage = list(conversationId, ItemListParams.none())

    /** @see list */
    fun list(
        conversationId: String,
        params: ItemListParams = ItemListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ItemListPage =
        list(params.toBuilder().conversationId(conversationId).build(), requestOptions)

    /** @see list */
    fun list(conversationId: String, params: ItemListParams = ItemListParams.none()): ItemListPage =
        list(conversationId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ItemListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ItemListPage

    /** @see list */
    fun list(params: ItemListParams): ItemListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(conversationId: String, requestOptions: RequestOptions): ItemListPage =
        list(conversationId, ItemListParams.none(), requestOptions)

    /** Delete an item from a conversation with the given IDs. */
    fun delete(itemId: String, params: ItemDeleteParams): Conversation =
        delete(itemId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        itemId: String,
        params: ItemDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Conversation = delete(params.toBuilder().itemId(itemId).build(), requestOptions)

    /** @see delete */
    fun delete(params: ItemDeleteParams): Conversation = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ItemDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Conversation

    /** A view of [ItemService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ItemService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /conversations/{conversation_id}/items`, but is
         * otherwise the same as [ItemService.create].
         */
        @MustBeClosed
        fun create(
            conversationId: String,
            params: ItemCreateParams,
        ): HttpResponseFor<ConversationItemList> =
            create(conversationId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            conversationId: String,
            params: ItemCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationItemList> =
            create(params.toBuilder().conversationId(conversationId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: ItemCreateParams): HttpResponseFor<ConversationItemList> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ItemCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationItemList>

        /**
         * Returns a raw HTTP response for `get /conversations/{conversation_id}/items/{item_id}`,
         * but is otherwise the same as [ItemService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            itemId: String,
            params: ItemRetrieveParams,
        ): HttpResponseFor<ConversationItem> = retrieve(itemId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            itemId: String,
            params: ItemRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationItem> =
            retrieve(params.toBuilder().itemId(itemId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ItemRetrieveParams): HttpResponseFor<ConversationItem> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ItemRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationItem>

        /**
         * Returns a raw HTTP response for `get /conversations/{conversation_id}/items`, but is
         * otherwise the same as [ItemService.list].
         */
        @MustBeClosed
        fun list(conversationId: String): HttpResponseFor<ItemListPage> =
            list(conversationId, ItemListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            conversationId: String,
            params: ItemListParams = ItemListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ItemListPage> =
            list(params.toBuilder().conversationId(conversationId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            conversationId: String,
            params: ItemListParams = ItemListParams.none(),
        ): HttpResponseFor<ItemListPage> = list(conversationId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ItemListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ItemListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: ItemListParams): HttpResponseFor<ItemListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            conversationId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ItemListPage> =
            list(conversationId, ItemListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /conversations/{conversation_id}/items/{item_id}`, but is otherwise the same as
         * [ItemService.delete].
         */
        @MustBeClosed
        fun delete(itemId: String, params: ItemDeleteParams): HttpResponseFor<Conversation> =
            delete(itemId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            itemId: String,
            params: ItemDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Conversation> =
            delete(params.toBuilder().itemId(itemId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: ItemDeleteParams): HttpResponseFor<Conversation> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ItemDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Conversation>
    }
}
