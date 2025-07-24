// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.vectorstores

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
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
import java.util.function.Consumer

interface FileService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileService

    /**
     * Create a vector store file by attaching a
     * [File](https://platform.openai.com/docs/api-reference/files) to a
     * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object).
     */
    fun create(vectorStoreId: String, params: FileCreateParams): VectorStoreFile =
        create(vectorStoreId, params, RequestOptions.none())

    /** @see create */
    fun create(
        vectorStoreId: String,
        params: FileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFile =
        create(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

    /** @see create */
    fun create(params: FileCreateParams): VectorStoreFile = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: FileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFile

    /** Retrieves a vector store file. */
    fun retrieve(fileId: String, params: FileRetrieveParams): VectorStoreFile =
        retrieve(fileId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        fileId: String,
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFile = retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: FileRetrieveParams): VectorStoreFile =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFile

    /** Update attributes on a vector store file. */
    fun update(fileId: String, params: FileUpdateParams): VectorStoreFile =
        update(fileId, params, RequestOptions.none())

    /** @see update */
    fun update(
        fileId: String,
        params: FileUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFile = update(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see update */
    fun update(params: FileUpdateParams): VectorStoreFile = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: FileUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFile

    /** Returns a list of vector store files. */
    fun list(vectorStoreId: String): FileListPage = list(vectorStoreId, FileListParams.none())

    /** @see list */
    fun list(
        vectorStoreId: String,
        params: FileListParams = FileListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileListPage = list(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

    /** @see list */
    fun list(vectorStoreId: String, params: FileListParams = FileListParams.none()): FileListPage =
        list(vectorStoreId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: FileListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileListPage

    /** @see list */
    fun list(params: FileListParams): FileListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(vectorStoreId: String, requestOptions: RequestOptions): FileListPage =
        list(vectorStoreId, FileListParams.none(), requestOptions)

    /**
     * Delete a vector store file. This will remove the file from the vector store but the file
     * itself will not be deleted. To delete the file, use the
     * [delete file](https://platform.openai.com/docs/api-reference/files/delete) endpoint.
     */
    fun delete(fileId: String, params: FileDeleteParams): VectorStoreFileDeleted =
        delete(fileId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        fileId: String,
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFileDeleted = delete(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see delete */
    fun delete(params: FileDeleteParams): VectorStoreFileDeleted =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VectorStoreFileDeleted

    /** Retrieve the parsed contents of a vector store file. */
    fun content(fileId: String, params: FileContentParams): FileContentPage =
        content(fileId, params, RequestOptions.none())

    /** @see content */
    fun content(
        fileId: String,
        params: FileContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileContentPage = content(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see content */
    fun content(params: FileContentParams): FileContentPage = content(params, RequestOptions.none())

    /** @see content */
    fun content(
        params: FileContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileContentPage

    /** A view of [FileService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /vector_stores/{vector_store_id}/files`, but is
         * otherwise the same as [FileService.create].
         */
        @MustBeClosed
        fun create(
            vectorStoreId: String,
            params: FileCreateParams,
        ): HttpResponseFor<VectorStoreFile> = create(vectorStoreId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            vectorStoreId: String,
            params: FileCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreFile> =
            create(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: FileCreateParams): HttpResponseFor<VectorStoreFile> =
            create(params, RequestOptions.none())

        /** @see create */
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
        fun retrieve(fileId: String, params: FileRetrieveParams): HttpResponseFor<VectorStoreFile> =
            retrieve(fileId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            fileId: String,
            params: FileRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreFile> =
            retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: FileRetrieveParams): HttpResponseFor<VectorStoreFile> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
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
        fun update(fileId: String, params: FileUpdateParams): HttpResponseFor<VectorStoreFile> =
            update(fileId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            fileId: String,
            params: FileUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreFile> =
            update(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: FileUpdateParams): HttpResponseFor<VectorStoreFile> =
            update(params, RequestOptions.none())

        /** @see update */
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
        fun list(vectorStoreId: String): HttpResponseFor<FileListPage> =
            list(vectorStoreId, FileListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            vectorStoreId: String,
            params: FileListParams = FileListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileListPage> =
            list(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            vectorStoreId: String,
            params: FileListParams = FileListParams.none(),
        ): HttpResponseFor<FileListPage> = list(vectorStoreId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: FileListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: FileListParams): HttpResponseFor<FileListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            vectorStoreId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileListPage> =
            list(vectorStoreId, FileListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /vector_stores/{vector_store_id}/files/{file_id}`, but is otherwise the same as
         * [FileService.delete].
         */
        @MustBeClosed
        fun delete(
            fileId: String,
            params: FileDeleteParams,
        ): HttpResponseFor<VectorStoreFileDeleted> = delete(fileId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            fileId: String,
            params: FileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VectorStoreFileDeleted> =
            delete(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: FileDeleteParams): HttpResponseFor<VectorStoreFileDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
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
        fun content(fileId: String, params: FileContentParams): HttpResponseFor<FileContentPage> =
            content(fileId, params, RequestOptions.none())

        /** @see content */
        @MustBeClosed
        fun content(
            fileId: String,
            params: FileContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileContentPage> =
            content(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see content */
        @MustBeClosed
        fun content(params: FileContentParams): HttpResponseFor<FileContentPage> =
            content(params, RequestOptions.none())

        /** @see content */
        @MustBeClosed
        fun content(
            params: FileContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileContentPage>
    }
}
