// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.groups.Group
import com.openai.models.admin.organization.groups.GroupCreateParams
import com.openai.models.admin.organization.groups.GroupDeleteParams
import com.openai.models.admin.organization.groups.GroupDeleteResponse
import com.openai.models.admin.organization.groups.GroupListPageAsync
import com.openai.models.admin.organization.groups.GroupListParams
import com.openai.models.admin.organization.groups.GroupUpdateParams
import com.openai.models.admin.organization.groups.GroupUpdateResponse
import com.openai.services.async.admin.organization.groups.RoleServiceAsync
import com.openai.services.async.admin.organization.groups.UserServiceAsync
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

    fun users(): UserServiceAsync

    fun roles(): RoleServiceAsync

    /** Creates a new group in the organization. */
    fun create(params: GroupCreateParams): CompletableFuture<Group> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: GroupCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Group>

    /** Updates a group's information. */
    fun update(groupId: String, params: GroupUpdateParams): CompletableFuture<GroupUpdateResponse> =
        update(groupId, params, RequestOptions.none())

    /** @see update */
    fun update(
        groupId: String,
        params: GroupUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GroupUpdateResponse> =
        update(params.toBuilder().groupId(groupId).build(), requestOptions)

    /** @see update */
    fun update(params: GroupUpdateParams): CompletableFuture<GroupUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: GroupUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GroupUpdateResponse>

    /** Lists all groups in the organization. */
    fun list(): CompletableFuture<GroupListPageAsync> = list(GroupListParams.none())

    /** @see list */
    fun list(
        params: GroupListParams = GroupListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GroupListPageAsync>

    /** @see list */
    fun list(
        params: GroupListParams = GroupListParams.none()
    ): CompletableFuture<GroupListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<GroupListPageAsync> =
        list(GroupListParams.none(), requestOptions)

    /** Deletes a group from the organization. */
    fun delete(groupId: String): CompletableFuture<GroupDeleteResponse> =
        delete(groupId, GroupDeleteParams.none())

    /** @see delete */
    fun delete(
        groupId: String,
        params: GroupDeleteParams = GroupDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GroupDeleteResponse> =
        delete(params.toBuilder().groupId(groupId).build(), requestOptions)

    /** @see delete */
    fun delete(
        groupId: String,
        params: GroupDeleteParams = GroupDeleteParams.none(),
    ): CompletableFuture<GroupDeleteResponse> = delete(groupId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: GroupDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GroupDeleteResponse>

    /** @see delete */
    fun delete(params: GroupDeleteParams): CompletableFuture<GroupDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        groupId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<GroupDeleteResponse> =
        delete(groupId, GroupDeleteParams.none(), requestOptions)

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

        fun users(): UserServiceAsync.WithRawResponse

        fun roles(): RoleServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/groups`, but is otherwise the same as
         * [GroupServiceAsync.create].
         */
        fun create(params: GroupCreateParams): CompletableFuture<HttpResponseFor<Group>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: GroupCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Group>>

        /**
         * Returns a raw HTTP response for `post /organization/groups/{group_id}`, but is otherwise
         * the same as [GroupServiceAsync.update].
         */
        fun update(
            groupId: String,
            params: GroupUpdateParams,
        ): CompletableFuture<HttpResponseFor<GroupUpdateResponse>> =
            update(groupId, params, RequestOptions.none())

        /** @see update */
        fun update(
            groupId: String,
            params: GroupUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GroupUpdateResponse>> =
            update(params.toBuilder().groupId(groupId).build(), requestOptions)

        /** @see update */
        fun update(
            params: GroupUpdateParams
        ): CompletableFuture<HttpResponseFor<GroupUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: GroupUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GroupUpdateResponse>>

        /**
         * Returns a raw HTTP response for `get /organization/groups`, but is otherwise the same as
         * [GroupServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<GroupListPageAsync>> =
            list(GroupListParams.none())

        /** @see list */
        fun list(
            params: GroupListParams = GroupListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GroupListPageAsync>>

        /** @see list */
        fun list(
            params: GroupListParams = GroupListParams.none()
        ): CompletableFuture<HttpResponseFor<GroupListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<GroupListPageAsync>> =
            list(GroupListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/groups/{group_id}`, but is
         * otherwise the same as [GroupServiceAsync.delete].
         */
        fun delete(groupId: String): CompletableFuture<HttpResponseFor<GroupDeleteResponse>> =
            delete(groupId, GroupDeleteParams.none())

        /** @see delete */
        fun delete(
            groupId: String,
            params: GroupDeleteParams = GroupDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GroupDeleteResponse>> =
            delete(params.toBuilder().groupId(groupId).build(), requestOptions)

        /** @see delete */
        fun delete(
            groupId: String,
            params: GroupDeleteParams = GroupDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<GroupDeleteResponse>> =
            delete(groupId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: GroupDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GroupDeleteResponse>>

        /** @see delete */
        fun delete(
            params: GroupDeleteParams
        ): CompletableFuture<HttpResponseFor<GroupDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            groupId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GroupDeleteResponse>> =
            delete(groupId, GroupDeleteParams.none(), requestOptions)
    }
}
