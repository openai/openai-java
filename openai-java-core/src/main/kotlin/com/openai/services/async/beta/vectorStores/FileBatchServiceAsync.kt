// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.vectorStores

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.BetaVectorStoreFileBatchCancelParams
import com.openai.models.BetaVectorStoreFileBatchCreateParams
import com.openai.models.BetaVectorStoreFileBatchListFilesPageAsync
import com.openai.models.BetaVectorStoreFileBatchListFilesParams
import com.openai.models.BetaVectorStoreFileBatchRetrieveParams
import com.openai.models.VectorStoreFileBatch
import java.util.concurrent.CompletableFuture

interface FileBatchServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Create a vector store file batch. */
    fun create(
        params: BetaVectorStoreFileBatchCreateParams
    ): CompletableFuture<VectorStoreFileBatch> = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: BetaVectorStoreFileBatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreFileBatch>

    /** Retrieves a vector store file batch. */
    fun retrieve(
        params: BetaVectorStoreFileBatchRetrieveParams
    ): CompletableFuture<VectorStoreFileBatch> = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: BetaVectorStoreFileBatchRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreFileBatch>

    /**
     * Cancel a vector store file batch. This attempts to cancel the processing of files in this
     * batch as soon as possible.
     */
    fun cancel(
        params: BetaVectorStoreFileBatchCancelParams
    ): CompletableFuture<VectorStoreFileBatch> = cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: BetaVectorStoreFileBatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreFileBatch>

    /** Returns a list of vector store files in a batch. */
    fun listFiles(
        params: BetaVectorStoreFileBatchListFilesParams
    ): CompletableFuture<BetaVectorStoreFileBatchListFilesPageAsync> =
        listFiles(params, RequestOptions.none())

    /** @see [listFiles] */
    fun listFiles(
        params: BetaVectorStoreFileBatchListFilesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BetaVectorStoreFileBatchListFilesPageAsync>

    /**
     * A view of [FileBatchServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /vector_stores/{vector_store_id}/file_batches`, but
         * is otherwise the same as [FileBatchServiceAsync.create].
         */
        @MustBeClosed
        fun create(
            params: BetaVectorStoreFileBatchCreateParams
        ): CompletableFuture<HttpResponseFor<VectorStoreFileBatch>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BetaVectorStoreFileBatchCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreFileBatch>>

        /**
         * Returns a raw HTTP response for `get
         * /vector_stores/{vector_store_id}/file_batches/{batch_id}`, but is otherwise the same as
         * [FileBatchServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: BetaVectorStoreFileBatchRetrieveParams
        ): CompletableFuture<HttpResponseFor<VectorStoreFileBatch>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: BetaVectorStoreFileBatchRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreFileBatch>>

        /**
         * Returns a raw HTTP response for `post
         * /vector_stores/{vector_store_id}/file_batches/{batch_id}/cancel`, but is otherwise the
         * same as [FileBatchServiceAsync.cancel].
         */
        @MustBeClosed
        fun cancel(
            params: BetaVectorStoreFileBatchCancelParams
        ): CompletableFuture<HttpResponseFor<VectorStoreFileBatch>> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: BetaVectorStoreFileBatchCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreFileBatch>>

        /**
         * Returns a raw HTTP response for `get
         * /vector_stores/{vector_store_id}/file_batches/{batch_id}/files`, but is otherwise the
         * same as [FileBatchServiceAsync.listFiles].
         */
        @MustBeClosed
        fun listFiles(
            params: BetaVectorStoreFileBatchListFilesParams
        ): CompletableFuture<HttpResponseFor<BetaVectorStoreFileBatchListFilesPageAsync>> =
            listFiles(params, RequestOptions.none())

        /** @see [listFiles] */
        @MustBeClosed
        fun listFiles(
            params: BetaVectorStoreFileBatchListFilesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BetaVectorStoreFileBatchListFilesPageAsync>>
    }
}
