// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.groups

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.groups.users.UserCreateParams
import com.openai.models.admin.organization.groups.users.UserCreateResponse
import com.openai.models.admin.organization.groups.users.UserDeleteParams
import com.openai.models.admin.organization.groups.users.UserDeleteResponse
import com.openai.models.admin.organization.groups.users.UserListPageAsync
import com.openai.models.admin.organization.groups.users.UserListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface UserServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserServiceAsync

    /** Adds a user to a group. */
    fun create(groupId: String, params: UserCreateParams): CompletableFuture<UserCreateResponse> =
        create(groupId, params, RequestOptions.none())

    /** @see create */
    fun create(
        groupId: String,
        params: UserCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserCreateResponse> =
        create(params.toBuilder().groupId(groupId).build(), requestOptions)

    /** @see create */
    fun create(params: UserCreateParams): CompletableFuture<UserCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: UserCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserCreateResponse>

    /** Lists the users assigned to a group. */
    fun list(groupId: String): CompletableFuture<UserListPageAsync> =
        list(groupId, UserListParams.none())

    /** @see list */
    fun list(
        groupId: String,
        params: UserListParams = UserListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserListPageAsync> =
        list(params.toBuilder().groupId(groupId).build(), requestOptions)

    /** @see list */
    fun list(
        groupId: String,
        params: UserListParams = UserListParams.none(),
    ): CompletableFuture<UserListPageAsync> = list(groupId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: UserListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserListPageAsync>

    /** @see list */
    fun list(params: UserListParams): CompletableFuture<UserListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        groupId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserListPageAsync> = list(groupId, UserListParams.none(), requestOptions)

    /** Removes a user from a group. */
    fun delete(userId: String, params: UserDeleteParams): CompletableFuture<UserDeleteResponse> =
        delete(userId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        userId: String,
        params: UserDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserDeleteResponse> =
        delete(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see delete */
    fun delete(params: UserDeleteParams): CompletableFuture<UserDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: UserDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserDeleteResponse>

    /** A view of [UserServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/groups/{group_id}/users`, but is
         * otherwise the same as [UserServiceAsync.create].
         */
        fun create(
            groupId: String,
            params: UserCreateParams,
        ): CompletableFuture<HttpResponseFor<UserCreateResponse>> =
            create(groupId, params, RequestOptions.none())

        /** @see create */
        fun create(
            groupId: String,
            params: UserCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserCreateResponse>> =
            create(params.toBuilder().groupId(groupId).build(), requestOptions)

        /** @see create */
        fun create(
            params: UserCreateParams
        ): CompletableFuture<HttpResponseFor<UserCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: UserCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /organization/groups/{group_id}/users`, but is
         * otherwise the same as [UserServiceAsync.list].
         */
        fun list(groupId: String): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(groupId, UserListParams.none())

        /** @see list */
        fun list(
            groupId: String,
            params: UserListParams = UserListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(params.toBuilder().groupId(groupId).build(), requestOptions)

        /** @see list */
        fun list(
            groupId: String,
            params: UserListParams = UserListParams.none(),
        ): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(groupId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: UserListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListPageAsync>>

        /** @see list */
        fun list(params: UserListParams): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            groupId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(groupId, UserListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/groups/{group_id}/users/{user_id}`,
         * but is otherwise the same as [UserServiceAsync.delete].
         */
        fun delete(
            userId: String,
            params: UserDeleteParams,
        ): CompletableFuture<HttpResponseFor<UserDeleteResponse>> =
            delete(userId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            userId: String,
            params: UserDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserDeleteResponse>> =
            delete(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: UserDeleteParams
        ): CompletableFuture<HttpResponseFor<UserDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: UserDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserDeleteResponse>>
    }
}
