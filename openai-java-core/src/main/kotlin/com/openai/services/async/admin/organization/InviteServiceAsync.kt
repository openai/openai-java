// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.invites.Invite
import com.openai.models.admin.organization.invites.InviteCreateParams
import com.openai.models.admin.organization.invites.InviteDeleteParams
import com.openai.models.admin.organization.invites.InviteDeleteResponse
import com.openai.models.admin.organization.invites.InviteListPageAsync
import com.openai.models.admin.organization.invites.InviteListParams
import com.openai.models.admin.organization.invites.InviteRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface InviteServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InviteServiceAsync

    /**
     * Create an invite for a user to the organization. The invite must be accepted by the user
     * before they have access to the organization.
     */
    fun create(params: InviteCreateParams): CompletableFuture<Invite> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: InviteCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Invite>

    /** Retrieves an invite. */
    fun retrieve(inviteId: String): CompletableFuture<Invite> =
        retrieve(inviteId, InviteRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        inviteId: String,
        params: InviteRetrieveParams = InviteRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Invite> =
        retrieve(params.toBuilder().inviteId(inviteId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        inviteId: String,
        params: InviteRetrieveParams = InviteRetrieveParams.none(),
    ): CompletableFuture<Invite> = retrieve(inviteId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: InviteRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Invite>

    /** @see retrieve */
    fun retrieve(params: InviteRetrieveParams): CompletableFuture<Invite> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(inviteId: String, requestOptions: RequestOptions): CompletableFuture<Invite> =
        retrieve(inviteId, InviteRetrieveParams.none(), requestOptions)

    /** Returns a list of invites in the organization. */
    fun list(): CompletableFuture<InviteListPageAsync> = list(InviteListParams.none())

    /** @see list */
    fun list(
        params: InviteListParams = InviteListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InviteListPageAsync>

    /** @see list */
    fun list(
        params: InviteListParams = InviteListParams.none()
    ): CompletableFuture<InviteListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<InviteListPageAsync> =
        list(InviteListParams.none(), requestOptions)

    /** Delete an invite. If the invite has already been accepted, it cannot be deleted. */
    fun delete(inviteId: String): CompletableFuture<InviteDeleteResponse> =
        delete(inviteId, InviteDeleteParams.none())

    /** @see delete */
    fun delete(
        inviteId: String,
        params: InviteDeleteParams = InviteDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InviteDeleteResponse> =
        delete(params.toBuilder().inviteId(inviteId).build(), requestOptions)

    /** @see delete */
    fun delete(
        inviteId: String,
        params: InviteDeleteParams = InviteDeleteParams.none(),
    ): CompletableFuture<InviteDeleteResponse> = delete(inviteId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: InviteDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InviteDeleteResponse>

    /** @see delete */
    fun delete(params: InviteDeleteParams): CompletableFuture<InviteDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        inviteId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<InviteDeleteResponse> =
        delete(inviteId, InviteDeleteParams.none(), requestOptions)

    /**
     * A view of [InviteServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InviteServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/invites`, but is otherwise the same
         * as [InviteServiceAsync.create].
         */
        fun create(params: InviteCreateParams): CompletableFuture<HttpResponseFor<Invite>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: InviteCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Invite>>

        /**
         * Returns a raw HTTP response for `get /organization/invites/{invite_id}`, but is otherwise
         * the same as [InviteServiceAsync.retrieve].
         */
        fun retrieve(inviteId: String): CompletableFuture<HttpResponseFor<Invite>> =
            retrieve(inviteId, InviteRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            inviteId: String,
            params: InviteRetrieveParams = InviteRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Invite>> =
            retrieve(params.toBuilder().inviteId(inviteId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            inviteId: String,
            params: InviteRetrieveParams = InviteRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Invite>> =
            retrieve(inviteId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: InviteRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Invite>>

        /** @see retrieve */
        fun retrieve(params: InviteRetrieveParams): CompletableFuture<HttpResponseFor<Invite>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            inviteId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Invite>> =
            retrieve(inviteId, InviteRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /organization/invites`, but is otherwise the same as
         * [InviteServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<InviteListPageAsync>> =
            list(InviteListParams.none())

        /** @see list */
        fun list(
            params: InviteListParams = InviteListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InviteListPageAsync>>

        /** @see list */
        fun list(
            params: InviteListParams = InviteListParams.none()
        ): CompletableFuture<HttpResponseFor<InviteListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<InviteListPageAsync>> =
            list(InviteListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/invites/{invite_id}`, but is
         * otherwise the same as [InviteServiceAsync.delete].
         */
        fun delete(inviteId: String): CompletableFuture<HttpResponseFor<InviteDeleteResponse>> =
            delete(inviteId, InviteDeleteParams.none())

        /** @see delete */
        fun delete(
            inviteId: String,
            params: InviteDeleteParams = InviteDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InviteDeleteResponse>> =
            delete(params.toBuilder().inviteId(inviteId).build(), requestOptions)

        /** @see delete */
        fun delete(
            inviteId: String,
            params: InviteDeleteParams = InviteDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<InviteDeleteResponse>> =
            delete(inviteId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: InviteDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InviteDeleteResponse>>

        /** @see delete */
        fun delete(
            params: InviteDeleteParams
        ): CompletableFuture<HttpResponseFor<InviteDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            inviteId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InviteDeleteResponse>> =
            delete(inviteId, InviteDeleteParams.none(), requestOptions)
    }
}
