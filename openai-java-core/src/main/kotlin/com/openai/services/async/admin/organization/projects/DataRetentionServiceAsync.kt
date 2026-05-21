// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.dataretention.DataRetentionRetrieveParams
import com.openai.models.admin.organization.projects.dataretention.DataRetentionUpdateParams
import com.openai.models.admin.organization.projects.dataretention.ProjectDataRetention
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

    /** Retrieves project data retention controls. */
    fun retrieve(projectId: String): CompletableFuture<ProjectDataRetention> =
        retrieve(projectId, DataRetentionRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: DataRetentionRetrieveParams = DataRetentionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectDataRetention> =
        retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: DataRetentionRetrieveParams = DataRetentionRetrieveParams.none(),
    ): CompletableFuture<ProjectDataRetention> = retrieve(projectId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: DataRetentionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectDataRetention>

    /** @see retrieve */
    fun retrieve(params: DataRetentionRetrieveParams): CompletableFuture<ProjectDataRetention> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectDataRetention> =
        retrieve(projectId, DataRetentionRetrieveParams.none(), requestOptions)

    /** Updates project data retention controls. */
    fun update(
        projectId: String,
        params: DataRetentionUpdateParams,
    ): CompletableFuture<ProjectDataRetention> = update(projectId, params, RequestOptions.none())

    /** @see update */
    fun update(
        projectId: String,
        params: DataRetentionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectDataRetention> =
        update(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see update */
    fun update(params: DataRetentionUpdateParams): CompletableFuture<ProjectDataRetention> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: DataRetentionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectDataRetention>

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
         * Returns a raw HTTP response for `get /organization/projects/{project_id}/data_retention`,
         * but is otherwise the same as [DataRetentionServiceAsync.retrieve].
         */
        fun retrieve(projectId: String): CompletableFuture<HttpResponseFor<ProjectDataRetention>> =
            retrieve(projectId, DataRetentionRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            params: DataRetentionRetrieveParams = DataRetentionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectDataRetention>> =
            retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            params: DataRetentionRetrieveParams = DataRetentionRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ProjectDataRetention>> =
            retrieve(projectId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: DataRetentionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectDataRetention>>

        /** @see retrieve */
        fun retrieve(
            params: DataRetentionRetrieveParams
        ): CompletableFuture<HttpResponseFor<ProjectDataRetention>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectDataRetention>> =
            retrieve(projectId, DataRetentionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/data_retention`, but is otherwise the same as
         * [DataRetentionServiceAsync.update].
         */
        fun update(
            projectId: String,
            params: DataRetentionUpdateParams,
        ): CompletableFuture<HttpResponseFor<ProjectDataRetention>> =
            update(projectId, params, RequestOptions.none())

        /** @see update */
        fun update(
            projectId: String,
            params: DataRetentionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectDataRetention>> =
            update(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see update */
        fun update(
            params: DataRetentionUpdateParams
        ): CompletableFuture<HttpResponseFor<ProjectDataRetention>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: DataRetentionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectDataRetention>>
    }
}
