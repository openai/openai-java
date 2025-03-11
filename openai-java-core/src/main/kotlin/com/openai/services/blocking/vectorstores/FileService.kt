// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.vectorstores

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.vectorstores.files.FileContentPage
import com.openai.models.vectorstores.files.FileContentParams
import com.openai.models.vectorstores.files.FileCreateParams
import com.openai.models.vectorstores.files.FileDeleteParams
import com.openai.models.vectorstores.files.FileListPage
import com.openai.models.vectorstores.files.FileListParams
import com.openai.models.vectorstores.files.FileRetrieveParams
import com.openai.models.vectorstores.files.FileUpdateParams
import com.openai.models.vectorstores.files.VectorStoreFile
import com.openai.models.vectorstores.files.VectorStoreFileDeleted

interface FileService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Create a vector store file by attaching a
     * [File](https://platform.openai.com/docs/api-reference/files) to a
     * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object).
     */
    fun create(params: FileCreateParams): VectorStoreFile = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: FileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFile

    /** Retrieves a vector store file. */
    fun retrieve(params: FileRetrieveParams): VectorStoreFile =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFile

    /** Update attributes on a vector store file. */
    fun update(params: FileUpdateParams): VectorStoreFile = update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: FileUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFile

    /** Returns a list of vector store files. */
    fun list(params: FileListParams): FileListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: FileListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileListPage

    /**
     * Delete a vector store file. This will remove the file from the vector store but the file
     * itself will not be deleted. To delete the file, use the
     * [delete file](https://platform.openai.com/docs/api-reference/files/delete) endpoint.
     */
    fun delete(params: FileDeleteParams): VectorStoreFileDeleted =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFileDeleted

    /** Retrieve the parsed contents of a vector store file. */
    fun content(params: FileContentParams): FileContentPage = content(params, RequestOptions.none())

    /** @see [content] */
    fun content(
        params: FileContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileContentPage

    /** A view of [FileService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /vector_stores/{vector_store_id}/files`, but is
         * otherwise the same as [FileService.create].
         */
        @MustBeClosed
        fun create(params: FileCreateParams): HttpResponseFor<VectorStoreFile> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: FileCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreFile>

        /**
         * Returns a raw HTTP response for `get /vector_stores/{vector_store_id}/files/{file_id}`,
         * but is otherwise the same as [FileService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: FileRetrieveParams): HttpResponseFor<VectorStoreFile> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: FileRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreFile>

        /**
         * Returns a raw HTTP response for `post /vector_stores/{vector_store_id}/files/{file_id}`,
         * but is otherwise the same as [FileService.update].
         */
        @MustBeClosed
        fun update(params: FileUpdateParams): HttpResponseFor<VectorStoreFile> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: FileUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreFile>

        /**
         * Returns a raw HTTP response for `get /vector_stores/{vector_store_id}/files`, but is
         * otherwise the same as [FileService.list].
         */
        @MustBeClosed
        fun list(params: FileListParams): HttpResponseFor<FileListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: FileListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileListPage>

        /**
         * Returns a raw HTTP response for `delete
         * /vector_stores/{vector_store_id}/files/{file_id}`, but is otherwise the same as
         * [FileService.delete].
         */
        @MustBeClosed
        fun delete(params: FileDeleteParams): HttpResponseFor<VectorStoreFileDeleted> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: FileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreFileDeleted>

        /**
         * Returns a raw HTTP response for `get
         * /vector_stores/{vector_store_id}/files/{file_id}/content`, but is otherwise the same as
         * [FileService.content].
         */
        @MustBeClosed
        fun content(params: FileContentParams): HttpResponseFor<FileContentPage> =
            content(params, RequestOptions.none())

        /** @see [content] */
        @MustBeClosed
        fun content(
            params: FileContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileContentPage>
    }
}
