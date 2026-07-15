// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.dataretention.DataRetentionRetrieveParams
import com.openai.models.admin.organization.dataretention.DataRetentionUpdateParams
import com.openai.models.admin.organization.dataretention.OrganizationDataRetention
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface DataRetentionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): DataRetentionServiceAsync

    /** Retrieves organization data retention controls. */
    fun retrieve(): CompletableFuture<OrganizationDataRetention> =
        retrieve(DataRetentionRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        params: DataRetentionRetrieveParams = DataRetentionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationDataRetention>

    /** @see retrieve */
    fun retrieve(
        params: DataRetentionRetrieveParams = DataRetentionRetrieveParams.none()
    ): CompletableFuture<OrganizationDataRetention> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(requestOptions: RequestOptions): CompletableFuture<OrganizationDataRetention> =
        retrieve(DataRetentionRetrieveParams.none(), requestOptions)

    /** Updates organization data retention controls. */
    fun update(params: DataRetentionUpdateParams): CompletableFuture<OrganizationDataRetention> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: DataRetentionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationDataRetention>

    /**
     * A view of [DataRetentionServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): DataRetentionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organization/data_retention`, but is otherwise the
         * same as [DataRetentionServiceAsync.retrieve].
         */
        fun retrieve(): CompletableFuture<HttpResponseFor<OrganizationDataRetention>> =
            retrieve(DataRetentionRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            params: DataRetentionRetrieveParams = DataRetentionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationDataRetention>>

        /** @see retrieve */
        fun retrieve(
            params: DataRetentionRetrieveParams = DataRetentionRetrieveParams.none()
        ): CompletableFuture<HttpResponseFor<OrganizationDataRetention>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<OrganizationDataRetention>> =
            retrieve(DataRetentionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /organization/data_retention`, but is otherwise the
         * same as [DataRetentionServiceAsync.update].
         */
        fun update(
            params: DataRetentionUpdateParams
        ): CompletableFuture<HttpResponseFor<OrganizationDataRetention>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: DataRetentionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationDataRetention>>
    }
}
