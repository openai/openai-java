// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.users.OrganizationUser
import com.openai.models.admin.organization.users.UserDeleteParams
import com.openai.models.admin.organization.users.UserDeleteResponse
import com.openai.models.admin.organization.users.UserListPageAsync
import com.openai.models.admin.organization.users.UserListParams
import com.openai.models.admin.organization.users.UserRetrieveParams
import com.openai.models.admin.organization.users.UserUpdateParams
import com.openai.services.async.admin.organization.users.RoleServiceAsync
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

    fun roles(): RoleServiceAsync

    /** Retrieves a user by their identifier. */
    fun retrieve(userId: String): CompletableFuture<OrganizationUser> =
        retrieve(userId, UserRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        userId: String,
        params: UserRetrieveParams = UserRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationUser> =
        retrieve(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        userId: String,
        params: UserRetrieveParams = UserRetrieveParams.none(),
    ): CompletableFuture<OrganizationUser> = retrieve(userId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationUser>

    /** @see retrieve */
    fun retrieve(params: UserRetrieveParams): CompletableFuture<OrganizationUser> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        userId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<OrganizationUser> =
        retrieve(userId, UserRetrieveParams.none(), requestOptions)

    /** Modifies a user's role in the organization. */
    fun update(userId: String): CompletableFuture<OrganizationUser> =
        update(userId, UserUpdateParams.none())

    /** @see update */
    fun update(
        userId: String,
        params: UserUpdateParams = UserUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationUser> =
        update(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see update */
    fun update(
        userId: String,
        params: UserUpdateParams = UserUpdateParams.none(),
    ): CompletableFuture<OrganizationUser> = update(userId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: UserUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationUser>

    /** @see update */
    fun update(params: UserUpdateParams): CompletableFuture<OrganizationUser> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        userId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<OrganizationUser> = update(userId, UserUpdateParams.none(), requestOptions)

    /** Lists all of the users in the organization. */
    fun list(): CompletableFuture<UserListPageAsync> = list(UserListParams.none())

    /** @see list */
    fun list(
        params: UserListParams = UserListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserListPageAsync>

    /** @see list */
    fun list(params: UserListParams = UserListParams.none()): CompletableFuture<UserListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<UserListPageAsync> =
        list(UserListParams.none(), requestOptions)

    /** Deletes a user from the organization. */
    fun delete(userId: String): CompletableFuture<UserDeleteResponse> =
        delete(userId, UserDeleteParams.none())

    /** @see delete */
    fun delete(
        userId: String,
        params: UserDeleteParams = UserDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserDeleteResponse> =
        delete(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see delete */
    fun delete(
        userId: String,
        params: UserDeleteParams = UserDeleteParams.none(),
    ): CompletableFuture<UserDeleteResponse> = delete(userId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: UserDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserDeleteResponse>

    /** @see delete */
    fun delete(params: UserDeleteParams): CompletableFuture<UserDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        userId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserDeleteResponse> =
        delete(userId, UserDeleteParams.none(), requestOptions)

    /** A view of [UserServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserServiceAsync.WithRawResponse

        fun roles(): RoleServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organization/users/{user_id}`, but is otherwise the
         * same as [UserServiceAsync.retrieve].
         */
        fun retrieve(userId: String): CompletableFuture<HttpResponseFor<OrganizationUser>> =
            retrieve(userId, UserRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            userId: String,
            params: UserRetrieveParams = UserRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationUser>> =
            retrieve(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            userId: String,
            params: UserRetrieveParams = UserRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationUser>> =
            retrieve(userId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: UserRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationUser>>

        /** @see retrieve */
        fun retrieve(
            params: UserRetrieveParams
        ): CompletableFuture<HttpResponseFor<OrganizationUser>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            userId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OrganizationUser>> =
            retrieve(userId, UserRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /organization/users/{user_id}`, but is otherwise
         * the same as [UserServiceAsync.update].
         */
        fun update(userId: String): CompletableFuture<HttpResponseFor<OrganizationUser>> =
            update(userId, UserUpdateParams.none())

        /** @see update */
        fun update(
            userId: String,
            params: UserUpdateParams = UserUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationUser>> =
            update(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see update */
        fun update(
            userId: String,
            params: UserUpdateParams = UserUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationUser>> =
            update(userId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: UserUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationUser>>

        /** @see update */
        fun update(params: UserUpdateParams): CompletableFuture<HttpResponseFor<OrganizationUser>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            userId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OrganizationUser>> =
            update(userId, UserUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /organization/users`, but is otherwise the same as
         * [UserServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(UserListParams.none())

        /** @see list */
        fun list(
            params: UserListParams = UserListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListPageAsync>>

        /** @see list */
        fun list(
            params: UserListParams = UserListParams.none()
        ): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(UserListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/users/{user_id}`, but is otherwise
         * the same as [UserServiceAsync.delete].
         */
        fun delete(userId: String): CompletableFuture<HttpResponseFor<UserDeleteResponse>> =
            delete(userId, UserDeleteParams.none())

        /** @see delete */
        fun delete(
            userId: String,
            params: UserDeleteParams = UserDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserDeleteResponse>> =
            delete(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see delete */
        fun delete(
            userId: String,
            params: UserDeleteParams = UserDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<UserDeleteResponse>> =
            delete(userId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: UserDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserDeleteResponse>>

        /** @see delete */
        fun delete(
            params: UserDeleteParams
        ): CompletableFuture<HttpResponseFor<UserDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            userId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserDeleteResponse>> =
            delete(userId, UserDeleteParams.none(), requestOptions)
    }
}
