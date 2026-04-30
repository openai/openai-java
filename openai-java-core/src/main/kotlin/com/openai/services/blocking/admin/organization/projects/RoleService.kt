// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.roles.RoleCreateParams
import com.openai.models.admin.organization.projects.roles.RoleDeleteParams
import com.openai.models.admin.organization.projects.roles.RoleDeleteResponse
import com.openai.models.admin.organization.projects.roles.RoleListPage
import com.openai.models.admin.organization.projects.roles.RoleListParams
import com.openai.models.admin.organization.projects.roles.RoleUpdateParams
import com.openai.models.admin.organization.roles.Role
import java.util.function.Consumer

interface RoleService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RoleService

    /** Creates a custom role for a project. */
    fun create(projectId: String, params: RoleCreateParams): Role =
        create(projectId, params, RequestOptions.none())

    /** @see create */
    fun create(
        projectId: String,
        params: RoleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Role = create(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see create */
    fun create(params: RoleCreateParams): Role = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: RoleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Role

    /** Updates an existing project role. */
    fun update(roleId: String, params: RoleUpdateParams): Role =
        update(roleId, params, RequestOptions.none())

    /** @see update */
    fun update(
        roleId: String,
        params: RoleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Role = update(params.toBuilder().roleId(roleId).build(), requestOptions)

    /** @see update */
    fun update(params: RoleUpdateParams): Role = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: RoleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Role

    /** Lists the roles configured for a project. */
    fun list(projectId: String): RoleListPage = list(projectId, RoleListParams.none())

    /** @see list */
    fun list(
        projectId: String,
        params: RoleListParams = RoleListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoleListPage = list(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see list */
    fun list(projectId: String, params: RoleListParams = RoleListParams.none()): RoleListPage =
        list(projectId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: RoleListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoleListPage

    /** @see list */
    fun list(params: RoleListParams): RoleListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(projectId: String, requestOptions: RequestOptions): RoleListPage =
        list(projectId, RoleListParams.none(), requestOptions)

    /** Deletes a custom role from a project. */
    fun delete(roleId: String, params: RoleDeleteParams): RoleDeleteResponse =
        delete(roleId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        roleId: String,
        params: RoleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoleDeleteResponse = delete(params.toBuilder().roleId(roleId).build(), requestOptions)

    /** @see delete */
    fun delete(params: RoleDeleteParams): RoleDeleteResponse = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: RoleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoleDeleteResponse

    /** A view of [RoleService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RoleService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /projects/{project_id}/roles`, but is otherwise the
         * same as [RoleService.create].
         */
        @MustBeClosed
        fun create(projectId: String, params: RoleCreateParams): HttpResponseFor<Role> =
            create(projectId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            projectId: String,
            params: RoleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Role> =
            create(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: RoleCreateParams): HttpResponseFor<Role> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: RoleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Role>

        /**
         * Returns a raw HTTP response for `post /projects/{project_id}/roles/{role_id}`, but is
         * otherwise the same as [RoleService.update].
         */
        @MustBeClosed
        fun update(roleId: String, params: RoleUpdateParams): HttpResponseFor<Role> =
            update(roleId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            roleId: String,
            params: RoleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Role> = update(params.toBuilder().roleId(roleId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: RoleUpdateParams): HttpResponseFor<Role> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: RoleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Role>

        /**
         * Returns a raw HTTP response for `get /projects/{project_id}/roles`, but is otherwise the
         * same as [RoleService.list].
         */
        @MustBeClosed
        fun list(projectId: String): HttpResponseFor<RoleListPage> =
            list(projectId, RoleListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            params: RoleListParams = RoleListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoleListPage> =
            list(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            params: RoleListParams = RoleListParams.none(),
        ): HttpResponseFor<RoleListPage> = list(projectId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: RoleListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoleListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: RoleListParams): HttpResponseFor<RoleListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(projectId: String, requestOptions: RequestOptions): HttpResponseFor<RoleListPage> =
            list(projectId, RoleListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /projects/{project_id}/roles/{role_id}`, but is
         * otherwise the same as [RoleService.delete].
         */
        @MustBeClosed
        fun delete(roleId: String, params: RoleDeleteParams): HttpResponseFor<RoleDeleteResponse> =
            delete(roleId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            roleId: String,
            params: RoleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoleDeleteResponse> =
            delete(params.toBuilder().roleId(roleId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: RoleDeleteParams): HttpResponseFor<RoleDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: RoleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoleDeleteResponse>
    }
}
