// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.serviceaccounts.ProjectServiceAccount
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountCreateParams
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountCreateResponse
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountDeleteParams
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountDeleteResponse
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountListPageAsync
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountListParams
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ServiceAccountServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ServiceAccountServiceAsync

    /**
     * Creates a new service account in the project. This also returns an unredacted API key for the
     * service account.
     */
    fun create(
        projectId: String,
        params: ServiceAccountCreateParams,
    ): CompletableFuture<ServiceAccountCreateResponse> =
        create(projectId, params, RequestOptions.none())

    /** @see create */
    fun create(
        projectId: String,
        params: ServiceAccountCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ServiceAccountCreateResponse> =
        create(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see create */
    fun create(
        params: ServiceAccountCreateParams
    ): CompletableFuture<ServiceAccountCreateResponse> = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ServiceAccountCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ServiceAccountCreateResponse>

    /** Retrieves a service account in the project. */
    fun retrieve(
        serviceAccountId: String,
        params: ServiceAccountRetrieveParams,
    ): CompletableFuture<ProjectServiceAccount> =
        retrieve(serviceAccountId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        serviceAccountId: String,
        params: ServiceAccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectServiceAccount> =
        retrieve(params.toBuilder().serviceAccountId(serviceAccountId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: ServiceAccountRetrieveParams): CompletableFuture<ProjectServiceAccount> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ServiceAccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectServiceAccount>

    /** Returns a list of service accounts in the project. */
    fun list(projectId: String): CompletableFuture<ServiceAccountListPageAsync> =
        list(projectId, ServiceAccountListParams.none())

    /** @see list */
    fun list(
        projectId: String,
        params: ServiceAccountListParams = ServiceAccountListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ServiceAccountListPageAsync> =
        list(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see list */
    fun list(
        projectId: String,
        params: ServiceAccountListParams = ServiceAccountListParams.none(),
    ): CompletableFuture<ServiceAccountListPageAsync> =
        list(projectId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ServiceAccountListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ServiceAccountListPageAsync>

    /** @see list */
    fun list(params: ServiceAccountListParams): CompletableFuture<ServiceAccountListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        projectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ServiceAccountListPageAsync> =
        list(projectId, ServiceAccountListParams.none(), requestOptions)

    /**
     * Deletes a service account from the project.
     *
     * Returns confirmation of service account deletion, or an error if the project is archived
     * (archived projects have no service accounts).
     */
    fun delete(
        serviceAccountId: String,
        params: ServiceAccountDeleteParams,
    ): CompletableFuture<ServiceAccountDeleteResponse> =
        delete(serviceAccountId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        serviceAccountId: String,
        params: ServiceAccountDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ServiceAccountDeleteResponse> =
        delete(params.toBuilder().serviceAccountId(serviceAccountId).build(), requestOptions)

    /** @see delete */
    fun delete(
        params: ServiceAccountDeleteParams
    ): CompletableFuture<ServiceAccountDeleteResponse> = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ServiceAccountDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ServiceAccountDeleteResponse>

    /**
     * A view of [ServiceAccountServiceAsync] that provides access to raw HTTP responses for each
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
        ): ServiceAccountServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/service_accounts`, but is otherwise the same as
         * [ServiceAccountServiceAsync.create].
         */
        fun create(
            projectId: String,
            params: ServiceAccountCreateParams,
        ): CompletableFuture<HttpResponseFor<ServiceAccountCreateResponse>> =
            create(projectId, params, RequestOptions.none())

        /** @see create */
        fun create(
            projectId: String,
            params: ServiceAccountCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ServiceAccountCreateResponse>> =
            create(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see create */
        fun create(
            params: ServiceAccountCreateParams
        ): CompletableFuture<HttpResponseFor<ServiceAccountCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: ServiceAccountCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ServiceAccountCreateResponse>>

        /**
         * Returns a raw HTTP response for `get
         * /organization/projects/{project_id}/service_accounts/{service_account_id}`, but is
         * otherwise the same as [ServiceAccountServiceAsync.retrieve].
         */
        fun retrieve(
            serviceAccountId: String,
            params: ServiceAccountRetrieveParams,
        ): CompletableFuture<HttpResponseFor<ProjectServiceAccount>> =
            retrieve(serviceAccountId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            serviceAccountId: String,
            params: ServiceAccountRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectServiceAccount>> =
            retrieve(params.toBuilder().serviceAccountId(serviceAccountId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: ServiceAccountRetrieveParams
        ): CompletableFuture<HttpResponseFor<ProjectServiceAccount>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ServiceAccountRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectServiceAccount>>

        /**
         * Returns a raw HTTP response for `get
         * /organization/projects/{project_id}/service_accounts`, but is otherwise the same as
         * [ServiceAccountServiceAsync.list].
         */
        fun list(
            projectId: String
        ): CompletableFuture<HttpResponseFor<ServiceAccountListPageAsync>> =
            list(projectId, ServiceAccountListParams.none())

        /** @see list */
        fun list(
            projectId: String,
            params: ServiceAccountListParams = ServiceAccountListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ServiceAccountListPageAsync>> =
            list(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see list */
        fun list(
            projectId: String,
            params: ServiceAccountListParams = ServiceAccountListParams.none(),
        ): CompletableFuture<HttpResponseFor<ServiceAccountListPageAsync>> =
            list(projectId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: ServiceAccountListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ServiceAccountListPageAsync>>

        /** @see list */
        fun list(
            params: ServiceAccountListParams
        ): CompletableFuture<HttpResponseFor<ServiceAccountListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ServiceAccountListPageAsync>> =
            list(projectId, ServiceAccountListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /organization/projects/{project_id}/service_accounts/{service_account_id}`, but is
         * otherwise the same as [ServiceAccountServiceAsync.delete].
         */
        fun delete(
            serviceAccountId: String,
            params: ServiceAccountDeleteParams,
        ): CompletableFuture<HttpResponseFor<ServiceAccountDeleteResponse>> =
            delete(serviceAccountId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            serviceAccountId: String,
            params: ServiceAccountDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ServiceAccountDeleteResponse>> =
            delete(params.toBuilder().serviceAccountId(serviceAccountId).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: ServiceAccountDeleteParams
        ): CompletableFuture<HttpResponseFor<ServiceAccountDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: ServiceAccountDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ServiceAccountDeleteResponse>>
    }
}
