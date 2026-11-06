// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.admin.organization.workloadidentityproviders

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRule
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleCreateParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleDeleteParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleDeleted
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleListPageAsync
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleListParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleRetrieveParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface FederationRuleServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FederationRuleServiceAsync

    /** Bind verified token attributes to an existing project service account. */
    fun create(
        workloadIdentityProviderId: String,
        params: FederationRuleCreateParams,
    ): CompletableFuture<FederationRule> =
        create(workloadIdentityProviderId, params, RequestOptions.none())

    /** @see create */
    fun create(
        workloadIdentityProviderId: String,
        params: FederationRuleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FederationRule> =
        create(
            params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
            requestOptions,
        )

    /** @see create */
    fun create(params: FederationRuleCreateParams): CompletableFuture<FederationRule> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: FederationRuleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FederationRule>

    /** Retrieve a federation rule owned by the authenticated organization and provider. */
    fun retrieve(
        workloadIdentityFederationRuleId: String,
        params: FederationRuleRetrieveParams,
    ): CompletableFuture<FederationRule> =
        retrieve(workloadIdentityFederationRuleId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        workloadIdentityFederationRuleId: String,
        params: FederationRuleRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FederationRule> =
        retrieve(
            params
                .toBuilder()
                .workloadIdentityFederationRuleId(workloadIdentityFederationRuleId)
                .build(),
            requestOptions,
        )

    /** @see retrieve */
    fun retrieve(params: FederationRuleRetrieveParams): CompletableFuture<FederationRule> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: FederationRuleRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FederationRule>

    /** Update supplied matcher, permission, metadata, or enabled fields. */
    fun update(
        workloadIdentityFederationRuleId: String,
        params: FederationRuleUpdateParams,
    ): CompletableFuture<FederationRule> =
        update(workloadIdentityFederationRuleId, params, RequestOptions.none())

    /** @see update */
    fun update(
        workloadIdentityFederationRuleId: String,
        params: FederationRuleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FederationRule> =
        update(
            params
                .toBuilder()
                .workloadIdentityFederationRuleId(workloadIdentityFederationRuleId)
                .build(),
            requestOptions,
        )

    /** @see update */
    fun update(params: FederationRuleUpdateParams): CompletableFuture<FederationRule> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: FederationRuleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FederationRule>

    /** List the provider's federation rules to project service accounts. */
    fun list(workloadIdentityProviderId: String): CompletableFuture<FederationRuleListPageAsync> =
        list(workloadIdentityProviderId, FederationRuleListParams.none())

    /** @see list */
    fun list(
        workloadIdentityProviderId: String,
        params: FederationRuleListParams = FederationRuleListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FederationRuleListPageAsync> =
        list(
            params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
            requestOptions,
        )

    /** @see list */
    fun list(
        workloadIdentityProviderId: String,
        params: FederationRuleListParams = FederationRuleListParams.none(),
    ): CompletableFuture<FederationRuleListPageAsync> =
        list(workloadIdentityProviderId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: FederationRuleListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FederationRuleListPageAsync>

    /** @see list */
    fun list(params: FederationRuleListParams): CompletableFuture<FederationRuleListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        workloadIdentityProviderId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<FederationRuleListPageAsync> =
        list(workloadIdentityProviderId, FederationRuleListParams.none(), requestOptions)

    /** Delete a federation rule to a project service account. */
    fun delete(
        workloadIdentityFederationRuleId: String,
        params: FederationRuleDeleteParams,
    ): CompletableFuture<FederationRuleDeleted> =
        delete(workloadIdentityFederationRuleId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        workloadIdentityFederationRuleId: String,
        params: FederationRuleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FederationRuleDeleted> =
        delete(
            params
                .toBuilder()
                .workloadIdentityFederationRuleId(workloadIdentityFederationRuleId)
                .build(),
            requestOptions,
        )

    /** @see delete */
    fun delete(params: FederationRuleDeleteParams): CompletableFuture<FederationRuleDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: FederationRuleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FederationRuleDeleted>

    /**
     * A view of [FederationRuleServiceAsync] that provides access to raw HTTP responses for each
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
        ): FederationRuleServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post
         * /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules`,
         * but is otherwise the same as [FederationRuleServiceAsync.create].
         */
        fun create(
            workloadIdentityProviderId: String,
            params: FederationRuleCreateParams,
        ): CompletableFuture<HttpResponseFor<FederationRule>> =
            create(workloadIdentityProviderId, params, RequestOptions.none())

        /** @see create */
        fun create(
            workloadIdentityProviderId: String,
            params: FederationRuleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FederationRule>> =
            create(
                params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
                requestOptions,
            )

        /** @see create */
        fun create(
            params: FederationRuleCreateParams
        ): CompletableFuture<HttpResponseFor<FederationRule>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: FederationRuleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FederationRule>>

        /**
         * Returns a raw HTTP response for `get
         * /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules/{workload_identity_federation_rule_id}`,
         * but is otherwise the same as [FederationRuleServiceAsync.retrieve].
         */
        fun retrieve(
            workloadIdentityFederationRuleId: String,
            params: FederationRuleRetrieveParams,
        ): CompletableFuture<HttpResponseFor<FederationRule>> =
            retrieve(workloadIdentityFederationRuleId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            workloadIdentityFederationRuleId: String,
            params: FederationRuleRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FederationRule>> =
            retrieve(
                params
                    .toBuilder()
                    .workloadIdentityFederationRuleId(workloadIdentityFederationRuleId)
                    .build(),
                requestOptions,
            )

        /** @see retrieve */
        fun retrieve(
            params: FederationRuleRetrieveParams
        ): CompletableFuture<HttpResponseFor<FederationRule>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: FederationRuleRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FederationRule>>

        /**
         * Returns a raw HTTP response for `post
         * /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules/{workload_identity_federation_rule_id}`,
         * but is otherwise the same as [FederationRuleServiceAsync.update].
         */
        fun update(
            workloadIdentityFederationRuleId: String,
            params: FederationRuleUpdateParams,
        ): CompletableFuture<HttpResponseFor<FederationRule>> =
            update(workloadIdentityFederationRuleId, params, RequestOptions.none())

        /** @see update */
        fun update(
            workloadIdentityFederationRuleId: String,
            params: FederationRuleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FederationRule>> =
            update(
                params
                    .toBuilder()
                    .workloadIdentityFederationRuleId(workloadIdentityFederationRuleId)
                    .build(),
                requestOptions,
            )

        /** @see update */
        fun update(
            params: FederationRuleUpdateParams
        ): CompletableFuture<HttpResponseFor<FederationRule>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: FederationRuleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FederationRule>>

        /**
         * Returns a raw HTTP response for `get
         * /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules`,
         * but is otherwise the same as [FederationRuleServiceAsync.list].
         */
        fun list(
            workloadIdentityProviderId: String
        ): CompletableFuture<HttpResponseFor<FederationRuleListPageAsync>> =
            list(workloadIdentityProviderId, FederationRuleListParams.none())

        /** @see list */
        fun list(
            workloadIdentityProviderId: String,
            params: FederationRuleListParams = FederationRuleListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FederationRuleListPageAsync>> =
            list(
                params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
                requestOptions,
            )

        /** @see list */
        fun list(
            workloadIdentityProviderId: String,
            params: FederationRuleListParams = FederationRuleListParams.none(),
        ): CompletableFuture<HttpResponseFor<FederationRuleListPageAsync>> =
            list(workloadIdentityProviderId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: FederationRuleListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FederationRuleListPageAsync>>

        /** @see list */
        fun list(
            params: FederationRuleListParams
        ): CompletableFuture<HttpResponseFor<FederationRuleListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            workloadIdentityProviderId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FederationRuleListPageAsync>> =
            list(workloadIdentityProviderId, FederationRuleListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules/{workload_identity_federation_rule_id}`,
         * but is otherwise the same as [FederationRuleServiceAsync.delete].
         */
        fun delete(
            workloadIdentityFederationRuleId: String,
            params: FederationRuleDeleteParams,
        ): CompletableFuture<HttpResponseFor<FederationRuleDeleted>> =
            delete(workloadIdentityFederationRuleId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            workloadIdentityFederationRuleId: String,
            params: FederationRuleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FederationRuleDeleted>> =
            delete(
                params
                    .toBuilder()
                    .workloadIdentityFederationRuleId(workloadIdentityFederationRuleId)
                    .build(),
                requestOptions,
            )

        /** @see delete */
        fun delete(
            params: FederationRuleDeleteParams
        ): CompletableFuture<HttpResponseFor<FederationRuleDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: FederationRuleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FederationRuleDeleted>>
    }
}
