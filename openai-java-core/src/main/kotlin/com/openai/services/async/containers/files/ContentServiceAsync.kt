// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.containers.files

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.models.containers.files.content.ContentRetrieveParams
import java.util.concurrent.CompletableFuture

interface ContentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Retrieve Container File Content */
    fun retrieve(fileId: String, params: ContentRetrieveParams): CompletableFuture<Void?> =
        retrieve(fileId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        fileId: String,
        params: ContentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> =
        retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(params: ContentRetrieveParams): CompletableFuture<Void?> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: ContentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /**
     * A view of [ContentServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /containers/{container_id}/files/{file_id}/content`,
         * but is otherwise the same as [ContentServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            fileId: String,
            params: ContentRetrieveParams,
        ): CompletableFuture<HttpResponse> = retrieve(fileId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            fileId: String,
            params: ContentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: ContentRetrieveParams): CompletableFuture<HttpResponse> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: ContentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>
    }
}
