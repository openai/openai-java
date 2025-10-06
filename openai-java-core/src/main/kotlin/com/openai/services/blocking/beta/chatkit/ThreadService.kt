// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.chatkit

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.chatkit.threads.ChatKitThread
import com.openai.models.beta.chatkit.threads.ThreadDeleteParams
import com.openai.models.beta.chatkit.threads.ThreadDeleteResponse
import com.openai.models.beta.chatkit.threads.ThreadListItemsPage
import com.openai.models.beta.chatkit.threads.ThreadListItemsParams
import com.openai.models.beta.chatkit.threads.ThreadListPage
import com.openai.models.beta.chatkit.threads.ThreadListParams
import com.openai.models.beta.chatkit.threads.ThreadRetrieveParams
import java.util.function.Consumer

interface ThreadService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ThreadService

    /** Retrieve a ChatKit thread */
    fun retrieve(threadId: String): ChatKitThread = retrieve(threadId, ThreadRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        threadId: String,
        params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatKitThread = retrieve(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        threadId: String,
        params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
    ): ChatKitThread = retrieve(threadId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ThreadRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatKitThread

    /** @see retrieve */
    fun retrieve(params: ThreadRetrieveParams): ChatKitThread =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(threadId: String, requestOptions: RequestOptions): ChatKitThread =
        retrieve(threadId, ThreadRetrieveParams.none(), requestOptions)

    /** List ChatKit threads */
    fun list(): ThreadListPage = list(ThreadListParams.none())

    /** @see list */
    fun list(
        params: ThreadListParams = ThreadListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ThreadListPage

    /** @see list */
    fun list(params: ThreadListParams = ThreadListParams.none()): ThreadListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): ThreadListPage =
        list(ThreadListParams.none(), requestOptions)

    /** Delete a ChatKit thread */
    fun delete(threadId: String): ThreadDeleteResponse = delete(threadId, ThreadDeleteParams.none())

    /** @see delete */
    fun delete(
        threadId: String,
        params: ThreadDeleteParams = ThreadDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ThreadDeleteResponse = delete(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see delete */
    fun delete(
        threadId: String,
        params: ThreadDeleteParams = ThreadDeleteParams.none(),
    ): ThreadDeleteResponse = delete(threadId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ThreadDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ThreadDeleteResponse

    /** @see delete */
    fun delete(params: ThreadDeleteParams): ThreadDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(threadId: String, requestOptions: RequestOptions): ThreadDeleteResponse =
        delete(threadId, ThreadDeleteParams.none(), requestOptions)

    /** List ChatKit thread items */
    fun listItems(threadId: String): ThreadListItemsPage =
        listItems(threadId, ThreadListItemsParams.none())

    /** @see listItems */
    fun listItems(
        threadId: String,
        params: ThreadListItemsParams = ThreadListItemsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ThreadListItemsPage =
        listItems(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see listItems */
    fun listItems(
        threadId: String,
        params: ThreadListItemsParams = ThreadListItemsParams.none(),
    ): ThreadListItemsPage = listItems(threadId, params, RequestOptions.none())

    /** @see listItems */
    fun listItems(
        params: ThreadListItemsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ThreadListItemsPage

    /** @see listItems */
    fun listItems(params: ThreadListItemsParams): ThreadListItemsPage =
        listItems(params, RequestOptions.none())

    /** @see listItems */
    fun listItems(threadId: String, requestOptions: RequestOptions): ThreadListItemsPage =
        listItems(threadId, ThreadListItemsParams.none(), requestOptions)

    /** A view of [ThreadService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ThreadService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /chatkit/threads/{thread_id}`, but is otherwise the
         * same as [ThreadService.retrieve].
         */
        @MustBeClosed
        fun retrieve(threadId: String): HttpResponseFor<ChatKitThread> =
            retrieve(threadId, ThreadRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            threadId: String,
            params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatKitThread> =
            retrieve(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            threadId: String,
            params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
        ): HttpResponseFor<ChatKitThread> = retrieve(threadId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ThreadRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChatKitThread>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ThreadRetrieveParams): HttpResponseFor<ChatKitThread> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            threadId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChatKitThread> =
            retrieve(threadId, ThreadRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /chatkit/threads`, but is otherwise the same as
         * [ThreadService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<ThreadListPage> = list(ThreadListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ThreadListParams = ThreadListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ThreadListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: ThreadListParams = ThreadListParams.none()
        ): HttpResponseFor<ThreadListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ThreadListPage> =
            list(ThreadListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /chatkit/threads/{thread_id}`, but is otherwise
         * the same as [ThreadService.delete].
         */
        @MustBeClosed
        fun delete(threadId: String): HttpResponseFor<ThreadDeleteResponse> =
            delete(threadId, ThreadDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            threadId: String,
            params: ThreadDeleteParams = ThreadDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ThreadDeleteResponse> =
            delete(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            threadId: String,
            params: ThreadDeleteParams = ThreadDeleteParams.none(),
        ): HttpResponseFor<ThreadDeleteResponse> = delete(threadId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ThreadDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ThreadDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(params: ThreadDeleteParams): HttpResponseFor<ThreadDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            threadId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ThreadDeleteResponse> =
            delete(threadId, ThreadDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /chatkit/threads/{thread_id}/items`, but is
         * otherwise the same as [ThreadService.listItems].
         */
        @MustBeClosed
        fun listItems(threadId: String): HttpResponseFor<ThreadListItemsPage> =
            listItems(threadId, ThreadListItemsParams.none())

        /** @see listItems */
        @MustBeClosed
        fun listItems(
            threadId: String,
            params: ThreadListItemsParams = ThreadListItemsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ThreadListItemsPage> =
            listItems(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see listItems */
        @MustBeClosed
        fun listItems(
            threadId: String,
            params: ThreadListItemsParams = ThreadListItemsParams.none(),
        ): HttpResponseFor<ThreadListItemsPage> = listItems(threadId, params, RequestOptions.none())

        /** @see listItems */
        @MustBeClosed
        fun listItems(
            params: ThreadListItemsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ThreadListItemsPage>

        /** @see listItems */
        @MustBeClosed
        fun listItems(params: ThreadListItemsParams): HttpResponseFor<ThreadListItemsPage> =
            listItems(params, RequestOptions.none())

        /** @see listItems */
        @MustBeClosed
        fun listItems(
            threadId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ThreadListItemsPage> =
            listItems(threadId, ThreadListItemsParams.none(), requestOptions)
    }
}
