// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.adminapikeys.AdminApiKey
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyCreateParams
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyCreateResponse
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyDeleteParams
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyDeleteResponse
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyListPage
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyListParams
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyRetrieveParams
import java.util.function.Consumer

interface AdminApiKeyService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AdminApiKeyService

    /** Create an organization admin API key */
    fun create(params: AdminApiKeyCreateParams): AdminApiKeyCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: AdminApiKeyCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AdminApiKeyCreateResponse

    /** Retrieve a single organization API key */
    fun retrieve(keyId: String): AdminApiKey = retrieve(keyId, AdminApiKeyRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        keyId: String,
        params: AdminApiKeyRetrieveParams = AdminApiKeyRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AdminApiKey = retrieve(params.toBuilder().keyId(keyId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        keyId: String,
        params: AdminApiKeyRetrieveParams = AdminApiKeyRetrieveParams.none(),
    ): AdminApiKey = retrieve(keyId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AdminApiKeyRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AdminApiKey

    /** @see retrieve */
    fun retrieve(params: AdminApiKeyRetrieveParams): AdminApiKey =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(keyId: String, requestOptions: RequestOptions): AdminApiKey =
        retrieve(keyId, AdminApiKeyRetrieveParams.none(), requestOptions)

    /** List organization API keys */
    fun list(): AdminApiKeyListPage = list(AdminApiKeyListParams.none())

    /** @see list */
    fun list(
        params: AdminApiKeyListParams = AdminApiKeyListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AdminApiKeyListPage

    /** @see list */
    fun list(params: AdminApiKeyListParams = AdminApiKeyListParams.none()): AdminApiKeyListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): AdminApiKeyListPage =
        list(AdminApiKeyListParams.none(), requestOptions)

    /** Delete an organization admin API key */
    fun delete(keyId: String): AdminApiKeyDeleteResponse =
        delete(keyId, AdminApiKeyDeleteParams.none())

    /** @see delete */
    fun delete(
        keyId: String,
        params: AdminApiKeyDeleteParams = AdminApiKeyDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AdminApiKeyDeleteResponse = delete(params.toBuilder().keyId(keyId).build(), requestOptions)

    /** @see delete */
    fun delete(
        keyId: String,
        params: AdminApiKeyDeleteParams = AdminApiKeyDeleteParams.none(),
    ): AdminApiKeyDeleteResponse = delete(keyId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: AdminApiKeyDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AdminApiKeyDeleteResponse

    /** @see delete */
    fun delete(params: AdminApiKeyDeleteParams): AdminApiKeyDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(keyId: String, requestOptions: RequestOptions): AdminApiKeyDeleteResponse =
        delete(keyId, AdminApiKeyDeleteParams.none(), requestOptions)

    /**
     * A view of [AdminApiKeyService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AdminApiKeyService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/admin_api_keys`, but is otherwise the
         * same as [AdminApiKeyService.create].
         */
        @MustBeClosed
        fun create(params: AdminApiKeyCreateParams): HttpResponseFor<AdminApiKeyCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: AdminApiKeyCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AdminApiKeyCreateResponse>

        /**
         * Returns a raw HTTP response for `get /organization/admin_api_keys/{key_id}`, but is
         * otherwise the same as [AdminApiKeyService.retrieve].
         */
        @MustBeClosed
        fun retrieve(keyId: String): HttpResponseFor<AdminApiKey> =
            retrieve(keyId, AdminApiKeyRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            keyId: String,
            params: AdminApiKeyRetrieveParams = AdminApiKeyRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AdminApiKey> =
            retrieve(params.toBuilder().keyId(keyId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            keyId: String,
            params: AdminApiKeyRetrieveParams = AdminApiKeyRetrieveParams.none(),
        ): HttpResponseFor<AdminApiKey> = retrieve(keyId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: AdminApiKeyRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AdminApiKey>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: AdminApiKeyRetrieveParams): HttpResponseFor<AdminApiKey> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(keyId: String, requestOptions: RequestOptions): HttpResponseFor<AdminApiKey> =
            retrieve(keyId, AdminApiKeyRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /organization/admin_api_keys`, but is otherwise the
         * same as [AdminApiKeyService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<AdminApiKeyListPage> = list(AdminApiKeyListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: AdminApiKeyListParams = AdminApiKeyListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AdminApiKeyListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: AdminApiKeyListParams = AdminApiKeyListParams.none()
        ): HttpResponseFor<AdminApiKeyListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<AdminApiKeyListPage> =
            list(AdminApiKeyListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/admin_api_keys/{key_id}`, but is
         * otherwise the same as [AdminApiKeyService.delete].
         */
        @MustBeClosed
        fun delete(keyId: String): HttpResponseFor<AdminApiKeyDeleteResponse> =
            delete(keyId, AdminApiKeyDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            keyId: String,
            params: AdminApiKeyDeleteParams = AdminApiKeyDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AdminApiKeyDeleteResponse> =
            delete(params.toBuilder().keyId(keyId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            keyId: String,
            params: AdminApiKeyDeleteParams = AdminApiKeyDeleteParams.none(),
        ): HttpResponseFor<AdminApiKeyDeleteResponse> = delete(keyId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: AdminApiKeyDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AdminApiKeyDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(params: AdminApiKeyDeleteParams): HttpResponseFor<AdminApiKeyDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            keyId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AdminApiKeyDeleteResponse> =
            delete(keyId, AdminApiKeyDeleteParams.none(), requestOptions)
    }
}
