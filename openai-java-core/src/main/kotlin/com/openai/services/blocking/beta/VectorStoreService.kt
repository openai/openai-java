// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.vectorstores.VectorStore
import com.openai.models.beta.vectorstores.VectorStoreCreateParams
import com.openai.models.beta.vectorstores.VectorStoreDeleteParams
import com.openai.models.beta.vectorstores.VectorStoreDeleted
import com.openai.models.beta.vectorstores.VectorStoreListPage
import com.openai.models.beta.vectorstores.VectorStoreListParams
import com.openai.models.beta.vectorstores.VectorStoreRetrieveParams
import com.openai.models.beta.vectorstores.VectorStoreUpdateParams
import com.openai.services.blocking.beta.vectorstores.FileBatchService
import com.openai.services.blocking.beta.vectorstores.FileService

interface VectorStoreService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun files(): FileService

    fun fileBatches(): FileBatchService

    /** Create a vector store. */
    fun create(params: VectorStoreCreateParams): VectorStore = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: VectorStoreCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStore

    /** Retrieves a vector store. */
    fun retrieve(params: VectorStoreRetrieveParams): VectorStore =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: VectorStoreRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStore

    /** Modifies a vector store. */
    fun update(params: VectorStoreUpdateParams): VectorStore = update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: VectorStoreUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStore

    /** Returns a list of vector stores. */
    fun list(): VectorStoreListPage = list(VectorStoreListParams.none())

    /** @see [list] */
    fun list(
        params: VectorStoreListParams = VectorStoreListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreListPage

    /** @see [list] */
    fun list(params: VectorStoreListParams = VectorStoreListParams.none()): VectorStoreListPage =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): VectorStoreListPage =
        list(VectorStoreListParams.none(), requestOptions)

    /** Delete a vector store. */
    fun delete(params: VectorStoreDeleteParams): VectorStoreDeleted =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: VectorStoreDeleteParams,
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
        fun create(params: VectorStoreCreateParams): HttpResponseFor<VectorStore> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: VectorStoreCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStore>

        /**
         * Returns a raw HTTP response for `get /vector_stores/{vector_store_id}`, but is otherwise
         * the same as [VectorStoreService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: VectorStoreRetrieveParams): HttpResponseFor<VectorStore> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: VectorStoreRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStore>

        /**
         * Returns a raw HTTP response for `post /vector_stores/{vector_store_id}`, but is otherwise
         * the same as [VectorStoreService.update].
         */
        @MustBeClosed
        fun update(params: VectorStoreUpdateParams): HttpResponseFor<VectorStore> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: VectorStoreUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStore>

        /**
         * Returns a raw HTTP response for `get /vector_stores`, but is otherwise the same as
         * [VectorStoreService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<VectorStoreListPage> = list(VectorStoreListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: VectorStoreListParams = VectorStoreListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: VectorStoreListParams = VectorStoreListParams.none()
        ): HttpResponseFor<VectorStoreListPage> = list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<VectorStoreListPage> =
            list(VectorStoreListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /vector_stores/{vector_store_id}`, but is
         * otherwise the same as [VectorStoreService.delete].
         */
        @MustBeClosed
        fun delete(params: VectorStoreDeleteParams): HttpResponseFor<VectorStoreDeleted> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: VectorStoreDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreDeleted>
    }
}
