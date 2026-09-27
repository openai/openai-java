// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.vaults.Vault
import com.openai.models.beta.agents.vaults.VaultCreateParams
import com.openai.models.beta.agents.vaults.VaultDeleteParams
import com.openai.models.beta.agents.vaults.VaultDeleted
import com.openai.models.beta.agents.vaults.VaultListPage
import com.openai.models.beta.agents.vaults.VaultListParams
import com.openai.models.beta.agents.vaults.VaultRetrieveParams
import com.openai.services.blocking.beta.agents.vaults.CredentialService
import java.util.function.Consumer

interface VaultService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VaultService

    fun credentials(): CredentialService

    /**
     * Creates a vault for the current project. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun create(): Vault = create(VaultCreateParams.none())

    /** @see create */
    fun create(
        params: VaultCreateParams = VaultCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Vault

    /** @see create */
    fun create(params: VaultCreateParams = VaultCreateParams.none()): Vault =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): Vault =
        create(VaultCreateParams.none(), requestOptions)

    /**
     * Retrieves a vault by its ID. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun retrieve(vaultId: String): Vault = retrieve(vaultId, VaultRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        vaultId: String,
        params: VaultRetrieveParams = VaultRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Vault = retrieve(params.toBuilder().vaultId(vaultId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(vaultId: String, params: VaultRetrieveParams = VaultRetrieveParams.none()): Vault =
        retrieve(vaultId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: VaultRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Vault

    /** @see retrieve */
    fun retrieve(params: VaultRetrieveParams): Vault = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(vaultId: String, requestOptions: RequestOptions): Vault =
        retrieve(vaultId, VaultRetrieveParams.none(), requestOptions)

    /**
     * Lists vaults using ID-based pagination. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun list(): VaultListPage = list(VaultListParams.none())

    /** @see list */
    fun list(
        params: VaultListParams = VaultListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VaultListPage

    /** @see list */
    fun list(params: VaultListParams = VaultListParams.none()): VaultListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): VaultListPage =
        list(VaultListParams.none(), requestOptions)

    /**
     * Deletes a vault and all its credentials. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun delete(vaultId: String): VaultDeleted = delete(vaultId, VaultDeleteParams.none())

    /** @see delete */
    fun delete(
        vaultId: String,
        params: VaultDeleteParams = VaultDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VaultDeleted = delete(params.toBuilder().vaultId(vaultId).build(), requestOptions)

    /** @see delete */
    fun delete(
        vaultId: String,
        params: VaultDeleteParams = VaultDeleteParams.none(),
    ): VaultDeleted = delete(vaultId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: VaultDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VaultDeleted

    /** @see delete */
    fun delete(params: VaultDeleteParams): VaultDeleted = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(vaultId: String, requestOptions: RequestOptions): VaultDeleted =
        delete(vaultId, VaultDeleteParams.none(), requestOptions)

    /** A view of [VaultService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): VaultService.WithRawResponse

        fun credentials(): CredentialService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /vaults`, but is otherwise the same as
         * [VaultService.create].
         */
        @MustBeClosed fun create(): HttpResponseFor<Vault> = create(VaultCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: VaultCreateParams = VaultCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Vault>

        /** @see create */
        @MustBeClosed
        fun create(params: VaultCreateParams = VaultCreateParams.none()): HttpResponseFor<Vault> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<Vault> =
            create(VaultCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /vaults/{vault_id}`, but is otherwise the same as
         * [VaultService.retrieve].
         */
        @MustBeClosed
        fun retrieve(vaultId: String): HttpResponseFor<Vault> =
            retrieve(vaultId, VaultRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            vaultId: String,
            params: VaultRetrieveParams = VaultRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Vault> =
            retrieve(params.toBuilder().vaultId(vaultId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            vaultId: String,
            params: VaultRetrieveParams = VaultRetrieveParams.none(),
        ): HttpResponseFor<Vault> = retrieve(vaultId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: VaultRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Vault>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: VaultRetrieveParams): HttpResponseFor<Vault> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(vaultId: String, requestOptions: RequestOptions): HttpResponseFor<Vault> =
            retrieve(vaultId, VaultRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /vaults`, but is otherwise the same as
         * [VaultService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<VaultListPage> = list(VaultListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: VaultListParams = VaultListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VaultListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: VaultListParams = VaultListParams.none()): HttpResponseFor<VaultListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<VaultListPage> =
            list(VaultListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /vaults/{vault_id}`, but is otherwise the same as
         * [VaultService.delete].
         */
        @MustBeClosed
        fun delete(vaultId: String): HttpResponseFor<VaultDeleted> =
            delete(vaultId, VaultDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            vaultId: String,
            params: VaultDeleteParams = VaultDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VaultDeleted> =
            delete(params.toBuilder().vaultId(vaultId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            vaultId: String,
            params: VaultDeleteParams = VaultDeleteParams.none(),
        ): HttpResponseFor<VaultDeleted> = delete(vaultId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: VaultDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VaultDeleted>

        /** @see delete */
        @MustBeClosed
        fun delete(params: VaultDeleteParams): HttpResponseFor<VaultDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(vaultId: String, requestOptions: RequestOptions): HttpResponseFor<VaultDeleted> =
            delete(vaultId, VaultDeleteParams.none(), requestOptions)
    }
}
