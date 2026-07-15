// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects.serviceaccounts

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.serviceaccounts.apikeys.ApiKeyCreateParams
import com.openai.models.admin.organization.projects.serviceaccounts.apikeys.ApiKeyCreateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ApiKeyServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiKeyServiceAsync

    /** Creates an API key for a service account in the project. */
    fun create(
        serviceAccountId: String,
        params: ApiKeyCreateParams,
    ): CompletableFuture<ApiKeyCreateResponse> =
        create(serviceAccountId, params, RequestOptions.none())

    /** @see create */
    fun create(
        serviceAccountId: String,
        params: ApiKeyCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyCreateResponse> =
        create(params.toBuilder().serviceAccountId(serviceAccountId).build(), requestOptions)

    /** @see create */
    fun create(params: ApiKeyCreateParams): CompletableFuture<ApiKeyCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ApiKeyCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyCreateResponse>

    /**
     * A view of [ApiKeyServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ApiKeyServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/service_accounts/{service_account_id}/api_keys`, but
         * is otherwise the same as [ApiKeyServiceAsync.create].
         */
        fun create(
            serviceAccountId: String,
            params: ApiKeyCreateParams,
        ): CompletableFuture<HttpResponseFor<ApiKeyCreateResponse>> =
            create(serviceAccountId, params, RequestOptions.none())

        /** @see create */
        fun create(
            serviceAccountId: String,
            params: ApiKeyCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyCreateResponse>> =
            create(params.toBuilder().serviceAccountId(serviceAccountId).build(), requestOptions)

        /** @see create */
        fun create(
            params: ApiKeyCreateParams
        ): CompletableFuture<HttpResponseFor<ApiKeyCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: ApiKeyCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyCreateResponse>>
    }
}
