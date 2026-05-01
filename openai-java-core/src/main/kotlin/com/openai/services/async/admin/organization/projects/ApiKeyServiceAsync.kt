// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.apikeys.ApiKeyDeleteParams
import com.openai.models.admin.organization.projects.apikeys.ApiKeyDeleteResponse
import com.openai.models.admin.organization.projects.apikeys.ApiKeyListPageAsync
import com.openai.models.admin.organization.projects.apikeys.ApiKeyListParams
import com.openai.models.admin.organization.projects.apikeys.ApiKeyRetrieveParams
import com.openai.models.admin.organization.projects.apikeys.ProjectApiKey
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

    /** Retrieves an API key in the project. */
    fun retrieve(apiKeyId: String, params: ApiKeyRetrieveParams): CompletableFuture<ProjectApiKey> =
        retrieve(apiKeyId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        apiKeyId: String,
        params: ApiKeyRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectApiKey> =
        retrieve(params.toBuilder().apiKeyId(apiKeyId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: ApiKeyRetrieveParams): CompletableFuture<ProjectApiKey> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ApiKeyRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectApiKey>

    /** Returns a list of API keys in the project. */
    fun list(projectId: String): CompletableFuture<ApiKeyListPageAsync> =
        list(projectId, ApiKeyListParams.none())

    /** @see list */
    fun list(
        projectId: String,
        params: ApiKeyListParams = ApiKeyListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyListPageAsync> =
        list(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see list */
    fun list(
        projectId: String,
        params: ApiKeyListParams = ApiKeyListParams.none(),
    ): CompletableFuture<ApiKeyListPageAsync> = list(projectId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ApiKeyListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyListPageAsync>

    /** @see list */
    fun list(params: ApiKeyListParams): CompletableFuture<ApiKeyListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        projectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiKeyListPageAsync> =
        list(projectId, ApiKeyListParams.none(), requestOptions)

    /**
     * Deletes an API key from the project.
     *
     * Returns confirmation of the key deletion, or an error if the key belonged to a service
     * account.
     */
    fun delete(
        apiKeyId: String,
        params: ApiKeyDeleteParams,
    ): CompletableFuture<ApiKeyDeleteResponse> = delete(apiKeyId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        apiKeyId: String,
        params: ApiKeyDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyDeleteResponse> =
        delete(params.toBuilder().apiKeyId(apiKeyId).build(), requestOptions)

    /** @see delete */
    fun delete(params: ApiKeyDeleteParams): CompletableFuture<ApiKeyDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ApiKeyDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyDeleteResponse>

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
         * Returns a raw HTTP response for `get
         * /organization/projects/{project_id}/api_keys/{api_key_id}`, but is otherwise the same as
         * [ApiKeyServiceAsync.retrieve].
         */
        fun retrieve(
            apiKeyId: String,
            params: ApiKeyRetrieveParams,
        ): CompletableFuture<HttpResponseFor<ProjectApiKey>> =
            retrieve(apiKeyId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            apiKeyId: String,
            params: ApiKeyRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectApiKey>> =
            retrieve(params.toBuilder().apiKeyId(apiKeyId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: ApiKeyRetrieveParams
        ): CompletableFuture<HttpResponseFor<ProjectApiKey>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ApiKeyRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectApiKey>>

        /**
         * Returns a raw HTTP response for `get /organization/projects/{project_id}/api_keys`, but
         * is otherwise the same as [ApiKeyServiceAsync.list].
         */
        fun list(projectId: String): CompletableFuture<HttpResponseFor<ApiKeyListPageAsync>> =
            list(projectId, ApiKeyListParams.none())

        /** @see list */
        fun list(
            projectId: String,
            params: ApiKeyListParams = ApiKeyListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyListPageAsync>> =
            list(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see list */
        fun list(
            projectId: String,
            params: ApiKeyListParams = ApiKeyListParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyListPageAsync>> =
            list(projectId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: ApiKeyListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyListPageAsync>>

        /** @see list */
        fun list(
            params: ApiKeyListParams
        ): CompletableFuture<HttpResponseFor<ApiKeyListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiKeyListPageAsync>> =
            list(projectId, ApiKeyListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /organization/projects/{project_id}/api_keys/{api_key_id}`, but is otherwise the same as
         * [ApiKeyServiceAsync.delete].
         */
        fun delete(
            apiKeyId: String,
            params: ApiKeyDeleteParams,
        ): CompletableFuture<HttpResponseFor<ApiKeyDeleteResponse>> =
            delete(apiKeyId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            apiKeyId: String,
            params: ApiKeyDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyDeleteResponse>> =
            delete(params.toBuilder().apiKeyId(apiKeyId).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: ApiKeyDeleteParams
        ): CompletableFuture<HttpResponseFor<ApiKeyDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: ApiKeyDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyDeleteResponse>>
    }
}
