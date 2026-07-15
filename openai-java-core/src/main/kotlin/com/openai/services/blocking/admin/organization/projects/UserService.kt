// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.users.ProjectUser
import com.openai.models.admin.organization.projects.users.UserCreateParams
import com.openai.models.admin.organization.projects.users.UserDeleteParams
import com.openai.models.admin.organization.projects.users.UserDeleteResponse
import com.openai.models.admin.organization.projects.users.UserListPage
import com.openai.models.admin.organization.projects.users.UserListParams
import com.openai.models.admin.organization.projects.users.UserRetrieveParams
import com.openai.models.admin.organization.projects.users.UserUpdateParams
import com.openai.services.blocking.admin.organization.projects.users.RoleService
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

    /**
     * Adds a user to the project. Users must already be members of the organization to be added to
     * a project.
     */
    fun create(projectId: String, params: UserCreateParams): ProjectUser =
        create(projectId, params, RequestOptions.none())

    /** @see create */
    fun create(
        projectId: String,
        params: UserCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectUser = create(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see create */
    fun create(params: UserCreateParams): ProjectUser = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: UserCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectUser

    /** Retrieves a user in the project. */
    fun retrieve(userId: String, params: UserRetrieveParams): ProjectUser =
        retrieve(userId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        userId: String,
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectUser = retrieve(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: UserRetrieveParams): ProjectUser = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectUser

    /** Modifies a user's role in the project. */
    fun update(userId: String, params: UserUpdateParams): ProjectUser =
        update(userId, params, RequestOptions.none())

    /** @see update */
    fun update(
        userId: String,
        params: UserUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectUser = update(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see update */
    fun update(params: UserUpdateParams): ProjectUser = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: UserUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectUser

    /** Returns a list of users in the project. */
    fun list(projectId: String): UserListPage = list(projectId, UserListParams.none())

    /** @see list */
    fun list(
        projectId: String,
        params: UserListParams = UserListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserListPage = list(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see list */
    fun list(projectId: String, params: UserListParams = UserListParams.none()): UserListPage =
        list(projectId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: UserListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserListPage

    /** @see list */
    fun list(params: UserListParams): UserListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(projectId: String, requestOptions: RequestOptions): UserListPage =
        list(projectId, UserListParams.none(), requestOptions)

    /**
     * Deletes a user from the project.
     *
     * Returns confirmation of project user deletion, or an error if the project is archived
     * (archived projects have no users).
     */
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

        fun roles(): RoleService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/projects/{project_id}/users`, but is
         * otherwise the same as [UserService.create].
         */
        @MustBeClosed
        fun create(projectId: String, params: UserCreateParams): HttpResponseFor<ProjectUser> =
            create(projectId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            projectId: String,
            params: UserCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectUser> =
            create(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: UserCreateParams): HttpResponseFor<ProjectUser> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: UserCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectUser>

        /**
         * Returns a raw HTTP response for `get
         * /organization/projects/{project_id}/users/{user_id}`, but is otherwise the same as
         * [UserService.retrieve].
         */
        @MustBeClosed
        fun retrieve(userId: String, params: UserRetrieveParams): HttpResponseFor<ProjectUser> =
            retrieve(userId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            userId: String,
            params: UserRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectUser> =
            retrieve(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: UserRetrieveParams): HttpResponseFor<ProjectUser> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: UserRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectUser>

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/users/{user_id}`, but is otherwise the same as
         * [UserService.update].
         */
        @MustBeClosed
        fun update(userId: String, params: UserUpdateParams): HttpResponseFor<ProjectUser> =
            update(userId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            userId: String,
            params: UserUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectUser> =
            update(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: UserUpdateParams): HttpResponseFor<ProjectUser> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: UserUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectUser>

        /**
         * Returns a raw HTTP response for `get /organization/projects/{project_id}/users`, but is
         * otherwise the same as [UserService.list].
         */
        @MustBeClosed
        fun list(projectId: String): HttpResponseFor<UserListPage> =
            list(projectId, UserListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            params: UserListParams = UserListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserListPage> =
            list(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            params: UserListParams = UserListParams.none(),
        ): HttpResponseFor<UserListPage> = list(projectId, params, RequestOptions.none())

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
        fun list(projectId: String, requestOptions: RequestOptions): HttpResponseFor<UserListPage> =
            list(projectId, UserListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /organization/projects/{project_id}/users/{user_id}`, but is otherwise the same as
         * [UserService.delete].
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
