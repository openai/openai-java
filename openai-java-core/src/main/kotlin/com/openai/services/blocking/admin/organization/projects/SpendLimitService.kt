// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.spendlimit.ProjectSpendLimit
import com.openai.models.admin.organization.projects.spendlimit.ProjectSpendLimitDeleted
import com.openai.models.admin.organization.projects.spendlimit.SpendLimitDeleteParams
import com.openai.models.admin.organization.projects.spendlimit.SpendLimitRetrieveParams
import com.openai.models.admin.organization.projects.spendlimit.SpendLimitUpdateParams
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

    /** Get a project's hard spend limit. */
    fun retrieve(projectId: String): ProjectSpendLimit =
        retrieve(projectId, SpendLimitRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: SpendLimitRetrieveParams = SpendLimitRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectSpendLimit = retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: SpendLimitRetrieveParams = SpendLimitRetrieveParams.none(),
    ): ProjectSpendLimit = retrieve(projectId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: SpendLimitRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectSpendLimit

    /** @see retrieve */
    fun retrieve(params: SpendLimitRetrieveParams): ProjectSpendLimit =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(projectId: String, requestOptions: RequestOptions): ProjectSpendLimit =
        retrieve(projectId, SpendLimitRetrieveParams.none(), requestOptions)

    /** Create or replace a project's hard spend limit. */
    fun update(projectId: String, params: SpendLimitUpdateParams): ProjectSpendLimit =
        update(projectId, params, RequestOptions.none())

    /** @see update */
    fun update(
        projectId: String,
        params: SpendLimitUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectSpendLimit = update(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see update */
    fun update(params: SpendLimitUpdateParams): ProjectSpendLimit =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: SpendLimitUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectSpendLimit

    /** Delete a project's hard spend limit. */
    fun delete(projectId: String): ProjectSpendLimitDeleted =
        delete(projectId, SpendLimitDeleteParams.none())

    /** @see delete */
    fun delete(
        projectId: String,
        params: SpendLimitDeleteParams = SpendLimitDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectSpendLimitDeleted =
        delete(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see delete */
    fun delete(
        projectId: String,
        params: SpendLimitDeleteParams = SpendLimitDeleteParams.none(),
    ): ProjectSpendLimitDeleted = delete(projectId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: SpendLimitDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectSpendLimitDeleted

    /** @see delete */
    fun delete(params: SpendLimitDeleteParams): ProjectSpendLimitDeleted =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(projectId: String, requestOptions: RequestOptions): ProjectSpendLimitDeleted =
        delete(projectId, SpendLimitDeleteParams.none(), requestOptions)

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
         * Returns a raw HTTP response for `get /organization/projects/{project_id}/spend_limit`,
         * but is otherwise the same as [SpendLimitService.retrieve].
         */
        @MustBeClosed
        fun retrieve(projectId: String): HttpResponseFor<ProjectSpendLimit> =
            retrieve(projectId, SpendLimitRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            projectId: String,
            params: SpendLimitRetrieveParams = SpendLimitRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectSpendLimit> =
            retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            projectId: String,
            params: SpendLimitRetrieveParams = SpendLimitRetrieveParams.none(),
        ): HttpResponseFor<ProjectSpendLimit> = retrieve(projectId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: SpendLimitRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectSpendLimit>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: SpendLimitRetrieveParams): HttpResponseFor<ProjectSpendLimit> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectSpendLimit> =
            retrieve(projectId, SpendLimitRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /organization/projects/{project_id}/spend_limit`,
         * but is otherwise the same as [SpendLimitService.update].
         */
        @MustBeClosed
        fun update(
            projectId: String,
            params: SpendLimitUpdateParams,
        ): HttpResponseFor<ProjectSpendLimit> = update(projectId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            projectId: String,
            params: SpendLimitUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectSpendLimit> =
            update(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: SpendLimitUpdateParams): HttpResponseFor<ProjectSpendLimit> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: SpendLimitUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectSpendLimit>

        /**
         * Returns a raw HTTP response for `delete /organization/projects/{project_id}/spend_limit`,
         * but is otherwise the same as [SpendLimitService.delete].
         */
        @MustBeClosed
        fun delete(projectId: String): HttpResponseFor<ProjectSpendLimitDeleted> =
            delete(projectId, SpendLimitDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            projectId: String,
            params: SpendLimitDeleteParams = SpendLimitDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectSpendLimitDeleted> =
            delete(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            projectId: String,
            params: SpendLimitDeleteParams = SpendLimitDeleteParams.none(),
        ): HttpResponseFor<ProjectSpendLimitDeleted> =
            delete(projectId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: SpendLimitDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectSpendLimitDeleted>

        /** @see delete */
        @MustBeClosed
        fun delete(params: SpendLimitDeleteParams): HttpResponseFor<ProjectSpendLimitDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectSpendLimitDeleted> =
            delete(projectId, SpendLimitDeleteParams.none(), requestOptions)
    }
}
