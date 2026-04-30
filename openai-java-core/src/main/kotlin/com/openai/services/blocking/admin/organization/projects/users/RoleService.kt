// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects.users

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.users.roles.RoleCreateParams
import com.openai.models.admin.organization.projects.users.roles.RoleCreateResponse
import com.openai.models.admin.organization.projects.users.roles.RoleDeleteParams
import com.openai.models.admin.organization.projects.users.roles.RoleDeleteResponse
import com.openai.models.admin.organization.projects.users.roles.RoleListPage
import com.openai.models.admin.organization.projects.users.roles.RoleListParams
import java.util.function.Consumer

interface RoleService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RoleService

    /** Assigns a project role to a user within a project. */
    fun create(userId: String, params: RoleCreateParams): RoleCreateResponse =
        create(userId, params, RequestOptions.none())

    /** @see create */
    fun create(
        userId: String,
        params: RoleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoleCreateResponse = create(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see create */
    fun create(params: RoleCreateParams): RoleCreateResponse = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: RoleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoleCreateResponse

    /** Lists the project roles assigned to a user within a project. */
    fun list(userId: String, params: RoleListParams): RoleListPage =
        list(userId, params, RequestOptions.none())

    /** @see list */
    fun list(
        userId: String,
        params: RoleListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoleListPage = list(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see list */
    fun list(params: RoleListParams): RoleListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: RoleListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoleListPage

    /** Unassigns a project role from a user within a project. */
    fun delete(roleId: String, params: RoleDeleteParams): RoleDeleteResponse =
        delete(roleId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        roleId: String,
        params: RoleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoleDeleteResponse = delete(params.toBuilder().roleId(roleId).build(), requestOptions)

    /** @see delete */
    fun delete(params: RoleDeleteParams): RoleDeleteResponse = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: RoleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoleDeleteResponse

    /** A view of [RoleService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RoleService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /projects/{project_id}/users/{user_id}/roles`, but
         * is otherwise the same as [RoleService.create].
         */
        @MustBeClosed
        fun create(userId: String, params: RoleCreateParams): HttpResponseFor<RoleCreateResponse> =
            create(userId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            userId: String,
            params: RoleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoleCreateResponse> =
            create(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: RoleCreateParams): HttpResponseFor<RoleCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: RoleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoleCreateResponse>

        /**
         * Returns a raw HTTP response for `get /projects/{project_id}/users/{user_id}/roles`, but
         * is otherwise the same as [RoleService.list].
         */
        @MustBeClosed
        fun list(userId: String, params: RoleListParams): HttpResponseFor<RoleListPage> =
            list(userId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            userId: String,
            params: RoleListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoleListPage> =
            list(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(params: RoleListParams): HttpResponseFor<RoleListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: RoleListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoleListPage>

        /**
         * Returns a raw HTTP response for `delete
         * /projects/{project_id}/users/{user_id}/roles/{role_id}`, but is otherwise the same as
         * [RoleService.delete].
         */
        @MustBeClosed
        fun delete(roleId: String, params: RoleDeleteParams): HttpResponseFor<RoleDeleteResponse> =
            delete(roleId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            roleId: String,
            params: RoleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoleDeleteResponse> =
            delete(params.toBuilder().roleId(roleId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: RoleDeleteParams): HttpResponseFor<RoleDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: RoleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoleDeleteResponse>
    }
}
