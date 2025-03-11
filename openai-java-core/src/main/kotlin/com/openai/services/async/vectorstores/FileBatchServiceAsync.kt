// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.vectorstores

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.vectorstores.filebatches.FileBatchCancelParams
import com.openai.models.vectorstores.filebatches.FileBatchCreateParams
import com.openai.models.vectorstores.filebatches.FileBatchListFilesPageAsync
import com.openai.models.vectorstores.filebatches.FileBatchListFilesParams
import com.openai.models.vectorstores.filebatches.FileBatchRetrieveParams
import com.openai.models.vectorstores.filebatches.VectorStoreFileBatch
import java.util.concurrent.CompletableFuture

interface FileBatchServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Create a vector store file batch. */
    fun create(params: FileBatchCreateParams): CompletableFuture<VectorStoreFileBatch> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: FileBatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreFileBatch>

    /** Retrieves a vector store file batch. */
    fun retrieve(params: FileBatchRetrieveParams): CompletableFuture<VectorStoreFileBatch> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: FileBatchRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreFileBatch>

    /**
     * Cancel a vector store file batch. This attempts to cancel the processing of files in this
     * batch as soon as possible.
     */
    fun cancel(params: FileBatchCancelParams): CompletableFuture<VectorStoreFileBatch> =
        cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: FileBatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreFileBatch>

    /** Returns a list of vector store files in a batch. */
    fun listFiles(
        params: FileBatchListFilesParams
    ): CompletableFuture<FileBatchListFilesPageAsync> = listFiles(params, RequestOptions.none())

    /** @see [listFiles] */
    fun listFiles(
        params: FileBatchListFilesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileBatchListFilesPageAsync>

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
            params: FileBatchCreateParams
        ): CompletableFuture<HttpResponseFor<VectorStoreFileBatch>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: FileBatchCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreFileBatch>>

        /**
         * Returns a raw HTTP response for `get
         * /vector_stores/{vector_store_id}/file_batches/{batch_id}`, but is otherwise the same as
         * [FileBatchServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: FileBatchRetrieveParams
        ): CompletableFuture<HttpResponseFor<VectorStoreFileBatch>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: FileBatchRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreFileBatch>>

        /**
         * Returns a raw HTTP response for `post
         * /vector_stores/{vector_store_id}/file_batches/{batch_id}/cancel`, but is otherwise the
         * same as [FileBatchServiceAsync.cancel].
         */
        @MustBeClosed
        fun cancel(
            params: FileBatchCancelParams
        ): CompletableFuture<HttpResponseFor<VectorStoreFileBatch>> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: FileBatchCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreFileBatch>>

        /**
         * Returns a raw HTTP response for `get
         * /vector_stores/{vector_store_id}/file_batches/{batch_id}/files`, but is otherwise the
         * same as [FileBatchServiceAsync.listFiles].
         */
        @MustBeClosed
        fun listFiles(
            params: FileBatchListFilesParams
        ): CompletableFuture<HttpResponseFor<FileBatchListFilesPageAsync>> =
            listFiles(params, RequestOptions.none())

        /** @see [listFiles] */
        @MustBeClosed
        fun listFiles(
            params: FileBatchListFilesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileBatchListFilesPageAsync>>
    }
}
