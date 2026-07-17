// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects.serviceaccounts

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.serviceaccounts.apikeys.ApiKeyCreateParams
import com.openai.models.admin.organization.projects.serviceaccounts.apikeys.ApiKeyCreateResponse
import java.util.function.Consumer

interface ApiKeyService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiKeyService

    /** Creates an API key for a service account in the project. */
    fun create(serviceAccountId: String, params: ApiKeyCreateParams): ApiKeyCreateResponse =
        create(serviceAccountId, params, RequestOptions.none())

    /** @see create */
    fun create(
        serviceAccountId: String,
        params: ApiKeyCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyCreateResponse =
        create(params.toBuilder().serviceAccountId(serviceAccountId).build(), requestOptions)

    /** @see create */
    fun create(params: ApiKeyCreateParams): ApiKeyCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ApiKeyCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyCreateResponse

    /** A view of [ApiKeyService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiKeyService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/service_accounts/{service_account_id}/api_keys`, but
         * is otherwise the same as [ApiKeyService.create].
         */
        @MustBeClosed
        fun create(
            serviceAccountId: String,
            params: ApiKeyCreateParams,
        ): HttpResponseFor<ApiKeyCreateResponse> =
            create(serviceAccountId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            serviceAccountId: String,
            params: ApiKeyCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyCreateResponse> =
            create(params.toBuilder().serviceAccountId(serviceAccountId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: ApiKeyCreateParams): HttpResponseFor<ApiKeyCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ApiKeyCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyCreateResponse>
    }
}
