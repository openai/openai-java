// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.vectorstores.VectorStore
import com.openai.models.vectorstores.VectorStoreCreateParams
import com.openai.models.vectorstores.VectorStoreDeleteParams
import com.openai.models.vectorstores.VectorStoreDeleted
import com.openai.models.vectorstores.VectorStoreListPage
import com.openai.models.vectorstores.VectorStoreListParams
import com.openai.models.vectorstores.VectorStoreRetrieveParams
import com.openai.models.vectorstores.VectorStoreSearchPage
import com.openai.models.vectorstores.VectorStoreSearchParams
import com.openai.models.vectorstores.VectorStoreUpdateParams
import com.openai.services.blocking.vectorstores.FileBatchService
import com.openai.services.blocking.vectorstores.FileService
import java.util.function.Consumer

interface VectorStoreService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VectorStoreService

    fun files(): FileService

    fun fileBatches(): FileBatchService

    /** Create a vector store. */
    fun create(): VectorStore = create(VectorStoreCreateParams.none())

    /** @see [create] */
    fun create(
        params: VectorStoreCreateParams = VectorStoreCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStore

    /** @see [create] */
    fun create(params: VectorStoreCreateParams = VectorStoreCreateParams.none()): VectorStore =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(requestOptions: RequestOptions): VectorStore =
        create(VectorStoreCreateParams.none(), requestOptions)

    /** Retrieves a vector store. */
    fun retrieve(vectorStoreId: String): VectorStore =
        retrieve(vectorStoreId, VectorStoreRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        vectorStoreId: String,
        params: VectorStoreRetrieveParams = VectorStoreRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStore =
        retrieve(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        vectorStoreId: String,
        params: VectorStoreRetrieveParams = VectorStoreRetrieveParams.none(),
    ): VectorStore = retrieve(vectorStoreId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: VectorStoreRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStore

    /** @see [retrieve] */
    fun retrieve(params: VectorStoreRetrieveParams): VectorStore =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(vectorStoreId: String, requestOptions: RequestOptions): VectorStore =
        retrieve(vectorStoreId, VectorStoreRetrieveParams.none(), requestOptions)

    /** Modifies a vector store. */
    fun update(vectorStoreId: String): VectorStore =
        update(vectorStoreId, VectorStoreUpdateParams.none())

    /** @see [update] */
    fun update(
        vectorStoreId: String,
        params: VectorStoreUpdateParams = VectorStoreUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStore = update(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

    /** @see [update] */
    fun update(
        vectorStoreId: String,
        params: VectorStoreUpdateParams = VectorStoreUpdateParams.none(),
    ): VectorStore = update(vectorStoreId, params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: VectorStoreUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStore

    /** @see [update] */
    fun update(params: VectorStoreUpdateParams): VectorStore = update(params, RequestOptions.none())

    /** @see [update] */
    fun update(vectorStoreId: String, requestOptions: RequestOptions): VectorStore =
        update(vectorStoreId, VectorStoreUpdateParams.none(), requestOptions)

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
    fun delete(vectorStoreId: String): VectorStoreDeleted =
        delete(vectorStoreId, VectorStoreDeleteParams.none())

    /** @see [delete] */
    fun delete(
        vectorStoreId: String,
        params: VectorStoreDeleteParams = VectorStoreDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreDeleted =
        delete(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

    /** @see [delete] */
    fun delete(
        vectorStoreId: String,
        params: VectorStoreDeleteParams = VectorStoreDeleteParams.none(),
    ): VectorStoreDeleted = delete(vectorStoreId, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: VectorStoreDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreDeleted

    /** @see [delete] */
    fun delete(params: VectorStoreDeleteParams): VectorStoreDeleted =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(vectorStoreId: String, requestOptions: RequestOptions): VectorStoreDeleted =
        delete(vectorStoreId, VectorStoreDeleteParams.none(), requestOptions)

    /** Search a vector store for relevant chunks based on a query and file attributes filter. */
    fun search(vectorStoreId: String, params: VectorStoreSearchParams): VectorStoreSearchPage =
        search(vectorStoreId, params, RequestOptions.none())

    /** @see [search] */
    fun search(
        vectorStoreId: String,
        params: VectorStoreSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreSearchPage =
        search(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

    /** @see [search] */
    fun search(params: VectorStoreSearchParams): VectorStoreSearchPage =
        search(params, RequestOptions.none())

    /** @see [search] */
    fun search(
        params: VectorStoreSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreSearchPage

    /**
     * A view of [VectorStoreService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VectorStoreService.WithRawResponse

        fun files(): FileService.WithRawResponse

        fun fileBatches(): FileBatchService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /vector_stores`, but is otherwise the same as
         * [VectorStoreService.create].
         */
        @MustBeClosed
        fun create(): HttpResponseFor<VectorStore> = create(VectorStoreCreateParams.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: VectorStoreCreateParams = VectorStoreCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStore>

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: VectorStoreCreateParams = VectorStoreCreateParams.none()
        ): HttpResponseFor<VectorStore> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<VectorStore> =
            create(VectorStoreCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /vector_stores/{vector_store_id}`, but is otherwise
         * the same as [VectorStoreService.retrieve].
         */
        @MustBeClosed
        fun retrieve(vectorStoreId: String): HttpResponseFor<VectorStore> =
            retrieve(vectorStoreId, VectorStoreRetrieveParams.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            vectorStoreId: String,
            params: VectorStoreRetrieveParams = VectorStoreRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStore> =
            retrieve(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            vectorStoreId: String,
            params: VectorStoreRetrieveParams = VectorStoreRetrieveParams.none(),
        ): HttpResponseFor<VectorStore> = retrieve(vectorStoreId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: VectorStoreRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStore>

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: VectorStoreRetrieveParams): HttpResponseFor<VectorStore> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            vectorStoreId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStore> =
            retrieve(vectorStoreId, VectorStoreRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /vector_stores/{vector_store_id}`, but is otherwise
         * the same as [VectorStoreService.update].
         */
        @MustBeClosed
        fun update(vectorStoreId: String): HttpResponseFor<VectorStore> =
            update(vectorStoreId, VectorStoreUpdateParams.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            vectorStoreId: String,
            params: VectorStoreUpdateParams = VectorStoreUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStore> =
            update(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

        /** @see [update] */
        @MustBeClosed
        fun update(
            vectorStoreId: String,
            params: VectorStoreUpdateParams = VectorStoreUpdateParams.none(),
        ): HttpResponseFor<VectorStore> = update(vectorStoreId, params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: VectorStoreUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStore>

        /** @see [update] */
        @MustBeClosed
        fun update(params: VectorStoreUpdateParams): HttpResponseFor<VectorStore> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            vectorStoreId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStore> =
            update(vectorStoreId, VectorStoreUpdateParams.none(), requestOptions)

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
        fun delete(vectorStoreId: String): HttpResponseFor<VectorStoreDeleted> =
            delete(vectorStoreId, VectorStoreDeleteParams.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            vectorStoreId: String,
            params: VectorStoreDeleteParams = VectorStoreDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreDeleted> =
            delete(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            vectorStoreId: String,
            params: VectorStoreDeleteParams = VectorStoreDeleteParams.none(),
        ): HttpResponseFor<VectorStoreDeleted> =
            delete(vectorStoreId, params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: VectorStoreDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreDeleted>

        /** @see [delete] */
        @MustBeClosed
        fun delete(params: VectorStoreDeleteParams): HttpResponseFor<VectorStoreDeleted> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            vectorStoreId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStoreDeleted> =
            delete(vectorStoreId, VectorStoreDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /vector_stores/{vector_store_id}/search`, but is
         * otherwise the same as [VectorStoreService.search].
         */
        @MustBeClosed
        fun search(
            vectorStoreId: String,
            params: VectorStoreSearchParams,
        ): HttpResponseFor<VectorStoreSearchPage> =
            search(vectorStoreId, params, RequestOptions.none())

        /** @see [search] */
        @MustBeClosed
        fun search(
            vectorStoreId: String,
            params: VectorStoreSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreSearchPage> =
            search(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

        /** @see [search] */
        @MustBeClosed
        fun search(params: VectorStoreSearchParams): HttpResponseFor<VectorStoreSearchPage> =
            search(params, RequestOptions.none())

        /** @see [search] */
        @MustBeClosed
        fun search(
            params: VectorStoreSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreSearchPage>
    }
}
