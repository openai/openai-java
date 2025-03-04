// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

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
    @JvmOverloads
    fun create(
        params: BetaVectorStoreCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStore>

    /** Retrieves a vector store. */
    @JvmOverloads
    fun retrieve(
        params: BetaVectorStoreRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStore>

    /** Modifies a vector store. */
    @JvmOverloads
    fun update(
        params: BetaVectorStoreUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStore>

    /** Returns a list of vector stores. */
    @JvmOverloads
    fun list(
        params: BetaVectorStoreListParams = BetaVectorStoreListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BetaVectorStoreListPageAsync>

    /** Returns a list of vector stores. */
    fun list(requestOptions: RequestOptions): CompletableFuture<BetaVectorStoreListPageAsync> =
        list(BetaVectorStoreListParams.none(), requestOptions)

    /** Delete a vector store. */
    @JvmOverloads
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
        @JvmOverloads
        @MustBeClosed
        fun create(
            params: BetaVectorStoreCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStore>>

        /**
         * Returns a raw HTTP response for `get /vector_stores/{vector_store_id}`, but is otherwise
         * the same as [VectorStoreServiceAsync.retrieve].
         */
        @JvmOverloads
        @MustBeClosed
        fun retrieve(
            params: BetaVectorStoreRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStore>>

        /**
         * Returns a raw HTTP response for `post /vector_stores/{vector_store_id}`, but is otherwise
         * the same as [VectorStoreServiceAsync.update].
         */
        @JvmOverloads
        @MustBeClosed
        fun update(
            params: BetaVectorStoreUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStore>>

        /**
         * Returns a raw HTTP response for `get /vector_stores`, but is otherwise the same as
         * [VectorStoreServiceAsync.list].
         */
        @JvmOverloads
        @MustBeClosed
        fun list(
            params: BetaVectorStoreListParams = BetaVectorStoreListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BetaVectorStoreListPageAsync>>

        /**
         * Returns a raw HTTP response for `get /vector_stores`, but is otherwise the same as
         * [VectorStoreServiceAsync.list].
         */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<BetaVectorStoreListPageAsync>> =
            list(BetaVectorStoreListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /vector_stores/{vector_store_id}`, but is
         * otherwise the same as [VectorStoreServiceAsync.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: BetaVectorStoreDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreDeleted>>
    }
}
