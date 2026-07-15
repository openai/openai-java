// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.hostedtoolpermissions.HostedToolPermissionRetrieveParams
import com.openai.models.admin.organization.projects.hostedtoolpermissions.HostedToolPermissionUpdateParams
import com.openai.models.admin.organization.projects.hostedtoolpermissions.ProjectHostedToolPermissions
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface HostedToolPermissionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): HostedToolPermissionServiceAsync

    /** Returns hosted tool permissions for a project. */
    fun retrieve(projectId: String): CompletableFuture<ProjectHostedToolPermissions> =
        retrieve(projectId, HostedToolPermissionRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: HostedToolPermissionRetrieveParams = HostedToolPermissionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectHostedToolPermissions> =
        retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: HostedToolPermissionRetrieveParams = HostedToolPermissionRetrieveParams.none(),
    ): CompletableFuture<ProjectHostedToolPermissions> =
        retrieve(projectId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: HostedToolPermissionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectHostedToolPermissions>

    /** @see retrieve */
    fun retrieve(
        params: HostedToolPermissionRetrieveParams
    ): CompletableFuture<ProjectHostedToolPermissions> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectHostedToolPermissions> =
        retrieve(projectId, HostedToolPermissionRetrieveParams.none(), requestOptions)

    /** Updates hosted tool permissions for a project. */
    fun update(projectId: String): CompletableFuture<ProjectHostedToolPermissions> =
        update(projectId, HostedToolPermissionUpdateParams.none())

    /** @see update */
    fun update(
        projectId: String,
        params: HostedToolPermissionUpdateParams = HostedToolPermissionUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectHostedToolPermissions> =
        update(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see update */
    fun update(
        projectId: String,
        params: HostedToolPermissionUpdateParams = HostedToolPermissionUpdateParams.none(),
    ): CompletableFuture<ProjectHostedToolPermissions> =
        update(projectId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: HostedToolPermissionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectHostedToolPermissions>

    /** @see update */
    fun update(
        params: HostedToolPermissionUpdateParams
    ): CompletableFuture<ProjectHostedToolPermissions> = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        projectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectHostedToolPermissions> =
        update(projectId, HostedToolPermissionUpdateParams.none(), requestOptions)

    /**
     * A view of [HostedToolPermissionServiceAsync] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): HostedToolPermissionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /organization/projects/{project_id}/hosted_tool_permissions`, but is otherwise the same
         * as [HostedToolPermissionServiceAsync.retrieve].
         */
        fun retrieve(
            projectId: String
        ): CompletableFuture<HttpResponseFor<ProjectHostedToolPermissions>> =
            retrieve(projectId, HostedToolPermissionRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            params: HostedToolPermissionRetrieveParams = HostedToolPermissionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectHostedToolPermissions>> =
            retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            params: HostedToolPermissionRetrieveParams = HostedToolPermissionRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ProjectHostedToolPermissions>> =
            retrieve(projectId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: HostedToolPermissionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectHostedToolPermissions>>

        /** @see retrieve */
        fun retrieve(
            params: HostedToolPermissionRetrieveParams
        ): CompletableFuture<HttpResponseFor<ProjectHostedToolPermissions>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectHostedToolPermissions>> =
            retrieve(projectId, HostedToolPermissionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/hosted_tool_permissions`, but is otherwise the same
         * as [HostedToolPermissionServiceAsync.update].
         */
        fun update(
            projectId: String
        ): CompletableFuture<HttpResponseFor<ProjectHostedToolPermissions>> =
            update(projectId, HostedToolPermissionUpdateParams.none())

        /** @see update */
        fun update(
            projectId: String,
            params: HostedToolPermissionUpdateParams = HostedToolPermissionUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectHostedToolPermissions>> =
            update(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see update */
        fun update(
            projectId: String,
            params: HostedToolPermissionUpdateParams = HostedToolPermissionUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<ProjectHostedToolPermissions>> =
            update(projectId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: HostedToolPermissionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectHostedToolPermissions>>

        /** @see update */
        fun update(
            params: HostedToolPermissionUpdateParams
        ): CompletableFuture<HttpResponseFor<ProjectHostedToolPermissions>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectHostedToolPermissions>> =
            update(projectId, HostedToolPermissionUpdateParams.none(), requestOptions)
    }
}
