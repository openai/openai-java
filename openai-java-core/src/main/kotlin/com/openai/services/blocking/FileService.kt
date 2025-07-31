// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.models.files.FileContentParams
import com.openai.models.files.FileCreateParams
import com.openai.models.files.FileDeleteParams
import com.openai.models.files.FileDeleted
import com.openai.models.files.FileListPage
import com.openai.models.files.FileListParams
import com.openai.models.files.FileObject
import com.openai.models.files.FileRetrieveParams
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

    /** @see create */
    fun create(
        params: FileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileObject

    /** Returns information about a specific file. */
    fun retrieve(fileId: String): FileObject = retrieve(fileId, FileRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        fileId: String,
        params: FileRetrieveParams = FileRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileObject = retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        fileId: String,
        params: FileRetrieveParams = FileRetrieveParams.none(),
    ): FileObject = retrieve(fileId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileObject

    /** @see retrieve */
    fun retrieve(params: FileRetrieveParams): FileObject = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(fileId: String, requestOptions: RequestOptions): FileObject =
        retrieve(fileId, FileRetrieveParams.none(), requestOptions)

    /** Returns a list of files. */
    fun list(): FileListPage = list(FileListParams.none())

    /** @see list */
    fun list(
        params: FileListParams = FileListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileListPage

    /** @see list */
    fun list(params: FileListParams = FileListParams.none()): FileListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): FileListPage =
        list(FileListParams.none(), requestOptions)

    /** Delete a file. */
    fun delete(fileId: String): FileDeleted = delete(fileId, FileDeleteParams.none())

    /** @see delete */
    fun delete(
        fileId: String,
        params: FileDeleteParams = FileDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileDeleted = delete(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see delete */
    fun delete(fileId: String, params: FileDeleteParams = FileDeleteParams.none()): FileDeleted =
        delete(fileId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileDeleted

    /** @see delete */
    fun delete(params: FileDeleteParams): FileDeleted = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(fileId: String, requestOptions: RequestOptions): FileDeleted =
        delete(fileId, FileDeleteParams.none(), requestOptions)

    /** Returns the contents of the specified file. */
    @MustBeClosed
    fun content(fileId: String): HttpResponse = content(fileId, FileContentParams.none())

    /** @see content */
    @MustBeClosed
    fun content(
        fileId: String,
        params: FileContentParams = FileContentParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse = content(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see content */
    @MustBeClosed
    fun content(
        fileId: String,
        params: FileContentParams = FileContentParams.none(),
    ): HttpResponse = content(fileId, params, RequestOptions.none())

    /** @see content */
    @MustBeClosed
    fun content(
        params: FileContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse

    /** @see content */
    @MustBeClosed
    fun content(params: FileContentParams): HttpResponse = content(params, RequestOptions.none())

    /** @see content */
    @MustBeClosed
    fun content(fileId: String, requestOptions: RequestOptions): HttpResponse =
        content(fileId, FileContentParams.none(), requestOptions)

    /** A view of [FileService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /files`, but is otherwise the same as
         * [FileService.create].
         */
        @MustBeClosed
        fun create(params: FileCreateParams): HttpResponseFor<FileObject> =
            create(params, RequestOptions.none())

        /** @see create */
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
        fun retrieve(fileId: String): HttpResponseFor<FileObject> =
            retrieve(fileId, FileRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            fileId: String,
            params: FileRetrieveParams = FileRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileObject> =
            retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            fileId: String,
            params: FileRetrieveParams = FileRetrieveParams.none(),
        ): HttpResponseFor<FileObject> = retrieve(fileId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: FileRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileObject>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: FileRetrieveParams): HttpResponseFor<FileObject> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(fileId: String, requestOptions: RequestOptions): HttpResponseFor<FileObject> =
            retrieve(fileId, FileRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /files`, but is otherwise the same as
         * [FileService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<FileListPage> = list(FileListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: FileListParams = FileListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: FileListParams = FileListParams.none()): HttpResponseFor<FileListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<FileListPage> =
            list(FileListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /files/{file_id}`, but is otherwise the same as
         * [FileService.delete].
         */
        @MustBeClosed
        fun delete(fileId: String): HttpResponseFor<FileDeleted> =
            delete(fileId, FileDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            fileId: String,
            params: FileDeleteParams = FileDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileDeleted> =
            delete(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            fileId: String,
            params: FileDeleteParams = FileDeleteParams.none(),
        ): HttpResponseFor<FileDeleted> = delete(fileId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: FileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileDeleted>

        /** @see delete */
        @MustBeClosed
        fun delete(params: FileDeleteParams): HttpResponseFor<FileDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(fileId: String, requestOptions: RequestOptions): HttpResponseFor<FileDeleted> =
            delete(fileId, FileDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /files/{file_id}/content`, but is otherwise the same
         * as [FileService.content].
         */
        @MustBeClosed
        fun content(fileId: String): HttpResponse = content(fileId, FileContentParams.none())

        /** @see content */
        @MustBeClosed
        fun content(
            fileId: String,
            params: FileContentParams = FileContentParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = content(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see content */
        @MustBeClosed
        fun content(
            fileId: String,
            params: FileContentParams = FileContentParams.none(),
        ): HttpResponse = content(fileId, params, RequestOptions.none())

        /** @see content */
        @MustBeClosed
        fun content(
            params: FileContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see content */
        @MustBeClosed
        fun content(params: FileContentParams): HttpResponse =
            content(params, RequestOptions.none())

        /** @see content */
        @MustBeClosed
        fun content(fileId: String, requestOptions: RequestOptions): HttpResponse =
            content(fileId, FileContentParams.none(), requestOptions)
    }
}
