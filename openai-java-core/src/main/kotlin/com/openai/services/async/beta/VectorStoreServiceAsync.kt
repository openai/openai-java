// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.vectorstores.VectorStore
import com.openai.models.beta.vectorstores.VectorStoreCreateParams
import com.openai.models.beta.vectorstores.VectorStoreDeleteParams
import com.openai.models.beta.vectorstores.VectorStoreDeleted
import com.openai.models.beta.vectorstores.VectorStoreListPageAsync
import com.openai.models.beta.vectorstores.VectorStoreListParams
import com.openai.models.beta.vectorstores.VectorStoreRetrieveParams
import com.openai.models.beta.vectorstores.VectorStoreUpdateParams
import com.openai.services.async.beta.vectorstores.FileBatchServiceAsync
import com.openai.services.async.beta.vectorstores.FileServiceAsync
import java.util.concurrent.CompletableFuture

interface VectorStoreServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun files(): FileServiceAsync

    fun fileBatches(): FileBatchServiceAsync

    /** Create a vector store. */
    fun create(params: VectorStoreCreateParams): CompletableFuture<VectorStore> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: VectorStoreCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStore>

    /** Retrieves a vector store. */
    fun retrieve(params: VectorStoreRetrieveParams): CompletableFuture<VectorStore> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: VectorStoreRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStore>

    /** Modifies a vector store. */
    fun update(params: VectorStoreUpdateParams): CompletableFuture<VectorStore> =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: VectorStoreUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStore>

    /** Returns a list of vector stores. */
    fun list(): CompletableFuture<VectorStoreListPageAsync> = list(VectorStoreListParams.none())

    /** @see [list] */
    fun list(
        params: VectorStoreListParams = VectorStoreListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreListPageAsync>

    /** @see [list] */
    fun list(
        params: VectorStoreListParams = VectorStoreListParams.none()
    ): CompletableFuture<VectorStoreListPageAsync> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<VectorStoreListPageAsync> =
        list(VectorStoreListParams.none(), requestOptions)

    /** Delete a vector store. */
    fun delete(params: VectorStoreDeleteParams): CompletableFuture<VectorStoreDeleted> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: VectorStoreDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreDeleted>

    /**
     * A view of [VectorStoreServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        fun files(): FileServiceAsync.WithRawResponse

        fun fileBatches(): FileBatchServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /vector_stores`, but is otherwise the same as
         * [VectorStoreServiceAsync.create].
         */
        @MustBeClosed
        fun create(
            params: VectorStoreCreateParams
        ): CompletableFuture<HttpResponseFor<VectorStore>> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: VectorStoreCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStore>>

        /**
         * Returns a raw HTTP response for `get /vector_stores/{vector_store_id}`, but is otherwise
         * the same as [VectorStoreServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: VectorStoreRetrieveParams
        ): CompletableFuture<HttpResponseFor<VectorStore>> = retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: VectorStoreRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStore>>

        /**
         * Returns a raw HTTP response for `post /vector_stores/{vector_store_id}`, but is otherwise
         * the same as [VectorStoreServiceAsync.update].
         */
        @MustBeClosed
        fun update(
            params: VectorStoreUpdateParams
        ): CompletableFuture<HttpResponseFor<VectorStore>> = update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: VectorStoreUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStore>>

        /**
         * Returns a raw HTTP response for `get /vector_stores`, but is otherwise the same as
         * [VectorStoreServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<VectorStoreListPageAsync>> =
            list(VectorStoreListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: VectorStoreListParams = VectorStoreListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: VectorStoreListParams = VectorStoreListParams.none()
        ): CompletableFuture<HttpResponseFor<VectorStoreListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<VectorStoreListPageAsync>> =
            list(VectorStoreListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /vector_stores/{vector_store_id}`, but is
         * otherwise the same as [VectorStoreServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(
            params: VectorStoreDeleteParams
        ): CompletableFuture<HttpResponseFor<VectorStoreDeleted>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: VectorStoreDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreDeleted>>
    }
}
