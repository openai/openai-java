// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.admin.organization.projects

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.apikeys.ApiKeyDeleteParams
import com.openai.models.admin.organization.projects.apikeys.ApiKeyDeleteResponse
import com.openai.models.admin.organization.projects.apikeys.ApiKeyListPage
import com.openai.models.admin.organization.projects.apikeys.ApiKeyListParams
import com.openai.models.admin.organization.projects.apikeys.ApiKeyRetrieveParams
import com.openai.models.admin.organization.projects.apikeys.ApiKeyUpdateParams
import com.openai.models.admin.organization.projects.apikeys.ProjectApiKey
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

    /** Retrieves an API key in the project. */
    fun retrieve(apiKeyId: String, params: ApiKeyRetrieveParams): ProjectApiKey =
        retrieve(apiKeyId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        apiKeyId: String,
        params: ApiKeyRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectApiKey = retrieve(params.toBuilder().apiKeyId(apiKeyId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: ApiKeyRetrieveParams): ProjectApiKey =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ApiKeyRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectApiKey

    /**
     * Updates the expiration of an existing API key in the project, including a
     * service-account-owned key. Requires permission to write project API keys.
     *
     * Provide `expires_in_seconds` to set the expiration relative to this request. The value must
     * satisfy the organization's and project's expiry policies. Expired keys cannot be updated.
     * Retrying resets the expiration relative to the new request. The response contains only the
     * redacted key, not its secret.
     */
    fun update(apiKeyId: String, params: ApiKeyUpdateParams): ProjectApiKey =
        update(apiKeyId, params, RequestOptions.none())

    /** @see update */
    fun update(
        apiKeyId: String,
        params: ApiKeyUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectApiKey = update(params.toBuilder().apiKeyId(apiKeyId).build(), requestOptions)

    /** @see update */
    fun update(params: ApiKeyUpdateParams): ProjectApiKey = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ApiKeyUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectApiKey

    /** Returns a list of API keys in the project. */
    fun list(projectId: String): ApiKeyListPage = list(projectId, ApiKeyListParams.none())

    /** @see list */
    fun list(
        projectId: String,
        params: ApiKeyListParams = ApiKeyListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyListPage = list(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see list */
    fun list(
        projectId: String,
        params: ApiKeyListParams = ApiKeyListParams.none(),
    ): ApiKeyListPage = list(projectId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ApiKeyListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyListPage

    /** @see list */
    fun list(params: ApiKeyListParams): ApiKeyListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(projectId: String, requestOptions: RequestOptions): ApiKeyListPage =
        list(projectId, ApiKeyListParams.none(), requestOptions)

    /**
     * Deletes an API key from the project.
     *
     * Returns confirmation of the key deletion, or an error if the key belonged to a service
     * account.
     */
    fun delete(apiKeyId: String, params: ApiKeyDeleteParams): ApiKeyDeleteResponse =
        delete(apiKeyId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        apiKeyId: String,
        params: ApiKeyDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyDeleteResponse = delete(params.toBuilder().apiKeyId(apiKeyId).build(), requestOptions)

    /** @see delete */
    fun delete(params: ApiKeyDeleteParams): ApiKeyDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ApiKeyDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyDeleteResponse

    /** A view of [ApiKeyService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiKeyService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /organization/projects/{project_id}/api_keys/{api_key_id}`, but is otherwise the same as
         * [ApiKeyService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            apiKeyId: String,
            params: ApiKeyRetrieveParams,
        ): HttpResponseFor<ProjectApiKey> = retrieve(apiKeyId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            apiKeyId: String,
            params: ApiKeyRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectApiKey> =
            retrieve(params.toBuilder().apiKeyId(apiKeyId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ApiKeyRetrieveParams): HttpResponseFor<ProjectApiKey> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ApiKeyRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectApiKey>

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/api_keys/{api_key_id}`, but is otherwise the same as
         * [ApiKeyService.update].
         */
        @MustBeClosed
        fun update(apiKeyId: String, params: ApiKeyUpdateParams): HttpResponseFor<ProjectApiKey> =
            update(apiKeyId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            apiKeyId: String,
            params: ApiKeyUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectApiKey> =
            update(params.toBuilder().apiKeyId(apiKeyId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: ApiKeyUpdateParams): HttpResponseFor<ProjectApiKey> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: ApiKeyUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectApiKey>

        /**
         * Returns a raw HTTP response for `get /organization/projects/{project_id}/api_keys`, but
         * is otherwise the same as [ApiKeyService.list].
         */
        @MustBeClosed
        fun list(projectId: String): HttpResponseFor<ApiKeyListPage> =
            list(projectId, ApiKeyListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            params: ApiKeyListParams = ApiKeyListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyListPage> =
            list(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            params: ApiKeyListParams = ApiKeyListParams.none(),
        ): HttpResponseFor<ApiKeyListPage> = list(projectId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ApiKeyListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: ApiKeyListParams): HttpResponseFor<ApiKeyListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiKeyListPage> =
            list(projectId, ApiKeyListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /organization/projects/{project_id}/api_keys/{api_key_id}`, but is otherwise the same as
         * [ApiKeyService.delete].
         */
        @MustBeClosed
        fun delete(
            apiKeyId: String,
            params: ApiKeyDeleteParams,
        ): HttpResponseFor<ApiKeyDeleteResponse> = delete(apiKeyId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            apiKeyId: String,
            params: ApiKeyDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyDeleteResponse> =
            delete(params.toBuilder().apiKeyId(apiKeyId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: ApiKeyDeleteParams): HttpResponseFor<ApiKeyDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ApiKeyDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyDeleteResponse>
    }
}
