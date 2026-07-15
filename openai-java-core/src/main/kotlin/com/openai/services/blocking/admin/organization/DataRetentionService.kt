// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.dataretention.DataRetentionRetrieveParams
import com.openai.models.admin.organization.dataretention.DataRetentionUpdateParams
import com.openai.models.admin.organization.dataretention.OrganizationDataRetention
import java.util.function.Consumer

interface DataRetentionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): DataRetentionService

    /** Retrieves organization data retention controls. */
    fun retrieve(): OrganizationDataRetention = retrieve(DataRetentionRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        params: DataRetentionRetrieveParams = DataRetentionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationDataRetention

    /** @see retrieve */
    fun retrieve(
        params: DataRetentionRetrieveParams = DataRetentionRetrieveParams.none()
    ): OrganizationDataRetention = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(requestOptions: RequestOptions): OrganizationDataRetention =
        retrieve(DataRetentionRetrieveParams.none(), requestOptions)

    /** Updates organization data retention controls. */
    fun update(params: DataRetentionUpdateParams): OrganizationDataRetention =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: DataRetentionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationDataRetention

    /**
     * A view of [DataRetentionService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): DataRetentionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organization/data_retention`, but is otherwise the
         * same as [DataRetentionService.retrieve].
         */
        @MustBeClosed
        fun retrieve(): HttpResponseFor<OrganizationDataRetention> =
            retrieve(DataRetentionRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: DataRetentionRetrieveParams = DataRetentionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationDataRetention>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: DataRetentionRetrieveParams = DataRetentionRetrieveParams.none()
        ): HttpResponseFor<OrganizationDataRetention> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(requestOptions: RequestOptions): HttpResponseFor<OrganizationDataRetention> =
            retrieve(DataRetentionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /organization/data_retention`, but is otherwise the
         * same as [DataRetentionService.update].
         */
        @MustBeClosed
        fun update(params: DataRetentionUpdateParams): HttpResponseFor<OrganizationDataRetention> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: DataRetentionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationDataRetention>
    }
}
