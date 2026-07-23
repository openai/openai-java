// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.spendlimit.OrganizationSpendLimit
import com.openai.models.admin.organization.spendlimit.OrganizationSpendLimitDeleted
import com.openai.models.admin.organization.spendlimit.SpendLimitDeleteParams
import com.openai.models.admin.organization.spendlimit.SpendLimitRetrieveParams
import com.openai.models.admin.organization.spendlimit.SpendLimitUpdateParams
import java.util.function.Consumer

interface SpendLimitService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpendLimitService

    /** Get the organization's hard spend limit. */
    fun retrieve(): OrganizationSpendLimit = retrieve(SpendLimitRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        params: SpendLimitRetrieveParams = SpendLimitRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationSpendLimit

    /** @see retrieve */
    fun retrieve(
        params: SpendLimitRetrieveParams = SpendLimitRetrieveParams.none()
    ): OrganizationSpendLimit = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(requestOptions: RequestOptions): OrganizationSpendLimit =
        retrieve(SpendLimitRetrieveParams.none(), requestOptions)

    /** Create or replace the organization's hard spend limit. */
    fun update(params: SpendLimitUpdateParams): OrganizationSpendLimit =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: SpendLimitUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationSpendLimit

    /** Delete the organization's hard spend limit. */
    fun delete(): OrganizationSpendLimitDeleted = delete(SpendLimitDeleteParams.none())

    /** @see delete */
    fun delete(
        params: SpendLimitDeleteParams = SpendLimitDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationSpendLimitDeleted

    /** @see delete */
    fun delete(
        params: SpendLimitDeleteParams = SpendLimitDeleteParams.none()
    ): OrganizationSpendLimitDeleted = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(requestOptions: RequestOptions): OrganizationSpendLimitDeleted =
        delete(SpendLimitDeleteParams.none(), requestOptions)

    /** A view of [SpendLimitService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SpendLimitService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organization/spend_limit`, but is otherwise the
         * same as [SpendLimitService.retrieve].
         */
        @MustBeClosed
        fun retrieve(): HttpResponseFor<OrganizationSpendLimit> =
            retrieve(SpendLimitRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: SpendLimitRetrieveParams = SpendLimitRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationSpendLimit>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: SpendLimitRetrieveParams = SpendLimitRetrieveParams.none()
        ): HttpResponseFor<OrganizationSpendLimit> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(requestOptions: RequestOptions): HttpResponseFor<OrganizationSpendLimit> =
            retrieve(SpendLimitRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /organization/spend_limit`, but is otherwise the
         * same as [SpendLimitService.update].
         */
        @MustBeClosed
        fun update(params: SpendLimitUpdateParams): HttpResponseFor<OrganizationSpendLimit> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: SpendLimitUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationSpendLimit>

        /**
         * Returns a raw HTTP response for `delete /organization/spend_limit`, but is otherwise the
         * same as [SpendLimitService.delete].
         */
        @MustBeClosed
        fun delete(): HttpResponseFor<OrganizationSpendLimitDeleted> =
            delete(SpendLimitDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: SpendLimitDeleteParams = SpendLimitDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationSpendLimitDeleted>

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: SpendLimitDeleteParams = SpendLimitDeleteParams.none()
        ): HttpResponseFor<OrganizationSpendLimitDeleted> = delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(requestOptions: RequestOptions): HttpResponseFor<OrganizationSpendLimitDeleted> =
            delete(SpendLimitDeleteParams.none(), requestOptions)
    }
}
