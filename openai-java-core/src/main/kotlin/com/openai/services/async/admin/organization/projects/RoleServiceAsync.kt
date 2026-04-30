// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.roles.RoleCreateParams
import com.openai.models.admin.organization.projects.roles.RoleDeleteParams
import com.openai.models.admin.organization.projects.roles.RoleDeleteResponse
import com.openai.models.admin.organization.projects.roles.RoleListPageAsync
import com.openai.models.admin.organization.projects.roles.RoleListParams
import com.openai.models.admin.organization.projects.roles.RoleUpdateParams
import com.openai.models.admin.organization.roles.Role
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

    /** Creates a custom role for a project. */
    fun create(projectId: String, params: RoleCreateParams): CompletableFuture<Role> =
        create(projectId, params, RequestOptions.none())

    /** @see create */
    fun create(
        projectId: String,
        params: RoleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Role> =
        create(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see create */
    fun create(params: RoleCreateParams): CompletableFuture<Role> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: RoleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Role>

    /** Updates an existing project role. */
    fun update(roleId: String, params: RoleUpdateParams): CompletableFuture<Role> =
        update(roleId, params, RequestOptions.none())

    /** @see update */
    fun update(
        roleId: String,
        params: RoleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Role> = update(params.toBuilder().roleId(roleId).build(), requestOptions)

    /** @see update */
    fun update(params: RoleUpdateParams): CompletableFuture<Role> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: RoleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Role>

    /** Lists the roles configured for a project. */
    fun list(projectId: String): CompletableFuture<RoleListPageAsync> =
        list(projectId, RoleListParams.none())

    /** @see list */
    fun list(
        projectId: String,
        params: RoleListParams = RoleListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RoleListPageAsync> =
        list(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see list */
    fun list(
        projectId: String,
        params: RoleListParams = RoleListParams.none(),
    ): CompletableFuture<RoleListPageAsync> = list(projectId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: RoleListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RoleListPageAsync>

    /** @see list */
    fun list(params: RoleListParams): CompletableFuture<RoleListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        projectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<RoleListPageAsync> = list(projectId, RoleListParams.none(), requestOptions)

    /** Deletes a custom role from a project. */
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
         * Returns a raw HTTP response for `post /projects/{project_id}/roles`, but is otherwise the
         * same as [RoleServiceAsync.create].
         */
        fun create(
            projectId: String,
            params: RoleCreateParams,
        ): CompletableFuture<HttpResponseFor<Role>> =
            create(projectId, params, RequestOptions.none())

        /** @see create */
        fun create(
            projectId: String,
            params: RoleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Role>> =
            create(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see create */
        fun create(params: RoleCreateParams): CompletableFuture<HttpResponseFor<Role>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: RoleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Role>>

        /**
         * Returns a raw HTTP response for `post /projects/{project_id}/roles/{role_id}`, but is
         * otherwise the same as [RoleServiceAsync.update].
         */
        fun update(
            roleId: String,
            params: RoleUpdateParams,
        ): CompletableFuture<HttpResponseFor<Role>> = update(roleId, params, RequestOptions.none())

        /** @see update */
        fun update(
            roleId: String,
            params: RoleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Role>> =
            update(params.toBuilder().roleId(roleId).build(), requestOptions)

        /** @see update */
        fun update(params: RoleUpdateParams): CompletableFuture<HttpResponseFor<Role>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: RoleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Role>>

        /**
         * Returns a raw HTTP response for `get /projects/{project_id}/roles`, but is otherwise the
         * same as [RoleServiceAsync.list].
         */
        fun list(projectId: String): CompletableFuture<HttpResponseFor<RoleListPageAsync>> =
            list(projectId, RoleListParams.none())

        /** @see list */
        fun list(
            projectId: String,
            params: RoleListParams = RoleListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RoleListPageAsync>> =
            list(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see list */
        fun list(
            projectId: String,
            params: RoleListParams = RoleListParams.none(),
        ): CompletableFuture<HttpResponseFor<RoleListPageAsync>> =
            list(projectId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: RoleListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RoleListPageAsync>>

        /** @see list */
        fun list(params: RoleListParams): CompletableFuture<HttpResponseFor<RoleListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RoleListPageAsync>> =
            list(projectId, RoleListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /projects/{project_id}/roles/{role_id}`, but is
         * otherwise the same as [RoleServiceAsync.delete].
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
