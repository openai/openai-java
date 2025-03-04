// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

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
    @JvmOverloads
    fun create(
        params: BetaVectorStoreCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStore

    /** Retrieves a vector store. */
    @JvmOverloads
    fun retrieve(
        params: BetaVectorStoreRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStore

    /** Modifies a vector store. */
    @JvmOverloads
    fun update(
        params: BetaVectorStoreUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStore

    /** Returns a list of vector stores. */
    @JvmOverloads
    fun list(
        params: BetaVectorStoreListParams = BetaVectorStoreListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaVectorStoreListPage

    /** Returns a list of vector stores. */
    fun list(requestOptions: RequestOptions): BetaVectorStoreListPage =
        list(BetaVectorStoreListParams.none(), requestOptions)

    /** Delete a vector store. */
    @JvmOverloads
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
        @JvmOverloads
        @MustBeClosed
        fun create(
            params: BetaVectorStoreCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStore>

        /**
         * Returns a raw HTTP response for `get /vector_stores/{vector_store_id}`, but is otherwise
         * the same as [VectorStoreService.retrieve].
         */
        @JvmOverloads
        @MustBeClosed
        fun retrieve(
            params: BetaVectorStoreRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStore>

        /**
         * Returns a raw HTTP response for `post /vector_stores/{vector_store_id}`, but is otherwise
         * the same as [VectorStoreService.update].
         */
        @JvmOverloads
        @MustBeClosed
        fun update(
            params: BetaVectorStoreUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStore>

        /**
         * Returns a raw HTTP response for `get /vector_stores`, but is otherwise the same as
         * [VectorStoreService.list].
         */
        @JvmOverloads
        @MustBeClosed
        fun list(
            params: BetaVectorStoreListParams = BetaVectorStoreListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaVectorStoreListPage>

        /**
         * Returns a raw HTTP response for `get /vector_stores`, but is otherwise the same as
         * [VectorStoreService.list].
         */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<BetaVectorStoreListPage> =
            list(BetaVectorStoreListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /vector_stores/{vector_store_id}`, but is
         * otherwise the same as [VectorStoreService.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: BetaVectorStoreDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreDeleted>
    }
}
