// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.groups

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.groups.users.UserCreateParams
import com.openai.models.admin.organization.groups.users.UserCreateResponse
import com.openai.models.admin.organization.groups.users.UserDeleteParams
import com.openai.models.admin.organization.groups.users.UserDeleteResponse
import com.openai.models.admin.organization.groups.users.UserListPage
import com.openai.models.admin.organization.groups.users.UserListParams
import java.util.function.Consumer

interface UserService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserService

    /** Adds a user to a group. */
    fun create(groupId: String, params: UserCreateParams): UserCreateResponse =
        create(groupId, params, RequestOptions.none())

    /** @see create */
    fun create(
        groupId: String,
        params: UserCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserCreateResponse = create(params.toBuilder().groupId(groupId).build(), requestOptions)

    /** @see create */
    fun create(params: UserCreateParams): UserCreateResponse = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: UserCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserCreateResponse

    /** Lists the users assigned to a group. */
    fun list(groupId: String): UserListPage = list(groupId, UserListParams.none())

    /** @see list */
    fun list(
        groupId: String,
        params: UserListParams = UserListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserListPage = list(params.toBuilder().groupId(groupId).build(), requestOptions)

    /** @see list */
    fun list(groupId: String, params: UserListParams = UserListParams.none()): UserListPage =
        list(groupId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: UserListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserListPage

    /** @see list */
    fun list(params: UserListParams): UserListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(groupId: String, requestOptions: RequestOptions): UserListPage =
        list(groupId, UserListParams.none(), requestOptions)

    /** Removes a user from a group. */
    fun delete(userId: String, params: UserDeleteParams): UserDeleteResponse =
        delete(userId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        userId: String,
        params: UserDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserDeleteResponse = delete(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see delete */
    fun delete(params: UserDeleteParams): UserDeleteResponse = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: UserDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserDeleteResponse

    /** A view of [UserService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/groups/{group_id}/users`, but is
         * otherwise the same as [UserService.create].
         */
        @MustBeClosed
        fun create(groupId: String, params: UserCreateParams): HttpResponseFor<UserCreateResponse> =
            create(groupId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            groupId: String,
            params: UserCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserCreateResponse> =
            create(params.toBuilder().groupId(groupId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: UserCreateParams): HttpResponseFor<UserCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: UserCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserCreateResponse>

        /**
         * Returns a raw HTTP response for `get /organization/groups/{group_id}/users`, but is
         * otherwise the same as [UserService.list].
         */
        @MustBeClosed
        fun list(groupId: String): HttpResponseFor<UserListPage> =
            list(groupId, UserListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            groupId: String,
            params: UserListParams = UserListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserListPage> =
            list(params.toBuilder().groupId(groupId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            groupId: String,
            params: UserListParams = UserListParams.none(),
        ): HttpResponseFor<UserListPage> = list(groupId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: UserListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: UserListParams): HttpResponseFor<UserListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(groupId: String, requestOptions: RequestOptions): HttpResponseFor<UserListPage> =
            list(groupId, UserListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/groups/{group_id}/users/{user_id}`,
         * but is otherwise the same as [UserService.delete].
         */
        @MustBeClosed
        fun delete(userId: String, params: UserDeleteParams): HttpResponseFor<UserDeleteResponse> =
            delete(userId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            userId: String,
            params: UserDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserDeleteResponse> =
            delete(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: UserDeleteParams): HttpResponseFor<UserDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: UserDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserDeleteResponse>
    }
}
