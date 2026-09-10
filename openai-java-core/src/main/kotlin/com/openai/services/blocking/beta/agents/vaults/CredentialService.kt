// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.vaults

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.agents.vaults.credentials.Credential
import com.openai.models.beta.agents.vaults.credentials.CredentialCreateParams
import com.openai.models.beta.agents.vaults.credentials.CredentialDeleteParams
import com.openai.models.beta.agents.vaults.credentials.CredentialDeleted
import com.openai.models.beta.agents.vaults.credentials.CredentialListPage
import com.openai.models.beta.agents.vaults.credentials.CredentialListParams
import com.openai.models.beta.agents.vaults.credentials.CredentialRetrieveParams
import com.openai.models.beta.agents.vaults.credentials.CredentialUpdateParams
import java.util.function.Consumer

interface CredentialService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CredentialService

    /**
     * Creates a vault credential. Secret values are write-only and are never returned. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun create(vaultId: String, params: CredentialCreateParams): Credential =
        create(vaultId, params, RequestOptions.none())

    /** @see create */
    fun create(
        vaultId: String,
        params: CredentialCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Credential = create(params.toBuilder().vaultId(vaultId).build(), requestOptions)

    /** @see create */
    fun create(params: CredentialCreateParams): Credential = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CredentialCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Credential

    /**
     * Retrieves vault credential metadata without returning secret values. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun retrieve(credentialId: String, params: CredentialRetrieveParams): Credential =
        retrieve(credentialId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        credentialId: String,
        params: CredentialRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Credential = retrieve(params.toBuilder().credentialId(credentialId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: CredentialRetrieveParams): Credential =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: CredentialRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Credential

    /**
     * Rotates a vault credential's write-only secret and returns only credential metadata. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun update(credentialId: String, params: CredentialUpdateParams): Credential =
        update(credentialId, params, RequestOptions.none())

    /** @see update */
    fun update(
        credentialId: String,
        params: CredentialUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Credential = update(params.toBuilder().credentialId(credentialId).build(), requestOptions)

    /** @see update */
    fun update(params: CredentialUpdateParams): Credential = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: CredentialUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Credential

    /**
     * Lists a vault's credentials using ID-based pagination without returning secret values. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun list(vaultId: String): CredentialListPage = list(vaultId, CredentialListParams.none())

    /** @see list */
    fun list(
        vaultId: String,
        params: CredentialListParams = CredentialListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CredentialListPage = list(params.toBuilder().vaultId(vaultId).build(), requestOptions)

    /** @see list */
    fun list(
        vaultId: String,
        params: CredentialListParams = CredentialListParams.none(),
    ): CredentialListPage = list(vaultId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: CredentialListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CredentialListPage

    /** @see list */
    fun list(params: CredentialListParams): CredentialListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(vaultId: String, requestOptions: RequestOptions): CredentialListPage =
        list(vaultId, CredentialListParams.none(), requestOptions)

    /**
     * Deletes a vault credential. See
     * [vaults](https://developers.openai.com/api/docs/guides/agents-api/tools/vaults).
     */
    fun delete(credentialId: String, params: CredentialDeleteParams): CredentialDeleted =
        delete(credentialId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        credentialId: String,
        params: CredentialDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CredentialDeleted =
        delete(params.toBuilder().credentialId(credentialId).build(), requestOptions)

    /** @see delete */
    fun delete(params: CredentialDeleteParams): CredentialDeleted =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: CredentialDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CredentialDeleted

    /** A view of [CredentialService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CredentialService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /vaults/{vault_id}/credentials`, but is otherwise
         * the same as [CredentialService.create].
         */
        @MustBeClosed
        fun create(vaultId: String, params: CredentialCreateParams): HttpResponseFor<Credential> =
            create(vaultId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            vaultId: String,
            params: CredentialCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Credential> =
            create(params.toBuilder().vaultId(vaultId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: CredentialCreateParams): HttpResponseFor<Credential> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: CredentialCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Credential>

        /**
         * Returns a raw HTTP response for `get /vaults/{vault_id}/credentials/{credential_id}`, but
         * is otherwise the same as [CredentialService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            credentialId: String,
            params: CredentialRetrieveParams,
        ): HttpResponseFor<Credential> = retrieve(credentialId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            credentialId: String,
            params: CredentialRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Credential> =
            retrieve(params.toBuilder().credentialId(credentialId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: CredentialRetrieveParams): HttpResponseFor<Credential> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: CredentialRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Credential>

        /**
         * Returns a raw HTTP response for `post /vaults/{vault_id}/credentials/{credential_id}`,
         * but is otherwise the same as [CredentialService.update].
         */
        @MustBeClosed
        fun update(
            credentialId: String,
            params: CredentialUpdateParams,
        ): HttpResponseFor<Credential> = update(credentialId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            credentialId: String,
            params: CredentialUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Credential> =
            update(params.toBuilder().credentialId(credentialId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: CredentialUpdateParams): HttpResponseFor<Credential> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: CredentialUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Credential>

        /**
         * Returns a raw HTTP response for `get /vaults/{vault_id}/credentials`, but is otherwise
         * the same as [CredentialService.list].
         */
        @MustBeClosed
        fun list(vaultId: String): HttpResponseFor<CredentialListPage> =
            list(vaultId, CredentialListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            vaultId: String,
            params: CredentialListParams = CredentialListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CredentialListPage> =
            list(params.toBuilder().vaultId(vaultId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            vaultId: String,
            params: CredentialListParams = CredentialListParams.none(),
        ): HttpResponseFor<CredentialListPage> = list(vaultId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: CredentialListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CredentialListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: CredentialListParams): HttpResponseFor<CredentialListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            vaultId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CredentialListPage> =
            list(vaultId, CredentialListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /vaults/{vault_id}/credentials/{credential_id}`,
         * but is otherwise the same as [CredentialService.delete].
         */
        @MustBeClosed
        fun delete(
            credentialId: String,
            params: CredentialDeleteParams,
        ): HttpResponseFor<CredentialDeleted> = delete(credentialId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            credentialId: String,
            params: CredentialDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CredentialDeleted> =
            delete(params.toBuilder().credentialId(credentialId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: CredentialDeleteParams): HttpResponseFor<CredentialDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: CredentialDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CredentialDeleted>
    }
}
