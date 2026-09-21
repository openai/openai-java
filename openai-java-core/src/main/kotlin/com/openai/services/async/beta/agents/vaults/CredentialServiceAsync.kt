// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.vaults

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.vaults.credentials.Credential
import com.openai.models.beta.agents.vaults.credentials.CredentialCreateParams
import com.openai.models.beta.agents.vaults.credentials.CredentialDeleteParams
import com.openai.models.beta.agents.vaults.credentials.CredentialDeleted
import com.openai.models.beta.agents.vaults.credentials.CredentialListPageAsync
import com.openai.models.beta.agents.vaults.credentials.CredentialListParams
import com.openai.models.beta.agents.vaults.credentials.CredentialRetrieveParams
import com.openai.models.beta.agents.vaults.credentials.CredentialUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface CredentialServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CredentialServiceAsync

    /**
     * Creates a vault credential. Secret values are write-only and are never returned. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun create(vaultId: String, params: CredentialCreateParams): CompletableFuture<Credential> =
        create(vaultId, params, RequestOptions.none())

    /** @see create */
    fun create(
        vaultId: String,
        params: CredentialCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Credential> =
        create(params.toBuilder().vaultId(vaultId).build(), requestOptions)

    /** @see create */
    fun create(params: CredentialCreateParams): CompletableFuture<Credential> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CredentialCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Credential>

    /**
     * Retrieves vault credential metadata without returning secret values. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun retrieve(
        credentialId: String,
        params: CredentialRetrieveParams,
    ): CompletableFuture<Credential> = retrieve(credentialId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        credentialId: String,
        params: CredentialRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Credential> =
        retrieve(params.toBuilder().credentialId(credentialId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: CredentialRetrieveParams): CompletableFuture<Credential> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: CredentialRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Credential>

    /**
     * Rotates a vault credential's write-only secret and returns only credential metadata. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun update(
        credentialId: String,
        params: CredentialUpdateParams,
    ): CompletableFuture<Credential> = update(credentialId, params, RequestOptions.none())

    /** @see update */
    fun update(
        credentialId: String,
        params: CredentialUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Credential> =
        update(params.toBuilder().credentialId(credentialId).build(), requestOptions)

    /** @see update */
    fun update(params: CredentialUpdateParams): CompletableFuture<Credential> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: CredentialUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Credential>

    /**
     * Lists a vault's credentials using ID-based pagination without returning secret values. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun list(vaultId: String): CompletableFuture<CredentialListPageAsync> =
        list(vaultId, CredentialListParams.none())

    /** @see list */
    fun list(
        vaultId: String,
        params: CredentialListParams = CredentialListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CredentialListPageAsync> =
        list(params.toBuilder().vaultId(vaultId).build(), requestOptions)

    /** @see list */
    fun list(
        vaultId: String,
        params: CredentialListParams = CredentialListParams.none(),
    ): CompletableFuture<CredentialListPageAsync> = list(vaultId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: CredentialListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CredentialListPageAsync>

    /** @see list */
    fun list(params: CredentialListParams): CompletableFuture<CredentialListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        vaultId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<CredentialListPageAsync> =
        list(vaultId, CredentialListParams.none(), requestOptions)

    /**
     * Deletes a vault credential. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun delete(
        credentialId: String,
        params: CredentialDeleteParams,
    ): CompletableFuture<CredentialDeleted> = delete(credentialId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        credentialId: String,
        params: CredentialDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CredentialDeleted> =
        delete(params.toBuilder().credentialId(credentialId).build(), requestOptions)

    /** @see delete */
    fun delete(params: CredentialDeleteParams): CompletableFuture<CredentialDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: CredentialDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CredentialDeleted>

    /**
     * A view of [CredentialServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CredentialServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /vaults/{vault_id}/credentials`, but is otherwise
         * the same as [CredentialServiceAsync.create].
         */
        fun create(
            vaultId: String,
            params: CredentialCreateParams,
        ): CompletableFuture<HttpResponseFor<Credential>> =
            create(vaultId, params, RequestOptions.none())

        /** @see create */
        fun create(
            vaultId: String,
            params: CredentialCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Credential>> =
            create(params.toBuilder().vaultId(vaultId).build(), requestOptions)

        /** @see create */
        fun create(params: CredentialCreateParams): CompletableFuture<HttpResponseFor<Credential>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: CredentialCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Credential>>

        /**
         * Returns a raw HTTP response for `get /vaults/{vault_id}/credentials/{credential_id}`, but
         * is otherwise the same as [CredentialServiceAsync.retrieve].
         */
        fun retrieve(
            credentialId: String,
            params: CredentialRetrieveParams,
        ): CompletableFuture<HttpResponseFor<Credential>> =
            retrieve(credentialId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            credentialId: String,
            params: CredentialRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Credential>> =
            retrieve(params.toBuilder().credentialId(credentialId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: CredentialRetrieveParams
        ): CompletableFuture<HttpResponseFor<Credential>> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: CredentialRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Credential>>

        /**
         * Returns a raw HTTP response for `post /vaults/{vault_id}/credentials/{credential_id}`,
         * but is otherwise the same as [CredentialServiceAsync.update].
         */
        fun update(
            credentialId: String,
            params: CredentialUpdateParams,
        ): CompletableFuture<HttpResponseFor<Credential>> =
            update(credentialId, params, RequestOptions.none())

        /** @see update */
        fun update(
            credentialId: String,
            params: CredentialUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Credential>> =
            update(params.toBuilder().credentialId(credentialId).build(), requestOptions)

        /** @see update */
        fun update(params: CredentialUpdateParams): CompletableFuture<HttpResponseFor<Credential>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: CredentialUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Credential>>

        /**
         * Returns a raw HTTP response for `get /vaults/{vault_id}/credentials`, but is otherwise
         * the same as [CredentialServiceAsync.list].
         */
        fun list(vaultId: String): CompletableFuture<HttpResponseFor<CredentialListPageAsync>> =
            list(vaultId, CredentialListParams.none())

        /** @see list */
        fun list(
            vaultId: String,
            params: CredentialListParams = CredentialListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CredentialListPageAsync>> =
            list(params.toBuilder().vaultId(vaultId).build(), requestOptions)

        /** @see list */
        fun list(
            vaultId: String,
            params: CredentialListParams = CredentialListParams.none(),
        ): CompletableFuture<HttpResponseFor<CredentialListPageAsync>> =
            list(vaultId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: CredentialListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CredentialListPageAsync>>

        /** @see list */
        fun list(
            params: CredentialListParams
        ): CompletableFuture<HttpResponseFor<CredentialListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            vaultId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CredentialListPageAsync>> =
            list(vaultId, CredentialListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /vaults/{vault_id}/credentials/{credential_id}`,
         * but is otherwise the same as [CredentialServiceAsync.delete].
         */
        fun delete(
            credentialId: String,
            params: CredentialDeleteParams,
        ): CompletableFuture<HttpResponseFor<CredentialDeleted>> =
            delete(credentialId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            credentialId: String,
            params: CredentialDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CredentialDeleted>> =
            delete(params.toBuilder().credentialId(credentialId).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: CredentialDeleteParams
        ): CompletableFuture<HttpResponseFor<CredentialDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: CredentialDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CredentialDeleted>>
    }
}
