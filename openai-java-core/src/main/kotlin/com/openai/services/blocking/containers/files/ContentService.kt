// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.containers.files

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.models.containers.files.content.ContentRetrieveParams
import java.util.function.Consumer

interface ContentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContentService

    /** Retrieve Container File Content */
    @MustBeClosed
    fun retrieve(fileId: String, params: ContentRetrieveParams): HttpResponse =
        retrieve(fileId, params, RequestOptions.none())

    /** @see [retrieve] */
    @MustBeClosed
    fun retrieve(
        fileId: String,
        params: ContentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse = retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

    /** @see [retrieve] */
    @MustBeClosed
    fun retrieve(params: ContentRetrieveParams): HttpResponse =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    @MustBeClosed
    fun retrieve(
        params: ContentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse

    /** A view of [ContentService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContentService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /containers/{container_id}/files/{file_id}/content`,
         * but is otherwise the same as [ContentService.retrieve].
         */
        @MustBeClosed
        fun retrieve(fileId: String, params: ContentRetrieveParams): HttpResponse =
            retrieve(fileId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            fileId: String,
            params: ContentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = retrieve(params.toBuilder().fileId(fileId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: ContentRetrieveParams): HttpResponse =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: ContentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
