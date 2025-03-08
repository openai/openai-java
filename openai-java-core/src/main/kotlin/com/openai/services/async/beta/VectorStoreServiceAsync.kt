// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.BetaVectorStoreCreateParams
import com.openai.models.BetaVectorStoreDeleteParams
import com.openai.models.BetaVectorStoreListPageAsync
import com.openai.models.BetaVectorStoreListParams
import com.openai.models.BetaVectorStoreRetrieveParams
import com.openai.models.BetaVectorStoreUpdateParams
import com.openai.models.VectorStore
import com.openai.models.VectorStoreDeleted
import com.openai.services.async.beta.vectorStores.FileBatchServiceAsync
import com.openai.services.async.beta.vectorStores.FileServiceAsync
import java.util.concurrent.CompletableFuture

interface VectorStoreServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun files(): FileServiceAsync

    fun fileBatches(): FileBatchServiceAsync

    /** Create a vector store. */
    fun create(params: BetaVectorStoreCreateParams): CompletableFuture<VectorStore> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: BetaVectorStoreCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStore>

    /** Retrieves a vector store. */
    fun retrieve(params: BetaVectorStoreRetrieveParams): CompletableFuture<VectorStore> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: BetaVectorStoreRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStore>

    /** Modifies a vector store. */
    fun update(params: BetaVectorStoreUpdateParams): CompletableFuture<VectorStore> =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: BetaVectorStoreUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStore>

    /** Returns a list of vector stores. */
    fun list(): CompletableFuture<BetaVectorStoreListPageAsync> =
        list(BetaVectorStoreListParams.none())

    /** @see [list] */
    fun list(
        params: BetaVectorStoreListParams = BetaVectorStoreListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BetaVectorStoreListPageAsync>

    /** @see [list] */
    fun list(
        params: BetaVectorStoreListParams = BetaVectorStoreListParams.none()
    ): CompletableFuture<BetaVectorStoreListPageAsync> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<BetaVectorStoreListPageAsync> =
        list(BetaVectorStoreListParams.none(), requestOptions)

    /** Delete a vector store. */
    fun delete(params: BetaVectorStoreDeleteParams): CompletableFuture<VectorStoreDeleted> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: BetaVectorStoreDeleteParams,
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
            params: BetaVectorStoreCreateParams
        ): CompletableFuture<HttpResponseFor<VectorStore>> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BetaVectorStoreCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStore>>

        /**
         * Returns a raw HTTP response for `get /vector_stores/{vector_store_id}`, but is otherwise
         * the same as [VectorStoreServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: BetaVectorStoreRetrieveParams
        ): CompletableFuture<HttpResponseFor<VectorStore>> = retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: BetaVectorStoreRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStore>>

        /**
         * Returns a raw HTTP response for `post /vector_stores/{vector_store_id}`, but is otherwise
         * the same as [VectorStoreServiceAsync.update].
         */
        @MustBeClosed
        fun update(
            params: BetaVectorStoreUpdateParams
        ): CompletableFuture<HttpResponseFor<VectorStore>> = update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: BetaVectorStoreUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStore>>

        /**
         * Returns a raw HTTP response for `get /vector_stores`, but is otherwise the same as
         * [VectorStoreServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<BetaVectorStoreListPageAsync>> =
            list(BetaVectorStoreListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: BetaVectorStoreListParams = BetaVectorStoreListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BetaVectorStoreListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: BetaVectorStoreListParams = BetaVectorStoreListParams.none()
        ): CompletableFuture<HttpResponseFor<BetaVectorStoreListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<BetaVectorStoreListPageAsync>> =
            list(BetaVectorStoreListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /vector_stores/{vector_store_id}`, but is
         * otherwise the same as [VectorStoreServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(
            params: BetaVectorStoreDeleteParams
        ): CompletableFuture<HttpResponseFor<VectorStoreDeleted>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: BetaVectorStoreDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreDeleted>>
    }
}
