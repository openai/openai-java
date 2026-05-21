// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.spendalerts.ProjectSpendAlert
import com.openai.models.admin.organization.projects.spendalerts.ProjectSpendAlertDeleted
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertCreateParams
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertDeleteParams
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertListPage
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertListParams
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertUpdateParams
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

    /** Creates a project spend alert. */
    fun create(projectId: String, params: SpendAlertCreateParams): ProjectSpendAlert =
        create(projectId, params, RequestOptions.none())

    /** @see create */
    fun create(
        projectId: String,
        params: SpendAlertCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectSpendAlert = create(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see create */
    fun create(params: SpendAlertCreateParams): ProjectSpendAlert =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: SpendAlertCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectSpendAlert

    /** Updates a project spend alert. */
    fun update(alertId: String, params: SpendAlertUpdateParams): ProjectSpendAlert =
        update(alertId, params, RequestOptions.none())

    /** @see update */
    fun update(
        alertId: String,
        params: SpendAlertUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectSpendAlert = update(params.toBuilder().alertId(alertId).build(), requestOptions)

    /** @see update */
    fun update(params: SpendAlertUpdateParams): ProjectSpendAlert =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: SpendAlertUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectSpendAlert

    /** Lists project spend alerts. */
    fun list(projectId: String): SpendAlertListPage = list(projectId, SpendAlertListParams.none())

    /** @see list */
    fun list(
        projectId: String,
        params: SpendAlertListParams = SpendAlertListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpendAlertListPage = list(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see list */
    fun list(
        projectId: String,
        params: SpendAlertListParams = SpendAlertListParams.none(),
    ): SpendAlertListPage = list(projectId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: SpendAlertListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpendAlertListPage

    /** @see list */
    fun list(params: SpendAlertListParams): SpendAlertListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(projectId: String, requestOptions: RequestOptions): SpendAlertListPage =
        list(projectId, SpendAlertListParams.none(), requestOptions)

    /** Deletes a project spend alert. */
    fun delete(alertId: String, params: SpendAlertDeleteParams): ProjectSpendAlertDeleted =
        delete(alertId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        alertId: String,
        params: SpendAlertDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectSpendAlertDeleted =
        delete(params.toBuilder().alertId(alertId).build(), requestOptions)

    /** @see delete */
    fun delete(params: SpendAlertDeleteParams): ProjectSpendAlertDeleted =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: SpendAlertDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectSpendAlertDeleted

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
         * Returns a raw HTTP response for `post /organization/projects/{project_id}/spend_alerts`,
         * but is otherwise the same as [SpendAlertService.create].
         */
        @MustBeClosed
        fun create(
            projectId: String,
            params: SpendAlertCreateParams,
        ): HttpResponseFor<ProjectSpendAlert> = create(projectId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            projectId: String,
            params: SpendAlertCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectSpendAlert> =
            create(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: SpendAlertCreateParams): HttpResponseFor<ProjectSpendAlert> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: SpendAlertCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectSpendAlert>

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/spend_alerts/{alert_id}`, but is otherwise the same
         * as [SpendAlertService.update].
         */
        @MustBeClosed
        fun update(
            alertId: String,
            params: SpendAlertUpdateParams,
        ): HttpResponseFor<ProjectSpendAlert> = update(alertId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            alertId: String,
            params: SpendAlertUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectSpendAlert> =
            update(params.toBuilder().alertId(alertId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: SpendAlertUpdateParams): HttpResponseFor<ProjectSpendAlert> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: SpendAlertUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectSpendAlert>

        /**
         * Returns a raw HTTP response for `get /organization/projects/{project_id}/spend_alerts`,
         * but is otherwise the same as [SpendAlertService.list].
         */
        @MustBeClosed
        fun list(projectId: String): HttpResponseFor<SpendAlertListPage> =
            list(projectId, SpendAlertListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            params: SpendAlertListParams = SpendAlertListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpendAlertListPage> =
            list(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            params: SpendAlertListParams = SpendAlertListParams.none(),
        ): HttpResponseFor<SpendAlertListPage> = list(projectId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: SpendAlertListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpendAlertListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: SpendAlertListParams): HttpResponseFor<SpendAlertListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SpendAlertListPage> =
            list(projectId, SpendAlertListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /organization/projects/{project_id}/spend_alerts/{alert_id}`, but is otherwise the same
         * as [SpendAlertService.delete].
         */
        @MustBeClosed
        fun delete(
            alertId: String,
            params: SpendAlertDeleteParams,
        ): HttpResponseFor<ProjectSpendAlertDeleted> =
            delete(alertId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            alertId: String,
            params: SpendAlertDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectSpendAlertDeleted> =
            delete(params.toBuilder().alertId(alertId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: SpendAlertDeleteParams): HttpResponseFor<ProjectSpendAlertDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: SpendAlertDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectSpendAlertDeleted>
    }
}
