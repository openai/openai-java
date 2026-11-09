// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.admin.organization

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProvider
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderCreateParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderDeleteParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderDeleted
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderListPage
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderListParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderRetrieveParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderUpdateParams
import com.openai.services.blocking.admin.organization.workloadidentityproviders.FederationRuleService
import java.util.function.Consumer

interface WorkloadIdentityProviderService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WorkloadIdentityProviderService

    fun federationRules(): FederationRuleService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Register an OIDC provider for keyless project service-account authentication. */
    fun create(params: WorkloadIdentityProviderCreateParams): WorkloadIdentityProvider =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: WorkloadIdentityProviderCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WorkloadIdentityProvider

    /** Retrieve an OIDC provider in the authenticated organization. */
    fun retrieve(workloadIdentityProviderId: String): WorkloadIdentityProvider =
        retrieve(workloadIdentityProviderId, WorkloadIdentityProviderRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        workloadIdentityProviderId: String,
        params: WorkloadIdentityProviderRetrieveParams =
            WorkloadIdentityProviderRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WorkloadIdentityProvider =
        retrieve(
            params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
            requestOptions,
        )

    /** @see retrieve */
    fun retrieve(
        workloadIdentityProviderId: String,
        params: WorkloadIdentityProviderRetrieveParams =
            WorkloadIdentityProviderRetrieveParams.none(),
    ): WorkloadIdentityProvider =
        retrieve(workloadIdentityProviderId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: WorkloadIdentityProviderRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WorkloadIdentityProvider

    /** @see retrieve */
    fun retrieve(params: WorkloadIdentityProviderRetrieveParams): WorkloadIdentityProvider =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        workloadIdentityProviderId: String,
        requestOptions: RequestOptions,
    ): WorkloadIdentityProvider =
        retrieve(
            workloadIdentityProviderId,
            WorkloadIdentityProviderRetrieveParams.none(),
            requestOptions,
        )

    /** Update supplied provider fields, preserving omitted fields. */
    fun update(workloadIdentityProviderId: String): WorkloadIdentityProvider =
        update(workloadIdentityProviderId, WorkloadIdentityProviderUpdateParams.none())

    /** @see update */
    fun update(
        workloadIdentityProviderId: String,
        params: WorkloadIdentityProviderUpdateParams = WorkloadIdentityProviderUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WorkloadIdentityProvider =
        update(
            params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
            requestOptions,
        )

    /** @see update */
    fun update(
        workloadIdentityProviderId: String,
        params: WorkloadIdentityProviderUpdateParams = WorkloadIdentityProviderUpdateParams.none(),
    ): WorkloadIdentityProvider = update(workloadIdentityProviderId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: WorkloadIdentityProviderUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WorkloadIdentityProvider

    /** @see update */
    fun update(params: WorkloadIdentityProviderUpdateParams): WorkloadIdentityProvider =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        workloadIdentityProviderId: String,
        requestOptions: RequestOptions,
    ): WorkloadIdentityProvider =
        update(
            workloadIdentityProviderId,
            WorkloadIdentityProviderUpdateParams.none(),
            requestOptions,
        )

    /** List OIDC providers in the authenticated Admin API key's organization. */
    fun list(): WorkloadIdentityProviderListPage = list(WorkloadIdentityProviderListParams.none())

    /** @see list */
    fun list(
        params: WorkloadIdentityProviderListParams = WorkloadIdentityProviderListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WorkloadIdentityProviderListPage

    /** @see list */
    fun list(
        params: WorkloadIdentityProviderListParams = WorkloadIdentityProviderListParams.none()
    ): WorkloadIdentityProviderListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): WorkloadIdentityProviderListPage =
        list(WorkloadIdentityProviderListParams.none(), requestOptions)

    /** Delete a provider after deleting all its federation rules. */
    fun delete(workloadIdentityProviderId: String): WorkloadIdentityProviderDeleted =
        delete(workloadIdentityProviderId, WorkloadIdentityProviderDeleteParams.none())

    /** @see delete */
    fun delete(
        workloadIdentityProviderId: String,
        params: WorkloadIdentityProviderDeleteParams = WorkloadIdentityProviderDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WorkloadIdentityProviderDeleted =
        delete(
            params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
            requestOptions,
        )

    /** @see delete */
    fun delete(
        workloadIdentityProviderId: String,
        params: WorkloadIdentityProviderDeleteParams = WorkloadIdentityProviderDeleteParams.none(),
    ): WorkloadIdentityProviderDeleted =
        delete(workloadIdentityProviderId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: WorkloadIdentityProviderDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WorkloadIdentityProviderDeleted

    /** @see delete */
    fun delete(params: WorkloadIdentityProviderDeleteParams): WorkloadIdentityProviderDeleted =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        workloadIdentityProviderId: String,
        requestOptions: RequestOptions,
    ): WorkloadIdentityProviderDeleted =
        delete(
            workloadIdentityProviderId,
            WorkloadIdentityProviderDeleteParams.none(),
            requestOptions,
        )

    /**
     * A view of [WorkloadIdentityProviderService] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WorkloadIdentityProviderService.WithRawResponse

        fun federationRules(): FederationRuleService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /**
         * Returns a raw HTTP response for `post /organization/workload_identity_providers`, but is
         * otherwise the same as [WorkloadIdentityProviderService.create].
         */
        @MustBeClosed
        fun create(
            params: WorkloadIdentityProviderCreateParams
        ): HttpResponseFor<WorkloadIdentityProvider> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: WorkloadIdentityProviderCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WorkloadIdentityProvider>

        /**
         * Returns a raw HTTP response for `get
         * /organization/workload_identity_providers/{workload_identity_provider_id}`, but is
         * otherwise the same as [WorkloadIdentityProviderService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            workloadIdentityProviderId: String
        ): HttpResponseFor<WorkloadIdentityProvider> =
            retrieve(workloadIdentityProviderId, WorkloadIdentityProviderRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            workloadIdentityProviderId: String,
            params: WorkloadIdentityProviderRetrieveParams =
                WorkloadIdentityProviderRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WorkloadIdentityProvider> =
            retrieve(
                params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
                requestOptions,
            )

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            workloadIdentityProviderId: String,
            params: WorkloadIdentityProviderRetrieveParams =
                WorkloadIdentityProviderRetrieveParams.none(),
        ): HttpResponseFor<WorkloadIdentityProvider> =
            retrieve(workloadIdentityProviderId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: WorkloadIdentityProviderRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WorkloadIdentityProvider>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: WorkloadIdentityProviderRetrieveParams
        ): HttpResponseFor<WorkloadIdentityProvider> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            workloadIdentityProviderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WorkloadIdentityProvider> =
            retrieve(
                workloadIdentityProviderId,
                WorkloadIdentityProviderRetrieveParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `post
         * /organization/workload_identity_providers/{workload_identity_provider_id}`, but is
         * otherwise the same as [WorkloadIdentityProviderService.update].
         */
        @MustBeClosed
        fun update(workloadIdentityProviderId: String): HttpResponseFor<WorkloadIdentityProvider> =
            update(workloadIdentityProviderId, WorkloadIdentityProviderUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            workloadIdentityProviderId: String,
            params: WorkloadIdentityProviderUpdateParams =
                WorkloadIdentityProviderUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WorkloadIdentityProvider> =
            update(
                params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
                requestOptions,
            )

        /** @see update */
        @MustBeClosed
        fun update(
            workloadIdentityProviderId: String,
            params: WorkloadIdentityProviderUpdateParams =
                WorkloadIdentityProviderUpdateParams.none(),
        ): HttpResponseFor<WorkloadIdentityProvider> =
            update(workloadIdentityProviderId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: WorkloadIdentityProviderUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WorkloadIdentityProvider>

        /** @see update */
        @MustBeClosed
        fun update(
            params: WorkloadIdentityProviderUpdateParams
        ): HttpResponseFor<WorkloadIdentityProvider> = update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            workloadIdentityProviderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WorkloadIdentityProvider> =
            update(
                workloadIdentityProviderId,
                WorkloadIdentityProviderUpdateParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `get /organization/workload_identity_providers`, but is
         * otherwise the same as [WorkloadIdentityProviderService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<WorkloadIdentityProviderListPage> =
            list(WorkloadIdentityProviderListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: WorkloadIdentityProviderListParams = WorkloadIdentityProviderListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WorkloadIdentityProviderListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: WorkloadIdentityProviderListParams = WorkloadIdentityProviderListParams.none()
        ): HttpResponseFor<WorkloadIdentityProviderListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): HttpResponseFor<WorkloadIdentityProviderListPage> =
            list(WorkloadIdentityProviderListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /organization/workload_identity_providers/{workload_identity_provider_id}`, but is
         * otherwise the same as [WorkloadIdentityProviderService.delete].
         */
        @MustBeClosed
        fun delete(
            workloadIdentityProviderId: String
        ): HttpResponseFor<WorkloadIdentityProviderDeleted> =
            delete(workloadIdentityProviderId, WorkloadIdentityProviderDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            workloadIdentityProviderId: String,
            params: WorkloadIdentityProviderDeleteParams =
                WorkloadIdentityProviderDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WorkloadIdentityProviderDeleted> =
            delete(
                params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
                requestOptions,
            )

        /** @see delete */
        @MustBeClosed
        fun delete(
            workloadIdentityProviderId: String,
            params: WorkloadIdentityProviderDeleteParams =
                WorkloadIdentityProviderDeleteParams.none(),
        ): HttpResponseFor<WorkloadIdentityProviderDeleted> =
            delete(workloadIdentityProviderId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: WorkloadIdentityProviderDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WorkloadIdentityProviderDeleted>

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: WorkloadIdentityProviderDeleteParams
        ): HttpResponseFor<WorkloadIdentityProviderDeleted> = delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            workloadIdentityProviderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WorkloadIdentityProviderDeleted> =
            delete(
                workloadIdentityProviderId,
                WorkloadIdentityProviderDeleteParams.none(),
                requestOptions,
            )
    }
}
