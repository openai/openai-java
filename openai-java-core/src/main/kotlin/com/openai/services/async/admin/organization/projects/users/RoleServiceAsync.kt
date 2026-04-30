// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects.users

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.users.roles.RoleCreateParams
import com.openai.models.admin.organization.projects.users.roles.RoleCreateResponse
import com.openai.models.admin.organization.projects.users.roles.RoleDeleteParams
import com.openai.models.admin.organization.projects.users.roles.RoleDeleteResponse
import com.openai.models.admin.organization.projects.users.roles.RoleListPageAsync
import com.openai.models.admin.organization.projects.users.roles.RoleListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface RoleServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RoleServiceAsync

    /** Assigns a project role to a user within a project. */
    fun create(userId: String, params: RoleCreateParams): CompletableFuture<RoleCreateResponse> =
        create(userId, params, RequestOptions.none())

    /** @see create */
    fun create(
        userId: String,
        params: RoleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RoleCreateResponse> =
        create(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see create */
    fun create(params: RoleCreateParams): CompletableFuture<RoleCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: RoleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RoleCreateResponse>

    /** Lists the project roles assigned to a user within a project. */
    fun list(userId: String, params: RoleListParams): CompletableFuture<RoleListPageAsync> =
        list(userId, params, RequestOptions.none())

    /** @see list */
    fun list(
        userId: String,
        params: RoleListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RoleListPageAsync> =
        list(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see list */
    fun list(params: RoleListParams): CompletableFuture<RoleListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: RoleListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RoleListPageAsync>

    /** Unassigns a project role from a user within a project. */
    fun delete(roleId: String, params: RoleDeleteParams): CompletableFuture<RoleDeleteResponse> =
        delete(roleId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        roleId: String,
        params: RoleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RoleDeleteResponse> =
        delete(params.toBuilder().roleId(roleId).build(), requestOptions)

    /** @see delete */
    fun delete(params: RoleDeleteParams): CompletableFuture<RoleDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: RoleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RoleDeleteResponse>

    /** A view of [RoleServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RoleServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /projects/{project_id}/users/{user_id}/roles`, but
         * is otherwise the same as [RoleServiceAsync.create].
         */
        fun create(
            userId: String,
            params: RoleCreateParams,
        ): CompletableFuture<HttpResponseFor<RoleCreateResponse>> =
            create(userId, params, RequestOptions.none())

        /** @see create */
        fun create(
            userId: String,
            params: RoleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RoleCreateResponse>> =
            create(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see create */
        fun create(
            params: RoleCreateParams
        ): CompletableFuture<HttpResponseFor<RoleCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: RoleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RoleCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /projects/{project_id}/users/{user_id}/roles`, but
         * is otherwise the same as [RoleServiceAsync.list].
         */
        fun list(
            userId: String,
            params: RoleListParams,
        ): CompletableFuture<HttpResponseFor<RoleListPageAsync>> =
            list(userId, params, RequestOptions.none())

        /** @see list */
        fun list(
            userId: String,
            params: RoleListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RoleListPageAsync>> =
            list(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see list */
        fun list(params: RoleListParams): CompletableFuture<HttpResponseFor<RoleListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            params: RoleListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RoleListPageAsync>>

        /**
         * Returns a raw HTTP response for `delete
         * /projects/{project_id}/users/{user_id}/roles/{role_id}`, but is otherwise the same as
         * [RoleServiceAsync.delete].
         */
        fun delete(
            roleId: String,
            params: RoleDeleteParams,
        ): CompletableFuture<HttpResponseFor<RoleDeleteResponse>> =
            delete(roleId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            roleId: String,
            params: RoleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RoleDeleteResponse>> =
            delete(params.toBuilder().roleId(roleId).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: RoleDeleteParams
        ): CompletableFuture<HttpResponseFor<RoleDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: RoleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RoleDeleteResponse>>
    }
}
