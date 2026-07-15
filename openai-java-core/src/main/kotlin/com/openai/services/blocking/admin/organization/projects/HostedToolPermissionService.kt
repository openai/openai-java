// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.hostedtoolpermissions.HostedToolPermissionRetrieveParams
import com.openai.models.admin.organization.projects.hostedtoolpermissions.HostedToolPermissionUpdateParams
import com.openai.models.admin.organization.projects.hostedtoolpermissions.ProjectHostedToolPermissions
import java.util.function.Consumer

interface HostedToolPermissionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): HostedToolPermissionService

    /** Returns hosted tool permissions for a project. */
    fun retrieve(projectId: String): ProjectHostedToolPermissions =
        retrieve(projectId, HostedToolPermissionRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: HostedToolPermissionRetrieveParams = HostedToolPermissionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectHostedToolPermissions =
        retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: HostedToolPermissionRetrieveParams = HostedToolPermissionRetrieveParams.none(),
    ): ProjectHostedToolPermissions = retrieve(projectId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: HostedToolPermissionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectHostedToolPermissions

    /** @see retrieve */
    fun retrieve(params: HostedToolPermissionRetrieveParams): ProjectHostedToolPermissions =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(projectId: String, requestOptions: RequestOptions): ProjectHostedToolPermissions =
        retrieve(projectId, HostedToolPermissionRetrieveParams.none(), requestOptions)

    /** Updates hosted tool permissions for a project. */
    fun update(projectId: String): ProjectHostedToolPermissions =
        update(projectId, HostedToolPermissionUpdateParams.none())

    /** @see update */
    fun update(
        projectId: String,
        params: HostedToolPermissionUpdateParams = HostedToolPermissionUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectHostedToolPermissions =
        update(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see update */
    fun update(
        projectId: String,
        params: HostedToolPermissionUpdateParams = HostedToolPermissionUpdateParams.none(),
    ): ProjectHostedToolPermissions = update(projectId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: HostedToolPermissionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectHostedToolPermissions

    /** @see update */
    fun update(params: HostedToolPermissionUpdateParams): ProjectHostedToolPermissions =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(projectId: String, requestOptions: RequestOptions): ProjectHostedToolPermissions =
        update(projectId, HostedToolPermissionUpdateParams.none(), requestOptions)

    /**
     * A view of [HostedToolPermissionService] that provides access to raw HTTP responses for each
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
        ): HostedToolPermissionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /organization/projects/{project_id}/hosted_tool_permissions`, but is otherwise the same
         * as [HostedToolPermissionService.retrieve].
         */
        @MustBeClosed
        fun retrieve(projectId: String): HttpResponseFor<ProjectHostedToolPermissions> =
            retrieve(projectId, HostedToolPermissionRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            projectId: String,
            params: HostedToolPermissionRetrieveParams = HostedToolPermissionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectHostedToolPermissions> =
            retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            projectId: String,
            params: HostedToolPermissionRetrieveParams = HostedToolPermissionRetrieveParams.none(),
        ): HttpResponseFor<ProjectHostedToolPermissions> =
            retrieve(projectId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: HostedToolPermissionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectHostedToolPermissions>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: HostedToolPermissionRetrieveParams
        ): HttpResponseFor<ProjectHostedToolPermissions> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectHostedToolPermissions> =
            retrieve(projectId, HostedToolPermissionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/hosted_tool_permissions`, but is otherwise the same
         * as [HostedToolPermissionService.update].
         */
        @MustBeClosed
        fun update(projectId: String): HttpResponseFor<ProjectHostedToolPermissions> =
            update(projectId, HostedToolPermissionUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            projectId: String,
            params: HostedToolPermissionUpdateParams = HostedToolPermissionUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectHostedToolPermissions> =
            update(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            projectId: String,
            params: HostedToolPermissionUpdateParams = HostedToolPermissionUpdateParams.none(),
        ): HttpResponseFor<ProjectHostedToolPermissions> =
            update(projectId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: HostedToolPermissionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectHostedToolPermissions>

        /** @see update */
        @MustBeClosed
        fun update(
            params: HostedToolPermissionUpdateParams
        ): HttpResponseFor<ProjectHostedToolPermissions> = update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectHostedToolPermissions> =
            update(projectId, HostedToolPermissionUpdateParams.none(), requestOptions)
    }
}
