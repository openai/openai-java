// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.spendlimit.OrganizationSpendLimit
import com.openai.models.admin.organization.spendlimit.OrganizationSpendLimitDeleted
import com.openai.models.admin.organization.spendlimit.SpendLimitDeleteParams
import com.openai.models.admin.organization.spendlimit.SpendLimitRetrieveParams
import com.openai.models.admin.organization.spendlimit.SpendLimitUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface SpendLimitServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpendLimitServiceAsync

    /** Get the organization's hard spend limit. */
    fun retrieve(): CompletableFuture<OrganizationSpendLimit> =
        retrieve(SpendLimitRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        params: SpendLimitRetrieveParams = SpendLimitRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationSpendLimit>

    /** @see retrieve */
    fun retrieve(
        params: SpendLimitRetrieveParams = SpendLimitRetrieveParams.none()
    ): CompletableFuture<OrganizationSpendLimit> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(requestOptions: RequestOptions): CompletableFuture<OrganizationSpendLimit> =
        retrieve(SpendLimitRetrieveParams.none(), requestOptions)

    /** Create or replace the organization's hard spend limit. */
    fun update(params: SpendLimitUpdateParams): CompletableFuture<OrganizationSpendLimit> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: SpendLimitUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationSpendLimit>

    /** Delete the organization's hard spend limit. */
    fun delete(): CompletableFuture<OrganizationSpendLimitDeleted> =
        delete(SpendLimitDeleteParams.none())

    /** @see delete */
    fun delete(
        params: SpendLimitDeleteParams = SpendLimitDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationSpendLimitDeleted>

    /** @see delete */
    fun delete(
        params: SpendLimitDeleteParams = SpendLimitDeleteParams.none()
    ): CompletableFuture<OrganizationSpendLimitDeleted> = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(requestOptions: RequestOptions): CompletableFuture<OrganizationSpendLimitDeleted> =
        delete(SpendLimitDeleteParams.none(), requestOptions)

    /**
     * A view of [SpendLimitServiceAsync] that provides access to raw HTTP responses for each
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
        ): SpendLimitServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organization/spend_limit`, but is otherwise the
         * same as [SpendLimitServiceAsync.retrieve].
         */
        fun retrieve(): CompletableFuture<HttpResponseFor<OrganizationSpendLimit>> =
            retrieve(SpendLimitRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            params: SpendLimitRetrieveParams = SpendLimitRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationSpendLimit>>

        /** @see retrieve */
        fun retrieve(
            params: SpendLimitRetrieveParams = SpendLimitRetrieveParams.none()
        ): CompletableFuture<HttpResponseFor<OrganizationSpendLimit>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<OrganizationSpendLimit>> =
            retrieve(SpendLimitRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /organization/spend_limit`, but is otherwise the
         * same as [SpendLimitServiceAsync.update].
         */
        fun update(
            params: SpendLimitUpdateParams
        ): CompletableFuture<HttpResponseFor<OrganizationSpendLimit>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: SpendLimitUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationSpendLimit>>

        /**
         * Returns a raw HTTP response for `delete /organization/spend_limit`, but is otherwise the
         * same as [SpendLimitServiceAsync.delete].
         */
        fun delete(): CompletableFuture<HttpResponseFor<OrganizationSpendLimitDeleted>> =
            delete(SpendLimitDeleteParams.none())

        /** @see delete */
        fun delete(
            params: SpendLimitDeleteParams = SpendLimitDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationSpendLimitDeleted>>

        /** @see delete */
        fun delete(
            params: SpendLimitDeleteParams = SpendLimitDeleteParams.none()
        ): CompletableFuture<HttpResponseFor<OrganizationSpendLimitDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<OrganizationSpendLimitDeleted>> =
            delete(SpendLimitDeleteParams.none(), requestOptions)
    }
}
