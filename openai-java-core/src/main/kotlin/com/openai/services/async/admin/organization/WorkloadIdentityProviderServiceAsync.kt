// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.admin.organization

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProvider
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderCreateParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderDeleteParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderDeleted
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderListPageAsync
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderListParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderRetrieveParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderUpdateParams
import com.openai.services.async.admin.organization.workloadidentityproviders.FederationRuleServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface WorkloadIdentityProviderServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WorkloadIdentityProviderServiceAsync

    fun federationRules(): FederationRuleServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Register an OIDC provider for keyless project service-account authentication. */
    fun create(
        params: WorkloadIdentityProviderCreateParams
    ): CompletableFuture<WorkloadIdentityProvider> = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: WorkloadIdentityProviderCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WorkloadIdentityProvider>

    /** Retrieve an OIDC provider in the authenticated organization. */
    fun retrieve(workloadIdentityProviderId: String): CompletableFuture<WorkloadIdentityProvider> =
        retrieve(workloadIdentityProviderId, WorkloadIdentityProviderRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        workloadIdentityProviderId: String,
        params: WorkloadIdentityProviderRetrieveParams =
            WorkloadIdentityProviderRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WorkloadIdentityProvider> =
        retrieve(
            params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
            requestOptions,
        )

    /** @see retrieve */
    fun retrieve(
        workloadIdentityProviderId: String,
        params: WorkloadIdentityProviderRetrieveParams =
            WorkloadIdentityProviderRetrieveParams.none(),
    ): CompletableFuture<WorkloadIdentityProvider> =
        retrieve(workloadIdentityProviderId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: WorkloadIdentityProviderRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WorkloadIdentityProvider>

    /** @see retrieve */
    fun retrieve(
        params: WorkloadIdentityProviderRetrieveParams
    ): CompletableFuture<WorkloadIdentityProvider> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        workloadIdentityProviderId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<WorkloadIdentityProvider> =
        retrieve(
            workloadIdentityProviderId,
            WorkloadIdentityProviderRetrieveParams.none(),
            requestOptions,
        )

    /** Update supplied provider fields, preserving omitted fields. */
    fun update(workloadIdentityProviderId: String): CompletableFuture<WorkloadIdentityProvider> =
        update(workloadIdentityProviderId, WorkloadIdentityProviderUpdateParams.none())

    /** @see update */
    fun update(
        workloadIdentityProviderId: String,
        params: WorkloadIdentityProviderUpdateParams = WorkloadIdentityProviderUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WorkloadIdentityProvider> =
        update(
            params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
            requestOptions,
        )

    /** @see update */
    fun update(
        workloadIdentityProviderId: String,
        params: WorkloadIdentityProviderUpdateParams = WorkloadIdentityProviderUpdateParams.none(),
    ): CompletableFuture<WorkloadIdentityProvider> =
        update(workloadIdentityProviderId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: WorkloadIdentityProviderUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WorkloadIdentityProvider>

    /** @see update */
    fun update(
        params: WorkloadIdentityProviderUpdateParams
    ): CompletableFuture<WorkloadIdentityProvider> = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        workloadIdentityProviderId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<WorkloadIdentityProvider> =
        update(
            workloadIdentityProviderId,
            WorkloadIdentityProviderUpdateParams.none(),
            requestOptions,
        )

    /** List OIDC providers in the authenticated Admin API key's organization. */
    fun list(): CompletableFuture<WorkloadIdentityProviderListPageAsync> =
        list(WorkloadIdentityProviderListParams.none())

    /** @see list */
    fun list(
        params: WorkloadIdentityProviderListParams = WorkloadIdentityProviderListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WorkloadIdentityProviderListPageAsync>

    /** @see list */
    fun list(
        params: WorkloadIdentityProviderListParams = WorkloadIdentityProviderListParams.none()
    ): CompletableFuture<WorkloadIdentityProviderListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        requestOptions: RequestOptions
    ): CompletableFuture<WorkloadIdentityProviderListPageAsync> =
        list(WorkloadIdentityProviderListParams.none(), requestOptions)

    /** Delete a provider after deleting all its federation rules. */
    fun delete(
        workloadIdentityProviderId: String
    ): CompletableFuture<WorkloadIdentityProviderDeleted> =
        delete(workloadIdentityProviderId, WorkloadIdentityProviderDeleteParams.none())

    /** @see delete */
    fun delete(
        workloadIdentityProviderId: String,
        params: WorkloadIdentityProviderDeleteParams = WorkloadIdentityProviderDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WorkloadIdentityProviderDeleted> =
        delete(
            params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
            requestOptions,
        )

    /** @see delete */
    fun delete(
        workloadIdentityProviderId: String,
        params: WorkloadIdentityProviderDeleteParams = WorkloadIdentityProviderDeleteParams.none(),
    ): CompletableFuture<WorkloadIdentityProviderDeleted> =
        delete(workloadIdentityProviderId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: WorkloadIdentityProviderDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<WorkloadIdentityProviderDeleted>

    /** @see delete */
    fun delete(
        params: WorkloadIdentityProviderDeleteParams
    ): CompletableFuture<WorkloadIdentityProviderDeleted> = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        workloadIdentityProviderId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<WorkloadIdentityProviderDeleted> =
        delete(
            workloadIdentityProviderId,
            WorkloadIdentityProviderDeleteParams.none(),
            requestOptions,
        )

    /**
     * A view of [WorkloadIdentityProviderServiceAsync] that provides access to raw HTTP responses
     * for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WorkloadIdentityProviderServiceAsync.WithRawResponse

        fun federationRules(): FederationRuleServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /**
         * Returns a raw HTTP response for `post /organization/workload_identity_providers`, but is
         * otherwise the same as [WorkloadIdentityProviderServiceAsync.create].
         */
        fun create(
            params: WorkloadIdentityProviderCreateParams
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProvider>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: WorkloadIdentityProviderCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProvider>>

        /**
         * Returns a raw HTTP response for `get
         * /organization/workload_identity_providers/{workload_identity_provider_id}`, but is
         * otherwise the same as [WorkloadIdentityProviderServiceAsync.retrieve].
         */
        fun retrieve(
            workloadIdentityProviderId: String
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProvider>> =
            retrieve(workloadIdentityProviderId, WorkloadIdentityProviderRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            workloadIdentityProviderId: String,
            params: WorkloadIdentityProviderRetrieveParams =
                WorkloadIdentityProviderRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProvider>> =
            retrieve(
                params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
                requestOptions,
            )

        /** @see retrieve */
        fun retrieve(
            workloadIdentityProviderId: String,
            params: WorkloadIdentityProviderRetrieveParams =
                WorkloadIdentityProviderRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProvider>> =
            retrieve(workloadIdentityProviderId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: WorkloadIdentityProviderRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProvider>>

        /** @see retrieve */
        fun retrieve(
            params: WorkloadIdentityProviderRetrieveParams
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProvider>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            workloadIdentityProviderId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProvider>> =
            retrieve(
                workloadIdentityProviderId,
                WorkloadIdentityProviderRetrieveParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `post
         * /organization/workload_identity_providers/{workload_identity_provider_id}`, but is
         * otherwise the same as [WorkloadIdentityProviderServiceAsync.update].
         */
        fun update(
            workloadIdentityProviderId: String
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProvider>> =
            update(workloadIdentityProviderId, WorkloadIdentityProviderUpdateParams.none())

        /** @see update */
        fun update(
            workloadIdentityProviderId: String,
            params: WorkloadIdentityProviderUpdateParams =
                WorkloadIdentityProviderUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProvider>> =
            update(
                params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
                requestOptions,
            )

        /** @see update */
        fun update(
            workloadIdentityProviderId: String,
            params: WorkloadIdentityProviderUpdateParams =
                WorkloadIdentityProviderUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProvider>> =
            update(workloadIdentityProviderId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: WorkloadIdentityProviderUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProvider>>

        /** @see update */
        fun update(
            params: WorkloadIdentityProviderUpdateParams
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProvider>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            workloadIdentityProviderId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProvider>> =
            update(
                workloadIdentityProviderId,
                WorkloadIdentityProviderUpdateParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `get /organization/workload_identity_providers`, but is
         * otherwise the same as [WorkloadIdentityProviderServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<WorkloadIdentityProviderListPageAsync>> =
            list(WorkloadIdentityProviderListParams.none())

        /** @see list */
        fun list(
            params: WorkloadIdentityProviderListParams = WorkloadIdentityProviderListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProviderListPageAsync>>

        /** @see list */
        fun list(
            params: WorkloadIdentityProviderListParams = WorkloadIdentityProviderListParams.none()
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProviderListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProviderListPageAsync>> =
            list(WorkloadIdentityProviderListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /organization/workload_identity_providers/{workload_identity_provider_id}`, but is
         * otherwise the same as [WorkloadIdentityProviderServiceAsync.delete].
         */
        fun delete(
            workloadIdentityProviderId: String
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProviderDeleted>> =
            delete(workloadIdentityProviderId, WorkloadIdentityProviderDeleteParams.none())

        /** @see delete */
        fun delete(
            workloadIdentityProviderId: String,
            params: WorkloadIdentityProviderDeleteParams =
                WorkloadIdentityProviderDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProviderDeleted>> =
            delete(
                params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
                requestOptions,
            )

        /** @see delete */
        fun delete(
            workloadIdentityProviderId: String,
            params: WorkloadIdentityProviderDeleteParams =
                WorkloadIdentityProviderDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProviderDeleted>> =
            delete(workloadIdentityProviderId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: WorkloadIdentityProviderDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProviderDeleted>>

        /** @see delete */
        fun delete(
            params: WorkloadIdentityProviderDeleteParams
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProviderDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            workloadIdentityProviderId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProviderDeleted>> =
            delete(
                workloadIdentityProviderId,
                WorkloadIdentityProviderDeleteParams.none(),
                requestOptions,
            )
    }
}
