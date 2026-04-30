// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.invites.Invite
import com.openai.models.admin.organization.invites.InviteCreateParams
import com.openai.models.admin.organization.invites.InviteDeleteParams
import com.openai.models.admin.organization.invites.InviteDeleteResponse
import com.openai.models.admin.organization.invites.InviteListPage
import com.openai.models.admin.organization.invites.InviteListParams
import com.openai.models.admin.organization.invites.InviteRetrieveParams
import java.util.function.Consumer

interface InviteService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InviteService

    /**
     * Create an invite for a user to the organization. The invite must be accepted by the user
     * before they have access to the organization.
     */
    fun create(params: InviteCreateParams): Invite = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: InviteCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Invite

    /** Retrieves an invite. */
    fun retrieve(inviteId: String): Invite = retrieve(inviteId, InviteRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        inviteId: String,
        params: InviteRetrieveParams = InviteRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Invite = retrieve(params.toBuilder().inviteId(inviteId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        inviteId: String,
        params: InviteRetrieveParams = InviteRetrieveParams.none(),
    ): Invite = retrieve(inviteId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: InviteRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Invite

    /** @see retrieve */
    fun retrieve(params: InviteRetrieveParams): Invite = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(inviteId: String, requestOptions: RequestOptions): Invite =
        retrieve(inviteId, InviteRetrieveParams.none(), requestOptions)

    /** Returns a list of invites in the organization. */
    fun list(): InviteListPage = list(InviteListParams.none())

    /** @see list */
    fun list(
        params: InviteListParams = InviteListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InviteListPage

    /** @see list */
    fun list(params: InviteListParams = InviteListParams.none()): InviteListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): InviteListPage =
        list(InviteListParams.none(), requestOptions)

    /** Delete an invite. If the invite has already been accepted, it cannot be deleted. */
    fun delete(inviteId: String): InviteDeleteResponse = delete(inviteId, InviteDeleteParams.none())

    /** @see delete */
    fun delete(
        inviteId: String,
        params: InviteDeleteParams = InviteDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InviteDeleteResponse = delete(params.toBuilder().inviteId(inviteId).build(), requestOptions)

    /** @see delete */
    fun delete(
        inviteId: String,
        params: InviteDeleteParams = InviteDeleteParams.none(),
    ): InviteDeleteResponse = delete(inviteId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: InviteDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InviteDeleteResponse

    /** @see delete */
    fun delete(params: InviteDeleteParams): InviteDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(inviteId: String, requestOptions: RequestOptions): InviteDeleteResponse =
        delete(inviteId, InviteDeleteParams.none(), requestOptions)

    /** A view of [InviteService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): InviteService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/invites`, but is otherwise the same
         * as [InviteService.create].
         */
        @MustBeClosed
        fun create(params: InviteCreateParams): HttpResponseFor<Invite> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: InviteCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Invite>

        /**
         * Returns a raw HTTP response for `get /organization/invites/{invite_id}`, but is otherwise
         * the same as [InviteService.retrieve].
         */
        @MustBeClosed
        fun retrieve(inviteId: String): HttpResponseFor<Invite> =
            retrieve(inviteId, InviteRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            inviteId: String,
            params: InviteRetrieveParams = InviteRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Invite> =
            retrieve(params.toBuilder().inviteId(inviteId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            inviteId: String,
            params: InviteRetrieveParams = InviteRetrieveParams.none(),
        ): HttpResponseFor<Invite> = retrieve(inviteId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: InviteRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Invite>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: InviteRetrieveParams): HttpResponseFor<Invite> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(inviteId: String, requestOptions: RequestOptions): HttpResponseFor<Invite> =
            retrieve(inviteId, InviteRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /organization/invites`, but is otherwise the same as
         * [InviteService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<InviteListPage> = list(InviteListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: InviteListParams = InviteListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InviteListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: InviteListParams = InviteListParams.none()
        ): HttpResponseFor<InviteListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<InviteListPage> =
            list(InviteListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/invites/{invite_id}`, but is
         * otherwise the same as [InviteService.delete].
         */
        @MustBeClosed
        fun delete(inviteId: String): HttpResponseFor<InviteDeleteResponse> =
            delete(inviteId, InviteDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            inviteId: String,
            params: InviteDeleteParams = InviteDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InviteDeleteResponse> =
            delete(params.toBuilder().inviteId(inviteId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            inviteId: String,
            params: InviteDeleteParams = InviteDeleteParams.none(),
        ): HttpResponseFor<InviteDeleteResponse> = delete(inviteId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: InviteDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InviteDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(params: InviteDeleteParams): HttpResponseFor<InviteDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            inviteId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InviteDeleteResponse> =
            delete(inviteId, InviteDeleteParams.none(), requestOptions)
    }
}
