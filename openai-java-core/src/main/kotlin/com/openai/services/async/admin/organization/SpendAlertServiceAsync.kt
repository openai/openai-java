// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.spendalerts.OrganizationSpendAlert
import com.openai.models.admin.organization.spendalerts.OrganizationSpendAlertDeleted
import com.openai.models.admin.organization.spendalerts.SpendAlertCreateParams
import com.openai.models.admin.organization.spendalerts.SpendAlertDeleteParams
import com.openai.models.admin.organization.spendalerts.SpendAlertListPageAsync
import com.openai.models.admin.organization.spendalerts.SpendAlertListParams
import com.openai.models.admin.organization.spendalerts.SpendAlertRetrieveParams
import com.openai.models.admin.organization.spendalerts.SpendAlertUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface SpendAlertServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpendAlertServiceAsync

    /** Creates an organization spend alert. */
    fun create(params: SpendAlertCreateParams): CompletableFuture<OrganizationSpendAlert> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: SpendAlertCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationSpendAlert>

    /** Retrieves an organization spend alert. */
    fun retrieve(alertId: String): CompletableFuture<OrganizationSpendAlert> =
        retrieve(alertId, SpendAlertRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        alertId: String,
        params: SpendAlertRetrieveParams = SpendAlertRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationSpendAlert> =
        retrieve(params.toBuilder().alertId(alertId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        alertId: String,
        params: SpendAlertRetrieveParams = SpendAlertRetrieveParams.none(),
    ): CompletableFuture<OrganizationSpendAlert> = retrieve(alertId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: SpendAlertRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationSpendAlert>

    /** @see retrieve */
    fun retrieve(params: SpendAlertRetrieveParams): CompletableFuture<OrganizationSpendAlert> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        alertId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<OrganizationSpendAlert> =
        retrieve(alertId, SpendAlertRetrieveParams.none(), requestOptions)

    /** Updates an organization spend alert. */
    fun update(
        alertId: String,
        params: SpendAlertUpdateParams,
    ): CompletableFuture<OrganizationSpendAlert> = update(alertId, params, RequestOptions.none())

    /** @see update */
    fun update(
        alertId: String,
        params: SpendAlertUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationSpendAlert> =
        update(params.toBuilder().alertId(alertId).build(), requestOptions)

    /** @see update */
    fun update(params: SpendAlertUpdateParams): CompletableFuture<OrganizationSpendAlert> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: SpendAlertUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationSpendAlert>

    /** Lists organization spend alerts. */
    fun list(): CompletableFuture<SpendAlertListPageAsync> = list(SpendAlertListParams.none())

    /** @see list */
    fun list(
        params: SpendAlertListParams = SpendAlertListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SpendAlertListPageAsync>

    /** @see list */
    fun list(
        params: SpendAlertListParams = SpendAlertListParams.none()
    ): CompletableFuture<SpendAlertListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<SpendAlertListPageAsync> =
        list(SpendAlertListParams.none(), requestOptions)

    /** Deletes an organization spend alert. */
    fun delete(alertId: String): CompletableFuture<OrganizationSpendAlertDeleted> =
        delete(alertId, SpendAlertDeleteParams.none())

    /** @see delete */
    fun delete(
        alertId: String,
        params: SpendAlertDeleteParams = SpendAlertDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationSpendAlertDeleted> =
        delete(params.toBuilder().alertId(alertId).build(), requestOptions)

    /** @see delete */
    fun delete(
        alertId: String,
        params: SpendAlertDeleteParams = SpendAlertDeleteParams.none(),
    ): CompletableFuture<OrganizationSpendAlertDeleted> =
        delete(alertId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: SpendAlertDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationSpendAlertDeleted>

    /** @see delete */
    fun delete(params: SpendAlertDeleteParams): CompletableFuture<OrganizationSpendAlertDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        alertId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<OrganizationSpendAlertDeleted> =
        delete(alertId, SpendAlertDeleteParams.none(), requestOptions)

    /**
     * A view of [SpendAlertServiceAsync] that provides access to raw HTTP responses for each
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
        ): SpendAlertServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/spend_alerts`, but is otherwise the
         * same as [SpendAlertServiceAsync.create].
         */
        fun create(
            params: SpendAlertCreateParams
        ): CompletableFuture<HttpResponseFor<OrganizationSpendAlert>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: SpendAlertCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationSpendAlert>>

        /**
         * Returns a raw HTTP response for `get /organization/spend_alerts/{alert_id}`, but is
         * otherwise the same as [SpendAlertServiceAsync.retrieve].
         */
        fun retrieve(alertId: String): CompletableFuture<HttpResponseFor<OrganizationSpendAlert>> =
            retrieve(alertId, SpendAlertRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            alertId: String,
            params: SpendAlertRetrieveParams = SpendAlertRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationSpendAlert>> =
            retrieve(params.toBuilder().alertId(alertId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            alertId: String,
            params: SpendAlertRetrieveParams = SpendAlertRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationSpendAlert>> =
            retrieve(alertId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: SpendAlertRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationSpendAlert>>

        /** @see retrieve */
        fun retrieve(
            params: SpendAlertRetrieveParams
        ): CompletableFuture<HttpResponseFor<OrganizationSpendAlert>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            alertId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OrganizationSpendAlert>> =
            retrieve(alertId, SpendAlertRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /organization/spend_alerts/{alert_id}`, but is
         * otherwise the same as [SpendAlertServiceAsync.update].
         */
        fun update(
            alertId: String,
            params: SpendAlertUpdateParams,
        ): CompletableFuture<HttpResponseFor<OrganizationSpendAlert>> =
            update(alertId, params, RequestOptions.none())

        /** @see update */
        fun update(
            alertId: String,
            params: SpendAlertUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationSpendAlert>> =
            update(params.toBuilder().alertId(alertId).build(), requestOptions)

        /** @see update */
        fun update(
            params: SpendAlertUpdateParams
        ): CompletableFuture<HttpResponseFor<OrganizationSpendAlert>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: SpendAlertUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationSpendAlert>>

        /**
         * Returns a raw HTTP response for `get /organization/spend_alerts`, but is otherwise the
         * same as [SpendAlertServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<SpendAlertListPageAsync>> =
            list(SpendAlertListParams.none())

        /** @see list */
        fun list(
            params: SpendAlertListParams = SpendAlertListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SpendAlertListPageAsync>>

        /** @see list */
        fun list(
            params: SpendAlertListParams = SpendAlertListParams.none()
        ): CompletableFuture<HttpResponseFor<SpendAlertListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<SpendAlertListPageAsync>> =
            list(SpendAlertListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/spend_alerts/{alert_id}`, but is
         * otherwise the same as [SpendAlertServiceAsync.delete].
         */
        fun delete(
            alertId: String
        ): CompletableFuture<HttpResponseFor<OrganizationSpendAlertDeleted>> =
            delete(alertId, SpendAlertDeleteParams.none())

        /** @see delete */
        fun delete(
            alertId: String,
            params: SpendAlertDeleteParams = SpendAlertDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationSpendAlertDeleted>> =
            delete(params.toBuilder().alertId(alertId).build(), requestOptions)

        /** @see delete */
        fun delete(
            alertId: String,
            params: SpendAlertDeleteParams = SpendAlertDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationSpendAlertDeleted>> =
            delete(alertId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: SpendAlertDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationSpendAlertDeleted>>

        /** @see delete */
        fun delete(
            params: SpendAlertDeleteParams
        ): CompletableFuture<HttpResponseFor<OrganizationSpendAlertDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            alertId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OrganizationSpendAlertDeleted>> =
            delete(alertId, SpendAlertDeleteParams.none(), requestOptions)
    }
}
