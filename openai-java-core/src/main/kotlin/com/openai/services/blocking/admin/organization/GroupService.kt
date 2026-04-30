// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.groups.Group
import com.openai.models.admin.organization.groups.GroupCreateParams
import com.openai.models.admin.organization.groups.GroupDeleteParams
import com.openai.models.admin.organization.groups.GroupDeleteResponse
import com.openai.models.admin.organization.groups.GroupListPage
import com.openai.models.admin.organization.groups.GroupListParams
import com.openai.models.admin.organization.groups.GroupUpdateParams
import com.openai.models.admin.organization.groups.GroupUpdateResponse
import com.openai.services.blocking.admin.organization.groups.RoleService
import com.openai.services.blocking.admin.organization.groups.UserService
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

    fun users(): UserService

    fun roles(): RoleService

    /** Creates a new group in the organization. */
    fun create(params: GroupCreateParams): Group = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: GroupCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Group

    /** Updates a group's information. */
    fun update(groupId: String, params: GroupUpdateParams): GroupUpdateResponse =
        update(groupId, params, RequestOptions.none())

    /** @see update */
    fun update(
        groupId: String,
        params: GroupUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GroupUpdateResponse = update(params.toBuilder().groupId(groupId).build(), requestOptions)

    /** @see update */
    fun update(params: GroupUpdateParams): GroupUpdateResponse =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: GroupUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GroupUpdateResponse

    /** Lists all groups in the organization. */
    fun list(): GroupListPage = list(GroupListParams.none())

    /** @see list */
    fun list(
        params: GroupListParams = GroupListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GroupListPage

    /** @see list */
    fun list(params: GroupListParams = GroupListParams.none()): GroupListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): GroupListPage =
        list(GroupListParams.none(), requestOptions)

    /** Deletes a group from the organization. */
    fun delete(groupId: String): GroupDeleteResponse = delete(groupId, GroupDeleteParams.none())

    /** @see delete */
    fun delete(
        groupId: String,
        params: GroupDeleteParams = GroupDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GroupDeleteResponse = delete(params.toBuilder().groupId(groupId).build(), requestOptions)

    /** @see delete */
    fun delete(
        groupId: String,
        params: GroupDeleteParams = GroupDeleteParams.none(),
    ): GroupDeleteResponse = delete(groupId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: GroupDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GroupDeleteResponse

    /** @see delete */
    fun delete(params: GroupDeleteParams): GroupDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(groupId: String, requestOptions: RequestOptions): GroupDeleteResponse =
        delete(groupId, GroupDeleteParams.none(), requestOptions)

    /** A view of [GroupService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): GroupService.WithRawResponse

        fun users(): UserService.WithRawResponse

        fun roles(): RoleService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/groups`, but is otherwise the same as
         * [GroupService.create].
         */
        @MustBeClosed
        fun create(params: GroupCreateParams): HttpResponseFor<Group> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: GroupCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Group>

        /**
         * Returns a raw HTTP response for `post /organization/groups/{group_id}`, but is otherwise
         * the same as [GroupService.update].
         */
        @MustBeClosed
        fun update(
            groupId: String,
            params: GroupUpdateParams,
        ): HttpResponseFor<GroupUpdateResponse> = update(groupId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            groupId: String,
            params: GroupUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GroupUpdateResponse> =
            update(params.toBuilder().groupId(groupId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: GroupUpdateParams): HttpResponseFor<GroupUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: GroupUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GroupUpdateResponse>

        /**
         * Returns a raw HTTP response for `get /organization/groups`, but is otherwise the same as
         * [GroupService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<GroupListPage> = list(GroupListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: GroupListParams = GroupListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GroupListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: GroupListParams = GroupListParams.none()): HttpResponseFor<GroupListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<GroupListPage> =
            list(GroupListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/groups/{group_id}`, but is
         * otherwise the same as [GroupService.delete].
         */
        @MustBeClosed
        fun delete(groupId: String): HttpResponseFor<GroupDeleteResponse> =
            delete(groupId, GroupDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            groupId: String,
            params: GroupDeleteParams = GroupDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GroupDeleteResponse> =
            delete(params.toBuilder().groupId(groupId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            groupId: String,
            params: GroupDeleteParams = GroupDeleteParams.none(),
        ): HttpResponseFor<GroupDeleteResponse> = delete(groupId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: GroupDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GroupDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(params: GroupDeleteParams): HttpResponseFor<GroupDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            groupId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GroupDeleteResponse> =
            delete(groupId, GroupDeleteParams.none(), requestOptions)
    }
}
