// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.models.containers.ContainerCreateParams
import com.openai.models.containers.ContainerCreateResponse
import com.openai.models.containers.ContainerDeleteParams
import com.openai.models.containers.ContainerListPageAsync
import com.openai.models.containers.ContainerListParams
import com.openai.models.containers.ContainerRetrieveParams
import com.openai.models.containers.ContainerRetrieveResponse
import com.openai.services.async.containers.FileServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ContainerServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContainerServiceAsync

    fun files(): FileServiceAsync

    /** Create Container */
    fun create(params: ContainerCreateParams): CompletableFuture<ContainerCreateResponse> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: ContainerCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContainerCreateResponse>

    /** Retrieve Container */
    fun retrieve(containerId: String): CompletableFuture<ContainerRetrieveResponse> =
        retrieve(containerId, ContainerRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        containerId: String,
        params: ContainerRetrieveParams = ContainerRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContainerRetrieveResponse> =
        retrieve(params.toBuilder().containerId(containerId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        containerId: String,
        params: ContainerRetrieveParams = ContainerRetrieveParams.none(),
    ): CompletableFuture<ContainerRetrieveResponse> =
        retrieve(containerId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: ContainerRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContainerRetrieveResponse>

    /** @see [retrieve] */
    fun retrieve(params: ContainerRetrieveParams): CompletableFuture<ContainerRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        containerId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ContainerRetrieveResponse> =
        retrieve(containerId, ContainerRetrieveParams.none(), requestOptions)

    /** List Containers */
    fun list(): CompletableFuture<ContainerListPageAsync> = list(ContainerListParams.none())

    /** @see [list] */
    fun list(
        params: ContainerListParams = ContainerListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContainerListPageAsync>

    /** @see [list] */
    fun list(
        params: ContainerListParams = ContainerListParams.none()
    ): CompletableFuture<ContainerListPageAsync> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<ContainerListPageAsync> =
        list(ContainerListParams.none(), requestOptions)

    /** Delete Container */
    fun delete(containerId: String): CompletableFuture<Void?> =
        delete(containerId, ContainerDeleteParams.none())

    /** @see [delete] */
    fun delete(
        containerId: String,
        params: ContainerDeleteParams = ContainerDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> =
        delete(params.toBuilder().containerId(containerId).build(), requestOptions)

    /** @see [delete] */
    fun delete(
        containerId: String,
        params: ContainerDeleteParams = ContainerDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(containerId, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ContainerDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see [delete] */
    fun delete(params: ContainerDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(containerId: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(containerId, ContainerDeleteParams.none(), requestOptions)

    /**
     * A view of [ContainerServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ContainerServiceAsync.WithRawResponse

        fun files(): FileServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /containers`, but is otherwise the same as
         * [ContainerServiceAsync.create].
         */
        fun create(
            params: ContainerCreateParams
        ): CompletableFuture<HttpResponseFor<ContainerCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        fun create(
            params: ContainerCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContainerCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /containers/{container_id}`, but is otherwise the
         * same as [ContainerServiceAsync.retrieve].
         */
        fun retrieve(
            containerId: String
        ): CompletableFuture<HttpResponseFor<ContainerRetrieveResponse>> =
            retrieve(containerId, ContainerRetrieveParams.none())

        /** @see [retrieve] */
        fun retrieve(
            containerId: String,
            params: ContainerRetrieveParams = ContainerRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContainerRetrieveResponse>> =
            retrieve(params.toBuilder().containerId(containerId).build(), requestOptions)

        /** @see [retrieve] */
        fun retrieve(
            containerId: String,
            params: ContainerRetrieveParams = ContainerRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ContainerRetrieveResponse>> =
            retrieve(containerId, params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            params: ContainerRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContainerRetrieveResponse>>

        /** @see [retrieve] */
        fun retrieve(
            params: ContainerRetrieveParams
        ): CompletableFuture<HttpResponseFor<ContainerRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            containerId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ContainerRetrieveResponse>> =
            retrieve(containerId, ContainerRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /containers`, but is otherwise the same as
         * [ContainerServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<ContainerListPageAsync>> =
            list(ContainerListParams.none())

        /** @see [list] */
        fun list(
            params: ContainerListParams = ContainerListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContainerListPageAsync>>

        /** @see [list] */
        fun list(
            params: ContainerListParams = ContainerListParams.none()
        ): CompletableFuture<HttpResponseFor<ContainerListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ContainerListPageAsync>> =
            list(ContainerListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /containers/{container_id}`, but is otherwise the
         * same as [ContainerServiceAsync.delete].
         */
        fun delete(containerId: String): CompletableFuture<HttpResponse> =
            delete(containerId, ContainerDeleteParams.none())

        /** @see [delete] */
        fun delete(
            containerId: String,
            params: ContainerDeleteParams = ContainerDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().containerId(containerId).build(), requestOptions)

        /** @see [delete] */
        fun delete(
            containerId: String,
            params: ContainerDeleteParams = ContainerDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(containerId, params, RequestOptions.none())

        /** @see [delete] */
        fun delete(
            params: ContainerDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see [delete] */
        fun delete(params: ContainerDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        fun delete(
            containerId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            delete(containerId, ContainerDeleteParams.none(), requestOptions)
    }
}
