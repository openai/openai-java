// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
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
import java.util.function.Consumer

interface FileServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileServiceAsync

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
    fun retrieve(fileId: String): CompletableFuture<FileObject> =
        retrieve(fileId, FileRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        fileId: String,
        params: FileRetrieveParams = FileRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileObject> =
        retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        fileId: String,
        params: FileRetrieveParams = FileRetrieveParams.none(),
    ): CompletableFuture<FileObject> = retrieve(fileId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileObject>

    /** @see [retrieve] */
    fun retrieve(params: FileRetrieveParams): CompletableFuture<FileObject> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(fileId: String, requestOptions: RequestOptions): CompletableFuture<FileObject> =
        retrieve(fileId, FileRetrieveParams.none(), requestOptions)

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
    fun delete(fileId: String): CompletableFuture<FileDeleted> =
        delete(fileId, FileDeleteParams.none())

    /** @see [delete] */
    fun delete(
        fileId: String,
        params: FileDeleteParams = FileDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileDeleted> =
        delete(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see [delete] */
    fun delete(
        fileId: String,
        params: FileDeleteParams = FileDeleteParams.none(),
    ): CompletableFuture<FileDeleted> = delete(fileId, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileDeleted>

    /** @see [delete] */
    fun delete(params: FileDeleteParams): CompletableFuture<FileDeleted> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(fileId: String, requestOptions: RequestOptions): CompletableFuture<FileDeleted> =
        delete(fileId, FileDeleteParams.none(), requestOptions)

    /** Returns the contents of the specified file. */
    fun content(fileId: String): CompletableFuture<HttpResponse> =
        content(fileId, FileContentParams.none())

    /** @see [content] */
    fun content(
        fileId: String,
        params: FileContentParams = FileContentParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse> =
        content(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see [content] */
    fun content(
        fileId: String,
        params: FileContentParams = FileContentParams.none(),
    ): CompletableFuture<HttpResponse> = content(fileId, params, RequestOptions.none())

    /** @see [content] */
    fun content(
        params: FileContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>

    /** @see [content] */
    fun content(params: FileContentParams): CompletableFuture<HttpResponse> =
        content(params, RequestOptions.none())

    /** @see [content] */
    fun content(fileId: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
        content(fileId, FileContentParams.none(), requestOptions)

    /** A view of [FileServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /files`, but is otherwise the same as
         * [FileServiceAsync.create].
         */
        fun create(params: FileCreateParams): CompletableFuture<HttpResponseFor<FileObject>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        fun create(
            params: FileCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileObject>>

        /**
         * Returns a raw HTTP response for `get /files/{file_id}`, but is otherwise the same as
         * [FileServiceAsync.retrieve].
         */
        fun retrieve(fileId: String): CompletableFuture<HttpResponseFor<FileObject>> =
            retrieve(fileId, FileRetrieveParams.none())

        /** @see [retrieve] */
        fun retrieve(
            fileId: String,
            params: FileRetrieveParams = FileRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileObject>> =
            retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see [retrieve] */
        fun retrieve(
            fileId: String,
            params: FileRetrieveParams = FileRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<FileObject>> =
            retrieve(fileId, params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            params: FileRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileObject>>

        /** @see [retrieve] */
        fun retrieve(params: FileRetrieveParams): CompletableFuture<HttpResponseFor<FileObject>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            fileId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileObject>> =
            retrieve(fileId, FileRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /files`, but is otherwise the same as
         * [FileServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(FileListParams.none())

        /** @see [list] */
        fun list(
            params: FileListParams = FileListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>>

        /** @see [list] */
        fun list(
            params: FileListParams = FileListParams.none()
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(FileListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /files/{file_id}`, but is otherwise the same as
         * [FileServiceAsync.delete].
         */
        fun delete(fileId: String): CompletableFuture<HttpResponseFor<FileDeleted>> =
            delete(fileId, FileDeleteParams.none())

        /** @see [delete] */
        fun delete(
            fileId: String,
            params: FileDeleteParams = FileDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileDeleted>> =
            delete(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see [delete] */
        fun delete(
            fileId: String,
            params: FileDeleteParams = FileDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<FileDeleted>> =
            delete(fileId, params, RequestOptions.none())

        /** @see [delete] */
        fun delete(
            params: FileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileDeleted>>

        /** @see [delete] */
        fun delete(params: FileDeleteParams): CompletableFuture<HttpResponseFor<FileDeleted>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        fun delete(
            fileId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileDeleted>> =
            delete(fileId, FileDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /files/{file_id}/content`, but is otherwise the same
         * as [FileServiceAsync.content].
         */
        fun content(fileId: String): CompletableFuture<HttpResponse> =
            content(fileId, FileContentParams.none())

        /** @see [content] */
        fun content(
            fileId: String,
            params: FileContentParams = FileContentParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            content(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see [content] */
        fun content(
            fileId: String,
            params: FileContentParams = FileContentParams.none(),
        ): CompletableFuture<HttpResponse> = content(fileId, params, RequestOptions.none())

        /** @see [content] */
        fun content(
            params: FileContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see [content] */
        fun content(params: FileContentParams): CompletableFuture<HttpResponse> =
            content(params, RequestOptions.none())

        /** @see [content] */
        fun content(
            fileId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            content(fileId, FileContentParams.none(), requestOptions)
    }
}
