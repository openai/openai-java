// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.containers

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.models.containers.files.FileCreateParams
import com.openai.models.containers.files.FileCreateResponse
import com.openai.models.containers.files.FileDeleteParams
import com.openai.models.containers.files.FileListPageAsync
import com.openai.models.containers.files.FileListParams
import com.openai.models.containers.files.FileRetrieveParams
import com.openai.models.containers.files.FileRetrieveResponse
import com.openai.services.async.containers.files.ContentServiceAsync
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

    fun content(): ContentServiceAsync

    /**
     * Create a Container File
     *
     * You can send either a multipart/form-data request with the raw file content, or a JSON
     * request with a file ID.
     */
    fun create(containerId: String): CompletableFuture<FileCreateResponse> =
        create(containerId, FileCreateParams.none())

    /** @see create */
    fun create(
        containerId: String,
        params: FileCreateParams = FileCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileCreateResponse> =
        create(params.toBuilder().containerId(containerId).build(), requestOptions)

    /** @see create */
    fun create(
        containerId: String,
        params: FileCreateParams = FileCreateParams.none(),
    ): CompletableFuture<FileCreateResponse> = create(containerId, params, RequestOptions.none())

    /** @see create */
    fun create(
        params: FileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileCreateResponse>

    /** @see create */
    fun create(params: FileCreateParams): CompletableFuture<FileCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        containerId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileCreateResponse> =
        create(containerId, FileCreateParams.none(), requestOptions)

    /** Retrieve Container File */
    fun retrieve(
        fileId: String,
        params: FileRetrieveParams,
    ): CompletableFuture<FileRetrieveResponse> = retrieve(fileId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        fileId: String,
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileRetrieveResponse> =
        retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: FileRetrieveParams): CompletableFuture<FileRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileRetrieveResponse>

    /** List Container files */
    fun list(containerId: String): CompletableFuture<FileListPageAsync> =
        list(containerId, FileListParams.none())

    /** @see list */
    fun list(
        containerId: String,
        params: FileListParams = FileListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileListPageAsync> =
        list(params.toBuilder().containerId(containerId).build(), requestOptions)

    /** @see list */
    fun list(
        containerId: String,
        params: FileListParams = FileListParams.none(),
    ): CompletableFuture<FileListPageAsync> = list(containerId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: FileListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileListPageAsync>

    /** @see list */
    fun list(params: FileListParams): CompletableFuture<FileListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        containerId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileListPageAsync> =
        list(containerId, FileListParams.none(), requestOptions)

    /** Delete Container File */
    fun delete(fileId: String, params: FileDeleteParams): CompletableFuture<Void?> =
        delete(fileId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        fileId: String,
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = delete(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see delete */
    fun delete(params: FileDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** A view of [FileServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileServiceAsync.WithRawResponse

        fun content(): ContentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /containers/{container_id}/files`, but is otherwise
         * the same as [FileServiceAsync.create].
         */
        fun create(containerId: String): CompletableFuture<HttpResponseFor<FileCreateResponse>> =
            create(containerId, FileCreateParams.none())

        /** @see create */
        fun create(
            containerId: String,
            params: FileCreateParams = FileCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileCreateResponse>> =
            create(params.toBuilder().containerId(containerId).build(), requestOptions)

        /** @see create */
        fun create(
            containerId: String,
            params: FileCreateParams = FileCreateParams.none(),
        ): CompletableFuture<HttpResponseFor<FileCreateResponse>> =
            create(containerId, params, RequestOptions.none())

        /** @see create */
        fun create(
            params: FileCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileCreateResponse>>

        /** @see create */
        fun create(
            params: FileCreateParams
        ): CompletableFuture<HttpResponseFor<FileCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            containerId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileCreateResponse>> =
            create(containerId, FileCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /containers/{container_id}/files/{file_id}`, but is
         * otherwise the same as [FileServiceAsync.retrieve].
         */
        fun retrieve(
            fileId: String,
            params: FileRetrieveParams,
        ): CompletableFuture<HttpResponseFor<FileRetrieveResponse>> =
            retrieve(fileId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            fileId: String,
            params: FileRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileRetrieveResponse>> =
            retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: FileRetrieveParams
        ): CompletableFuture<HttpResponseFor<FileRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: FileRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileRetrieveResponse>>

        /**
         * Returns a raw HTTP response for `get /containers/{container_id}/files`, but is otherwise
         * the same as [FileServiceAsync.list].
         */
        fun list(containerId: String): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(containerId, FileListParams.none())

        /** @see list */
        fun list(
            containerId: String,
            params: FileListParams = FileListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(params.toBuilder().containerId(containerId).build(), requestOptions)

        /** @see list */
        fun list(
            containerId: String,
            params: FileListParams = FileListParams.none(),
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(containerId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: FileListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>>

        /** @see list */
        fun list(params: FileListParams): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            containerId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(containerId, FileListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /containers/{container_id}/files/{file_id}`, but
         * is otherwise the same as [FileServiceAsync.delete].
         */
        fun delete(fileId: String, params: FileDeleteParams): CompletableFuture<HttpResponse> =
            delete(fileId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            fileId: String,
            params: FileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see delete */
        fun delete(params: FileDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: FileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>
    }
}
