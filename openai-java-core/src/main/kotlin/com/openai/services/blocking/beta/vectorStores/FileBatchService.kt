// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.vectorStores

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.BetaVectorStoreFileBatchCancelParams
import com.openai.models.BetaVectorStoreFileBatchCreateParams
import com.openai.models.BetaVectorStoreFileBatchListFilesPage
import com.openai.models.BetaVectorStoreFileBatchListFilesParams
import com.openai.models.BetaVectorStoreFileBatchRetrieveParams
import com.openai.models.VectorStoreFileBatch

interface FileBatchService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Create a vector store file batch. */
    fun create(params: BetaVectorStoreFileBatchCreateParams): VectorStoreFileBatch =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: BetaVectorStoreFileBatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFileBatch

    /** Retrieves a vector store file batch. */
    fun retrieve(params: BetaVectorStoreFileBatchRetrieveParams): VectorStoreFileBatch =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: BetaVectorStoreFileBatchRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFileBatch

    /**
     * Cancel a vector store file batch. This attempts to cancel the processing of files in this
     * batch as soon as possible.
     */
    fun cancel(params: BetaVectorStoreFileBatchCancelParams): VectorStoreFileBatch =
        cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: BetaVectorStoreFileBatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFileBatch

    /** Returns a list of vector store files in a batch. */
    fun listFiles(
        params: BetaVectorStoreFileBatchListFilesParams
    ): BetaVectorStoreFileBatchListFilesPage = listFiles(params, RequestOptions.none())

    /** @see [listFiles] */
    fun listFiles(
        params: BetaVectorStoreFileBatchListFilesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaVectorStoreFileBatchListFilesPage

    /** A view of [FileBatchService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /vector_stores/{vector_store_id}/file_batches`, but
         * is otherwise the same as [FileBatchService.create].
         */
        @MustBeClosed
        fun create(
            params: BetaVectorStoreFileBatchCreateParams
        ): HttpResponseFor<VectorStoreFileBatch> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BetaVectorStoreFileBatchCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreFileBatch>

        /**
         * Returns a raw HTTP response for `get
         * /vector_stores/{vector_store_id}/file_batches/{batch_id}`, but is otherwise the same as
         * [FileBatchService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: BetaVectorStoreFileBatchRetrieveParams
        ): HttpResponseFor<VectorStoreFileBatch> = retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: BetaVectorStoreFileBatchRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreFileBatch>

        /**
         * Returns a raw HTTP response for `post
         * /vector_stores/{vector_store_id}/file_batches/{batch_id}/cancel`, but is otherwise the
         * same as [FileBatchService.cancel].
         */
        @MustBeClosed
        fun cancel(
            params: BetaVectorStoreFileBatchCancelParams
        ): HttpResponseFor<VectorStoreFileBatch> = cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: BetaVectorStoreFileBatchCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreFileBatch>

        /**
         * Returns a raw HTTP response for `get
         * /vector_stores/{vector_store_id}/file_batches/{batch_id}/files`, but is otherwise the
         * same as [FileBatchService.listFiles].
         */
        @MustBeClosed
        fun listFiles(
            params: BetaVectorStoreFileBatchListFilesParams
        ): HttpResponseFor<BetaVectorStoreFileBatchListFilesPage> =
            listFiles(params, RequestOptions.none())

        /** @see [listFiles] */
        @MustBeClosed
        fun listFiles(
            params: BetaVectorStoreFileBatchListFilesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaVectorStoreFileBatchListFilesPage>
    }
}
