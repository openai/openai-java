// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

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
    @JvmOverloads
    fun create(
        params: BetaVectorStoreFileBatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreFileBatch>

    /** Retrieves a vector store file batch. */
    @JvmOverloads
    fun retrieve(
        params: BetaVectorStoreFileBatchRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreFileBatch>

    /**
     * Cancel a vector store file batch. This attempts to cancel the processing of files in this
     * batch as soon as possible.
     */
    @JvmOverloads
    fun cancel(
        params: BetaVectorStoreFileBatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreFileBatch>

    /** Returns a list of vector store files in a batch. */
    @JvmOverloads
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
        @JvmOverloads
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
        @JvmOverloads
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
        @JvmOverloads
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
        @JvmOverloads
        @MustBeClosed
        fun listFiles(
            params: BetaVectorStoreFileBatchListFilesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BetaVectorStoreFileBatchListFilesPageAsync>>
    }
}
