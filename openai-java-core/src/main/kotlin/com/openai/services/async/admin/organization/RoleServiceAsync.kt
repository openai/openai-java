// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.roles.Role
import com.openai.models.admin.organization.roles.RoleCreateParams
import com.openai.models.admin.organization.roles.RoleDeleteParams
import com.openai.models.admin.organization.roles.RoleDeleteResponse
import com.openai.models.admin.organization.roles.RoleListPageAsync
import com.openai.models.admin.organization.roles.RoleListParams
import com.openai.models.admin.organization.roles.RoleUpdateParams
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

    /** Creates a custom role for the organization. */
    fun create(params: RoleCreateParams): CompletableFuture<Role> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: RoleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Role>

    /** Updates an existing organization role. */
    fun update(roleId: String): CompletableFuture<Role> = update(roleId, RoleUpdateParams.none())

    /** @see update */
    fun update(
        roleId: String,
        params: RoleUpdateParams = RoleUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Role> = update(params.toBuilder().roleId(roleId).build(), requestOptions)

    /** @see update */
    fun update(
        roleId: String,
        params: RoleUpdateParams = RoleUpdateParams.none(),
    ): CompletableFuture<Role> = update(roleId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: RoleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Role>

    /** @see update */
    fun update(params: RoleUpdateParams): CompletableFuture<Role> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(roleId: String, requestOptions: RequestOptions): CompletableFuture<Role> =
        update(roleId, RoleUpdateParams.none(), requestOptions)

    /** Lists the roles configured for the organization. */
    fun list(): CompletableFuture<RoleListPageAsync> = list(RoleListParams.none())

    /** @see list */
    fun list(
        params: RoleListParams = RoleListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RoleListPageAsync>

    /** @see list */
    fun list(params: RoleListParams = RoleListParams.none()): CompletableFuture<RoleListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<RoleListPageAsync> =
        list(RoleListParams.none(), requestOptions)

    /** Deletes a custom role from the organization. */
    fun delete(roleId: String): CompletableFuture<RoleDeleteResponse> =
        delete(roleId, RoleDeleteParams.none())

    /** @see delete */
    fun delete(
        roleId: String,
        params: RoleDeleteParams = RoleDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RoleDeleteResponse> =
        delete(params.toBuilder().roleId(roleId).build(), requestOptions)

    /** @see delete */
    fun delete(
        roleId: String,
        params: RoleDeleteParams = RoleDeleteParams.none(),
    ): CompletableFuture<RoleDeleteResponse> = delete(roleId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: RoleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RoleDeleteResponse>

    /** @see delete */
    fun delete(params: RoleDeleteParams): CompletableFuture<RoleDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        roleId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<RoleDeleteResponse> =
        delete(roleId, RoleDeleteParams.none(), requestOptions)

    /** A view of [RoleServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RoleServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/roles`, but is otherwise the same as
         * [RoleServiceAsync.create].
         */
        fun create(params: RoleCreateParams): CompletableFuture<HttpResponseFor<Role>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: RoleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Role>>

        /**
         * Returns a raw HTTP response for `post /organization/roles/{role_id}`, but is otherwise
         * the same as [RoleServiceAsync.update].
         */
        fun update(roleId: String): CompletableFuture<HttpResponseFor<Role>> =
            update(roleId, RoleUpdateParams.none())

        /** @see update */
        fun update(
            roleId: String,
            params: RoleUpdateParams = RoleUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Role>> =
            update(params.toBuilder().roleId(roleId).build(), requestOptions)

        /** @see update */
        fun update(
            roleId: String,
            params: RoleUpdateParams = RoleUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<Role>> = update(roleId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: RoleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Role>>

        /** @see update */
        fun update(params: RoleUpdateParams): CompletableFuture<HttpResponseFor<Role>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            roleId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Role>> =
            update(roleId, RoleUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /organization/roles`, but is otherwise the same as
         * [RoleServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<RoleListPageAsync>> =
            list(RoleListParams.none())

        /** @see list */
        fun list(
            params: RoleListParams = RoleListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RoleListPageAsync>>

        /** @see list */
        fun list(
            params: RoleListParams = RoleListParams.none()
        ): CompletableFuture<HttpResponseFor<RoleListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<RoleListPageAsync>> =
            list(RoleListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/roles/{role_id}`, but is otherwise
         * the same as [RoleServiceAsync.delete].
         */
        fun delete(roleId: String): CompletableFuture<HttpResponseFor<RoleDeleteResponse>> =
            delete(roleId, RoleDeleteParams.none())

        /** @see delete */
        fun delete(
            roleId: String,
            params: RoleDeleteParams = RoleDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RoleDeleteResponse>> =
            delete(params.toBuilder().roleId(roleId).build(), requestOptions)

        /** @see delete */
        fun delete(
            roleId: String,
            params: RoleDeleteParams = RoleDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<RoleDeleteResponse>> =
            delete(roleId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: RoleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RoleDeleteResponse>>

        /** @see delete */
        fun delete(
            params: RoleDeleteParams
        ): CompletableFuture<HttpResponseFor<RoleDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            roleId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RoleDeleteResponse>> =
            delete(roleId, RoleDeleteParams.none(), requestOptions)
    }
}
