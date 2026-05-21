// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.spendalerts.OrganizationSpendAlert
import com.openai.models.admin.organization.spendalerts.OrganizationSpendAlertDeleted
import com.openai.models.admin.organization.spendalerts.SpendAlertCreateParams
import com.openai.models.admin.organization.spendalerts.SpendAlertDeleteParams
import com.openai.models.admin.organization.spendalerts.SpendAlertListPage
import com.openai.models.admin.organization.spendalerts.SpendAlertListParams
import com.openai.models.admin.organization.spendalerts.SpendAlertUpdateParams
import java.util.function.Consumer

interface SpendAlertService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpendAlertService

    /** Creates an organization spend alert. */
    fun create(params: SpendAlertCreateParams): OrganizationSpendAlert =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: SpendAlertCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationSpendAlert

    /** Updates an organization spend alert. */
    fun update(alertId: String, params: SpendAlertUpdateParams): OrganizationSpendAlert =
        update(alertId, params, RequestOptions.none())

    /** @see update */
    fun update(
        alertId: String,
        params: SpendAlertUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationSpendAlert = update(params.toBuilder().alertId(alertId).build(), requestOptions)

    /** @see update */
    fun update(params: SpendAlertUpdateParams): OrganizationSpendAlert =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: SpendAlertUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationSpendAlert

    /** Lists organization spend alerts. */
    fun list(): SpendAlertListPage = list(SpendAlertListParams.none())

    /** @see list */
    fun list(
        params: SpendAlertListParams = SpendAlertListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpendAlertListPage

    /** @see list */
    fun list(params: SpendAlertListParams = SpendAlertListParams.none()): SpendAlertListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): SpendAlertListPage =
        list(SpendAlertListParams.none(), requestOptions)

    /** Deletes an organization spend alert. */
    fun delete(alertId: String): OrganizationSpendAlertDeleted =
        delete(alertId, SpendAlertDeleteParams.none())

    /** @see delete */
    fun delete(
        alertId: String,
        params: SpendAlertDeleteParams = SpendAlertDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationSpendAlertDeleted =
        delete(params.toBuilder().alertId(alertId).build(), requestOptions)

    /** @see delete */
    fun delete(
        alertId: String,
        params: SpendAlertDeleteParams = SpendAlertDeleteParams.none(),
    ): OrganizationSpendAlertDeleted = delete(alertId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: SpendAlertDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationSpendAlertDeleted

    /** @see delete */
    fun delete(params: SpendAlertDeleteParams): OrganizationSpendAlertDeleted =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(alertId: String, requestOptions: RequestOptions): OrganizationSpendAlertDeleted =
        delete(alertId, SpendAlertDeleteParams.none(), requestOptions)

    /** A view of [SpendAlertService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SpendAlertService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/spend_alerts`, but is otherwise the
         * same as [SpendAlertService.create].
         */
        @MustBeClosed
        fun create(params: SpendAlertCreateParams): HttpResponseFor<OrganizationSpendAlert> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: SpendAlertCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationSpendAlert>

        /**
         * Returns a raw HTTP response for `post /organization/spend_alerts/{alert_id}`, but is
         * otherwise the same as [SpendAlertService.update].
         */
        @MustBeClosed
        fun update(
            alertId: String,
            params: SpendAlertUpdateParams,
        ): HttpResponseFor<OrganizationSpendAlert> = update(alertId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            alertId: String,
            params: SpendAlertUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationSpendAlert> =
            update(params.toBuilder().alertId(alertId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: SpendAlertUpdateParams): HttpResponseFor<OrganizationSpendAlert> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: SpendAlertUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationSpendAlert>

        /**
         * Returns a raw HTTP response for `get /organization/spend_alerts`, but is otherwise the
         * same as [SpendAlertService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<SpendAlertListPage> = list(SpendAlertListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: SpendAlertListParams = SpendAlertListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpendAlertListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: SpendAlertListParams = SpendAlertListParams.none()
        ): HttpResponseFor<SpendAlertListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<SpendAlertListPage> =
            list(SpendAlertListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/spend_alerts/{alert_id}`, but is
         * otherwise the same as [SpendAlertService.delete].
         */
        @MustBeClosed
        fun delete(alertId: String): HttpResponseFor<OrganizationSpendAlertDeleted> =
            delete(alertId, SpendAlertDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            alertId: String,
            params: SpendAlertDeleteParams = SpendAlertDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationSpendAlertDeleted> =
            delete(params.toBuilder().alertId(alertId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            alertId: String,
            params: SpendAlertDeleteParams = SpendAlertDeleteParams.none(),
        ): HttpResponseFor<OrganizationSpendAlertDeleted> =
            delete(alertId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: SpendAlertDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationSpendAlertDeleted>

        /** @see delete */
        @MustBeClosed
        fun delete(params: SpendAlertDeleteParams): HttpResponseFor<OrganizationSpendAlertDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            alertId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationSpendAlertDeleted> =
            delete(alertId, SpendAlertDeleteParams.none(), requestOptions)
    }
}
