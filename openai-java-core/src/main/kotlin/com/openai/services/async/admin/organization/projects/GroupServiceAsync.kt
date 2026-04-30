// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.groups.GroupCreateParams
import com.openai.models.admin.organization.projects.groups.GroupDeleteParams
import com.openai.models.admin.organization.projects.groups.GroupDeleteResponse
import com.openai.models.admin.organization.projects.groups.GroupListPageAsync
import com.openai.models.admin.organization.projects.groups.GroupListParams
import com.openai.models.admin.organization.projects.groups.ProjectGroup
import com.openai.services.async.admin.organization.projects.groups.RoleServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface GroupServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): GroupServiceAsync

    fun roles(): RoleServiceAsync

    /** Grants a group access to a project. */
    fun create(projectId: String, params: GroupCreateParams): CompletableFuture<ProjectGroup> =
        create(projectId, params, RequestOptions.none())

    /** @see create */
    fun create(
        projectId: String,
        params: GroupCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectGroup> =
        create(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see create */
    fun create(params: GroupCreateParams): CompletableFuture<ProjectGroup> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: GroupCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectGroup>

    /** Lists the groups that have access to a project. */
    fun list(projectId: String): CompletableFuture<GroupListPageAsync> =
        list(projectId, GroupListParams.none())

    /** @see list */
    fun list(
        projectId: String,
        params: GroupListParams = GroupListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GroupListPageAsync> =
        list(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see list */
    fun list(
        projectId: String,
        params: GroupListParams = GroupListParams.none(),
    ): CompletableFuture<GroupListPageAsync> = list(projectId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: GroupListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GroupListPageAsync>

    /** @see list */
    fun list(params: GroupListParams): CompletableFuture<GroupListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        projectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<GroupListPageAsync> =
        list(projectId, GroupListParams.none(), requestOptions)

    /** Revokes a group's access to a project. */
    fun delete(groupId: String, params: GroupDeleteParams): CompletableFuture<GroupDeleteResponse> =
        delete(groupId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        groupId: String,
        params: GroupDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GroupDeleteResponse> =
        delete(params.toBuilder().groupId(groupId).build(), requestOptions)

    /** @see delete */
    fun delete(params: GroupDeleteParams): CompletableFuture<GroupDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: GroupDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GroupDeleteResponse>

    /** A view of [GroupServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GroupServiceAsync.WithRawResponse

        fun roles(): RoleServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/projects/{project_id}/groups`, but is
         * otherwise the same as [GroupServiceAsync.create].
         */
        fun create(
            projectId: String,
            params: GroupCreateParams,
        ): CompletableFuture<HttpResponseFor<ProjectGroup>> =
            create(projectId, params, RequestOptions.none())

        /** @see create */
        fun create(
            projectId: String,
            params: GroupCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectGroup>> =
            create(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see create */
        fun create(params: GroupCreateParams): CompletableFuture<HttpResponseFor<ProjectGroup>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: GroupCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectGroup>>

        /**
         * Returns a raw HTTP response for `get /organization/projects/{project_id}/groups`, but is
         * otherwise the same as [GroupServiceAsync.list].
         */
        fun list(projectId: String): CompletableFuture<HttpResponseFor<GroupListPageAsync>> =
            list(projectId, GroupListParams.none())

        /** @see list */
        fun list(
            projectId: String,
            params: GroupListParams = GroupListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GroupListPageAsync>> =
            list(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see list */
        fun list(
            projectId: String,
            params: GroupListParams = GroupListParams.none(),
        ): CompletableFuture<HttpResponseFor<GroupListPageAsync>> =
            list(projectId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: GroupListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GroupListPageAsync>>

        /** @see list */
        fun list(params: GroupListParams): CompletableFuture<HttpResponseFor<GroupListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GroupListPageAsync>> =
            list(projectId, GroupListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /organization/projects/{project_id}/groups/{group_id}`, but is otherwise the same as
         * [GroupServiceAsync.delete].
         */
        fun delete(
            groupId: String,
            params: GroupDeleteParams,
        ): CompletableFuture<HttpResponseFor<GroupDeleteResponse>> =
            delete(groupId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            groupId: String,
            params: GroupDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GroupDeleteResponse>> =
            delete(params.toBuilder().groupId(groupId).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: GroupDeleteParams
        ): CompletableFuture<HttpResponseFor<GroupDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: GroupDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GroupDeleteResponse>>
    }
}
