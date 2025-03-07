// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.BetaVectorStoreCreateParams
import com.openai.models.BetaVectorStoreDeleteParams
import com.openai.models.BetaVectorStoreListPage
import com.openai.models.BetaVectorStoreListParams
import com.openai.models.BetaVectorStoreRetrieveParams
import com.openai.models.BetaVectorStoreUpdateParams
import com.openai.models.VectorStore
import com.openai.models.VectorStoreDeleted
import com.openai.services.blocking.beta.vectorStores.FileBatchService
import com.openai.services.blocking.beta.vectorStores.FileService

interface VectorStoreService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun files(): FileService

    fun fileBatches(): FileBatchService

    /** Create a vector store. */
    fun create(params: BetaVectorStoreCreateParams): VectorStore =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: BetaVectorStoreCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStore

    /** Retrieves a vector store. */
    fun retrieve(params: BetaVectorStoreRetrieveParams): VectorStore =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: BetaVectorStoreRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStore

    /** Modifies a vector store. */
    fun update(params: BetaVectorStoreUpdateParams): VectorStore =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: BetaVectorStoreUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStore

    /** Returns a list of vector stores. */
    fun list(): BetaVectorStoreListPage = list(BetaVectorStoreListParams.none())

    /** @see [list] */
    fun list(
        params: BetaVectorStoreListParams = BetaVectorStoreListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaVectorStoreListPage

    /** @see [list] */
    fun list(
        params: BetaVectorStoreListParams = BetaVectorStoreListParams.none()
    ): BetaVectorStoreListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): BetaVectorStoreListPage =
        list(BetaVectorStoreListParams.none(), requestOptions)

    /** Delete a vector store. */
    fun delete(params: BetaVectorStoreDeleteParams): VectorStoreDeleted =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: BetaVectorStoreDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreDeleted

    /**
     * A view of [VectorStoreService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        fun files(): FileService.WithRawResponse

        fun fileBatches(): FileBatchService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /vector_stores`, but is otherwise the same as
         * [VectorStoreService.create].
         */
        @MustBeClosed
        fun create(params: BetaVectorStoreCreateParams): HttpResponseFor<VectorStore> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BetaVectorStoreCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStore>

        /**
         * Returns a raw HTTP response for `get /vector_stores/{vector_store_id}`, but is otherwise
         * the same as [VectorStoreService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: BetaVectorStoreRetrieveParams): HttpResponseFor<VectorStore> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: BetaVectorStoreRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStore>

        /**
         * Returns a raw HTTP response for `post /vector_stores/{vector_store_id}`, but is otherwise
         * the same as [VectorStoreService.update].
         */
        @MustBeClosed
        fun update(params: BetaVectorStoreUpdateParams): HttpResponseFor<VectorStore> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: BetaVectorStoreUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStore>

        /**
         * Returns a raw HTTP response for `get /vector_stores`, but is otherwise the same as
         * [VectorStoreService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<BetaVectorStoreListPage> =
            list(BetaVectorStoreListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: BetaVectorStoreListParams = BetaVectorStoreListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaVectorStoreListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: BetaVectorStoreListParams = BetaVectorStoreListParams.none()
        ): HttpResponseFor<BetaVectorStoreListPage> = list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<BetaVectorStoreListPage> =
            list(BetaVectorStoreListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /vector_stores/{vector_store_id}`, but is
         * otherwise the same as [VectorStoreService.delete].
         */
        @MustBeClosed
        fun delete(params: BetaVectorStoreDeleteParams): HttpResponseFor<VectorStoreDeleted> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: BetaVectorStoreDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreDeleted>
    }
}
