// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.vaults.Vault
import com.openai.models.beta.agents.vaults.VaultCreateParams
import com.openai.models.beta.agents.vaults.VaultDeleteParams
import com.openai.models.beta.agents.vaults.VaultDeleted
import com.openai.models.beta.agents.vaults.VaultListPageAsync
import com.openai.models.beta.agents.vaults.VaultListParams
import com.openai.models.beta.agents.vaults.VaultRetrieveParams
import com.openai.services.async.beta.agents.vaults.CredentialServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface VaultServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VaultServiceAsync

    fun credentials(): CredentialServiceAsync

    /**
     * Creates a vault for the current project. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun create(): CompletableFuture<Vault> = create(VaultCreateParams.none())

    /** @see create */
    fun create(
        params: VaultCreateParams = VaultCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Vault>

    /** @see create */
    fun create(params: VaultCreateParams = VaultCreateParams.none()): CompletableFuture<Vault> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<Vault> =
        create(VaultCreateParams.none(), requestOptions)

    /**
     * Retrieves a vault by its ID. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun retrieve(vaultId: String): CompletableFuture<Vault> =
        retrieve(vaultId, VaultRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        vaultId: String,
        params: VaultRetrieveParams = VaultRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Vault> =
        retrieve(params.toBuilder().vaultId(vaultId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        vaultId: String,
        params: VaultRetrieveParams = VaultRetrieveParams.none(),
    ): CompletableFuture<Vault> = retrieve(vaultId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: VaultRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Vault>

    /** @see retrieve */
    fun retrieve(params: VaultRetrieveParams): CompletableFuture<Vault> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(vaultId: String, requestOptions: RequestOptions): CompletableFuture<Vault> =
        retrieve(vaultId, VaultRetrieveParams.none(), requestOptions)

    /**
     * Lists vaults using ID-based pagination. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun list(): CompletableFuture<VaultListPageAsync> = list(VaultListParams.none())

    /** @see list */
    fun list(
        params: VaultListParams = VaultListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VaultListPageAsync>

    /** @see list */
    fun list(
        params: VaultListParams = VaultListParams.none()
    ): CompletableFuture<VaultListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<VaultListPageAsync> =
        list(VaultListParams.none(), requestOptions)

    /**
     * Deletes a vault and all its credentials. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun delete(vaultId: String): CompletableFuture<VaultDeleted> =
        delete(vaultId, VaultDeleteParams.none())

    /** @see delete */
    fun delete(
        vaultId: String,
        params: VaultDeleteParams = VaultDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VaultDeleted> =
        delete(params.toBuilder().vaultId(vaultId).build(), requestOptions)

    /** @see delete */
    fun delete(
        vaultId: String,
        params: VaultDeleteParams = VaultDeleteParams.none(),
    ): CompletableFuture<VaultDeleted> = delete(vaultId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: VaultDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VaultDeleted>

    /** @see delete */
    fun delete(params: VaultDeleteParams): CompletableFuture<VaultDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(vaultId: String, requestOptions: RequestOptions): CompletableFuture<VaultDeleted> =
        delete(vaultId, VaultDeleteParams.none(), requestOptions)

    /** A view of [VaultServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VaultServiceAsync.WithRawResponse

        fun credentials(): CredentialServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /vaults`, but is otherwise the same as
         * [VaultServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<Vault>> = create(VaultCreateParams.none())

        /** @see create */
        fun create(
            params: VaultCreateParams = VaultCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Vault>>

        /** @see create */
        fun create(
            params: VaultCreateParams = VaultCreateParams.none()
        ): CompletableFuture<HttpResponseFor<Vault>> = create(params, RequestOptions.none())

        /** @see create */
        fun create(requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<Vault>> =
            create(VaultCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /vaults/{vault_id}`, but is otherwise the same as
         * [VaultServiceAsync.retrieve].
         */
        fun retrieve(vaultId: String): CompletableFuture<HttpResponseFor<Vault>> =
            retrieve(vaultId, VaultRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            vaultId: String,
            params: VaultRetrieveParams = VaultRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Vault>> =
            retrieve(params.toBuilder().vaultId(vaultId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            vaultId: String,
            params: VaultRetrieveParams = VaultRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Vault>> =
            retrieve(vaultId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: VaultRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Vault>>

        /** @see retrieve */
        fun retrieve(params: VaultRetrieveParams): CompletableFuture<HttpResponseFor<Vault>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            vaultId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Vault>> =
            retrieve(vaultId, VaultRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /vaults`, but is otherwise the same as
         * [VaultServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<VaultListPageAsync>> =
            list(VaultListParams.none())

        /** @see list */
        fun list(
            params: VaultListParams = VaultListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VaultListPageAsync>>

        /** @see list */
        fun list(
            params: VaultListParams = VaultListParams.none()
        ): CompletableFuture<HttpResponseFor<VaultListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<VaultListPageAsync>> =
            list(VaultListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /vaults/{vault_id}`, but is otherwise the same as
         * [VaultServiceAsync.delete].
         */
        fun delete(vaultId: String): CompletableFuture<HttpResponseFor<VaultDeleted>> =
            delete(vaultId, VaultDeleteParams.none())

        /** @see delete */
        fun delete(
            vaultId: String,
            params: VaultDeleteParams = VaultDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VaultDeleted>> =
            delete(params.toBuilder().vaultId(vaultId).build(), requestOptions)

        /** @see delete */
        fun delete(
            vaultId: String,
            params: VaultDeleteParams = VaultDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<VaultDeleted>> =
            delete(vaultId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: VaultDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VaultDeleted>>

        /** @see delete */
        fun delete(params: VaultDeleteParams): CompletableFuture<HttpResponseFor<VaultDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            vaultId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VaultDeleted>> =
            delete(vaultId, VaultDeleteParams.none(), requestOptions)
    }
}
