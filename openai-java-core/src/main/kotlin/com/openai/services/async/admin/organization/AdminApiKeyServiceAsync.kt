// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.adminapikeys.AdminApiKey
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyCreateParams
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyDeleteParams
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyDeleteResponse
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyListPageAsync
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyListParams
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface AdminApiKeyServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AdminApiKeyServiceAsync

    /** Create an organization admin API key */
    fun create(params: AdminApiKeyCreateParams): CompletableFuture<AdminApiKey> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: AdminApiKeyCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AdminApiKey>

    /** Retrieve a single organization API key */
    fun retrieve(keyId: String): CompletableFuture<AdminApiKey> =
        retrieve(keyId, AdminApiKeyRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        keyId: String,
        params: AdminApiKeyRetrieveParams = AdminApiKeyRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AdminApiKey> =
        retrieve(params.toBuilder().keyId(keyId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        keyId: String,
        params: AdminApiKeyRetrieveParams = AdminApiKeyRetrieveParams.none(),
    ): CompletableFuture<AdminApiKey> = retrieve(keyId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AdminApiKeyRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AdminApiKey>

    /** @see retrieve */
    fun retrieve(params: AdminApiKeyRetrieveParams): CompletableFuture<AdminApiKey> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(keyId: String, requestOptions: RequestOptions): CompletableFuture<AdminApiKey> =
        retrieve(keyId, AdminApiKeyRetrieveParams.none(), requestOptions)

    /** List organization API keys */
    fun list(): CompletableFuture<AdminApiKeyListPageAsync> = list(AdminApiKeyListParams.none())

    /** @see list */
    fun list(
        params: AdminApiKeyListParams = AdminApiKeyListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AdminApiKeyListPageAsync>

    /** @see list */
    fun list(
        params: AdminApiKeyListParams = AdminApiKeyListParams.none()
    ): CompletableFuture<AdminApiKeyListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<AdminApiKeyListPageAsync> =
        list(AdminApiKeyListParams.none(), requestOptions)

    /** Delete an organization admin API key */
    fun delete(keyId: String): CompletableFuture<AdminApiKeyDeleteResponse> =
        delete(keyId, AdminApiKeyDeleteParams.none())

    /** @see delete */
    fun delete(
        keyId: String,
        params: AdminApiKeyDeleteParams = AdminApiKeyDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AdminApiKeyDeleteResponse> =
        delete(params.toBuilder().keyId(keyId).build(), requestOptions)

    /** @see delete */
    fun delete(
        keyId: String,
        params: AdminApiKeyDeleteParams = AdminApiKeyDeleteParams.none(),
    ): CompletableFuture<AdminApiKeyDeleteResponse> = delete(keyId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: AdminApiKeyDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AdminApiKeyDeleteResponse>

    /** @see delete */
    fun delete(params: AdminApiKeyDeleteParams): CompletableFuture<AdminApiKeyDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        keyId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<AdminApiKeyDeleteResponse> =
        delete(keyId, AdminApiKeyDeleteParams.none(), requestOptions)

    /**
     * A view of [AdminApiKeyServiceAsync] that provides access to raw HTTP responses for each
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
        ): AdminApiKeyServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/admin_api_keys`, but is otherwise the
         * same as [AdminApiKeyServiceAsync.create].
         */
        fun create(
            params: AdminApiKeyCreateParams
        ): CompletableFuture<HttpResponseFor<AdminApiKey>> = create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: AdminApiKeyCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AdminApiKey>>

        /**
         * Returns a raw HTTP response for `get /organization/admin_api_keys/{key_id}`, but is
         * otherwise the same as [AdminApiKeyServiceAsync.retrieve].
         */
        fun retrieve(keyId: String): CompletableFuture<HttpResponseFor<AdminApiKey>> =
            retrieve(keyId, AdminApiKeyRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            keyId: String,
            params: AdminApiKeyRetrieveParams = AdminApiKeyRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AdminApiKey>> =
            retrieve(params.toBuilder().keyId(keyId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            keyId: String,
            params: AdminApiKeyRetrieveParams = AdminApiKeyRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<AdminApiKey>> =
            retrieve(keyId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: AdminApiKeyRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AdminApiKey>>

        /** @see retrieve */
        fun retrieve(
            params: AdminApiKeyRetrieveParams
        ): CompletableFuture<HttpResponseFor<AdminApiKey>> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            keyId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AdminApiKey>> =
            retrieve(keyId, AdminApiKeyRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /organization/admin_api_keys`, but is otherwise the
         * same as [AdminApiKeyServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<AdminApiKeyListPageAsync>> =
            list(AdminApiKeyListParams.none())

        /** @see list */
        fun list(
            params: AdminApiKeyListParams = AdminApiKeyListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AdminApiKeyListPageAsync>>

        /** @see list */
        fun list(
            params: AdminApiKeyListParams = AdminApiKeyListParams.none()
        ): CompletableFuture<HttpResponseFor<AdminApiKeyListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AdminApiKeyListPageAsync>> =
            list(AdminApiKeyListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/admin_api_keys/{key_id}`, but is
         * otherwise the same as [AdminApiKeyServiceAsync.delete].
         */
        fun delete(keyId: String): CompletableFuture<HttpResponseFor<AdminApiKeyDeleteResponse>> =
            delete(keyId, AdminApiKeyDeleteParams.none())

        /** @see delete */
        fun delete(
            keyId: String,
            params: AdminApiKeyDeleteParams = AdminApiKeyDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AdminApiKeyDeleteResponse>> =
            delete(params.toBuilder().keyId(keyId).build(), requestOptions)

        /** @see delete */
        fun delete(
            keyId: String,
            params: AdminApiKeyDeleteParams = AdminApiKeyDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<AdminApiKeyDeleteResponse>> =
            delete(keyId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: AdminApiKeyDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AdminApiKeyDeleteResponse>>

        /** @see delete */
        fun delete(
            params: AdminApiKeyDeleteParams
        ): CompletableFuture<HttpResponseFor<AdminApiKeyDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            keyId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AdminApiKeyDeleteResponse>> =
            delete(keyId, AdminApiKeyDeleteParams.none(), requestOptions)
    }
}
