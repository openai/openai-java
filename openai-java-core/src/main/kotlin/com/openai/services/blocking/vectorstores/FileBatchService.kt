// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.vectorstores

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.vectorstores.filebatches.FileBatchCancelParams
import com.openai.models.vectorstores.filebatches.FileBatchCreateParams
import com.openai.models.vectorstores.filebatches.FileBatchListFilesPage
import com.openai.models.vectorstores.filebatches.FileBatchListFilesParams
import com.openai.models.vectorstores.filebatches.FileBatchRetrieveParams
import com.openai.models.vectorstores.filebatches.VectorStoreFileBatch
import java.util.function.Consumer

interface FileBatchService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileBatchService

    /** Create a vector store file batch. */
    fun create(vectorStoreId: String, params: FileBatchCreateParams): VectorStoreFileBatch =
        create(vectorStoreId, params, RequestOptions.none())

    /** @see create */
    fun create(
        vectorStoreId: String,
        params: FileBatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFileBatch =
        create(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

    /** @see create */
    fun create(params: FileBatchCreateParams): VectorStoreFileBatch =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: FileBatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFileBatch

    /** Retrieves a vector store file batch. */
    fun retrieve(batchId: String, params: FileBatchRetrieveParams): VectorStoreFileBatch =
        retrieve(batchId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        batchId: String,
        params: FileBatchRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFileBatch = retrieve(params.toBuilder().batchId(batchId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: FileBatchRetrieveParams): VectorStoreFileBatch =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: FileBatchRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFileBatch

    /**
     * Cancel a vector store file batch. This attempts to cancel the processing of files in this
     * batch as soon as possible.
     */
    fun cancel(batchId: String, params: FileBatchCancelParams): VectorStoreFileBatch =
        cancel(batchId, params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        batchId: String,
        params: FileBatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFileBatch = cancel(params.toBuilder().batchId(batchId).build(), requestOptions)

    /** @see cancel */
    fun cancel(params: FileBatchCancelParams): VectorStoreFileBatch =
        cancel(params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        params: FileBatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFileBatch

    /** Returns a list of vector store files in a batch. */
    fun listFiles(batchId: String, params: FileBatchListFilesParams): FileBatchListFilesPage =
        listFiles(batchId, params, RequestOptions.none())

    /** @see listFiles */
    fun listFiles(
        batchId: String,
        params: FileBatchListFilesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileBatchListFilesPage =
        listFiles(params.toBuilder().batchId(batchId).build(), requestOptions)

    /** @see listFiles */
    fun listFiles(params: FileBatchListFilesParams): FileBatchListFilesPage =
        listFiles(params, RequestOptions.none())

    /** @see listFiles */
    fun listFiles(
        params: FileBatchListFilesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileBatchListFilesPage

    /** A view of [FileBatchService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileBatchService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /vector_stores/{vector_store_id}/file_batches`, but
         * is otherwise the same as [FileBatchService.create].
         */
        @MustBeClosed
        fun create(
            vectorStoreId: String,
            params: FileBatchCreateParams,
        ): HttpResponseFor<VectorStoreFileBatch> =
            create(vectorStoreId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            vectorStoreId: String,
            params: FileBatchCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreFileBatch> =
            create(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: FileBatchCreateParams): HttpResponseFor<VectorStoreFileBatch> =
            create(params, RequestOptions.none())

        /** @see create */
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
        fun retrieve(
            batchId: String,
            params: FileBatchRetrieveParams,
        ): HttpResponseFor<VectorStoreFileBatch> = retrieve(batchId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            batchId: String,
            params: FileBatchRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreFileBatch> =
            retrieve(params.toBuilder().batchId(batchId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: FileBatchRetrieveParams): HttpResponseFor<VectorStoreFileBatch> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
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
        fun cancel(
            batchId: String,
            params: FileBatchCancelParams,
        ): HttpResponseFor<VectorStoreFileBatch> = cancel(batchId, params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            batchId: String,
            params: FileBatchCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreFileBatch> =
            cancel(params.toBuilder().batchId(batchId).build(), requestOptions)

        /** @see cancel */
        @MustBeClosed
        fun cancel(params: FileBatchCancelParams): HttpResponseFor<VectorStoreFileBatch> =
            cancel(params, RequestOptions.none())

        /** @see cancel */
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
        fun listFiles(
            batchId: String,
            params: FileBatchListFilesParams,
        ): HttpResponseFor<FileBatchListFilesPage> =
            listFiles(batchId, params, RequestOptions.none())

        /** @see listFiles */
        @MustBeClosed
        fun listFiles(
            batchId: String,
            params: FileBatchListFilesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileBatchListFilesPage> =
            listFiles(params.toBuilder().batchId(batchId).build(), requestOptions)

        /** @see listFiles */
        @MustBeClosed
        fun listFiles(params: FileBatchListFilesParams): HttpResponseFor<FileBatchListFilesPage> =
            listFiles(params, RequestOptions.none())

        /** @see listFiles */
        @MustBeClosed
        fun listFiles(
            params: FileBatchListFilesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileBatchListFilesPage>
    }
}
