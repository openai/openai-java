// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.users.ProjectUser
import com.openai.models.admin.organization.projects.users.UserCreateParams
import com.openai.models.admin.organization.projects.users.UserDeleteParams
import com.openai.models.admin.organization.projects.users.UserDeleteResponse
import com.openai.models.admin.organization.projects.users.UserListPageAsync
import com.openai.models.admin.organization.projects.users.UserListParams
import com.openai.models.admin.organization.projects.users.UserRetrieveParams
import com.openai.models.admin.organization.projects.users.UserUpdateParams
import com.openai.services.async.admin.organization.projects.users.RoleServiceAsync
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

    /**
     * Adds a user to the project. Users must already be members of the organization to be added to
     * a project.
     */
    fun create(projectId: String, params: UserCreateParams): CompletableFuture<ProjectUser> =
        create(projectId, params, RequestOptions.none())

    /** @see create */
    fun create(
        projectId: String,
        params: UserCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectUser> =
        create(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see create */
    fun create(params: UserCreateParams): CompletableFuture<ProjectUser> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: UserCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectUser>

    /** Retrieves a user in the project. */
    fun retrieve(userId: String, params: UserRetrieveParams): CompletableFuture<ProjectUser> =
        retrieve(userId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        userId: String,
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectUser> =
        retrieve(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: UserRetrieveParams): CompletableFuture<ProjectUser> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectUser>

    /** Modifies a user's role in the project. */
    fun update(userId: String, params: UserUpdateParams): CompletableFuture<ProjectUser> =
        update(userId, params, RequestOptions.none())

    /** @see update */
    fun update(
        userId: String,
        params: UserUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectUser> =
        update(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see update */
    fun update(params: UserUpdateParams): CompletableFuture<ProjectUser> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: UserUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectUser>

    /** Returns a list of users in the project. */
    fun list(projectId: String): CompletableFuture<UserListPageAsync> =
        list(projectId, UserListParams.none())

    /** @see list */
    fun list(
        projectId: String,
        params: UserListParams = UserListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserListPageAsync> =
        list(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see list */
    fun list(
        projectId: String,
        params: UserListParams = UserListParams.none(),
    ): CompletableFuture<UserListPageAsync> = list(projectId, params, RequestOptions.none())

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
        projectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserListPageAsync> = list(projectId, UserListParams.none(), requestOptions)

    /**
     * Deletes a user from the project.
     *
     * Returns confirmation of project user deletion, or an error if the project is archived
     * (archived projects have no users).
     */
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

        fun roles(): RoleServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/projects/{project_id}/users`, but is
         * otherwise the same as [UserServiceAsync.create].
         */
        fun create(
            projectId: String,
            params: UserCreateParams,
        ): CompletableFuture<HttpResponseFor<ProjectUser>> =
            create(projectId, params, RequestOptions.none())

        /** @see create */
        fun create(
            projectId: String,
            params: UserCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectUser>> =
            create(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see create */
        fun create(params: UserCreateParams): CompletableFuture<HttpResponseFor<ProjectUser>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: UserCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectUser>>

        /**
         * Returns a raw HTTP response for `get
         * /organization/projects/{project_id}/users/{user_id}`, but is otherwise the same as
         * [UserServiceAsync.retrieve].
         */
        fun retrieve(
            userId: String,
            params: UserRetrieveParams,
        ): CompletableFuture<HttpResponseFor<ProjectUser>> =
            retrieve(userId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            userId: String,
            params: UserRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectUser>> =
            retrieve(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(params: UserRetrieveParams): CompletableFuture<HttpResponseFor<ProjectUser>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: UserRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectUser>>

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/users/{user_id}`, but is otherwise the same as
         * [UserServiceAsync.update].
         */
        fun update(
            userId: String,
            params: UserUpdateParams,
        ): CompletableFuture<HttpResponseFor<ProjectUser>> =
            update(userId, params, RequestOptions.none())

        /** @see update */
        fun update(
            userId: String,
            params: UserUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectUser>> =
            update(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see update */
        fun update(params: UserUpdateParams): CompletableFuture<HttpResponseFor<ProjectUser>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: UserUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectUser>>

        /**
         * Returns a raw HTTP response for `get /organization/projects/{project_id}/users`, but is
         * otherwise the same as [UserServiceAsync.list].
         */
        fun list(projectId: String): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(projectId, UserListParams.none())

        /** @see list */
        fun list(
            projectId: String,
            params: UserListParams = UserListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see list */
        fun list(
            projectId: String,
            params: UserListParams = UserListParams.none(),
        ): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(projectId, params, RequestOptions.none())

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
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserListPageAsync>> =
            list(projectId, UserListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /organization/projects/{project_id}/users/{user_id}`, but is otherwise the same as
         * [UserServiceAsync.delete].
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
