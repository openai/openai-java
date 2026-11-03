// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.admin.organization.workloadidentityproviders

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRule
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleCreateParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleDeleteParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleDeleted
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleListPage
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleListParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleRetrieveParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleUpdateParams
import java.util.function.Consumer

interface FederationRuleService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FederationRuleService

    /** Bind verified token attributes to an existing project service account. */
    fun create(
        workloadIdentityProviderId: String,
        params: FederationRuleCreateParams,
    ): FederationRule = create(workloadIdentityProviderId, params, RequestOptions.none())

    /** @see create */
    fun create(
        workloadIdentityProviderId: String,
        params: FederationRuleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FederationRule =
        create(
            params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
            requestOptions,
        )

    /** @see create */
    fun create(params: FederationRuleCreateParams): FederationRule =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: FederationRuleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FederationRule

    /** Retrieve a federation rule owned by the authenticated organization and provider. */
    fun retrieve(
        workloadIdentityFederationRuleId: String,
        params: FederationRuleRetrieveParams,
    ): FederationRule = retrieve(workloadIdentityFederationRuleId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        workloadIdentityFederationRuleId: String,
        params: FederationRuleRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FederationRule =
        retrieve(
            params
                .toBuilder()
                .workloadIdentityFederationRuleId(workloadIdentityFederationRuleId)
                .build(),
            requestOptions,
        )

    /** @see retrieve */
    fun retrieve(params: FederationRuleRetrieveParams): FederationRule =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: FederationRuleRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FederationRule

    /** Update supplied matcher, permission, metadata, or enabled fields. */
    fun update(
        workloadIdentityFederationRuleId: String,
        params: FederationRuleUpdateParams,
    ): FederationRule = update(workloadIdentityFederationRuleId, params, RequestOptions.none())

    /** @see update */
    fun update(
        workloadIdentityFederationRuleId: String,
        params: FederationRuleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FederationRule =
        update(
            params
                .toBuilder()
                .workloadIdentityFederationRuleId(workloadIdentityFederationRuleId)
                .build(),
            requestOptions,
        )

    /** @see update */
    fun update(params: FederationRuleUpdateParams): FederationRule =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: FederationRuleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FederationRule

    /** List the provider's federation rules to project service accounts. */
    fun list(workloadIdentityProviderId: String): FederationRuleListPage =
        list(workloadIdentityProviderId, FederationRuleListParams.none())

    /** @see list */
    fun list(
        workloadIdentityProviderId: String,
        params: FederationRuleListParams = FederationRuleListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FederationRuleListPage =
        list(
            params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
            requestOptions,
        )

    /** @see list */
    fun list(
        workloadIdentityProviderId: String,
        params: FederationRuleListParams = FederationRuleListParams.none(),
    ): FederationRuleListPage = list(workloadIdentityProviderId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: FederationRuleListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FederationRuleListPage

    /** @see list */
    fun list(params: FederationRuleListParams): FederationRuleListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        workloadIdentityProviderId: String,
        requestOptions: RequestOptions,
    ): FederationRuleListPage =
        list(workloadIdentityProviderId, FederationRuleListParams.none(), requestOptions)

    /** Delete a federation rule to a project service account. */
    fun delete(
        workloadIdentityFederationRuleId: String,
        params: FederationRuleDeleteParams,
    ): FederationRuleDeleted =
        delete(workloadIdentityFederationRuleId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        workloadIdentityFederationRuleId: String,
        params: FederationRuleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FederationRuleDeleted =
        delete(
            params
                .toBuilder()
                .workloadIdentityFederationRuleId(workloadIdentityFederationRuleId)
                .build(),
            requestOptions,
        )

    /** @see delete */
    fun delete(params: FederationRuleDeleteParams): FederationRuleDeleted =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: FederationRuleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FederationRuleDeleted

    /**
     * A view of [FederationRuleService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FederationRuleService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post
         * /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules`,
         * but is otherwise the same as [FederationRuleService.create].
         */
        @MustBeClosed
        fun create(
            workloadIdentityProviderId: String,
            params: FederationRuleCreateParams,
        ): HttpResponseFor<FederationRule> =
            create(workloadIdentityProviderId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            workloadIdentityProviderId: String,
            params: FederationRuleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FederationRule> =
            create(
                params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
                requestOptions,
            )

        /** @see create */
        @MustBeClosed
        fun create(params: FederationRuleCreateParams): HttpResponseFor<FederationRule> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: FederationRuleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FederationRule>

        /**
         * Returns a raw HTTP response for `get
         * /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules/{workload_identity_federation_rule_id}`,
         * but is otherwise the same as [FederationRuleService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            workloadIdentityFederationRuleId: String,
            params: FederationRuleRetrieveParams,
        ): HttpResponseFor<FederationRule> =
            retrieve(workloadIdentityFederationRuleId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            workloadIdentityFederationRuleId: String,
            params: FederationRuleRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FederationRule> =
            retrieve(
                params
                    .toBuilder()
                    .workloadIdentityFederationRuleId(workloadIdentityFederationRuleId)
                    .build(),
                requestOptions,
            )

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: FederationRuleRetrieveParams): HttpResponseFor<FederationRule> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: FederationRuleRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FederationRule>

        /**
         * Returns a raw HTTP response for `post
         * /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules/{workload_identity_federation_rule_id}`,
         * but is otherwise the same as [FederationRuleService.update].
         */
        @MustBeClosed
        fun update(
            workloadIdentityFederationRuleId: String,
            params: FederationRuleUpdateParams,
        ): HttpResponseFor<FederationRule> =
            update(workloadIdentityFederationRuleId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            workloadIdentityFederationRuleId: String,
            params: FederationRuleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FederationRule> =
            update(
                params
                    .toBuilder()
                    .workloadIdentityFederationRuleId(workloadIdentityFederationRuleId)
                    .build(),
                requestOptions,
            )

        /** @see update */
        @MustBeClosed
        fun update(params: FederationRuleUpdateParams): HttpResponseFor<FederationRule> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: FederationRuleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FederationRule>

        /**
         * Returns a raw HTTP response for `get
         * /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules`,
         * but is otherwise the same as [FederationRuleService.list].
         */
        @MustBeClosed
        fun list(workloadIdentityProviderId: String): HttpResponseFor<FederationRuleListPage> =
            list(workloadIdentityProviderId, FederationRuleListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            workloadIdentityProviderId: String,
            params: FederationRuleListParams = FederationRuleListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FederationRuleListPage> =
            list(
                params.toBuilder().workloadIdentityProviderId(workloadIdentityProviderId).build(),
                requestOptions,
            )

        /** @see list */
        @MustBeClosed
        fun list(
            workloadIdentityProviderId: String,
            params: FederationRuleListParams = FederationRuleListParams.none(),
        ): HttpResponseFor<FederationRuleListPage> =
            list(workloadIdentityProviderId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: FederationRuleListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FederationRuleListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: FederationRuleListParams): HttpResponseFor<FederationRuleListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            workloadIdentityProviderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FederationRuleListPage> =
            list(workloadIdentityProviderId, FederationRuleListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules/{workload_identity_federation_rule_id}`,
         * but is otherwise the same as [FederationRuleService.delete].
         */
        @MustBeClosed
        fun delete(
            workloadIdentityFederationRuleId: String,
            params: FederationRuleDeleteParams,
        ): HttpResponseFor<FederationRuleDeleted> =
            delete(workloadIdentityFederationRuleId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            workloadIdentityFederationRuleId: String,
            params: FederationRuleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FederationRuleDeleted> =
            delete(
                params
                    .toBuilder()
                    .workloadIdentityFederationRuleId(workloadIdentityFederationRuleId)
                    .build(),
                requestOptions,
            )

        /** @see delete */
        @MustBeClosed
        fun delete(params: FederationRuleDeleteParams): HttpResponseFor<FederationRuleDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: FederationRuleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FederationRuleDeleted>
    }
}
