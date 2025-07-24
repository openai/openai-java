// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.containers

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.models.containers.files.FileCreateParams
import com.openai.models.containers.files.FileCreateResponse
import com.openai.models.containers.files.FileDeleteParams
import com.openai.models.containers.files.FileListPage
import com.openai.models.containers.files.FileListParams
import com.openai.models.containers.files.FileRetrieveParams
import com.openai.models.containers.files.FileRetrieveResponse
import com.openai.services.blocking.containers.files.ContentService
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

    fun content(): ContentService

    /**
     * Create a Container File
     *
     * You can send either a multipart/form-data request with the raw file content, or a JSON
     * request with a file ID.
     */
    fun create(containerId: String): FileCreateResponse =
        create(containerId, FileCreateParams.none())

    /** @see create */
    fun create(
        containerId: String,
        params: FileCreateParams = FileCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileCreateResponse =
        create(params.toBuilder().containerId(containerId).build(), requestOptions)

    /** @see create */
    fun create(
        containerId: String,
        params: FileCreateParams = FileCreateParams.none(),
    ): FileCreateResponse = create(containerId, params, RequestOptions.none())

    /** @see create */
    fun create(
        params: FileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileCreateResponse

    /** @see create */
    fun create(params: FileCreateParams): FileCreateResponse = create(params, RequestOptions.none())

    /** @see create */
    fun create(containerId: String, requestOptions: RequestOptions): FileCreateResponse =
        create(containerId, FileCreateParams.none(), requestOptions)

    /** Retrieve Container File */
    fun retrieve(fileId: String, params: FileRetrieveParams): FileRetrieveResponse =
        retrieve(fileId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        fileId: String,
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileRetrieveResponse = retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: FileRetrieveParams): FileRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileRetrieveResponse

    /** List Container files */
    fun list(containerId: String): FileListPage = list(containerId, FileListParams.none())

    /** @see list */
    fun list(
        containerId: String,
        params: FileListParams = FileListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileListPage = list(params.toBuilder().containerId(containerId).build(), requestOptions)

    /** @see list */
    fun list(containerId: String, params: FileListParams = FileListParams.none()): FileListPage =
        list(containerId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: FileListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileListPage

    /** @see list */
    fun list(params: FileListParams): FileListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(containerId: String, requestOptions: RequestOptions): FileListPage =
        list(containerId, FileListParams.none(), requestOptions)

    /** Delete Container File */
    fun delete(fileId: String, params: FileDeleteParams) =
        delete(fileId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        fileId: String,
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see delete */
    fun delete(params: FileDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(params: FileDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** A view of [FileService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileService.WithRawResponse

        fun content(): ContentService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /containers/{container_id}/files`, but is otherwise
         * the same as [FileService.create].
         */
        @MustBeClosed
        fun create(containerId: String): HttpResponseFor<FileCreateResponse> =
            create(containerId, FileCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            containerId: String,
            params: FileCreateParams = FileCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileCreateResponse> =
            create(params.toBuilder().containerId(containerId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(
            containerId: String,
            params: FileCreateParams = FileCreateParams.none(),
        ): HttpResponseFor<FileCreateResponse> = create(containerId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: FileCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileCreateResponse>

        /** @see create */
        @MustBeClosed
        fun create(params: FileCreateParams): HttpResponseFor<FileCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            containerId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileCreateResponse> =
            create(containerId, FileCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /containers/{container_id}/files/{file_id}`, but is
         * otherwise the same as [FileService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            fileId: String,
            params: FileRetrieveParams,
        ): HttpResponseFor<FileRetrieveResponse> = retrieve(fileId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            fileId: String,
            params: FileRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileRetrieveResponse> =
            retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: FileRetrieveParams): HttpResponseFor<FileRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: FileRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileRetrieveResponse>

        /**
         * Returns a raw HTTP response for `get /containers/{container_id}/files`, but is otherwise
         * the same as [FileService.list].
         */
        @MustBeClosed
        fun list(containerId: String): HttpResponseFor<FileListPage> =
            list(containerId, FileListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            containerId: String,
            params: FileListParams = FileListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileListPage> =
            list(params.toBuilder().containerId(containerId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            containerId: String,
            params: FileListParams = FileListParams.none(),
        ): HttpResponseFor<FileListPage> = list(containerId, params, RequestOptions.none())

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
            containerId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileListPage> = list(containerId, FileListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /containers/{container_id}/files/{file_id}`, but
         * is otherwise the same as [FileService.delete].
         */
        @MustBeClosed
        fun delete(fileId: String, params: FileDeleteParams): HttpResponse =
            delete(fileId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            fileId: String,
            params: FileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: FileDeleteParams): HttpResponse = delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: FileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
