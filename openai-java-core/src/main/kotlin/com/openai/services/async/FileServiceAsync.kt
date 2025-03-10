// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.models.files.FileContentParams
import com.openai.models.files.FileCreateParams
import com.openai.models.files.FileDeleteParams
import com.openai.models.files.FileDeleted
import com.openai.models.files.FileListPageAsync
import com.openai.models.files.FileListParams
import com.openai.models.files.FileObject
import com.openai.models.files.FileRetrieveParams
import java.util.concurrent.CompletableFuture

interface FileServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Upload a file that can be used across various endpoints. Individual files can be up to 512
     * MB, and the size of all files uploaded by one organization can be up to 100 GB.
     *
     * The Assistants API supports files up to 2 million tokens and of specific file types. See the
     * [Assistants Tools guide](https://platform.openai.com/docs/assistants/tools) for details.
     *
     * The Fine-tuning API only supports `.jsonl` files. The input also has certain required formats
     * for fine-tuning [chat](https://platform.openai.com/docs/api-reference/fine-tuning/chat-input)
     * or
     * [completions](https://platform.openai.com/docs/api-reference/fine-tuning/completions-input)
     * models.
     *
     * The Batch API only supports `.jsonl` files up to 200 MB in size. The input also has a
     * specific required
     * [format](https://platform.openai.com/docs/api-reference/batch/request-input).
     *
     * Please [contact us](https://help.openai.com/) if you need to increase these storage limits.
     */
    fun create(params: FileCreateParams): CompletableFuture<FileObject> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: FileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileObject>

    /** Returns information about a specific file. */
    fun retrieve(params: FileRetrieveParams): CompletableFuture<FileObject> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileObject>

    /** Returns a list of files. */
    fun list(): CompletableFuture<FileListPageAsync> = list(FileListParams.none())

    /** @see [list] */
    fun list(
        params: FileListParams = FileListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileListPageAsync>

    /** @see [list] */
    fun list(params: FileListParams = FileListParams.none()): CompletableFuture<FileListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<FileListPageAsync> =
        list(FileListParams.none(), requestOptions)

    /** Delete a file. */
    fun delete(params: FileDeleteParams): CompletableFuture<FileDeleted> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileDeleted>

    /** Returns the contents of the specified file. */
    @MustBeClosed
    fun content(params: FileContentParams): CompletableFuture<HttpResponse> =
        content(params, RequestOptions.none())

    /** @see [content] */
    @MustBeClosed
    fun content(
        params: FileContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>

    /** A view of [FileServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /files`, but is otherwise the same as
         * [FileServiceAsync.create].
         */
        @MustBeClosed
        fun create(params: FileCreateParams): CompletableFuture<HttpResponseFor<FileObject>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: FileCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileObject>>

        /**
         * Returns a raw HTTP response for `get /files/{file_id}`, but is otherwise the same as
         * [FileServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: FileRetrieveParams): CompletableFuture<HttpResponseFor<FileObject>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: FileRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileObject>>

        /**
         * Returns a raw HTTP response for `get /files`, but is otherwise the same as
         * [FileServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(FileListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: FileListParams = FileListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: FileListParams = FileListParams.none()
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(FileListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /files/{file_id}`, but is otherwise the same as
         * [FileServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(params: FileDeleteParams): CompletableFuture<HttpResponseFor<FileDeleted>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: FileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileDeleted>>

        /**
         * Returns a raw HTTP response for `get /files/{file_id}/content`, but is otherwise the same
         * as [FileServiceAsync.content].
         */
        @MustBeClosed
        fun content(params: FileContentParams): CompletableFuture<HttpResponse> =
            content(params, RequestOptions.none())

        /** @see [content] */
        @MustBeClosed
        fun content(
            params: FileContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>
    }
}
