// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.dataretention.DataRetentionRetrieveParams
import com.openai.models.admin.organization.projects.dataretention.DataRetentionUpdateParams
import com.openai.models.admin.organization.projects.dataretention.ProjectDataRetention
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

    /** Retrieves project data retention controls. */
    fun retrieve(projectId: String): ProjectDataRetention =
        retrieve(projectId, DataRetentionRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: DataRetentionRetrieveParams = DataRetentionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectDataRetention =
        retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: DataRetentionRetrieveParams = DataRetentionRetrieveParams.none(),
    ): ProjectDataRetention = retrieve(projectId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: DataRetentionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectDataRetention

    /** @see retrieve */
    fun retrieve(params: DataRetentionRetrieveParams): ProjectDataRetention =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(projectId: String, requestOptions: RequestOptions): ProjectDataRetention =
        retrieve(projectId, DataRetentionRetrieveParams.none(), requestOptions)

    /** Updates project data retention controls. */
    fun update(projectId: String, params: DataRetentionUpdateParams): ProjectDataRetention =
        update(projectId, params, RequestOptions.none())

    /** @see update */
    fun update(
        projectId: String,
        params: DataRetentionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectDataRetention =
        update(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see update */
    fun update(params: DataRetentionUpdateParams): ProjectDataRetention =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: DataRetentionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectDataRetention

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
         * Returns a raw HTTP response for `get /organization/projects/{project_id}/data_retention`,
         * but is otherwise the same as [DataRetentionService.retrieve].
         */
        @MustBeClosed
        fun retrieve(projectId: String): HttpResponseFor<ProjectDataRetention> =
            retrieve(projectId, DataRetentionRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            projectId: String,
            params: DataRetentionRetrieveParams = DataRetentionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectDataRetention> =
            retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            projectId: String,
            params: DataRetentionRetrieveParams = DataRetentionRetrieveParams.none(),
        ): HttpResponseFor<ProjectDataRetention> =
            retrieve(projectId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: DataRetentionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectDataRetention>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: DataRetentionRetrieveParams): HttpResponseFor<ProjectDataRetention> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectDataRetention> =
            retrieve(projectId, DataRetentionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/data_retention`, but is otherwise the same as
         * [DataRetentionService.update].
         */
        @MustBeClosed
        fun update(
            projectId: String,
            params: DataRetentionUpdateParams,
        ): HttpResponseFor<ProjectDataRetention> = update(projectId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            projectId: String,
            params: DataRetentionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectDataRetention> =
            update(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: DataRetentionUpdateParams): HttpResponseFor<ProjectDataRetention> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: DataRetentionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectDataRetention>
    }
}
