// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.serviceaccounts.ProjectServiceAccount
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountCreateParams
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountCreateResponse
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountDeleteParams
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountDeleteResponse
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountListPage
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountListParams
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountRetrieveParams
import java.util.function.Consumer

interface ServiceAccountService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ServiceAccountService

    /**
     * Creates a new service account in the project. This also returns an unredacted API key for the
     * service account.
     */
    fun create(
        projectId: String,
        params: ServiceAccountCreateParams,
    ): ServiceAccountCreateResponse = create(projectId, params, RequestOptions.none())

    /** @see create */
    fun create(
        projectId: String,
        params: ServiceAccountCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ServiceAccountCreateResponse =
        create(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see create */
    fun create(params: ServiceAccountCreateParams): ServiceAccountCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ServiceAccountCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ServiceAccountCreateResponse

    /** Retrieves a service account in the project. */
    fun retrieve(
        serviceAccountId: String,
        params: ServiceAccountRetrieveParams,
    ): ProjectServiceAccount = retrieve(serviceAccountId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        serviceAccountId: String,
        params: ServiceAccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectServiceAccount =
        retrieve(params.toBuilder().serviceAccountId(serviceAccountId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: ServiceAccountRetrieveParams): ProjectServiceAccount =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ServiceAccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectServiceAccount

    /** Returns a list of service accounts in the project. */
    fun list(projectId: String): ServiceAccountListPage =
        list(projectId, ServiceAccountListParams.none())

    /** @see list */
    fun list(
        projectId: String,
        params: ServiceAccountListParams = ServiceAccountListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ServiceAccountListPage =
        list(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see list */
    fun list(
        projectId: String,
        params: ServiceAccountListParams = ServiceAccountListParams.none(),
    ): ServiceAccountListPage = list(projectId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ServiceAccountListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ServiceAccountListPage

    /** @see list */
    fun list(params: ServiceAccountListParams): ServiceAccountListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(projectId: String, requestOptions: RequestOptions): ServiceAccountListPage =
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
    ): ServiceAccountDeleteResponse = delete(serviceAccountId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        serviceAccountId: String,
        params: ServiceAccountDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ServiceAccountDeleteResponse =
        delete(params.toBuilder().serviceAccountId(serviceAccountId).build(), requestOptions)

    /** @see delete */
    fun delete(params: ServiceAccountDeleteParams): ServiceAccountDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ServiceAccountDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ServiceAccountDeleteResponse

    /**
     * A view of [ServiceAccountService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ServiceAccountService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/service_accounts`, but is otherwise the same as
         * [ServiceAccountService.create].
         */
        @MustBeClosed
        fun create(
            projectId: String,
            params: ServiceAccountCreateParams,
        ): HttpResponseFor<ServiceAccountCreateResponse> =
            create(projectId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            projectId: String,
            params: ServiceAccountCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ServiceAccountCreateResponse> =
            create(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(
            params: ServiceAccountCreateParams
        ): HttpResponseFor<ServiceAccountCreateResponse> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ServiceAccountCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ServiceAccountCreateResponse>

        /**
         * Returns a raw HTTP response for `get
         * /organization/projects/{project_id}/service_accounts/{service_account_id}`, but is
         * otherwise the same as [ServiceAccountService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            serviceAccountId: String,
            params: ServiceAccountRetrieveParams,
        ): HttpResponseFor<ProjectServiceAccount> =
            retrieve(serviceAccountId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            serviceAccountId: String,
            params: ServiceAccountRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectServiceAccount> =
            retrieve(params.toBuilder().serviceAccountId(serviceAccountId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ServiceAccountRetrieveParams): HttpResponseFor<ProjectServiceAccount> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ServiceAccountRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectServiceAccount>

        /**
         * Returns a raw HTTP response for `get
         * /organization/projects/{project_id}/service_accounts`, but is otherwise the same as
         * [ServiceAccountService.list].
         */
        @MustBeClosed
        fun list(projectId: String): HttpResponseFor<ServiceAccountListPage> =
            list(projectId, ServiceAccountListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            params: ServiceAccountListParams = ServiceAccountListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ServiceAccountListPage> =
            list(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            params: ServiceAccountListParams = ServiceAccountListParams.none(),
        ): HttpResponseFor<ServiceAccountListPage> = list(projectId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ServiceAccountListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ServiceAccountListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: ServiceAccountListParams): HttpResponseFor<ServiceAccountListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ServiceAccountListPage> =
            list(projectId, ServiceAccountListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /organization/projects/{project_id}/service_accounts/{service_account_id}`, but is
         * otherwise the same as [ServiceAccountService.delete].
         */
        @MustBeClosed
        fun delete(
            serviceAccountId: String,
            params: ServiceAccountDeleteParams,
        ): HttpResponseFor<ServiceAccountDeleteResponse> =
            delete(serviceAccountId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            serviceAccountId: String,
            params: ServiceAccountDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ServiceAccountDeleteResponse> =
            delete(params.toBuilder().serviceAccountId(serviceAccountId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ServiceAccountDeleteParams
        ): HttpResponseFor<ServiceAccountDeleteResponse> = delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ServiceAccountDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ServiceAccountDeleteResponse>
    }
}
