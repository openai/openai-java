// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.roles.Role
import com.openai.models.admin.organization.roles.RoleCreateParams
import com.openai.models.admin.organization.roles.RoleDeleteParams
import com.openai.models.admin.organization.roles.RoleDeleteResponse
import com.openai.models.admin.organization.roles.RoleListPage
import com.openai.models.admin.organization.roles.RoleListParams
import com.openai.models.admin.organization.roles.RoleUpdateParams
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

    /** Creates a custom role for the organization. */
    fun create(params: RoleCreateParams): Role = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: RoleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Role

    /** Updates an existing organization role. */
    fun update(roleId: String): Role = update(roleId, RoleUpdateParams.none())

    /** @see update */
    fun update(
        roleId: String,
        params: RoleUpdateParams = RoleUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Role = update(params.toBuilder().roleId(roleId).build(), requestOptions)

    /** @see update */
    fun update(roleId: String, params: RoleUpdateParams = RoleUpdateParams.none()): Role =
        update(roleId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: RoleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Role

    /** @see update */
    fun update(params: RoleUpdateParams): Role = update(params, RequestOptions.none())

    /** @see update */
    fun update(roleId: String, requestOptions: RequestOptions): Role =
        update(roleId, RoleUpdateParams.none(), requestOptions)

    /** Lists the roles configured for the organization. */
    fun list(): RoleListPage = list(RoleListParams.none())

    /** @see list */
    fun list(
        params: RoleListParams = RoleListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoleListPage

    /** @see list */
    fun list(params: RoleListParams = RoleListParams.none()): RoleListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): RoleListPage =
        list(RoleListParams.none(), requestOptions)

    /** Deletes a custom role from the organization. */
    fun delete(roleId: String): RoleDeleteResponse = delete(roleId, RoleDeleteParams.none())

    /** @see delete */
    fun delete(
        roleId: String,
        params: RoleDeleteParams = RoleDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoleDeleteResponse = delete(params.toBuilder().roleId(roleId).build(), requestOptions)

    /** @see delete */
    fun delete(
        roleId: String,
        params: RoleDeleteParams = RoleDeleteParams.none(),
    ): RoleDeleteResponse = delete(roleId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: RoleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoleDeleteResponse

    /** @see delete */
    fun delete(params: RoleDeleteParams): RoleDeleteResponse = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(roleId: String, requestOptions: RequestOptions): RoleDeleteResponse =
        delete(roleId, RoleDeleteParams.none(), requestOptions)

    /** A view of [RoleService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RoleService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/roles`, but is otherwise the same as
         * [RoleService.create].
         */
        @MustBeClosed
        fun create(params: RoleCreateParams): HttpResponseFor<Role> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: RoleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Role>

        /**
         * Returns a raw HTTP response for `post /organization/roles/{role_id}`, but is otherwise
         * the same as [RoleService.update].
         */
        @MustBeClosed
        fun update(roleId: String): HttpResponseFor<Role> = update(roleId, RoleUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            roleId: String,
            params: RoleUpdateParams = RoleUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Role> = update(params.toBuilder().roleId(roleId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            roleId: String,
            params: RoleUpdateParams = RoleUpdateParams.none(),
        ): HttpResponseFor<Role> = update(roleId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: RoleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Role>

        /** @see update */
        @MustBeClosed
        fun update(params: RoleUpdateParams): HttpResponseFor<Role> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(roleId: String, requestOptions: RequestOptions): HttpResponseFor<Role> =
            update(roleId, RoleUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /organization/roles`, but is otherwise the same as
         * [RoleService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<RoleListPage> = list(RoleListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: RoleListParams = RoleListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoleListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: RoleListParams = RoleListParams.none()): HttpResponseFor<RoleListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<RoleListPage> =
            list(RoleListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/roles/{role_id}`, but is otherwise
         * the same as [RoleService.delete].
         */
        @MustBeClosed
        fun delete(roleId: String): HttpResponseFor<RoleDeleteResponse> =
            delete(roleId, RoleDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            roleId: String,
            params: RoleDeleteParams = RoleDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoleDeleteResponse> =
            delete(params.toBuilder().roleId(roleId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            roleId: String,
            params: RoleDeleteParams = RoleDeleteParams.none(),
        ): HttpResponseFor<RoleDeleteResponse> = delete(roleId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: RoleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoleDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(params: RoleDeleteParams): HttpResponseFor<RoleDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            roleId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RoleDeleteResponse> =
            delete(roleId, RoleDeleteParams.none(), requestOptions)
    }
}
