// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.spendalerts.ProjectSpendAlert
import com.openai.models.admin.organization.projects.spendalerts.ProjectSpendAlertDeleted
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertCreateParams
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertDeleteParams
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertListPageAsync
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertListParams
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertUpdateParams
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

    /** Creates a project spend alert. */
    fun create(
        projectId: String,
        params: SpendAlertCreateParams,
    ): CompletableFuture<ProjectSpendAlert> = create(projectId, params, RequestOptions.none())

    /** @see create */
    fun create(
        projectId: String,
        params: SpendAlertCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectSpendAlert> =
        create(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see create */
    fun create(params: SpendAlertCreateParams): CompletableFuture<ProjectSpendAlert> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: SpendAlertCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectSpendAlert>

    /** Updates a project spend alert. */
    fun update(
        alertId: String,
        params: SpendAlertUpdateParams,
    ): CompletableFuture<ProjectSpendAlert> = update(alertId, params, RequestOptions.none())

    /** @see update */
    fun update(
        alertId: String,
        params: SpendAlertUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectSpendAlert> =
        update(params.toBuilder().alertId(alertId).build(), requestOptions)

    /** @see update */
    fun update(params: SpendAlertUpdateParams): CompletableFuture<ProjectSpendAlert> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: SpendAlertUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectSpendAlert>

    /** Lists project spend alerts. */
    fun list(projectId: String): CompletableFuture<SpendAlertListPageAsync> =
        list(projectId, SpendAlertListParams.none())

    /** @see list */
    fun list(
        projectId: String,
        params: SpendAlertListParams = SpendAlertListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SpendAlertListPageAsync> =
        list(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see list */
    fun list(
        projectId: String,
        params: SpendAlertListParams = SpendAlertListParams.none(),
    ): CompletableFuture<SpendAlertListPageAsync> = list(projectId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: SpendAlertListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SpendAlertListPageAsync>

    /** @see list */
    fun list(params: SpendAlertListParams): CompletableFuture<SpendAlertListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        projectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<SpendAlertListPageAsync> =
        list(projectId, SpendAlertListParams.none(), requestOptions)

    /** Deletes a project spend alert. */
    fun delete(
        alertId: String,
        params: SpendAlertDeleteParams,
    ): CompletableFuture<ProjectSpendAlertDeleted> = delete(alertId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        alertId: String,
        params: SpendAlertDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectSpendAlertDeleted> =
        delete(params.toBuilder().alertId(alertId).build(), requestOptions)

    /** @see delete */
    fun delete(params: SpendAlertDeleteParams): CompletableFuture<ProjectSpendAlertDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: SpendAlertDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectSpendAlertDeleted>

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
         * Returns a raw HTTP response for `post /organization/projects/{project_id}/spend_alerts`,
         * but is otherwise the same as [SpendAlertServiceAsync.create].
         */
        fun create(
            projectId: String,
            params: SpendAlertCreateParams,
        ): CompletableFuture<HttpResponseFor<ProjectSpendAlert>> =
            create(projectId, params, RequestOptions.none())

        /** @see create */
        fun create(
            projectId: String,
            params: SpendAlertCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectSpendAlert>> =
            create(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see create */
        fun create(
            params: SpendAlertCreateParams
        ): CompletableFuture<HttpResponseFor<ProjectSpendAlert>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: SpendAlertCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectSpendAlert>>

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/spend_alerts/{alert_id}`, but is otherwise the same
         * as [SpendAlertServiceAsync.update].
         */
        fun update(
            alertId: String,
            params: SpendAlertUpdateParams,
        ): CompletableFuture<HttpResponseFor<ProjectSpendAlert>> =
            update(alertId, params, RequestOptions.none())

        /** @see update */
        fun update(
            alertId: String,
            params: SpendAlertUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectSpendAlert>> =
            update(params.toBuilder().alertId(alertId).build(), requestOptions)

        /** @see update */
        fun update(
            params: SpendAlertUpdateParams
        ): CompletableFuture<HttpResponseFor<ProjectSpendAlert>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: SpendAlertUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectSpendAlert>>

        /**
         * Returns a raw HTTP response for `get /organization/projects/{project_id}/spend_alerts`,
         * but is otherwise the same as [SpendAlertServiceAsync.list].
         */
        fun list(projectId: String): CompletableFuture<HttpResponseFor<SpendAlertListPageAsync>> =
            list(projectId, SpendAlertListParams.none())

        /** @see list */
        fun list(
            projectId: String,
            params: SpendAlertListParams = SpendAlertListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SpendAlertListPageAsync>> =
            list(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see list */
        fun list(
            projectId: String,
            params: SpendAlertListParams = SpendAlertListParams.none(),
        ): CompletableFuture<HttpResponseFor<SpendAlertListPageAsync>> =
            list(projectId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: SpendAlertListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SpendAlertListPageAsync>>

        /** @see list */
        fun list(
            params: SpendAlertListParams
        ): CompletableFuture<HttpResponseFor<SpendAlertListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SpendAlertListPageAsync>> =
            list(projectId, SpendAlertListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /organization/projects/{project_id}/spend_alerts/{alert_id}`, but is otherwise the same
         * as [SpendAlertServiceAsync.delete].
         */
        fun delete(
            alertId: String,
            params: SpendAlertDeleteParams,
        ): CompletableFuture<HttpResponseFor<ProjectSpendAlertDeleted>> =
            delete(alertId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            alertId: String,
            params: SpendAlertDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectSpendAlertDeleted>> =
            delete(params.toBuilder().alertId(alertId).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: SpendAlertDeleteParams
        ): CompletableFuture<HttpResponseFor<ProjectSpendAlertDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: SpendAlertDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectSpendAlertDeleted>>
    }
}
