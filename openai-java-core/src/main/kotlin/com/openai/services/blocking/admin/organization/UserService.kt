// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.users.OrganizationUser
import com.openai.models.admin.organization.users.UserDeleteParams
import com.openai.models.admin.organization.users.UserDeleteResponse
import com.openai.models.admin.organization.users.UserListPage
import com.openai.models.admin.organization.users.UserListParams
import com.openai.models.admin.organization.users.UserRetrieveParams
import com.openai.models.admin.organization.users.UserUpdateParams
import com.openai.services.blocking.admin.organization.users.RoleService
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

    fun roles(): RoleService

    /** Retrieves a user by their identifier. */
    fun retrieve(userId: String): OrganizationUser = retrieve(userId, UserRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        userId: String,
        params: UserRetrieveParams = UserRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationUser = retrieve(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        userId: String,
        params: UserRetrieveParams = UserRetrieveParams.none(),
    ): OrganizationUser = retrieve(userId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationUser

    /** @see retrieve */
    fun retrieve(params: UserRetrieveParams): OrganizationUser =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(userId: String, requestOptions: RequestOptions): OrganizationUser =
        retrieve(userId, UserRetrieveParams.none(), requestOptions)

    /** Modifies a user's role in the organization. */
    fun update(userId: String, params: UserUpdateParams): OrganizationUser =
        update(userId, params, RequestOptions.none())

    /** @see update */
    fun update(
        userId: String,
        params: UserUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationUser = update(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see update */
    fun update(params: UserUpdateParams): OrganizationUser = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: UserUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationUser

    /** Lists all of the users in the organization. */
    fun list(): UserListPage = list(UserListParams.none())

    /** @see list */
    fun list(
        params: UserListParams = UserListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserListPage

    /** @see list */
    fun list(params: UserListParams = UserListParams.none()): UserListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): UserListPage =
        list(UserListParams.none(), requestOptions)

    /** Deletes a user from the organization. */
    fun delete(userId: String): UserDeleteResponse = delete(userId, UserDeleteParams.none())

    /** @see delete */
    fun delete(
        userId: String,
        params: UserDeleteParams = UserDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserDeleteResponse = delete(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see delete */
    fun delete(
        userId: String,
        params: UserDeleteParams = UserDeleteParams.none(),
    ): UserDeleteResponse = delete(userId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: UserDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserDeleteResponse

    /** @see delete */
    fun delete(params: UserDeleteParams): UserDeleteResponse = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(userId: String, requestOptions: RequestOptions): UserDeleteResponse =
        delete(userId, UserDeleteParams.none(), requestOptions)

    /** A view of [UserService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserService.WithRawResponse

        fun roles(): RoleService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organization/users/{user_id}`, but is otherwise the
         * same as [UserService.retrieve].
         */
        @MustBeClosed
        fun retrieve(userId: String): HttpResponseFor<OrganizationUser> =
            retrieve(userId, UserRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            userId: String,
            params: UserRetrieveParams = UserRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationUser> =
            retrieve(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            userId: String,
            params: UserRetrieveParams = UserRetrieveParams.none(),
        ): HttpResponseFor<OrganizationUser> = retrieve(userId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: UserRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationUser>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: UserRetrieveParams): HttpResponseFor<OrganizationUser> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            userId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationUser> =
            retrieve(userId, UserRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /organization/users/{user_id}`, but is otherwise
         * the same as [UserService.update].
         */
        @MustBeClosed
        fun update(userId: String, params: UserUpdateParams): HttpResponseFor<OrganizationUser> =
            update(userId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            userId: String,
            params: UserUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationUser> =
            update(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: UserUpdateParams): HttpResponseFor<OrganizationUser> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: UserUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationUser>

        /**
         * Returns a raw HTTP response for `get /organization/users`, but is otherwise the same as
         * [UserService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<UserListPage> = list(UserListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: UserListParams = UserListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: UserListParams = UserListParams.none()): HttpResponseFor<UserListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<UserListPage> =
            list(UserListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/users/{user_id}`, but is otherwise
         * the same as [UserService.delete].
         */
        @MustBeClosed
        fun delete(userId: String): HttpResponseFor<UserDeleteResponse> =
            delete(userId, UserDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            userId: String,
            params: UserDeleteParams = UserDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserDeleteResponse> =
            delete(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            userId: String,
            params: UserDeleteParams = UserDeleteParams.none(),
        ): HttpResponseFor<UserDeleteResponse> = delete(userId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: UserDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(params: UserDeleteParams): HttpResponseFor<UserDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            userId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserDeleteResponse> =
            delete(userId, UserDeleteParams.none(), requestOptions)
    }
}
