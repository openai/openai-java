// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.models.FileContentParams
import com.openai.models.FileCreateParams
import com.openai.models.FileDeleteParams
import com.openai.models.FileDeleted
import com.openai.models.FileListPage
import com.openai.models.FileListParams
import com.openai.models.FileObject
import com.openai.models.FileRetrieveParams

interface FileService {

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
    fun create(params: FileCreateParams): FileObject = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: FileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileObject

    /** Returns information about a specific file. */
    fun retrieve(params: FileRetrieveParams): FileObject = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileObject

    /** Returns a list of files. */
    fun list(): FileListPage = list(FileListParams.none())

    /** @see [list] */
    fun list(
        params: FileListParams = FileListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileListPage

    /** @see [list] */
    fun list(params: FileListParams = FileListParams.none()): FileListPage =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): FileListPage =
        list(FileListParams.none(), requestOptions)

    /** Delete a file. */
    fun delete(params: FileDeleteParams): FileDeleted = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileDeleted

    /** Returns the contents of the specified file. */
    @MustBeClosed
    fun content(params: FileContentParams): HttpResponse = content(params, RequestOptions.none())

    /** @see [content] */
    @MustBeClosed
    fun content(
        params: FileContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse

    /** A view of [FileService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /files`, but is otherwise the same as
         * [FileService.create].
         */
        @MustBeClosed
        fun create(params: FileCreateParams): HttpResponseFor<FileObject> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: FileCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileObject>

        /**
         * Returns a raw HTTP response for `get /files/{file_id}`, but is otherwise the same as
         * [FileService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: FileRetrieveParams): HttpResponseFor<FileObject> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: FileRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileObject>

        /**
         * Returns a raw HTTP response for `get /files`, but is otherwise the same as
         * [FileService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<FileListPage> = list(FileListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: FileListParams = FileListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(params: FileListParams = FileListParams.none()): HttpResponseFor<FileListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<FileListPage> =
            list(FileListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /files/{file_id}`, but is otherwise the same as
         * [FileService.delete].
         */
        @MustBeClosed
        fun delete(params: FileDeleteParams): HttpResponseFor<FileDeleted> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: FileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileDeleted>

        /**
         * Returns a raw HTTP response for `get /files/{file_id}/content`, but is otherwise the same
         * as [FileService.content].
         */
        @MustBeClosed
        fun content(params: FileContentParams): HttpResponse =
            content(params, RequestOptions.none())

        /** @see [content] */
        @MustBeClosed
        fun content(
            params: FileContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
