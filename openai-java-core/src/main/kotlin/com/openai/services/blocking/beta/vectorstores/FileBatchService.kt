// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.vectorstores

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.vectorstores.filebatches.FileBatchCancelParams
import com.openai.models.beta.vectorstores.filebatches.FileBatchCreateParams
import com.openai.models.beta.vectorstores.filebatches.FileBatchListFilesPage
import com.openai.models.beta.vectorstores.filebatches.FileBatchListFilesParams
import com.openai.models.beta.vectorstores.filebatches.FileBatchRetrieveParams
import com.openai.models.beta.vectorstores.filebatches.VectorStoreFileBatch

interface FileBatchService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Create a vector store file batch. */
    fun create(params: FileBatchCreateParams): VectorStoreFileBatch =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: FileBatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFileBatch

    /** Retrieves a vector store file batch. */
    fun retrieve(params: FileBatchRetrieveParams): VectorStoreFileBatch =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: FileBatchRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFileBatch

    /**
     * Cancel a vector store file batch. This attempts to cancel the processing of files in this
     * batch as soon as possible.
     */
    fun cancel(params: FileBatchCancelParams): VectorStoreFileBatch =
        cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: FileBatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFileBatch

    /** Returns a list of vector store files in a batch. */
    fun listFiles(params: FileBatchListFilesParams): FileBatchListFilesPage =
        listFiles(params, RequestOptions.none())

    /** @see [listFiles] */
    fun listFiles(
        params: FileBatchListFilesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileBatchListFilesPage

    /** A view of [FileBatchService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /vector_stores/{vector_store_id}/file_batches`, but
         * is otherwise the same as [FileBatchService.create].
         */
        @MustBeClosed
        fun create(params: FileBatchCreateParams): HttpResponseFor<VectorStoreFileBatch> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: FileBatchCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreFileBatch>

        /**
         * Returns a raw HTTP response for `get
         * /vector_stores/{vector_store_id}/file_batches/{batch_id}`, but is otherwise the same as
         * [FileBatchService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: FileBatchRetrieveParams): HttpResponseFor<VectorStoreFileBatch> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: FileBatchRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreFileBatch>

        /**
         * Returns a raw HTTP response for `post
         * /vector_stores/{vector_store_id}/file_batches/{batch_id}/cancel`, but is otherwise the
         * same as [FileBatchService.cancel].
         */
        @MustBeClosed
        fun cancel(params: FileBatchCancelParams): HttpResponseFor<VectorStoreFileBatch> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: FileBatchCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreFileBatch>

        /**
         * Returns a raw HTTP response for `get
         * /vector_stores/{vector_store_id}/file_batches/{batch_id}/files`, but is otherwise the
         * same as [FileBatchService.listFiles].
         */
        @MustBeClosed
        fun listFiles(params: FileBatchListFilesParams): HttpResponseFor<FileBatchListFilesPage> =
            listFiles(params, RequestOptions.none())

        /** @see [listFiles] */
        @MustBeClosed
        fun listFiles(
            params: FileBatchListFilesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileBatchListFilesPage>
    }
}
