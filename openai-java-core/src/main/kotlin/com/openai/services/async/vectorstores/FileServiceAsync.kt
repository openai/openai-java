// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.vectorstores

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.vectorstores.files.FileContentPageAsync
import com.openai.models.vectorstores.files.FileContentParams
import com.openai.models.vectorstores.files.FileCreateParams
import com.openai.models.vectorstores.files.FileDeleteParams
import com.openai.models.vectorstores.files.FileListPageAsync
import com.openai.models.vectorstores.files.FileListParams
import com.openai.models.vectorstores.files.FileRetrieveParams
import com.openai.models.vectorstores.files.FileUpdateParams
import com.openai.models.vectorstores.files.VectorStoreFile
import com.openai.models.vectorstores.files.VectorStoreFileDeleted
import java.util.concurrent.CompletableFuture

interface FileServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Create a vector store file by attaching a
     * [File](https://platform.openai.com/docs/api-reference/files) to a
     * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object).
     */
    fun create(
        vectorStoreId: String,
        params: FileCreateParams,
    ): CompletableFuture<VectorStoreFile> = create(vectorStoreId, params, RequestOptions.none())

    /** @see [create] */
    fun create(
        vectorStoreId: String,
        params: FileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreFile> =
        create(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

    /** @see [create] */
    fun create(params: FileCreateParams): CompletableFuture<VectorStoreFile> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: FileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreFile>

    /** Retrieves a vector store file. */
    fun retrieve(fileId: String, params: FileRetrieveParams): CompletableFuture<VectorStoreFile> =
        retrieve(fileId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        fileId: String,
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreFile> =
        retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(params: FileRetrieveParams): CompletableFuture<VectorStoreFile> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreFile>

    /** Update attributes on a vector store file. */
    fun update(fileId: String, params: FileUpdateParams): CompletableFuture<VectorStoreFile> =
        update(fileId, params, RequestOptions.none())

    /** @see [update] */
    fun update(
        fileId: String,
        params: FileUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreFile> =
        update(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see [update] */
    fun update(params: FileUpdateParams): CompletableFuture<VectorStoreFile> =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: FileUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreFile>

    /** Returns a list of vector store files. */
    fun list(vectorStoreId: String): CompletableFuture<FileListPageAsync> =
        list(vectorStoreId, FileListParams.none())

    /** @see [list] */
    fun list(
        vectorStoreId: String,
        params: FileListParams = FileListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileListPageAsync> =
        list(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

    /** @see [list] */
    fun list(
        vectorStoreId: String,
        params: FileListParams = FileListParams.none(),
    ): CompletableFuture<FileListPageAsync> = list(vectorStoreId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: FileListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileListPageAsync>

    /** @see [list] */
    fun list(params: FileListParams): CompletableFuture<FileListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        vectorStoreId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileListPageAsync> =
        list(vectorStoreId, FileListParams.none(), requestOptions)

    /**
     * Delete a vector store file. This will remove the file from the vector store but the file
     * itself will not be deleted. To delete the file, use the
     * [delete file](https://platform.openai.com/docs/api-reference/files/delete) endpoint.
     */
    fun delete(
        fileId: String,
        params: FileDeleteParams,
    ): CompletableFuture<VectorStoreFileDeleted> = delete(fileId, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        fileId: String,
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreFileDeleted> =
        delete(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see [delete] */
    fun delete(params: FileDeleteParams): CompletableFuture<VectorStoreFileDeleted> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VectorStoreFileDeleted>

    /** Retrieve the parsed contents of a vector store file. */
    fun content(
        fileId: String,
        params: FileContentParams,
    ): CompletableFuture<FileContentPageAsync> = content(fileId, params, RequestOptions.none())

    /** @see [content] */
    fun content(
        fileId: String,
        params: FileContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileContentPageAsync> =
        content(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see [content] */
    fun content(params: FileContentParams): CompletableFuture<FileContentPageAsync> =
        content(params, RequestOptions.none())

    /** @see [content] */
    fun content(
        params: FileContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileContentPageAsync>

    /** A view of [FileServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /vector_stores/{vector_store_id}/files`, but is
         * otherwise the same as [FileServiceAsync.create].
         */
        @MustBeClosed
        fun create(
            vectorStoreId: String,
            params: FileCreateParams,
        ): CompletableFuture<HttpResponseFor<VectorStoreFile>> =
            create(vectorStoreId, params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            vectorStoreId: String,
            params: FileCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreFile>> =
            create(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

        /** @see [create] */
        @MustBeClosed
        fun create(params: FileCreateParams): CompletableFuture<HttpResponseFor<VectorStoreFile>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: FileCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreFile>>

        /**
         * Returns a raw HTTP response for `get /vector_stores/{vector_store_id}/files/{file_id}`,
         * but is otherwise the same as [FileServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            fileId: String,
            params: FileRetrieveParams,
        ): CompletableFuture<HttpResponseFor<VectorStoreFile>> =
            retrieve(fileId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            fileId: String,
            params: FileRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreFile>> =
            retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: FileRetrieveParams
        ): CompletableFuture<HttpResponseFor<VectorStoreFile>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: FileRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreFile>>

        /**
         * Returns a raw HTTP response for `post /vector_stores/{vector_store_id}/files/{file_id}`,
         * but is otherwise the same as [FileServiceAsync.update].
         */
        @MustBeClosed
        fun update(
            fileId: String,
            params: FileUpdateParams,
        ): CompletableFuture<HttpResponseFor<VectorStoreFile>> =
            update(fileId, params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            fileId: String,
            params: FileUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreFile>> =
            update(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see [update] */
        @MustBeClosed
        fun update(params: FileUpdateParams): CompletableFuture<HttpResponseFor<VectorStoreFile>> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: FileUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreFile>>

        /**
         * Returns a raw HTTP response for `get /vector_stores/{vector_store_id}/files`, but is
         * otherwise the same as [FileServiceAsync.list].
         */
        @MustBeClosed
        fun list(vectorStoreId: String): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(vectorStoreId, FileListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            vectorStoreId: String,
            params: FileListParams = FileListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(params.toBuilder().vectorStoreId(vectorStoreId).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(
            vectorStoreId: String,
            params: FileListParams = FileListParams.none(),
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(vectorStoreId, params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: FileListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(params: FileListParams): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            vectorStoreId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(vectorStoreId, FileListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /vector_stores/{vector_store_id}/files/{file_id}`, but is otherwise the same as
         * [FileServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(
            fileId: String,
            params: FileDeleteParams,
        ): CompletableFuture<HttpResponseFor<VectorStoreFileDeleted>> =
            delete(fileId, params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            fileId: String,
            params: FileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreFileDeleted>> =
            delete(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: FileDeleteParams
        ): CompletableFuture<HttpResponseFor<VectorStoreFileDeleted>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: FileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VectorStoreFileDeleted>>

        /**
         * Returns a raw HTTP response for `get
         * /vector_stores/{vector_store_id}/files/{file_id}/content`, but is otherwise the same as
         * [FileServiceAsync.content].
         */
        @MustBeClosed
        fun content(
            fileId: String,
            params: FileContentParams,
        ): CompletableFuture<HttpResponseFor<FileContentPageAsync>> =
            content(fileId, params, RequestOptions.none())

        /** @see [content] */
        @MustBeClosed
        fun content(
            fileId: String,
            params: FileContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileContentPageAsync>> =
            content(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see [content] */
        @MustBeClosed
        fun content(
            params: FileContentParams
        ): CompletableFuture<HttpResponseFor<FileContentPageAsync>> =
            content(params, RequestOptions.none())

        /** @see [content] */
        @MustBeClosed
        fun content(
            params: FileContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileContentPageAsync>>
    }
}
