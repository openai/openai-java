// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.models.containers.ContainerCreateParams
import com.openai.models.containers.ContainerCreateResponse
import com.openai.models.containers.ContainerDeleteParams
import com.openai.models.containers.ContainerListPage
import com.openai.models.containers.ContainerListParams
import com.openai.models.containers.ContainerRetrieveParams
import com.openai.models.containers.ContainerRetrieveResponse
import com.openai.services.blocking.containers.FileService
import java.util.function.Consumer

interface ContainerService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContainerService

    fun files(): FileService

    /** Create Container */
    fun create(params: ContainerCreateParams): ContainerCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ContainerCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContainerCreateResponse

    /** Retrieve Container */
    fun retrieve(containerId: String): ContainerRetrieveResponse =
        retrieve(containerId, ContainerRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        containerId: String,
        params: ContainerRetrieveParams = ContainerRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContainerRetrieveResponse =
        retrieve(params.toBuilder().containerId(containerId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        containerId: String,
        params: ContainerRetrieveParams = ContainerRetrieveParams.none(),
    ): ContainerRetrieveResponse = retrieve(containerId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ContainerRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContainerRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: ContainerRetrieveParams): ContainerRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(containerId: String, requestOptions: RequestOptions): ContainerRetrieveResponse =
        retrieve(containerId, ContainerRetrieveParams.none(), requestOptions)

    /** List Containers */
    fun list(): ContainerListPage = list(ContainerListParams.none())

    /** @see list */
    fun list(
        params: ContainerListParams = ContainerListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContainerListPage

    /** @see list */
    fun list(params: ContainerListParams = ContainerListParams.none()): ContainerListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): ContainerListPage =
        list(ContainerListParams.none(), requestOptions)

    /** Delete Container */
    fun delete(containerId: String) = delete(containerId, ContainerDeleteParams.none())

    /** @see delete */
    fun delete(
        containerId: String,
        params: ContainerDeleteParams = ContainerDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().containerId(containerId).build(), requestOptions)

    /** @see delete */
    fun delete(containerId: String, params: ContainerDeleteParams = ContainerDeleteParams.none()) =
        delete(containerId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ContainerDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    fun delete(params: ContainerDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(containerId: String, requestOptions: RequestOptions) =
        delete(containerId, ContainerDeleteParams.none(), requestOptions)

    /** A view of [ContainerService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContainerService.WithRawResponse

        fun files(): FileService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /containers`, but is otherwise the same as
         * [ContainerService.create].
         */
        @MustBeClosed
        fun create(params: ContainerCreateParams): HttpResponseFor<ContainerCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ContainerCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContainerCreateResponse>

        /**
         * Returns a raw HTTP response for `get /containers/{container_id}`, but is otherwise the
         * same as [ContainerService.retrieve].
         */
        @MustBeClosed
        fun retrieve(containerId: String): HttpResponseFor<ContainerRetrieveResponse> =
            retrieve(containerId, ContainerRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            containerId: String,
            params: ContainerRetrieveParams = ContainerRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContainerRetrieveResponse> =
            retrieve(params.toBuilder().containerId(containerId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            containerId: String,
            params: ContainerRetrieveParams = ContainerRetrieveParams.none(),
        ): HttpResponseFor<ContainerRetrieveResponse> =
            retrieve(containerId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ContainerRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContainerRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ContainerRetrieveParams): HttpResponseFor<ContainerRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            containerId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContainerRetrieveResponse> =
            retrieve(containerId, ContainerRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /containers`, but is otherwise the same as
         * [ContainerService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<ContainerListPage> = list(ContainerListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ContainerListParams = ContainerListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContainerListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: ContainerListParams = ContainerListParams.none()
        ): HttpResponseFor<ContainerListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ContainerListPage> =
            list(ContainerListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /containers/{container_id}`, but is otherwise the
         * same as [ContainerService.delete].
         */
        @MustBeClosed
        fun delete(containerId: String): HttpResponse =
            delete(containerId, ContainerDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            containerId: String,
            params: ContainerDeleteParams = ContainerDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse =
            delete(params.toBuilder().containerId(containerId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            containerId: String,
            params: ContainerDeleteParams = ContainerDeleteParams.none(),
        ): HttpResponse = delete(containerId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ContainerDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(params: ContainerDeleteParams): HttpResponse =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(containerId: String, requestOptions: RequestOptions): HttpResponse =
            delete(containerId, ContainerDeleteParams.none(), requestOptions)
    }
}
