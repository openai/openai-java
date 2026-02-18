// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.chatkit

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.chatkit.threads.ChatKitThread
import com.openai.models.beta.chatkit.threads.ThreadDeleteParams
import com.openai.models.beta.chatkit.threads.ThreadDeleteResponse
import com.openai.models.beta.chatkit.threads.ThreadListItemsPageAsync
import com.openai.models.beta.chatkit.threads.ThreadListItemsParams
import com.openai.models.beta.chatkit.threads.ThreadListPageAsync
import com.openai.models.beta.chatkit.threads.ThreadListParams
import com.openai.models.beta.chatkit.threads.ThreadRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ThreadServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ThreadServiceAsync

    /** Retrieve a ChatKit thread by its identifier. */
    fun retrieve(threadId: String): CompletableFuture<ChatKitThread> =
        retrieve(threadId, ThreadRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        threadId: String,
        params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatKitThread> =
        retrieve(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        threadId: String,
        params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
    ): CompletableFuture<ChatKitThread> = retrieve(threadId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ThreadRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatKitThread>

    /** @see retrieve */
    fun retrieve(params: ThreadRetrieveParams): CompletableFuture<ChatKitThread> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        threadId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ChatKitThread> =
        retrieve(threadId, ThreadRetrieveParams.none(), requestOptions)

    /** List ChatKit threads with optional pagination and user filters. */
    fun list(): CompletableFuture<ThreadListPageAsync> = list(ThreadListParams.none())

    /** @see list */
    fun list(
        params: ThreadListParams = ThreadListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ThreadListPageAsync>

    /** @see list */
    fun list(
        params: ThreadListParams = ThreadListParams.none()
    ): CompletableFuture<ThreadListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<ThreadListPageAsync> =
        list(ThreadListParams.none(), requestOptions)

    /** Delete a ChatKit thread along with its items and stored attachments. */
    fun delete(threadId: String): CompletableFuture<ThreadDeleteResponse> =
        delete(threadId, ThreadDeleteParams.none())

    /** @see delete */
    fun delete(
        threadId: String,
        params: ThreadDeleteParams = ThreadDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ThreadDeleteResponse> =
        delete(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see delete */
    fun delete(
        threadId: String,
        params: ThreadDeleteParams = ThreadDeleteParams.none(),
    ): CompletableFuture<ThreadDeleteResponse> = delete(threadId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ThreadDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ThreadDeleteResponse>

    /** @see delete */
    fun delete(params: ThreadDeleteParams): CompletableFuture<ThreadDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        threadId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ThreadDeleteResponse> =
        delete(threadId, ThreadDeleteParams.none(), requestOptions)

    /** List items that belong to a ChatKit thread. */
    fun listItems(threadId: String): CompletableFuture<ThreadListItemsPageAsync> =
        listItems(threadId, ThreadListItemsParams.none())

    /** @see listItems */
    fun listItems(
        threadId: String,
        params: ThreadListItemsParams = ThreadListItemsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ThreadListItemsPageAsync> =
        listItems(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see listItems */
    fun listItems(
        threadId: String,
        params: ThreadListItemsParams = ThreadListItemsParams.none(),
    ): CompletableFuture<ThreadListItemsPageAsync> =
        listItems(threadId, params, RequestOptions.none())

    /** @see listItems */
    fun listItems(
        params: ThreadListItemsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ThreadListItemsPageAsync>

    /** @see listItems */
    fun listItems(params: ThreadListItemsParams): CompletableFuture<ThreadListItemsPageAsync> =
        listItems(params, RequestOptions.none())

    /** @see listItems */
    fun listItems(
        threadId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ThreadListItemsPageAsync> =
        listItems(threadId, ThreadListItemsParams.none(), requestOptions)

    /**
     * A view of [ThreadServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ThreadServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /chatkit/threads/{thread_id}`, but is otherwise the
         * same as [ThreadServiceAsync.retrieve].
         */
        fun retrieve(threadId: String): CompletableFuture<HttpResponseFor<ChatKitThread>> =
            retrieve(threadId, ThreadRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            threadId: String,
            params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatKitThread>> =
            retrieve(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            threadId: String,
            params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ChatKitThread>> =
            retrieve(threadId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ThreadRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ChatKitThread>>

        /** @see retrieve */
        fun retrieve(
            params: ThreadRetrieveParams
        ): CompletableFuture<HttpResponseFor<ChatKitThread>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            threadId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ChatKitThread>> =
            retrieve(threadId, ThreadRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /chatkit/threads`, but is otherwise the same as
         * [ThreadServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<ThreadListPageAsync>> =
            list(ThreadListParams.none())

        /** @see list */
        fun list(
            params: ThreadListParams = ThreadListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ThreadListPageAsync>>

        /** @see list */
        fun list(
            params: ThreadListParams = ThreadListParams.none()
        ): CompletableFuture<HttpResponseFor<ThreadListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ThreadListPageAsync>> =
            list(ThreadListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /chatkit/threads/{thread_id}`, but is otherwise
         * the same as [ThreadServiceAsync.delete].
         */
        fun delete(threadId: String): CompletableFuture<HttpResponseFor<ThreadDeleteResponse>> =
            delete(threadId, ThreadDeleteParams.none())

        /** @see delete */
        fun delete(
            threadId: String,
            params: ThreadDeleteParams = ThreadDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ThreadDeleteResponse>> =
            delete(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see delete */
        fun delete(
            threadId: String,
            params: ThreadDeleteParams = ThreadDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<ThreadDeleteResponse>> =
            delete(threadId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: ThreadDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ThreadDeleteResponse>>

        /** @see delete */
        fun delete(
            params: ThreadDeleteParams
        ): CompletableFuture<HttpResponseFor<ThreadDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            threadId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ThreadDeleteResponse>> =
            delete(threadId, ThreadDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /chatkit/threads/{thread_id}/items`, but is
         * otherwise the same as [ThreadServiceAsync.listItems].
         */
        fun listItems(
            threadId: String
        ): CompletableFuture<HttpResponseFor<ThreadListItemsPageAsync>> =
            listItems(threadId, ThreadListItemsParams.none())

        /** @see listItems */
        fun listItems(
            threadId: String,
            params: ThreadListItemsParams = ThreadListItemsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ThreadListItemsPageAsync>> =
            listItems(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see listItems */
        fun listItems(
            threadId: String,
            params: ThreadListItemsParams = ThreadListItemsParams.none(),
        ): CompletableFuture<HttpResponseFor<ThreadListItemsPageAsync>> =
            listItems(threadId, params, RequestOptions.none())

        /** @see listItems */
        fun listItems(
            params: ThreadListItemsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ThreadListItemsPageAsync>>

        /** @see listItems */
        fun listItems(
            params: ThreadListItemsParams
        ): CompletableFuture<HttpResponseFor<ThreadListItemsPageAsync>> =
            listItems(params, RequestOptions.none())

        /** @see listItems */
        fun listItems(
            threadId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ThreadListItemsPageAsync>> =
            listItems(threadId, ThreadListItemsParams.none(), requestOptions)
    }
}
