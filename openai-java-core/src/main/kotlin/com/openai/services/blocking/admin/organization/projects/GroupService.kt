// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.groups.GroupCreateParams
import com.openai.models.admin.organization.projects.groups.GroupDeleteParams
import com.openai.models.admin.organization.projects.groups.GroupDeleteResponse
import com.openai.models.admin.organization.projects.groups.GroupListPage
import com.openai.models.admin.organization.projects.groups.GroupListParams
import com.openai.models.admin.organization.projects.groups.ProjectGroup
import com.openai.services.blocking.admin.organization.projects.groups.RoleService
import java.util.function.Consumer

interface GroupService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): GroupService

    fun roles(): RoleService

    /** Grants a group access to a project. */
    fun create(projectId: String, params: GroupCreateParams): ProjectGroup =
        create(projectId, params, RequestOptions.none())

    /** @see create */
    fun create(
        projectId: String,
        params: GroupCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectGroup = create(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see create */
    fun create(params: GroupCreateParams): ProjectGroup = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: GroupCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectGroup

    /** Lists the groups that have access to a project. */
    fun list(projectId: String): GroupListPage = list(projectId, GroupListParams.none())

    /** @see list */
    fun list(
        projectId: String,
        params: GroupListParams = GroupListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GroupListPage = list(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see list */
    fun list(projectId: String, params: GroupListParams = GroupListParams.none()): GroupListPage =
        list(projectId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: GroupListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GroupListPage

    /** @see list */
    fun list(params: GroupListParams): GroupListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(projectId: String, requestOptions: RequestOptions): GroupListPage =
        list(projectId, GroupListParams.none(), requestOptions)

    /** Revokes a group's access to a project. */
    fun delete(groupId: String, params: GroupDeleteParams): GroupDeleteResponse =
        delete(groupId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        groupId: String,
        params: GroupDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GroupDeleteResponse = delete(params.toBuilder().groupId(groupId).build(), requestOptions)

    /** @see delete */
    fun delete(params: GroupDeleteParams): GroupDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: GroupDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GroupDeleteResponse

    /** A view of [GroupService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): GroupService.WithRawResponse

        fun roles(): RoleService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/projects/{project_id}/groups`, but is
         * otherwise the same as [GroupService.create].
         */
        @MustBeClosed
        fun create(projectId: String, params: GroupCreateParams): HttpResponseFor<ProjectGroup> =
            create(projectId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            projectId: String,
            params: GroupCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectGroup> =
            create(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: GroupCreateParams): HttpResponseFor<ProjectGroup> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: GroupCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectGroup>

        /**
         * Returns a raw HTTP response for `get /organization/projects/{project_id}/groups`, but is
         * otherwise the same as [GroupService.list].
         */
        @MustBeClosed
        fun list(projectId: String): HttpResponseFor<GroupListPage> =
            list(projectId, GroupListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            params: GroupListParams = GroupListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GroupListPage> =
            list(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            params: GroupListParams = GroupListParams.none(),
        ): HttpResponseFor<GroupListPage> = list(projectId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: GroupListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GroupListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: GroupListParams): HttpResponseFor<GroupListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GroupListPage> = list(projectId, GroupListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /organization/projects/{project_id}/groups/{group_id}`, but is otherwise the same as
         * [GroupService.delete].
         */
        @MustBeClosed
        fun delete(
            groupId: String,
            params: GroupDeleteParams,
        ): HttpResponseFor<GroupDeleteResponse> = delete(groupId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            groupId: String,
            params: GroupDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GroupDeleteResponse> =
            delete(params.toBuilder().groupId(groupId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: GroupDeleteParams): HttpResponseFor<GroupDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: GroupDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GroupDeleteResponse>
    }
}
